package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {
    String dFC;
    String dFE;
    String dFG;
    String dFJ;
    String dyF;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dFC = "";
        this.dFE = "";
        this.dFG = "";
        this.mScheme = "";
        this.dFJ = "";
        if (e.aJV() != null) {
            b.a aJY = e.aJV().aJY();
            this.mFrom = h.kS(aJY.getAppFrameType());
            this.mAppId = aJY.getAppId();
            this.mSource = aJY.aBe();
            this.dFE = aJY.aBk().getString("aiapp_extra_need_download", "");
            this.dFG = aJY.aBk().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aJY.aBg();
            this.dFJ = aJY.getPage();
            this.dyF = aJY.aBx();
            this.mAppVersion = aJY.getVersion();
            this.dFC = aJY.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dFC = "";
        this.dFE = "";
        this.dFG = "";
        this.mScheme = "";
        this.dFJ = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dFE = jSONObject.optString("needDown");
            this.dFG = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dFJ = jSONObject.optString("extPage");
            this.dyF = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dFC = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dFE);
            jSONObject.put("isPreset", this.dFG);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dFJ);
            jSONObject.put("launchId", this.dyF);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dFC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
