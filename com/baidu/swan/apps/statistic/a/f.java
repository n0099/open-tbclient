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
    public String cQI;
    public SwanCoreVersion cXF;
    public String mAppVersion = "";
    public String cXG = "";
    public String cXH = "";
    public String cXI = "";
    public String cXJ = "";
    public String cXK = "";
    public String mScheme = "";
    public String cXL = "";
    public String cXM = "";
    public String cXN = "";
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
        this.cXI = eVar.aqT().getString("aiapp_extra_need_download", "");
        this.cXK = eVar.aqT().getString("aiapp_extra_preset_pkg", "");
        this.cXJ = eVar.aqT().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aqP();
        this.cXN = eVar.getPage();
        this.cQI = eVar.arg();
    }

    public void rA(String str) {
        this.cQI = str;
    }

    public String arg() {
        return this.cQI;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e agn = com.baidu.swan.apps.v.f.arY().agn();
            String a = com.baidu.swan.apps.swancore.b.a(this.cXF, this.mFrom == "swangame" ? 1 : 0);
            if (agn != null && agn.XZ() != null) {
                b.a XZ = agn.XZ();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = agn.getVersion();
                }
                if (TextUtils.isEmpty(this.cXG)) {
                    this.cXG = XZ.getVersionCode();
                }
                if (XZ.aqS() != null) {
                    this.cXI = XZ.aqS().getString("aiapp_extra_need_download", "");
                    this.cXK = XZ.aqT().getString("aiapp_extra_preset_pkg", "0");
                    this.cXJ = XZ.aqT().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = XZ.aqP();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.rn(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(XZ.getPage())) {
                    this.cXN = XZ.getPage();
                }
                this.cXN = com.baidu.swan.apps.statistic.g.rn(this.cXN);
                if (TextUtils.isEmpty(this.cQI)) {
                    this.cQI = XZ.arg();
                }
            }
            this.cXH = SwanAppNetworkUtils.auT().type;
            if (this.cXD == null) {
                this.cXD = new JSONObject();
            }
            this.cXD.put("swan", a);
            this.cXD.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cXD.put("thirdversion", this.cXG);
            this.cXD.put("net", this.cXH);
            this.cXD.put("needdown", this.cXI);
            this.cXD.put("preset", this.cXK);
            this.cXD.put("isPreDownloading", this.cXJ);
            this.cXD.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cXD.put("page", this.cXN);
            this.cXD.put("error_code", this.mErrorCode);
            this.cXD.put("launchid", this.cQI);
            if (!TextUtils.isEmpty(this.cXL)) {
                this.cXD.put("canceltime", this.cXL);
            }
            if (!TextUtils.isEmpty(this.cXM)) {
                this.cXD.put("successtime", this.cXM);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cXD + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
