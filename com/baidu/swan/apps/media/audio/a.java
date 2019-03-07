package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public boolean azA;
    String azy;
    public String azr = "";
    public String azs = "";
    public String mUrl = "";
    public String mTitle = "";
    public String azt = "";
    public String azu = "";
    public String azv = "";
    public int azw = 0;
    public int mPos = 0;
    public String azx = "";
    public boolean azz = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.azr = jSONObject.optString("audioId", aVar.azr);
            aVar2.azs = jSONObject.optString("slaveId", aVar.azs);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.azz = com.baidu.swan.apps.ae.b.IX() != null && com.baidu.swan.apps.storage.b.gV(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.azt = jSONObject.optString("epname", aVar.azt);
            aVar2.azu = jSONObject.optString("singer", aVar.azu);
            aVar2.azv = jSONObject.optString("coverImgUrl", aVar.azv);
            aVar2.azw = jSONObject.optInt("startTime", aVar.azw);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.azy = jSONObject.optString("cb", aVar.azy);
            aVar2.azx = jSONObject.optString("param", aVar.azx);
            aVar2.azA = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean En() {
        return this.azA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eT(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.azt);
            jSONObject.putOpt("singer", this.azu);
            jSONObject.putOpt("coverImgUrl", this.azv);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.azz));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.azr + "; slaveId : " + this.azs + "; url : " + this.mUrl + "; startTime : " + this.azw + "; pos : " + this.mPos + "; canPlay : " + this.azA;
    }
}
