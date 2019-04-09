package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String azD;
    public String azw = "";
    public String azx = "";
    public String mUrl = "";
    public int azB = 0;
    public boolean azG = false;
    public boolean mLoop = false;
    public boolean azH = true;
    public int mPos = 0;
    public float azI = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.azw = jSONObject.optString("audioId", bVar.azw);
            bVar2.azx = jSONObject.optString("slaveId", bVar.azx);
            bVar2.azG = jSONObject.optBoolean("autoplay", bVar.azG);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.azB = jSONObject.optInt("startTime", bVar.azB);
            bVar2.azH = jSONObject.optBoolean("obeyMuteSwitch", bVar.azH);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.azI = (float) jSONObject.optDouble("volume", bVar.azI);
            bVar2.azD = jSONObject.optString("cb", bVar.azD);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.azw);
    }

    public String toString() {
        return "playerId : " + this.azw + "; slaveId : " + this.azx + "; url : " + this.mUrl + "; AutoPlay : " + this.azG + "; Loop : " + this.mLoop + "; startTime : " + this.azB + "; ObeyMute : " + this.azH + "; pos : " + this.mPos;
    }
}
