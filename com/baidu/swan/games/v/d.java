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
/* loaded from: classes3.dex */
public class d {
    public static void e(b.a aVar) {
        Bundle arC;
        if (aVar != null && aQa() && (arC = aVar.arC()) != null && arC.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jG(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.arx();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.cZM = String.valueOf(currentTimeMillis - j);
            fVar.rS(arC.getString("ubc"));
            h.onEvent(fVar);
            arC.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle arC;
        if (aVar != null && !aQa() && (arC = aVar.arC()) != null && arC.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jG(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.arx();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.cZL = String.valueOf(currentTimeMillis - j);
            fVar.u(TiebaInitialize.LogFields.REASON, str);
            fVar.u("errorList", b.aPY().aPZ());
            fVar.rS(arC.getString("ubc"));
            h.onEvent(fVar);
            arC.remove("page_display_flag_for_statistic");
        }
    }

    public static void wj(String str) {
        if (com.baidu.swan.apps.runtime.d.aAn().Yy() == 1 && !aQa()) {
            i.pq("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow pq = i.pq("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        pq.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bs(optLong));
                    }
                }
            }
        }
    }

    public static boolean aQa() {
        SwanAppActivity aAl;
        e aAr = e.aAr();
        if (aAr != null && (aAl = aAr.aAl()) != null) {
            com.baidu.swan.apps.framework.c Yz = aAl.Yz();
            if (Yz instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) Yz).aOB();
            }
            return false;
        }
        return false;
    }

    public static long aQb() {
        SwanAppActivity aAl;
        e aAr = e.aAr();
        if (aAr != null && (aAl = aAr.aAl()) != null) {
            com.baidu.swan.apps.framework.c Yz = aAl.Yz();
            if (Yz instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) Yz).aOC();
            }
            return 0L;
        }
        return 0L;
    }
}
