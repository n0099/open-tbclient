package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends e {
    public String dEC;
    public SwanCoreVersion dLx;
    public String mAppVersion = "";
    public String dLy = "";
    public String dLz = "";
    public String dLA = "";
    public String dLB = "";
    public String dLC = "";
    public String mScheme = "";
    public String dLD = "";
    public String dLE = "";
    public String dLF = "";
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
        this.mSource = eVar.aza();
        this.dLA = eVar.azg().getString("aiapp_extra_need_download", "");
        this.dLC = eVar.azg().getString("aiapp_extra_preset_pkg", "");
        this.dLB = eVar.azg().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.azc();
        this.dLF = eVar.getPage();
        this.dEC = eVar.azt();
    }

    public void sU(String str) {
        this.dEC = str;
    }

    public String azt() {
        return this.dEC;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e aos = com.baidu.swan.apps.v.f.aAl().aos();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dLx, this.mFrom == "swangame" ? 1 : 0);
            if (aos != null && aos.afZ() != null) {
                b.a afZ = aos.afZ();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = aos.getVersion();
                }
                if (TextUtils.isEmpty(this.dLy)) {
                    this.dLy = afZ.getVersionCode();
                }
                if (afZ.azf() != null) {
                    this.dLA = afZ.azf().getString("aiapp_extra_need_download", "");
                    this.dLC = afZ.azg().getString("aiapp_extra_preset_pkg", "0");
                    this.dLB = afZ.azg().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = afZ.azc();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.sH(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(afZ.getPage())) {
                    this.dLF = afZ.getPage();
                }
                this.dLF = com.baidu.swan.apps.statistic.g.sH(this.dLF);
                if (TextUtils.isEmpty(this.dEC)) {
                    this.dEC = afZ.azt();
                }
            }
            this.dLz = SwanAppNetworkUtils.aDf().type;
            if (this.dLv == null) {
                this.dLv = new JSONObject();
            }
            this.dLv.put(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, a2);
            this.dLv.put("appversion", this.mAppVersion);
            this.dLv.put("thirdversion", this.dLy);
            this.dLv.put("net", this.dLz);
            this.dLv.put("needdown", this.dLA);
            this.dLv.put("preset", this.dLC);
            this.dLv.put("isPreDownloading", this.dLB);
            this.dLv.put("scheme", this.mScheme);
            this.dLv.put("page", this.dLF);
            this.dLv.put("error_code", this.mErrorCode);
            this.dLv.put(Constant.KEY_LAUNCHID, this.dEC);
            if (!TextUtils.isEmpty(this.dLD)) {
                this.dLv.put("canceltime", this.dLD);
            }
            if (!TextUtils.isEmpty(this.dLE)) {
                this.dLv.put("successtime", this.dLE);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dLv + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
