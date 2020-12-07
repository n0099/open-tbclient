package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes25.dex */
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
            int intValue = jVar.aWC() != null ? jVar.aWC().intValue() : -1;
            int intValue2 = jVar.aWD() != null ? jVar.aWD().intValue() : -1;
            int intValue3 = jVar.aWE() != null ? jVar.aWE().intValue() : -1;
            int intValue4 = jVar.aWF() != null ? jVar.aWF().intValue() : -1;
            String str2 = alert.getDescription() != null ? new String(alert.getDescription().toByteArray()) : "";
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "alert";
            fVar.mValue = str;
            fVar.t("dh_group_id", Integer.valueOf(intValue));
            fVar.t("dh_secret", Integer.valueOf(intValue2));
            fVar.t("dh_pub_c", Integer.valueOf(intValue3));
            fVar.t("dh_pub_s", Integer.valueOf(intValue4));
            fVar.t("alert_msg", str2);
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

    public static void wV(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aVz = e.aVy().aVz();
        if (aVz == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aVz.aWC() != null ? aVz.aWC().intValue() : -1;
            int intValue2 = aVz.aWD() != null ? aVz.aWD().intValue() : -1;
            int intValue3 = aVz.aWE() != null ? aVz.aWE().intValue() : -1;
            int intValue4 = aVz.aWF() != null ? aVz.aWF().intValue() : -1;
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = str;
            fVar.t("dh_group_id", Integer.valueOf(intValue));
            fVar.t("dh_secret", Integer.valueOf(intValue2));
            fVar.t("dh_pub_c", Integer.valueOf(intValue3));
            fVar.t("dh_pub_s", Integer.valueOf(intValue4));
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
