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
    private static C0476a dNR;
    private static C0476a dNS;

    public static void k(boolean z, int i) {
        h.aMk().putBoolean(jJ(i), z);
    }

    public static boolean jI(int i) {
        return h.aMk().getBoolean(jJ(i), false) || !j(i, jK(i)).isAvailable();
    }

    private static String jJ(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long jK(int i) {
        return h.aMk().getLong(jP(i), 0L);
    }

    public static void jL(int i) {
        h.aMk().putLong(jP(i), 0L);
    }

    public static C0476a jM(int i) {
        return i == 1 ? aMu() : aMv();
    }

    private static C0476a aMu() {
        if (dNS == null) {
            dNS = C0476a.c(jR(1), 1);
        }
        return dNS;
    }

    private static C0476a aMv() {
        if (dNR == null) {
            dNR = C0476a.c(jR(0), 0);
        }
        return dNR;
    }

    public static synchronized Exception jN(int i) {
        Exception n;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!jI(i)) {
                n = null;
            } else {
                C0476a jM = jM(i);
                long j = h.aMk().getLong(jO(i), 0L);
                long tD = com.baidu.swan.apps.swancore.b.tD(jM.aMw());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + tD);
                }
                n = n(tD, i);
            }
        }
        return n;
    }

    private static Exception n(long j, int i) {
        c.bl("PresetSwanCoreControl", "doPresetUpdate.");
        String jO = jO(i);
        if (!d.dx(jO, o(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + jO);
            c.g("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(jQ(i), arrayList);
        h.aMk().putLong(jP(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String e = e.e(new File(jO(i)), false);
            if (!TextUtils.isEmpty(e)) {
                h.aMk().putString(com.baidu.swan.apps.swancore.a.jx(i), e);
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

    private static String jO(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String jP(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File jQ(int i) {
        return new File(com.baidu.swan.apps.swancore.b.jF(i), "preset");
    }

    private static File o(long j, int i) {
        return new File(jQ(i), String.valueOf(j));
    }

    private static JSONObject jR(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), jS(i));
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

    private static String jS(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0476a {
        private String dNT;

        public static C0476a c(JSONObject jSONObject, int i) {
            C0476a c0476a = new C0476a();
            if (jSONObject != null) {
                c0476a.dNT = jSONObject.optString(jA(i));
            }
            return c0476a;
        }

        private static String jA(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aMw() {
            return TextUtils.isEmpty(this.dNT) ? "0" : this.dNT;
        }
    }
}
