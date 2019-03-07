package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public String azy;
    public String azr = "";
    public String azs = "";
    public String mUrl = "";
    public int azw = 0;
    public boolean azB = false;
    public boolean mLoop = false;
    public boolean azC = true;
    public int mPos = 0;
    public float azD = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.azr = jSONObject.optString("audioId", bVar.azr);
            bVar2.azs = jSONObject.optString("slaveId", bVar.azs);
            bVar2.azB = jSONObject.optBoolean("autoplay", bVar.azB);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.azw = jSONObject.optInt("startTime", bVar.azw);
            bVar2.azC = jSONObject.optBoolean("obeyMuteSwitch", bVar.azC);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.azD = (float) jSONObject.optDouble("volume", bVar.azD);
            bVar2.azy = jSONObject.optString("cb", bVar.azy);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.azr);
    }

    public String toString() {
        return "playerId : " + this.azr + "; slaveId : " + this.azs + "; url : " + this.mUrl + "; AutoPlay : " + this.azB + "; Loop : " + this.mLoop + "; startTime : " + this.azw + "; ObeyMute : " + this.azC + "; pos : " + this.mPos;
    }
}
