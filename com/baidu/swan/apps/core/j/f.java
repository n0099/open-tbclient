package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cYV;
    private HashMap<String, c> cYW;

    public static f auY() {
        return a.cYX;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cYV = auZ();
        this.cYW = this.cYV.auV();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c nW(String str) {
        if (this.cYW != null) {
            return this.cYW.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cYV.a(cVar, dVar);
    }

    private b auZ() {
        return (DEBUG && ava()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean ava() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final f cYX = new f();
    }
}
