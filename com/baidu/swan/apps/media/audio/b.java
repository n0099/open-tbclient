package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cjG;
    public String cjA = "";
    public String bIH = "";
    public String mUrl = "";
    public int cjE = 0;
    public boolean cjJ = false;
    public boolean mLoop = false;
    public boolean cjK = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cjA = jSONObject.optString("audioId", bVar.cjA);
            bVar2.bIH = jSONObject.optString("slaveId", bVar.bIH);
            bVar2.cjJ = jSONObject.optBoolean("autoplay", bVar.cjJ);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.cjE = jSONObject.optInt("startTime", bVar.cjE);
            bVar2.cjK = jSONObject.optBoolean("obeyMuteSwitch", bVar.cjK);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cjG = jSONObject.optString("cb", bVar.cjG);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cjA);
    }

    public String toString() {
        return "playerId : " + this.cjA + "; slaveId : " + this.bIH + "; url : " + this.mUrl + "; AutoPlay : " + this.cjJ + "; Loop : " + this.mLoop + "; startTime : " + this.cjE + "; ObeyMute : " + this.cjK + "; pos : " + this.mPos;
    }
}
