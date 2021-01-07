package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dfy;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes9.dex */
    public interface a {
        void asw();
    }

    private c() {
        this.dfy = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.dfy.edit();
    }

    /* loaded from: classes9.dex */
    private static final class b {
        private static final c dfz = new c();
    }

    public static c azk() {
        return b.dfz;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.aBw().a(activity, str, str2, aVar);
    }

    public boolean azl() {
        e aMl = e.aMl();
        if (aMl == null) {
            return false;
        }
        return aMl.aMD().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
