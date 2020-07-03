package com.baidu.swan.games.v;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static void d(b.a aVar) {
        Bundle ahV;
        if (aVar != null && aCR() && (ahV = aVar.ahV()) != null && ahV.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.hf(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ahQ();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.cLn = String.valueOf(currentTimeMillis - j);
            fVar.oO(ahV.getString("ubc"));
            h.onEvent(fVar);
            ahV.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle ahV;
        if (aVar != null && !aCR() && (ahV = aVar.ahV()) != null && ahV.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.hf(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ahQ();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.cLm = String.valueOf(currentTimeMillis - j);
            fVar.v(TiebaInitialize.LogFields.REASON, str);
            fVar.v("errorList", b.aCP().aCQ());
            fVar.oO(ahV.getString("ubc"));
            h.onEvent(fVar);
            ahV.remove("page_display_flag_for_statistic");
        }
    }

    public static void sB(String str) {
        if (com.baidu.swan.apps.runtime.d.apI().RF() == 1 && !aCR()) {
            g.mx("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void F(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow mx = g.mx("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        mx.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(optLong));
                    }
                }
            }
        }
    }

    public static boolean aCR() {
        SwanAppActivity apG;
        e apM = e.apM();
        if (apM != null && (apG = apM.apG()) != null) {
            com.baidu.swan.apps.framework.c RG = apG.RG();
            if (RG instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) RG).aBu();
            }
            return false;
        }
        return false;
    }

    public static long aCS() {
        SwanAppActivity apG;
        e apM = e.apM();
        if (apM != null && (apG = apM.apG()) != null) {
            com.baidu.swan.apps.framework.c RG = apG.RG();
            if (RG instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) RG).aBv();
            }
            return 0L;
        }
        return 0L;
    }
}
