package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String azD;
    public boolean azF;
    public String azw = "";
    public String azx = "";
    public String mUrl = "";
    public String mTitle = "";
    public String azy = "";
    public String azz = "";
    public String azA = "";
    public int azB = 0;
    public int mPos = 0;
    public String azC = "";
    public boolean azE = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.azw = jSONObject.optString("audioId", aVar.azw);
            aVar2.azx = jSONObject.optString("slaveId", aVar.azx);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.azE = com.baidu.swan.apps.ae.b.IV() != null && com.baidu.swan.apps.storage.b.gW(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.azy = jSONObject.optString("epname", aVar.azy);
            aVar2.azz = jSONObject.optString("singer", aVar.azz);
            aVar2.azA = jSONObject.optString("coverImgUrl", aVar.azA);
            aVar2.azB = jSONObject.optInt("startTime", aVar.azB);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.azD = jSONObject.optString("cb", aVar.azD);
            aVar2.azC = jSONObject.optString("param", aVar.azC);
            aVar2.azF = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean El() {
        return this.azF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eU(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.azy);
            jSONObject.putOpt("singer", this.azz);
            jSONObject.putOpt("coverImgUrl", this.azA);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.azE));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.azw + "; slaveId : " + this.azx + "; url : " + this.mUrl + "; startTime : " + this.azB + "; pos : " + this.mPos + "; canPlay : " + this.azF;
    }
}
