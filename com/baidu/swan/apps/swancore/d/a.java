package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static C0194a aXi;
    private static C0194a aXj;

    public static void c(boolean z, int i) {
        f.Ob().putBoolean(ed(i), z);
    }

    public static boolean ec(int i) {
        return f.Ob().getBoolean(ed(i), false);
    }

    private static String ed(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static long ee(int i) {
        return f.Ob().getLong(ei(i), 0L);
    }

    public static C0194a ef(int i) {
        return i == 1 ? Ok() : Ol();
    }

    private static C0194a Ok() {
        if (aXj == null) {
            aXj = C0194a.c(ek(1), 1);
        }
        return aXj;
    }

    private static C0194a Ol() {
        if (aXi == null) {
            aXi = C0194a.c(ek(0), 0);
        }
        return aXi;
    }

    public static synchronized void eg(int i) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (ec(i)) {
                C0194a ef = ef(i);
                long j = f.Ob().getLong(eh(i), 0L);
                long hQ = com.baidu.swan.apps.swancore.b.hQ(ef.aXk);
                if (DEBUG) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + hQ);
                }
                if (j < hQ) {
                    c(hQ, i);
                    if (DEBUG) {
                        Log.d("PresetSwanCoreControl", "onPresetUpdate end.");
                    }
                }
            }
        }
    }

    public static void c(long j, int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "doPresetUpdate.");
        }
        if (com.baidu.swan.c.a.bu(eh(i), d(j, i).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            com.baidu.swan.apps.swancore.b.c(ej(i), arrayList);
            f.Ob().putLong(ei(i), j);
            c(false, i);
            if (DEBUG) {
                String b = com.baidu.swan.c.b.b(new File(eh(i)), false);
                if (!TextUtils.isEmpty(b)) {
                    f.Ob().putString(com.baidu.swan.apps.swancore.a.dR(i), b);
                }
            }
        } else if (DEBUG) {
            Log.e("PresetSwanCoreControl", "doPresetUpdate unzip failed: " + Log.getStackTraceString(new Exception()));
        }
    }

    private static String eh(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    private static String ei(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    private static File ej(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dZ(i), "preset");
    }

    public static File d(long j, int i) {
        return new File(ej(i), String.valueOf(j));
    }

    public static JSONObject ek(int i) {
        if (DEBUG) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String ad = com.baidu.swan.c.a.ad(AppRuntime.getAppContext(), el(i));
        if (TextUtils.isEmpty(ad)) {
            if (DEBUG) {
                throw new RuntimeException("empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ad);
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

    private static String el(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0194a {
        public String aXk;

        public static C0194a c(JSONObject jSONObject, int i) {
            C0194a c0194a = new C0194a();
            if (jSONObject != null) {
                c0194a.aXk = jSONObject.optString(dU(i));
            }
            return c0194a;
        }

        private static String dU(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }
    }
}
