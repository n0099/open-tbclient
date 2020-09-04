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
/* loaded from: classes8.dex */
public class d {
    public static void e(b.a aVar) {
        Bundle aqS;
        if (aVar != null && aPp() && (aqS = aVar.aqS()) != null && aqS.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jv(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aqN();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.cXM = String.valueOf(currentTimeMillis - j);
            fVar.rz(aqS.getString("ubc"));
            h.onEvent(fVar);
            aqS.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle aqS;
        if (aVar != null && !aPp() && (aqS = aVar.aqS()) != null && aqS.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jv(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aqN();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.cXL = String.valueOf(currentTimeMillis - j);
            fVar.u(TiebaInitialize.LogFields.REASON, str);
            fVar.u("errorList", b.aPn().aPo());
            fVar.rz(aqS.getString("ubc"));
            h.onEvent(fVar);
            aqS.remove("page_display_flag_for_statistic");
        }
    }

    public static void vQ(String str) {
        if (com.baidu.swan.apps.runtime.d.azE().XP() == 1 && !aPp()) {
            i.oX("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow oX = i.oX("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        oX.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).br(optLong));
                    }
                }
            }
        }
    }

    public static boolean aPp() {
        SwanAppActivity azC;
        e azI = e.azI();
        if (azI != null && (azC = azI.azC()) != null) {
            com.baidu.swan.apps.framework.c XQ = azC.XQ();
            if (XQ instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) XQ).aNQ();
            }
            return false;
        }
        return false;
    }

    public static long aPq() {
        SwanAppActivity azC;
        e azI = e.azI();
        if (azI != null && (azC = azI.azC()) != null) {
            com.baidu.swan.apps.framework.c XQ = azC.XQ();
            if (XQ instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) XQ).aNR();
            }
            return 0L;
        }
        return 0L;
    }
}
