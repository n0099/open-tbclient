package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String cES;
    String cLh;
    String cLj;
    String cLl;
    String cLo;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cLh = "";
        this.cLj = "";
        this.cLl = "";
        this.mScheme = "";
        this.cLo = "";
        if (e.apN() != null) {
            b.a apQ = e.apN().apQ();
            this.mFrom = h.hf(apQ.getAppFrameType());
            this.mAppId = apQ.getAppId();
            this.mSource = apQ.ahQ();
            this.cLj = apQ.ahW().getString("aiapp_extra_need_download", "");
            this.cLl = apQ.ahW().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = apQ.ahS();
            this.cLo = apQ.getPage();
            this.cES = apQ.aij();
            this.mAppVersion = apQ.getVersion();
            this.cLh = apQ.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cLh = "";
        this.cLj = "";
        this.cLl = "";
        this.mScheme = "";
        this.cLo = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cLj = jSONObject.optString("needDown");
            this.cLl = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cLo = jSONObject.optString("extPage");
            this.cES = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cLh = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cLj);
            jSONObject.put("isPreset", this.cLl);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cLo);
            jSONObject.put("launchId", this.cES);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cLh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
