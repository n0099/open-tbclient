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
        List<com.baidu.swan.apps.ac.f.a> jV = swanAppConfigData.jV(3);
        if (jV == null || jV.isEmpty()) {
            com.baidu.swan.apps.ac.g.b.cf("dynamicLibPath", null);
            com.baidu.swan.apps.ac.g.b.cf("dynamicLibConfig", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone dynamic lib");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (com.baidu.swan.apps.ac.f.a aVar : jV) {
            if (aVar != null && aVar.isValid()) {
                String str2 = aVar.Tc;
                long d = d(d.ol(str2), str2);
                long ti = com.baidu.swan.apps.swancore.b.ti(aVar.cWE);
                File bD = d > ti ? d.bD(str2, String.valueOf(d)) : null;
                if (bD == null) {
                    try {
                        str = aVar.cWG;
                        com.baidu.swan.apps.ac.d.a.print("apply path inner swan app, name = " + str2);
                    } catch (JSONException e) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                    }
                } else {
                    str = bD.getAbsolutePath();
                    com.baidu.swan.apps.ac.d.a.print("apply path in workspace, name = " + str2);
                }
                jSONObject.put(str2, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.cWH)) {
                    File file = new File(str, aVar.cWH);
                    if (file.exists()) {
                        String readFileData = com.baidu.swan.c.d.readFileData(file);
                        com.baidu.swan.apps.ac.d.a.print("pages info = " + readFileData);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(readFileData));
                        jSONObject2.put(str2, jSONObject3);
                    }
                }
                if (d > ti) {
                    try {
                        aVar = (com.baidu.swan.apps.ac.f.a) aVar.clone();
                    } catch (CloneNotSupportedException e2) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                    }
                    aVar.cWE = com.baidu.swan.apps.swancore.b.bU(d);
                }
                if (z) {
                    a(aVar, true);
                }
            }
        }
        String jSONObject4 = jSONObject.toString();
        String jSONObject5 = jSONObject2.toString();
        com.baidu.swan.apps.ac.g.b.cf("dynamicLibPath", jSONObject4);
        com.baidu.swan.apps.ac.g.b.cf("dynamicLibConfig", jSONObject5);
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
        List<com.baidu.swan.apps.ac.f.a> jV = swanAppConfigData.jV(3);
        if (jV == null || jV.isEmpty()) {
            if (DEBUG) {
                com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone dynamic lib");
            }
            return null;
        }
        String cg = com.baidu.swan.apps.ac.g.b.cg("dynamicLibPath", null);
        if (TextUtils.isEmpty(cg)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            for (com.baidu.swan.apps.ac.f.a aVar : jV) {
                if (aVar != null && aVar.isValid()) {
                    String str2 = aVar.Tc;
                    long d = d(d.ol(str2), str2);
                    long ti = com.baidu.swan.apps.swancore.b.ti(aVar.cWE);
                    File bD = d > ti ? d.bD(str2, String.valueOf(d)) : null;
                    if (bD == null) {
                        try {
                            str = aVar.cWG;
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print("apply path inner swan app, name = " + str2);
                            }
                        } catch (JSONException e) {
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                            }
                        }
                    } else {
                        str = bD.getAbsolutePath();
                        if (DEBUG) {
                            com.baidu.swan.apps.ac.d.a.print("apply path in workspace, name = " + str2);
                        }
                    }
                    jSONObject.put(str2, str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.cWH)) {
                        File file = new File(str, aVar.cWH);
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
                    if (d > ti) {
                        try {
                            aVar = (com.baidu.swan.apps.ac.f.a) aVar.clone();
                        } catch (CloneNotSupportedException e2) {
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                            }
                        }
                        aVar.cWE = com.baidu.swan.apps.swancore.b.bU(d);
                    }
                    if (z) {
                        a(aVar, true);
                    }
                }
            }
            String jSONObject4 = jSONObject.toString();
            String jSONObject5 = jSONObject2.toString();
            com.baidu.swan.apps.ac.g.b.cf("dynamicLibPath", jSONObject4);
            com.baidu.swan.apps.ac.g.b.cf("dynamicLibConfig", jSONObject5);
            return jSONObject4;
        }
        return cg;
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
        final String str = aVar.Tc;
        String str2 = aVar.cWE;
        h dk = com.baidu.swan.pms.database.a.aWO().dk(str, str2);
        if (dk != null && !dk.aXb()) {
            com.baidu.swan.apps.ac.d.a.print("plugin is new, not yet expired");
        } else {
            c.a(new com.baidu.swan.pms.c.d.d(str, str2, aVar.cWF), new com.baidu.swan.apps.ac.a.a(str, str2, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.ac.b.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: e */
                public void O(Boolean bool) {
                    com.baidu.swan.apps.ac.d.a.print("download plugin result = " + bool);
                    if (z) {
                        com.baidu.swan.apps.ac.e.a.R(str, 2);
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
                h dk = com.baidu.swan.pms.database.a.aWO().dk(str, com.baidu.swan.apps.swancore.b.bU(j));
                if (j > j2) {
                    if (dk == null) {
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

    public static boolean qA(String str) {
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
                    String cg = com.baidu.swan.apps.ac.g.b.cg("dynamicLibConfig", null);
                    if (TextUtils.isEmpty(cg)) {
                        return false;
                    }
                    try {
                        JSONObject optJSONObject2 = new JSONObject(cg).optJSONObject(str2);
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
