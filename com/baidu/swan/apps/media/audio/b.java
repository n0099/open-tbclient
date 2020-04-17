package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYX;
    public String bYS = "";
    public String bAK = "";
    public String mUrl = "";
    public int bYV = 0;
    public boolean bZa = false;
    public boolean mLoop = false;
    public boolean bZb = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bYS = jSONObject.optString("audioId", bVar.bYS);
            bVar2.bAK = jSONObject.optString("slaveId", bVar.bAK);
            bVar2.bZa = jSONObject.optBoolean("autoplay", bVar.bZa);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bYV = jSONObject.optInt("startTime", bVar.bYV);
            bVar2.bZb = jSONObject.optBoolean("obeyMuteSwitch", bVar.bZb);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bYX = jSONObject.optString("cb", bVar.bYX);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYS);
    }

    public String toString() {
        return "playerId : " + this.bYS + "; slaveId : " + this.bAK + "; url : " + this.mUrl + "; AutoPlay : " + this.bZa + "; Loop : " + this.mLoop + "; startTime : " + this.bYV + "; ObeyMute : " + this.bZb + "; pos : " + this.mPos;
    }
}
