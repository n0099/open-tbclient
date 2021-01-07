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

    public static h rH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.bgc().dw(str, "0.0.0");
    }

    public static String rI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h rH = rH(str);
        if ((rH == null || TextUtils.isEmpty(rH.appKey)) ? false : true) {
            return rH.appKey;
        }
        com.baidu.swan.apps.ac.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String cq(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData o = SwanAppConfigData.o(d.readFileData(new File(str, "app.json")), new File(str));
        if (o == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = o.dHz;
        if (iVar == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.dIc;
        if (hashMap == null) {
            com.baidu.swan.apps.ac.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aIs() {
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null && (ajt.asU() instanceof g)) {
            com.baidu.swan.apps.v.f.aDH().aDr().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kQ = swanAppConfigData.kQ(4);
        if (kQ == null || kQ.isEmpty()) {
            cr("pluginPath", null);
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ac.f.a aVar : kQ) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.dvt);
            }
        }
        String jSONArray2 = jSONArray.toString();
        cr("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static String f(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ac.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ac.f.a> kQ = swanAppConfigData.kQ(4);
        if (kQ == null || kQ.isEmpty()) {
            com.baidu.swan.apps.ac.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        String cs = cs("pluginPath", null);
        if (TextUtils.isEmpty(cs)) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.apps.ac.f.a aVar : kQ) {
                if (aVar != null && aVar.isValid()) {
                    jSONArray.put(aVar.dvt);
                }
            }
            String jSONArray2 = jSONArray.toString();
            cr("pluginPath", jSONArray2);
            return jSONArray2;
        }
        return cs;
    }

    public static void cr(String str, String str2) {
        e aMl;
        if (!TextUtils.isEmpty(str) && (aMl = e.aMl()) != null) {
            aMl.aMD().putString(str, str2);
        }
    }

    public static String cs(String str, String str2) {
        e aMl = e.aMl();
        if (aMl == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aMl.aMD().getString(str, str2);
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
                            hVar.ewI = optString;
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
                                com.baidu.swan.pms.database.a.bgc().c(hVar);
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

    public static h rJ(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.apH() || com.baidu.swan.apps.ad.a.a.aIL()) {
            e aMl = e.aMl();
            if (aMl == null) {
                return null;
            }
            SwanAppConfigData aMu = aMl.aMu();
            if (aMu == null || (list = aMu.dHH) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.ewI)) {
                    return hVar;
                }
            }
            return null;
        }
        return rH(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e aMl = e.aMl();
        String string = aMl != null ? aMl.aMD().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aMu = aMl != null ? aMl.aMu() : null;
        if (i == 3) {
            if (c.aHU()) {
                com.baidu.swan.apps.ac.b.a.b(aMu, false);
            } else {
                com.baidu.swan.apps.ac.b.a.a(aMu, false);
            }
            string = cs(str, null);
        } else if (i == 4) {
            if (c.aHU()) {
                string = f(aMu);
            } else {
                string = e(aMu);
            }
        }
        map.put(str, string);
        return string;
    }
}
