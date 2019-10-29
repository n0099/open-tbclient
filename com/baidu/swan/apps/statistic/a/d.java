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
    private static int bax = 35;
    private boolean baz = false;
    private JSONObject bpt;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.TP());
        aK("detail", aVar.TO().toString());
        return this;
    }

    public d cP(boolean z) {
        this.baz = z;
        return this;
    }

    public d ia(String str) {
        this.mFrom = str;
        return this;
    }

    public d ib(String str) {
        this.mAppId = str;
        return this;
    }

    public d ic(String str) {
        this.mSource = str;
        return this;
    }

    public d ie(String str) {
        this.aTe = str;
        return this;
    }

    public d aK(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.bpt == null) {
                this.bpt = new JSONObject();
            }
            try {
                this.bpt.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d s(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.KE())) {
                this.mSource = bVar.KE();
            }
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                this.mAppId = bVar.getAppId();
            }
            if (!TextUtils.isEmpty(bVar.KF())) {
                this.bpA = bVar.KF();
            }
            if (!TextUtils.isEmpty(bVar.getPage())) {
                this.bpC = bVar.getPage();
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
            if (!TextUtils.isEmpty(cVar.aTi)) {
                this.bpA = cVar.aTi;
            }
            if (!TextUtils.isEmpty(cVar.aTe)) {
                this.bpC = cVar.aTe;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bpu == null) {
            this.bpu = new JSONObject();
        }
        try {
            if (this.bpt != null) {
                if (this.baz) {
                    String fy = ac.fy(bax);
                    if (!TextUtils.isEmpty(fy)) {
                        this.bpt.put("stacktrace", fy);
                    }
                }
                this.bpu.put(Config.LAUNCH_INFO, this.bpt);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
