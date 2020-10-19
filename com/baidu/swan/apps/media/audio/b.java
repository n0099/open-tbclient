package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cMA;
    public String cMu = "";
    public String cib = "";
    public String mUrl = "";
    public int cMy = 0;
    public boolean cMD = false;
    public boolean mLoop = false;
    public boolean cME = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cMu = jSONObject.optString("audioId", bVar.cMu);
            bVar2.cib = jSONObject.optString("slaveId", bVar.cib);
            bVar2.cMD = jSONObject.optBoolean("autoplay", bVar.cMD);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.cMy = jSONObject.optInt("startTime", bVar.cMy);
            bVar2.cME = jSONObject.optBoolean("obeyMuteSwitch", bVar.cME);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cMA = jSONObject.optString("cb", bVar.cMA);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cMu);
    }

    public String toString() {
        return "playerId : " + this.cMu + "; slaveId : " + this.cib + "; url : " + this.mUrl + "; AutoPlay : " + this.cMD + "; Loop : " + this.mLoop + "; startTime : " + this.cMy + "; ObeyMute : " + this.cME + "; pos : " + this.mPos;
    }
}
