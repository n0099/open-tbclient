package com.baidu.swan.games.bdtls;

import android.util.Log;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes8.dex */
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
            int intValue = jVar.aVs() != null ? jVar.aVs().intValue() : -1;
            int intValue2 = jVar.aVt() != null ? jVar.aVt().intValue() : -1;
            int intValue3 = jVar.aVu() != null ? jVar.aVu().intValue() : -1;
            int intValue4 = jVar.aVv() != null ? jVar.aVv().intValue() : -1;
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
            h.c(fVar);
        } catch (Exception e) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void wj(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aUp = e.aUo().aUp();
        if (aUp == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aUp.aVs() != null ? aUp.aVs().intValue() : -1;
            int intValue2 = aUp.aVt() != null ? aUp.aVt().intValue() : -1;
            int intValue3 = aUp.aVu() != null ? aUp.aVu().intValue() : -1;
            int intValue4 = aUp.aVv() != null ? aUp.aVv().intValue() : -1;
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
            h.c(fVar);
        } catch (Exception e) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
