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
        Bundle VR;
        if (aVar != null && apI() && (VR = aVar.VR()) != null && VR.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.VM();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.bVF = String.valueOf(currentTimeMillis - j);
            fVar.lQ(VR.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VR.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle VR;
        if (aVar != null && !apI() && (VR = aVar.VR()) != null && VR.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.VM();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.bVE = String.valueOf(currentTimeMillis - j);
            fVar.n(TiebaInitialize.LogFields.REASON, str);
            fVar.n("errorList", b.apG().apH());
            fVar.lQ(VR.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VR.remove("page_display_flag_for_statistic");
        }
    }

    public static void pC(String str) {
        if (com.baidu.swan.apps.runtime.d.acF().Gz() == 1 && !apI()) {
            com.baidu.swan.apps.performance.f.jO("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void F(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        jO.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(optLong));
                    }
                }
            }
        }
    }

    public static boolean apI() {
        SwanAppActivity acE;
        e acI = e.acI();
        if (acI != null && (acE = acI.acE()) != null) {
            com.baidu.swan.apps.framework.c GA = acE.GA();
            if (GA instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) GA).aom();
            }
            return false;
        }
        return false;
    }

    public static long apJ() {
        SwanAppActivity acE;
        e acI = e.acI();
        if (acI != null && (acE = acI.acE()) != null) {
            com.baidu.swan.apps.framework.c GA = acE.GA();
            if (GA instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) GA).aon();
            }
            return 0L;
        }
        return 0L;
    }
}
