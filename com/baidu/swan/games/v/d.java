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
        Bundle auo;
        if (aVar != null && aSJ() && (auo = aVar.auo()) != null && auo.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.kd(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.auj();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dlW = String.valueOf(currentTimeMillis - j);
            fVar.sF(auo.getString("ubc"));
            h.onEvent(fVar);
            auo.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle auo;
        if (aVar != null && !aSJ() && (auo = aVar.auo()) != null && auo.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.kd(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.auj();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dlV = String.valueOf(currentTimeMillis - j);
            fVar.u(TiebaInitialize.LogFields.REASON, str);
            fVar.u("errorList", b.aSH().aSI());
            fVar.sF(auo.getString("ubc"));
            h.onEvent(fVar);
            auo.remove("page_display_flag_for_statistic");
        }
    }

    public static void wV(String str) {
        if (com.baidu.swan.apps.runtime.d.aCW().abk() == 1 && !aSJ()) {
            i.qc("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow qc = i.qc("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        qc.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bA(optLong));
                    }
                }
            }
        }
    }

    public static boolean aSJ() {
        SwanAppActivity aCU;
        e aDa = e.aDa();
        if (aDa != null && (aCU = aDa.aCU()) != null) {
            com.baidu.swan.apps.framework.c abl = aCU.abl();
            if (abl instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) abl).aRk();
            }
            return false;
        }
        return false;
    }

    public static long aSK() {
        SwanAppActivity aCU;
        e aDa = e.aDa();
        if (aDa != null && (aCU = aDa.aCU()) != null) {
            com.baidu.swan.apps.framework.c abl = aCU.abl();
            if (abl instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) abl).aRl();
            }
            return 0L;
        }
        return 0L;
    }
}
