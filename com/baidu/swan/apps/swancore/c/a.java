package com.baidu.swan.apps.swancore.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.d.d;
import com.baidu.swan.d.e;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0403a cPs;
    private static C0403a cPt;

    public static void k(boolean z, int i) {
        h.auW().putBoolean(hC(i), z);
    }

    public static boolean hB(int i) {
        return h.auW().getBoolean(hC(i), false) || !i(i, hD(i)).isAvailable();
    }

    private static String hC(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long hD(int i) {
        return h.auW().getLong(hH(i), 0L);
    }

    public static C0403a hE(int i) {
        return i == 1 ? avg() : avh();
    }

    private static C0403a avg() {
        if (cPt == null) {
            cPt = C0403a.c(hJ(1), 1);
        }
        return cPt;
    }

    private static C0403a avh() {
        if (cPs == null) {
            cPs = C0403a.c(hJ(0), 0);
        }
        return cPs;
    }

    public static synchronized Exception hF(int i) {
        Exception d;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!hB(i)) {
                d = null;
            } else {
                C0403a hE = hE(i);
                long j = h.auW().getLong(hG(i), 0L);
                long qb = com.baidu.swan.apps.swancore.b.qb(hE.avi());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + qb);
                }
                d = d(qb, i);
            }
        }
        return d;
    }

    public static Exception d(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        String hG = hG(i);
        if (!d.cX(hG, e(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + hG);
            if (DEBUG) {
                Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(exc));
                return exc;
            }
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(hI(i), arrayList);
        h.auW().putLong(hH(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(hG(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.auW().putString(com.baidu.swan.apps.swancore.a.hq(i), md5);
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

    private static String hG(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String hH(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File hI(int i) {
        return new File(com.baidu.swan.apps.swancore.b.hy(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(hI(i), String.valueOf(j));
    }

    public static JSONObject hJ(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), hK(i));
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

    private static String hK(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0403a {
        private String cPu;

        public static C0403a c(JSONObject jSONObject, int i) {
            C0403a c0403a = new C0403a();
            if (jSONObject != null) {
                c0403a.cPu = jSONObject.optString(ht(i));
            }
            return c0403a;
        }

        private static String ht(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String avi() {
            return TextUtils.isEmpty(this.cPu) ? "0" : this.cPu;
        }
    }
}
