package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g csL;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes8.dex */
    public interface a {
        void agO();
    }

    private c() {
        this.csL = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.csL.edit();
    }

    /* loaded from: classes8.dex */
    private static final class b {
        private static final c csM = new c();
    }

    public static c anB() {
        return b.csM;
    }

    public void a(@NonNull Activity activity, String str, String str2, a aVar) {
        com.baidu.swan.apps.t.a.apO().a(activity, str, str2, aVar);
    }

    public boolean anC() {
        e azI = e.azI();
        if (azI == null) {
            return false;
        }
        return azI.aAa().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
