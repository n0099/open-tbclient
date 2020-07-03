package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cww = 35;
    private JSONObject cLd;
    private boolean cwy = false;

    public d() {
        this.mSource = "NA";
    }

    public d hg(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d f(@NonNull com.baidu.swan.apps.an.a aVar) {
        this.mType = String.valueOf(aVar.atS());
        bU("detail", aVar.atR().toString());
        return this;
    }

    public d fr(boolean z) {
        this.cwy = z;
        return this;
    }

    public d oK(String str) {
        this.mFrom = str;
        return this;
    }

    public d oL(String str) {
        this.mAppId = str;
        return this;
    }

    public d oM(String str) {
        this.mSource = str;
        return this;
    }

    public d oN(String str) {
        this.mPage = str;
        return this;
    }

    public d bU(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cLd == null) {
                this.cLd = new JSONObject();
            }
            try {
                this.cLd.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.v.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.ahQ())) {
                this.mSource = eVar.ahQ();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.ahS())) {
                this.mScheme = eVar.ahS();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cLo = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cLe == null) {
            this.cLe = new JSONObject();
        }
        try {
            if (this.cLd != null) {
                if (this.cwy) {
                    String hU = aj.hU(cww);
                    if (!TextUtils.isEmpty(hU)) {
                        this.cLd.put("stacktrace", hU);
                    }
                }
                this.cLe.put("info", this.cLd);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
