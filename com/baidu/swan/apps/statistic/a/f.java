package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aSu;
    public String mAppVersion = "";
    public String aSv = "";
    public String aSw = "";
    public String aSx = "";
    public String aSy = "";
    public String aSz = "";
    public String aSA = "";

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
        this.aSx = cVar.DA().getString("aiapp_extra_need_download", "");
        this.aSy = cVar.axK;
        this.aSA = cVar.axL;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b za = com.baidu.swan.apps.w.e.Ea().za();
            String a = com.baidu.swan.apps.swancore.b.a(this.aSu, this.mFrom == "swangame" ? 1 : 0);
            if (za != null && za.uA() != null) {
                com.baidu.swan.apps.v.b.b uA = za.uA();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = za.getVersion();
                }
                if (TextUtils.isEmpty(this.aSv)) {
                    this.aSv = uA.auk;
                }
                if (uA.axT != null) {
                    this.aSx = uA.axT.getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aSy)) {
                    this.aSy = uA.axK;
                }
                if (TextUtils.isEmpty(this.axL) && !TextUtils.isEmpty(uA.axL)) {
                    this.aSA = uA.axL;
                }
            }
            this.aSw = SwanAppNetworkUtils.Fb().type;
            if (this.aSt == null) {
                this.aSt = new JSONObject();
            }
            this.aSt.put("swan", a);
            this.aSt.put("appversion", this.mAppVersion);
            this.aSt.put("thirdversion", this.aSv);
            this.aSt.put("net", this.aSw);
            this.aSt.put("needdown", this.aSx);
            this.aSt.put("scheme", this.aSy);
            this.aSt.put("page", this.aSA);
            if (!TextUtils.isEmpty(this.aSz)) {
                this.aSt.put("canceltime", this.aSz);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aSt + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
