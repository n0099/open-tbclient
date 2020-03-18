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
    public String bPF;
    public SwanCoreVersion bVz;
    public String mAppVersion = "";
    public String bVA = "";
    public String bVB = "";
    public String bVC = "";
    public String bVD = "";
    public String mScheme = "";
    public String bVE = "";
    public String bVF = "";
    public String bVG = "";
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
        this.mSource = eVar.VM();
        this.bVC = eVar.VS().getString("aiapp_extra_need_download", "");
        this.bVD = eVar.VS().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.VO();
        this.bVG = eVar.getPage();
        this.bPF = eVar.Wf();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e OD = com.baidu.swan.apps.y.f.WV().OD();
            String a = com.baidu.swan.apps.swancore.b.a(this.bVz, this.mFrom == "swangame" ? 1 : 0);
            if (OD != null && OD.GJ() != null) {
                b.a GJ = OD.GJ();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = OD.getVersion();
                }
                if (TextUtils.isEmpty(this.bVA)) {
                    this.bVA = GJ.getVersionCode();
                }
                if (GJ.VR() != null) {
                    this.bVC = GJ.VR().getString("aiapp_extra_need_download", "");
                    this.bVD = GJ.VS().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = GJ.VO();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(GJ.getPage())) {
                    this.bVG = GJ.getPage();
                }
                if (TextUtils.isEmpty(this.bPF)) {
                    this.bPF = GJ.Wf();
                }
            }
            this.bVB = SwanAppNetworkUtils.Zc().type;
            if (this.bVx == null) {
                this.bVx = new JSONObject();
            }
            this.bVx.put("swan", a);
            this.bVx.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.bVx.put("thirdversion", this.bVA);
            this.bVx.put("net", this.bVB);
            this.bVx.put("needdown", this.bVC);
            this.bVx.put("preset", this.bVD);
            this.bVx.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.bVx.put("page", this.bVG);
            this.bVx.put("error_code", this.mErrorCode);
            this.bVx.put("launchid", this.bPF);
            if (!TextUtils.isEmpty(this.bVE)) {
                this.bVx.put("canceltime", this.bVE);
            }
            if (!TextUtils.isEmpty(this.bVF)) {
                this.bVx.put("successtime", this.bVF);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bVx + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
