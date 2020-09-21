package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cAv;
    public boolean cAx;
    public String mReferer;
    public String mUserAgent;
    public String cAp = "";
    public String bVN = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cAq = "";
    public String cAr = "";
    public String mCoverUrl = "";
    public String cAs = "";
    public int cAt = 0;
    public int mPos = 0;
    public String cAu = "";
    public boolean cAw = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cAp = jSONObject.optString("audioId", aVar.cAp);
            aVar2.bVN = jSONObject.optString("slaveId", aVar.bVN);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.cAw = e.aAr() != null && com.baidu.swan.apps.storage.b.rU(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cAq = jSONObject.optString("epname", aVar.cAq);
            aVar2.cAr = jSONObject.optString("singer", aVar.cAr);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cAs = jSONObject.optString("lrcURL", aVar.cAs);
            aVar2.cAt = jSONObject.optInt("startTime", aVar.cAt);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cAv = jSONObject.optString("cb", aVar.cAv);
            aVar2.cAu = jSONObject.optString("param", aVar.cAu);
            aVar2.cAx = TextUtils.isEmpty(jSONObject.optString("src"));
            String ala = com.baidu.swan.apps.core.turbo.d.akC().ala();
            if (!TextUtils.isEmpty(ala)) {
                aVar2.mUserAgent = ala;
            }
            String aFF = ab.aFF();
            if (!TextUtils.isEmpty(aFF) && ab.sW(aVar2.mUrl)) {
                aVar2.mReferer = aFF;
            }
        }
        return aVar2;
    }

    public boolean atf() {
        return this.cAx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ox(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cAq);
            jSONObject.putOpt("singer", this.cAr);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cAs);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cAw));
            jSONObject.putOpt("appid", e.aAt());
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
        return "playerId : " + this.cAp + "; slaveId : " + this.bVN + "; url : " + this.mUrl + "; startTime : " + this.cAt + "; pos : " + this.mPos + "; canPlay : " + this.cAx;
    }
}
