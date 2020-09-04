package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cyu;
    public boolean cyw;
    public String mReferer;
    public String mUserAgent;
    public String cyo = "";
    public String bTN = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cyp = "";
    public String cyq = "";
    public String mCoverUrl = "";
    public String cyr = "";
    public int cys = 0;
    public int mPos = 0;
    public String cyt = "";
    public boolean cyv = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cyo = jSONObject.optString("audioId", aVar.cyo);
            aVar2.bTN = jSONObject.optString("slaveId", aVar.bTN);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.cyv = e.azI() != null && com.baidu.swan.apps.storage.b.rB(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cyp = jSONObject.optString("epname", aVar.cyp);
            aVar2.cyq = jSONObject.optString("singer", aVar.cyq);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cyr = jSONObject.optString("lrcURL", aVar.cyr);
            aVar2.cys = jSONObject.optInt("startTime", aVar.cys);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cyu = jSONObject.optString("cb", aVar.cyu);
            aVar2.cyt = jSONObject.optString("param", aVar.cyt);
            aVar2.cyw = TextUtils.isEmpty(jSONObject.optString("src"));
            String akq = com.baidu.swan.apps.core.turbo.d.ajS().akq();
            if (!TextUtils.isEmpty(akq)) {
                aVar2.mUserAgent = akq;
            }
            String aEV = ab.aEV();
            if (!TextUtils.isEmpty(aEV) && ab.sD(aVar2.mUrl)) {
                aVar2.mReferer = aEV;
            }
        }
        return aVar2;
    }

    public boolean asv() {
        return this.cyw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String oc(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cyp);
            jSONObject.putOpt("singer", this.cyq);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cyr);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cyv));
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
        return "playerId : " + this.cyo + "; slaveId : " + this.bTN + "; url : " + this.mUrl + "; startTime : " + this.cys + "; pos : " + this.mPos + "; canPlay : " + this.cyw;
    }
}
