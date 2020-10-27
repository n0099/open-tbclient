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
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0475a dvk;
    private static C0475a dvl;

    public static void l(boolean z, int i) {
        h.aIs().putBoolean(kC(i), z);
    }

    public static boolean kB(int i) {
        return h.aIs().getBoolean(kC(i), false) || !j(i, kD(i)).isAvailable();
    }

    private static String kC(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long kD(int i) {
        return h.aIs().getLong(kI(i), 0L);
    }

    public static void kE(int i) {
        h.aIs().putLong(kI(i), 0L);
    }

    public static C0475a kF(int i) {
        return i == 1 ? aIC() : aID();
    }

    private static C0475a aIC() {
        if (dvl == null) {
            dvl = C0475a.c(kK(1), 1);
        }
        return dvl;
    }

    private static C0475a aID() {
        if (dvk == null) {
            dvk = C0475a.c(kK(0), 0);
        }
        return dvk;
    }

    public static synchronized Exception kG(int i) {
        Exception h;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!kB(i)) {
                h = null;
            } else {
                C0475a kF = kF(i);
                long j = h.aIs().getLong(kH(i), 0L);
                long tB = com.baidu.swan.apps.swancore.b.tB(kF.aIE());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + tB);
                }
                h = h(tB, i);
            }
        }
        return h;
    }

    private static Exception h(long j, int i) {
        c.bn("PresetSwanCoreControl", "doPresetUpdate.");
        String kH = kH(i);
        if (!d.dz(kH, i(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + kH);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(kJ(i), arrayList);
        h.aIs().putLong(kI(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        l(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(kH(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aIs().putString(com.baidu.swan.apps.swancore.a.kq(i), md5);
            }
        }
        return null;
    }

    public static SwanCoreVersion j(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = i(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String kH(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String kI(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File kJ(int i) {
        return new File(com.baidu.swan.apps.swancore.b.ky(i), "preset");
    }

    private static File i(long j, int i) {
        return new File(kJ(i), String.valueOf(j));
    }

    private static JSONObject kK(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), kL(i));
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

    private static String kL(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0475a {
        private String dvm;

        public static C0475a c(JSONObject jSONObject, int i) {
            C0475a c0475a = new C0475a();
            if (jSONObject != null) {
                c0475a.dvm = jSONObject.optString(kt(i));
            }
            return c0475a;
        }

        private static String kt(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aIE() {
            return TextUtils.isEmpty(this.dvm) ? "0" : this.dvm;
        }
    }
}
