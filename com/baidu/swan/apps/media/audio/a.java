package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cqA;
    public boolean cqC;
    public String mReferer;
    public String mUserAgent;
    public String cqu = "";
    public String bOl = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cqv = "";
    public String cqw = "";
    public String mCoverUrl = "";
    public String cqx = "";
    public int cqy = 0;
    public int mPos = 0;
    public String cqz = "";
    public boolean cqB = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cqu = jSONObject.optString("audioId", aVar.cqu);
            aVar2.bOl = jSONObject.optString("slaveId", aVar.bOl);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.cqB = e.arv() != null && com.baidu.swan.apps.storage.b.pA(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cqv = jSONObject.optString("epname", aVar.cqv);
            aVar2.cqw = jSONObject.optString("singer", aVar.cqw);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cqx = jSONObject.optString("lrcURL", aVar.cqx);
            aVar2.cqy = jSONObject.optInt("startTime", aVar.cqy);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cqA = jSONObject.optString("cb", aVar.cqA);
            aVar2.cqz = jSONObject.optString("param", aVar.cqz);
            aVar2.cqC = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String adT = com.baidu.swan.apps.core.turbo.d.adw().adT();
            if (!TextUtils.isEmpty(adT)) {
                aVar2.mUserAgent = adT;
            }
            String awL = aa.awL();
            if (!TextUtils.isEmpty(awL) && aa.qB(aVar2.mUrl)) {
                aVar2.mReferer = awL;
            }
        }
        return aVar2;
    }

    public boolean akG() {
        return this.cqC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String me(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cqv);
            jSONObject.putOpt("singer", this.cqw);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cqx);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cqB));
            jSONObject.putOpt("appid", e.arx());
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
        return "playerId : " + this.cqu + "; slaveId : " + this.bOl + "; url : " + this.mUrl + "; startTime : " + this.cqy + "; pos : " + this.mPos + "; canPlay : " + this.cqC;
    }
}
