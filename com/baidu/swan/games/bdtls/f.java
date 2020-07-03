package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
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
            int intValue = jVar.azX() != null ? jVar.azX().intValue() : -1;
            int intValue2 = jVar.azY() != null ? jVar.azY().intValue() : -1;
            int intValue3 = jVar.azZ() != null ? jVar.azZ().intValue() : -1;
            int intValue4 = jVar.aAa() != null ? jVar.aAa().intValue() : -1;
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

    public static void rq(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j ayU = e.ayT().ayU();
        if (ayU == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = ayU.azX() != null ? ayU.azX().intValue() : -1;
            int intValue2 = ayU.azY() != null ? ayU.azY().intValue() : -1;
            int intValue3 = ayU.azZ() != null ? ayU.azZ().intValue() : -1;
            int intValue4 = ayU.aAa() != null ? ayU.aAa().intValue() : -1;
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
