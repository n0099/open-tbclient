package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.ac;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aHj = 35;
    private boolean aHl = false;
    private JSONObject aWp;

    public d() {
        this.mSource = "NA";
    }

    public d a(@NonNull com.baidu.swan.apps.ak.a aVar) {
        this.mType = String.valueOf(aVar.OZ());
        aC(DpStatConstants.KEY_DETAIL, aVar.OY().toString());
        return this;
    }

    public d cy(boolean z) {
        this.aHl = z;
        return this;
    }

    public d hx(String str) {
        this.mFrom = str;
        return this;
    }

    public d hy(String str) {
        this.mAppId = str;
        return this;
    }

    public d hz(String str) {
        this.mSource = str;
        return this;
    }

    public d hA(String str) {
        this.azQ = str;
        return this;
    }

    public d aC(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.aWp == null) {
                this.aWp = new JSONObject();
            }
            try {
                this.aWp.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public d s(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.FK())) {
                this.mSource = bVar.FK();
            }
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                this.mAppId = bVar.getAppId();
            }
            if (!TextUtils.isEmpty(bVar.FL())) {
                this.aWw = bVar.FL();
            }
            if (!TextUtils.isEmpty(bVar.getPage())) {
                this.aWy = bVar.getPage();
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
            if (!TextUtils.isEmpty(cVar.azU)) {
                this.aWw = cVar.azU;
            }
            if (!TextUtils.isEmpty(cVar.azQ)) {
                this.aWy = cVar.azQ;
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aWq == null) {
            this.aWq = new JSONObject();
        }
        try {
            if (this.aWp != null) {
                if (this.aHl) {
                    String eD = ac.eD(aHj);
                    if (!TextUtils.isEmpty(eD)) {
                        this.aWp.put("stacktrace", eD);
                    }
                }
                this.aWq.put(Config.LAUNCH_INFO, this.aWp);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
