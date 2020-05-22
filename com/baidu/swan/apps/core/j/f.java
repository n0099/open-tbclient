package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bZo;
    private HashMap<String, c> bZp;

    public static f aaH() {
        return a.bZq;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.bZo = aaI();
        this.bZp = this.bZo.aaE();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c jJ(String str) {
        if (this.bZp != null) {
            return this.bZp.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.bZo.a(cVar, dVar);
    }

    private b aaI() {
        return (DEBUG && aaJ()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean aaJ() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f bZq = new f();
    }
}
