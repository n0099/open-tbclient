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
    public String bPt;
    public SwanCoreVersion bVn;
    public String mAppVersion = "";
    public String bVo = "";
    public String bVp = "";
    public String bVq = "";
    public String bVr = "";
    public String mScheme = "";
    public String bVs = "";
    public String bVt = "";
    public String bVu = "";
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
        this.bVq = eVar.VP().getString("aiapp_extra_need_download", "");
        this.bVr = eVar.VP().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.VL();
        this.bVu = eVar.getPage();
        this.bPt = eVar.Wc();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e OA = com.baidu.swan.apps.y.f.WS().OA();
            String a = com.baidu.swan.apps.swancore.b.a(this.bVn, this.mFrom == "swangame" ? 1 : 0);
            if (OA != null && OA.GE() != null) {
                b.a GE = OA.GE();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = OA.getVersion();
                }
                if (TextUtils.isEmpty(this.bVo)) {
                    this.bVo = GE.getVersionCode();
                }
                if (GE.VO() != null) {
                    this.bVq = GE.VO().getString("aiapp_extra_need_download", "");
                    this.bVr = GE.VP().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = GE.VL();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(GE.getPage())) {
                    this.bVu = GE.getPage();
                }
                if (TextUtils.isEmpty(this.bPt)) {
                    this.bPt = GE.Wc();
                }
            }
            this.bVp = SwanAppNetworkUtils.YZ().type;
            if (this.bVl == null) {
                this.bVl = new JSONObject();
            }
            this.bVl.put("swan", a);
            this.bVl.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.bVl.put("thirdversion", this.bVo);
            this.bVl.put("net", this.bVp);
            this.bVl.put("needdown", this.bVq);
            this.bVl.put("preset", this.bVr);
            this.bVl.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.bVl.put("page", this.bVu);
            this.bVl.put("error_code", this.mErrorCode);
            this.bVl.put("launchid", this.bPt);
            if (!TextUtils.isEmpty(this.bVs)) {
                this.bVl.put("canceltime", this.bVs);
            }
            if (!TextUtils.isEmpty(this.bVt)) {
                this.bVl.put("successtime", this.bVt);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bVl + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
