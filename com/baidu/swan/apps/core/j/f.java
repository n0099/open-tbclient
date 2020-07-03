package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cee;
    private HashMap<String, c> cef;

    public static f abN() {
        return a.ceg;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cee = abO();
        this.cef = this.cee.abK();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c jR(String str) {
        if (this.cef != null) {
            return this.cef.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cee.a(cVar, dVar);
    }

    private b abO() {
        return (DEBUG && abP()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean abP() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f ceg = new f();
    }
}
