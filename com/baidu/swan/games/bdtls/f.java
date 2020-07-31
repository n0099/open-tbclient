package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes7.dex */
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
            int intValue = jVar.aDC() != null ? jVar.aDC().intValue() : -1;
            int intValue2 = jVar.aDD() != null ? jVar.aDD().intValue() : -1;
            int intValue3 = jVar.aDE() != null ? jVar.aDE().intValue() : -1;
            int intValue4 = jVar.aDF() != null ? jVar.aDF().intValue() : -1;
            String str2 = alert.getDescription() != null ? new String(alert.getDescription().toByteArray()) : "";
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "alert";
            fVar.mValue = str;
            fVar.v("dh_group_id", Integer.valueOf(intValue));
            fVar.v("dh_secret", Integer.valueOf(intValue2));
            fVar.v("dh_pub_c", Integer.valueOf(intValue3));
            fVar.v("dh_pub_s", Integer.valueOf(intValue4));
            fVar.v("alert_msg", str2);
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

    public static void so(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aCz = e.aCy().aCz();
        if (aCz == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aCz.aDC() != null ? aCz.aDC().intValue() : -1;
            int intValue2 = aCz.aDD() != null ? aCz.aDD().intValue() : -1;
            int intValue3 = aCz.aDE() != null ? aCz.aDE().intValue() : -1;
            int intValue4 = aCz.aDF() != null ? aCz.aDF().intValue() : -1;
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = str;
            fVar.v("dh_group_id", Integer.valueOf(intValue));
            fVar.v("dh_secret", Integer.valueOf(intValue2));
            fVar.v("dh_pub_c", Integer.valueOf(intValue3));
            fVar.v("dh_pub_s", Integer.valueOf(intValue4));
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
