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
    public static void d(b.a aVar) {
        Bundle ajl;
        if (aVar != null && aGy() && (ajl = aVar.ajl()) != null && ajl.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ho(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ajg();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.cOI = String.valueOf(currentTimeMillis - j);
            fVar.py(ajl.getString("ubc"));
            h.onEvent(fVar);
            ajl.remove("page_display_flag_for_statistic");
        }
    }

    public static void b(String str, b.a aVar) {
        Bundle ajl;
        if (aVar != null && !aGy() && (ajl = aVar.ajl()) != null && ajl.getLong("page_display_flag_for_statistic") > 0) {
            long j = aVar.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = new f();
            fVar.mFrom = h.ho(aVar.getAppFrameType());
            fVar.mAppId = aVar.getAppId();
            fVar.mSource = aVar.ajg();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.cOH = String.valueOf(currentTimeMillis - j);
            fVar.v(TiebaInitialize.LogFields.REASON, str);
            fVar.v("errorList", b.aGw().aGx());
            fVar.py(ajl.getString("ubc"));
            h.onEvent(fVar);
            ajl.remove("page_display_flag_for_statistic");
        }
    }

    public static void tz(String str) {
        if (com.baidu.swan.apps.runtime.d.arr().RU() == 1 && !aGy()) {
            i.mX("startup").f(new UbcFlowEvent(str));
        }
    }

    public static void G(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow mX = i.mX("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        mX.f(new UbcFlowEvent(optString).a(UbcFlowEvent.RecordType.UPDATE_RECENT).bm(optLong));
                    }
                }
            }
        }
    }

    public static boolean aGy() {
        SwanAppActivity arp;
        e arv = e.arv();
        if (arv != null && (arp = arv.arp()) != null) {
            com.baidu.swan.apps.framework.c RV = arp.RV();
            if (RV instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) RV).aFb();
            }
            return false;
        }
        return false;
    }

    public static long aGz() {
        SwanAppActivity arp;
        e arv = e.arv();
        if (arv != null && (arp = arv.arp()) != null) {
            com.baidu.swan.apps.framework.c RV = arp.RV();
            if (RV instanceof com.baidu.swan.games.j.b) {
                return ((com.baidu.swan.games.j.b) RV).aFc();
            }
            return 0L;
        }
        return 0L;
    }
}
