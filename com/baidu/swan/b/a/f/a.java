package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    String bLn;
    String bRi;
    String bRk;
    String bRl;
    String bRo;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bRi = "";
        this.bRk = "";
        this.bRl = "";
        this.mScheme = "";
        this.bRo = "";
        if (e.aaq() != null) {
            b.a aas = e.aaq().aas();
            this.mFrom = f.gb(aas.getAppFrameType());
            this.mAppId = aas.getAppId();
            this.mSource = aas.Tt();
            this.bRk = aas.Tz().getString("aiapp_extra_need_download", "");
            this.bRl = aas.Tz().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aas.Tv();
            this.bRo = aas.getPage();
            this.bLn = aas.TM();
            this.mAppVersion = aas.getVersion();
            this.bRi = aas.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bRi = "";
        this.bRk = "";
        this.bRl = "";
        this.mScheme = "";
        this.bRo = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.bRk = jSONObject.optString("needDown");
            this.bRl = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.bRo = jSONObject.optString("extPage");
            this.bLn = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.bRi = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.bRk);
            jSONObject.put("isPreset", this.bRl);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.bRo);
            jSONObject.put("launchId", this.bLn);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.bRi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
