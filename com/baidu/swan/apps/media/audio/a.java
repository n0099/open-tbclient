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
    String dgk;
    public boolean dgm;
    public String mReferer;
    public String mUserAgent;
    public String dge = "";
    public String cBM = "";
    public String mUrl = "";
    public String mTitle = "";
    public String dgf = "";
    public String dgg = "";
    public String mCoverUrl = "";
    public String dgh = "";
    public int dgi = 0;
    public int mPos = 0;
    public String dgj = "";
    public boolean dgl = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.dge = jSONObject.optString("audioId", aVar.dge);
            aVar2.cBM = jSONObject.optString("slaveId", aVar.cBM);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.dgl = e.aIr() != null && com.baidu.swan.apps.storage.b.sC(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.dgf = jSONObject.optString("epname", aVar.dgf);
            aVar2.dgg = jSONObject.optString("singer", aVar.dgg);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.dgh = jSONObject.optString("lrcURL", aVar.dgh);
            aVar2.dgi = jSONObject.optInt("startTime", aVar.dgi);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.dgk = jSONObject.optString("cb", aVar.dgk);
            aVar2.dgj = jSONObject.optString("param", aVar.dgj);
            aVar2.dgm = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String ase = com.baidu.swan.apps.core.turbo.d.arG().ase();
            if (!TextUtils.isEmpty(ase)) {
                aVar2.mUserAgent = ase;
            }
            String aNF = ab.aNF();
            if (!TextUtils.isEmpty(aNF) && ab.tF(aVar2.mUrl)) {
                aVar2.mReferer = aNF;
            }
        }
        return aVar2;
    }

    public boolean aAj() {
        return this.dgm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String oZ(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.dgf);
            jSONObject.putOpt("singer", this.dgg);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.dgh);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.dgl));
            jSONObject.putOpt("appid", e.aIt());
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
        return "playerId : " + this.dge + "; slaveId : " + this.cBM + "; url : " + this.mUrl + "; startTime : " + this.dgi + "; pos : " + this.mPos + "; canPlay : " + this.dgm;
    }
}
