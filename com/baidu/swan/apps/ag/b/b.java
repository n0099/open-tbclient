package com.baidu.swan.apps.ag.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.c.d.d;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static String a(SwanAppConfigData swanAppConfigData, boolean z) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ag.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ag.f.a> fU = swanAppConfigData.fU(3);
        if (fU == null || fU.isEmpty()) {
            com.baidu.swan.apps.ag.g.b.aV("dynamicLibPath", null);
            com.baidu.swan.apps.ag.d.a.print("this swan app not apply on someone dynamic lib");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (com.baidu.swan.apps.ag.f.a aVar : fU) {
            if (aVar != null && aVar.isValid()) {
                String str = aVar.xy;
                long c = c(e.hM(str), str);
                long lX = com.baidu.swan.apps.swancore.b.lX(aVar.bDU);
                File ax = c > lX ? e.ax(str, String.valueOf(c)) : null;
                if (ax == null) {
                    try {
                        jSONObject.put(str, aVar.bDW);
                        com.baidu.swan.apps.ag.d.a.print("apply path inner swan app, name = " + str);
                    } catch (JSONException e) {
                        com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
                    }
                } else {
                    jSONObject.put(str, ax.getAbsolutePath());
                    com.baidu.swan.apps.ag.d.a.print("apply path in workspace, name = " + str);
                }
                if (c > lX) {
                    try {
                        aVar = (com.baidu.swan.apps.ag.f.a) aVar.clone();
                    } catch (CloneNotSupportedException e2) {
                        com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e2));
                    }
                    aVar.bDU = com.baidu.swan.apps.swancore.b.ay(c);
                }
                if (z) {
                    a(aVar, true);
                }
            }
        }
        String jSONObject2 = jSONObject.toString();
        com.baidu.swan.apps.ag.g.b.aV("dynamicLibPath", jSONObject2);
        return jSONObject2;
    }

    private static void a(com.baidu.swan.apps.ag.f.a aVar, final boolean z) {
        if (aVar == null || !aVar.isValid()) {
            com.baidu.swan.apps.ag.d.a.print("plugin is invalid");
            return;
        }
        final String str = aVar.xy;
        String str2 = aVar.bDU;
        h bT = com.baidu.swan.pms.database.a.aqM().bT(str, str2);
        if (bT != null && !bT.arb()) {
            com.baidu.swan.apps.ag.d.a.print("plugin is new, not yet expired");
        } else {
            c.a(new d(str, str2, aVar.bDV), new com.baidu.swan.apps.ag.a.a(str, str2, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.ag.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: d */
                public void D(Boolean bool) {
                    com.baidu.swan.apps.ag.d.a.print("download plugin result = " + bool);
                    if (z) {
                        com.baidu.swan.apps.ag.e.a.E(str, 2);
                    }
                }
            }));
        }
    }

    private static long c(File file, String str) {
        String[] list;
        long j;
        if (file == null || TextUtils.isEmpty(str) || (list = file.list()) == null || list.length == 0) {
            return -1L;
        }
        int length = list.length;
        int i = 0;
        long j2 = -1;
        while (i < length) {
            String str2 = list[i];
            if (TextUtils.isEmpty(str2)) {
                j = j2;
            } else {
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
                    j = -1;
                }
                h bT = com.baidu.swan.pms.database.a.aqM().bT(str, com.baidu.swan.apps.swancore.b.ay(j));
                if (j > j2) {
                    if (bT == null) {
                        com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(new RuntimeException("get latest plugin version, but it hasn't insert the db yet")));
                    }
                }
                j = j2;
            }
            i++;
            j2 = j;
        }
        return j2;
    }
}
