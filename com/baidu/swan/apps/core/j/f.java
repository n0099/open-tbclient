package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cXW;
    private HashMap<String, c> cXX;

    public static f arE() {
        return a.cXY;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cXW = arF();
        this.cXX = this.cXW.arB();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c nk(String str) {
        if (this.cXX != null) {
            return this.cXX.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cXW.a(cVar, dVar);
    }

    private b arF() {
        return (DEBUG && arG()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean arG() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final f cXY = new f();
    }
}
