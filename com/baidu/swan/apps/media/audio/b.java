package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cov;
    public String cop = "";
    public String bNv = "";
    public String mUrl = "";
    public int cot = 0;
    public boolean coy = false;
    public boolean mLoop = false;
    public boolean coz = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cop = jSONObject.optString("audioId", bVar.cop);
            bVar2.bNv = jSONObject.optString("slaveId", bVar.bNv);
            bVar2.coy = jSONObject.optBoolean("autoplay", bVar.coy);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.cot = jSONObject.optInt("startTime", bVar.cot);
            bVar2.coz = jSONObject.optBoolean("obeyMuteSwitch", bVar.coz);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cov = jSONObject.optString("cb", bVar.cov);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cop);
    }

    public String toString() {
        return "playerId : " + this.cop + "; slaveId : " + this.bNv + "; url : " + this.mUrl + "; AutoPlay : " + this.coy + "; Loop : " + this.mLoop + "; startTime : " + this.cot + "; ObeyMute : " + this.coz + "; pos : " + this.mPos;
    }
}
