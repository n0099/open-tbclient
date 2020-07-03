package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.f;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private String action;
    private JSONObject bzS;
    private String content;
    private long ed = System.currentTimeMillis();
    private String bzR = f.getNetworkType();

    public b(String str) {
        this.action = str;
    }

    public JSONObject Og() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.l("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.ed);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.bzR);
            if (this.bzS != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.bzS);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.d.bAO) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b ab(JSONObject jSONObject) {
        this.bzS = jSONObject;
        return this;
    }

    public b gF(String str) {
        this.content = str;
        return this;
    }
}
