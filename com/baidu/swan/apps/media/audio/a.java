package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bwu;
    public boolean bww;
    public String mReferer;
    public String mUserAgent;
    public String bwp = "";
    public String aXX = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bwq = "";
    public String bwr = "";
    public String mCoverUrl = "";
    public int bws = 0;
    public int mPos = 0;
    public String bwt = "";
    public boolean bwv = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bwp = jSONObject.optString("audioId", aVar.bwp);
            aVar2.aXX = jSONObject.optString("slaveId", aVar.aXX);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bwv = e.aap() != null && com.baidu.swan.apps.storage.b.lD(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bwq = jSONObject.optString("epname", aVar.bwq);
            aVar2.bwr = jSONObject.optString("singer", aVar.bwr);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bws = jSONObject.optInt("startTime", aVar.bws);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bwu = jSONObject.optString("cb", aVar.bwu);
            aVar2.bwt = jSONObject.optString("param", aVar.bwt);
            aVar2.bww = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String OD = com.baidu.swan.apps.core.k.d.Og().OD();
            if (!TextUtils.isEmpty(OD)) {
                aVar2.mUserAgent = OD;
            }
            String aeD = y.aeD();
            if (!TextUtils.isEmpty(aeD) && y.my(aVar2.mUrl)) {
                aVar2.mReferer = aeD;
            }
        }
        return aVar2;
    }

    public boolean UO() {
        return this.bww;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String iH(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bwq);
            jSONObject.putOpt("singer", this.bwr);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bwv));
            jSONObject.putOpt("appid", e.aar());
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
        return "playerId : " + this.bwp + "; slaveId : " + this.aXX + "; url : " + this.mUrl + "; startTime : " + this.bws + "; pos : " + this.mPos + "; canPlay : " + this.bww;
    }
}
