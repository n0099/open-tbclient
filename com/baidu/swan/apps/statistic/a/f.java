package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aSr;
    public String mAppVersion = "";
    public String aSs = "";
    public String aSt = "";
    public String aSu = "";
    public String aSv = "";
    public String aSw = "";
    public String aSx = "";

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
        this.aSu = cVar.DC().getString("aiapp_extra_need_download", "");
        this.aSv = cVar.axH;
        this.aSx = cVar.axI;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b zb = com.baidu.swan.apps.w.e.Ec().zb();
            String a = com.baidu.swan.apps.swancore.b.a(this.aSr, this.mFrom == "swangame" ? 1 : 0);
            if (zb != null && zb.uB() != null) {
                com.baidu.swan.apps.v.b.b uB = zb.uB();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = zb.getVersion();
                }
                if (TextUtils.isEmpty(this.aSs)) {
                    this.aSs = uB.aug;
                }
                if (uB.axQ != null) {
                    this.aSu = uB.axQ.getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aSv)) {
                    this.aSv = uB.axH;
                }
                if (TextUtils.isEmpty(this.axI) && !TextUtils.isEmpty(uB.axI)) {
                    this.aSx = uB.axI;
                }
            }
            this.aSt = SwanAppNetworkUtils.Fd().type;
            if (this.aSq == null) {
                this.aSq = new JSONObject();
            }
            this.aSq.put("swan", a);
            this.aSq.put("appversion", this.mAppVersion);
            this.aSq.put("thirdversion", this.aSs);
            this.aSq.put("net", this.aSt);
            this.aSq.put("needdown", this.aSu);
            this.aSq.put("scheme", this.aSv);
            this.aSq.put("page", this.aSx);
            if (!TextUtils.isEmpty(this.aSw)) {
                this.aSq.put("canceltime", this.aSw);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aSq + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
