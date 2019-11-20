package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUC;
    public String aUw = "";
    public String aUx = "";
    public String mUrl = "";
    public int aUA = 0;
    public boolean aUF = false;
    public boolean aUG = false;
    public boolean aUH = true;
    public int mPos = 0;
    public float aUI = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.aUw = jSONObject.optString("audioId", bVar.aUw);
            bVar2.aUx = jSONObject.optString("slaveId", bVar.aUx);
            bVar2.aUF = jSONObject.optBoolean("autoplay", bVar.aUF);
            bVar2.aUG = jSONObject.optBoolean("loop", bVar.aUG);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.aUA = jSONObject.optInt("startTime", bVar.aUA);
            bVar2.aUH = jSONObject.optBoolean("obeyMuteSwitch", bVar.aUH);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.aUI = (float) jSONObject.optDouble("volume", bVar.aUI);
            bVar2.aUC = jSONObject.optString("cb", bVar.aUC);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUw);
    }

    public String toString() {
        return "playerId : " + this.aUw + "; slaveId : " + this.aUx + "; url : " + this.mUrl + "; AutoPlay : " + this.aUF + "; Loop : " + this.aUG + "; startTime : " + this.aUA + "; ObeyMute : " + this.aUH + "; pos : " + this.mPos;
    }
}
