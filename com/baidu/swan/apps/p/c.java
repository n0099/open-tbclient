package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cPy;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes10.dex */
    public interface a {
        void amd();
    }

    private c() {
        this.cPy = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.cPy.edit();
    }

    /* loaded from: classes10.dex */
    private static final class b {
        private static final c cPz = new c();
    }

    public static c asS() {
        return b.cPz;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.ave().a(activity, str, str2, aVar);
    }

    public boolean asT() {
        e aEU = e.aEU();
        if (aEU == null) {
            return false;
        }
        return aEU.aFm().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
