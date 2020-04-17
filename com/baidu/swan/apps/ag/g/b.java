package com.baidu.swan.apps.ag.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.d.c;
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
    public static h lw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.aBI().cn(str, "0.0.0");
    }

    public static String lx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h lw = lw(str);
        if ((lw == null || TextUtils.isEmpty(lw.appKey)) ? false : true) {
            return lw.appKey;
        }
        com.baidu.swan.apps.ag.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String bn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData k = SwanAppConfigData.k(c.readFileData(new File(str, "app.json")), new File(str));
        if (k == null) {
            com.baidu.swan.apps.ag.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.f fVar = k.coC;
        if (fVar == null) {
            com.baidu.swan.apps.ag.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = fVar.coZ;
        if (hashMap == null) {
            com.baidu.swan.apps.ag.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void ais() {
        e Ou = f.aeK().Ou();
        if (Ou != null && (Ou.We() instanceof com.baidu.swan.apps.core.d.f)) {
            f.aeK().aev().onBackPressed();
        }
    }

    public static String b(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ag.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ag.f.a> gt = swanAppConfigData.gt(4);
        if (gt == null || gt.isEmpty()) {
            bo("pluginPath", null);
            com.baidu.swan.apps.ag.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ag.f.a aVar : gt) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.chI);
            }
        }
        String jSONArray2 = jSONArray.toString();
        bo("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static void bo(String str, String str2) {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && !TextUtils.isEmpty(str)) {
            akN.ald().putString(str, str2);
        }
    }

    public static void a(Map<String, String> map, com.baidu.swan.apps.ag.b.a aVar, String str) {
        if (map != null) {
            String a = a(map, "dynamicLibPath", aVar, 3);
            String a2 = a(map, "pluginPath", aVar, 4);
            if (!TextUtils.isEmpty(str)) {
                com.baidu.swan.apps.ag.d.a.print(str + ", dynamicLibPath = " + a + " ;  pluginPath = " + a2);
            }
        }
    }

    public static List<h> C(String str, boolean z) {
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
                            hVar.dai = optString;
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
                                com.baidu.swan.pms.database.a.aBI().c(hVar);
                            }
                        }
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
            return null;
        }
    }

    public static h ly(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.TG() || com.baidu.swan.apps.ah.a.a.aiL()) {
            com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
            if (akN == null) {
                return null;
            }
            SwanAppConfigData akT = akN.akT();
            if (akT == null || (list = akT.coJ) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.dai)) {
                    return hVar;
                }
            }
            return null;
        }
        return lw(str);
    }

    private static String a(String str, com.baidu.swan.apps.ag.b.a aVar, int i) {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        String string = akN != null ? akN.ald().getString(str, (String) null) : null;
        if (TextUtils.isEmpty(string)) {
            SwanAppConfigData akT = akN != null ? akN.akT() : null;
            if (akT == null && aVar != null) {
                akT = aVar.chc;
            }
            if (i == 3) {
                return com.baidu.swan.apps.ag.b.b.a(akT, false);
            }
            if (i == 4) {
                return b(akT);
            }
            return string;
        }
        return string;
    }

    private static String a(Map<String, String> map, String str, com.baidu.swan.apps.ag.b.a aVar, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a = a(str, aVar, i);
        map.put(str, a);
        return a;
    }
}
