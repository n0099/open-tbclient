package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAD;
    public String bAy = "";
    public String bch = "";
    public String mUrl = "";
    public int bAB = 0;
    public boolean bAG = false;
    public boolean mLoop = false;
    public boolean bAH = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bAy = jSONObject.optString("audioId", bVar.bAy);
            bVar2.bch = jSONObject.optString("slaveId", bVar.bch);
            bVar2.bAG = jSONObject.optBoolean("autoplay", bVar.bAG);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bAB = jSONObject.optInt("startTime", bVar.bAB);
            bVar2.bAH = jSONObject.optBoolean("obeyMuteSwitch", bVar.bAH);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bAD = jSONObject.optString("cb", bVar.bAD);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAy);
    }

    public String toString() {
        return "playerId : " + this.bAy + "; slaveId : " + this.bch + "; url : " + this.mUrl + "; AutoPlay : " + this.bAG + "; Loop : " + this.mLoop + "; startTime : " + this.bAB + "; ObeyMute : " + this.bAH + "; pos : " + this.mPos;
    }
}
