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
        Bundle ayI;
        if (aVar != null && aXd() && (ayI = aVar.ayI()) != null && ayI.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ky(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ayD();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dAq = String.valueOf(currentTimeMillis - j);
            fVar.tm(ayI.getString("ubc"));
            h.onEvent(fVar);
            ayI.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle ayI;
        if (aVar != null && !aXd() && (ayI = aVar.ayI()) != null && ayI.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ky(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ayD();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dAp = String.valueOf(currentTimeMillis - j);
            fVar.u(TiebaInitialize.LogFields.REASON, str);
            fVar.u("errorList", b.aXb().aXc());
            fVar.tm(ayI.getString("ubc"));
            h.onEvent(fVar);
            ayI.remove("page_display_flag_for_statistic");
        }
    }

    public static void xC(String str) {
        if (com.baidu.swan.apps.runtime.d.aHq().afE() == 1 && !aXd()) {
            i.qJ("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow qJ = i.qJ("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        qJ.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(optLong));
                    }
                }
            }
        }
    }

    public static boolean aXd() {
        SwanAppActivity aHo;
        e aHu = e.aHu();
        if (aHu != null && (aHo = aHu.aHo()) != null) {
            com.baidu.swan.apps.framework.c afF = aHo.afF();
            if (afF instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afF).aVE();
            }
            return false;
        }
        return false;
    }

    public static long aXe() {
        SwanAppActivity aHo;
        e aHu = e.aHu();
        if (aHu != null && (aHo = aHu.aHo()) != null) {
            com.baidu.swan.apps.framework.c afF = aHo.afF();
            if (afF instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afF).aVF();
            }
            return 0L;
        }
        return 0L;
    }
}
