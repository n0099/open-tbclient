package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bZd;
    public String bYY = "";
    public String bAP = "";
    public String mUrl = "";
    public int bZb = 0;
    public boolean bZg = false;
    public boolean mLoop = false;
    public boolean bZh = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bYY = jSONObject.optString("audioId", bVar.bYY);
            bVar2.bAP = jSONObject.optString("slaveId", bVar.bAP);
            bVar2.bZg = jSONObject.optBoolean("autoplay", bVar.bZg);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bZb = jSONObject.optInt("startTime", bVar.bZb);
            bVar2.bZh = jSONObject.optBoolean("obeyMuteSwitch", bVar.bZh);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bZd = jSONObject.optString("cb", bVar.bZd);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYY);
    }

    public String toString() {
        return "playerId : " + this.bYY + "; slaveId : " + this.bAP + "; url : " + this.mUrl + "; AutoPlay : " + this.bZg + "; Loop : " + this.mLoop + "; startTime : " + this.bZb + "; ObeyMute : " + this.bZh + "; pos : " + this.mPos;
    }
}
