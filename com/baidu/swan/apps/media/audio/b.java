package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String azC;
    public String azv = "";
    public String azw = "";
    public String mUrl = "";
    public int azA = 0;
    public boolean azF = false;
    public boolean mLoop = false;
    public boolean azG = true;
    public int mPos = 0;
    public float azH = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.azv = jSONObject.optString("audioId", bVar.azv);
            bVar2.azw = jSONObject.optString("slaveId", bVar.azw);
            bVar2.azF = jSONObject.optBoolean("autoplay", bVar.azF);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.azA = jSONObject.optInt("startTime", bVar.azA);
            bVar2.azG = jSONObject.optBoolean("obeyMuteSwitch", bVar.azG);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.azH = (float) jSONObject.optDouble("volume", bVar.azH);
            bVar2.azC = jSONObject.optString("cb", bVar.azC);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.azv);
    }

    public String toString() {
        return "playerId : " + this.azv + "; slaveId : " + this.azw + "; url : " + this.mUrl + "; AutoPlay : " + this.azF + "; Loop : " + this.mLoop + "; startTime : " + this.azA + "; ObeyMute : " + this.azG + "; pos : " + this.mPos;
    }
}
