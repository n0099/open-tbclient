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
    private long bFJ = System.currentTimeMillis();
    private String bFK = f.getNetworkType();
    private JSONObject bFL;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject Ui() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.bFJ);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.bFK);
            if (this.bFL != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.bFL);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bGI) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b ae(JSONObject jSONObject) {
        this.bFL = jSONObject;
        return this;
    }

    public b hY(String str) {
        this.content = str;
        return this;
    }
}
