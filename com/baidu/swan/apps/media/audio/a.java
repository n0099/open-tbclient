package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String dgg;
    public boolean dgi;
    public String mReferer;
    public String mUserAgent;
    public String dga = "";
    public String cBI = "";
    public String mUrl = "";
    public String mTitle = "";
    public String dgb = "";
    public String dgc = "";
    public String mCoverUrl = "";
    public String dgd = "";
    public int dge = 0;
    public int mPos = 0;
    public String dgf = "";
    public boolean dgh = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.dga = jSONObject.optString("audioId", aVar.dga);
            aVar2.cBI = jSONObject.optString("slaveId", aVar.cBI);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.dgh = e.aJU() != null && com.baidu.swan.apps.storage.b.tQ(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.dgb = jSONObject.optString("epname", aVar.dgb);
            aVar2.dgc = jSONObject.optString("singer", aVar.dgc);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.dgd = jSONObject.optString("lrcURL", aVar.dgd);
            aVar2.dge = jSONObject.optInt("startTime", aVar.dge);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.dgg = jSONObject.optString("cb", aVar.dgg);
            aVar2.dgf = jSONObject.optString("param", aVar.dgf);
            aVar2.dgi = TextUtils.isEmpty(jSONObject.optString("src"));
            String auG = com.baidu.swan.apps.core.turbo.d.aui().auG();
            if (!TextUtils.isEmpty(auG)) {
                aVar2.mUserAgent = auG;
            }
            String aPh = ab.aPh();
            if (!TextUtils.isEmpty(aPh) && ab.uR(aVar2.mUrl)) {
                aVar2.mReferer = aPh;
            }
        }
        return aVar2;
    }

    public boolean aCL() {
        return this.dgi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.dgb);
            jSONObject.putOpt("singer", this.dgc);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.dgd);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.dgh));
            jSONObject.putOpt("appid", e.aJW());
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
        return "playerId : " + this.dga + "; slaveId : " + this.cBI + "; url : " + this.mUrl + "; startTime : " + this.dge + "; pos : " + this.mPos + "; canPlay : " + this.dgi;
    }
}
