package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends e {
    public SwanCoreVersion dFB;
    public String dyF;
    public String mAppVersion = "";
    public String dFC = "";
    public String dFD = "";
    public String dFE = "";
    public String dFF = "";
    public String dFG = "";
    public String mScheme = "";
    public String dFH = "";
    public String dFI = "";
    public String dFJ = "";
    public String mErrorCode = "";

    public f() {
        com.baidu.swan.apps.statistic.g.a(this);
        com.baidu.swan.apps.statistic.g.b(this);
        com.baidu.swan.apps.statistic.g.c(this);
    }

    public void b(com.baidu.swan.apps.u.c.e eVar) {
        d(eVar);
    }

    public void c(com.baidu.swan.apps.u.c.e eVar) {
        d(eVar);
    }

    public void d(com.baidu.swan.apps.u.c.e eVar) {
        if (eVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.mAppId = eVar.getAppId();
        this.mSource = eVar.aBe();
        this.dFE = eVar.aBk().getString("aiapp_extra_need_download", "");
        this.dFG = eVar.aBk().getString("aiapp_extra_preset_pkg", "");
        this.dFF = eVar.aBk().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aBg();
        this.dFJ = eVar.getPage();
        this.dyF = eVar.aBx();
    }

    public void tP(String str) {
        this.dyF = str;
    }

    public String aBx() {
        return this.dyF;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e aqC = com.baidu.swan.apps.v.f.aCp().aqC();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dFB, this.mFrom == "swangame" ? 1 : 0);
            if (aqC != null && aqC.aio() != null) {
                b.a aio = aqC.aio();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = aqC.getVersion();
                }
                if (TextUtils.isEmpty(this.dFC)) {
                    this.dFC = aio.getVersionCode();
                }
                if (aio.aBj() != null) {
                    this.dFE = aio.aBj().getString("aiapp_extra_need_download", "");
                    this.dFG = aio.aBk().getString("aiapp_extra_preset_pkg", "0");
                    this.dFF = aio.aBk().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = aio.aBg();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.tC(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(aio.getPage())) {
                    this.dFJ = aio.getPage();
                }
                this.dFJ = com.baidu.swan.apps.statistic.g.tC(this.dFJ);
                if (TextUtils.isEmpty(this.dyF)) {
                    this.dyF = aio.aBx();
                }
            }
            this.dFD = SwanAppNetworkUtils.aFi().type;
            if (this.dFz == null) {
                this.dFz = new JSONObject();
            }
            this.dFz.put("swan", a2);
            this.dFz.put("appversion", this.mAppVersion);
            this.dFz.put("thirdversion", this.dFC);
            this.dFz.put("net", this.dFD);
            this.dFz.put("needdown", this.dFE);
            this.dFz.put("preset", this.dFG);
            this.dFz.put("isPreDownloading", this.dFF);
            this.dFz.put("scheme", this.mScheme);
            this.dFz.put("page", this.dFJ);
            this.dFz.put("error_code", this.mErrorCode);
            this.dFz.put(Constant.KEY_LAUNCHID, this.dyF);
            if (!TextUtils.isEmpty(this.dFH)) {
                this.dFz.put("canceltime", this.dFH);
            }
            if (!TextUtils.isEmpty(this.dFI)) {
                this.dFz.put("successtime", this.dFI);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dFz + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
