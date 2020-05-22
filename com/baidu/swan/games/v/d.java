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
        Bundle agP;
        if (aVar != null && aBL() && (agP = aVar.agP()) != null && agP.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.gS(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.agK();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.cGD = String.valueOf(currentTimeMillis - j);
            fVar.oG(agP.getString("ubc"));
            h.onEvent(fVar);
            agP.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle agP;
        if (aVar != null && !aBL() && (agP = aVar.agP()) != null && agP.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.gS(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.agK();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.cGC = String.valueOf(currentTimeMillis - j);
            fVar.v(TiebaInitialize.LogFields.REASON, str);
            fVar.v("errorList", b.aBJ().aBK());
            fVar.oG(agP.getString("ubc"));
            h.onEvent(fVar);
            agP.remove("page_display_flag_for_statistic");
        }
    }

    public static void st(String str) {
        if (com.baidu.swan.apps.runtime.d.aoB().Qz() == 1 && !aBL()) {
            g.mp("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void F(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow mp = g.mp("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        mp.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(optLong));
                    }
                }
            }
        }
    }

    public static boolean aBL() {
        SwanAppActivity aoz;
        e aoF = e.aoF();
        if (aoF != null && (aoz = aoF.aoz()) != null) {
            com.baidu.swan.apps.framework.c QA = aoz.QA();
            if (QA instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) QA).aAo();
            }
            return false;
        }
        return false;
    }

    public static long aBM() {
        SwanAppActivity aoz;
        e aoF = e.aoF();
        if (aoF != null && (aoz = aoF.aoz()) != null) {
            com.baidu.swan.apps.framework.c QA = aoz.QA();
            if (QA instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) QA).aAp();
            }
            return 0L;
        }
        return 0L;
    }
}
