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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static h qO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.bcv().dp(str, "0.0.0");
    }

    public static String qP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h qO = qO(str);
        if ((qO == null || TextUtils.isEmpty(qO.appKey)) ? false : true) {
            return qO.appKey;
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
        SwanAppConfigData.i iVar = o.dER;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.dFu;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aET() {
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null && (afX.apx() instanceof g)) {
            com.baidu.swan.apps.v.f.aAl().azV().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jn = swanAppConfigData.jn(4);
        if (jn == null || jn.isEmpty()) {
            ck("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : jn) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.dsQ);
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
        List<com.baidu.swan.apps.ac.f.a> jn = swanAppConfigData.jn(4);
        if (jn == null || jn.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cl = cl("pluginPath", null);
        if (TextUtils.isEmpty(cl)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : jn) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.dsQ);
                }
            }
            String jSONArray2 = jSONArray.toString();
            ck("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cl;
    }

    public static void ck(String str, String str2) {
        e aIK;
        if (!TextUtils.isEmpty(str) && (aIK = e.aIK()) != null) {
            aIK.aJc().putString(str, str2);
        }
    }

    public static String cl(String str, String str2) {
        e aIK = e.aIK();
        if (aIK == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aIK.aJc().getString(str, str2);
    }

    public static void c(Map<String, String> map, String str) {
        if (map != null) {
            String b2 = b(map, "dynamicLibPath", 3);
            String b3 = b(map, "dynamicLibConfig", 3);
            String b4 = b(map, "pluginPath", 4);
            if (!TextUtils.isEmpty(str) && DEBUG) {
                com.baidu.swan.apps.ac.d.a.print(str + ", dynamicLibPath = " + b2 + "; dynamicLibConfig = " + b3 + "; pluginPath = " + b4);
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
                            hVar.euc = optString;
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
                                com.baidu.swan.pms.database.a.bcv().c(hVar);
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

    public static h qQ(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.amk() || com.baidu.swan.apps.ad.a.a.aFm()) {
            e aIK = e.aIK();
            if (aIK == null) {
                return null;
            }
            SwanAppConfigData aIT = aIK.aIT();
            if (aIT == null || (list = aIT.dEZ) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.euc)) {
                    return hVar;
                }
            }
            return null;
        }
        return qO(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aIK = e.aIK();
        String string = aIK != null ? aIK.aJc().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aIT = aIK != null ? aIK.aIT() : null;
        if (i == 3) {
            if (c.aEv()) {
                com.baidu.swan.apps.ac.b.a.b(aIT, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aIT, false);
            }
            string = cl(str, null);
        } else if (i == 4) {
            if (c.aEv()) {
                string = f(aIT);
            } else {
                string = e(aIT);
            }
        }
        map.put(str, string);
        return string;
    }
}
