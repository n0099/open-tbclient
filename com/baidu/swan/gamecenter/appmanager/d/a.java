package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    String deQ;
    String dlQ;
    String dlS;
    String dlU;
    String dlX;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dlQ = "";
        this.dlS = "";
        this.dlU = "";
        this.mScheme = "";
        this.dlX = "";
        if (e.aDb() != null) {
            b.a aDe = e.aDb().aDe();
            this.mFrom = h.kd(aDe.getAppFrameType());
            this.mAppId = aDe.getAppId();
            this.mSource = aDe.auj();
            this.dlS = aDe.aup().getString("aiapp_extra_need_download", "");
            this.dlU = aDe.aup().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aDe.aul();
            this.dlX = aDe.getPage();
            this.deQ = aDe.auC();
            this.mAppVersion = aDe.getVersion();
            this.dlQ = aDe.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dlQ = "";
        this.dlS = "";
        this.dlU = "";
        this.mScheme = "";
        this.dlX = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dlS = jSONObject.optString("needDown");
            this.dlU = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dlX = jSONObject.optString("extPage");
            this.deQ = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dlQ = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dlS);
            jSONObject.put("isPreset", this.dlU);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dlX);
            jSONObject.put("launchId", this.deQ);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dlQ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
