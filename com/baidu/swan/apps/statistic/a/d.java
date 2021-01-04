package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int dtx = 35;
    private JSONObject dOc;
    private boolean dtz = false;

    public d() {
        this.mSource = "NA";
    }

    public d kY(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.al.a aVar) {
        this.mType = String.valueOf(aVar.aQF());
        cD("detail", aVar.aQE().toString());
        return this;
    }

    public d hu(boolean z) {
        this.dtz = z;
        return this;
    }

    public d tH(String str) {
        this.mFrom = str;
        return this;
    }

    public d tI(String str) {
        this.mAppId = str;
        return this;
    }

    public d tJ(String str) {
        this.mSource = str;
        return this;
    }

    public d tK(String str) {
        this.mPage = str;
        return this;
    }

    public d cD(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dOc == null) {
                this.dOc = new JSONObject();
            }
            try {
                this.dOc.put(str, str2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.u.c.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.aCv())) {
                this.mSource = eVar.aCv();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.aCx())) {
                this.mScheme = eVar.aCx();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dOn = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dOd == null) {
            this.dOd = new JSONObject();
        }
        try {
            if (this.dOc != null) {
                if (this.dtz) {
                    String lP = ak.lP(dtx);
                    if (!TextUtils.isEmpty(lP)) {
                        this.dOc.put("stacktrace", lP);
                    }
                }
                this.dOd.put("info", this.dOc);
            }
            ExtensionCore avW = com.baidu.swan.apps.core.turbo.d.avA().avW();
            if (avW != null) {
                this.dOd.put("extension_ver", avW.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
