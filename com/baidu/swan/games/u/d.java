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
/* loaded from: classes10.dex */
public class d {
    public static void d(b.a aVar) {
        Bundle Ty;
        if (aVar != null && anp() && (Ty = aVar.Ty()) != null && Ty.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.Tt();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.bRn = String.valueOf(currentTimeMillis - j);
            fVar.lC(Ty.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            Ty.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle Ty;
        if (aVar != null && !anp() && (Ty = aVar.Ty()) != null && Ty.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.Tt();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.bRm = String.valueOf(currentTimeMillis - j);
            fVar.n(TiebaInitialize.LogFields.REASON, str);
            fVar.n("errorList", b.ann().ano());
            fVar.lC(Ty.getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            Ty.remove("page_display_flag_for_statistic");
        }
    }

    public static void po(String str) {
        if (com.baidu.swan.apps.runtime.d.aam().Ed() == 1 && !anp()) {
            com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void F(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        jA.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).aq(optLong));
                    }
                }
            }
        }
    }

    public static boolean anp() {
        SwanAppActivity aal;
        e aap = e.aap();
        if (aap != null && (aal = aap.aal()) != null) {
            com.baidu.swan.apps.framework.c Ee = aal.Ee();
            if (Ee instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) Ee).alU();
            }
            return false;
        }
        return false;
    }

    public static long anq() {
        SwanAppActivity aal;
        e aap = e.aap();
        if (aap != null && (aal = aap.aal()) != null) {
            com.baidu.swan.apps.framework.c Ee = aal.Ee();
            if (Ee instanceof com.baidu.swan.games.i.b) {
                return ((com.baidu.swan.games.i.b) Ee).alV();
            }
            return 0L;
        }
        return 0L;
    }
}
