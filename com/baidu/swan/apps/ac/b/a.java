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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static String a(SwanAppConfigData swanAppConfigData, boolean z) {
        String str;
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jn = swanAppConfigData.jn(3);
        if (jn == null || jn.isEmpty()) {
            com.baidu.swan.apps.ac.g.b.ca("dynamicLibPath", null);
            com.baidu.swan.apps.ac.g.b.ca("dynamicLibConfig", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone dynamic lib");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (com.baidu.swan.apps.ac.f.a aVar : jn) {
            if (aVar != null && aVar.isValid()) {
                String str2 = aVar.Sq;
                long d = d(d.ne(str2), str2);
                long sb = com.baidu.swan.apps.swancore.b.sb(aVar.cIx);
                File by = d > sb ? d.by(str2, String.valueOf(d)) : null;
                if (by == null) {
                    try {
                        str = aVar.cIz;
                        com.baidu.swan.apps.ac.d.a.print("apply path inner swan app, name = " + str2);
                    } catch (JSONException e) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                    }
                } else {
                    str = by.getAbsolutePath();
                    com.baidu.swan.apps.ac.d.a.print("apply path in workspace, name = " + str2);
                }
                jSONObject.put(str2, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.cIA)) {
                    File file = new File(str, aVar.cIA);
                    if (file.exists()) {
                        String readFileData = com.baidu.swan.c.d.readFileData(file);
                        com.baidu.swan.apps.ac.d.a.print("pages info = " + readFileData);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(readFileData));
                        jSONObject2.put(str2, jSONObject3);
                    }
                }
                if (d > sb) {
                    try {
                        aVar = (com.baidu.swan.apps.ac.f.a) aVar.clone();
                    } catch (CloneNotSupportedException e2) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                    }
                    aVar.cIx = com.baidu.swan.apps.swancore.b.bL(d);
                }
                if (z) {
                    a(aVar, true);
                }
            }
        }
        String jSONObject4 = jSONObject.toString();
        String jSONObject5 = jSONObject2.toString();
        com.baidu.swan.apps.ac.g.b.ca("dynamicLibPath", jSONObject4);
        com.baidu.swan.apps.ac.g.b.ca("dynamicLibConfig", jSONObject5);
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
        List<com.baidu.swan.apps.ac.f.a> jn = swanAppConfigData.jn(3);
        if (jn == null || jn.isEmpty()) {
            if (DEBUG) {
                com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone dynamic lib");
            }
            return null;
        }
        String cb = com.baidu.swan.apps.ac.g.b.cb("dynamicLibPath", null);
        if (TextUtils.isEmpty(cb)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            for (com.baidu.swan.apps.ac.f.a aVar : jn) {
                if (aVar != null && aVar.isValid()) {
                    String str2 = aVar.Sq;
                    long d = d(d.ne(str2), str2);
                    long sb = com.baidu.swan.apps.swancore.b.sb(aVar.cIx);
                    File by = d > sb ? d.by(str2, String.valueOf(d)) : null;
                    if (by == null) {
                        try {
                            str = aVar.cIz;
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print("apply path inner swan app, name = " + str2);
                            }
                        } catch (JSONException e) {
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                            }
                        }
                    } else {
                        str = by.getAbsolutePath();
                        if (DEBUG) {
                            com.baidu.swan.apps.ac.d.a.print("apply path in workspace, name = " + str2);
                        }
                    }
                    jSONObject.put(str2, str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.cIA)) {
                        File file = new File(str, aVar.cIA);
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
                    if (d > sb) {
                        try {
                            aVar = (com.baidu.swan.apps.ac.f.a) aVar.clone();
                        } catch (CloneNotSupportedException e2) {
                            if (DEBUG) {
                                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                            }
                        }
                        aVar.cIx = com.baidu.swan.apps.swancore.b.bL(d);
                    }
                    if (z) {
                        a(aVar, true);
                    }
                }
            }
            String jSONObject4 = jSONObject.toString();
            String jSONObject5 = jSONObject2.toString();
            com.baidu.swan.apps.ac.g.b.ca("dynamicLibPath", jSONObject4);
            com.baidu.swan.apps.ac.g.b.ca("dynamicLibConfig", jSONObject5);
            return jSONObject4;
        }
        return cb;
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
        final String str = aVar.Sq;
        String str2 = aVar.cIx;
        h df = com.baidu.swan.pms.database.a.aTt().df(str, str2);
        if (df != null && !df.aTG()) {
            com.baidu.swan.apps.ac.d.a.print("plugin is new, not yet expired");
        } else {
            c.a(new com.baidu.swan.pms.c.d.d(str, str2, aVar.cIy), new com.baidu.swan.apps.ac.a.a(str, str2, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.ac.b.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: d */
                public void K(Boolean bool) {
                    com.baidu.swan.apps.ac.d.a.print("download plugin result = " + bool);
                    if (z) {
                        com.baidu.swan.apps.ac.e.a.Q(str, 2);
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
                h df = com.baidu.swan.pms.database.a.aTt().df(str, com.baidu.swan.apps.swancore.b.bL(j));
                if (j > j2) {
                    if (df == null) {
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

    public static boolean pu(String str) {
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
                    String cb = com.baidu.swan.apps.ac.g.b.cb("dynamicLibConfig", null);
                    if (TextUtils.isEmpty(cb)) {
                        return false;
                    }
                    try {
                        JSONObject optJSONObject2 = new JSONObject(cb).optJSONObject(str2);
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
