package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g daD;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes25.dex */
    public interface a {
        void ard();
    }

    private c() {
        this.daD = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.daD.edit();
    }

    /* loaded from: classes25.dex */
    private static final class b {
        private static final c daE = new c();
    }

    public static c axS() {
        return b.daE;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.aAe().a(activity, str, str2, aVar);
    }

    public boolean axT() {
        e aJU = e.aJU();
        if (aJU == null) {
            return false;
        }
        return aJU.aKm().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
