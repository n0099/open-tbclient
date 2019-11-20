package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion bpe;
    public String mAppVersion = "";
    public String bpf = "";
    public String bpg = "";
    public String bph = "";
    public String bpi = "";
    public String bpj = "";
    public String bpk = "";

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
        this.bph = cVar.Kt().getString("aiapp_extra_need_download", "");
        this.bpi = cVar.aSQ;
        this.bpk = cVar.aSM;
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
        this.mSource = bVar.KF();
        this.bph = bVar.Kt().getString("aiapp_extra_need_download", "");
        this.bpi = bVar.KG();
        this.bpk = bVar.getPage();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b FE = com.baidu.swan.apps.w.e.LE().FE();
            String a = com.baidu.swan.apps.swancore.b.a(this.bpe, this.mFrom == "swangame" ? 1 : 0);
            if (FE != null && FE.AK() != null) {
                com.baidu.swan.apps.v.b.b AK = FE.AK();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = FE.getVersion();
                }
                if (TextUtils.isEmpty(this.bpf)) {
                    this.bpf = AK.getVersionCode();
                }
                if (AK.KJ() != null) {
                    this.bph = AK.KJ().getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.bpi)) {
                    this.bpi = AK.KG();
                }
                if (TextUtils.isEmpty(this.aSM) && !TextUtils.isEmpty(AK.getPage())) {
                    this.bpk = AK.getPage();
                }
            }
            this.bpg = SwanAppNetworkUtils.MQ().type;
            if (this.bpc == null) {
                this.bpc = new JSONObject();
            }
            this.bpc.put("swan", a);
            this.bpc.put("appversion", this.mAppVersion);
            this.bpc.put("thirdversion", this.bpf);
            this.bpc.put("net", this.bpg);
            this.bpc.put("needdown", this.bph);
            this.bpc.put("scheme", this.bpi);
            this.bpc.put("page", this.bpk);
            if (!TextUtils.isEmpty(this.bpj)) {
                this.bpc.put("canceltime", this.bpj);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bpc + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
