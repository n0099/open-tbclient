package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bAF;
    public boolean bAH;
    public String mReferer;
    public String mUserAgent;
    public String bAA = "";
    public String bcj = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bAB = "";
    public String bAC = "";
    public String mCoverUrl = "";
    public int bAD = 0;
    public int mPos = 0;
    public String bAE = "";
    public boolean bAG = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bAA = jSONObject.optString("audioId", aVar.bAA);
            aVar2.bcj = jSONObject.optString("slaveId", aVar.bcj);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bAG = e.acF() != null && com.baidu.swan.apps.storage.b.lS(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bAB = jSONObject.optString("epname", aVar.bAB);
            aVar2.bAC = jSONObject.optString("singer", aVar.bAC);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bAD = jSONObject.optInt("startTime", aVar.bAD);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bAF = jSONObject.optString("cb", aVar.bAF);
            aVar2.bAE = jSONObject.optString("param", aVar.bAE);
            aVar2.bAH = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String QT = com.baidu.swan.apps.core.k.d.Qw().QT();
            if (!TextUtils.isEmpty(QT)) {
                aVar2.mUserAgent = QT;
            }
            String agT = y.agT();
            if (!TextUtils.isEmpty(agT) && y.mN(aVar2.mUrl)) {
                aVar2.mReferer = agT;
            }
        }
        return aVar2;
    }

    public boolean Xe() {
        return this.bAH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String iW(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bAB);
            jSONObject.putOpt("singer", this.bAC);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bAG));
            jSONObject.putOpt("appid", e.acH());
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
        return "playerId : " + this.bAA + "; slaveId : " + this.bcj + "; url : " + this.mUrl + "; startTime : " + this.bAD + "; pos : " + this.mPos + "; canPlay : " + this.bAH;
    }
}
