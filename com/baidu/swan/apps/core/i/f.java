package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bPC;
    private HashMap<String, c> bPD;

    public static f XN() {
        return a.bPE;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.bPC = XO();
        this.bPD = this.bPC.XK();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c iD(String str) {
        if (this.bPD != null) {
            return this.bPD.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.bPC.a(cVar, dVar);
    }

    private b XO() {
        return (DEBUG && XP()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean XP() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f bPE = new f();
    }
}
