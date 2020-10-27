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
/* loaded from: classes10.dex */
public class d {
    public static void e(b.a aVar) {
        Bundle awi;
        if (aVar != null && aUD() && (awi = aVar.awi()) != null && awi.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ko(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.awd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.duy = String.valueOf(currentTimeMillis - j);
            fVar.sY(awi.getString("ubc"));
            h.onEvent(fVar);
            awi.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle awi;
        if (aVar != null && !aUD() && (awi = aVar.awi()) != null && awi.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ko(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.awd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dux = String.valueOf(currentTimeMillis - j);
            fVar.u(TiebaInitialize.LogFields.REASON, str);
            fVar.u("errorList", b.aUB().aUC());
            fVar.sY(awi.getString("ubc"));
            h.onEvent(fVar);
            awi.remove("page_display_flag_for_statistic");
        }
    }

    public static void xo(String str) {
        if (com.baidu.swan.apps.runtime.d.aEQ().ade() == 1 && !aUD()) {
            i.qv("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow qv = i.qv("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        qv.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bC(optLong));
                    }
                }
            }
        }
    }

    public static boolean aUD() {
        SwanAppActivity aEO;
        e aEU = e.aEU();
        if (aEU != null && (aEO = aEU.aEO()) != null) {
            com.baidu.swan.apps.framework.c adf = aEO.adf();
            if (adf instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) adf).aTe();
            }
            return false;
        }
        return false;
    }

    public static long aUE() {
        SwanAppActivity aEO;
        e aEU = e.aEU();
        if (aEU != null && (aEO = aEU.aEO()) != null) {
            com.baidu.swan.apps.framework.c adf = aEO.adf();
            if (adf instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) adf).aTf();
            }
            return 0L;
        }
        return 0L;
    }
}
