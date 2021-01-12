package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cUj;
    private HashMap<String, c> cUk;

    public static f ard() {
        return a.cUl;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cUj = are();
        this.cUk = this.cUj.ara();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c mL(String str) {
        if (this.cUk != null) {
            return this.cUk.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cUj.a(cVar, dVar);
    }

    private b are() {
        return (DEBUG && arf()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean arf() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final f cUl = new f();
    }
}
