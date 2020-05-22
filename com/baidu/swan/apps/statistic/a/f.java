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
    public String cAi;
    public SwanCoreVersion cGw;
    public String mAppVersion = "";
    public String cGx = "";
    public String cGy = "";
    public String cGz = "";
    public String cGA = "";
    public String cGB = "";
    public String mScheme = "";
    public String cGC = "";
    public String cGD = "";
    public String cGE = "";
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
        this.mSource = eVar.agK();
        this.cGz = eVar.agQ().getString("aiapp_extra_need_download", "");
        this.cGB = eVar.agQ().getString("aiapp_extra_preset_pkg", "");
        this.cGA = eVar.agQ().getString("aiapp_extra_pkg_downloading", "0");
        this.mScheme = eVar.agM();
        this.cGE = eVar.getPage();
        this.cAi = eVar.ahd();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e Zc = com.baidu.swan.apps.w.f.ahV().Zc();
            String a = com.baidu.swan.apps.swancore.b.a(this.cGw, this.mFrom == "swangame" ? 1 : 0);
            if (Zc != null && Zc.QJ() != null) {
                b.a QJ = Zc.QJ();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = Zc.getVersion();
                }
                if (TextUtils.isEmpty(this.cGx)) {
                    this.cGx = QJ.getVersionCode();
                }
                if (QJ.agP() != null) {
                    this.cGz = QJ.agP().getString("aiapp_extra_need_download", "");
                    this.cGB = QJ.agQ().getString("aiapp_extra_preset_pkg", "0");
                    this.cGA = QJ.agQ().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = QJ.agM();
                }
                this.mScheme = com.baidu.swan.apps.statistic.g.ov(this.mScheme);
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(QJ.getPage())) {
                    this.cGE = QJ.getPage();
                }
                this.cGE = com.baidu.swan.apps.statistic.g.ov(this.cGE);
                if (TextUtils.isEmpty(this.cAi)) {
                    this.cAi = QJ.ahd();
                }
            }
            this.cGy = SwanAppNetworkUtils.akA().type;
            if (this.cGu == null) {
                this.cGu = new JSONObject();
            }
            this.cGu.put("swan", a);
            this.cGu.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cGu.put("thirdversion", this.cGx);
            this.cGu.put("net", this.cGy);
            this.cGu.put("needdown", this.cGz);
            this.cGu.put("preset", this.cGB);
            this.cGu.put("isPreDownloading", this.cGA);
            this.cGu.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cGu.put("page", this.cGE);
            this.cGu.put("error_code", this.mErrorCode);
            this.cGu.put("launchid", this.cAi);
            if (!TextUtils.isEmpty(this.cGC)) {
                this.cGu.put("canceltime", this.cGC);
            }
            if (!TextUtils.isEmpty(this.cGD)) {
                this.cGu.put("successtime", this.cGD);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cGu + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
