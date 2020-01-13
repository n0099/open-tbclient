package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bwu;
    public String bwp = "";
    public String aXX = "";
    public String mUrl = "";
    public int bws = 0;
    public boolean bwx = false;
    public boolean bwy = false;
    public boolean bwz = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.bwp = jSONObject.optString("audioId", bVar.bwp);
            bVar2.aXX = jSONObject.optString("slaveId", bVar.aXX);
            bVar2.bwx = jSONObject.optBoolean("autoplay", bVar.bwx);
            bVar2.bwy = jSONObject.optBoolean("loop", bVar.bwy);
            bVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.mUrl);
            bVar2.bws = jSONObject.optInt("startTime", bVar.bws);
            bVar2.bwz = jSONObject.optBoolean("obeyMuteSwitch", bVar.bwz);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.mVolume = (float) jSONObject.optDouble("volume", bVar.mVolume);
            bVar2.bwu = jSONObject.optString("cb", bVar.bwu);
        }
        return bVar2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bwp);
    }

    public String toString() {
        return "playerId : " + this.bwp + "; slaveId : " + this.aXX + "; url : " + this.mUrl + "; AutoPlay : " + this.bwx + "; Loop : " + this.bwy + "; startTime : " + this.bws + "; ObeyMute : " + this.bwz + "; pos : " + this.mPos;
    }
}
