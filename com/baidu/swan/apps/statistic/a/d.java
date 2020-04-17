package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cgF = 35;
    private boolean cgH = false;
    private JSONObject cum;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.aos());
        bx("detail", aVar.aor().toString());
        return this;
    }

    public d eS(boolean z) {
        this.cgH = z;
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
            if (this.cum == null) {
                this.cum = new JSONObject();
            }
            try {
                this.cum.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.adB())) {
                this.mSource = eVar.adB();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.adD())) {
                this.mScheme = eVar.adD();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cuy = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cun == null) {
            this.cun = new JSONObject();
        }
        try {
            if (this.cum != null) {
                if (this.cgH) {
                    String hm = ai.hm(cgF);
                    if (!TextUtils.isEmpty(hm)) {
                        this.cum.put("stacktrace", hm);
                    }
                }
                this.cun.put("info", this.cum);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
