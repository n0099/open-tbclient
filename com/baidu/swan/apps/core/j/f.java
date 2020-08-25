package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cmf;
    private HashMap<String, c> cmg;

    public static f ajq() {
        return a.cmh;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cmf = ajr();
        this.cmg = this.cmf.ajn();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c lO(String str) {
        if (this.cmg != null) {
            return this.cmg.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cmf.a(cVar, dVar);
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
        private static final f cmh = new f();
    }
}
