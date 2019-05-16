package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aAA;
    public String aAu = "";
    public String aAv = "";
    public String mUrl = "";
    public int aAy = 0;
    public boolean aAD = false;
    public boolean mLoop = false;
    public boolean aAE = true;
    public int mPos = 0;
    public float aAF = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.aAu = jSONObject.optString("audioId", bVar.aAu);
            bVar2.aAv = jSONObject.optString("slaveId", bVar.aAv);
            bVar2.aAD = jSONObject.optBoolean("autoplay", bVar.aAD);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.aAy = jSONObject.optInt("startTime", bVar.aAy);
            bVar2.aAE = jSONObject.optBoolean("obeyMuteSwitch", bVar.aAE);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.aAF = (float) jSONObject.optDouble("volume", bVar.aAF);
            bVar2.aAA = jSONObject.optString("cb", bVar.aAA);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aAu);
    }

    public String toString() {
        return "playerId : " + this.aAu + "; slaveId : " + this.aAv + "; url : " + this.mUrl + "; AutoPlay : " + this.aAD + "; Loop : " + this.mLoop + "; startTime : " + this.aAy + "; ObeyMute : " + this.aAE + "; pos : " + this.mPos;
    }
}
