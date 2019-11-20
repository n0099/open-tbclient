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
    private static int baf = 35;
    private boolean bah = false;
    private JSONObject bpb;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.TN());
        aK("detail", aVar.TM().toString());
        return this;
    }

    public d cP(boolean z) {
        this.bah = z;
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
        this.aSM = str;
        return this;
    }

    public d aK(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.bpb == null) {
                this.bpb = new JSONObject();
            }
            try {
                this.bpb.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d s(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.KF())) {
                this.mSource = bVar.KF();
            }
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                this.mAppId = bVar.getAppId();
            }
            if (!TextUtils.isEmpty(bVar.KG())) {
                this.bpi = bVar.KG();
            }
            if (!TextUtils.isEmpty(bVar.getPage())) {
                this.bpk = bVar.getPage();
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
            if (!TextUtils.isEmpty(cVar.aSQ)) {
                this.bpi = cVar.aSQ;
            }
            if (!TextUtils.isEmpty(cVar.aSM)) {
                this.bpk = cVar.aSM;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bpc == null) {
            this.bpc = new JSONObject();
        }
        try {
            if (this.bpb != null) {
                if (this.bah) {
                    String fx = ac.fx(baf);
                    if (!TextUtils.isEmpty(fx)) {
                        this.bpb.put("stacktrace", fx);
                    }
                }
                this.bpc.put(Config.LAUNCH_INFO, this.bpb);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
