package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cGH = 35;
    private boolean cGJ = false;
    private JSONObject cXC;

    public d() {
        this.mSource = "NA";
    }

    public d jw(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aEc());
        cm("detail", aVar.aEb().toString());
        return this;
    }

    public d fU(boolean z) {
        this.cGJ = z;
        return this;
    }

    public d rv(String str) {
        this.mFrom = str;
        return this;
    }

    public d rw(String str) {
        this.mAppId = str;
        return this;
    }

    public d rx(String str) {
        this.mSource = str;
        return this;
    }

    public d ry(String str) {
        this.mPage = str;
        return this;
    }

    public d cm(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cXC == null) {
                this.cXC = new JSONObject();
            }
            try {
                this.cXC.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.aqN())) {
                this.mSource = eVar.aqN();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.aqP())) {
                this.mScheme = eVar.aqP();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cXN = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXD == null) {
            this.cXD = new JSONObject();
        }
        try {
            if (this.cXC != null) {
                if (this.cGJ) {
                    String kn = ak.kn(cGH);
                    if (!TextUtils.isEmpty(kn)) {
                        this.cXC.put("stacktrace", kn);
                    }
                }
                this.cXD.put("info", this.cXC);
            }
            ExtensionCore ako = com.baidu.swan.apps.core.turbo.d.ajS().ako();
            if (ako != null) {
                this.cXD.put("extension_ver", ako.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
