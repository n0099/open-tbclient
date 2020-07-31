package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.f;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private String action;
    private long bAd = System.currentTimeMillis();
    private String bAe = f.getNetworkType();
    private JSONObject bAf;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject Oo() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.l("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.bAd);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.bAe);
            if (this.bAf != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.bAf);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bBe) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b ac(JSONObject jSONObject) {
        this.bAf = jSONObject;
        return this;
    }

    public b gE(String str) {
        this.content = str;
        return this;
    }
}
