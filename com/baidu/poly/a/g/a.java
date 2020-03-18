package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private long aRs = System.currentTimeMillis();
    private String aRt = e.getNetworkType();
    private JSONObject aRu;
    private String action;
    private String content;

    public a(String str) {
        this.action = str;
    }

    public JSONObject EL() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.c.j("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.aRs);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.aRt);
            if (this.aRu != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.aRu);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.c.aSq) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public a J(JSONObject jSONObject) {
        this.aRu = jSONObject;
        return this;
    }

    public a eP(String str) {
        this.content = str;
        return this;
    }
}
