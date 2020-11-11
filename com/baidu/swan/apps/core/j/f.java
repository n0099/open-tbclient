package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cOQ;
    private HashMap<String, c> cOR;

    public static f arg() {
        return a.cOS;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cOQ = arh();
        this.cOR = this.cOQ.ard();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c nC(String str) {
        if (this.cOR != null) {
            return this.cOR.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cOQ.a(cVar, dVar);
    }

    private b arh() {
        return (DEBUG && ari()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean ari() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final f cOS = new f();
    }
}
