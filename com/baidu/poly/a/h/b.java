package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.f;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String action;
    private long cnZ = System.currentTimeMillis();
    private String coa = f.getNetworkType();
    private JSONObject cob;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject adx() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.cnZ);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.coa);
            if (this.cob != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.cob);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cpa) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b az(JSONObject jSONObject) {
        this.cob = jSONObject;
        return this;
    }

    public b jr(String str) {
        this.content = str;
        return this;
    }
}
