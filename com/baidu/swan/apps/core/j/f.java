package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cTZ;
    private HashMap<String, c> cUa;

    public static f atG() {
        return a.cUb;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cTZ = atH();
        this.cUa = this.cTZ.atD();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c od(String str) {
        if (this.cUa != null) {
            return this.cUa.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cTZ.a(cVar, dVar);
    }

    private b atH() {
        return (DEBUG && atI()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean atI() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private static final f cUb = new f();
    }
}
