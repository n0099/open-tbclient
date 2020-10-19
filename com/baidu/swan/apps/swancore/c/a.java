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
    private static C0461a dmI;
    private static C0461a dmJ;

    public static void l(boolean z, int i) {
        h.aGy().putBoolean(kr(i), z);
    }

    public static boolean kq(int i) {
        return h.aGy().getBoolean(kr(i), false) || !j(i, ks(i)).isAvailable();
    }

    private static String kr(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long ks(int i) {
        return h.aGy().getLong(kx(i), 0L);
    }

    public static void kt(int i) {
        h.aGy().putLong(kx(i), 0L);
    }

    public static C0461a ku(int i) {
        return i == 1 ? aGI() : aGJ();
    }

    private static C0461a aGI() {
        if (dmJ == null) {
            dmJ = C0461a.c(kz(1), 1);
        }
        return dmJ;
    }

    private static C0461a aGJ() {
        if (dmI == null) {
            dmI = C0461a.c(kz(0), 0);
        }
        return dmI;
    }

    public static synchronized Exception kv(int i) {
        Exception h;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!kq(i)) {
                h = null;
            } else {
                C0461a ku = ku(i);
                long j = h.aGy().getLong(kw(i), 0L);
                long ti = com.baidu.swan.apps.swancore.b.ti(ku.aGK());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + ti);
                }
                h = h(ti, i);
            }
        }
        return h;
    }

    private static Exception h(long j, int i) {
        c.bg("PresetSwanCoreControl", "doPresetUpdate.");
        String kw = kw(i);
        if (!d.ds(kw, i(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + kw);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(ky(i), arrayList);
        h.aGy().putLong(kx(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        l(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(kw(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aGy().putString(com.baidu.swan.apps.swancore.a.kf(i), md5);
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

    private static String kw(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String kx(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File ky(int i) {
        return new File(com.baidu.swan.apps.swancore.b.kn(i), "preset");
    }

    private static File i(long j, int i) {
        return new File(ky(i), String.valueOf(j));
    }

    private static JSONObject kz(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), kA(i));
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

    private static String kA(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0461a {
        private String dmK;

        public static C0461a c(JSONObject jSONObject, int i) {
            C0461a c0461a = new C0461a();
            if (jSONObject != null) {
                c0461a.dmK = jSONObject.optString(ki(i));
            }
            return c0461a;
        }

        private static String ki(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aGK() {
            return TextUtils.isEmpty(this.dmK) ? "0" : this.dmK;
        }
    }
}
