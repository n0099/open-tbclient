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
/* loaded from: classes7.dex */
public class d {
    public static void e(b.a aVar) {
        Bundle aya;
        if (aVar != null && aWv() && (aya = aVar.aya()) != null && aya.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ku(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.axV();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.dyJ = String.valueOf(currentTimeMillis - j);
            fVar.th(aya.getString("ubc"));
            h.onEvent(fVar);
            aya.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle aya;
        if (aVar != null && !aWv() && (aya = aVar.aya()) != null && aya.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ku(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.axV();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.dyI = String.valueOf(currentTimeMillis - j);
            fVar.u(TiebaInitialize.LogFields.REASON, str);
            fVar.u("errorList", b.aWt().aWu());
            fVar.th(aya.getString("ubc"));
            h.onEvent(fVar);
            aya.remove("page_display_flag_for_statistic");
        }
    }

    public static void xx(String str) {
        if (com.baidu.swan.apps.runtime.d.aGI().aeW() == 1 && !aWv()) {
            i.qD("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow qD = i.qD("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        qD.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(optLong));
                    }
                }
            }
        }
    }

    public static boolean aWv() {
        SwanAppActivity aGG;
        e aGM = e.aGM();
        if (aGM != null && (aGG = aGM.aGG()) != null) {
            com.baidu.swan.apps.framework.c aeX = aGG.aeX();
            if (aeX instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) aeX).aUW();
            }
            return false;
        }
        return false;
    }

    public static long aWw() {
        SwanAppActivity aGG;
        e aGM = e.aGM();
        if (aGM != null && (aGG = aGM.aGG()) != null) {
            com.baidu.swan.apps.framework.c aeX = aGG.aeX();
            if (aeX instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) aeX).aUX();
            }
            return 0L;
        }
        return 0L;
    }
}
