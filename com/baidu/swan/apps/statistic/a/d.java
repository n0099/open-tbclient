package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aEh = 35;
    private boolean aEj = false;
    private JSONObject aSp;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.LC());
        aA("detail", aVar.LB().toString());
        return this;
    }

    public d cg(boolean z) {
        this.aEj = z;
        return this;
    }

    public d gR(String str) {
        this.mFrom = str;
        return this;
    }

    public d gS(String str) {
        this.mAppId = str;
        return this;
    }

    public d gT(String str) {
        this.mSource = str;
        return this;
    }

    public d gU(String str) {
        this.axI = str;
        return this;
    }

    public d aA(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aSp == null) {
                this.aSp = new JSONObject();
            }
            try {
                this.aSp.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d r(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.axG)) {
                this.mSource = bVar.axG;
            }
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                this.mAppId = bVar.mAppId;
            }
            if (!TextUtils.isEmpty(bVar.axH)) {
                this.aSv = bVar.axH;
            }
            if (!TextUtils.isEmpty(bVar.axI)) {
                this.aSx = bVar.axI;
            }
        }
        return this;
    }

    public d c(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.mFrom)) {
                this.mSource = cVar.mFrom;
            }
            if (!TextUtils.isEmpty(cVar.mAppId)) {
                this.mAppId = cVar.mAppId;
            }
            if (!TextUtils.isEmpty(cVar.axH)) {
                this.aSv = cVar.axH;
            }
            if (!TextUtils.isEmpty(cVar.axI)) {
                this.aSx = cVar.axI;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aSq == null) {
            this.aSq = new JSONObject();
        }
        try {
            if (this.aSp != null) {
                if (this.aEj) {
                    String ep = aa.ep(aEh);
                    if (!TextUtils.isEmpty(ep)) {
                        this.aSp.put("stacktrace", ep);
                    }
                }
                this.aSq.put("info", this.aSp);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
