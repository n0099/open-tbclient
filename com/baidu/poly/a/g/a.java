package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private long aRd = System.currentTimeMillis();
    private String aRe = e.getNetworkType();
    private JSONObject aRf;
    private String action;
    private String content;

    public a(String str) {
        this.action = str;
    }

    public JSONObject EE() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.c.j("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.aRd);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.aRe);
            if (this.aRf != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.aRf);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.c.aSb) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public a J(JSONObject jSONObject) {
        this.aRf = jSONObject;
        return this;
    }

    public a eQ(String str) {
        this.content = str;
        return this;
    }
}
