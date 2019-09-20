package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aWs;
    public String mAppVersion = "";
    public String aWt = "";
    public String aWu = "";
    public String aWv = "";
    public String aWw = "";
    public String aWx = "";
    public String aWy = "";

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
        this.aWv = cVar.Fy().getString("aiapp_extra_need_download", "");
        this.aWw = cVar.azU;
        this.aWy = cVar.azQ;
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
        this.mSource = bVar.FK();
        this.aWv = bVar.Fy().getString("aiapp_extra_need_download", "");
        this.aWw = bVar.FL();
        this.aWy = bVar.getPage();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b AI = com.baidu.swan.apps.w.e.GJ().AI();
            String a = com.baidu.swan.apps.swancore.b.a(this.aWs, this.mFrom == "swangame" ? 1 : 0);
            if (AI != null && AI.vP() != null) {
                com.baidu.swan.apps.v.b.b vP = AI.vP();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = AI.getVersion();
                }
                if (TextUtils.isEmpty(this.aWt)) {
                    this.aWt = vP.getVersionCode();
                }
                if (vP.FO() != null) {
                    this.aWv = vP.FO().getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aWw)) {
                    this.aWw = vP.FL();
                }
                if (TextUtils.isEmpty(this.azQ) && !TextUtils.isEmpty(vP.getPage())) {
                    this.aWy = vP.getPage();
                }
            }
            this.aWu = SwanAppNetworkUtils.HV().type;
            if (this.aWq == null) {
                this.aWq = new JSONObject();
            }
            this.aWq.put("swan", a);
            this.aWq.put("appversion", this.mAppVersion);
            this.aWq.put("thirdversion", this.aWt);
            this.aWq.put("net", this.aWu);
            this.aWq.put("needdown", this.aWv);
            this.aWq.put("scheme", this.aWw);
            this.aWq.put("page", this.aWy);
            if (!TextUtils.isEmpty(this.aWx)) {
                this.aWq.put("canceltime", this.aWx);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aWq + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
