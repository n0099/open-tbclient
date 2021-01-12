package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dgk;
    public String dge = "";
    public String cBM = "";
    public String mUrl = "";
    public int dgi = 0;
    public boolean dgn = false;
    public boolean mLoop = false;
    public boolean dgo = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.dge = jSONObject.optString("audioId", bVar.dge);
            bVar2.cBM = jSONObject.optString("slaveId", bVar.cBM);
            bVar2.dgn = jSONObject.optBoolean("autoplay", bVar.dgn);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.dgi = jSONObject.optInt("startTime", bVar.dgi);
            bVar2.dgo = jSONObject.optBoolean("obeyMuteSwitch", bVar.dgo);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.dgk = jSONObject.optString("cb", bVar.dgk);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.dge);
    }

    public String toString() {
        return "playerId : " + this.dge + "; slaveId : " + this.cBM + "; url : " + this.mUrl + "; AutoPlay : " + this.dgn + "; Loop : " + this.mLoop + "; startTime : " + this.dgi + "; ObeyMute : " + this.dgo + "; pos : " + this.mPos;
    }
}
