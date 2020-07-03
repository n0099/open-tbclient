package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends e {
    public String cES;
    public SwanCoreVersion cLg;
    public String mAppVersion = "";
    public String cLh = "";
    public String cLi = "";
    public String cLj = "";
    public String cLk = "";
    public String cLl = "";
    public String mScheme = "";
    public String cLm = "";
    public String cLn = "";
    public String cLo = "";
    public String mErrorCode = "";

    public f() {
        com.baidu.swan.apps.statistic.g.a(this);
        com.baidu.swan.apps.statistic.g.b(this);
        com.baidu.swan.apps.statistic.g.c(this);
    }

    public void b(com.baidu.swan.apps.v.b.e eVar) {
        d(eVar);
    }

    public void c(com.baidu.swan.apps.v.b.e eVar) {
        d(eVar);
    }

    public void d(com.baidu.swan.apps.v.b.e eVar) {
        if (eVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.mAppId = eVar.getAppId();
        this.mSource = eVar.ahQ();
        this.cLj = eVar.ahW().getString("aiapp_extra_need_download", "");
        this.cLl = eVar.ahW().getString("aiapp_extra_preset_pkg", "");
        this.cLk = eVar.ahW().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.ahS();
        this.cLo = eVar.getPage();
        this.cES = eVar.aij();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e aai = com.baidu.swan.apps.w.f.ajb().aai();
            String a = com.baidu.swan.apps.swancore.b.a(this.cLg, this.mFrom == "swangame" ? 1 : 0);
            if (aai != null && aai.RP() != null) {
                b.a RP = aai.RP();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = aai.getVersion();
                }
                if (TextUtils.isEmpty(this.cLh)) {
                    this.cLh = RP.getVersionCode();
                }
                if (RP.ahV() != null) {
                    this.cLj = RP.ahV().getString("aiapp_extra_need_download", "");
                    this.cLl = RP.ahW().getString("aiapp_extra_preset_pkg", "0");
                    this.cLk = RP.ahW().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = RP.ahS();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.oD(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(RP.getPage())) {
                    this.cLo = RP.getPage();
                }
                this.cLo = com.baidu.swan.apps.statistic.g.oD(this.cLo);
                if (TextUtils.isEmpty(this.cES)) {
                    this.cES = RP.aij();
                }
            }
            this.cLi = SwanAppNetworkUtils.alG().type;
            if (this.cLe == null) {
                this.cLe = new JSONObject();
            }
            this.cLe.put("swan", a);
            this.cLe.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cLe.put("thirdversion", this.cLh);
            this.cLe.put("net", this.cLi);
            this.cLe.put("needdown", this.cLj);
            this.cLe.put("preset", this.cLl);
            this.cLe.put("isPreDownloading", this.cLk);
            this.cLe.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cLe.put("page", this.cLo);
            this.cLe.put("error_code", this.mErrorCode);
            this.cLe.put("launchid", this.cES);
            if (!TextUtils.isEmpty(this.cLm)) {
                this.cLe.put("canceltime", this.cLm);
            }
            if (!TextUtils.isEmpty(this.cLn)) {
                this.cLe.put("successtime", this.cLn);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cLe + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
