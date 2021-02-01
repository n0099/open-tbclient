package com.baidu.swan.games.v;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static void e(b.a aVar) {
        Bundle azf;
        if (aVar != null && aYn() && (azf = aVar.azf()) != null && azf.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ju(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aza();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dLE = String.valueOf(currentTimeMillis - j);
            fVar.sT(azf.getString("ubc"));
            h.onEvent(fVar);
            azf.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle azf;
        if (aVar != null && !aYn() && (azf = aVar.azf()) != null && azf.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ju(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aza();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dLD = String.valueOf(currentTimeMillis - j);
            fVar.r(TiebaInitialize.LogFields.REASON, str);
            fVar.r("errorList", b.aYl().aYm());
            fVar.sT(azf.getString("ubc"));
            h.onEvent(fVar);
            azf.remove("page_display_flag_for_statistic");
        }
    }

    public static void xl(String str) {
        if (com.baidu.swan.apps.runtime.d.aIG().getFrameType() == 1 && !aYn()) {
            i.qk("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow qk = i.qk("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        qk.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(optLong));
                    }
                }
            }
        }
    }

    public static boolean aYn() {
        SwanAppActivity aIE;
        e aIK = e.aIK();
        if (aIK != null && (aIE = aIK.aIE()) != null) {
            com.baidu.swan.apps.framework.c afQ = aIE.afQ();
            if (afQ instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afQ).aWO();
            }
            return false;
        }
        return false;
    }

    public static long aYo() {
        SwanAppActivity aIE;
        e aIK = e.aIK();
        if (aIK != null && (aIE = aIK.aIE()) != null) {
            com.baidu.swan.apps.framework.c afQ = aIE.afQ();
            if (afQ instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afQ).aWP();
            }
            return 0L;
        }
        return 0L;
    }
}
