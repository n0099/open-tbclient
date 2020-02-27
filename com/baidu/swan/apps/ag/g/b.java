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
    public static h kk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.pms.database.a.att().cd(str, "0.0.0");
    }

    public static String kl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h kk = kk(str);
        if ((kk == null || TextUtils.isEmpty(kk.appKey)) ? false : true) {
            return kk.appKey;
        }
        com.baidu.swan.apps.ag.d.a.print("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static String be(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData l = SwanAppConfigData.l(c.readFileData(new File(str, "app.json")), new File(str));
        if (l == null) {
            com.baidu.swan.apps.ag.d.a.print("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.f fVar = l.bPD;
        if (fVar == null) {
            com.baidu.swan.apps.ag.d.a.print("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = fVar.bQa;
        if (hashMap == null) {
            com.baidu.swan.apps.ag.d.a.print("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static void aai() {
        e GA = f.WQ().GA();
        if (GA != null && (GA.Ol() instanceof com.baidu.swan.apps.core.d.f)) {
            f.WQ().WB().onBackPressed();
        }
    }

    public static String b(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            com.baidu.swan.apps.ag.d.a.print("parse app.json is null");
            return null;
        }
        List<com.baidu.swan.apps.ag.f.a> gl = swanAppConfigData.gl(4);
        if (gl == null || gl.isEmpty()) {
            bf("pluginPath", null);
            com.baidu.swan.apps.ag.d.a.print("this swan app not apply on someone plugin");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.apps.ag.f.a aVar : gl) {
            if (aVar != null && aVar.isValid()) {
                jSONArray.put(aVar.bIM);
            }
        }
        String jSONArray2 = jSONArray.toString();
        bf("pluginPath", jSONArray2);
        return jSONArray2;
    }

    public static void bf(String str, String str2) {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null && !TextUtils.isEmpty(str)) {
            acD.acT().putString(str, str2);
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

    public static List<h> x(String str, boolean z) {
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
                            hVar.cAX = optString;
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
                                com.baidu.swan.pms.database.a.att().c(hVar);
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

    public static h km(String str) {
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.baidu.swan.apps.console.debugger.a.e.LN() || com.baidu.swan.apps.ah.a.a.aaB()) {
            com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
            if (acD == null) {
                return null;
            }
            SwanAppConfigData acJ = acD.acJ();
            if (acJ == null || (list = acJ.bPK) == null) {
                return null;
            }
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.cAX)) {
                    return hVar;
                }
            }
            return null;
        }
        return kk(str);
    }

    private static String a(String str, com.baidu.swan.apps.ag.b.a aVar, int i) {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        String string = acD != null ? acD.acT().getString(str, (String) null) : null;
        if (TextUtils.isEmpty(string)) {
            SwanAppConfigData acJ = acD != null ? acD.acJ() : null;
            if (acJ == null && aVar != null) {
                acJ = aVar.bIg;
            }
            if (i == 3) {
                return com.baidu.swan.apps.ag.b.b.a(acJ, false);
            }
            if (i == 4) {
                return b(acJ);
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
