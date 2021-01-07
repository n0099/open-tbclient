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
    public String dHk;
    public SwanCoreVersion dOf;
    public String mAppVersion = "";
    public String dOg = "";
    public String dOh = "";
    public String dOi = "";
    public String dOj = "";
    public String dOk = "";
    public String mScheme = "";
    public String dOl = "";
    public String dOm = "";
    public String dOn = "";
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
        this.mSource = eVar.aCw();
        this.dOi = eVar.aCC().getString("aiapp_extra_need_download", "");
        this.dOk = eVar.aCC().getString("aiapp_extra_preset_pkg", "");
        this.dOj = eVar.aCC().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aCy();
        this.dOn = eVar.getPage();
        this.dHk = eVar.aCP();
    }

    public void tM(String str) {
        this.dHk = str;
    }

    public String aCP() {
        return this.dHk;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e arP = com.baidu.swan.apps.v.f.aDH().arP();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dOf, this.mFrom == "swangame" ? 1 : 0);
            if (arP != null && arP.ajv() != null) {
                b.a ajv = arP.ajv();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = arP.getVersion();
                }
                if (TextUtils.isEmpty(this.dOg)) {
                    this.dOg = ajv.getVersionCode();
                }
                if (ajv.aCB() != null) {
                    this.dOi = ajv.aCB().getString("aiapp_extra_need_download", "");
                    this.dOk = ajv.aCC().getString("aiapp_extra_preset_pkg", "0");
                    this.dOj = ajv.aCC().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = ajv.aCy();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.tz(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(ajv.getPage())) {
                    this.dOn = ajv.getPage();
                }
                this.dOn = com.baidu.swan.apps.statistic.g.tz(this.dOn);
                if (TextUtils.isEmpty(this.dHk)) {
                    this.dHk = ajv.aCP();
                }
            }
            this.dOh = SwanAppNetworkUtils.aGD().type;
            if (this.dOd == null) {
                this.dOd = new JSONObject();
            }
            this.dOd.put(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, a2);
            this.dOd.put("appversion", this.mAppVersion);
            this.dOd.put("thirdversion", this.dOg);
            this.dOd.put("net", this.dOh);
            this.dOd.put("needdown", this.dOi);
            this.dOd.put("preset", this.dOk);
            this.dOd.put("isPreDownloading", this.dOj);
            this.dOd.put("scheme", this.mScheme);
            this.dOd.put("page", this.dOn);
            this.dOd.put("error_code", this.mErrorCode);
            this.dOd.put(Constant.KEY_LAUNCHID, this.dHk);
            if (!TextUtils.isEmpty(this.dOl)) {
                this.dOd.put("canceltime", this.dOl);
            }
            if (!TextUtils.isEmpty(this.dOm)) {
                this.dOd.put("successtime", this.dOm);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dOd + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
