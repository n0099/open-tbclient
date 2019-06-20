package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String aAA;
    public boolean aAC;
    public String aAu = "";
    public String aAv = "";
    public String mUrl = "";
    public String mTitle = "";
    public String aAw = "";
    public String aAx = "";
    public String mCoverUrl = "";
    public int aAy = 0;
    public int mPos = 0;
    public String aAz = "";
    public boolean aAB = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.aAu = jSONObject.optString("audioId", aVar.aAu);
            aVar2.aAv = jSONObject.optString("slaveId", aVar.aAv);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.aAB = com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.storage.b.hs(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.aAw = jSONObject.optString("epname", aVar.aAw);
            aVar2.aAx = jSONObject.optString("singer", aVar.aAx);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.aAy = jSONObject.optInt("startTime", aVar.aAy);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.aAA = jSONObject.optString("cb", aVar.aAA);
            aVar2.aAz = jSONObject.optString("param", aVar.aAz);
            aVar2.aAC = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean Gh() {
        return this.aAC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fe(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.aAw);
            jSONObject.putOpt("singer", this.aAx);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.aAB));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.aAu + "; slaveId : " + this.aAv + "; url : " + this.mUrl + "; startTime : " + this.aAy + "; pos : " + this.mPos + "; canPlay : " + this.aAC;
    }
}
