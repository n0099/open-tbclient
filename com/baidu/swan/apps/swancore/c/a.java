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
    private static C0449a cYu;
    private static C0449a cYv;

    public static void k(boolean z, int i) {
        h.aDf().putBoolean(jJ(i), z);
    }

    public static boolean jI(int i) {
        return h.aDf().getBoolean(jJ(i), false) || !i(i, jK(i)).isAvailable();
    }

    private static String jJ(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long jK(int i) {
        return h.aDf().getLong(jP(i), 0L);
    }

    public static void jL(int i) {
        h.aDf().putLong(jP(i), 0L);
    }

    public static C0449a jM(int i) {
        return i == 1 ? aDp() : aDq();
    }

    private static C0449a aDp() {
        if (cYv == null) {
            cYv = C0449a.b(jR(1), 1);
        }
        return cYv;
    }

    private static C0449a aDq() {
        if (cYu == null) {
            cYu = C0449a.b(jR(0), 0);
        }
        return cYu;
    }

    public static synchronized Exception jN(int i) {
        Exception d;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!jI(i)) {
                d = null;
            } else {
                C0449a jM = jM(i);
                long j = h.aDf().getLong(jO(i), 0L);
                long sb = com.baidu.swan.apps.swancore.b.sb(jM.aDr());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + sb);
                }
                d = d(sb, i);
            }
        }
        return d;
    }

    private static Exception d(long j, int i) {
        c.bb("PresetSwanCoreControl", "doPresetUpdate.");
        String jO = jO(i);
        if (!d.dn(jO, e(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + jO);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(jQ(i), arrayList);
        h.aDf().putLong(jP(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(jO(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aDf().putString(com.baidu.swan.apps.swancore.a.jx(i), md5);
            }
        }
        return null;
    }

    public static SwanCoreVersion i(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = e(j, i).getPath();
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

    private static File e(long j, int i) {
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
    public static class C0449a {
        private String cYw;

        public static C0449a b(JSONObject jSONObject, int i) {
            C0449a c0449a = new C0449a();
            if (jSONObject != null) {
                c0449a.cYw = jSONObject.optString(jA(i));
            }
            return c0449a;
        }

        private static String jA(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aDr() {
            return TextUtils.isEmpty(this.cYw) ? "0" : this.cYw;
        }
    }
}
