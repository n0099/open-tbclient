package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cVr;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes10.dex */
    public interface a {
        void aoD();
    }

    private c() {
        this.cVr = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.cVr.edit();
    }

    /* loaded from: classes10.dex */
    private static final class b {
        private static final c cVs = new c();
    }

    public static c avs() {
        return b.cVs;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.axE().a(activity, str, str2, aVar);
    }

    public boolean avt() {
        e aHu = e.aHu();
        if (aHu == null) {
            return false;
        }
        return aHu.aHM().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
