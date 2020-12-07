package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int doy = 35;
    private JSONObject dFy;
    private boolean doA = false;

    public d() {
        this.mSource = "NA";
    }

    public d kT(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aOo());
        cE("detail", aVar.aOn().toString());
        return this;
    }

    public d hc(boolean z) {
        this.doA = z;
        return this;
    }

    public d tK(String str) {
        this.mFrom = str;
        return this;
    }

    public d tL(String str) {
        this.mAppId = str;
        return this;
    }

    public d tM(String str) {
        this.mSource = str;
        return this;
    }

    public d tN(String str) {
        this.mPage = str;
        return this;
    }

    public d cE(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dFy == null) {
                this.dFy = new JSONObject();
            }
            try {
                this.dFy.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.aBe())) {
                this.mSource = eVar.aBe();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.aBg())) {
                this.mScheme = eVar.aBg();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dFJ = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dFz == null) {
            this.dFz = new JSONObject();
        }
        try {
            if (this.dFy != null) {
                if (this.doA) {
                    String lK = ak.lK(doy);
                    if (!TextUtils.isEmpty(lK)) {
                        this.dFy.put("stacktrace", lK);
                    }
                }
                this.dFz.put("info", this.dFy);
            }
            ExtensionCore auE = com.baidu.swan.apps.core.turbo.d.aui().auE();
            if (auE != null) {
                this.dFz.put("extension_ver", auE.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
