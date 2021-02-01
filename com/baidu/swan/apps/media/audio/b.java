package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String diy;
    public String diq = "";
    public String cEi = "";
    public String mUrl = "";
    public int diw = 0;
    public boolean diB = false;
    public boolean mLoop = false;
    public boolean diC = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.diq = jSONObject.optString("audioId", bVar.diq);
            bVar2.cEi = jSONObject.optString("slaveId", bVar.cEi);
            bVar2.diB = jSONObject.optBoolean("autoplay", bVar.diB);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.diw = jSONObject.optInt("startTime", bVar.diw);
            bVar2.diC = jSONObject.optBoolean("obeyMuteSwitch", bVar.diC);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.diy = jSONObject.optString("cb", bVar.diy);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.diq);
    }

    public String toString() {
        return "playerId : " + this.diq + "; slaveId : " + this.cEi + "; url : " + this.mUrl + "; AutoPlay : " + this.diB + "; Loop : " + this.mLoop + "; startTime : " + this.diw + "; ObeyMute : " + this.diC + "; pos : " + this.mPos;
    }
}
