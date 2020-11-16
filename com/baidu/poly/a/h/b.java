package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.f;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private String action;
    private long caT = System.currentTimeMillis();
    private String caU = f.getNetworkType();
    private JSONObject caV;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject aay() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.caT);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.caU);
            if (this.caV != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.caV);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cbS) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b an(JSONObject jSONObject) {
        this.caV = jSONObject;
        return this;
    }

    public b ju(String str) {
        this.content = str;
        return this;
    }
}
