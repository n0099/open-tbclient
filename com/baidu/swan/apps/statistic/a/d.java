package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cIH = 35;
    private boolean cIJ = false;
    private JSONObject cZC;

    public d() {
        this.mSource = "NA";
    }

    public d jH(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aEM());
        cm("detail", aVar.aEL().toString());
        return this;
    }

    public d fS(boolean z) {
        this.cIJ = z;
        return this;
    }

    public d rO(String str) {
        this.mFrom = str;
        return this;
    }

    public d rP(String str) {
        this.mAppId = str;
        return this;
    }

    public d rQ(String str) {
        this.mSource = str;
        return this;
    }

    public d rR(String str) {
        this.mPage = str;
        return this;
    }

    public d cm(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cZC == null) {
                this.cZC = new JSONObject();
            }
            try {
                this.cZC.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.arx())) {
                this.mSource = eVar.arx();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.arz())) {
                this.mScheme = eVar.arz();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cZN = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cZD == null) {
            this.cZD = new JSONObject();
        }
        try {
            if (this.cZC != null) {
                if (this.cIJ) {
                    String ky = ak.ky(cIH);
                    if (!TextUtils.isEmpty(ky)) {
                        this.cZC.put("stacktrace", ky);
                    }
                }
                this.cZD.put("info", this.cZC);
            }
            ExtensionCore akY = com.baidu.swan.apps.core.turbo.d.akC().akY();
            if (akY != null) {
                this.cZD.put("extension_ver", akY.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
