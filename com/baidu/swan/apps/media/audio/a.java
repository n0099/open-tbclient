package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String aBG;
    public boolean aBI;
    public String aBA = "";
    public String aBB = "";
    public String mUrl = "";
    public String mTitle = "";
    public String aBC = "";
    public String aBD = "";
    public String mCoverUrl = "";
    public int aBE = 0;
    public int mPos = 0;
    public String aBF = "";
    public boolean aBH = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.aBA = jSONObject.optString("audioId", aVar.aBA);
            aVar2.aBB = jSONObject.optString("slaveId", aVar.aBB);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.aBH = com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.storage.b.hB(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.aBC = jSONObject.optString("epname", aVar.aBC);
            aVar2.aBD = jSONObject.optString("singer", aVar.aBD);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.aBE = jSONObject.optInt("startTime", aVar.aBE);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.aBG = jSONObject.optString("cb", aVar.aBG);
            aVar2.aBF = jSONObject.optString("param", aVar.aBF);
            aVar2.aBI = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean GV() {
        return this.aBI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fl(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.aBC);
            jSONObject.putOpt("singer", this.aBD);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.aBH));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.aBA + "; slaveId : " + this.aBB + "; url : " + this.mUrl + "; startTime : " + this.aBE + "; pos : " + this.mPos + "; canPlay : " + this.aBI;
    }
}
