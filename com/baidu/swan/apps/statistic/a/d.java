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
    private static int dqS = 35;
    private JSONObject dLu;
    private boolean dqU = false;

    public d() {
        this.mSource = "NA";
    }

    public d jv(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.al.a aVar) {
        this.mType = String.valueOf(aVar.aNf());
        cw("detail", aVar.aNe().toString());
        return this;
    }

    public d hs(boolean z) {
        this.dqU = z;
        return this;
    }

    public d sP(String str) {
        this.mFrom = str;
        return this;
    }

    public d sQ(String str) {
        this.mAppId = str;
        return this;
    }

    public d sR(String str) {
        this.mSource = str;
        return this;
    }

    public d sS(String str) {
        this.mPage = str;
        return this;
    }

    public d cw(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dLu == null) {
                this.dLu = new JSONObject();
            }
            try {
                this.dLu.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.aza())) {
                this.mSource = eVar.aza();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.azc())) {
                this.mScheme = eVar.azc();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dLF = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dLv == null) {
            this.dLv = new JSONObject();
        }
        try {
            if (this.dLu != null) {
                if (this.dqU) {
                    String km = ak.km(dqS);
                    if (!TextUtils.isEmpty(km)) {
                        this.dLu.put("stacktrace", km);
                    }
                }
                this.dLv.put("info", this.dLu);
            }
            ExtensionCore asB = com.baidu.swan.apps.core.turbo.d.ase().asB();
            if (asB != null) {
                this.dLv.put("extension_ver", asB.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
