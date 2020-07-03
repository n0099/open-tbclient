package com.baidu.swan.apps.aq;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static List<String> cOu = new ArrayList();
    private static List<String> cOv = new ArrayList();
    private static final Object cOw = new Object();
    private static int cOx = 0;

    public static boolean auo() {
        SwanCoreVersion acM = com.baidu.swan.apps.core.turbo.d.acr().acM();
        if (acM == null) {
            if (DEBUG) {
                Log.d("Api-Base", "isSupportBindApi: false => null cur ver");
            }
        } else {
            r0 = acM.swanCoreVersion >= 12892110851L;
            if (DEBUG) {
                Log.d("Api-Base", "isSupportBindApi: " + r0 + " => cur【" + com.baidu.swan.apps.swancore.b.bt(acM.swanCoreVersion) + "】support 【" + com.baidu.swan.apps.swancore.b.bt(12892110851L) + "】");
            }
        }
        return r0;
    }

    public static boolean aup() {
        return !ae.pT("3.120.2");
    }

    public static boolean auq() {
        return ae.pT("3.170.0");
    }

    public static String A(int i, boolean z) {
        List<String> list;
        String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        if (cOx == 1) {
            if (DEBUG) {
                Log.d("SwanAppCompat", "type support default");
            }
            return SchemeCollecter.getSchemesDes(str, i);
        }
        if (aur()) {
            synchronized (cOw) {
                if (z) {
                    list = cOu;
                } else {
                    list = cOv;
                }
                if (list != null && list.size() > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppCompat", "support ab js native descriptions");
                    }
                    cOx = 2;
                    return list.get(i);
                }
            }
        }
        if (DEBUG) {
            Log.d("SwanAppCompat", "use default descriptions");
        }
        cOx = 1;
        return SchemeCollecter.getSchemesDes(str, i);
    }

    private static boolean aur() {
        if (cOx != 2) {
            return com.baidu.swan.apps.u.a.aga().SH() && !com.baidu.swan.apps.storage.c.h.asV().getBoolean("swan_app_js_native_ab_update_key", false);
        } else if (DEBUG) {
            Log.d("SwanAppCompat", "has used ab description");
            return true;
        } else {
            return true;
        }
    }

    public static void aus() {
        if (DEBUG) {
            Log.d("SwanAppCompat", "start prepare ab description");
        }
        fy(true);
        fy(false);
        if (DEBUG) {
            Log.d("SwanAppCompat", "end prepare ab description");
        }
    }

    private static void fy(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCompat", "start prepare ab description :" + (z ? V8Engine.TYPE_V8 : "webview"));
        }
        String str = com.baidu.swan.apps.r.e.afO().getPath() + File.separator + "js_native" + File.separator + (z ? "swan_js_native_v8_ab.txt" : "swan_js_native_webview_ab.txt");
        if (com.baidu.swan.e.d.isExistFile(str)) {
            if (com.baidu.swan.apps.storage.c.h.asV().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (DEBUG) {
                    Log.d("SwanAppCompat", "need delete file case update");
                }
                if (aut()) {
                    com.baidu.swan.apps.storage.c.h.asV().putBoolean("swan_app_js_native_ab_update_key", false);
                } else {
                    return;
                }
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCompat", "start create cache");
                }
                j(com.baidu.swan.e.d.F(new File(str)), z);
                return;
            }
        }
        k(z, str);
    }

    private static boolean aut() {
        String str = com.baidu.swan.apps.r.e.afO().getPath() + File.separator + "js_native" + File.separator;
        return com.baidu.swan.e.d.ue(new StringBuilder().append(str).append("swan_js_native_v8_ab.txt").toString()) && com.baidu.swan.e.d.ue(new StringBuilder().append(str).append("swan_js_native_webview_ab.txt").toString());
    }

    private static void k(boolean z, String str) {
        String str2 = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        String str3 = z ? "swan/v8_ab" : "swan/webview_ab";
        List<JSONObject> pJ = pJ(str2);
        List<JSONObject> pJ2 = pJ(str3);
        if (pJ != null && pJ2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pJ2.size(); i++) {
                try {
                    JSONArray jSONArray = pJ2.get(i).getJSONArray("descriptions");
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.getJSONObject(i2));
                        }
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            if (arrayList.size() != 0 && g(pJ, arrayList)) {
                File file = new File(str);
                ArrayList arrayList2 = new ArrayList();
                for (JSONObject jSONObject : pJ) {
                    if (jSONObject != null) {
                        arrayList2.add(jSONObject.toString());
                    }
                }
                if (file.exists()) {
                    com.baidu.swan.e.d.safeDeleteFile(file);
                }
                com.baidu.swan.e.d.createNewFileSafely(file);
                com.baidu.swan.e.d.b(arrayList2, file);
                j(arrayList2, z);
            }
        }
    }

    private static void j(List<String> list, boolean z) {
        if (list != null) {
            synchronized (cOw) {
                if (cOx == 0) {
                    if (z) {
                        cOu = list;
                    } else {
                        cOv = list;
                    }
                    if (DEBUG) {
                        Log.d("SwanAppCompat", "has update descriptions, list :" + list.toString() + " type :" + (z ? V8Engine.TYPE_V8 : "webview"));
                    }
                }
            }
        }
    }

    private static boolean g(List<JSONObject> list, List<JSONObject> list2) {
        boolean z;
        try {
            for (JSONObject jSONObject : list2) {
                String string = jSONObject.getString("name");
                boolean z2 = false;
                for (JSONObject jSONObject2 : list) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("descriptions");
                    if (jSONArray != null) {
                        int i = 0;
                        while (true) {
                            if (i < jSONArray.length()) {
                                if (!TextUtils.equals(string, jSONArray.getJSONObject(i).getString("name"))) {
                                    i++;
                                } else {
                                    jSONArray.remove(i);
                                    jSONArray.put(jSONObject);
                                    z = true;
                                    break;
                                }
                            } else {
                                z = z2;
                                break;
                            }
                        }
                        if (!z) {
                            z2 = z;
                        }
                    }
                }
            }
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Nullable
    private static List<JSONObject> pJ(String str) {
        String schemesDes = SchemeCollecter.getSchemesDes(str, 0);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(schemesDes);
            arrayList.add(jSONObject);
            int i = jSONObject.getInt("totalSlices");
            for (int i2 = 1; i2 < i; i2++) {
                arrayList.add(new JSONObject(SchemeCollecter.getSchemesDes(str, i2)));
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void auu() {
        if (DEBUG) {
            Log.d("SwanAppCompat", "start release descriptions");
        }
        synchronized (cOw) {
            cOx = 0;
            cOu = new ArrayList();
            cOv = new ArrayList();
        }
    }

    public static void auv() {
        if (DEBUG) {
            Log.d("SwanAppCompat", "on App upgrade");
        }
        com.baidu.swan.apps.storage.c.h.asV().putBoolean("swan_app_js_native_ab_update_key", true);
    }
}
