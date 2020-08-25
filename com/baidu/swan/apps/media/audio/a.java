package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cyq;
    public boolean cys;
    public String mReferer;
    public String mUserAgent;
    public String cyk = "";
    public String bTJ = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cyl = "";
    public String cym = "";
    public String mCoverUrl = "";
    public String cyn = "";
    public int cyo = 0;
    public int mPos = 0;
    public String cyp = "";
    public boolean cyr = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cyk = jSONObject.optString("audioId", aVar.cyk);
            aVar2.bTJ = jSONObject.optString("slaveId", aVar.bTJ);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.cyr = e.azI() != null && com.baidu.swan.apps.storage.b.rA(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cyl = jSONObject.optString("epname", aVar.cyl);
            aVar2.cym = jSONObject.optString("singer", aVar.cym);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cyn = jSONObject.optString("lrcURL", aVar.cyn);
            aVar2.cyo = jSONObject.optInt("startTime", aVar.cyo);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cyq = jSONObject.optString("cb", aVar.cyq);
            aVar2.cyp = jSONObject.optString("param", aVar.cyp);
            aVar2.cys = TextUtils.isEmpty(jSONObject.optString("src"));
            String akq = com.baidu.swan.apps.core.turbo.d.ajS().akq();
            if (!TextUtils.isEmpty(akq)) {
                aVar2.mUserAgent = akq;
            }
            String aEV = ab.aEV();
            if (!TextUtils.isEmpty(aEV) && ab.sC(aVar2.mUrl)) {
                aVar2.mReferer = aEV;
            }
        }
        return aVar2;
    }

    public boolean asv() {
        return this.cys;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ob(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cyl);
            jSONObject.putOpt("singer", this.cym);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cyn);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cyr));
            jSONObject.putOpt("appid", e.azK());
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
        return "playerId : " + this.cyk + "; slaveId : " + this.bTJ + "; url : " + this.mUrl + "; startTime : " + this.cyo + "; pos : " + this.mPos + "; canPlay : " + this.cys;
    }
}
