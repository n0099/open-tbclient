package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cUW;
    public boolean cUY;
    public String mReferer;
    public String mUserAgent;
    public String cUQ = "";
    public String cqC = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cUR = "";
    public String cUS = "";
    public String mCoverUrl = "";
    public String cUT = "";
    public int cUU = 0;
    public int mPos = 0;
    public String cUV = "";
    public boolean cUX = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cUQ = jSONObject.optString("audioId", aVar.cUQ);
            aVar2.cqC = jSONObject.optString("slaveId", aVar.cqC);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.cUX = e.aEU() != null && com.baidu.swan.apps.storage.b.ta(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cUR = jSONObject.optString("epname", aVar.cUR);
            aVar2.cUS = jSONObject.optString("singer", aVar.cUS);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cUT = jSONObject.optString("lrcURL", aVar.cUT);
            aVar2.cUU = jSONObject.optInt("startTime", aVar.cUU);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cUW = jSONObject.optString("cb", aVar.cUW);
            aVar2.cUV = jSONObject.optString("param", aVar.cUV);
            aVar2.cUY = TextUtils.isEmpty(jSONObject.optString("src"));
            String apG = com.baidu.swan.apps.core.turbo.d.aph().apG();
            if (!TextUtils.isEmpty(apG)) {
                aVar2.mUserAgent = apG;
            }
            String aKi = ab.aKi();
            if (!TextUtils.isEmpty(aKi) && ab.ub(aVar2.mUrl)) {
                aVar2.mReferer = aKi;
            }
        }
        return aVar2;
    }

    public boolean axK() {
        return this.cUY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String pC(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cUR);
            jSONObject.putOpt("singer", this.cUS);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cUT);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cUX));
            jSONObject.putOpt("appid", e.aEW());
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
        return "playerId : " + this.cUQ + "; slaveId : " + this.cqC + "; url : " + this.mUrl + "; startTime : " + this.cUU + "; pos : " + this.mPos + "; canPlay : " + this.cUY;
    }
}
