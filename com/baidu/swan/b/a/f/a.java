package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String cAi;
    String cGB;
    String cGE;
    String cGx;
    String cGz;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cGx = "";
        this.cGz = "";
        this.cGB = "";
        this.mScheme = "";
        this.cGE = "";
        if (e.aoG() != null) {
            b.a aoJ = e.aoG().aoJ();
            this.mFrom = h.gU(aoJ.getAppFrameType());
            this.mAppId = aoJ.getAppId();
            this.mSource = aoJ.agK();
            this.cGz = aoJ.agQ().getString("aiapp_extra_need_download", "");
            this.cGB = aoJ.agQ().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aoJ.agM();
            this.cGE = aoJ.getPage();
            this.cAi = aoJ.ahd();
            this.mAppVersion = aoJ.getVersion();
            this.cGx = aoJ.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cGx = "";
        this.cGz = "";
        this.cGB = "";
        this.mScheme = "";
        this.cGE = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cGz = jSONObject.optString("needDown");
            this.cGB = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cGE = jSONObject.optString("extPage");
            this.cAi = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cGx = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cGz);
            jSONObject.put("isPreset", this.cGB);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cGE);
            jSONObject.put("launchId", this.cAi);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cGx);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
