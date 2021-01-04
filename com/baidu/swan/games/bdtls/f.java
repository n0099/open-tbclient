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
            int intValue = jVar.aYW() != null ? jVar.aYW().intValue() : -1;
            int intValue2 = jVar.aYX() != null ? jVar.aYX().intValue() : -1;
            int intValue3 = jVar.aYY() != null ? jVar.aYY().intValue() : -1;
            int intValue4 = jVar.aYZ() != null ? jVar.aYZ().intValue() : -1;
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
        j aXT = e.aXS().aXT();
        if (aXT == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aXT.aYW() != null ? aXT.aYW().intValue() : -1;
            int intValue2 = aXT.aYX() != null ? aXT.aYX().intValue() : -1;
            int intValue3 = aXT.aYY() != null ? aXT.aYY().intValue() : -1;
            int intValue4 = aXT.aYZ() != null ? aXT.aYZ().intValue() : -1;
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
