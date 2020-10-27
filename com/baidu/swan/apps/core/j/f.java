package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cIX;
    private HashMap<String, c> cIY;

    public static f aoF() {
        return a.cIZ;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cIX = aoG();
        this.cIY = this.cIX.aoC();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c nn(String str) {
        if (this.cIY != null) {
            return this.cIY.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cIX.a(cVar, dVar);
    }

    private b aoG() {
        return (DEBUG && aoH()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean aoH() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final f cIZ = new f();
    }
}
