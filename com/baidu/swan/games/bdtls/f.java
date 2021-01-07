package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes9.dex */
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
            int intValue = jVar.aYX() != null ? jVar.aYX().intValue() : -1;
            int intValue2 = jVar.aYY() != null ? jVar.aYY().intValue() : -1;
            int intValue3 = jVar.aYZ() != null ? jVar.aYZ().intValue() : -1;
            int intValue4 = jVar.aZa() != null ? jVar.aZa().intValue() : -1;
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

    public static void wU(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aXU = e.aXT().aXU();
        if (aXU == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aXU.aYX() != null ? aXU.aYX().intValue() : -1;
            int intValue2 = aXU.aYY() != null ? aXU.aYY().intValue() : -1;
            int intValue3 = aXU.aYZ() != null ? aXU.aYZ().intValue() : -1;
            int intValue4 = aXU.aZa() != null ? aXU.aZa().intValue() : -1;
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
