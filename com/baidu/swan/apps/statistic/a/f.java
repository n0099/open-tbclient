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
        this.mSource = eVar.aCv();
        this.dOi = eVar.aCB().getString("aiapp_extra_need_download", "");
        this.dOk = eVar.aCB().getString("aiapp_extra_preset_pkg", "");
        this.dOj = eVar.aCB().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aCx();
        this.dOn = eVar.getPage();
        this.dHk = eVar.aCO();
    }

    public void tM(String str) {
        this.dHk = str;
    }

    public String aCO() {
        return this.dHk;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e arO = com.baidu.swan.apps.v.f.aDG().arO();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dOf, this.mFrom == "swangame" ? 1 : 0);
            if (arO != null && arO.aju() != null) {
                b.a aju = arO.aju();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = arO.getVersion();
                }
                if (TextUtils.isEmpty(this.dOg)) {
                    this.dOg = aju.getVersionCode();
                }
                if (aju.aCA() != null) {
                    this.dOi = aju.aCA().getString("aiapp_extra_need_download", "");
                    this.dOk = aju.aCB().getString("aiapp_extra_preset_pkg", "0");
                    this.dOj = aju.aCB().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = aju.aCx();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.tz(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(aju.getPage())) {
                    this.dOn = aju.getPage();
                }
                this.dOn = com.baidu.swan.apps.statistic.g.tz(this.dOn);
                if (TextUtils.isEmpty(this.dHk)) {
                    this.dHk = aju.aCO();
                }
            }
            this.dOh = SwanAppNetworkUtils.aGC().type;
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
