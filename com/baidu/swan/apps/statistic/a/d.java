package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aEl = 35;
    private boolean aEn = false;
    private JSONObject aSt;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.LA());
        aA("detail", aVar.Lz().toString());
        return this;
    }

    public d cg(boolean z) {
        this.aEn = z;
        return this;
    }

    public d gS(String str) {
        this.mFrom = str;
        return this;
    }

    public d gT(String str) {
        this.mAppId = str;
        return this;
    }

    public d gU(String str) {
        this.mSource = str;
        return this;
    }

    public d gV(String str) {
        this.axM = str;
        return this;
    }

    public d aA(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aSt == null) {
                this.aSt = new JSONObject();
            }
            try {
                this.aSt.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d r(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.axK)) {
                this.mSource = bVar.axK;
            }
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                this.mAppId = bVar.mAppId;
            }
            if (!TextUtils.isEmpty(bVar.axL)) {
                this.aSz = bVar.axL;
            }
            if (!TextUtils.isEmpty(bVar.axM)) {
                this.aSB = bVar.axM;
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
            if (!TextUtils.isEmpty(cVar.axL)) {
                this.aSz = cVar.axL;
            }
            if (!TextUtils.isEmpty(cVar.axM)) {
                this.aSB = cVar.axM;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aSu == null) {
            this.aSu = new JSONObject();
        }
        try {
            if (this.aSt != null) {
                if (this.aEn) {
                    String eo = aa.eo(aEl);
                    if (!TextUtils.isEmpty(eo)) {
                        this.aSt.put("stacktrace", eo);
                    }
                }
                this.aSu.put("info", this.aSt);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
