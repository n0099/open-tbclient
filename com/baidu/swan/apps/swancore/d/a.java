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
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0287a bRn;
    private static C0287a bRo;

    public static void f(boolean z, int i) {
        h.acE().putBoolean(gn(i), z);
    }

    public static boolean gm(int i) {
        return h.acE().getBoolean(gn(i), false) || !h(i, go(i)).isAvailable();
    }

    private static String gn(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long go(int i) {
        return h.acE().getLong(gs(i), 0L);
    }

    public static C0287a gp(int i) {
        return i == 1 ? acO() : acP();
    }

    private static C0287a acO() {
        if (bRo == null) {
            bRo = C0287a.c(gu(1), 1);
        }
        return bRo;
    }

    private static C0287a acP() {
        if (bRn == null) {
            bRn = C0287a.c(gu(0), 0);
        }
        return bRn;
    }

    public static synchronized void gq(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (gm(i)) {
                C0287a gp = gp(i);
                long j = h.acE().getLong(gr(i), 0L);
                long lX = com.baidu.swan.apps.swancore.b.lX(gp.bRp);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + lX);
                }
                d(lX, i);
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
        if (c.ca(gr(i), e(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.b(gt(i), arrayList);
            h.acE().putLong(gs(i), j);
            f(false, i);
            if (DEBUG) {
                String md5 = d.toMd5(new File(gr(i)), false);
                if (!TextUtils.isEmpty(md5)) {
                    h.acE().putString(com.baidu.swan.apps.swancore.a.gb(i), md5);
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

    private static String gr(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String gs(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File gt(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gj(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(gt(i), String.valueOf(j));
    }

    public static JSONObject gu(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = c.readAssetData(AppRuntime.getAppContext(), gv(i));
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

    private static String gv(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0287a {
        public String bRp;

        public static C0287a c(JSONObject jSONObject, int i) {
            C0287a c0287a = new C0287a();
            if (jSONObject != null) {
                c0287a.bRp = jSONObject.optString(ge(i));
            }
            return c0287a;
        }

        private static String ge(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
