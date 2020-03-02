package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAE;
    public String bAz = "";
    public String bci = "";
    public String mUrl = "";
    public int bAC = 0;
    public boolean bAH = false;
    public boolean mLoop = false;
    public boolean bAI = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bAz = jSONObject.optString("audioId", bVar.bAz);
            bVar2.bci = jSONObject.optString("slaveId", bVar.bci);
            bVar2.bAH = jSONObject.optBoolean("autoplay", bVar.bAH);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bAC = jSONObject.optInt("startTime", bVar.bAC);
            bVar2.bAI = jSONObject.optBoolean("obeyMuteSwitch", bVar.bAI);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bAE = jSONObject.optString("cb", bVar.bAE);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAz);
    }

    public String toString() {
        return "playerId : " + this.bAz + "; slaveId : " + this.bci + "; url : " + this.mUrl + "; AutoPlay : " + this.bAH + "; Loop : " + this.mLoop + "; startTime : " + this.bAC + "; ObeyMute : " + this.bAI + "; pos : " + this.mPos;
    }
}
