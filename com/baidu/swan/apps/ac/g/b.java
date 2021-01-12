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

    public static h qw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.bci().dv(str, "0.0.0");
    }

    public static String qx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h qw = qw(str);
        if ((qw == null || TextUtils.isEmpty(qw.appKey)) ? false : true) {
            return qw.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String cp(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData o = SwanAppConfigData.o(d.readFileData(new File(str, "app.json")), new File(str));
        if (o == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = o.dCN;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.dDq;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aEy() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && (afz.aoY() instanceof g)) {
            com.baidu.swan.apps.v.f.azN().azx().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jk = swanAppConfigData.jk(4);
        if (jk == null || jk.isEmpty()) {
            cq("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : jk) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.dqE);
            }
        }
        String jSONArray2 = jSONArray.toString();
        cq("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> jk = swanAppConfigData.jk(4);
        if (jk == null || jk.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cr = cr("pluginPath", null);
        if (TextUtils.isEmpty(cr)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : jk) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.dqE);
                }
            }
            String jSONArray2 = jSONArray.toString();
            cq("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cr;
    }

    public static void cq(String str, String str2) {
        e aIr;
        if (!TextUtils.isEmpty(str) && (aIr = e.aIr()) != null) {
            aIr.aIJ().putString(str, str2);
        }
    }

    public static String cr(String str, String str2) {
        e aIr = e.aIr();
        if (aIr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aIr.aIJ().getString(str, str2);
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
                            hVar.erV = optString;
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
                                com.baidu.swan.pms.database.a.bci().c(hVar);
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

    public static h qy(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.alM() || com.baidu.swan.apps.ad.a.a.aER()) {
            e aIr = e.aIr();
            if (aIr == null) {
                return null;
            }
            SwanAppConfigData aIA = aIr.aIA();
            if (aIA == null || (list = aIA.dCV) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.erV)) {
                    return hVar;
                }
            }
            return null;
        }
        return qw(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aIr = e.aIr();
        String string = aIr != null ? aIr.aIJ().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aIA = aIr != null ? aIr.aIA() : null;
        if (i == 3) {
            if (c.aEa()) {
                com.baidu.swan.apps.ac.b.a.b(aIA, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aIA, false);
            }
            string = cr(str, null);
        } else if (i == 4) {
            if (c.aEa()) {
                string = f(aIA);
            } else {
                string = e(aIA);
            }
        }
        map.put(str, string);
        return string;
    }
}
