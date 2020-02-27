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
    public String bPs;
    public SwanCoreVersion bVm;
    public String mAppVersion = "";
    public String bVn = "";
    public String bVo = "";
    public String bVp = "";
    public String bVq = "";
    public String mScheme = "";
    public String bVr = "";
    public String bVs = "";
    public String bVt = "";
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
        this.mSource = eVar.VH();
        this.bVp = eVar.VN().getString("aiapp_extra_need_download", "");
        this.bVq = eVar.VN().getString("aiapp_extra_preset_pkg", "");
        this.mScheme = eVar.VJ();
        this.bVt = eVar.getPage();
        this.bPs = eVar.Wa();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.runtime.e Oy = com.baidu.swan.apps.y.f.WQ().Oy();
            String a = com.baidu.swan.apps.swancore.b.a(this.bVm, this.mFrom == "swangame" ? 1 : 0);
            if (Oy != null && Oy.GC() != null) {
                b.a GC = Oy.GC();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = Oy.getVersion();
                }
                if (TextUtils.isEmpty(this.bVn)) {
                    this.bVn = GC.getVersionCode();
                }
                if (GC.VM() != null) {
                    this.bVp = GC.VM().getString("aiapp_extra_need_download", "");
                    this.bVq = GC.VN().getString("aiapp_extra_preset_pkg", "0");
                }
                if (TextUtils.isEmpty(this.mScheme)) {
                    this.mScheme = GC.VJ();
                }
                if (TextUtils.isEmpty(this.mPage) && !TextUtils.isEmpty(GC.getPage())) {
                    this.bVt = GC.getPage();
                }
                if (TextUtils.isEmpty(this.bPs)) {
                    this.bPs = GC.Wa();
                }
            }
            this.bVo = SwanAppNetworkUtils.YX().type;
            if (this.bVk == null) {
                this.bVk = new JSONObject();
            }
            this.bVk.put("swan", a);
            this.bVk.put(ETAG.KEY_APP_VERSION, this.mAppVersion);
            this.bVk.put("thirdversion", this.bVn);
            this.bVk.put("net", this.bVo);
            this.bVk.put("needdown", this.bVp);
            this.bVk.put("preset", this.bVq);
            this.bVk.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            this.bVk.put("page", this.bVt);
            this.bVk.put("error_code", this.mErrorCode);
            this.bVk.put("launchid", this.bPs);
            if (!TextUtils.isEmpty(this.bVr)) {
                this.bVk.put("canceltime", this.bVr);
            }
            if (!TextUtils.isEmpty(this.bVs)) {
                this.bVk.put("successtime", this.bVs);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.bVk + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
