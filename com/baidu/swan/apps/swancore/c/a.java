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
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0444a daA;
    private static C0444a daB;

    public static void k(boolean z, int i) {
        h.aDP().putBoolean(jU(i), z);
    }

    public static boolean jT(int i) {
        return h.aDP().getBoolean(jU(i), false) || !i(i, jV(i)).isAvailable();
    }

    private static String jU(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long jV(int i) {
        return h.aDP().getLong(ka(i), 0L);
    }

    public static void jW(int i) {
        h.aDP().putLong(ka(i), 0L);
    }

    public static C0444a jX(int i) {
        return i == 1 ? aDZ() : aEa();
    }

    private static C0444a aDZ() {
        if (daB == null) {
            daB = C0444a.b(kc(1), 1);
        }
        return daB;
    }

    private static C0444a aEa() {
        if (daA == null) {
            daA = C0444a.b(kc(0), 0);
        }
        return daA;
    }

    public static synchronized Exception jY(int i) {
        Exception h;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!jT(i)) {
                h = null;
            } else {
                C0444a jX = jX(i);
                long j = h.aDP().getLong(jZ(i), 0L);
                long sw = com.baidu.swan.apps.swancore.b.sw(jX.aEb());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + sw);
                }
                h = h(sw, i);
            }
        }
        return h;
    }

    private static Exception h(long j, int i) {
        c.bb("PresetSwanCoreControl", "doPresetUpdate.");
        String jZ = jZ(i);
        if (!d.dn(jZ, i(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + jZ);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(kb(i), arrayList);
        h.aDP().putLong(ka(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(jZ(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aDP().putString(com.baidu.swan.apps.swancore.a.jI(i), md5);
            }
        }
        return null;
    }

    public static SwanCoreVersion i(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = i(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String jZ(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String ka(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File kb(int i) {
        return new File(com.baidu.swan.apps.swancore.b.jQ(i), "preset");
    }

    private static File i(long j, int i) {
        return new File(kb(i), String.valueOf(j));
    }

    private static JSONObject kc(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), kd(i));
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

    private static String kd(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0444a {
        private String daC;

        public static C0444a b(JSONObject jSONObject, int i) {
            C0444a c0444a = new C0444a();
            if (jSONObject != null) {
                c0444a.daC = jSONObject.optString(jL(i));
            }
            return c0444a;
        }

        private static String jL(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aEb() {
            return TextUtils.isEmpty(this.daC) ? "0" : this.daC;
        }
    }
}
