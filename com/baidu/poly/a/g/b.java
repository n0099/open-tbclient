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
    private long buZ = System.currentTimeMillis();
    private String bva = f.getNetworkType();
    private JSONObject bvb;
    private String content;

    public b(String str) {
        this.action = str;
    }

    public JSONObject MX() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.d.l("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.buZ);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.bva);
            if (this.bvb != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.bvb);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.d.bvX) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public b U(JSONObject jSONObject) {
        this.bvb = jSONObject;
        return this;
    }

    public b gx(String str) {
        this.content = str;
        return this;
    }
}
