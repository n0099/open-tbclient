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
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static h rO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.bdF().dx(str, "0.0.0");
    }

    public static String rP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h rO = rO(str);
        if ((rO == null || TextUtils.isEmpty(rO.appKey)) ? false : true) {
            return rO.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String cr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData l = SwanAppConfigData.l(d.readFileData(new File(str, "app.json")), new File(str));
        if (l == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = l.dyU;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.dzx;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aGY() {
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null && (aim.arB() instanceof g)) {
            com.baidu.swan.apps.v.f.aCp().aBZ().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kK = swanAppConfigData.kK(4);
        if (kK == null || kK.isEmpty()) {
            cs("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : kK) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.dqu);
            }
        }
        String jSONArray2 = jSONArray.toString();
        cs("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kK = swanAppConfigData.kK(4);
        if (kK == null || kK.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String ct = ct("pluginPath", null);
        if (TextUtils.isEmpty(ct)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : kK) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.dqu);
                }
            }
            String jSONArray2 = jSONArray.toString();
            cs("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return ct;
    }

    public static void cs(String str, String str2) {
        e aJU;
        if (!TextUtils.isEmpty(str) && (aJU = e.aJU()) != null) {
            aJU.aKm().putString(str, str2);
        }
    }

    public static String ct(String str, String str2) {
        e aJU = e.aJU();
        if (aJU == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aJU.aKm().getString(str, str2);
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

    public static List<h> ab(String str, boolean z) {
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
                            hVar.emZ = optString;
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
                                com.baidu.swan.pms.database.a.bdF().c(hVar);
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

    public static h rQ(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.aot() || com.baidu.swan.apps.ad.a.a.aHr()) {
            e aJU = e.aJU();
            if (aJU == null) {
                return null;
            }
            SwanAppConfigData aKd = aJU.aKd();
            if (aKd == null || (list = aKd.dzc) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.emZ)) {
                    return hVar;
                }
            }
            return null;
        }
        return rO(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aJU = e.aJU();
        String string = aJU != null ? aJU.aKm().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aKd = aJU != null ? aJU.aKd() : null;
        if (i == 3) {
            if (c.aGA()) {
                com.baidu.swan.apps.ac.b.a.b(aKd, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aKd, false);
            }
            string = ct(str, null);
        } else if (i == 4) {
            if (c.aGA()) {
                string = f(aKd);
            } else {
                string = e(aKd);
            }
        }
        map.put(str, string);
        return string;
    }
}
