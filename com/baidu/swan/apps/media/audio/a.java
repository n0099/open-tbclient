package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String dkZ;
    public boolean dlb;
    public String mReferer;
    public String mUserAgent;
    public String dkT = "";
    public String cGy = "";
    public String mUrl = "";
    public String mTitle = "";
    public String dkU = "";
    public String dkV = "";
    public String mCoverUrl = "";
    public String dkW = "";
    public int dkX = 0;
    public int mPos = 0;
    public String dkY = "";
    public boolean dla = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.dkT = jSONObject.optString("audioId", aVar.dkT);
            aVar2.cGy = jSONObject.optString("slaveId", aVar.cGy);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.dla = e.aMk() != null && com.baidu.swan.apps.storage.b.tN(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.dkU = jSONObject.optString("epname", aVar.dkU);
            aVar2.dkV = jSONObject.optString("singer", aVar.dkV);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.dkW = jSONObject.optString("lrcURL", aVar.dkW);
            aVar2.dkX = jSONObject.optInt("startTime", aVar.dkX);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.dkZ = jSONObject.optString("cb", aVar.dkZ);
            aVar2.dkY = jSONObject.optString("param", aVar.dkY);
            aVar2.dlb = TextUtils.isEmpty(jSONObject.optString("src"));
            String avY = com.baidu.swan.apps.core.turbo.d.avA().avY();
            if (!TextUtils.isEmpty(avY)) {
                aVar2.mUserAgent = avY;
            }
            String aRy = ab.aRy();
            if (!TextUtils.isEmpty(aRy) && ab.uQ(aVar2.mUrl)) {
                aVar2.mReferer = aRy;
            }
        }
        return aVar2;
    }

    public boolean aEc() {
        return this.dlb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qk(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.dkU);
            jSONObject.putOpt("singer", this.dkV);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.dkW);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.dla));
            jSONObject.putOpt("appid", e.aMm());
            jSONObject.putOpt("user-agent", this.mUserAgent);
            jSONObject.putOpt("refer", this.mReferer);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.dkT + "; slaveId : " + this.cGy + "; url : " + this.mUrl + "; startTime : " + this.dkX + "; pos : " + this.mPos + "; canPlay : " + this.dlb;
    }
}
