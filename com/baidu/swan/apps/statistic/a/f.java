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
/* loaded from: classes8.dex */
public class f extends e {
    public String dGd;
    public SwanCoreVersion dMY;
    public String mAppVersion = "";
    public String dMZ = "";
    public String dNa = "";
    public String dNb = "";
    public String dNc = "";
    public String dNd = "";
    public String mScheme = "";
    public String dNe = "";
    public String dNf = "";
    public String dNg = "";
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
        this.mSource = eVar.azd();
        this.dNb = eVar.azj().getString("aiapp_extra_need_download", "");
        this.dNd = eVar.azj().getString("aiapp_extra_preset_pkg", "");
        this.dNc = eVar.azj().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.azf();
        this.dNg = eVar.getPage();
        this.dGd = eVar.azw();
    }

    public void tb(String str) {
        this.dGd = str;
    }

    public String azw() {
        return this.dGd;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e aov = com.baidu.swan.apps.v.f.aAo().aov();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dMY, this.mFrom == "swangame" ? 1 : 0);
            if (aov != null && aov.agc() != null) {
                b.a agc = aov.agc();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = aov.getVersion();
                }
                if (TextUtils.isEmpty(this.dMZ)) {
                    this.dMZ = agc.getVersionCode();
                }
                if (agc.azi() != null) {
                    this.dNb = agc.azi().getString("aiapp_extra_need_download", "");
                    this.dNd = agc.azj().getString("aiapp_extra_preset_pkg", "0");
                    this.dNc = agc.azj().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = agc.azf();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.sO(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(agc.getPage())) {
                    this.dNg = agc.getPage();
                }
                this.dNg = com.baidu.swan.apps.statistic.g.sO(this.dNg);
                if (TextUtils.isEmpty(this.dGd)) {
                    this.dGd = agc.azw();
                }
            }
            this.dNa = SwanAppNetworkUtils.aDi().type;
            if (this.dMW == null) {
                this.dMW = new JSONObject();
            }
            this.dMW.put(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, a2);
            this.dMW.put("appversion", this.mAppVersion);
            this.dMW.put("thirdversion", this.dMZ);
            this.dMW.put("net", this.dNa);
            this.dMW.put("needdown", this.dNb);
            this.dMW.put("preset", this.dNd);
            this.dMW.put("isPreDownloading", this.dNc);
            this.dMW.put("scheme", this.mScheme);
            this.dMW.put("page", this.dNg);
            this.dMW.put("error_code", this.mErrorCode);
            this.dMW.put(Constant.KEY_LAUNCHID, this.dGd);
            if (!TextUtils.isEmpty(this.dNe)) {
                this.dMW.put("canceltime", this.dNe);
            }
            if (!TextUtils.isEmpty(this.dNf)) {
                this.dMW.put("successtime", this.dNf);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dMW + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
