package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cUK = 35;
    private boolean cUM = false;
    private JSONObject dlM;

    public d() {
        this.mSource = "NA";
    }

    public d ke(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aHv());
        cr("detail", aVar.aHu().toString());
        return this;
    }

    public d go(boolean z) {
        this.cUM = z;
        return this;
    }

    public d sB(String str) {
        this.mFrom = str;
        return this;
    }

    public d sC(String str) {
        this.mAppId = str;
        return this;
    }

    public d sD(String str) {
        this.mSource = str;
        return this;
    }

    public d sE(String str) {
        this.mPage = str;
        return this;
    }

    public d cr(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dlM == null) {
                this.dlM = new JSONObject();
            }
            try {
                this.dlM.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.auj())) {
                this.mSource = eVar.auj();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.aul())) {
                this.mScheme = eVar.aul();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dlX = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dlN == null) {
            this.dlN = new JSONObject();
        }
        try {
            if (this.dlM != null) {
                if (this.cUM) {
                    String kV = ak.kV(cUK);
                    if (!TextUtils.isEmpty(kV)) {
                        this.dlM.put("stacktrace", kV);
                    }
                }
                this.dlN.put("info", this.dlM);
            }
            ExtensionCore anJ = com.baidu.swan.apps.core.turbo.d.ann().anJ();
            if (anJ != null) {
                this.dlN.put("extension_ver", anJ.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
