package com.baidu.swan.apps.ad.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.d.d;
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
    public static h nC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.aKS().cP(str, "0.0.0");
    }

    public static String nD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h nC = nC(str);
        if ((nC == null || TextUtils.isEmpty(nC.appKey)) ? false : true) {
            return nC.appKey;
        }
        com.baidu.swan.apps.ad.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String bK(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData m = SwanAppConfigData.m(d.readFileData(new File(str, "app.json")), new File(str));
        if (m == null) {
            com.baidu.swan.apps.ad.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = m.cHU;
        if (iVar == null) {
            com.baidu.swan.apps.ad.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.cIx;
        if (hashMap == null) {
            com.baidu.swan.apps.ad.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aoN() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && (Sc.aaZ() instanceof g)) {
            com.baidu.swan.apps.v.f.akr().akb().onBackPressed();
        }
    }

    public static String e(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ad.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ad.f.a> hg = swanAppConfigData.hg(4);
        if (hg == null || hg.isEmpty()) {
            bL("pluginPath", null);
            com.baidu.swan.apps.ad.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ad.f.a aVar : hg) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.cAq);
            }
        }
        String jSONArray2 = jSONArray.toString();
        bL("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static void bL(String str, String str2) {
        e arv;
        if (!TextUtils.isEmpty(str) && (arv = e.arv()) != null) {
            arv.arN().putString(str, str2);
        }
    }

    public static String bM(String str, String str2) {
        e arv = e.arv();
        if (arv == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return arv.arN().getString(str, str2);
    }

    public static void b(Map<String, String> map, String str) {
        if (map != null) {
            String b = b(map, "dynamicLibPath", 3);
            String b2 = b(map, "dynamicLibConfig", 3);
            String b3 = b(map, "pluginPath", 4);
            if (!TextUtils.isEmpty(str)) {
                com.baidu.swan.apps.ad.d.a.print(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3);
            }
        }
    }

    public static List<h> P(String str, boolean z) {
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
                            hVar.dvZ = optString;
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
                                com.baidu.swan.pms.database.a.aKS().c(hVar);
                            }
                        }
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            com.baidu.swan.apps.ad.d.a.print(Log.getStackTraceString(e));
            return null;
        }
    }

    public static h nE(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.XY() || com.baidu.swan.apps.ae.a.a.apg()) {
            e arv = e.arv();
            if (arv == null) {
                return null;
            }
            SwanAppConfigData arE = arv.arE();
            if (arE == null || (list = arE.cIc) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.dvZ)) {
                    return hVar;
                }
            }
            return null;
        }
        return nC(str);
    }

    private static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e arv = e.arv();
        String string = arv != null ? arv.arN().getString(str, (String) null) : null;
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
            return string;
        }
        SwanAppConfigData arE = arv != null ? arv.arE() : null;
        if (i == 3) {
            com.baidu.swan.apps.ad.b.a.a(arE, false);
            string = bM(str, null);
        } else if (i == 4) {
            string = e(arE);
        }
        map.put(str, string);
        return string;
    }
}
