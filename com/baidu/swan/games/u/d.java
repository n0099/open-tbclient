package com.baidu.swan.games.u;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static void d(b.a aVar) {
        Bundle adF;
        if (aVar != null && axU() && (adF = aVar.adF()) != null && adF.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.adA();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.cuD = String.valueOf(currentTimeMillis - j);
            fVar.nd(adF.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            adF.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle adF;
        if (aVar != null && !axU() && (adF = aVar.adF()) != null && adF.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.adA();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.cuC = String.valueOf(currentTimeMillis - j);
            fVar.s(TiebaInitialize.LogFields.REASON, str);
            fVar.s("errorList", b.axS().axT());
            fVar.nd(adF.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            adF.remove("page_display_flag_for_statistic");
        }
    }

    public static void qP(String str) {
        if (com.baidu.swan.apps.runtime.d.akJ().Ol() == 1 && !axU()) {
            com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void G(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        lb.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).aZ(optLong));
                    }
                }
            }
        }
    }

    public static boolean axU() {
        SwanAppActivity akI;
        e akM = e.akM();
        if (akM != null && (akI = akM.akI()) != null) {
            com.baidu.swan.apps.framework.c Om = akI.Om();
            if (Om instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) Om).awz();
            }
            return false;
        }
        return false;
    }

    public static long axV() {
        SwanAppActivity akI;
        e akM = e.akM();
        if (akM != null && (akI = akM.akI()) != null) {
            com.baidu.swan.apps.framework.c Om = akI.Om();
            if (Om instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) Om).awA();
            }
            return 0L;
        }
        return 0L;
    }
}
