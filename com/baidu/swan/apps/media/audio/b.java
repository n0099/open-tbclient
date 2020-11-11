package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String daQ;
    public String daK = "";
    public String cwA = "";
    public String mUrl = "";
    public int daO = 0;
    public boolean daT = false;
    public boolean mLoop = false;
    public boolean daU = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.daK = jSONObject.optString("audioId", bVar.daK);
            bVar2.cwA = jSONObject.optString("slaveId", bVar.cwA);
            bVar2.daT = jSONObject.optBoolean("autoplay", bVar.daT);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.daO = jSONObject.optInt("startTime", bVar.daO);
            bVar2.daU = jSONObject.optBoolean("obeyMuteSwitch", bVar.daU);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.daQ = jSONObject.optString("cb", bVar.daQ);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.daK);
    }

    public String toString() {
        return "playerId : " + this.daK + "; slaveId : " + this.cwA + "; url : " + this.mUrl + "; AutoPlay : " + this.daT + "; Loop : " + this.mLoop + "; startTime : " + this.daO + "; ObeyMute : " + this.daU + "; pos : " + this.mPos;
    }
}
