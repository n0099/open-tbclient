package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bmT;
    private HashMap<String, c> bmU;

    public static f NG() {
        return a.bmV;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.bmT = NH();
        this.bmU = this.bmT.ND();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c hb(String str) {
        if (this.bmU != null) {
            return this.bmU.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.bmT.a(cVar, dVar);
    }

    private b NH() {
        return (DEBUG && NI()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean NI() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final f bmV = new f();
    }
}
