package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cMA;
    public boolean cMC;
    public String mReferer;
    public String mUserAgent;
    public String cMu = "";
    public String cib = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cMv = "";
    public String cMw = "";
    public String mCoverUrl = "";
    public String cMx = "";
    public int cMy = 0;
    public int mPos = 0;
    public String cMz = "";
    public boolean cMB = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cMu = jSONObject.optString("audioId", aVar.cMu);
            aVar2.cib = jSONObject.optString("slaveId", aVar.cib);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.cMB = e.aDa() != null && com.baidu.swan.apps.storage.b.sH(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cMv = jSONObject.optString("epname", aVar.cMv);
            aVar2.cMw = jSONObject.optString("singer", aVar.cMw);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cMx = jSONObject.optString("lrcURL", aVar.cMx);
            aVar2.cMy = jSONObject.optInt("startTime", aVar.cMy);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cMA = jSONObject.optString("cb", aVar.cMA);
            aVar2.cMz = jSONObject.optString("param", aVar.cMz);
            aVar2.cMC = TextUtils.isEmpty(jSONObject.optString("src"));
            String anL = com.baidu.swan.apps.core.turbo.d.ann().anL();
            if (!TextUtils.isEmpty(anL)) {
                aVar2.mUserAgent = anL;
            }
            String aIo = ab.aIo();
            if (!TextUtils.isEmpty(aIo) && ab.tI(aVar2.mUrl)) {
                aVar2.mReferer = aIo;
            }
        }
        return aVar2;
    }

    public boolean avQ() {
        return this.cMC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String pj(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cMv);
            jSONObject.putOpt("singer", this.cMw);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cMx);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cMB));
            jSONObject.putOpt("appid", e.aDc());
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
        return "playerId : " + this.cMu + "; slaveId : " + this.cib + "; url : " + this.mUrl + "; startTime : " + this.cMy + "; pos : " + this.mPos + "; canPlay : " + this.cMC;
    }
}
