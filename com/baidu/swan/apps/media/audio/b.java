package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBG;
    public String aBA = "";
    public String aBB = "";
    public String mUrl = "";
    public int aBE = 0;
    public boolean aBJ = false;
    public boolean mLoop = false;
    public boolean aBK = true;
    public int mPos = 0;
    public float aBL = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.aBA = jSONObject.optString("audioId", bVar.aBA);
            bVar2.aBB = jSONObject.optString("slaveId", bVar.aBB);
            bVar2.aBJ = jSONObject.optBoolean("autoplay", bVar.aBJ);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.aBE = jSONObject.optInt("startTime", bVar.aBE);
            bVar2.aBK = jSONObject.optBoolean("obeyMuteSwitch", bVar.aBK);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.aBL = (float) jSONObject.optDouble("volume", bVar.aBL);
            bVar2.aBG = jSONObject.optString("cb", bVar.aBG);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBA);
    }

    public String toString() {
        return "playerId : " + this.aBA + "; slaveId : " + this.aBB + "; url : " + this.mUrl + "; AutoPlay : " + this.aBJ + "; Loop : " + this.mLoop + "; startTime : " + this.aBE + "; ObeyMute : " + this.aBK + "; pos : " + this.mPos;
    }
}
