package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.ac;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aGL = 35;
    private boolean aGN = false;
    private JSONObject aVR;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.OV());
        aC("detail", aVar.OU().toString());
        return this;
    }

    public d cy(boolean z) {
        this.aGN = z;
        return this;
    }

    public d hv(String str) {
        this.mFrom = str;
        return this;
    }

    public d hw(String str) {
        this.mAppId = str;
        return this;
    }

    public d hx(String str) {
        this.mSource = str;
        return this;
    }

    public d hy(String str) {
        this.azs = str;
        return this;
    }

    public d aC(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aVR == null) {
                this.aVR = new JSONObject();
            }
            try {
                this.aVR.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d s(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.FG())) {
                this.mSource = bVar.FG();
            }
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                this.mAppId = bVar.getAppId();
            }
            if (!TextUtils.isEmpty(bVar.FH())) {
                this.aVY = bVar.FH();
            }
            if (!TextUtils.isEmpty(bVar.getPage())) {
                this.aWa = bVar.getPage();
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
            if (!TextUtils.isEmpty(cVar.azw)) {
                this.aVY = cVar.azw;
            }
            if (!TextUtils.isEmpty(cVar.azs)) {
                this.aWa = cVar.azs;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aVS == null) {
            this.aVS = new JSONObject();
        }
        try {
            if (this.aVR != null) {
                if (this.aGN) {
                    String eC = ac.eC(aGL);
                    if (!TextUtils.isEmpty(eC)) {
                        this.aVR.put("stacktrace", eC);
                    }
                }
                this.aVS.put(Config.LAUNCH_INFO, this.aVR);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
