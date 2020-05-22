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
    private static C0391a cHn;
    private static C0391a cHo;

    public static void k(boolean z, int i) {
        h.arO().putBoolean(hg(i), z);
    }

    public static boolean hf(int i) {
        return h.arO().getBoolean(hg(i), false) || !h(i, hh(i)).isAvailable();
    }

    private static String hg(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long hh(int i) {
        return h.arO().getLong(hl(i), 0L);
    }

    public static C0391a hi(int i) {
        return i == 1 ? arY() : arZ();
    }

    private static C0391a arY() {
        if (cHo == null) {
            cHo = C0391a.c(hn(1), 1);
        }
        return cHo;
    }

    private static C0391a arZ() {
        if (cHn == null) {
            cHn = C0391a.c(hn(0), 0);
        }
        return cHn;
    }

    public static synchronized Exception hj(int i) {
        Exception d;
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (!hf(i)) {
                d = null;
            } else {
                C0391a hi = hi(i);
                long j = h.arO().getLong(hk(i), 0L);
                long pi = com.baidu.swan.apps.swancore.b.pi(hi.asa());
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + pi);
                }
                d = d(pi, i);
            }
        }
        return d;
    }

    public static Exception d(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        String hk = hk(i);
        if (!d.cS(hk, e(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + hk);
            if (DEBUG) {
                Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(exc));
                return exc;
            }
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        com.baidu.swan.apps.swancore.b.b(hm(i), arrayList);
        h.arO().putLong(hl(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        k(false, i);
        if (DEBUG) {
            String md5 = e.toMd5(new File(hk(i)), false);
            if (!TextUtils.isEmpty(md5)) {
                h.arO().putString(com.baidu.swan.apps.swancore.a.gU(i), md5);
            }
        }
        return null;
    }

    public static SwanCoreVersion h(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = e(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    private static String hk(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String hl(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File hm(int i) {
        return new File(com.baidu.swan.apps.swancore.b.hc(i), "preset");
    }

    public static File e(long j, int i) {
        return new File(hm(i), String.valueOf(j));
    }

    public static JSONObject hn(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), ho(i));
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

    private static String ho(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0391a {
        private String cHp;

        public static C0391a c(JSONObject jSONObject, int i) {
            C0391a c0391a = new C0391a();
            if (jSONObject != null) {
                c0391a.cHp = jSONObject.optString(gX(i));
            }
            return c0391a;
        }

        private static String gX(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public String asa() {
            return TextUtils.isEmpty(this.cHp) ? "0" : this.cHp;
        }
    }
}
