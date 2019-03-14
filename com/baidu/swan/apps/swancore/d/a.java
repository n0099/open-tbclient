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
    private static C0176a aTh;
    private static C0176a aTi;

    public static void c(boolean z, int i) {
        f.KL().putBoolean(dP(i), z);
    }

    public static boolean dO(int i) {
        return f.KL().getBoolean(dP(i), false);
    }

    private static String dP(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long dQ(int i) {
        return f.KL().getLong(dU(i), 0L);
    }

    public static C0176a dR(int i) {
        return i == 1 ? KU() : KV();
    }

    private static C0176a KU() {
        if (aTi == null) {
            aTi = C0176a.c(dW(1), 1);
        }
        return aTi;
    }

    private static C0176a KV() {
        if (aTh == null) {
            aTh = C0176a.c(dW(0), 0);
        }
        return aTh;
    }

    public static synchronized void dS(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (dO(i)) {
                C0176a dR = dR(i);
                long j = f.KL().getLong(dT(i), 0L);
                long hg = com.baidu.swan.apps.swancore.b.hg(dR.aTj);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + hg);
                }
                if (j < hg) {
                    e(hg, i);
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
        if (com.baidu.swan.c.b.bm(dT(i), f(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.c(dV(i), arrayList);
            f.KL().putLong(dU(i), j);
            c(false, i);
            if (DEBUG) {
                String c = c.c(new File(dT(i)), false);
                if (!TextUtils.isEmpty(c)) {
                    f.KL().putString(com.baidu.swan.apps.swancore.a.dD(i), c);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    private static String dT(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String dU(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File dV(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dL(i), "preset");
    }

    public static File f(long j, int i) {
        return new File(dV(i), String.valueOf(j));
    }

    public static JSONObject dW(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String aq = com.baidu.swan.c.b.aq(AppRuntime.getAppContext(), dX(i));
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

    private static String dX(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0176a {
        public String aTj;

        public static C0176a c(JSONObject jSONObject, int i) {
            C0176a c0176a = new C0176a();
            if (jSONObject != null) {
                c0176a.aTj = jSONObject.optString(dG(i));
            }
            return c0176a;
        }

        private static String dG(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
