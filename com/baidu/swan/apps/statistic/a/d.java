package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cgL = 35;
    private boolean cgN = false;
    private JSONObject cuu;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.aor());
        bx("detail", aVar.aoq().toString());
        return this;
    }

    public d eS(boolean z) {
        this.cgN = z;
        return this;
    }

    public d mZ(String str) {
        this.mFrom = str;
        return this;
    }

    public d na(String str) {
        this.mAppId = str;
        return this;
    }

    public d nb(String str) {
        this.mSource = str;
        return this;
    }

    public d nc(String str) {
        this.mPage = str;
        return this;
    }

    public d bx(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cuu == null) {
                this.cuu = new JSONObject();
            }
            try {
                this.cuu.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.adA())) {
                this.mSource = eVar.adA();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.adC())) {
                this.mScheme = eVar.adC();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cuE = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cuv == null) {
            this.cuv = new JSONObject();
        }
        try {
            if (this.cuu != null) {
                if (this.cgN) {
                    String hm = ai.hm(cgL);
                    if (!TextUtils.isEmpty(hm)) {
                        this.cuu.put("stacktrace", hm);
                    }
                }
                this.cuv.put("info", this.cuu);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
