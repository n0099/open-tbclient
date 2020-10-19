package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cHc;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes10.dex */
    public interface a {
        void akj();
    }

    private c() {
        this.cHc = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.cHc.edit();
    }

    /* loaded from: classes10.dex */
    private static final class b {
        private static final c cHd = new c();
    }

    public static c aqX() {
        return b.cHd;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.atk().a(activity, str, str2, aVar);
    }

    public boolean aqY() {
        e aDa = e.aDa();
        if (aDa == null) {
            return false;
        }
        return aDa.aDs().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
