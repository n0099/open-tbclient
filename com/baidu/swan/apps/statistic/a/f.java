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
    public String deQ;
    public SwanCoreVersion dlP;
    public String mAppVersion = "";
    public String dlQ = "";
    public String dlR = "";
    public String dlS = "";
    public String dlT = "";
    public String dlU = "";
    public String mScheme = "";
    public String dlV = "";
    public String dlW = "";
    public String dlX = "";
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
        this.mSource = eVar.auj();
        this.dlS = eVar.aup().getString("aiapp_extra_need_download", "");
        this.dlU = eVar.aup().getString("aiapp_extra_preset_pkg", "");
        this.dlT = eVar.aup().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aul();
        this.dlX = eVar.getPage();
        this.deQ = eVar.auC();
    }

    public void sG(String str) {
        this.deQ = str;
    }

    public String auC() {
        return this.deQ;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e ajI = com.baidu.swan.apps.v.f.avu().ajI();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dlP, this.mFrom == "swangame" ? 1 : 0);
            if (ajI != null && ajI.abu() != null) {
                b.a abu = ajI.abu();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = ajI.getVersion();
                }
                if (TextUtils.isEmpty(this.dlQ)) {
                    this.dlQ = abu.getVersionCode();
                }
                if (abu.auo() != null) {
                    this.dlS = abu.auo().getString("aiapp_extra_need_download", "");
                    this.dlU = abu.aup().getString("aiapp_extra_preset_pkg", "0");
                    this.dlT = abu.aup().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = abu.aul();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.st(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(abu.getPage())) {
                    this.dlX = abu.getPage();
                }
                this.dlX = com.baidu.swan.apps.statistic.g.st(this.dlX);
                if (TextUtils.isEmpty(this.deQ)) {
                    this.deQ = abu.auC();
                }
            }
            this.dlR = SwanAppNetworkUtils.ayn().type;
            if (this.dlN == null) {
                this.dlN = new JSONObject();
            }
            this.dlN.put("swan", a2);
            this.dlN.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.dlN.put("thirdversion", this.dlQ);
            this.dlN.put("net", this.dlR);
            this.dlN.put("needdown", this.dlS);
            this.dlN.put("preset", this.dlU);
            this.dlN.put("isPreDownloading", this.dlT);
            this.dlN.put("scheme", this.mScheme);
            this.dlN.put("page", this.dlX);
            this.dlN.put("error_code", this.mErrorCode);
            this.dlN.put("launchid", this.deQ);
            if (!TextUtils.isEmpty(this.dlV)) {
                this.dlN.put("canceltime", this.dlV);
            }
            if (!TextUtils.isEmpty(this.dlW)) {
                this.dlN.put("successtime", this.dlW);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dlN + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
