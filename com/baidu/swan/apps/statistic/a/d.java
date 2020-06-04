package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int crI = 35;
    private JSONObject cGt;
    private boolean crK = false;

    public d() {
        this.mSource = "NA";
    }

    public d gV(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d f(@NonNull com.baidu.swan.apps.an.a aVar) {
        this.mType = String.valueOf(aVar.asM());
        bS("detail", aVar.asL().toString());
        return this;
    }

    public d fm(boolean z) {
        this.crK = z;
        return this;
    }

    public d oC(String str) {
        this.mFrom = str;
        return this;
    }

    public d oD(String str) {
        this.mAppId = str;
        return this;
    }

    public d oE(String str) {
        this.mSource = str;
        return this;
    }

    public d oF(String str) {
        this.mPage = str;
        return this;
    }

    public d bS(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cGt == null) {
                this.cGt = new JSONObject();
            }
            try {
                this.cGt.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.v.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.agK())) {
                this.mSource = eVar.agK();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.agM())) {
                this.mScheme = eVar.agM();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cGE = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cGu == null) {
            this.cGu = new JSONObject();
        }
        try {
            if (this.cGt != null) {
                if (this.crK) {
                    String hJ = aj.hJ(crI);
                    if (!TextUtils.isEmpty(hJ)) {
                        this.cGt.put("stacktrace", hJ);
                    }
                }
                this.cGu.put("info", this.cGt);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
