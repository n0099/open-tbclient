package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cWw;
    private HashMap<String, c> cWx;

    public static f arB() {
        return a.cWy;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cWw = arC();
        this.cWx = this.cWw.ary();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c nd(String str) {
        if (this.cWx != null) {
            return this.cWx.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cWw.a(cVar, dVar);
    }

    private b arC() {
        return (DEBUG && arD()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean arD() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final f cWy = new f();
    }
}
