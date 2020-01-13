package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.x.b.b;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends e {
    public String bLn;
    public SwanCoreVersion bRh;
    public String mAppVersion = "";
    public String bRi = "";
    public String bRj = "";
    public String bRk = "";
    public String bRl = "";
    public String mScheme = "";
    public String bRm = "";
    public String bRn = "";
    public String bRo = "";
    public String mErrorCode = "";

    public void b(com.baidu.swan.apps.x.b.e eVar) {
        d(eVar);
    }

    public void c(com.baidu.swan.apps.x.b.e eVar) {
        d(eVar);
    }

    public void d(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.mAppId = eVar.getAppId();
        this.mSource = eVar.Tt();
        this.bRk = eVar.Tz().getString("aiapp_extra_need_download", "");
        this.bRl = eVar.Tz().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.Tv();
        this.bRo = eVar.getPage();
        this.bLn = eVar.TM();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e Mk = com.baidu.swan.apps.y.f.UC().Mk();
            String a = com.baidu.swan.apps.swancore.b.a(this.bRh, this.mFrom == "swangame" ? 1 : 0);
            if (Mk != null && Mk.En() != null) {
                b.a En = Mk.En();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = Mk.getVersion();
                }
                if (TextUtils.isEmpty(this.bRi)) {
                    this.bRi = En.getVersionCode();
                }
                if (En.Ty() != null) {
                    this.bRk = En.Ty().getString("aiapp_extra_need_download", "");
                    this.bRl = En.Tz().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = En.Tv();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(En.getPage())) {
                    this.bRo = En.getPage();
                }
                if (TextUtils.isEmpty(this.bLn)) {
                    this.bLn = En.TM();
                }
            }
            this.bRj = SwanAppNetworkUtils.WJ().type;
            if (this.bRf == null) {
                this.bRf = new JSONObject();
            }
            this.bRf.put("swan", a);
            this.bRf.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.bRf.put("thirdversion", this.bRi);
            this.bRf.put("net", this.bRj);
            this.bRf.put("needdown", this.bRk);
            this.bRf.put("preset", this.bRl);
            this.bRf.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.bRf.put("page", this.bRo);
            this.bRf.put("error_code", this.mErrorCode);
            this.bRf.put("launchid", this.bLn);
            if (!TextUtils.isEmpty(this.bRm)) {
                this.bRf.put("canceltime", this.bRm);
            }
            if (!TextUtils.isEmpty(this.bRn)) {
                this.bRf.put("successtime", this.bRn);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bRf + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
