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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0473a dKm;
    private static C0473a dKn;

    public static void k(boolean z, int i) {
        h.aLO().putBoolean(jF(i), z);
    }

    public static boolean jE(int i) {
        return h.aLO().getBoolean(jF(i), false) || !i(i, jG(i)).isAvailable();
    }

    private static String jF(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long jG(int i) {
        return h.aLO().getLong(jL(i), 0L);
    }

    public static void jH(int i) {
        h.aLO().putLong(jL(i), 0L);
    }

    public static C0473a jI(int i) {
        return i == 1 ? aLY() : aLZ();
    }

    private static C0473a aLY() {
        if (dKn == null) {
            dKn = C0473a.c(jN(1), 1);
        }
        return dKn;
    }

    private static C0473a aLZ() {
        if (dKm == null) {
            dKm = C0473a.c(jN(0), 0);
        }
        return dKm;
    }

    public static synchronized Exception jJ(int i) {
        Exception n;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!jE(i)) {
                n = null;
            } else {
                C0473a jI = jI(i);
                long j = h.aLO().getLong(jK(i), 0L);
                long td = com.baidu.swan.apps.swancore.b.td(jI.aMa());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + td);
                }
                n = n(td, i);
            }
        }
        return n;
    }

    private static Exception n(long j, int i) {
        c.br("PresetSwanCoreControl", "doPresetUpdate.");
        String jK = jK(i);
        if (!d.dD(jK, o(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + jK);
            c.g("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(jM(i), arrayList);
        h.aLO().putLong(jL(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String e = e.e(new File(jK(i)), false);
            if (!TextUtils.isEmpty(e)) {
                h.aLO().putString(com.baidu.swan.apps.swancore.a.jt(i), e);
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

    private static String jK(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String jL(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File jM(int i) {
        return new File(com.baidu.swan.apps.swancore.b.jB(i), "preset");
    }

    private static File o(long j, int i) {
        return new File(jM(i), String.valueOf(j));
    }

    private static JSONObject jN(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), jO(i));
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

    private static String jO(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0473a {
        private String dKo;

        public static C0473a c(JSONObject jSONObject, int i) {
            C0473a c0473a = new C0473a();
            if (jSONObject != null) {
                c0473a.dKo = jSONObject.optString(jw(i));
            }
            return c0473a;
        }

        private static String jw(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aMa() {
            return TextUtils.isEmpty(this.dKo) ? "0" : this.dKo;
        }
    }
}
