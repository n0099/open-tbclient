package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    String cQE;
    String cXC;
    String cXE;
    String cXG;
    String cXJ;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cXC = "";
        this.cXE = "";
        this.cXG = "";
        this.mScheme = "";
        this.cXJ = "";
        if (e.azJ() != null) {
            b.a azM = e.azJ().azM();
            this.mFrom = h.jv(azM.getAppFrameType());
            this.mAppId = azM.getAppId();
            this.mSource = azM.aqN();
            this.cXE = azM.aqT().getString("aiapp_extra_need_download", "");
            this.cXG = azM.aqT().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = azM.aqP();
            this.cXJ = azM.getPage();
            this.cQE = azM.arg();
            this.mAppVersion = azM.getVersion();
            this.cXC = azM.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cXC = "";
        this.cXE = "";
        this.cXG = "";
        this.mScheme = "";
        this.cXJ = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cXE = jSONObject.optString("needDown");
            this.cXG = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cXJ = jSONObject.optString("extPage");
            this.cQE = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cXC = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cXE);
            jSONObject.put("isPreset", this.cXG);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cXJ);
            jSONObject.put("launchId", this.cQE);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cXC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
