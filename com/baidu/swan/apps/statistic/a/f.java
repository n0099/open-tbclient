package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends e {
    public String cHF;
    public SwanCoreVersion cOB;
    public String mAppVersion = "";
    public String cOC = "";
    public String cOD = "";
    public String cOE = "";
    public String cOF = "";
    public String cOG = "";
    public String mScheme = "";
    public String cOH = "";
    public String cOI = "";
    public String cOJ = "";
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
        this.mSource = eVar.ajg();
        this.cOE = eVar.ajm().getString("aiapp_extra_need_download", "");
        this.cOG = eVar.ajm().getString("aiapp_extra_preset_pkg", "");
        this.cOF = eVar.ajm().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.aji();
        this.cOJ = eVar.getPage();
        this.cHF = eVar.ajz();
    }

    public void pz(String str) {
        this.cHF = str;
    }

    public String ajz() {
        return this.cHF;
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e aad = com.baidu.swan.apps.v.f.akr().aad();
            String a = com.baidu.swan.apps.swancore.b.a(this.cOB, this.mFrom == "swangame" ? 1 : 0);
            if (aad != null && aad.Se() != null) {
                b.a Se = aad.Se();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = aad.getVersion();
                }
                if (TextUtils.isEmpty(this.cOC)) {
                    this.cOC = Se.getVersionCode();
                }
                if (Se.ajl() != null) {
                    this.cOE = Se.ajl().getString("aiapp_extra_need_download", "");
                    this.cOG = Se.ajm().getString("aiapp_extra_preset_pkg", "0");
                    this.cOF = Se.ajm().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = Se.aji();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.pm(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(Se.getPage())) {
                    this.cOJ = Se.getPage();
                }
                this.cOJ = com.baidu.swan.apps.statistic.g.pm(this.cOJ);
                if (TextUtils.isEmpty(this.cHF)) {
                    this.cHF = Se.ajz();
                }
            }
            this.cOD = SwanAppNetworkUtils.amW().type;
            if (this.cOz == null) {
                this.cOz = new JSONObject();
            }
            this.cOz.put("swan", a);
            this.cOz.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cOz.put("thirdversion", this.cOC);
            this.cOz.put("net", this.cOD);
            this.cOz.put("needdown", this.cOE);
            this.cOz.put("preset", this.cOG);
            this.cOz.put("isPreDownloading", this.cOF);
            this.cOz.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cOz.put("page", this.cOJ);
            this.cOz.put("error_code", this.mErrorCode);
            this.cOz.put("launchid", this.cHF);
            if (!TextUtils.isEmpty(this.cOH)) {
                this.cOz.put("canceltime", this.cOH);
            }
            if (!TextUtils.isEmpty(this.cOI)) {
                this.cOz.put("successtime", this.cOI);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cOz + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
