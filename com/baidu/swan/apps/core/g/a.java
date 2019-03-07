package com.baidu.swan.apps.core.g;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.c.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private static volatile a asy;
    private Map<String, com.baidu.swan.apps.ae.a.c> asz;

    public static a zO() {
        if (asy == null) {
            synchronized (a.class) {
                if (asy == null) {
                    asy = new a();
                }
            }
        }
        return asy;
    }

    public void af(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File ah = c.d.ah(str, str2);
            if (ah.exists()) {
                String B = b.B(new File(ah, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(B)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + B);
                }
                com.baidu.swan.apps.ae.a.c gk = com.baidu.swan.apps.ae.a.c.gk(B);
                if (this.asz == null) {
                    this.asz = new HashMap();
                }
                if (gk != null) {
                    this.asz.put(str, gk);
                }
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.a.c eb(String str) {
        if (this.asz == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.asz.get(str);
    }

    private void zP() {
        this.asz = null;
        asy = null;
    }

    public static void release() {
        if (asy != null) {
            asy.zP();
        }
    }
}
