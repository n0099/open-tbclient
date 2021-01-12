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
        Bundle ayH;
        if (aVar != null && aYb() && (ayH = aVar.ayH()) != null && ayH.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jr(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ayC();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dJA = String.valueOf(currentTimeMillis - j);
            fVar.sA(ayH.getString("ubc"));
            h.onEvent(fVar);
            ayH.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle ayH;
        if (aVar != null && !aYb() && (ayH = aVar.ayH()) != null && ayH.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jr(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ayC();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dJz = String.valueOf(currentTimeMillis - j);
            fVar.t(TiebaInitialize.LogFields.REASON, str);
            fVar.t("errorList", b.aXZ().aYa());
            fVar.sA(ayH.getString("ubc"));
            h.onEvent(fVar);
            ayH.remove("page_display_flag_for_statistic");
        }
    }

    public static void wS(String str) {
        if (com.baidu.swan.apps.runtime.d.aIn().afr() == 1 && !aYb()) {
            i.pS("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void J(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow pS = i.pS("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        pS.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(optLong));
                    }
                }
            }
        }
    }

    public static boolean aYb() {
        SwanAppActivity aIl;
        e aIr = e.aIr();
        if (aIr != null && (aIl = aIr.aIl()) != null) {
            com.baidu.swan.apps.framework.c afs = aIl.afs();
            if (afs instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afs).aWC();
            }
            return false;
        }
        return false;
    }

    public static long aYc() {
        SwanAppActivity aIl;
        e aIr = e.aIr();
        if (aIr != null && (aIl = aIr.aIl()) != null) {
            com.baidu.swan.apps.framework.c afs = aIl.afs();
            if (afs instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afs).aWD();
            }
            return 0L;
        }
        return 0L;
    }
}
