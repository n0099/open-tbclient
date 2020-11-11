package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String daQ;
    public boolean daS;
    public String mReferer;
    public String mUserAgent;
    public String daK = "";
    public String cwA = "";
    public String mUrl = "";
    public String mTitle = "";
    public String daL = "";
    public String daM = "";
    public String mCoverUrl = "";
    public String daN = "";
    public int daO = 0;
    public int mPos = 0;
    public String daP = "";
    public boolean daR = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.daK = jSONObject.optString("audioId", aVar.daK);
            aVar2.cwA = jSONObject.optString("slaveId", aVar.cwA);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.daR = e.aHu() != null && com.baidu.swan.apps.storage.b.to(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.daL = jSONObject.optString("epname", aVar.daL);
            aVar2.daM = jSONObject.optString("singer", aVar.daM);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.daN = jSONObject.optString("lrcURL", aVar.daN);
            aVar2.daO = jSONObject.optInt("startTime", aVar.daO);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.daQ = jSONObject.optString("cb", aVar.daQ);
            aVar2.daP = jSONObject.optString("param", aVar.daP);
            aVar2.daS = TextUtils.isEmpty(jSONObject.optString("src"));
            String asg = com.baidu.swan.apps.core.turbo.d.arI().asg();
            if (!TextUtils.isEmpty(asg)) {
                aVar2.mUserAgent = asg;
            }
            String aMI = ab.aMI();
            if (!TextUtils.isEmpty(aMI) && ab.up(aVar2.mUrl)) {
                aVar2.mReferer = aMI;
            }
        }
        return aVar2;
    }

    public boolean aAk() {
        return this.daS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String pQ(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.daL);
            jSONObject.putOpt("singer", this.daM);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.daN);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.daR));
            jSONObject.putOpt("appid", e.aHw());
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
        return "playerId : " + this.daK + "; slaveId : " + this.cwA + "; url : " + this.mUrl + "; startTime : " + this.daO + "; pos : " + this.mPos + "; canPlay : " + this.daS;
    }
}
