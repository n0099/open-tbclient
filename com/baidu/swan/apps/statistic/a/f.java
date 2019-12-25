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
/* loaded from: classes9.dex */
public class f extends e {
    public String bKD;
    public SwanCoreVersion bQx;
    public String mAppVersion = "";
    public String bQy = "";
    public String bQz = "";
    public String bQA = "";
    public String bQB = "";
    public String mScheme = "";
    public String bQC = "";
    public String bQD = "";
    public String bQE = "";
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
        this.mSource = eVar.SW();
        this.bQA = eVar.Tc().getString("aiapp_extra_need_download", "");
        this.bQB = eVar.Tc().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.SY();
        this.bQE = eVar.getPage();
        this.bKD = eVar.Tp();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e LO = com.baidu.swan.apps.y.f.Uf().LO();
            String a = com.baidu.swan.apps.swancore.b.a(this.bQx, this.mFrom == "swangame" ? 1 : 0);
            if (LO != null && LO.DR() != null) {
                b.a DR = LO.DR();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = LO.getVersion();
                }
                if (TextUtils.isEmpty(this.bQy)) {
                    this.bQy = DR.getVersionCode();
                }
                if (DR.Tb() != null) {
                    this.bQA = DR.Tb().getString("aiapp_extra_need_download", "");
                    this.bQB = DR.Tc().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = DR.SY();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(DR.getPage())) {
                    this.bQE = DR.getPage();
                }
                if (TextUtils.isEmpty(this.bKD)) {
                    this.bKD = DR.Tp();
                }
            }
            this.bQz = SwanAppNetworkUtils.Wm().type;
            if (this.bQv == null) {
                this.bQv = new JSONObject();
            }
            this.bQv.put("swan", a);
            this.bQv.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.bQv.put("thirdversion", this.bQy);
            this.bQv.put("net", this.bQz);
            this.bQv.put("needdown", this.bQA);
            this.bQv.put("preset", this.bQB);
            this.bQv.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.bQv.put("page", this.bQE);
            this.bQv.put("error_code", this.mErrorCode);
            this.bQv.put("launchid", this.bKD);
            if (!TextUtils.isEmpty(this.bQC)) {
                this.bQv.put("canceltime", this.bQC);
            }
            if (!TextUtils.isEmpty(this.bQD)) {
                this.bQv.put("successtime", this.bQD);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bQv + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
