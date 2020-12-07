package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dgg;
    public String dga = "";
    public String cBI = "";
    public String mUrl = "";
    public int dge = 0;
    public boolean dgj = false;
    public boolean mLoop = false;
    public boolean dgk = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.dga = jSONObject.optString("audioId", bVar.dga);
            bVar2.cBI = jSONObject.optString("slaveId", bVar.cBI);
            bVar2.dgj = jSONObject.optBoolean("autoplay", bVar.dgj);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.dge = jSONObject.optInt("startTime", bVar.dge);
            bVar2.dgk = jSONObject.optBoolean("obeyMuteSwitch", bVar.dgk);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.dgg = jSONObject.optString("cb", bVar.dgg);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.dga);
    }

    public String toString() {
        return "playerId : " + this.dga + "; slaveId : " + this.cBI + "; url : " + this.mUrl + "; AutoPlay : " + this.dgj + "; Loop : " + this.mLoop + "; startTime : " + this.dge + "; ObeyMute : " + this.dgk + "; pos : " + this.mPos;
    }
}
