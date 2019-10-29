package com.baidu.swan.apps.core.h;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.c;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.install.e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aNk;
    private Map<String, c> aNl;

    public static a GC() {
        if (aNk == null) {
            synchronized (a.class) {
                if (aNk == null) {
                    aNk = new a();
                }
            }
        }
        return aNk;
    }

    public void aj(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File am = e.d.am(str, str2);
            if (am.exists()) {
                String l = com.baidu.swan.c.a.l(new File(am, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(l)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + l);
                }
                c hs = c.hs(l);
                if (this.aNl == null) {
                    this.aNl = new HashMap();
                }
                if (hs != null) {
                    this.aNl.put(str, hs);
                }
            }
        }
    }

    @Nullable
    public c eE(String str) {
        if (this.aNl == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aNl.get(str);
    }

    private void GD() {
        this.aNl = null;
        aNk = null;
    }

    public static void release() {
        if (aNk != null) {
            aNk.GD();
        }
    }
}
