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
        Bundle azi;
        if (aVar != null && aYq() && (azi = aVar.azi()) != null && azi.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jv(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.azd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dNf = String.valueOf(currentTimeMillis - j);
            fVar.ta(azi.getString("ubc"));
            h.onEvent(fVar);
            azi.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle azi;
        if (aVar != null && !aYq() && (azi = aVar.azi()) != null && azi.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.jv(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.azd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dNe = String.valueOf(currentTimeMillis - j);
            fVar.s(TiebaInitialize.LogFields.REASON, str);
            fVar.s("errorList", b.aYo().aYp());
            fVar.ta(azi.getString("ubc"));
            h.onEvent(fVar);
            azi.remove("page_display_flag_for_statistic");
        }
    }

    public static void xs(String str) {
        if (com.baidu.swan.apps.runtime.d.aIJ().getFrameType() == 1 && !aYq()) {
            i.qr("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow qr = i.qr("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        qr.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(optLong));
                    }
                }
            }
        }
    }

    public static boolean aYq() {
        SwanAppActivity aIH;
        e aIN = e.aIN();
        if (aIN != null && (aIH = aIN.aIH()) != null) {
            com.baidu.swan.apps.framework.c afT = aIH.afT();
            if (afT instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afT).aWR();
            }
            return false;
        }
        return false;
    }

    public static long aYr() {
        SwanAppActivity aIH;
        e aIN = e.aIN();
        if (aIN != null && (aIH = aIN.aIH()) != null) {
            com.baidu.swan.apps.framework.c afT = aIH.afT();
            if (afT instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) afT).aWS();
            }
            return 0L;
        }
        return 0L;
    }
}
