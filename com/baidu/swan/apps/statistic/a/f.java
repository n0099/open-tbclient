package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aSq;
    public String mAppVersion = "";
    public String aSr = "";
    public String aSs = "";
    public String aSt = "";
    public String aSu = "";
    public String aSv = "";
    public String aSw = "";

    public void d(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchparams is null");
                return;
            }
            return;
        }
        this.mAppId = cVar.mAppId;
        this.mSource = cVar.mFrom;
        this.aSt = cVar.DC().getString("aiapp_extra_need_download", "");
        this.aSu = cVar.axG;
        this.aSw = cVar.axH;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b zb = com.baidu.swan.apps.w.e.Ec().zb();
            String a = com.baidu.swan.apps.swancore.b.a(this.aSq, this.mFrom == "swangame" ? 1 : 0);
            if (zb != null && zb.uB() != null) {
                com.baidu.swan.apps.v.b.b uB = zb.uB();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = zb.getVersion();
                }
                if (TextUtils.isEmpty(this.aSr)) {
                    this.aSr = uB.auf;
                }
                if (uB.axP != null) {
                    this.aSt = uB.axP.getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aSu)) {
                    this.aSu = uB.axG;
                }
                if (TextUtils.isEmpty(this.axH) && !TextUtils.isEmpty(uB.axH)) {
                    this.aSw = uB.axH;
                }
            }
            this.aSs = SwanAppNetworkUtils.Fd().type;
            if (this.aSp == null) {
                this.aSp = new JSONObject();
            }
            this.aSp.put("swan", a);
            this.aSp.put("appversion", this.mAppVersion);
            this.aSp.put("thirdversion", this.aSr);
            this.aSp.put("net", this.aSs);
            this.aSp.put("needdown", this.aSt);
            this.aSp.put("scheme", this.aSu);
            this.aSp.put("page", this.aSw);
            if (!TextUtils.isEmpty(this.aSv)) {
                this.aSp.put("canceltime", this.aSv);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aSp + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
