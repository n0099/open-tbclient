package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cmj;
    private HashMap<String, c> cmk;

    public static f ajq() {
        return a.cml;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cmj = ajr();
        this.cmk = this.cmj.ajn();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c lP(String str) {
        if (this.cmk != null) {
            return this.cmk.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cmj.a(cVar, dVar);
    }

    private b ajr() {
        return (DEBUG && ajs()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean ajs() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final f cml = new f();
    }
}
