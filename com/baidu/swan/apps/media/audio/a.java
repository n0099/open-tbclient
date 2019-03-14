package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azB;
    String azz;
    public String azs = "";
    public String azt = "";
    public String mUrl = "";
    public String mTitle = "";
    public String azu = "";
    public String azv = "";
    public String azw = "";
    public int azx = 0;
    public int mPos = 0;
    public String azy = "";
    public boolean azA = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.azs = jSONObject.optString("audioId", aVar.azs);
            aVar2.azt = jSONObject.optString("slaveId", aVar.azt);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.azA = com.baidu.swan.apps.ae.b.IX() != null && com.baidu.swan.apps.storage.b.gV(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.azu = jSONObject.optString("epname", aVar.azu);
            aVar2.azv = jSONObject.optString("singer", aVar.azv);
            aVar2.azw = jSONObject.optString("coverImgUrl", aVar.azw);
            aVar2.azx = jSONObject.optInt("startTime", aVar.azx);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.azz = jSONObject.optString("cb", aVar.azz);
            aVar2.azy = jSONObject.optString("param", aVar.azy);
            aVar2.azB = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean En() {
        return this.azB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eT(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.azu);
            jSONObject.putOpt("singer", this.azv);
            jSONObject.putOpt("coverImgUrl", this.azw);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.azA));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.azs + "; slaveId : " + this.azt + "; url : " + this.mUrl + "; startTime : " + this.azx + "; pos : " + this.mPos + "; canPlay : " + this.azB;
    }
}
