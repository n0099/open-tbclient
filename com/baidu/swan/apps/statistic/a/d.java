package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bCS = 35;
    private boolean bCU = false;
    private JSONObject bQu;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.adB());
        be("detail", aVar.adA().toString());
        return this;
    }

    public d dJ(boolean z) {
        this.bCU = z;
        return this;
    }

    public d lv(String str) {
        this.mFrom = str;
        return this;
    }

    public d lw(String str) {
        this.mAppId = str;
        return this;
    }

    public d lx(String str) {
        this.mSource = str;
        return this;
    }

    public d ly(String str) {
        this.mPage = str;
        return this;
    }

    public d be(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.bQu == null) {
                this.bQu = new JSONObject();
            }
            try {
                this.bQu.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.SW())) {
                this.mSource = eVar.SW();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.SY())) {
                this.mScheme = eVar.SY();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.bQE = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bQv == null) {
            this.bQv = new JSONObject();
        }
        try {
            if (this.bQu != null) {
                if (this.bCU) {
                    String gO = ai.gO(bCS);
                    if (!TextUtils.isEmpty(gO)) {
                        this.bQu.put("stacktrace", gO);
                    }
                }
                this.bQv.put("info", this.bQu);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
