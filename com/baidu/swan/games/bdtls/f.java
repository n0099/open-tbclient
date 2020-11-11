package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes10.dex */
public class f {
    public static void a(j jVar, Bdtls.Alert alert) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls ubc");
        }
        if (jVar == null || alert == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            String str = alert.getLevel() == 1 ? "warning" : "fatal_error";
            int intValue = jVar.aUf() != null ? jVar.aUf().intValue() : -1;
            int intValue2 = jVar.aUg() != null ? jVar.aUg().intValue() : -1;
            int intValue3 = jVar.aUh() != null ? jVar.aUh().intValue() : -1;
            int intValue4 = jVar.aUi() != null ? jVar.aUi().intValue() : -1;
            String str2 = alert.getDescription() != null ? new String(alert.getDescription().toByteArray()) : "";
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "alert";
            fVar.mValue = str;
            fVar.u("dh_group_id", Integer.valueOf(intValue));
            fVar.u("dh_secret", Integer.valueOf(intValue2));
            fVar.u("dh_pub_c", Integer.valueOf(intValue3));
            fVar.u("dh_pub_s", Integer.valueOf(intValue4));
            fVar.u("alert_msg", str2);
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc create event");
            }
            h.c(fVar);
        } catch (Exception e) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void wt(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aTc = e.aTb().aTc();
        if (aTc == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aTc.aUf() != null ? aTc.aUf().intValue() : -1;
            int intValue2 = aTc.aUg() != null ? aTc.aUg().intValue() : -1;
            int intValue3 = aTc.aUh() != null ? aTc.aUh().intValue() : -1;
            int intValue4 = aTc.aUi() != null ? aTc.aUi().intValue() : -1;
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = str;
            fVar.u("dh_group_id", Integer.valueOf(intValue));
            fVar.u("dh_secret", Integer.valueOf(intValue2));
            fVar.u("dh_pub_c", Integer.valueOf(intValue3));
            fVar.u("dh_pub_s", Integer.valueOf(intValue4));
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc create event");
            }
            h.c(fVar);
        } catch (Exception e) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
