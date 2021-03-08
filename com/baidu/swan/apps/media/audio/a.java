package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String djZ;
    public boolean dkb;
    public String mReferer;
    public String mUserAgent;
    public String djT = "";
    public String cFI = "";
    public String mUrl = "";
    public String mTitle = "";
    public String djU = "";
    public String djV = "";
    public String mCoverUrl = "";
    public String djW = "";
    public int djX = 0;
    public int mPos = 0;
    public String djY = "";
    public boolean dka = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.djT = jSONObject.optString("audioId", aVar.djT);
            aVar2.cFI = jSONObject.optString("slaveId", aVar.cFI);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.dka = e.aIN() != null && com.baidu.swan.apps.storage.b.tc(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.djU = jSONObject.optString("epname", aVar.djU);
            aVar2.djV = jSONObject.optString("singer", aVar.djV);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.djW = jSONObject.optString("lrcURL", aVar.djW);
            aVar2.djX = jSONObject.optInt("startTime", aVar.djX);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.djZ = jSONObject.optString("cb", aVar.djZ);
            aVar2.djY = jSONObject.optString("param", aVar.djY);
            aVar2.dkb = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String asG = com.baidu.swan.apps.core.turbo.d.ash().asG();
            if (!TextUtils.isEmpty(asG)) {
                aVar2.mUserAgent = asG;
            }
            String aOb = ab.aOb();
            if (!TextUtils.isEmpty(aOb) && ab.uf(aVar2.mUrl)) {
                aVar2.mReferer = aOb;
            }
        }
        return aVar2;
    }

    public boolean aAK() {
        return this.dkb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String py(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.djU);
            jSONObject.putOpt("singer", this.djV);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.djW);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.dka));
            jSONObject.putOpt("appid", e.aIP());
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
        return "playerId : " + this.djT + "; slaveId : " + this.cFI + "; url : " + this.mUrl + "; startTime : " + this.djX + "; pos : " + this.mPos + "; canPlay : " + this.dkb;
    }
}
