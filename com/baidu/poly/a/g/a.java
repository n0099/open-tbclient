package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private long aRf = System.currentTimeMillis();
    private String aRg = e.getNetworkType();
    private JSONObject aRh;
    private String action;
    private String content;

    public a(String str) {
        this.action = str;
    }

    public JSONObject EG() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.c.j("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.aRf);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.aRg);
            if (this.aRh != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.aRh);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.c.aSd) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public a J(JSONObject jSONObject) {
        this.aRh = jSONObject;
        return this;
    }

    public a eQ(String str) {
        this.content = str;
        return this;
    }
}
