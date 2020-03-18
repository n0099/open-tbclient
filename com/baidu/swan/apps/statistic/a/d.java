package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bHW = 35;
    private boolean bHY = false;
    private JSONObject bVw;

    public d() {
        this.mSource = "NA";
    }

    public d e(@NonNull com.baidu.swan.apps.ap.a aVar) {
        this.mType = String.valueOf(aVar.agn());
        bn("detail", aVar.agm().toString());
        return this;
    }

    public d dW(boolean z) {
        this.bHY = z;
        return this;
    }

    public d lM(String str) {
        this.mFrom = str;
        return this;
    }

    public d lN(String str) {
        this.mAppId = str;
        return this;
    }

    public d lO(String str) {
        this.mSource = str;
        return this;
    }

    public d lP(String str) {
        this.mPage = str;
        return this;
    }

    public d bn(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.bVw == null) {
                this.bVw = new JSONObject();
            }
            try {
                this.bVw.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.x.b.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.VM())) {
                this.mSource = eVar.VM();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.VO())) {
                this.mScheme = eVar.VO();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.bVG = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVx == null) {
            this.bVx = new JSONObject();
        }
        try {
            if (this.bVw != null) {
                if (this.bHY) {
                    String hf = ai.hf(bHW);
                    if (!TextUtils.isEmpty(hf)) {
                        this.bVw.put("stacktrace", hf);
                    }
                }
                this.bVx.put("info", this.bVw);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
