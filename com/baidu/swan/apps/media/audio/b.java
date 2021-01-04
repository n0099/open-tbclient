package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dkZ;
    public String dkT = "";
    public String cGy = "";
    public String mUrl = "";
    public int dkX = 0;
    public boolean dlc = false;
    public boolean mLoop = false;
    public boolean dld = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.dkT = jSONObject.optString("audioId", bVar.dkT);
            bVar2.cGy = jSONObject.optString("slaveId", bVar.cGy);
            bVar2.dlc = jSONObject.optBoolean("autoplay", bVar.dlc);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.dkX = jSONObject.optInt("startTime", bVar.dkX);
            bVar2.dld = jSONObject.optBoolean("obeyMuteSwitch", bVar.dld);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.dkZ = jSONObject.optString("cb", bVar.dkZ);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.dkT);
    }

    public String toString() {
        return "playerId : " + this.dkT + "; slaveId : " + this.cGy + "; url : " + this.mUrl + "; AutoPlay : " + this.dlc + "; Loop : " + this.mLoop + "; startTime : " + this.dkX + "; ObeyMute : " + this.dld + "; pos : " + this.mPos;
    }
}
