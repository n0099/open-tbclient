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
    private static int ddj = 35;
    private boolean ddl = false;
    private JSONObject duo;

    public d() {
        this.mSource = "NA";
    }

    public d kp(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aJp());
        cy("detail", aVar.aJo().toString());
        return this;
    }

    public d gB(boolean z) {
        this.ddl = z;
        return this;
    }

    public d sU(String str) {
        this.mFrom = str;
        return this;
    }

    public d sV(String str) {
        this.mAppId = str;
        return this;
    }

    public d sW(String str) {
        this.mSource = str;
        return this;
    }

    public d sX(String str) {
        this.mPage = str;
        return this;
    }

    public d cy(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.duo == null) {
                this.duo = new JSONObject();
            }
            try {
                this.duo.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.awd())) {
                this.mSource = eVar.awd();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.awf())) {
                this.mScheme = eVar.awf();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.duz = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dup == null) {
            this.dup = new JSONObject();
        }
        try {
            if (this.duo != null) {
                if (this.ddl) {
                    String lg = ak.lg(ddj);
                    if (!TextUtils.isEmpty(lg)) {
                        this.duo.put("stacktrace", lg);
                    }
                }
                this.dup.put("info", this.duo);
            }
            ExtensionCore apE = com.baidu.swan.apps.core.turbo.d.aph().apE();
            if (apE != null) {
                this.dup.put("extension_ver", apE.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
