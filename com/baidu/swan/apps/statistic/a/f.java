package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aVU;
    public String mAppVersion = "";
    public String aVV = "";
    public String aVW = "";
    public String aVX = "";
    public String aVY = "";
    public String aVZ = "";
    public String aWa = "";

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
        this.aVX = cVar.Fu().getString("aiapp_extra_need_download", "");
        this.aVY = cVar.azw;
        this.aWa = cVar.azs;
    }

    public void t(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.mAppId = bVar.getAppId();
        this.mSource = bVar.FG();
        this.aVX = bVar.Fu().getString("aiapp_extra_need_download", "");
        this.aVY = bVar.FH();
        this.aWa = bVar.getPage();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b AE = com.baidu.swan.apps.w.e.GF().AE();
            String a = com.baidu.swan.apps.swancore.b.a(this.aVU, this.mFrom == "swangame" ? 1 : 0);
            if (AE != null && AE.vL() != null) {
                com.baidu.swan.apps.v.b.b vL = AE.vL();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = AE.getVersion();
                }
                if (TextUtils.isEmpty(this.aVV)) {
                    this.aVV = vL.getVersionCode();
                }
                if (vL.FK() != null) {
                    this.aVX = vL.FK().getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aVY)) {
                    this.aVY = vL.FH();
                }
                if (TextUtils.isEmpty(this.azs) && !TextUtils.isEmpty(vL.getPage())) {
                    this.aWa = vL.getPage();
                }
            }
            this.aVW = SwanAppNetworkUtils.HR().type;
            if (this.aVS == null) {
                this.aVS = new JSONObject();
            }
            this.aVS.put("swan", a);
            this.aVS.put("appversion", this.mAppVersion);
            this.aVS.put("thirdversion", this.aVV);
            this.aVS.put("net", this.aVW);
            this.aVS.put("needdown", this.aVX);
            this.aVS.put("scheme", this.aVY);
            this.aVS.put("page", this.aWa);
            if (!TextUtils.isEmpty(this.aVZ)) {
                this.aVS.put("canceltime", this.aVZ);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aVS + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
