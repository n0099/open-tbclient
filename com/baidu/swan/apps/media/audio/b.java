package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cAv;
    public String cAp = "";
    public String bVN = "";
    public String mUrl = "";
    public int cAt = 0;
    public boolean cAy = false;
    public boolean mLoop = false;
    public boolean cAz = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cAp = jSONObject.optString("audioId", bVar.cAp);
            bVar2.bVN = jSONObject.optString("slaveId", bVar.bVN);
            bVar2.cAy = jSONObject.optBoolean("autoplay", bVar.cAy);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.cAt = jSONObject.optInt("startTime", bVar.cAt);
            bVar2.cAz = jSONObject.optBoolean("obeyMuteSwitch", bVar.cAz);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cAv = jSONObject.optString("cb", bVar.cAv);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cAp);
    }

    public String toString() {
        return "playerId : " + this.cAp + "; slaveId : " + this.bVN + "; url : " + this.mUrl + "; AutoPlay : " + this.cAy + "; Loop : " + this.mLoop + "; startTime : " + this.cAt + "; ObeyMute : " + this.cAz + "; pos : " + this.mPos;
    }
}
