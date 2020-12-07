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
/* loaded from: classes25.dex */
public class d {
    public static void e(b.a aVar) {
        Bundle aBj;
        if (aVar != null && aZA() && (aBj = aVar.aBj()) != null && aBj.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.kS(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aBe();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dFI = String.valueOf(currentTimeMillis - j);
            fVar.tO(aBj.getString("ubc"));
            h.onEvent(fVar);
            aBj.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle aBj;
        if (aVar != null && !aZA() && (aBj = aVar.aBj()) != null && aBj.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.kS(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aBe();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dFH = String.valueOf(currentTimeMillis - j);
            fVar.t(TiebaInitialize.LogFields.REASON, str);
            fVar.t("errorList", b.aZy().aZz());
            fVar.tO(aBj.getString("ubc"));
            h.onEvent(fVar);
            aBj.remove("page_display_flag_for_statistic");
        }
    }

    public static void ye(String str) {
        if (com.baidu.swan.apps.runtime.d.aJQ().aie() == 1 && !aZA()) {
            i.rk("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void J(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow rk = i.rk("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        rk.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).cx(optLong));
                    }
                }
            }
        }
    }

    public static boolean aZA() {
        SwanAppActivity aJO;
        e aJU = e.aJU();
        if (aJU != null && (aJO = aJU.aJO()) != null) {
            com.baidu.swan.apps.framework.c aif = aJO.aif();
            if (aif instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) aif).aYb();
            }
            return false;
        }
        return false;
    }

    public static long aZB() {
        SwanAppActivity aJO;
        e aJU = e.aJU();
        if (aJU != null && (aJO = aJU.aJO()) != null) {
            com.baidu.swan.apps.framework.c aif = aJO.aif();
            if (aif instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) aif).aYc();
            }
            return 0L;
        }
        return 0L;
    }
}
