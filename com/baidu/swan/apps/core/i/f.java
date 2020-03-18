package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b brq;
    private HashMap<String, c> brr;

    public static f PZ() {
        return a.brs;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.brq = Qa();
        this.brr = this.brq.PW();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c hp(String str) {
        if (this.brr != null) {
            return this.brr.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.brq.a(cVar, dVar);
    }

    private b Qa() {
        return (DEBUG && Qb()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean Qb() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f brs = new f();
    }
}
