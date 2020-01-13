package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bDD = 35;
    private boolean bDF = false;
    private JSONObject bRe;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.adU());
        bf("detail", aVar.adT().toString());
        return this;
    }

    public d dO(boolean z) {
        this.bDF = z;
        return this;
    }

    public d ly(String str) {
        this.mFrom = str;
        return this;
    }

    public d lz(String str) {
        this.mAppId = str;
        return this;
    }

    public d lA(String str) {
        this.mSource = str;
        return this;
    }

    public d lB(String str) {
        this.mPage = str;
        return this;
    }

    public d bf(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.bRe == null) {
                this.bRe = new JSONObject();
            }
            try {
                this.bRe.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.Tt())) {
                this.mSource = eVar.Tt();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.Tv())) {
                this.mScheme = eVar.Tv();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.bRo = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bRf == null) {
            this.bRf = new JSONObject();
        }
        try {
            if (this.bRe != null) {
                if (this.bDF) {
                    String gO = ai.gO(bDD);
                    if (!TextUtils.isEmpty(gO)) {
                        this.bRe.put("stacktrace", gO);
                    }
                }
                this.bRf.put("info", this.bRe);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
