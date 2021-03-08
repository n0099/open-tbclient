package com.baidu.swan.apps.ac.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.g;
import com.baidu.swan.apps.performance.b.c;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.c.d;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static h qV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.bcx().dp(str, "0.0.0");
    }

    public static String qW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h qV = qV(str);
        if ((qV == null || TextUtils.isEmpty(qV.appKey)) ? false : true) {
            return qV.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String cj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData o = SwanAppConfigData.o(d.readFileData(new File(str, "app.json")), new File(str));
        if (o == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = o.dGs;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.dGV;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aEW() {
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null && (aga.apA() instanceof g)) {
            com.baidu.swan.apps.v.f.aAo().azY().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jo = swanAppConfigData.jo(4);
        if (jo == null || jo.isEmpty()) {
            ck("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : jo) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.dus);
            }
        }
        String jSONArray2 = jSONArray.toString();
        ck("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jo = swanAppConfigData.jo(4);
        if (jo == null || jo.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cl = cl("pluginPath", null);
        if (TextUtils.isEmpty(cl)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : jo) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.dus);
                }
            }
            String jSONArray2 = jSONArray.toString();
            ck("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cl;
    }

    public static void ck(String str, String str2) {
        e aIN;
        if (!TextUtils.isEmpty(str) && (aIN = e.aIN()) != null) {
            aIN.aJf().putString(str, str2);
        }
    }

    public static String cl(String str, String str2) {
        e aIN = e.aIN();
        if (aIN == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aIN.aJf().getString(str, str2);
    }

    public static void c(Map<String, String> map, String str) {
        if (map != null) {
            String b = b(map, "dynamicLibPath", 3);
            String b2 = b(map, "dynamicLibConfig", 3);
            String b3 = b(map, "pluginPath", 4);
            if (!TextUtils.isEmpty(str) && DEBUG) {
                com.baidu.swan.apps.ac.d.a.print(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3);
            }
        }
    }

    public static List<h> aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("plugin_id");
                        if (!TextUtils.isEmpty(optString)) {
                            h hVar = new h();
                            hVar.evD = optString;
                            hVar.versionCode = optJSONObject.optInt("version_code");
                            hVar.versionName = optJSONObject.optString(SharedPrefConfig.VERSION_NAME, "0.0.0");
                            hVar.token = optJSONObject.optString("token");
                            hVar.domains = optJSONObject.optString("domains");
                            hVar.category = 4;
                            hVar.appKey = optJSONObject.optString("app_key");
                            hVar.appName = optJSONObject.optString("app_name");
                            hVar.md5 = "";
                            hVar.sign = "";
                            hVar.downloadUrl = "";
                            arrayList.add(hVar);
                            if (z) {
                                com.baidu.swan.pms.database.a.bcx().c(hVar);
                            }
                        }
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
            return null;
        }
    }

    public static h qX(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.amn() || com.baidu.swan.apps.ad.a.a.aFp()) {
            e aIN = e.aIN();
            if (aIN == null) {
                return null;
            }
            SwanAppConfigData aIW = aIN.aIW();
            if (aIW == null || (list = aIW.dGA) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.evD)) {
                    return hVar;
                }
            }
            return null;
        }
        return qV(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aIN = e.aIN();
        String string = aIN != null ? aIN.aJf().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aIW = aIN != null ? aIN.aIW() : null;
        if (i == 3) {
            if (c.aEy()) {
                com.baidu.swan.apps.ac.b.a.b(aIW, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aIW, false);
            }
            string = cl(str, null);
        } else if (i == 4) {
            if (c.aEy()) {
                string = f(aIW);
            } else {
                string = e(aIW);
            }
        }
        map.put(str, string);
        return string;
    }
}
