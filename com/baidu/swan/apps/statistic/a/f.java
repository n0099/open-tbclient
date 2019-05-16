package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends e {
    public SwanCoreVersion aVk;
    public String mAppVersion = "";
    public String aVl = "";
    public String aVm = "";
    public String aVn = "";
    public String aVo = "";
    public String aVp = "";
    public String aVq = "";

    public void d(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchparams is null");
                return;
            }
            return;
        }
        this.mAppId = cVar.mAppId;
        this.mSource = cVar.mFrom;
        this.aVn = cVar.EK().getString("aiapp_extra_need_download", "");
        this.aVo = cVar.ayP;
        this.aVq = cVar.ayL;
    }

    public void t(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.mAppId = bVar.getAppId();
        this.mSource = bVar.EW();
        this.aVn = bVar.EK().getString("aiapp_extra_need_download", "");
        this.aVo = bVar.EX();
        this.aVq = bVar.getPage();
    }

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        try {
            com.baidu.swan.apps.ae.b zX = com.baidu.swan.apps.w.e.FV().zX();
            String a = com.baidu.swan.apps.swancore.b.a(this.aVk, this.mFrom == "swangame" ? 1 : 0);
            if (zX != null && zX.vk() != null) {
                com.baidu.swan.apps.v.b.b vk = zX.vk();
                if (TextUtils.isEmpty(this.mAppVersion)) {
                    this.mAppVersion = zX.getVersion();
                }
                if (TextUtils.isEmpty(this.aVl)) {
                    this.aVl = vk.getVersionCode();
                }
                if (vk.Fa() != null) {
                    this.aVn = vk.Fa().getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.aVo)) {
                    this.aVo = vk.EX();
                }
                if (TextUtils.isEmpty(this.ayL) && !TextUtils.isEmpty(vk.getPage())) {
                    this.aVq = vk.getPage();
                }
            }
            this.aVm = SwanAppNetworkUtils.Hg().type;
            if (this.aVi == null) {
                this.aVi = new JSONObject();
            }
            this.aVi.put("swan", a);
            this.aVi.put("appversion", this.mAppVersion);
            this.aVi.put("thirdversion", this.aVl);
            this.aVi.put("net", this.aVm);
            this.aVi.put("needdown", this.aVn);
            this.aVi.put("scheme", this.aVo);
            this.aVi.put("page", this.aVq);
            if (!TextUtils.isEmpty(this.aVp)) {
                this.aVi.put("canceltime", this.aVp);
            }
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.aVi + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
