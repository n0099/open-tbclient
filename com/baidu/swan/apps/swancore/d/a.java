package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.d.c;
import com.baidu.swan.d.d;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0289a bRX;
    private static C0289a bRY;

    public static void g(boolean z, int i) {
        h.adb().putBoolean(go(i), z);
    }

    public static boolean gn(int i) {
        return h.adb().getBoolean(go(i), false) || !h(i, gp(i)).isAvailable();
    }

    private static String go(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long gp(int i) {
        return h.adb().getLong(gt(i), 0L);
    }

    public static C0289a gq(int i) {
        return i == 1 ? adl() : adm();
    }

    private static C0289a adl() {
        if (bRY == null) {
            bRY = C0289a.c(gv(1), 1);
        }
        return bRY;
    }

    private static C0289a adm() {
        if (bRX == null) {
            bRX = C0289a.c(gv(0), 0);
        }
        return bRX;
    }

    public static synchronized void gr(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (gn(i)) {
                C0289a gq = gq(i);
                long j = h.adb().getLong(gs(i), 0L);
                long ma = com.baidu.swan.apps.swancore.b.ma(gq.bRZ);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + ma);
                }
                d(ma, i);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate end.");
                }
            }
        }
    }

    public static void d(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        if (c.cb(gs(i), e(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.b(gu(i), arrayList);
            h.adb().putLong(gt(i), j);
            g(false, i);
            if (DEBUG) {
                String md5 = d.toMd5(new File(gs(i)), false);
                if (!TextUtils.isEmpty(md5)) {
                    h.adb().putString(com.baidu.swan.apps.swancore.a.gc(i), md5);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    public static SwanCoreVersion h(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = e(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String gs(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String gt(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File gu(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gk(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(gu(i), String.valueOf(j));
    }

    public static JSONObject gv(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = c.readAssetData(AppRuntime.getAppContext(), gw(i));
        if (TextUtils.isEmpty(readAssetData)) {
            if (DEBUG) {
                throw new RuntimeException("empty preset json.");
            }
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

    private static String gw(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0289a {
        public String bRZ;

        public static C0289a c(JSONObject jSONObject, int i) {
            C0289a c0289a = new C0289a();
            if (jSONObject != null) {
                c0289a.bRZ = jSONObject.optString(gf(i));
            }
            return c0289a;
        }

        private static String gf(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
