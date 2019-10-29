package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String aUU;
    public boolean aUW;
    public String aUO = "";
    public String aUP = "";
    public String mUrl = "";
    public String mTitle = "";
    public String aUQ = "";
    public String aUR = "";
    public String mCoverUrl = "";
    public int aUS = 0;
    public int mPos = 0;
    public String aUT = "";
    public boolean aUV = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.aUO = jSONObject.optString("audioId", aVar.aUO);
            aVar2.aUP = jSONObject.optString("slaveId", aVar.aUP);
            aVar2.mUrl = jSONObject.optString("src", aVar.mUrl);
            aVar2.aUV = com.baidu.swan.apps.ae.b.QZ() != null && com.baidu.swan.apps.storage.b.m18if(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.aUQ = jSONObject.optString("epname", aVar.aUQ);
            aVar2.aUR = jSONObject.optString("singer", aVar.aUR);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.aUS = jSONObject.optInt("startTime", aVar.aUS);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.aUU = jSONObject.optString("cb", aVar.aUU);
            aVar2.aUT = jSONObject.optString("param", aVar.aUT);
            aVar2.aUW = TextUtils.isEmpty(jSONObject.optString("src"));
        }
        return aVar2;
    }

    public boolean LP() {
        return this.aUW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fR(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.aUQ);
            jSONObject.putOpt("singer", this.aUR);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.aUV));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.aUO + "; slaveId : " + this.aUP + "; url : " + this.mUrl + "; startTime : " + this.aUS + "; pos : " + this.mPos + "; canPlay : " + this.aUW;
    }
}
