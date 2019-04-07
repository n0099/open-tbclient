package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String azC;
    public boolean azE;
    public String azv = "";
    public String azw = "";
    public String mUrl = "";
    public String mTitle = "";
    public String azx = "";
    public String azy = "";
    public String azz = "";
    public int azA = 0;
    public int mPos = 0;
    public String azB = "";
    public boolean azD = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.azv = jSONObject.optString("audioId", aVar.azv);
            aVar2.azw = jSONObject.optString("slaveId", aVar.azw);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.azD = com.baidu.swan.apps.ae.b.IV() != null && com.baidu.swan.apps.storage.b.gW(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.azx = jSONObject.optString("epname", aVar.azx);
            aVar2.azy = jSONObject.optString("singer", aVar.azy);
            aVar2.azz = jSONObject.optString("coverImgUrl", aVar.azz);
            aVar2.azA = jSONObject.optInt("startTime", aVar.azA);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.azC = jSONObject.optString("cb", aVar.azC);
            aVar2.azB = jSONObject.optString("param", aVar.azB);
            aVar2.azE = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean El() {
        return this.azE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eU(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.azx);
            jSONObject.putOpt("singer", this.azy);
            jSONObject.putOpt("coverImgUrl", this.azz);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.azD));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.azv + "; slaveId : " + this.azw + "; url : " + this.mUrl + "; startTime : " + this.azA + "; pos : " + this.mPos + "; canPlay : " + this.azE;
    }
}
