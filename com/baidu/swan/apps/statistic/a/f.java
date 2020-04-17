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
    public String cor;
    public SwanCoreVersion cup;
    public String mAppVersion = "";
    public String cuq = "";
    public String cus = "";
    public String cuu = "";
    public String cuv = "";
    public String mScheme = "";
    public String cuw = "";
    public String cux = "";
    public String cuy = "";
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
        this.mSource = eVar.adB();
        this.cuu = eVar.adH().getString("aiapp_extra_need_download", "");
        this.cuv = eVar.adH().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.adD();
        this.cuy = eVar.getPage();
        this.cor = eVar.adU();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e Wr = com.baidu.swan.apps.y.f.aeK().Wr();
            String a = com.baidu.swan.apps.swancore.b.a(this.cup, this.mFrom == "swangame" ? 1 : 0);
            if (Wr != null && Wr.Ow() != null) {
                b.a Ow = Wr.Ow();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = Wr.getVersion();
                }
                if (TextUtils.isEmpty(this.cuq)) {
                    this.cuq = Ow.getVersionCode();
                }
                if (Ow.adG() != null) {
                    this.cuu = Ow.adG().getString("aiapp_extra_need_download", "");
                    this.cuv = Ow.adH().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = Ow.adD();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(Ow.getPage())) {
                    this.cuy = Ow.getPage();
                }
                if (TextUtils.isEmpty(this.cor)) {
                    this.cor = Ow.adU();
                }
            }
            this.cus = SwanAppNetworkUtils.ahi().type;
            if (this.cun == null) {
                this.cun = new JSONObject();
            }
            this.cun.put("swan", a);
            this.cun.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.cun.put("thirdversion", this.cuq);
            this.cun.put("net", this.cus);
            this.cun.put("needdown", this.cuu);
            this.cun.put("preset", this.cuv);
            this.cun.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.cun.put("page", this.cuy);
            this.cun.put("error_code", this.mErrorCode);
            this.cun.put("launchid", this.cor);
            if (!TextUtils.isEmpty(this.cuw)) {
                this.cun.put("canceltime", this.cuw);
            }
            if (!TextUtils.isEmpty(this.cux)) {
                this.cun.put("successtime", this.cux);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.cun + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
