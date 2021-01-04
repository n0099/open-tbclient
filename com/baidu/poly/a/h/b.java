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
    private JSONObject coA;
    private String content;
    private long coy = System.currentTimeMillis();
    private String coz = f.getNetworkType();

    public b(String str) {
        this.action = str;
    }

    public JSONObject afB() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.coy);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.coz);
            if (this.coA != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.coA);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cpz) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b ax(JSONObject jSONObject) {
        this.coA = jSONObject;
        return this;
    }

    public b jX(String str) {
        this.content = str;
        return this;
    }
}
