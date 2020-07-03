package com.baidu.swan.apps.ae.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.e.d;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public static h mV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.aHb().cM(str, "0.0.0");
    }

    public static String mW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h mV = mV(str);
        if ((mV == null || TextUtils.isEmpty(mV.appKey)) ? false : true) {
            return mV.appKey;
        }
        com.baidu.swan.apps.ae.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String bI(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData k = SwanAppConfigData.k(d.readFileData(new File(str, "app.json")), new File(str));
        if (k == null) {
            com.baidu.swan.apps.ae.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.h hVar = k.cFe;
        if (hVar == null) {
            com.baidu.swan.apps.ae.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = hVar.cFF;
        if (hashMap == null) {
            com.baidu.swan.apps.ae.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void ane() {
        e RN = f.ajb().RN();
        if (RN != null && (RN.ZV() instanceof com.baidu.swan.apps.core.d.f)) {
            f.ajb().aiL().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ae.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ae.f.a> gX = swanAppConfigData.gX(4);
        if (gX == null || gX.isEmpty()) {
            bJ("pluginPath", null);
            com.baidu.swan.apps.ae.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ae.f.a aVar : gX) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.cxR);
            }
        }
        String jSONArray2 = jSONArray.toString();
        bJ("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static void bJ(String str, String str2) {
        com.baidu.swan.apps.runtime.e apM;
        if (!TextUtils.isEmpty(str) && (apM = com.baidu.swan.apps.runtime.e.apM()) != null) {
            apM.aqe().putString(str, str2);
        }
    }

    public static String bK(String str, String str2) {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return apM.aqe().getString(str, str2);
    }

    public static void b(Map<String, String> map, String str) {
        if (map != null) {
            String b = b(map, "dynamicLibPath", 3);
            String b2 = b(map, "dynamicLibConfig", 3);
            String b3 = b(map, "pluginPath", 4);
            if (!TextUtils.isEmpty(str)) {
                com.baidu.swan.apps.ae.d.a.print(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3);
            }
        }
    }

    public static List<h> Q(String str, boolean z) {
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
                            hVar.dqi = optString;
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
                                com.baidu.swan.pms.database.a.aHb().c(hVar);
                            }
                        }
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
            return null;
        }
    }

    public static h mX(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.Xs() || com.baidu.swan.apps.af.a.a.anx()) {
            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
            if (apM == null) {
                return null;
            }
            SwanAppConfigData apV = apM.apV();
            if (apV == null || (list = apV.cFm) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.dqi)) {
                    return hVar;
                }
            }
            return null;
        }
        return mV(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        String string = apM != null ? apM.aqe().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData apV = apM != null ? apM.apV() : null;
        if (i == 3) {
            com.baidu.swan.apps.ae.b.a.a(apV, false);
            string = bK(str, null);
        } else if (i == 4) {
            string = e(apV);
        }
        map.put(str, string);
        return string;
    }
}
