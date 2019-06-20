package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.an.ac;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aGd = 35;
    private boolean aGf = false;
    private JSONObject aVh;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.Og());
        aC("detail", aVar.Of().toString());
        return this;
    }

    public d cv(boolean z) {
        this.aGf = z;
        return this;
    }

    public d ho(String str) {
        this.mFrom = str;
        return this;
    }

    public d hp(String str) {
        this.mAppId = str;
        return this;
    }

    public d hq(String str) {
        this.mSource = str;
        return this;
    }

    public d hr(String str) {
        this.ayL = str;
        return this;
    }

    public d aC(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aVh == null) {
                this.aVh = new JSONObject();
            }
            try {
                this.aVh.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d s(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.EW())) {
                this.mSource = bVar.EW();
            }
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                this.mAppId = bVar.getAppId();
            }
            if (!TextUtils.isEmpty(bVar.EX())) {
                this.aVo = bVar.EX();
            }
            if (!TextUtils.isEmpty(bVar.getPage())) {
                this.aVq = bVar.getPage();
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
            if (!TextUtils.isEmpty(cVar.ayP)) {
                this.aVo = cVar.ayP;
            }
            if (!TextUtils.isEmpty(cVar.ayL)) {
                this.aVq = cVar.ayL;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aVi == null) {
            this.aVi = new JSONObject();
        }
        try {
            if (this.aVh != null) {
                if (this.aGf) {
                    String ez = ac.ez(aGd);
                    if (!TextUtils.isEmpty(ez)) {
                        this.aVh.put("stacktrace", ez);
                    }
                }
                this.aVi.put("info", this.aVh);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
