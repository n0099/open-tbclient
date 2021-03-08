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
    private static int dsv = 35;
    private JSONObject dMV;
    private boolean dsx = false;

    public d() {
        this.mSource = "NA";
    }

    public d jw(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.al.a aVar) {
        this.mType = String.valueOf(aVar.aNi());
        cw("detail", aVar.aNh().toString());
        return this;
    }

    public d hs(boolean z) {
        this.dsx = z;
        return this;
    }

    public d sW(String str) {
        this.mFrom = str;
        return this;
    }

    public d sX(String str) {
        this.mAppId = str;
        return this;
    }

    public d sY(String str) {
        this.mSource = str;
        return this;
    }

    public d sZ(String str) {
        this.mPage = str;
        return this;
    }

    public d cw(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dMV == null) {
                this.dMV = new JSONObject();
            }
            try {
                this.dMV.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.azd())) {
                this.mSource = eVar.azd();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.azf())) {
                this.mScheme = eVar.azf();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dNg = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dMW == null) {
            this.dMW = new JSONObject();
        }
        try {
            if (this.dMV != null) {
                if (this.dsx) {
                    String kn = ak.kn(dsv);
                    if (!TextUtils.isEmpty(kn)) {
                        this.dMV.put("stacktrace", kn);
                    }
                }
                this.dMW.put("info", this.dMV);
            }
            ExtensionCore asE = com.baidu.swan.apps.core.turbo.d.ash().asE();
            if (asE != null) {
                this.dMW.put("extension_ver", asE.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
