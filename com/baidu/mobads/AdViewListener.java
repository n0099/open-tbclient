package com.baidu.mobads;

import org.json.JSONObject;
/* loaded from: classes20.dex */
public interface AdViewListener {
    void onAdClick(JSONObject jSONObject);

    void onAdClose(JSONObject jSONObject);

    void onAdFailed(String str);

    void onAdReady(AdView adView);

    void onAdShow(JSONObject jSONObject);

    void onAdSwitch();
}
