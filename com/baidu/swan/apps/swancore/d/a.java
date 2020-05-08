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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0350a cvl;
    private static C0350a cvm;

    public static void i(boolean z, int i) {
        h.any().putBoolean(gM(i), z);
    }

    public static boolean gL(int i) {
        return h.any().getBoolean(gM(i), false) || !h(i, gN(i)).isAvailable();
    }

    private static String gM(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long gN(int i) {
        return h.any().getLong(gR(i), 0L);
    }

    public static C0350a gO(int i) {
        return i == 1 ? anI() : anJ();
    }

    private static C0350a anI() {
        if (cvm == null) {
            cvm = C0350a.c(gT(1), 1);
        }
        return cvm;
    }

    private static C0350a anJ() {
        if (cvl == null) {
            cvl = C0350a.c(gT(0), 0);
        }
        return cvl;
    }

    public static synchronized void gP(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (gL(i)) {
                C0350a gO = gO(i);
                long j = h.any().getLong(gQ(i), 0L);
                long nB = com.baidu.swan.apps.swancore.b.nB(gO.cvn);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + nB);
                }
                d(nB, i);
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
        if (c.cu(gQ(i), e(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.b(gS(i), arrayList);
            h.any().putLong(gR(i), j);
            i(false, i);
            if (DEBUG) {
                String md5 = d.toMd5(new File(gQ(i)), false);
                if (!TextUtils.isEmpty(md5)) {
                    h.any().putString(com.baidu.swan.apps.swancore.a.gA(i), md5);
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

    private static String gQ(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String gR(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File gS(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gI(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(gS(i), String.valueOf(j));
    }

    public static JSONObject gT(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = c.readAssetData(AppRuntime.getAppContext(), gU(i));
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

    private static String gU(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0350a {
        public String cvn;

        public static C0350a c(JSONObject jSONObject, int i) {
            C0350a c0350a = new C0350a();
            if (jSONObject != null) {
                c0350a.cvn = jSONObject.optString(gD(i));
            }
            return c0350a;
        }

        private static String gD(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
