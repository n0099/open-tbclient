package com.baidu.swan.games.bdtls;

import android.util.Log;
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
            int intValue = jVar.akx() != null ? jVar.akx().intValue() : -1;
            int intValue2 = jVar.aky() != null ? jVar.aky().intValue() : -1;
            int intValue3 = jVar.akz() != null ? jVar.akz().intValue() : -1;
            int intValue4 = jVar.akA() != null ? jVar.akA().intValue() : -1;
            String str2 = alert.getDescription() != null ? new String(alert.getDescription().toByteArray()) : "";
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "alert";
            fVar.mValue = str;
            fVar.n("dh_group_id", Integer.valueOf(intValue));
            fVar.n("dh_secret", Integer.valueOf(intValue2));
            fVar.n("dh_pub_c", Integer.valueOf(intValue3));
            fVar.n("dh_pub_s", Integer.valueOf(intValue4));
            fVar.n("alert_msg", str2);
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

    public static void oe(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j aju = e.ajt().aju();
        if (aju == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = aju.akx() != null ? aju.akx().intValue() : -1;
            int intValue2 = aju.aky() != null ? aju.aky().intValue() : -1;
            int intValue3 = aju.akz() != null ? aju.akz().intValue() : -1;
            int intValue4 = aju.akA() != null ? aju.akA().intValue() : -1;
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = str;
            fVar.n("dh_group_id", Integer.valueOf(intValue));
            fVar.n("dh_secret", Integer.valueOf(intValue2));
            fVar.n("dh_pub_c", Integer.valueOf(intValue3));
            fVar.n("dh_pub_s", Integer.valueOf(intValue4));
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
