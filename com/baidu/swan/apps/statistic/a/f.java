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
    public String dCy;
    public SwanCoreVersion dJt;
    public String mAppVersion = "";
    public String dJu = "";
    public String dJv = "";
    public String dJw = "";
    public String dJx = "";
    public String dJy = "";
    public String mScheme = "";
    public String dJz = "";
    public String dJA = "";
    public String dJB = "";
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
        this.mSource = eVar.ayC();
        this.dJw = eVar.ayI().getString("aiapp_extra_need_download", "");
        this.dJy = eVar.ayI().getString("aiapp_extra_preset_pkg", "");
        this.dJx = eVar.ayI().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.ayE();
        this.dJB = eVar.getPage();
        this.dCy = eVar.ayV();
    }

    public void sB(String str) {
        this.dCy = str;
    }

    public String ayV() {
        return this.dCy;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e anU = com.baidu.swan.apps.v.f.azN().anU();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dJt, this.mFrom == "swangame" ? 1 : 0);
            if (anU != null && anU.afB() != null) {
                b.a afB = anU.afB();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = anU.getVersion();
                }
                if (TextUtils.isEmpty(this.dJu)) {
                    this.dJu = afB.getVersionCode();
                }
                if (afB.ayH() != null) {
                    this.dJw = afB.ayH().getString("aiapp_extra_need_download", "");
                    this.dJy = afB.ayI().getString("aiapp_extra_preset_pkg", "0");
                    this.dJx = afB.ayI().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = afB.ayE();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.sn(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(afB.getPage())) {
                    this.dJB = afB.getPage();
                }
                this.dJB = com.baidu.swan.apps.statistic.g.sn(this.dJB);
                if (TextUtils.isEmpty(this.dCy)) {
                    this.dCy = afB.ayV();
                }
            }
            this.dJv = SwanAppNetworkUtils.aCJ().type;
            if (this.dJr == null) {
                this.dJr = new JSONObject();
            }
            this.dJr.put(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, a2);
            this.dJr.put("appversion", this.mAppVersion);
            this.dJr.put("thirdversion", this.dJu);
            this.dJr.put("net", this.dJv);
            this.dJr.put("needdown", this.dJw);
            this.dJr.put("preset", this.dJy);
            this.dJr.put("isPreDownloading", this.dJx);
            this.dJr.put("scheme", this.mScheme);
            this.dJr.put("page", this.dJB);
            this.dJr.put("error_code", this.mErrorCode);
            this.dJr.put(Constant.KEY_LAUNCHID, this.dCy);
            if (!TextUtils.isEmpty(this.dJz)) {
                this.dJr.put("canceltime", this.dJz);
            }
            if (!TextUtils.isEmpty(this.dJA)) {
                this.dJr.put("successtime", this.dJA);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dJr + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
