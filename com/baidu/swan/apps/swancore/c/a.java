package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.e.d;
import com.baidu.swan.e.e;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0397a cLX;
    private static C0397a cLY;

    public static void k(boolean z, int i) {
        h.asV().putBoolean(ht(i), z);
    }

    public static boolean hs(int i) {
        return h.asV().getBoolean(ht(i), false) || !i(i, hu(i)).isAvailable();
    }

    private static String ht(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long hu(int i) {
        return h.asV().getLong(hy(i), 0L);
    }

    public static C0397a hv(int i) {
        return i == 1 ? atf() : atg();
    }

    private static C0397a atf() {
        if (cLY == null) {
            cLY = C0397a.c(hA(1), 1);
        }
        return cLY;
    }

    private static C0397a atg() {
        if (cLX == null) {
            cLX = C0397a.c(hA(0), 0);
        }
        return cLX;
    }

    public static synchronized Exception hw(int i) {
        Exception d;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!hs(i)) {
                d = null;
            } else {
                C0397a hv = hv(i);
                long j = h.asV().getLong(hx(i), 0L);
                long pq = com.baidu.swan.apps.swancore.b.pq(hv.ath());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + pq);
                }
                d = d(pq, i);
            }
        }
        return d;
    }

    public static Exception d(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        String hx = hx(i);
        if (!d.cU(hx, e(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + hx);
            if (DEBUG) {
                Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(exc));
                return exc;
            }
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(hz(i), arrayList);
        h.asV().putLong(hy(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(hx(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.asV().putString(com.baidu.swan.apps.swancore.a.hh(i), md5);
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

    private static String hx(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String hy(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File hz(int i) {
        return new File(com.baidu.swan.apps.swancore.b.hp(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(hz(i), String.valueOf(j));
    }

    public static JSONObject hA(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), hB(i));
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

    private static String hB(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0397a {
        private String cLZ;

        public static C0397a c(JSONObject jSONObject, int i) {
            C0397a c0397a = new C0397a();
            if (jSONObject != null) {
                c0397a.cLZ = jSONObject.optString(hk(i));
            }
            return c0397a;
        }

        private static String hk(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String ath() {
            return TextUtils.isEmpty(this.cLZ) ? "0" : this.cLZ;
        }
    }
}
