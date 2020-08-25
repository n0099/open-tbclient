package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cyq;
    public String cyk = "";
    public String bTJ = "";
    public String mUrl = "";
    public int cyo = 0;
    public boolean cyt = false;
    public boolean mLoop = false;
    public boolean cyu = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cyk = jSONObject.optString("audioId", bVar.cyk);
            bVar2.bTJ = jSONObject.optString("slaveId", bVar.bTJ);
            bVar2.cyt = jSONObject.optBoolean("autoplay", bVar.cyt);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.cyo = jSONObject.optInt("startTime", bVar.cyo);
            bVar2.cyu = jSONObject.optBoolean("obeyMuteSwitch", bVar.cyu);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cyq = jSONObject.optString("cb", bVar.cyq);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cyk);
    }

    public String toString() {
        return "playerId : " + this.cyk + "; slaveId : " + this.bTJ + "; url : " + this.mUrl + "; AutoPlay : " + this.cyt + "; Loop : " + this.mLoop + "; startTime : " + this.cyo + "; ObeyMute : " + this.cyu + "; pos : " + this.mPos;
    }
}
