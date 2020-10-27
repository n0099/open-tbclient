package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends e {
    public String dnp;
    public SwanCoreVersion dur;
    public String mAppVersion = "";
    public String dus = "";
    public String dut = "";
    public String duu = "";
    public String duv = "";
    public String duw = "";
    public String mScheme = "";
    public String dux = "";
    public String duy = "";
    public String duz = "";
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
        this.mSource = eVar.awd();
        this.duu = eVar.awj().getString("aiapp_extra_need_download", "");
        this.duw = eVar.awj().getString("aiapp_extra_preset_pkg", "");
        this.duv = eVar.awj().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.awf();
        this.duz = eVar.getPage();
        this.dnp = eVar.aww();
    }

    public void sZ(String str) {
        this.dnp = str;
    }

    public String aww() {
        return this.dnp;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e alC = com.baidu.swan.apps.v.f.axo().alC();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dur, this.mFrom == "swangame" ? 1 : 0);
            if (alC != null && alC.ado() != null) {
                b.a ado = alC.ado();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = alC.getVersion();
                }
                if (TextUtils.isEmpty(this.dus)) {
                    this.dus = ado.getVersionCode();
                }
                if (ado.awi() != null) {
                    this.duu = ado.awi().getString("aiapp_extra_need_download", "");
                    this.duw = ado.awj().getString("aiapp_extra_preset_pkg", "0");
                    this.duv = ado.awj().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = ado.awf();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.sM(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(ado.getPage())) {
                    this.duz = ado.getPage();
                }
                this.duz = com.baidu.swan.apps.statistic.g.sM(this.duz);
                if (TextUtils.isEmpty(this.dnp)) {
                    this.dnp = ado.aww();
                }
            }
            this.dut = SwanAppNetworkUtils.aAh().type;
            if (this.dup == null) {
                this.dup = new JSONObject();
            }
            this.dup.put("swan", a2);
            this.dup.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.dup.put("thirdversion", this.dus);
            this.dup.put("net", this.dut);
            this.dup.put("needdown", this.duu);
            this.dup.put("preset", this.duw);
            this.dup.put("isPreDownloading", this.duv);
            this.dup.put("scheme", this.mScheme);
            this.dup.put("page", this.duz);
            this.dup.put("error_code", this.mErrorCode);
            this.dup.put("launchid", this.dnp);
            if (!TextUtils.isEmpty(this.dux)) {
                this.dup.put("canceltime", this.dux);
            }
            if (!TextUtils.isEmpty(this.duy)) {
                this.dup.put("successtime", this.duy);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dup + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
