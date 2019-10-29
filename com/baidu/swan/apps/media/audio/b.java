package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUU;
    public String aUO = "";
    public String aUP = "";
    public String mUrl = "";
    public int aUS = 0;
    public boolean aUX = false;
    public boolean aUY = false;
    public boolean aUZ = true;
    public int mPos = 0;
    public float aVa = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.aUO = jSONObject.optString("audioId", bVar.aUO);
            bVar2.aUP = jSONObject.optString("slaveId", bVar.aUP);
            bVar2.aUX = jSONObject.optBoolean("autoplay", bVar.aUX);
            bVar2.aUY = jSONObject.optBoolean("loop", bVar.aUY);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.aUS = jSONObject.optInt("startTime", bVar.aUS);
            bVar2.aUZ = jSONObject.optBoolean("obeyMuteSwitch", bVar.aUZ);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.aVa = (float) jSONObject.optDouble("volume", bVar.aVa);
            bVar2.aUU = jSONObject.optString("cb", bVar.aUU);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUO);
    }

    public String toString() {
        return "playerId : " + this.aUO + "; slaveId : " + this.aUP + "; url : " + this.mUrl + "; AutoPlay : " + this.aUX + "; Loop : " + this.aUY + "; startTime : " + this.aUS + "; ObeyMute : " + this.aUZ + "; pos : " + this.mPos;
    }
}
