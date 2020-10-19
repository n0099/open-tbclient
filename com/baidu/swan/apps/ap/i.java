package com.baidu.swan.apps.ap;

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
/* loaded from: classes10.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static List<String> dpf = new ArrayList();
    private static List<String> dpg = new ArrayList();
    private static final Object dph = new Object();
    private static int dpi = 0;

    public static boolean aHT() {
        SwanCoreVersion anI = com.baidu.swan.apps.core.turbo.d.ann().anI();
        if (anI == null) {
            if (DEBUG) {
                Log.d("Api-Base", "isSupportBindApi: false => null cur ver");
            }
        } else {
            r0 = anI.swanCoreVersion >= 12892110851L;
            if (DEBUG) {
                Log.d("Api-Base", "isSupportBindApi: " + r0 + " => cur【" + com.baidu.swan.apps.swancore.b.bU(anI.swanCoreVersion) + "】support 【" + com.baidu.swan.apps.swancore.b.bU(12892110851L) + "】");
            }
        }
        return r0;
    }

    public static boolean aHU() {
        return !ag.tL("3.120.2");
    }

    public static boolean aHV() {
        return ag.tL("3.200.100");
    }

    public static String C(int i, boolean z) {
        List<String> list;
        String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        if (dpi == 1) {
            if (DEBUG) {
                Log.d("SwanAppCompat", "type support default");
            }
            return SchemeCollecter.getSchemesDes(str, i);
        }
        if (aHW()) {
            synchronized (dph) {
                if (z) {
                    list = dpf;
                } else {
                    list = dpg;
                }
                if (list != null && list.size() > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppCompat", "support ab js native descriptions");
                    }
                    dpi = 2;
                    return list.get(i);
                }
            }
        }
        if (DEBUG) {
            Log.d("SwanAppCompat", "use default descriptions");
        }
        dpi = 1;
        return SchemeCollecter.getSchemesDes(str, i);
    }

    private static boolean aHW() {
        if (dpi != 2) {
            return com.baidu.swan.apps.t.a.asi().acn() && !com.baidu.swan.apps.storage.c.h.aGy().getBoolean("swan_app_js_native_ab_update_key", false);
        } else if (DEBUG) {
            Log.d("SwanAppCompat", "has used ab description");
            return true;
        } else {
            return true;
        }
    }

    public static void aHX() {
        if (DEBUG) {
            Log.d("SwanAppCompat", "start prepare ab description");
        }
        gv(true);
        gv(false);
        if (DEBUG) {
            Log.d("SwanAppCompat", "end prepare ab description");
        }
    }

    private static void gv(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCompat", "start prepare ab description :" + (z ? V8Engine.TYPE_V8 : "webview"));
        }
        String str = com.baidu.swan.apps.r.d.arV().getPath() + File.separator + "js_native" + File.separator + (z ? "swan_js_native_v8_ab.txt" : "swan_js_native_webview_ab.txt");
        if (com.baidu.swan.c.d.isExistFile(str)) {
            if (com.baidu.swan.apps.storage.c.h.aGy().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (DEBUG) {
                    Log.d("SwanAppCompat", "need delete file case update");
                }
                if (aHY()) {
                    com.baidu.swan.apps.storage.c.h.aGy().putBoolean("swan_app_js_native_ab_update_key", false);
                } else {
                    return;
                }
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCompat", "start create cache");
                }
                i(com.baidu.swan.c.d.N(new File(str)), z);
                return;
            }
        }
        k(z, str);
    }

    private static boolean aHY() {
        String str = com.baidu.swan.apps.r.d.arV().getPath() + File.separator + "js_native" + File.separator;
        return com.baidu.swan.c.d.yy(new StringBuilder().append(str).append("swan_js_native_v8_ab.txt").toString()) && com.baidu.swan.c.d.yy(new StringBuilder().append(str).append("swan_js_native_webview_ab.txt").toString());
    }

    private static void k(boolean z, String str) {
        String str2 = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        String str3 = z ? "swan/v8_ab" : "swan/webview_ab";
        List<JSONObject> tB = tB(str2);
        List<JSONObject> tB2 = tB(str3);
        if (tB != null && tB2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < tB2.size(); i++) {
                try {
                    JSONArray jSONArray = tB2.get(i).getJSONArray("descriptions");
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
            if (arrayList.size() != 0 && h(tB, arrayList)) {
                File file = new File(str);
                ArrayList arrayList2 = new ArrayList();
                for (JSONObject jSONObject : tB) {
                    if (jSONObject != null) {
                        arrayList2.add(jSONObject.toString());
                    }
                }
                if (file.exists()) {
                    com.baidu.swan.c.d.safeDeleteFile(file);
                }
                com.baidu.swan.c.d.createNewFileSafely(file);
                com.baidu.swan.c.d.b(arrayList2, file);
                i(arrayList2, z);
            }
        }
    }

    private static void i(List<String> list, boolean z) {
        if (list != null) {
            synchronized (dph) {
                if (dpi == 0) {
                    if (z) {
                        dpf = list;
                    } else {
                        dpg = list;
                    }
                    if (DEBUG) {
                        Log.d("SwanAppCompat", "has update descriptions, list :" + list.toString() + " type :" + (z ? V8Engine.TYPE_V8 : "webview"));
                    }
                }
            }
        }
    }

    private static boolean h(List<JSONObject> list, List<JSONObject> list2) {
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
    private static List<JSONObject> tB(String str) {
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

    public static void aHZ() {
        if (DEBUG) {
            Log.d("SwanAppCompat", "start release descriptions");
        }
        synchronized (dph) {
            dpi = 0;
            dpf = new ArrayList();
            dpg = new ArrayList();
        }
    }

    public static void aIa() {
        if (DEBUG) {
            Log.d("SwanAppCompat", "on App upgrade");
        }
        com.baidu.swan.apps.storage.c.h.aGy().putBoolean("swan_app_js_native_ab_update_key", true);
    }
}
