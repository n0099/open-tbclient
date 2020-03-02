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
    private static C0299a bWc;
    private static C0299a bWd;

    public static void h(boolean z, int i) {
        h.afr().putBoolean(gF(i), z);
    }

    public static boolean gE(int i) {
        return h.afr().getBoolean(gF(i), false) || !h(i, gG(i)).isAvailable();
    }

    private static String gF(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long gG(int i) {
        return h.afr().getLong(gK(i), 0L);
    }

    public static C0299a gH(int i) {
        return i == 1 ? afB() : afC();
    }

    private static C0299a afB() {
        if (bWd == null) {
            bWd = C0299a.c(gM(1), 1);
        }
        return bWd;
    }

    private static C0299a afC() {
        if (bWc == null) {
            bWc = C0299a.c(gM(0), 0);
        }
        return bWc;
    }

    public static synchronized void gI(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (gE(i)) {
                C0299a gH = gH(i);
                long j = h.afr().getLong(gJ(i), 0L);
                long mp = com.baidu.swan.apps.swancore.b.mp(gH.bWe);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + mp);
                }
                d(mp, i);
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
        if (c.ck(gJ(i), e(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.b(gL(i), arrayList);
            h.afr().putLong(gK(i), j);
            h(false, i);
            if (DEBUG) {
                String md5 = d.toMd5(new File(gJ(i)), false);
                if (!TextUtils.isEmpty(md5)) {
                    h.afr().putString(com.baidu.swan.apps.swancore.a.gt(i), md5);
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

    private static String gJ(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String gK(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File gL(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gB(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(gL(i), String.valueOf(j));
    }

    public static JSONObject gM(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = c.readAssetData(AppRuntime.getAppContext(), gN(i));
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

    private static String gN(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0299a {
        public String bWe;

        public static C0299a c(JSONObject jSONObject, int i) {
            C0299a c0299a = new C0299a();
            if (jSONObject != null) {
                c0299a.bWe = jSONObject.optString(gw(i));
            }
            return c0299a;
        }

        private static String gw(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
