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
    private long bOx = System.currentTimeMillis();
    private String bOy = f.getNetworkType();
    private JSONObject bOz;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject WO() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.bOx);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.bOy);
            if (this.bOz != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.bOz);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bPw) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b ak(JSONObject jSONObject) {
        this.bOz = jSONObject;
        return this;
    }

    public b iU(String str) {
        this.content = str;
        return this;
    }
}
