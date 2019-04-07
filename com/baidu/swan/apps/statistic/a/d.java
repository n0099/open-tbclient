package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aEk = 35;
    private boolean aEm = false;
    private JSONObject aSs;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.LA());
        aA("detail", aVar.Lz().toString());
        return this;
    }

    public d cg(boolean z) {
        this.aEm = z;
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
        this.axL = str;
        return this;
    }

    public d aA(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aSs == null) {
                this.aSs = new JSONObject();
            }
            try {
                this.aSs.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d r(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.axJ)) {
                this.mSource = bVar.axJ;
            }
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                this.mAppId = bVar.mAppId;
            }
            if (!TextUtils.isEmpty(bVar.axK)) {
                this.aSy = bVar.axK;
            }
            if (!TextUtils.isEmpty(bVar.axL)) {
                this.aSA = bVar.axL;
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
            if (!TextUtils.isEmpty(cVar.axK)) {
                this.aSy = cVar.axK;
            }
            if (!TextUtils.isEmpty(cVar.axL)) {
                this.aSA = cVar.axL;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aSt == null) {
            this.aSt = new JSONObject();
        }
        try {
            if (this.aSs != null) {
                if (this.aEm) {
                    String eo = aa.eo(aEk);
                    if (!TextUtils.isEmpty(eo)) {
                        this.aSs.put("stacktrace", eo);
                    }
                }
                this.aSt.put("info", this.aSs);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
