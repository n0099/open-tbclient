package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends e {
    public String drE;
    public SwanCoreVersion dyC;
    public String mAppVersion = "";
    public String dyD = "";
    public String dyE = "";
    public String dyF = "";
    public String dyG = "";
    public String dyH = "";
    public String mScheme = "";
    public String dyI = "";
    public String dyJ = "";
    public String dyK = "";
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
        this.mSource = eVar.axV();
        this.dyF = eVar.ayb().getString("aiapp_extra_need_download", "");
        this.dyH = eVar.ayb().getString("aiapp_extra_preset_pkg", "");
        this.dyG = eVar.ayb().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.axX();
        this.dyK = eVar.getPage();
        this.drE = eVar.ayo();
    }

    public void ti(String str) {
        this.drE = str;
    }

    public String ayo() {
        return this.drE;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e anu = com.baidu.swan.apps.v.f.azg().anu();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dyC, this.mFrom == "swangame" ? 1 : 0);
            if (anu != null && anu.afg() != null) {
                b.a afg = anu.afg();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = anu.getVersion();
                }
                if (TextUtils.isEmpty(this.dyD)) {
                    this.dyD = afg.getVersionCode();
                }
                if (afg.aya() != null) {
                    this.dyF = afg.aya().getString("aiapp_extra_need_download", "");
                    this.dyH = afg.ayb().getString("aiapp_extra_preset_pkg", "0");
                    this.dyG = afg.ayb().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = afg.axX();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.sV(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(afg.getPage())) {
                    this.dyK = afg.getPage();
                }
                this.dyK = com.baidu.swan.apps.statistic.g.sV(this.dyK);
                if (TextUtils.isEmpty(this.drE)) {
                    this.drE = afg.ayo();
                }
            }
            this.dyE = SwanAppNetworkUtils.aBZ().type;
            if (this.dyA == null) {
                this.dyA = new JSONObject();
            }
            this.dyA.put("swan", a2);
            this.dyA.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.dyA.put("thirdversion", this.dyD);
            this.dyA.put("net", this.dyE);
            this.dyA.put("needdown", this.dyF);
            this.dyA.put("preset", this.dyH);
            this.dyA.put("isPreDownloading", this.dyG);
            this.dyA.put("scheme", this.mScheme);
            this.dyA.put("page", this.dyK);
            this.dyA.put("error_code", this.mErrorCode);
            this.dyA.put("launchid", this.drE);
            if (!TextUtils.isEmpty(this.dyI)) {
                this.dyA.put("canceltime", this.dyI);
            }
            if (!TextUtils.isEmpty(this.dyJ)) {
                this.dyA.put("successtime", this.dyJ);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dyA + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
