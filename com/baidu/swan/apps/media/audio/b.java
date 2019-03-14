package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String azz;
    public String azs = "";
    public String azt = "";
    public String mUrl = "";
    public int azx = 0;
    public boolean azC = false;
    public boolean mLoop = false;
    public boolean azD = true;
    public int mPos = 0;
    public float azE = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.azs = jSONObject.optString("audioId", bVar.azs);
            bVar2.azt = jSONObject.optString("slaveId", bVar.azt);
            bVar2.azC = jSONObject.optBoolean("autoplay", bVar.azC);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.azx = jSONObject.optInt("startTime", bVar.azx);
            bVar2.azD = jSONObject.optBoolean("obeyMuteSwitch", bVar.azD);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.azE = (float) jSONObject.optDouble("volume", bVar.azE);
            bVar2.azz = jSONObject.optString("cb", bVar.azz);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.azs);
    }

    public String toString() {
        return "playerId : " + this.azs + "; slaveId : " + this.azt + "; url : " + this.mUrl + "; AutoPlay : " + this.azC + "; Loop : " + this.mLoop + "; startTime : " + this.azx + "; ObeyMute : " + this.azD + "; pos : " + this.mPos;
    }
}
