package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.c.d;
import com.baidu.swan.c.e;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0490a dOY;
    private static C0490a dOZ;

    public static void k(boolean z, int i) {
        h.aPI().putBoolean(ll(i), z);
    }

    public static boolean lk(int i) {
        return h.aPI().getBoolean(ll(i), false) || !i(i, lm(i)).isAvailable();
    }

    private static String ll(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long lm(int i) {
        return h.aPI().getLong(lr(i), 0L);
    }

    public static void ln(int i) {
        h.aPI().putLong(lr(i), 0L);
    }

    public static C0490a lo(int i) {
        return i == 1 ? aPS() : aPT();
    }

    private static C0490a aPS() {
        if (dOZ == null) {
            dOZ = C0490a.c(lt(1), 1);
        }
        return dOZ;
    }

    private static C0490a aPT() {
        if (dOY == null) {
            dOY = C0490a.c(lt(0), 0);
        }
        return dOY;
    }

    public static synchronized Exception lp(int i) {
        Exception n;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!lk(i)) {
                n = null;
            } else {
                C0490a lo = lo(i);
                long j = h.aPI().getLong(lq(i), 0L);
                long uo = com.baidu.swan.apps.swancore.b.uo(lo.aPU());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + uo);
                }
                n = n(uo, i);
            }
        }
        return n;
    }

    private static Exception n(long j, int i) {
        c.bs("PresetSwanCoreControl", "doPresetUpdate.");
        String lq = lq(i);
        if (!d.dE(lq, o(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + lq);
            c.g("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(ls(i), arrayList);
        h.aPI().putLong(lr(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String e = e.e(new File(lq(i)), false);
            if (!TextUtils.isEmpty(e)) {
                h.aPI().putString(com.baidu.swan.apps.swancore.a.kZ(i), e);
            }
        }
        return null;
    }

    public static SwanCoreVersion i(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = o(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String lq(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String lr(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File ls(int i) {
        return new File(com.baidu.swan.apps.swancore.b.lh(i), "preset");
    }

    private static File o(long j, int i) {
        return new File(ls(i), String.valueOf(j));
    }

    private static JSONObject lt(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), lu(i));
        if (TextUtils.isEmpty(readAssetData)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(readAssetData);
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

    private static String lu(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0490a {
        private String dPa;

        public static C0490a c(JSONObject jSONObject, int i) {
            C0490a c0490a = new C0490a();
            if (jSONObject != null) {
                c0490a.dPa = jSONObject.optString(lc(i));
            }
            return c0490a;
        }

        private static String lc(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aPU() {
            return TextUtils.isEmpty(this.dPa) ? "0" : this.dPa;
        }
    }
}
