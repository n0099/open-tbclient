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
    private static C0183a aWa;
    private static C0183a aWb;

    public static void c(boolean z, int i) {
        f.Ni().putBoolean(dZ(i), z);
    }

    public static boolean dY(int i) {
        return f.Ni().getBoolean(dZ(i), false);
    }

    private static String dZ(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long ea(int i) {
        return f.Ni().getLong(ee(i), 0L);
    }

    public static C0183a eb(int i) {
        return i == 1 ? Nr() : Ns();
    }

    private static C0183a Nr() {
        if (aWb == null) {
            aWb = C0183a.c(eg(1), 1);
        }
        return aWb;
    }

    private static C0183a Ns() {
        if (aWa == null) {
            aWa = C0183a.c(eg(0), 0);
        }
        return aWa;
    }

    public static synchronized void ec(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (dY(i)) {
                C0183a eb = eb(i);
                long j = f.Ni().getLong(ed(i), 0L);
                long hI = com.baidu.swan.apps.swancore.b.hI(eb.aWc);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + hI);
                }
                if (j < hI) {
                    c(hI, i);
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
        if (com.baidu.swan.c.a.bu(ed(i), d(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.c(ef(i), arrayList);
            f.Ni().putLong(ee(i), j);
            c(false, i);
            if (DEBUG) {
                String b = com.baidu.swan.c.b.b(new File(ed(i)), false);
                if (!TextUtils.isEmpty(b)) {
                    f.Ni().putString(com.baidu.swan.apps.swancore.a.dN(i), b);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    private static String ed(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String ee(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File ef(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dV(i), "preset");
    }

    public static File d(long j, int i) {
        return new File(ef(i), String.valueOf(j));
    }

    public static JSONObject eg(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String ae = com.baidu.swan.c.a.ae(AppRuntime.getAppContext(), eh(i));
        if (TextUtils.isEmpty(ae)) {
            if (DEBUG) {
                throw new RuntimeException("empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ae);
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

    private static String eh(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0183a {
        public String aWc;

        public static C0183a c(JSONObject jSONObject, int i) {
            C0183a c0183a = new C0183a();
            if (jSONObject != null) {
                c0183a.aWc = jSONObject.optString(dQ(i));
            }
            return c0183a;
        }

        private static String dQ(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
