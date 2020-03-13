package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bHL = 35;
    private boolean bHN = false;
    private JSONObject bVl;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.agk());
        bo("detail", aVar.agj().toString());
        return this;
    }

    public d dV(boolean z) {
        this.bHN = z;
        return this;
    }

    public d lN(String str) {
        this.mFrom = str;
        return this;
    }

    public d lO(String str) {
        this.mAppId = str;
        return this;
    }

    public d lP(String str) {
        this.mSource = str;
        return this;
    }

    public d lQ(String str) {
        this.mPage = str;
        return this;
    }

    public d bo(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.bVl == null) {
                this.bVl = new JSONObject();
            }
            try {
                this.bVl.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.VJ())) {
                this.mSource = eVar.VJ();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.VL())) {
                this.mScheme = eVar.VL();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.bVv = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVm == null) {
            this.bVm = new JSONObject();
        }
        try {
            if (this.bVl != null) {
                if (this.bHN) {
                    String hf = ai.hf(bHL);
                    if (!TextUtils.isEmpty(hf)) {
                        this.bVl.put("stacktrace", hf);
                    }
                }
                this.bVm.put("info", this.bVl);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
