package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cuV;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes3.dex */
    public interface a {
        void ahy();
    }

    private c() {
        this.cuV = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.cuV.edit();
    }

    /* loaded from: classes3.dex */
    private static final class b {
        private static final c cuW = new c();
    }

    public static c aol() {
        return b.cuW;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.aqy().a(activity, str, str2, aVar);
    }

    public boolean aom() {
        e aAr = e.aAr();
        if (aAr == null) {
            return false;
        }
        return aAr.aAJ().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
