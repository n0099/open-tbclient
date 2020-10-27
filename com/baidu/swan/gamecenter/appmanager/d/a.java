package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    String dnp;
    String dus;
    String duu;
    String duw;
    String duz;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dus = "";
        this.duu = "";
        this.duw = "";
        this.mScheme = "";
        this.duz = "";
        if (e.aEV() != null) {
            b.a aEY = e.aEV().aEY();
            this.mFrom = h.ko(aEY.getAppFrameType());
            this.mAppId = aEY.getAppId();
            this.mSource = aEY.awd();
            this.duu = aEY.awj().getString("aiapp_extra_need_download", "");
            this.duw = aEY.awj().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aEY.awf();
            this.duz = aEY.getPage();
            this.dnp = aEY.aww();
            this.mAppVersion = aEY.getVersion();
            this.dus = aEY.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dus = "";
        this.duu = "";
        this.duw = "";
        this.mScheme = "";
        this.duz = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.duu = jSONObject.optString("needDown");
            this.duw = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.duz = jSONObject.optString("extPage");
            this.dnp = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dus = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.duu);
            jSONObject.put("isPreset", this.duw);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.duz);
            jSONObject.put("launchId", this.dnp);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dus);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
