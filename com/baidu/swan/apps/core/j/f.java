package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cAB;
    private HashMap<String, c> cAC;

    public static f amL() {
        return a.cAD;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cAB = amM();
        this.cAC = this.cAB.amI();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c mU(String str) {
        if (this.cAC != null) {
            return this.cAC.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cAB.a(cVar, dVar);
    }

    private b amM() {
        return (DEBUG && amN()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean amN() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final f cAD = new f();
    }
}
