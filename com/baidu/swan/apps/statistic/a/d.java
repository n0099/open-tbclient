package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static int aEg = 35;
    private boolean aEi = false;
    private JSONObject aSo;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.LC());
        aA("detail", aVar.LB().toString());
        return this;
    }

    public d cg(boolean z) {
        this.aEi = z;
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
        this.axH = str;
        return this;
    }

    public d aA(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aSo == null) {
                this.aSo = new JSONObject();
            }
            try {
                this.aSo.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d r(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.axF)) {
                this.mSource = bVar.axF;
            }
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                this.mAppId = bVar.mAppId;
            }
            if (!TextUtils.isEmpty(bVar.axG)) {
                this.aSu = bVar.axG;
            }
            if (!TextUtils.isEmpty(bVar.axH)) {
                this.aSw = bVar.axH;
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
            if (!TextUtils.isEmpty(cVar.axG)) {
                this.aSu = cVar.axG;
            }
            if (!TextUtils.isEmpty(cVar.axH)) {
                this.aSw = cVar.axH;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aSp == null) {
            this.aSp = new JSONObject();
        }
        try {
            if (this.aSo != null) {
                if (this.aEi) {
                    String ep = aa.ep(aEg);
                    if (!TextUtils.isEmpty(ep)) {
                        this.aSo.put("stacktrace", ep);
                    }
                }
                this.aSp.put("info", this.aSo);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
