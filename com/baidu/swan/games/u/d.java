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
        Bundle VM;
        if (aVar != null && apD() && (VM = aVar.VM()) != null && VM.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.VH();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.bVs = String.valueOf(currentTimeMillis - j);
            fVar.lR(VM.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VM.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle VM;
        if (aVar != null && !apD() && (VM = aVar.VM()) != null && VM.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.VH();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.bVr = String.valueOf(currentTimeMillis - j);
            fVar.n(TiebaInitialize.LogFields.REASON, str);
            fVar.n("errorList", b.apB().apC());
            fVar.lR(VM.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VM.remove("page_display_flag_for_statistic");
        }
    }

    public static void pD(String str) {
        if (com.baidu.swan.apps.runtime.d.acA().Gs() == 1 && !apD()) {
            com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void F(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        jP.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(optLong));
                    }
                }
            }
        }
    }

    public static boolean apD() {
        SwanAppActivity acz;
        e acD = e.acD();
        if (acD != null && (acz = acD.acz()) != null) {
            com.baidu.swan.apps.framework.c Gt = acz.Gt();
            if (Gt instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) Gt).aoh();
            }
            return false;
        }
        return false;
    }

    public static long apE() {
        SwanAppActivity acz;
        e acD = e.acD();
        if (acD != null && (acz = acD.acz()) != null) {
            com.baidu.swan.apps.framework.c Gt = acz.Gt();
            if (Gt instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) Gt).aoi();
            }
            return 0L;
        }
        return 0L;
    }
}
