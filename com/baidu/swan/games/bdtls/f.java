package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes3.dex */
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
            int intValue = jVar.aNc() != null ? jVar.aNc().intValue() : -1;
            int intValue2 = jVar.aNd() != null ? jVar.aNd().intValue() : -1;
            int intValue3 = jVar.aNe() != null ? jVar.aNe().intValue() : -1;
            int intValue4 = jVar.aNf() != null ? jVar.aNf().intValue() : -1;
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

    public static void va(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aLZ = e.aLY().aLZ();
        if (aLZ == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aLZ.aNc() != null ? aLZ.aNc().intValue() : -1;
            int intValue2 = aLZ.aNd() != null ? aLZ.aNd().intValue() : -1;
            int intValue3 = aLZ.aNe() != null ? aLZ.aNe().intValue() : -1;
            int intValue4 = aLZ.aNf() != null ? aLZ.aNf().intValue() : -1;
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
