package com.baidu.swan.apps.ae.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ae.g.b;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.e.d;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static String a(SwanAppConfigData swanAppConfigData, boolean z) {
        String str;
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ae.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ae.f.a> gX = swanAppConfigData.gX(3);
        if (gX == null || gX.isEmpty()) {
            b.bJ("dynamicLibPath", null);
            b.bJ("dynamicLibConfig", null);
            com.baidu.swan.apps.ae.d.a.print("this swan app not apply on someone dynamic lib");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (com.baidu.swan.apps.ae.f.a aVar : gX) {
            if (aVar != null && aVar.isValid()) {
                String str2 = aVar.RP;
                long d = d(e.kK(str2), str2);
                long pq = com.baidu.swan.apps.swancore.b.pq(aVar.cxP);
                File bj = d > pq ? e.bj(str2, String.valueOf(d)) : null;
                if (bj == null) {
                    try {
                        str = aVar.cxR;
                        com.baidu.swan.apps.ae.d.a.print("apply path inner swan app, name = " + str2);
                    } catch (JSONException e) {
                        com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
                    }
                } else {
                    str = bj.getAbsolutePath();
                    com.baidu.swan.apps.ae.d.a.print("apply path in workspace, name = " + str2);
                }
                jSONObject.put(str2, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.cxS)) {
                    File file = new File(str, aVar.cxS);
                    if (file.exists()) {
                        String readFileData = d.readFileData(file);
                        com.baidu.swan.apps.ae.d.a.print("pages info = " + readFileData);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(readFileData));
                        jSONObject2.put(str2, jSONObject3);
                    }
                }
                if (d > pq) {
                    try {
                        aVar = (com.baidu.swan.apps.ae.f.a) aVar.clone();
                    } catch (CloneNotSupportedException e2) {
                        com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e2));
                    }
                    aVar.cxP = com.baidu.swan.apps.swancore.b.bt(d);
                }
                if (z) {
                    a(aVar, true);
                }
            }
        }
        String jSONObject4 = jSONObject.toString();
        String jSONObject5 = jSONObject2.toString();
        b.bJ("dynamicLibPath", jSONObject4);
        b.bJ("dynamicLibConfig", jSONObject5);
        return jSONObject4;
    }

    private static void a(final com.baidu.swan.apps.ae.f.a aVar, final boolean z) {
        if (com.baidu.swan.apps.performance.b.b.amR()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ae.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.b(com.baidu.swan.apps.ae.f.a.this, z);
                }
            }, "requestDynamicLib", 2);
        } else {
            b(aVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.ae.f.a aVar, final boolean z) {
        if (aVar == null || !aVar.isValid()) {
            com.baidu.swan.apps.ae.d.a.print("plugin is invalid");
            return;
        }
        final String str = aVar.RP;
        String str2 = aVar.cxP;
        h cM = com.baidu.swan.pms.database.a.aHb().cM(str, str2);
        if (cM != null && !cM.aHr()) {
            com.baidu.swan.apps.ae.d.a.print("plugin is new, not yet expired");
        } else {
            c.a(new com.baidu.swan.pms.c.d.d(str, str2, aVar.cxQ), new com.baidu.swan.apps.ae.a.a(str, str2, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.ae.b.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: d */
                public void K(Boolean bool) {
                    com.baidu.swan.apps.ae.d.a.print("download plugin result = " + bool);
                    if (z) {
                        com.baidu.swan.apps.ae.e.a.O(str, 2);
                    }
                }
            }));
        }
    }

    private static long d(File file, String str) {
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
                    com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
                    j = -1;
                }
                h cM = com.baidu.swan.pms.database.a.aHb().cM(str, com.baidu.swan.apps.swancore.b.bt(j));
                if (j > j2) {
                    if (cM == null) {
                        com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(new RuntimeException("get latest plugin version, but it hasn't insert the db yet")));
                    }
                }
                j = j2;
            }
            i++;
            j2 = j;
        }
        return j2;
    }

    public static boolean mP(String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        int length;
        if (!TextUtils.isEmpty(str) && str.startsWith("__dynamicLib__")) {
            String[] split = str.split("/");
            if (split.length >= 2) {
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf < str.length()) {
                    String substring = str.substring(indexOf);
                    String bK = b.bK("dynamicLibConfig", null);
                    if (TextUtils.isEmpty(bK)) {
                        return false;
                    }
                    try {
                        JSONObject optJSONObject2 = new JSONObject(bK).optJSONObject(str2);
                        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("config")) == null || (optJSONArray = optJSONObject.optJSONArray("pages")) == null || (length = optJSONArray.length()) == 0) {
                            return false;
                        }
                        for (int i = 0; i < length; i++) {
                            if (TextUtils.equals(substring, optJSONArray.optString(i))) {
                                return true;
                            }
                        }
                        return false;
                    } catch (JSONException e) {
                        com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
