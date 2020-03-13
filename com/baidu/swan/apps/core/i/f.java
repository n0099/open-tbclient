package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bre;
    private HashMap<String, c> brf;

    public static f PW() {
        return a.brg;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.bre = PX();
        this.brf = this.bre.PT();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c hq(String str) {
        if (this.brf != null) {
            return this.brf.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.bre.a(cVar, dVar);
    }

    private b PX() {
        return (DEBUG && PY()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean PY() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f brg = new f();
    }
}
