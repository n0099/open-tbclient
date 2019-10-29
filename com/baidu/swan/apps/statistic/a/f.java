package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion bpw;
    public String mAppVersion = "";
    public String bpx = "";
    public String bpy = "";
    public String bpz = "";
    public String bpA = "";
    public String bpB = "";
    public String bpC = "";

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
        this.bpz = cVar.Ks().getString("aiapp_extra_need_download", "");
        this.bpA = cVar.aTi;
        this.bpC = cVar.aTe;
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
        this.mSource = bVar.KE();
        this.bpz = bVar.Ks().getString("aiapp_extra_need_download", "");
        this.bpA = bVar.KF();
        this.bpC = bVar.getPage();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b FD = com.baidu.swan.apps.w.e.LD().FD();
            String a = com.baidu.swan.apps.swancore.b.a(this.bpw, this.mFrom == "swangame" ? 1 : 0);
            if (FD != null && FD.AJ() != null) {
                com.baidu.swan.apps.v.b.b AJ = FD.AJ();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = FD.getVersion();
                }
                if (TextUtils.isEmpty(this.bpx)) {
                    this.bpx = AJ.getVersionCode();
                }
                if (AJ.KI() != null) {
                    this.bpz = AJ.KI().getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.bpA)) {
                    this.bpA = AJ.KF();
                }
                if (TextUtils.isEmpty(this.aTe) && !TextUtils.isEmpty(AJ.getPage())) {
                    this.bpC = AJ.getPage();
                }
            }
            this.bpy = SwanAppNetworkUtils.MP().type;
            if (this.bpu == null) {
                this.bpu = new JSONObject();
            }
            this.bpu.put("swan", a);
            this.bpu.put("appversion", this.mAppVersion);
            this.bpu.put("thirdversion", this.bpx);
            this.bpu.put("net", this.bpy);
            this.bpu.put("needdown", this.bpz);
            this.bpu.put("scheme", this.bpA);
            this.bpu.put("page", this.bpC);
            if (!TextUtils.isEmpty(this.bpB)) {
                this.bpu.put("canceltime", this.bpB);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bpu + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
