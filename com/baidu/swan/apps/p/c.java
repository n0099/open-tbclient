package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dcV;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes9.dex */
    public interface a {
        void aoY();
    }

    private c() {
        this.dcV = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.dcV.edit();
    }

    /* loaded from: classes9.dex */
    private static final class b {
        private static final c dcW = new c();
    }

    public static c avO() {
        return b.dcW;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.aya().a(activity, str, str2, aVar);
    }

    public boolean avP() {
        e aIK = e.aIK();
        if (aIK == null) {
            return false;
        }
        return aIK.aJc().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
