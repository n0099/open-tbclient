package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cfN;
    private HashMap<String, c> cfO;

    public static f acR() {
        return a.cfP;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.cfN = acS();
        this.cfO = this.cfN.acO();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c kk(String str) {
        if (this.cfO != null) {
            return this.cfO.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.cfN.a(cVar, dVar);
    }

    private b acS() {
        return (DEBUG && acT()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean acT() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final f cfP = new f();
    }
}
