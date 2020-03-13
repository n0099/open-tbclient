package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAF;
    public String bAA = "";
    public String bcj = "";
    public String mUrl = "";
    public int bAD = 0;
    public boolean bAI = false;
    public boolean mLoop = false;
    public boolean bAJ = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bAA = jSONObject.optString("audioId", bVar.bAA);
            bVar2.bcj = jSONObject.optString("slaveId", bVar.bcj);
            bVar2.bAI = jSONObject.optBoolean("autoplay", bVar.bAI);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bAD = jSONObject.optInt("startTime", bVar.bAD);
            bVar2.bAJ = jSONObject.optBoolean("obeyMuteSwitch", bVar.bAJ);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bAF = jSONObject.optString("cb", bVar.bAF);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAA);
    }

    public String toString() {
        return "playerId : " + this.bAA + "; slaveId : " + this.bcj + "; url : " + this.mUrl + "; AutoPlay : " + this.bAI + "; Loop : " + this.mLoop + "; startTime : " + this.bAD + "; ObeyMute : " + this.bAJ + "; pos : " + this.mPos;
    }
}
