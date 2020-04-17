package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes11.dex */
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
            int intValue = jVar.avd() != null ? jVar.avd().intValue() : -1;
            int intValue2 = jVar.ave() != null ? jVar.ave().intValue() : -1;
            int intValue3 = jVar.avf() != null ? jVar.avf().intValue() : -1;
            int intValue4 = jVar.avg() != null ? jVar.avg().intValue() : -1;
            String str2 = alert.getDescription() != null ? new String(alert.getDescription().toByteArray()) : "";
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "alert";
            fVar.mValue = str;
            fVar.s("dh_group_id", Integer.valueOf(intValue));
            fVar.s("dh_secret", Integer.valueOf(intValue2));
            fVar.s("dh_pub_c", Integer.valueOf(intValue3));
            fVar.s("dh_pub_s", Integer.valueOf(intValue4));
            fVar.s("alert_msg", str2);
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc create event");
            }
            com.baidu.swan.apps.statistic.f.c(fVar);
        } catch (Exception e) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void pH(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aub = e.aua().aub();
        if (aub == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aub.avd() != null ? aub.avd().intValue() : -1;
            int intValue2 = aub.ave() != null ? aub.ave().intValue() : -1;
            int intValue3 = aub.avf() != null ? aub.avf().intValue() : -1;
            int intValue4 = aub.avg() != null ? aub.avg().intValue() : -1;
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = str;
            fVar.s("dh_group_id", Integer.valueOf(intValue));
            fVar.s("dh_secret", Integer.valueOf(intValue2));
            fVar.s("dh_pub_c", Integer.valueOf(intValue3));
            fVar.s("dh_pub_s", Integer.valueOf(intValue4));
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc create event");
            }
            com.baidu.swan.apps.statistic.f.c(fVar);
        } catch (Exception e) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
