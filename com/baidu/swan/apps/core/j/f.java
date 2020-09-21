package com.baidu.swan.apps.core.j;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b col;

    /* renamed from: com  reason: collision with root package name */
    private HashMap<String, c> f970com;

    public static f aka() {
        return a.coo;
    }

    private f() {
        long currentTimeMillis = System.currentTimeMillis();
        this.col = akb();
        this.f970com = this.col.ajX();
        if (DEBUG) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Nullable
    public c mi(String str) {
        if (this.f970com != null) {
            return this.f970com.get(str);
        }
        return null;
    }

    public void a(c cVar, d dVar) {
        this.col.a(cVar, dVar);
    }

    private b akb() {
        return (DEBUG && akc()) ? new e() : new com.baidu.swan.apps.core.j.a();
    }

    public static boolean akc() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final f coo = new f();
    }
}
