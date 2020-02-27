package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b brc;
    private HashMap<String, c> brd;

    public static f PU() {
        return a.bre;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.brc = PV();
        this.brd = this.brc.PR();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c hq(String str) {
        if (this.brd != null) {
            return this.brd.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.brc.a(cVar, dVar);
    }

    private b PV() {
        return (DEBUG && PW()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean PW() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f bre = new f();
    }
}
