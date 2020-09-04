package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cyu;
    public String cyo = "";
    public String bTN = "";
    public String mUrl = "";
    public int cys = 0;
    public boolean cyx = false;
    public boolean mLoop = false;
    public boolean cyy = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cyo = jSONObject.optString("audioId", bVar.cyo);
            bVar2.bTN = jSONObject.optString("slaveId", bVar.bTN);
            bVar2.cyx = jSONObject.optBoolean("autoplay", bVar.cyx);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString("src", bVar.mUrl);
            bVar2.cys = jSONObject.optInt("startTime", bVar.cys);
            bVar2.cyy = jSONObject.optBoolean("obeyMuteSwitch", bVar.cyy);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cyu = jSONObject.optString("cb", bVar.cyu);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cyo);
    }

    public String toString() {
        return "playerId : " + this.cyo + "; slaveId : " + this.bTN + "; url : " + this.mUrl + "; AutoPlay : " + this.cyx + "; Loop : " + this.mLoop + "; startTime : " + this.cys + "; ObeyMute : " + this.cyy + "; pos : " + this.mPos;
    }
}
