package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bPx;
    private HashMap<String, c> bPy;

    public static f XO() {
        return a.bPz;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.bPx = XP();
        this.bPy = this.bPx.XL();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c iD(String str) {
        if (this.bPy != null) {
            return this.bPy.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.bPx.a(cVar, dVar);
    }

    private b XP() {
        return (DEBUG && XQ()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean XQ() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f bPz = new f();
    }
}
