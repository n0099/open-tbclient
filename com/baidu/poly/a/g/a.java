package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.e;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private long aME = System.currentTimeMillis();
    private String aMF = e.getNetworkType();
    private JSONObject aMG;
    private String action;
    private String content;

    public a(String str) {
        this.action = str;
    }

    public JSONObject Ci() {
        if (TextUtils.isEmpty(this.action)) {
            com.baidu.poly.util.c.j("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_VERSION_CODE, this.action);
            jSONObject.put("t", this.aME);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.aMF);
            if (this.aMG != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.aMG);
            } else if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.content);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.poly.util.c.aNC) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public a J(JSONObject jSONObject) {
        this.aMG = jSONObject;
        return this;
    }

    public a eA(String str) {
        this.content = str;
        return this;
    }
}
