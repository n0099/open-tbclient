package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cZg;
    public String cZa = "";
    public String cuQ = "";
    public String mUrl = "";
    public int cZe = 0;
    public boolean cZj = false;
    public boolean mLoop = false;
    public boolean cZk = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cZa = jSONObject.optString("audioId", bVar.cZa);
            bVar2.cuQ = jSONObject.optString("slaveId", bVar.cuQ);
            bVar2.cZj = jSONObject.optBoolean("autoplay", bVar.cZj);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.cZe = jSONObject.optInt("startTime", bVar.cZe);
            bVar2.cZk = jSONObject.optBoolean("obeyMuteSwitch", bVar.cZk);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cZg = jSONObject.optString("cb", bVar.cZg);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cZa);
    }

    public String toString() {
        return "playerId : " + this.cZa + "; slaveId : " + this.cuQ + "; url : " + this.mUrl + "; AutoPlay : " + this.cZj + "; Loop : " + this.mLoop + "; startTime : " + this.cZe + "; ObeyMute : " + this.cZk + "; pos : " + this.mPos;
    }
}
