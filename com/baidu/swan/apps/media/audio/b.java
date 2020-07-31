package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cqA;
    public String cqu = "";
    public String bOl = "";
    public String mUrl = "";
    public int cqy = 0;
    public boolean cqD = false;
    public boolean mLoop = false;
    public boolean cqE = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.cqu = jSONObject.optString("audioId", bVar.cqu);
            bVar2.bOl = jSONObject.optString("slaveId", bVar.bOl);
            bVar2.cqD = jSONObject.optBoolean("autoplay", bVar.cqD);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.cqy = jSONObject.optInt("startTime", bVar.cqy);
            bVar2.cqE = jSONObject.optBoolean("obeyMuteSwitch", bVar.cqE);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.cqA = jSONObject.optString("cb", bVar.cqA);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cqu);
    }

    public String toString() {
        return "playerId : " + this.cqu + "; slaveId : " + this.bOl + "; url : " + this.mUrl + "; AutoPlay : " + this.cqD + "; Loop : " + this.mLoop + "; startTime : " + this.cqy + "; ObeyMute : " + this.cqE + "; pos : " + this.mPos;
    }
}
