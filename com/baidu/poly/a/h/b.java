package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.f;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private String action;
    private long cjJ = System.currentTimeMillis();
    private String cjK = f.getNetworkType();
    private JSONObject cjL;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject abJ() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.cjJ);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.cjK);
            if (this.cjL != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.cjL);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.ckJ) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b ax(JSONObject jSONObject) {
        this.cjL = jSONObject;
        return this;
    }

    public b iM(String str) {
        this.content = str;
        return this;
    }
}
