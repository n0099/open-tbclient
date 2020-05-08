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
/* loaded from: classes11.dex */
public class f extends e {
    public String cox;
    public SwanCoreVersion cux;
    public String mAppVersion = "";
    public String cuy = "";
    public String cuz = "";
    public String cuA = "";
    public String cuB = "";
    public String mScheme = "";
    public String cuC = "";
    public String cuD = "";
    public String cuE = "";
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
        this.mSource = eVar.adA();
        this.cuA = eVar.adG().getString("aiapp_extra_need_download", "");
        this.cuB = eVar.adG().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.adC();
        this.cuE = eVar.getPage();
        this.cox = eVar.adT();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e Wq = com.baidu.swan.apps.y.f.aeJ().Wq();
            String a = com.baidu.swan.apps.swancore.b.a(this.cux, this.mFrom == "swangame" ? 1 : 0);
            if (Wq != null && Wq.Ov() != null) {
                b.a Ov = Wq.Ov();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = Wq.getVersion();
                }
                if (TextUtils.isEmpty(this.cuy)) {
                    this.cuy = Ov.getVersionCode();
                }
                if (Ov.adF() != null) {
                    this.cuA = Ov.adF().getString("aiapp_extra_need_download", "");
                    this.cuB = Ov.adG().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = Ov.adC();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(Ov.getPage())) {
                    this.cuE = Ov.getPage();
                }
                if (TextUtils.isEmpty(this.cox)) {
                    this.cox = Ov.adT();
                }
            }
            this.cuz = SwanAppNetworkUtils.ahh().type;
            if (this.cuv == null) {
                this.cuv = new JSONObject();
            }
            this.cuv.put("swan", a);
            this.cuv.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cuv.put("thirdversion", this.cuy);
            this.cuv.put("net", this.cuz);
            this.cuv.put("needdown", this.cuA);
            this.cuv.put("preset", this.cuB);
            this.cuv.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cuv.put("page", this.cuE);
            this.cuv.put("error_code", this.mErrorCode);
            this.cuv.put("launchid", this.cox);
            if (!TextUtils.isEmpty(this.cuC)) {
                this.cuv.put("canceltime", this.cuC);
            }
            if (!TextUtils.isEmpty(this.cuD)) {
                this.cuv.put("successtime", this.cuD);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cuv + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
