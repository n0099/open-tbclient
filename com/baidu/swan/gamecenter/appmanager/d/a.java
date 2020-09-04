package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    String cQI;
    String cXG;
    String cXI;
    String cXK;
    String cXN;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cXG = "";
        this.cXI = "";
        this.cXK = "";
        this.mScheme = "";
        this.cXN = "";
        if (e.azJ() != null) {
            b.a azM = e.azJ().azM();
            this.mFrom = h.jv(azM.getAppFrameType());
            this.mAppId = azM.getAppId();
            this.mSource = azM.aqN();
            this.cXI = azM.aqT().getString("aiapp_extra_need_download", "");
            this.cXK = azM.aqT().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = azM.aqP();
            this.cXN = azM.getPage();
            this.cQI = azM.arg();
            this.mAppVersion = azM.getVersion();
            this.cXG = azM.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cXG = "";
        this.cXI = "";
        this.cXK = "";
        this.mScheme = "";
        this.cXN = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cXI = jSONObject.optString("needDown");
            this.cXK = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cXN = jSONObject.optString("extPage");
            this.cQI = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cXG = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cXI);
            jSONObject.put("isPreset", this.cXK);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cXN);
            jSONObject.put("launchId", this.cQI);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cXG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
