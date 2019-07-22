package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0180a aWK;
    private static C0180a aWL;

    public static void c(boolean z, int i) {
        f.NX().putBoolean(ec(i), z);
    }

    public static boolean eb(int i) {
        return f.NX().getBoolean(ec(i), false);
    }

    private static String ec(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long ed(int i) {
        return f.NX().getLong(eh(i), 0L);
    }

    public static C0180a ee(int i) {
        return i == 1 ? Og() : Oh();
    }

    private static C0180a Og() {
        if (aWL == null) {
            aWL = C0180a.c(ej(1), 1);
        }
        return aWL;
    }

    private static C0180a Oh() {
        if (aWK == null) {
            aWK = C0180a.c(ej(0), 0);
        }
        return aWK;
    }

    public static synchronized void ef(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (eb(i)) {
                C0180a ee = ee(i);
                long j = f.NX().getLong(eg(i), 0L);
                long hO = com.baidu.swan.apps.swancore.b.hO(ee.aWM);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + hO);
                }
                if (j < hO) {
                    c(hO, i);
                    if (DEBUG) {
                        Log.d("PresetSwanCoreControl", "onPresetUpdate end.");
                    }
                }
            }
        }
    }

    public static void c(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        if (com.baidu.swan.c.a.bu(eg(i), d(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.c(ei(i), arrayList);
            f.NX().putLong(eh(i), j);
            c(false, i);
            if (DEBUG) {
                String b = com.baidu.swan.c.b.b(new File(eg(i)), false);
                if (!TextUtils.isEmpty(b)) {
                    f.NX().putString(com.baidu.swan.apps.swancore.a.dQ(i), b);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    private static String eg(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String eh(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File ei(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dY(i), "preset");
    }

    public static File d(long j, int i) {
        return new File(ei(i), String.valueOf(j));
    }

    public static JSONObject ej(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String ad = com.baidu.swan.c.a.ad(AppRuntime.getAppContext(), ek(i));
        if (TextUtils.isEmpty(ad)) {
            if (DEBUG) {
                throw new RuntimeException("empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ad);
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    private static String ek(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0180a {
        public String aWM;

        public static C0180a c(JSONObject jSONObject, int i) {
            C0180a c0180a = new C0180a();
            if (jSONObject != null) {
                c0180a.aWM = jSONObject.optString(dT(i));
            }
            return c0180a;
        }

        private static String dT(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
