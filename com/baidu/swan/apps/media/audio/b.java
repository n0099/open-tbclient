package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAQ;
    public String bAL = "";
    public String bcw = "";
    public String mUrl = "";
    public int bAO = 0;
    public boolean bAT = false;
    public boolean mLoop = false;
    public boolean bAU = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bAL = jSONObject.optString("audioId", bVar.bAL);
            bVar2.bcw = jSONObject.optString("slaveId", bVar.bcw);
            bVar2.bAT = jSONObject.optBoolean("autoplay", bVar.bAT);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bAO = jSONObject.optInt("startTime", bVar.bAO);
            bVar2.bAU = jSONObject.optBoolean("obeyMuteSwitch", bVar.bAU);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bAQ = jSONObject.optString("cb", bVar.bAQ);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAL);
    }

    public String toString() {
        return "playerId : " + this.bAL + "; slaveId : " + this.bcw + "; url : " + this.mUrl + "; AutoPlay : " + this.bAT + "; Loop : " + this.mLoop + "; startTime : " + this.bAO + "; ObeyMute : " + this.bAU + "; pos : " + this.mPos;
    }
}
