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
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0497a dGu;
    private static C0497a dGv;

    public static void l(boolean z, int i) {
        h.aNr().putBoolean(lg(i), z);
    }

    public static boolean lf(int i) {
        return h.aNr().getBoolean(lg(i), false) || !i(i, lh(i)).isAvailable();
    }

    private static String lg(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long lh(int i) {
        return h.aNr().getLong(lm(i), 0L);
    }

    public static void li(int i) {
        h.aNr().putLong(lm(i), 0L);
    }

    public static C0497a lj(int i) {
        return i == 1 ? aNB() : aNC();
    }

    private static C0497a aNB() {
        if (dGv == null) {
            dGv = C0497a.c(lo(1), 1);
        }
        return dGv;
    }

    private static C0497a aNC() {
        if (dGu == null) {
            dGu = C0497a.c(lo(0), 0);
        }
        return dGu;
    }

    public static synchronized Exception lk(int i) {
        Exception l;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!lf(i)) {
                l = null;
            } else {
                C0497a lj = lj(i);
                long j = h.aNr().getLong(ll(i), 0L);
                long ur = com.baidu.swan.apps.swancore.b.ur(lj.aND());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + ur);
                }
                l = l(ur, i);
            }
        }
        return l;
    }

    private static Exception l(long j, int i) {
        c.bt("PresetSwanCoreControl", "doPresetUpdate.");
        String ll = ll(i);
        if (!d.dF(ll, m(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + ll);
            c.f("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(ln(i), arrayList);
        h.aNr().putLong(lm(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        l(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(ll(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aNr().putString(com.baidu.swan.apps.swancore.a.kU(i), md5);
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

    private static String ll(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String lm(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File ln(int i) {
        return new File(com.baidu.swan.apps.swancore.b.lc(i), "preset");
    }

    private static File m(long j, int i) {
        return new File(ln(i), String.valueOf(j));
    }

    private static JSONObject lo(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), lp(i));
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

    private static String lp(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0497a {
        private String dGw;

        public static C0497a c(JSONObject jSONObject, int i) {
            C0497a c0497a = new C0497a();
            if (jSONObject != null) {
                c0497a.dGw = jSONObject.optString(kX(i));
            }
            return c0497a;
        }

        private static String kX(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String aND() {
            return TextUtils.isEmpty(this.dGw) ? "0" : this.dGw;
        }
    }
}
