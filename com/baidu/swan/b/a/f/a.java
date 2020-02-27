package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String bPs;
    String bVn;
    String bVp;
    String bVq;
    String bVt;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVn = "";
        this.bVp = "";
        this.bVq = "";
        this.mScheme = "";
        this.bVt = "";
        if (e.acE() != null) {
            b.a acG = e.acE().acG();
            this.mFrom = f.gs(acG.getAppFrameType());
            this.mAppId = acG.getAppId();
            this.mSource = acG.VH();
            this.bVp = acG.VN().getString("aiapp_extra_need_download", "");
            this.bVq = acG.VN().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = acG.VJ();
            this.bVt = acG.getPage();
            this.bPs = acG.Wa();
            this.mAppVersion = acG.getVersion();
            this.bVn = acG.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVn = "";
        this.bVp = "";
        this.bVq = "";
        this.mScheme = "";
        this.bVt = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.bVp = jSONObject.optString("needDown");
            this.bVq = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.bVt = jSONObject.optString("extPage");
            this.bPs = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.bVn = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.bVp);
            jSONObject.put("isPreset", this.bVq);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.bVt);
            jSONObject.put("launchId", this.bPs);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.bVn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
