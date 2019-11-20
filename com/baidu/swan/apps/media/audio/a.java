package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String aUC;
    public boolean aUE;
    public String aUw = "";
    public String aUx = "";
    public String mUrl = "";
    public String mTitle = "";
    public String aUy = "";
    public String aUz = "";
    public String mCoverUrl = "";
    public int aUA = 0;
    public int mPos = 0;
    public String aUB = "";
    public boolean aUD = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.aUw = jSONObject.optString("audioId", aVar.aUw);
            aVar2.aUx = jSONObject.optString("slaveId", aVar.aUx);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.aUD = com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.storage.b.m18if(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.aUy = jSONObject.optString("epname", aVar.aUy);
            aVar2.aUz = jSONObject.optString("singer", aVar.aUz);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.aUA = jSONObject.optInt("startTime", aVar.aUA);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.aUC = jSONObject.optString("cb", aVar.aUC);
            aVar2.aUB = jSONObject.optString("param", aVar.aUB);
            aVar2.aUE = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean LQ() {
        return this.aUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fR(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.aUy);
            jSONObject.putOpt("singer", this.aUz);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.aUD));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.aUw + "; slaveId : " + this.aUx + "; url : " + this.mUrl + "; startTime : " + this.aUA + "; pos : " + this.mPos + "; canPlay : " + this.aUE;
    }
}
