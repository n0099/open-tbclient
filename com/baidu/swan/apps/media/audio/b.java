package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cUW;
    public String cUQ = "";
    public String cqC = "";
    public String mUrl = "";
    public int cUU = 0;
    public boolean cUZ = false;
    public boolean mLoop = false;
    public boolean cVa = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cUQ = jSONObject.optString("audioId", bVar.cUQ);
            bVar2.cqC = jSONObject.optString("slaveId", bVar.cqC);
            bVar2.cUZ = jSONObject.optBoolean("autoplay", bVar.cUZ);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.cUU = jSONObject.optInt("startTime", bVar.cUU);
            bVar2.cVa = jSONObject.optBoolean("obeyMuteSwitch", bVar.cVa);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cUW = jSONObject.optString("cb", bVar.cUW);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cUQ);
    }

    public String toString() {
        return "playerId : " + this.cUQ + "; slaveId : " + this.cqC + "; url : " + this.mUrl + "; AutoPlay : " + this.cUZ + "; Loop : " + this.mLoop + "; startTime : " + this.cUU + "; ObeyMute : " + this.cVa + "; pos : " + this.mPos;
    }
}
