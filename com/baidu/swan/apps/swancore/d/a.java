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
    private static C0226a bpU;
    private static C0226a bpV;

    public static void d(boolean z, int i) {
        f.ST().putBoolean(eY(i), z);
    }

    public static boolean eX(int i) {
        return f.ST().getBoolean(eY(i), false);
    }

    private static String eY(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long eZ(int i) {
        return f.ST().getLong(fd(i), 0L);
    }

    public static C0226a fa(int i) {
        return i == 1 ? Tc() : Td();
    }

    private static C0226a Tc() {
        if (bpV == null) {
            bpV = C0226a.c(ff(1), 1);
        }
        return bpV;
    }

    private static C0226a Td() {
        if (bpU == null) {
            bpU = C0226a.c(ff(0), 0);
        }
        return bpU;
    }

    public static synchronized void fb(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (eX(i)) {
                C0226a fa = fa(i);
                long j = f.ST().getLong(fc(i), 0L);
                long iu = com.baidu.swan.apps.swancore.b.iu(fa.bpW);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + iu);
                }
                if (j < iu) {
                    d(iu, i);
                    if (DEBUG) {
                        Log.d("PresetSwanCoreControl", "onPresetUpdate end.");
                    }
                }
            }
        }
    }

    public static void d(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        if (com.baidu.swan.c.a.bB(fc(i), e(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.c(fe(i), arrayList);
            f.ST().putLong(fd(i), j);
            d(false, i);
            if (DEBUG) {
                String b = com.baidu.swan.c.b.b(new File(fc(i)), false);
                if (!TextUtils.isEmpty(b)) {
                    f.ST().putString(com.baidu.swan.apps.swancore.a.eM(i), b);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    private static String fc(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String fd(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File fe(int i) {
        return new File(com.baidu.swan.apps.swancore.b.eU(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(fe(i), String.valueOf(j));
    }

    public static JSONObject ff(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String ac = com.baidu.swan.c.a.ac(AppRuntime.getAppContext(), fg(i));
        if (TextUtils.isEmpty(ac)) {
            if (DEBUG) {
                throw new RuntimeException("empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ac);
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

    private static String fg(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0226a {
        public String bpW;

        public static C0226a c(JSONObject jSONObject, int i) {
            C0226a c0226a = new C0226a();
            if (jSONObject != null) {
                c0226a.bpW = jSONObject.optString(eP(i));
            }
            return c0226a;
        }

        private static String eP(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
