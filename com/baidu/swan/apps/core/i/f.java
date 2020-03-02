package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b brd;
    private HashMap<String, c> bre;

    public static f PW() {
        return a.brf;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.brd = PX();
        this.bre = this.brd.PT();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c hq(String str) {
        if (this.bre != null) {
            return this.bre.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.brd.a(cVar, dVar);
    }

    private b PX() {
        return (DEBUG && PY()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean PY() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final f brf = new f();
    }
}
