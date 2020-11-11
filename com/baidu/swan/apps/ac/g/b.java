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
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static h rn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.bbh().dr(str, "0.0.0");
    }

    public static String ro(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h rn = rn(str);
        if ((rn == null || TextUtils.isEmpty(rn.appKey)) ? false : true) {
            return rn.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String cl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData l = SwanAppConfigData.l(d.readFileData(new File(str, "app.json")), new File(str));
        if (l == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = l.dtC;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.duf;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aEy() {
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null && (afM.apb() instanceof g)) {
            com.baidu.swan.apps.v.f.azO().azy().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kq = swanAppConfigData.kq(4);
        if (kq == null || kq.isEmpty()) {
            cm("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : kq) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.dlc);
            }
        }
        String jSONArray2 = jSONArray.toString();
        cm("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kq = swanAppConfigData.kq(4);
        if (kq == null || kq.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cn2 = cn("pluginPath", null);
        if (TextUtils.isEmpty(cn2)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : kq) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.dlc);
                }
            }
            String jSONArray2 = jSONArray.toString();
            cm("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cn2;
    }

    public static void cm(String str, String str2) {
        e aHu;
        if (!TextUtils.isEmpty(str) && (aHu = e.aHu()) != null) {
            aHu.aHM().putString(str, str2);
        }
    }

    public static String cn(String str, String str2) {
        e aHu = e.aHu();
        if (aHu == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aHu.aHM().getString(str, str2);
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
                            hVar.ehG = optString;
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
                                com.baidu.swan.pms.database.a.bbh().c(hVar);
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

    public static h rp(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.alT() || com.baidu.swan.apps.ad.a.a.aER()) {
            e aHu = e.aHu();
            if (aHu == null) {
                return null;
            }
            SwanAppConfigData aHD = aHu.aHD();
            if (aHD == null || (list = aHD.dtK) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.ehG)) {
                    return hVar;
                }
            }
            return null;
        }
        return rn(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aHu = e.aHu();
        String string = aHu != null ? aHu.aHM().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aHD = aHu != null ? aHu.aHD() : null;
        if (i == 3) {
            if (c.aEa()) {
                com.baidu.swan.apps.ac.b.a.b(aHD, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aHD, false);
            }
            string = cn(str, null);
        } else if (i == 4) {
            if (c.aEa()) {
                string = f(aHD);
            } else {
                string = e(aHD);
            }
        }
        map.put(str, string);
        return string;
    }
}
