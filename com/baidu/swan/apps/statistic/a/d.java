package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int doH = 35;
    private JSONObject dJq;
    private boolean doJ = false;

    public d() {
        this.mSource = "NA";
    }

    public d js(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.al.a aVar) {
        this.mType = String.valueOf(aVar.aMM());
        cC("detail", aVar.aML().toString());
        return this;
    }

    public d hq(boolean z) {
        this.doJ = z;
        return this;
    }

    public d sw(String str) {
        this.mFrom = str;
        return this;
    }

    public d sx(String str) {
        this.mAppId = str;
        return this;
    }

    public d sy(String str) {
        this.mSource = str;
        return this;
    }

    public d sz(String str) {
        this.mPage = str;
        return this;
    }

    public d cC(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dJq == null) {
                this.dJq = new JSONObject();
            }
            try {
                this.dJq.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.ayC())) {
                this.mSource = eVar.ayC();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.ayE())) {
                this.mScheme = eVar.ayE();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dJB = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dJr == null) {
            this.dJr = new JSONObject();
        }
        try {
            if (this.dJq != null) {
                if (this.doJ) {
                    String kj = ak.kj(doH);
                    if (!TextUtils.isEmpty(kj)) {
                        this.dJq.put("stacktrace", kj);
                    }
                }
                this.dJr.put("info", this.dJq);
            }
            ExtensionCore asc = com.baidu.swan.apps.core.turbo.d.arG().asc();
            if (asc != null) {
                this.dJr.put("extension_ver", asc.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
