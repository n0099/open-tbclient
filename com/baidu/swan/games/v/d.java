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
        Bundle aCB;
        if (aVar != null && bbV() && (aCB = aVar.aCB()) != null && aCB.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.kX(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aCw();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dOm = String.valueOf(currentTimeMillis - j);
            fVar.tL(aCB.getString("ubc"));
            h.onEvent(fVar);
            aCB.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle aCB;
        if (aVar != null && !bbV() && (aCB = aVar.aCB()) != null && aCB.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.kX(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.aCw();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dOl = String.valueOf(currentTimeMillis - j);
            fVar.t(TiebaInitialize.LogFields.REASON, str);
            fVar.t("errorList", b.bbT().bbU());
            fVar.tL(aCB.getString("ubc"));
            h.onEvent(fVar);
            aCB.remove("page_display_flag_for_statistic");
        }
    }

    public static void yd(String str) {
        if (com.baidu.swan.apps.runtime.d.aMh().ajl() == 1 && !bbV()) {
            i.rd("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void J(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow rd = i.rd("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        rd.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(optLong));
                    }
                }
            }
        }
    }

    public static boolean bbV() {
        SwanAppActivity aMf;
        e aMl = e.aMl();
        if (aMl != null && (aMf = aMl.aMf()) != null) {
            com.baidu.swan.apps.framework.c ajm = aMf.ajm();
            if (ajm instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) ajm).baw();
            }
            return false;
        }
        return false;
    }

    public static long bbW() {
        SwanAppActivity aMf;
        e aMl = e.aMl();
        if (aMl != null && (aMf = aMl.aMf()) != null) {
            com.baidu.swan.apps.framework.c ajm = aMf.ajm();
            if (ajm instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) ajm).bax();
            }
            return 0L;
        }
        return 0L;
    }
}
