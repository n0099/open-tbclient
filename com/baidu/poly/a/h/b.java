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
    private long ccF = System.currentTimeMillis();
    private String ccG = f.getNetworkType();
    private JSONObject ccH;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject abh() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.ccF);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.ccG);
            if (this.ccH != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.ccH);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cdF) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b at(JSONObject jSONObject) {
        this.ccH = jSONObject;
        return this;
    }

    public b jA(String str) {
        this.content = str;
        return this;
    }
}
