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
    private static C0470a dMq;
    private static C0470a dMr;

    public static void k(boolean z, int i) {
        h.aMh().putBoolean(jI(i), z);
    }

    public static boolean jH(int i) {
        return h.aMh().getBoolean(jI(i), false) || !j(i, jJ(i)).isAvailable();
    }

    private static String jI(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long jJ(int i) {
        return h.aMh().getLong(jO(i), 0L);
    }

    public static void jK(int i) {
        h.aMh().putLong(jO(i), 0L);
    }

    public static C0470a jL(int i) {
        return i == 1 ? aMr() : aMs();
    }

    private static C0470a aMr() {
        if (dMr == null) {
            dMr = C0470a.c(jQ(1), 1);
        }
        return dMr;
    }

    private static C0470a aMs() {
        if (dMq == null) {
            dMq = C0470a.c(jQ(0), 0);
        }
        return dMq;
    }

    public static synchronized Exception jM(int i) {
        Exception n;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!jH(i)) {
                n = null;
            } else {
                C0470a jL = jL(i);
                long j = h.aMh().getLong(jN(i), 0L);
                long tw = com.baidu.swan.apps.swancore.b.tw(jL.aMt());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + tw);
                }
                n = n(tw, i);
            }
        }
        return n;
    }

    private static Exception n(long j, int i) {
        c.bl("PresetSwanCoreControl", "doPresetUpdate.");
        String jN = jN(i);
        if (!d.dx(jN, o(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + jN);
            c.g("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(jP(i), arrayList);
        h.aMh().putLong(jO(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String e = e.e(new File(jN(i)), false);
            if (!TextUtils.isEmpty(e)) {
                h.aMh().putString(com.baidu.swan.apps.swancore.a.jw(i), e);
            }
        }
        return null;
    }

    public static SwanCoreVersion j(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = o(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String jN(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String jO(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File jP(int i) {
        return new File(com.baidu.swan.apps.swancore.b.jE(i), "preset");
    }

    private static File o(long j, int i) {
        return new File(jP(i), String.valueOf(j));
    }

    private static JSONObject jQ(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), jR(i));
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

    private static String jR(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0470a {
        private String dMs;

        public static C0470a c(JSONObject jSONObject, int i) {
            C0470a c0470a = new C0470a();
            if (jSONObject != null) {
                c0470a.dMs = jSONObject.optString(jz(i));
            }
            return c0470a;
        }

        private static String jz(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aMt() {
            return TextUtils.isEmpty(this.dMs) ? "0" : this.dMs;
        }
    }
}
