package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g daJ;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes8.dex */
    public interface a {
        void aoA();
    }

    private c() {
        this.daJ = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.daJ.edit();
    }

    /* loaded from: classes8.dex */
    private static final class b {
        private static final c daK = new c();
    }

    public static c avq() {
        return b.daK;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.axC().a(activity, str, str2, aVar);
    }

    public boolean avr() {
        e aIr = e.aIr();
        if (aIr == null) {
            return false;
        }
        return aIr.aIJ().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
