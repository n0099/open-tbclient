package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bvH;
    public String bvC = "";
    public String aXf = "";
    public String mUrl = "";
    public int bvF = 0;
    public boolean bvK = false;
    public boolean bvL = false;
    public boolean bvM = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bvC = jSONObject.optString("audioId", bVar.bvC);
            bVar2.aXf = jSONObject.optString("slaveId", bVar.aXf);
            bVar2.bvK = jSONObject.optBoolean("autoplay", bVar.bvK);
            bVar2.bvL = jSONObject.optBoolean("loop", bVar.bvL);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bvF = jSONObject.optInt("startTime", bVar.bvF);
            bVar2.bvM = jSONObject.optBoolean("obeyMuteSwitch", bVar.bvM);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bvH = jSONObject.optString("cb", bVar.bvH);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bvC);
    }

    public String toString() {
        return "playerId : " + this.bvC + "; slaveId : " + this.aXf + "; url : " + this.mUrl + "; AutoPlay : " + this.bvK + "; Loop : " + this.bvL + "; startTime : " + this.bvF + "; ObeyMute : " + this.bvM + "; pos : " + this.mPos;
    }
}
