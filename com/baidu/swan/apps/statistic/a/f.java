package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aSv;
    public String mAppVersion = "";
    public String aSw = "";
    public String aSx = "";
    public String aSy = "";
    public String aSz = "";
    public String aSA = "";
    public String aSB = "";

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
        this.aSy = cVar.DA().getString("aiapp_extra_need_download", "");
        this.aSz = cVar.axL;
        this.aSB = cVar.axM;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b za = com.baidu.swan.apps.w.e.Ea().za();
            String a = com.baidu.swan.apps.swancore.b.a(this.aSv, this.mFrom == "swangame" ? 1 : 0);
            if (za != null && za.uA() != null) {
                com.baidu.swan.apps.v.b.b uA = za.uA();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = za.getVersion();
                }
                if (TextUtils.isEmpty(this.aSw)) {
                    this.aSw = uA.aul;
                }
                if (uA.axU != null) {
                    this.aSy = uA.axU.getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aSz)) {
                    this.aSz = uA.axL;
                }
                if (TextUtils.isEmpty(this.axM) && !TextUtils.isEmpty(uA.axM)) {
                    this.aSB = uA.axM;
                }
            }
            this.aSx = SwanAppNetworkUtils.Fb().type;
            if (this.aSu == null) {
                this.aSu = new JSONObject();
            }
            this.aSu.put("swan", a);
            this.aSu.put("appversion", this.mAppVersion);
            this.aSu.put("thirdversion", this.aSw);
            this.aSu.put("net", this.aSx);
            this.aSu.put("needdown", this.aSy);
            this.aSu.put("scheme", this.aSz);
            this.aSu.put("page", this.aSB);
            if (!TextUtils.isEmpty(this.aSA)) {
                this.aSu.put("canceltime", this.aSA);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aSu + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
