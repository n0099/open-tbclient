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
            int intValue = jVar.amQ() != null ? jVar.amQ().intValue() : -1;
            int intValue2 = jVar.amR() != null ? jVar.amR().intValue() : -1;
            int intValue3 = jVar.amS() != null ? jVar.amS().intValue() : -1;
            int intValue4 = jVar.amT() != null ? jVar.amT().intValue() : -1;
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

    public static void ou(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "bdtls success");
        }
        j alN = e.alM().alN();
        if (alN == null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = alN.amQ() != null ? alN.amQ().intValue() : -1;
            int intValue2 = alN.amR() != null ? alN.amR().intValue() : -1;
            int intValue3 = alN.amS() != null ? alN.amS().intValue() : -1;
            int intValue4 = alN.amT() != null ? alN.amT().intValue() : -1;
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
