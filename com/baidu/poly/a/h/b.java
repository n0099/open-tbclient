package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.f;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private String action;
    private String content;
    private long cpC = System.currentTimeMillis();
    private String cpD = f.getNetworkType();
    private JSONObject cpE;

    public b(String str) {
        this.action = str;
    }

    public b aB(JSONObject jSONObject) {
        this.cpE = jSONObject;
        return this;
    }

    public JSONObject adA() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.a("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.action);
            jSONObject.put("t", this.cpC);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.cpD);
            if (this.cpE != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.cpE);
            } else if (!TextUtils.isEmpty(this.content)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.content));
                } catch (JSONException e) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cqC) {
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b jx(String str) {
        this.content = str;
        return this;
    }
}
