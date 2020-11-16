package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cTH;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes7.dex */
    public interface a {
        void anV();
    }

    private c() {
        this.cTH = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.cTH.edit();
    }

    /* loaded from: classes7.dex */
    private static final class b {
        private static final c cTI = new c();
    }

    public static c auK() {
        return b.cTI;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.awW().a(activity, str, str2, aVar);
    }

    public boolean auL() {
        e aGM = e.aGM();
        if (aGM == null) {
            return false;
        }
        return aGM.aHe().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
