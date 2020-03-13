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
    public String bPu;
    public SwanCoreVersion bVo;
    public String mAppVersion = "";
    public String bVp = "";
    public String bVq = "";
    public String bVr = "";
    public String bVs = "";
    public String mScheme = "";
    public String bVt = "";
    public String bVu = "";
    public String bVv = "";
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
        this.mSource = eVar.VJ();
        this.bVr = eVar.VP().getString("aiapp_extra_need_download", "");
        this.bVs = eVar.VP().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.VL();
        this.bVv = eVar.getPage();
        this.bPu = eVar.Wc();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e OA = com.baidu.swan.apps.y.f.WS().OA();
            String a = com.baidu.swan.apps.swancore.b.a(this.bVo, this.mFrom == "swangame" ? 1 : 0);
            if (OA != null && OA.GE() != null) {
                b.a GE = OA.GE();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = OA.getVersion();
                }
                if (TextUtils.isEmpty(this.bVp)) {
                    this.bVp = GE.getVersionCode();
                }
                if (GE.VO() != null) {
                    this.bVr = GE.VO().getString("aiapp_extra_need_download", "");
                    this.bVs = GE.VP().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = GE.VL();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(GE.getPage())) {
                    this.bVv = GE.getPage();
                }
                if (TextUtils.isEmpty(this.bPu)) {
                    this.bPu = GE.Wc();
                }
            }
            this.bVq = SwanAppNetworkUtils.YZ().type;
            if (this.bVm == null) {
                this.bVm = new JSONObject();
            }
            this.bVm.put("swan", a);
            this.bVm.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.bVm.put("thirdversion", this.bVp);
            this.bVm.put("net", this.bVq);
            this.bVm.put("needdown", this.bVr);
            this.bVm.put("preset", this.bVs);
            this.bVm.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.bVm.put("page", this.bVv);
            this.bVm.put("error_code", this.mErrorCode);
            this.bVm.put("launchid", this.bPu);
            if (!TextUtils.isEmpty(this.bVt)) {
                this.bVm.put("canceltime", this.bVt);
            }
            if (!TextUtils.isEmpty(this.bVu)) {
                this.bVm.put("successtime", this.bVu);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bVm + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
