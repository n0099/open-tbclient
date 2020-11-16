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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static h rh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.baA().dq(str, "0.0.0");
    }

    public static String ri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h rh = rh(str);
        if ((rh == null || TextUtils.isEmpty(rh.appKey)) ? false : true) {
            return rh.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String ck(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData l = SwanAppConfigData.l(d.readFileData(new File(str, "app.json")), new File(str));
        if (l == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = l.drT;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.dsx;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aDQ() {
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null && (afe.aot() instanceof g)) {
            com.baidu.swan.apps.v.f.azg().ayQ().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> km = swanAppConfigData.km(4);
        if (km == null || km.isEmpty()) {
            cl("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : km) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.djv);
            }
        }
        String jSONArray2 = jSONArray.toString();
        cl("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> km = swanAppConfigData.km(4);
        if (km == null || km.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cm = cm("pluginPath", null);
        if (TextUtils.isEmpty(cm)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : km) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.djv);
                }
            }
            String jSONArray2 = jSONArray.toString();
            cl("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cm;
    }

    public static void cl(String str, String str2) {
        e aGM;
        if (!TextUtils.isEmpty(str) && (aGM = e.aGM()) != null) {
            aGM.aHe().putString(str, str2);
        }
    }

    public static String cm(String str, String str2) {
        e aGM = e.aGM();
        if (aGM == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aGM.aHe().getString(str, str2);
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
                            hVar.efY = optString;
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
                                com.baidu.swan.pms.database.a.baA().c(hVar);
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

    public static h rj(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.all() || com.baidu.swan.apps.ad.a.a.aEj()) {
            e aGM = e.aGM();
            if (aGM == null) {
                return null;
            }
            SwanAppConfigData aGV = aGM.aGV();
            if (aGV == null || (list = aGV.dsb) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.efY)) {
                    return hVar;
                }
            }
            return null;
        }
        return rh(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aGM = e.aGM();
        String string = aGM != null ? aGM.aHe().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aGV = aGM != null ? aGM.aGV() : null;
        if (i == 3) {
            if (c.aDs()) {
                com.baidu.swan.apps.ac.b.a.b(aGV, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aGV, false);
            }
            string = cm(str, null);
        } else if (i == 4) {
            if (c.aDs()) {
                string = f(aGV);
            } else {
                string = e(aGV);
            }
        }
        map.put(str, string);
        return string;
    }
}
