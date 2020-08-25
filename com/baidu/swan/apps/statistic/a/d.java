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
    private static int cGD = 35;
    private boolean cGF = false;
    private JSONObject cXy;

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

    public d fT(boolean z) {
        this.cGF = z;
        return this;
    }

    public d ru(String str) {
        this.mFrom = str;
        return this;
    }

    public d rv(String str) {
        this.mAppId = str;
        return this;
    }

    public d rw(String str) {
        this.mSource = str;
        return this;
    }

    public d rx(String str) {
        this.mPage = str;
        return this;
    }

    public d cm(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cXy == null) {
                this.cXy = new JSONObject();
            }
            try {
                this.cXy.put(str, str2);
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
                this.cXJ = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXz == null) {
            this.cXz = new JSONObject();
        }
        try {
            if (this.cXy != null) {
                if (this.cGF) {
                    String kn = ak.kn(cGD);
                    if (!TextUtils.isEmpty(kn)) {
                        this.cXy.put("stacktrace", kn);
                    }
                }
                this.cXz.put("info", this.cXy);
            }
            ExtensionCore ako = com.baidu.swan.apps.core.turbo.d.ajS().ako();
            if (ako != null) {
                this.cXz.put("extension_ver", ako.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
