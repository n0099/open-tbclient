package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String action;
    private long bnA = System.currentTimeMillis();
    private String bnB = e.getNetworkType();
    private JSONObject bnC;
    private String content;

    public a(String str) {
        this.action = str;
    }

    public JSONObject KV() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.c.l("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.bnA);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.bnB);
            if (this.bnC != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.bnC);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.c.box) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public a P(JSONObject jSONObject) {
        this.bnC = jSONObject;
        return this;
    }

    public a fK(String str) {
        this.content = str;
        return this;
    }
}
