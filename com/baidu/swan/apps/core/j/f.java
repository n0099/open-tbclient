package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cNg;
    private HashMap<String, c> cNh;

    public static f aqy() {
        return a.cNi;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cNg = aqz();
        this.cNh = this.cNg.aqv();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c nw(String str) {
        if (this.cNh != null) {
            return this.cNh.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cNg.a(cVar, dVar);
    }

    private b aqz() {
        return (DEBUG && aqA()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean aqA() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final f cNi = new f();
    }
}
