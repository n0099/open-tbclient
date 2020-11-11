package com.baidu.swan.apps.ac.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static String a(SwanAppConfigData swanAppConfigData, boolean z) {
        String str;
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kq = swanAppConfigData.kq(3);
        if (kq == null || kq.isEmpty()) {
            com.baidu.swan.apps.ac.g.b.cm("dynamicLibPath", null);
            com.baidu.swan.apps.ac.g.b.cm("dynamicLibConfig", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone dynamic lib");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (com.baidu.swan.apps.ac.f.a aVar : kq) {
            if (aVar != null && aVar.isValid()) {
                String str2 = aVar.Td;
                long d = d(d.oT(str2), str2);
                long tP = com.baidu.swan.apps.swancore.b.tP(aVar.dla);
                File bK = d > tP ? d.bK(str2, String.valueOf(d)) : null;
                if (bK == null) {
                    try {
                        str = aVar.dlc;
                        com.baidu.swan.apps.ac.d.a.print("apply path inner swan app, name = " + str2);
                    } catch (JSONException e) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                    }
                } else {
                    str = bK.getAbsolutePath();
                    com.baidu.swan.apps.ac.d.a.print("apply path in workspace, name = " + str2);
                }
                jSONObject.put(str2, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.dld)) {
                    File file = new File(str, aVar.dld);
                    if (file.exists()) {
                        String readFileData = com.baidu.swan.c.d.readFileData(file);
                        com.baidu.swan.apps.ac.d.a.print("pages info = " + readFileData);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(readFileData));
                        jSONObject2.put(str2, jSONObject3);
                    }
                }
                if (d > tP) {
                    try {
                        aVar = (com.baidu.swan.apps.ac.f.a) aVar.clone();
                    } catch (CloneNotSupportedException e2) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                    }
                    aVar.dla = com.baidu.swan.apps.swancore.b.cs(d);
                }
                if (z) {
                    a(aVar, true);
                }
            }
        }
        String jSONObject4 = jSONObject.toString();
        String jSONObject5 = jSONObject2.toString();
        com.baidu.swan.apps.ac.g.b.cm("dynamicLibPath", jSONObject4);
        com.baidu.swan.apps.ac.g.b.cm("dynamicLibConfig", jSONObject5);
        return jSONObject4;
    }

    public static String b(SwanAppConfigData swanAppConfigData, boolean z) {
        String str;
        if (swanAppConfigData == null) {
            if (DEBUG) {
                com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            }
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kq = swanAppConfigData.kq(3);
        if (kq == null || kq.isEmpty()) {
            if (DEBUG) {
                com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone dynamic lib");
            }
            return null;
        }
        String cn2 = com.baidu.swan.apps.ac.g.b.cn("dynamicLibPath", null);
        if (TextUtils.isEmpty(cn2)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            for (com.baidu.swan.apps.ac.f.a aVar : kq) {
                if (aVar != null && aVar.isValid()) {
                    String str2 = aVar.Td;
                    long d = d(d.oT(str2), str2);
                    long tP = com.baidu.swan.apps.swancore.b.tP(aVar.dla);
                    File bK = d > tP ? d.bK(str2, String.valueOf(d)) : null;
                    if (bK == null) {
                        try {
                            str = aVar.dlc;
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print("apply path inner swan app, name = " + str2);
                            }
                        } catch (JSONException e) {
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                            }
                        }
                    } else {
                        str = bK.getAbsolutePath();
                        if (DEBUG) {
                            com.baidu.swan.apps.ac.d.a.print("apply path in workspace, name = " + str2);
                        }
                    }
                    jSONObject.put(str2, str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.dld)) {
                        File file = new File(str, aVar.dld);
                        if (file.exists()) {
                            String readFileData = com.baidu.swan.c.d.readFileData(file);
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print("pages info = " + readFileData);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("config", new JSONObject(readFileData));
                            jSONObject2.put(str2, jSONObject3);
                        }
                    }
                    if (d > tP) {
                        try {
                            aVar = (com.baidu.swan.apps.ac.f.a) aVar.clone();
                        } catch (CloneNotSupportedException e2) {
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                            }
                        }
                        aVar.dla = com.baidu.swan.apps.swancore.b.cs(d);
                    }
                    if (z) {
                        a(aVar, true);
                    }
                }
            }
            String jSONObject4 = jSONObject.toString();
            String jSONObject5 = jSONObject2.toString();
            com.baidu.swan.apps.ac.g.b.cm("dynamicLibPath", jSONObject4);
            com.baidu.swan.apps.ac.g.b.cm("dynamicLibConfig", jSONObject5);
            return jSONObject4;
        }
        return cn2;
    }

    private static void a(final com.baidu.swan.apps.ac.f.a aVar, final boolean z) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.b(com.baidu.swan.apps.ac.f.a.this, z);
            }
        }, "requestDynamicLib", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.ac.f.a aVar, final boolean z) {
        if (aVar == null || !aVar.isValid()) {
            com.baidu.swan.apps.ac.d.a.print("plugin is invalid");
            return;
        }
        final String str = aVar.Td;
        String str2 = aVar.dla;
        h dr = com.baidu.swan.pms.database.a.bbh().dr(str, str2);
        if (dr != null && !dr.bbu()) {
            com.baidu.swan.apps.ac.d.a.print("plugin is new, not yet expired");
        } else {
            c.a(new com.baidu.swan.pms.c.d.d(str, str2, aVar.dlb), new com.baidu.swan.apps.ac.a.a(str, str2, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.ac.b.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: e */
                public void O(Boolean bool) {
                    com.baidu.swan.apps.ac.d.a.print("download plugin result = " + bool);
                    if (z) {
                        com.baidu.swan.apps.ac.e.a.T(str, 2);
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
                    com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                    j = -1;
                }
                h dr = com.baidu.swan.pms.database.a.bbh().dr(str, com.baidu.swan.apps.swancore.b.cs(j));
                if (j > j2) {
                    if (dr == null) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(new RuntimeException("get latest plugin version, but it hasn't insert the db yet")));
                    }
                }
                j = j2;
            }
            i++;
            j2 = j;
        }
        return j2;
    }

    public static boolean rh(String str) {
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
                    String cn2 = com.baidu.swan.apps.ac.g.b.cn("dynamicLibConfig", null);
                    if (TextUtils.isEmpty(cn2)) {
                        return false;
                    }
                    try {
                        JSONObject optJSONObject2 = new JSONObject(cn2).optJSONObject(str2);
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
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
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
