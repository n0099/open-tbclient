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
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0485a dzv;
    private static C0485a dzw;

    public static void l(boolean z, int i) {
        h.aKk().putBoolean(kI(i), z);
    }

    public static boolean kH(int i) {
        return h.aKk().getBoolean(kI(i), false) || !i(i, kJ(i)).isAvailable();
    }

    private static String kI(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long kJ(int i) {
        return h.aKk().getLong(kO(i), 0L);
    }

    public static void kK(int i) {
        h.aKk().putLong(kO(i), 0L);
    }

    public static C0485a kL(int i) {
        return i == 1 ? aKu() : aKv();
    }

    private static C0485a aKu() {
        if (dzw == null) {
            dzw = C0485a.c(kQ(1), 1);
        }
        return dzw;
    }

    private static C0485a aKv() {
        if (dzv == null) {
            dzv = C0485a.c(kQ(0), 0);
        }
        return dzv;
    }

    public static synchronized Exception kM(int i) {
        Exception l;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!kH(i)) {
                l = null;
            } else {
                C0485a kL = kL(i);
                long j = h.aKk().getLong(kN(i), 0L);
                long tK = com.baidu.swan.apps.swancore.b.tK(kL.aKw());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + tK);
                }
                l = l(tK, i);
            }
        }
        return l;
    }

    private static Exception l(long j, int i) {
        c.bm("PresetSwanCoreControl", "doPresetUpdate.");
        String kN = kN(i);
        if (!d.dy(kN, m(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + kN);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(kP(i), arrayList);
        h.aKk().putLong(kO(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        l(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(kN(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aKk().putString(com.baidu.swan.apps.swancore.a.kw(i), md5);
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

    private static String kN(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String kO(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File kP(int i) {
        return new File(com.baidu.swan.apps.swancore.b.kE(i), "preset");
    }

    private static File m(long j, int i) {
        return new File(kP(i), String.valueOf(j));
    }

    private static JSONObject kQ(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), kR(i));
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

    private static String kR(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0485a {
        private String dzx;

        public static C0485a c(JSONObject jSONObject, int i) {
            C0485a c0485a = new C0485a();
            if (jSONObject != null) {
                c0485a.dzx = jSONObject.optString(kz(i));
            }
            return c0485a;
        }

        private static String kz(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aKw() {
            return TextUtils.isEmpty(this.dzx) ? "0" : this.dzx;
        }
    }
}
