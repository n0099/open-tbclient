package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bHJ = 35;
    private boolean bHL = false;
    private JSONObject bVj;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.agi());
        bo("detail", aVar.agh().toString());
        return this;
    }

    public d dV(boolean z) {
        this.bHL = z;
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
            if (this.bVj == null) {
                this.bVj = new JSONObject();
            }
            try {
                this.bVj.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.VH())) {
                this.mSource = eVar.VH();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.VJ())) {
                this.mScheme = eVar.VJ();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.bVt = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVk == null) {
            this.bVk = new JSONObject();
        }
        try {
            if (this.bVj != null) {
                if (this.bHL) {
                    String hf = ai.hf(bHJ);
                    if (!TextUtils.isEmpty(hf)) {
                        this.bVj.put("stacktrace", hf);
                    }
                }
                this.bVk.put("info", this.bVj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
