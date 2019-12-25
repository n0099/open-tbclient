package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private long aLM = System.currentTimeMillis();
    private String aLN = e.getNetworkType();
    private JSONObject aLO;
    private String action;
    private String content;

    public a(String str) {
        this.action = str;
    }

    public JSONObject BM() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.c.j("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.aLM);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.aLN);
            if (this.aLO != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.aLO);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.c.aMK) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public a J(JSONObject jSONObject) {
        this.aLO = jSONObject;
        return this;
    }

    public a ex(String str) {
        this.content = str;
        return this;
    }
}
