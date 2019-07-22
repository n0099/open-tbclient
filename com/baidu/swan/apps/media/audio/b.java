package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBi;
    public String aBc = "";
    public String aBd = "";
    public String mUrl = "";
    public int aBg = 0;
    public boolean aBl = false;
    public boolean mLoop = false;
    public boolean aBm = true;
    public int mPos = 0;
    public float aBn = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.aBc = jSONObject.optString("audioId", bVar.aBc);
            bVar2.aBd = jSONObject.optString("slaveId", bVar.aBd);
            bVar2.aBl = jSONObject.optBoolean("autoplay", bVar.aBl);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.aBg = jSONObject.optInt("startTime", bVar.aBg);
            bVar2.aBm = jSONObject.optBoolean("obeyMuteSwitch", bVar.aBm);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.aBn = (float) jSONObject.optDouble("volume", bVar.aBn);
            bVar2.aBi = jSONObject.optString("cb", bVar.aBi);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBc);
    }

    public String toString() {
        return "playerId : " + this.aBc + "; slaveId : " + this.aBd + "; url : " + this.mUrl + "; AutoPlay : " + this.aBl + "; Loop : " + this.mLoop + "; startTime : " + this.aBg + "; ObeyMute : " + this.aBm + "; pos : " + this.mPos;
    }
}
