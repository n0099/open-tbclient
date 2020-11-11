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
    public SwanCoreVersion dAj;
    public String dtm;
    public String mAppVersion = "";
    public String dAk = "";
    public String dAl = "";
    public String dAm = "";
    public String dAn = "";
    public String dAo = "";
    public String mScheme = "";
    public String dAp = "";
    public String dAq = "";
    public String dAr = "";
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
        this.mSource = eVar.ayD();
        this.dAm = eVar.ayJ().getString("aiapp_extra_need_download", "");
        this.dAo = eVar.ayJ().getString("aiapp_extra_preset_pkg", "");
        this.dAn = eVar.ayJ().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.ayF();
        this.dAr = eVar.getPage();
        this.dtm = eVar.ayW();
    }

    public void tn(String str) {
        this.dtm = str;
    }

    public String ayW() {
        return this.dtm;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e aoc = com.baidu.swan.apps.v.f.azO().aoc();
            String a2 = com.baidu.swan.apps.swancore.b.a(this.dAj, this.mFrom == "swangame" ? 1 : 0);
            if (aoc != null && aoc.afO() != null) {
                b.a afO = aoc.afO();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = aoc.getVersion();
                }
                if (TextUtils.isEmpty(this.dAk)) {
                    this.dAk = afO.getVersionCode();
                }
                if (afO.ayI() != null) {
                    this.dAm = afO.ayI().getString("aiapp_extra_need_download", "");
                    this.dAo = afO.ayJ().getString("aiapp_extra_preset_pkg", "0");
                    this.dAn = afO.ayJ().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = afO.ayF();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.ta(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(afO.getPage())) {
                    this.dAr = afO.getPage();
                }
                this.dAr = com.baidu.swan.apps.statistic.g.ta(this.dAr);
                if (TextUtils.isEmpty(this.dtm)) {
                    this.dtm = afO.ayW();
                }
            }
            this.dAl = SwanAppNetworkUtils.aCH().type;
            if (this.dAh == null) {
                this.dAh = new JSONObject();
            }
            this.dAh.put("swan", a2);
            this.dAh.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.dAh.put("thirdversion", this.dAk);
            this.dAh.put("net", this.dAl);
            this.dAh.put("needdown", this.dAm);
            this.dAh.put("preset", this.dAo);
            this.dAh.put("isPreDownloading", this.dAn);
            this.dAh.put("scheme", this.mScheme);
            this.dAh.put("page", this.dAr);
            this.dAh.put("error_code", this.mErrorCode);
            this.dAh.put("launchid", this.dtm);
            if (!TextUtils.isEmpty(this.dAp)) {
                this.dAh.put("canceltime", this.dAp);
            }
            if (!TextUtils.isEmpty(this.dAq)) {
                this.dAh.put("successtime", this.dAq);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.dAh + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
