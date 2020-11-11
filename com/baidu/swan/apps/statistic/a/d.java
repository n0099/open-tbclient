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
    private static int djg = 35;
    private JSONObject dAg;
    private boolean dji = false;

    public d() {
        this.mSource = "NA";
    }

    public d kz(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aLP());
        cy("detail", aVar.aLO().toString());
        return this;
    }

    public d gK(boolean z) {
        this.dji = z;
        return this;
    }

    public d ti(String str) {
        this.mFrom = str;
        return this;
    }

    public d tj(String str) {
        this.mAppId = str;
        return this;
    }

    public d tk(String str) {
        this.mSource = str;
        return this;
    }

    public d tl(String str) {
        this.mPage = str;
        return this;
    }

    public d cy(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dAg == null) {
                this.dAg = new JSONObject();
            }
            try {
                this.dAg.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.ayD())) {
                this.mSource = eVar.ayD();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.ayF())) {
                this.mScheme = eVar.ayF();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dAr = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dAh == null) {
            this.dAh = new JSONObject();
        }
        try {
            if (this.dAg != null) {
                if (this.dji) {
                    String lq = ak.lq(djg);
                    if (!TextUtils.isEmpty(lq)) {
                        this.dAg.put("stacktrace", lq);
                    }
                }
                this.dAh.put("info", this.dAg);
            }
            ExtensionCore ase = com.baidu.swan.apps.core.turbo.d.arI().ase();
            if (ase != null) {
                this.dAh.put("extension_ver", ase.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
