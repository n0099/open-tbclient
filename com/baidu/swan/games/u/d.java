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
/* loaded from: classes9.dex */
public class d {
    public static void d(b.a aVar) {
        Bundle Tb;
        if (aVar != null && amW() && (Tb = aVar.Tb()) != null && Tb.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.SW();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.bQD = String.valueOf(currentTimeMillis - j);
            fVar.lz(Tb.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            Tb.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle Tb;
        if (aVar != null && !amW() && (Tb = aVar.Tb()) != null && Tb.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.SW();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.bQC = String.valueOf(currentTimeMillis - j);
            fVar.n(TiebaInitialize.LogFields.REASON, str);
            fVar.n("errorList", b.amU().amV());
            fVar.lz(Tb.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            Tb.remove("page_display_flag_for_statistic");
        }
    }

    public static void pl(String str) {
        if (com.baidu.swan.apps.runtime.d.ZP().DH() == 1 && !amW()) {
            com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void E(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        jx.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).an(optLong));
                    }
                }
            }
        }
    }

    public static boolean amW() {
        SwanAppActivity ZO;
        e ZS = e.ZS();
        if (ZS != null && (ZO = ZS.ZO()) != null) {
            com.baidu.swan.apps.framework.c DI = ZO.DI();
            if (DI instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) DI).alB();
            }
            return false;
        }
        return false;
    }

    public static long amX() {
        SwanAppActivity ZO;
        e ZS = e.ZS();
        if (ZS != null && (ZO = ZS.ZO()) != null) {
            com.baidu.swan.apps.framework.c DI = ZO.DI();
            if (DI instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) DI).alC();
            }
            return 0L;
        }
        return 0L;
    }
}
