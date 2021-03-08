package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dey;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes8.dex */
    public interface a {
        void apb();
    }

    private c() {
        this.dey = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.dey.edit();
    }

    /* loaded from: classes8.dex */
    private static final class b {
        private static final c dez = new c();
    }

    public static c avR() {
        return b.dez;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.ayd().a(activity, str, str2, aVar);
    }

    public boolean avS() {
        e aIN = e.aIN();
        if (aIN == null) {
            return false;
        }
        return aIN.aJf().c("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
