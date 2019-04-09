package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.c.c;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0176a aTl;
    private static C0176a aTm;

    public static void c(boolean z, int i) {
        f.KJ().putBoolean(dO(i), z);
    }

    public static boolean dN(int i) {
        return f.KJ().getBoolean(dO(i), false);
    }

    private static String dO(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long dP(int i) {
        return f.KJ().getLong(dT(i), 0L);
    }

    public static C0176a dQ(int i) {
        return i == 1 ? KS() : KT();
    }

    private static C0176a KS() {
        if (aTm == null) {
            aTm = C0176a.c(dV(1), 1);
        }
        return aTm;
    }

    private static C0176a KT() {
        if (aTl == null) {
            aTl = C0176a.c(dV(0), 0);
        }
        return aTl;
    }

    public static synchronized void dR(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (dN(i)) {
                C0176a dQ = dQ(i);
                long j = f.KJ().getLong(dS(i), 0L);
                long hh = com.baidu.swan.apps.swancore.b.hh(dQ.aTn);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + hh);
                }
                if (j < hh) {
                    e(hh, i);
                    if (DEBUG) {
                        Log.d("PresetSwanCoreControl", "onPresetUpdate end.");
                    }
                }
            }
        }
    }

    public static void e(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        if (com.baidu.swan.c.b.bm(dS(i), f(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.c(dU(i), arrayList);
            f.KJ().putLong(dT(i), j);
            c(false, i);
            if (DEBUG) {
                String c = c.c(new File(dS(i)), false);
                if (!TextUtils.isEmpty(c)) {
                    f.KJ().putString(com.baidu.swan.apps.swancore.a.dC(i), c);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    private static String dS(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String dT(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File dU(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dK(i), "preset");
    }

    public static File f(long j, int i) {
        return new File(dU(i), String.valueOf(j));
    }

    public static JSONObject dV(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String aq = com.baidu.swan.c.b.aq(AppRuntime.getAppContext(), dW(i));
        if (TextUtils.isEmpty(aq)) {
            if (DEBUG) {
                throw new RuntimeException("empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(aq);
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

    private static String dW(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0176a {
        public String aTn;

        public static C0176a c(JSONObject jSONObject, int i) {
            C0176a c0176a = new C0176a();
            if (jSONObject != null) {
                c0176a.aTn = jSONObject.optString(dF(i));
            }
            return c0176a;
        }

        private static String dF(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
