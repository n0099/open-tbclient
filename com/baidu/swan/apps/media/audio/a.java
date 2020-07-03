package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cov;
    public boolean cox;
    public String mReferer;
    public String mUserAgent;
    public String cop = "";
    public String bNv = "";
    public String mUrl = "";
    public String mTitle = "";
    public String coq = "";
    public String cor = "";
    public String mCoverUrl = "";
    public String cos = "";
    public int cot = 0;
    public int mPos = 0;
    public String cou = "";
    public boolean cow = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cop = jSONObject.optString("audioId", aVar.cop);
            aVar2.bNv = jSONObject.optString("slaveId", aVar.bNv);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.cow = e.apM() != null && com.baidu.swan.apps.storage.b.oP(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.coq = jSONObject.optString("epname", aVar.coq);
            aVar2.cor = jSONObject.optString("singer", aVar.cor);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cos = jSONObject.optString("lrcURL", aVar.cos);
            aVar2.cot = jSONObject.optInt("startTime", aVar.cot);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cov = jSONObject.optString("cb", aVar.cov);
            aVar2.cou = jSONObject.optString("param", aVar.cou);
            aVar2.cox = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String acP = com.baidu.swan.apps.core.turbo.d.acr().acP();
            if (!TextUtils.isEmpty(acP)) {
                aVar2.mUserAgent = acP;
            }
            String auJ = z.auJ();
            if (!TextUtils.isEmpty(auJ) && z.pQ(aVar2.mUrl)) {
                aVar2.mReferer = auJ;
            }
        }
        return aVar2;
    }

    public boolean ajq() {
        return this.cox;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lD(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.coq);
            jSONObject.putOpt("singer", this.cor);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cos);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cow));
            jSONObject.putOpt("appid", e.apO());
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
        return "playerId : " + this.cop + "; slaveId : " + this.bNv + "; url : " + this.mUrl + "; startTime : " + this.cot + "; pos : " + this.mPos + "; canPlay : " + this.cox;
    }
}
