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
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static h pU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.aUf().df(str, "0.0.0");
    }

    public static String pV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h pU = pU(str);
        if ((pU == null || TextUtils.isEmpty(pU.appKey)) ? false : true) {
            return pU.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String bZ(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData m = SwanAppConfigData.m(d.readFileData(new File(str, "app.json")), new File(str));
        if (m == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = m.cSX;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.cTA;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void axt() {
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null && (YG.ahW() instanceof g)) {
            com.baidu.swan.apps.v.f.asJ().ast().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jy = swanAppConfigData.jy(4);
        if (jy == null || jy.isEmpty()) {
            ca("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : jy) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.cKD);
            }
        }
        String jSONArray2 = jSONArray.toString();
        ca("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jy = swanAppConfigData.jy(4);
        if (jy == null || jy.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cb = cb("pluginPath", null);
        if (TextUtils.isEmpty(cb)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : jy) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.cKD);
                }
            }
            String jSONArray2 = jSONArray.toString();
            ca("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cb;
    }

    public static void ca(String str, String str2) {
        e aAr;
        if (!TextUtils.isEmpty(str) && (aAr = e.aAr()) != null) {
            aAr.aAJ().putString(str, str2);
        }
    }

    public static String cb(String str, String str2) {
        e aAr = e.aAr();
        if (aAr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aAr.aAJ().getString(str, str2);
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

    public static List<h> U(String str, boolean z) {
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
                            hVar.dHr = optString;
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
                                com.baidu.swan.pms.database.a.aUf().c(hVar);
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

    public static h pW(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.aeO() || com.baidu.swan.apps.ad.a.a.axM()) {
            e aAr = e.aAr();
            if (aAr == null) {
                return null;
            }
            SwanAppConfigData aAA = aAr.aAA();
            if (aAA == null || (list = aAA.cTf) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.dHr)) {
                    return hVar;
                }
            }
            return null;
        }
        return pU(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aAr = e.aAr();
        String string = aAr != null ? aAr.aAJ().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aAA = aAr != null ? aAr.aAA() : null;
        if (i == 3) {
            if (c.awV()) {
                com.baidu.swan.apps.ac.b.a.b(aAA, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aAA, false);
            }
            string = cb(str, null);
        } else if (i == 4) {
            if (c.awV()) {
                string = f(aAA);
            } else {
                string = e(aAA);
            }
        }
        map.put(str, string);
        return string;
    }
}
