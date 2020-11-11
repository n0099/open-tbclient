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
    private static C0487a dBc;
    private static C0487a dBd;

    public static void l(boolean z, int i) {
        h.aKS().putBoolean(kM(i), z);
    }

    public static boolean kL(int i) {
        return h.aKS().getBoolean(kM(i), false) || !i(i, kN(i)).isAvailable();
    }

    private static String kM(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long kN(int i) {
        return h.aKS().getLong(kS(i), 0L);
    }

    public static void kO(int i) {
        h.aKS().putLong(kS(i), 0L);
    }

    public static C0487a kP(int i) {
        return i == 1 ? aLc() : aLd();
    }

    private static C0487a aLc() {
        if (dBd == null) {
            dBd = C0487a.c(kU(1), 1);
        }
        return dBd;
    }

    private static C0487a aLd() {
        if (dBc == null) {
            dBc = C0487a.c(kU(0), 0);
        }
        return dBc;
    }

    public static synchronized Exception kQ(int i) {
        Exception l;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!kL(i)) {
                l = null;
            } else {
                C0487a kP = kP(i);
                long j = h.aKS().getLong(kR(i), 0L);
                long tP = com.baidu.swan.apps.swancore.b.tP(kP.aLe());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + tP);
                }
                l = l(tP, i);
            }
        }
        return l;
    }

    private static Exception l(long j, int i) {
        c.bn("PresetSwanCoreControl", "doPresetUpdate.");
        String kR = kR(i);
        if (!d.dz(kR, m(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + kR);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(kT(i), arrayList);
        h.aKS().putLong(kS(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        l(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(kR(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aKS().putString(com.baidu.swan.apps.swancore.a.kA(i), md5);
            }
        }
        return null;
    }

    public static SwanCoreVersion i(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = m(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String kR(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String kS(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File kT(int i) {
        return new File(com.baidu.swan.apps.swancore.b.kI(i), "preset");
    }

    private static File m(long j, int i) {
        return new File(kT(i), String.valueOf(j));
    }

    private static JSONObject kU(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), kV(i));
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

    private static String kV(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0487a {
        private String dBe;

        public static C0487a c(JSONObject jSONObject, int i) {
            C0487a c0487a = new C0487a();
            if (jSONObject != null) {
                c0487a.dBe = jSONObject.optString(kD(i));
            }
            return c0487a;
        }

        private static String kD(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aLe() {
            return TextUtils.isEmpty(this.dBe) ? "0" : this.dBe;
        }
    }
}
