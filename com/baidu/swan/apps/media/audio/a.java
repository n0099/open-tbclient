package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cZg;
    public boolean cZi;
    public String mReferer;
    public String mUserAgent;
    public String cZa = "";
    public String cuQ = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cZb = "";
    public String cZc = "";
    public String mCoverUrl = "";
    public String cZd = "";
    public int cZe = 0;
    public int mPos = 0;
    public String cZf = "";
    public boolean cZh = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cZa = jSONObject.optString("audioId", aVar.cZa);
            aVar2.cuQ = jSONObject.optString("slaveId", aVar.cuQ);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.cZh = e.aGM() != null && com.baidu.swan.apps.storage.b.tj(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cZb = jSONObject.optString("epname", aVar.cZb);
            aVar2.cZc = jSONObject.optString("singer", aVar.cZc);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cZd = jSONObject.optString("lrcURL", aVar.cZd);
            aVar2.cZe = jSONObject.optInt("startTime", aVar.cZe);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cZg = jSONObject.optString("cb", aVar.cZg);
            aVar2.cZf = jSONObject.optString("param", aVar.cZf);
            aVar2.cZi = TextUtils.isEmpty(jSONObject.optString("src"));
            String ary = com.baidu.swan.apps.core.turbo.d.ara().ary();
            if (!TextUtils.isEmpty(ary)) {
                aVar2.mUserAgent = ary;
            }
            String aMa = ab.aMa();
            if (!TextUtils.isEmpty(aMa) && ab.uk(aVar2.mUrl)) {
                aVar2.mReferer = aMa;
            }
        }
        return aVar2;
    }

    public boolean azC() {
        return this.cZi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String pK(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cZb);
            jSONObject.putOpt("singer", this.cZc);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cZd);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cZh));
            jSONObject.putOpt("appid", e.aGO());
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
        return "playerId : " + this.cZa + "; slaveId : " + this.cuQ + "; url : " + this.mUrl + "; startTime : " + this.cZe + "; pos : " + this.mPos + "; canPlay : " + this.cZi;
    }
}
