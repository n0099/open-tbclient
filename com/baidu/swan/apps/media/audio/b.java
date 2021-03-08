package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String djZ;
    public String djT = "";
    public String cFI = "";
    public String mUrl = "";
    public int djX = 0;
    public boolean dkc = false;
    public boolean mLoop = false;
    public boolean dkd = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.djT = jSONObject.optString("audioId", bVar.djT);
            bVar2.cFI = jSONObject.optString("slaveId", bVar.cFI);
            bVar2.dkc = jSONObject.optBoolean("autoplay", bVar.dkc);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.djX = jSONObject.optInt("startTime", bVar.djX);
            bVar2.dkd = jSONObject.optBoolean("obeyMuteSwitch", bVar.dkd);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.djZ = jSONObject.optString("cb", bVar.djZ);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.djT);
    }

    public String toString() {
        return "playerId : " + this.djT + "; slaveId : " + this.cFI + "; url : " + this.mUrl + "; AutoPlay : " + this.dkc + "; Loop : " + this.mLoop + "; startTime : " + this.djX + "; ObeyMute : " + this.dkd + "; pos : " + this.mPos;
    }
}
