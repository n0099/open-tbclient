package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int dhw = 35;
    private boolean dhy = false;
    private JSONObject dyz;

    public d() {
        this.mSource = "NA";
    }

    public d kv(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d i(@NonNull com.baidu.swan.apps.am.a aVar) {
        this.mType = String.valueOf(aVar.aLh());
        cx("detail", aVar.aLg().toString());
        return this;
    }

    public d gN(boolean z) {
        this.dhy = z;
        return this;
    }

    public d td(String str) {
        this.mFrom = str;
        return this;
    }

    public d te(String str) {
        this.mAppId = str;
        return this;
    }

    public d tf(String str) {
        this.mSource = str;
        return this;
    }

    public d tg(String str) {
        this.mPage = str;
        return this;
    }

    public d cx(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.dyz == null) {
                this.dyz = new JSONObject();
            }
            try {
                this.dyz.put(str, str2);
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
            if (!TextUtils.isEmpty(eVar.axV())) {
                this.mSource = eVar.axV();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.axX())) {
                this.mScheme = eVar.axX();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.dyK = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dyA == null) {
            this.dyA = new JSONObject();
        }
        try {
            if (this.dyz != null) {
                if (this.dhy) {
                    String lm = ak.lm(dhw);
                    if (!TextUtils.isEmpty(lm)) {
                        this.dyz.put("stacktrace", lm);
                    }
                }
                this.dyA.put("info", this.dyz);
            }
            ExtensionCore arw = com.baidu.swan.apps.core.turbo.d.ara().arw();
            if (arw != null) {
                this.dyA.put("extension_ver", arw.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
