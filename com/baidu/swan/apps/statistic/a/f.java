package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends e {
    public String cQE;
    public SwanCoreVersion cXB;
    public String mAppVersion = "";
    public String cXC = "";
    public String cXD = "";
    public String cXE = "";
    public String cXF = "";
    public String cXG = "";
    public String mScheme = "";
    public String cXH = "";
    public String cXI = "";
    public String cXJ = "";
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
        this.mSource = eVar.aqN();
        this.cXE = eVar.aqT().getString("aiapp_extra_need_download", "");
        this.cXG = eVar.aqT().getString("aiapp_extra_preset_pkg", "");
        this.cXF = eVar.aqT().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aqP();
        this.cXJ = eVar.getPage();
        this.cQE = eVar.arg();
    }

    public void rz(String str) {
        this.cQE = str;
    }

    public String arg() {
        return this.cQE;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e agn = com.baidu.swan.apps.v.f.arY().agn();
            String a = com.baidu.swan.apps.swancore.b.a(this.cXB, this.mFrom == "swangame" ? 1 : 0);
            if (agn != null && agn.XZ() != null) {
                b.a XZ = agn.XZ();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = agn.getVersion();
                }
                if (TextUtils.isEmpty(this.cXC)) {
                    this.cXC = XZ.getVersionCode();
                }
                if (XZ.aqS() != null) {
                    this.cXE = XZ.aqS().getString("aiapp_extra_need_download", "");
                    this.cXG = XZ.aqT().getString("aiapp_extra_preset_pkg", "0");
                    this.cXF = XZ.aqT().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = XZ.aqP();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.rm(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(XZ.getPage())) {
                    this.cXJ = XZ.getPage();
                }
                this.cXJ = com.baidu.swan.apps.statistic.g.rm(this.cXJ);
                if (TextUtils.isEmpty(this.cQE)) {
                    this.cQE = XZ.arg();
                }
            }
            this.cXD = SwanAppNetworkUtils.auT().type;
            if (this.cXz == null) {
                this.cXz = new JSONObject();
            }
            this.cXz.put("swan", a);
            this.cXz.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cXz.put("thirdversion", this.cXC);
            this.cXz.put("net", this.cXD);
            this.cXz.put("needdown", this.cXE);
            this.cXz.put("preset", this.cXG);
            this.cXz.put("isPreDownloading", this.cXF);
            this.cXz.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cXz.put("page", this.cXJ);
            this.cXz.put("error_code", this.mErrorCode);
            this.cXz.put("launchid", this.cQE);
            if (!TextUtils.isEmpty(this.cXH)) {
                this.cXz.put("canceltime", this.cXH);
            }
            if (!TextUtils.isEmpty(this.cXI)) {
                this.cXz.put("successtime", this.cXI);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cXz + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
