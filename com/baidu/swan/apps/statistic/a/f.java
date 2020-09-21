package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends e {
    public String cSI;
    public SwanCoreVersion cZF;
    public String mAppVersion = "";
    public String cZG = "";
    public String cZH = "";
    public String cZI = "";
    public String cZJ = "";
    public String cZK = "";
    public String mScheme = "";
    public String cZL = "";
    public String cZM = "";
    public String cZN = "";
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
        this.mSource = eVar.arx();
        this.cZI = eVar.arD().getString("aiapp_extra_need_download", "");
        this.cZK = eVar.arD().getString("aiapp_extra_preset_pkg", "");
        this.cZJ = eVar.arD().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.arz();
        this.cZN = eVar.getPage();
        this.cSI = eVar.arQ();
    }

    public void rT(String str) {
        this.cSI = str;
    }

    public String arQ() {
        return this.cSI;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e agX = com.baidu.swan.apps.v.f.asJ().agX();
            String a = com.baidu.swan.apps.swancore.b.a(this.cZF, this.mFrom == "swangame" ? 1 : 0);
            if (agX != null && agX.YI() != null) {
                b.a YI = agX.YI();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = agX.getVersion();
                }
                if (TextUtils.isEmpty(this.cZG)) {
                    this.cZG = YI.getVersionCode();
                }
                if (YI.arC() != null) {
                    this.cZI = YI.arC().getString("aiapp_extra_need_download", "");
                    this.cZK = YI.arD().getString("aiapp_extra_preset_pkg", "0");
                    this.cZJ = YI.arD().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = YI.arz();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.rG(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(YI.getPage())) {
                    this.cZN = YI.getPage();
                }
                this.cZN = com.baidu.swan.apps.statistic.g.rG(this.cZN);
                if (TextUtils.isEmpty(this.cSI)) {
                    this.cSI = YI.arQ();
                }
            }
            this.cZH = SwanAppNetworkUtils.avC().type;
            if (this.cZD == null) {
                this.cZD = new JSONObject();
            }
            this.cZD.put("swan", a);
            this.cZD.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cZD.put("thirdversion", this.cZG);
            this.cZD.put("net", this.cZH);
            this.cZD.put("needdown", this.cZI);
            this.cZD.put("preset", this.cZK);
            this.cZD.put("isPreDownloading", this.cZJ);
            this.cZD.put("scheme", this.mScheme);
            this.cZD.put("page", this.cZN);
            this.cZD.put("error_code", this.mErrorCode);
            this.cZD.put("launchid", this.cSI);
            if (!TextUtils.isEmpty(this.cZL)) {
                this.cZD.put("canceltime", this.cZL);
            }
            if (!TextUtils.isEmpty(this.cZM)) {
                this.cZD.put("successtime", this.cZM);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cZD + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
