package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean diA;
    String diy;
    public String mReferer;
    public String mUserAgent;
    public String diq = "";
    public String cEi = "";
    public String mUrl = "";
    public String mTitle = "";
    public String dit = "";
    public String diu = "";
    public String mCoverUrl = "";
    public String div = "";
    public int diw = 0;
    public int mPos = 0;
    public String dix = "";
    public boolean diz = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.diq = jSONObject.optString("audioId", aVar.diq);
            aVar2.cEi = jSONObject.optString("slaveId", aVar.cEi);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.diz = e.aIK() != null && com.baidu.swan.apps.storage.b.sV(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.dit = jSONObject.optString("epname", aVar.dit);
            aVar2.diu = jSONObject.optString("singer", aVar.diu);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.div = jSONObject.optString("lrcURL", aVar.div);
            aVar2.diw = jSONObject.optInt("startTime", aVar.diw);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.diy = jSONObject.optString("cb", aVar.diy);
            aVar2.dix = jSONObject.optString("param", aVar.dix);
            aVar2.diA = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String asD = com.baidu.swan.apps.core.turbo.d.ase().asD();
            if (!TextUtils.isEmpty(asD)) {
                aVar2.mUserAgent = asD;
            }
            String aNY = ab.aNY();
            if (!TextUtils.isEmpty(aNY) && ab.tY(aVar2.mUrl)) {
                aVar2.mReferer = aNY;
            }
        }
        return aVar2;
    }

    public boolean aAH() {
        return this.diA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String pr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.dit);
            jSONObject.putOpt("singer", this.diu);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.div);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.diz));
            jSONObject.putOpt("appid", e.aIM());
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
        return "playerId : " + this.diq + "; slaveId : " + this.cEi + "; url : " + this.mUrl + "; startTime : " + this.diw + "; pos : " + this.mPos + "; canPlay : " + this.diA;
    }
}
