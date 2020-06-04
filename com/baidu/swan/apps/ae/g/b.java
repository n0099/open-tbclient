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
    public static h mN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.aFV().cK(str, "0.0.0");
    }

    public static String mO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h mN = mN(str);
        if ((mN == null || TextUtils.isEmpty(mN.appKey)) ? false : true) {
            return mN.appKey;
        }
        com.baidu.swan.apps.ae.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String bG(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData k = SwanAppConfigData.k(d.readFileData(new File(str, "app.json")), new File(str));
        if (k == null) {
            com.baidu.swan.apps.ae.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.h hVar = k.cAu;
        if (hVar == null) {
            com.baidu.swan.apps.ae.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = hVar.cAV;
        if (hashMap == null) {
            com.baidu.swan.apps.ae.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void alY() {
        e QH = f.ahV().QH();
        if (QH != null && (QH.YP() instanceof com.baidu.swan.apps.core.d.f)) {
            f.ahV().ahF().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ae.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ae.f.a> gM = swanAppConfigData.gM(4);
        if (gM == null || gM.isEmpty()) {
            bH("pluginPath", null);
            com.baidu.swan.apps.ae.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ae.f.a aVar : gM) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.ctd);
            }
        }
        String jSONArray2 = jSONArray.toString();
        bH("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static void bH(String str, String str2) {
        com.baidu.swan.apps.runtime.e aoF;
        if (!TextUtils.isEmpty(str) && (aoF = com.baidu.swan.apps.runtime.e.aoF()) != null) {
            aoF.aoX().putString(str, str2);
        }
    }

    public static String bI(String str, String str2) {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return aoF.aoX().getString(str, str2);
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

    public static List<h> O(String str, boolean z) {
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
                            hVar.dlx = optString;
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
                                com.baidu.swan.pms.database.a.aFV().c(hVar);
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

    public static h mP(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.Wm() || com.baidu.swan.apps.af.a.a.amr()) {
            com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
            if (aoF == null) {
                return null;
            }
            SwanAppConfigData aoO = aoF.aoO();
            if (aoO == null || (list = aoO.cAC) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.dlx)) {
                    return hVar;
                }
            }
            return null;
        }
        return mN(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        String string = aoF != null ? aoF.aoX().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData aoO = aoF != null ? aoF.aoO() : null;
        if (i == 3) {
            com.baidu.swan.apps.ae.b.a.a(aoO, false);
            string = bI(str, null);
        } else if (i == 4) {
            string = e(aoO);
        }
        map.put(str, string);
        return string;
    }
}
