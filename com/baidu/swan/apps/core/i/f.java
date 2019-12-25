package com.baidu.swan.apps.core.i;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bmd;
    private HashMap<String, c> bme;

    public static f Nk() {
        return a.bmf;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.bmd = Nl();
        this.bme = this.bmd.Nh();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c gY(String str) {
        if (this.bme != null) {
            return this.bme.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.bmd.a(cVar, dVar);
    }

    private b Nl() {
        return (DEBUG && Nm()) ? new e() : new com.baidu.swan.apps.core.i.a();
    }

    public static boolean Nm() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final f bmf = new f();
    }
}
