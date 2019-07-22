package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String aBi;
    public boolean aBk;
    public String aBc = "";
    public String aBd = "";
    public String mUrl = "";
    public String mTitle = "";
    public String aBe = "";
    public String aBf = "";
    public String mCoverUrl = "";
    public int aBg = 0;
    public int mPos = 0;
    public String aBh = "";
    public boolean aBj = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.aBc = jSONObject.optString("audioId", aVar.aBc);
            aVar2.aBd = jSONObject.optString("slaveId", aVar.aBd);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.aBj = com.baidu.swan.apps.ae.b.Md() != null && com.baidu.swan.apps.storage.b.hz(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.aBe = jSONObject.optString("epname", aVar.aBe);
            aVar2.aBf = jSONObject.optString("singer", aVar.aBf);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.aBg = jSONObject.optInt("startTime", aVar.aBg);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.aBi = jSONObject.optString("cb", aVar.aBi);
            aVar2.aBh = jSONObject.optString("param", aVar.aBh);
            aVar2.aBk = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean GR() {
        return this.aBk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fj(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.aBe);
            jSONObject.putOpt("singer", this.aBf);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.aBj));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.aBc + "; slaveId : " + this.aBd + "; url : " + this.mUrl + "; startTime : " + this.aBg + "; pos : " + this.mPos + "; canPlay : " + this.aBk;
    }
}
