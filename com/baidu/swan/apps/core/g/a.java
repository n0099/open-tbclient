package com.baidu.swan.apps.core.g;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.c;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.install.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a asz;
    private Map<String, c> asA;

    public static a zO() {
        if (asz == null) {
            synchronized (a.class) {
                if (asz == null) {
                    asz = new a();
                }
            }
        }
        return asz;
    }

    public void af(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File ah = c.d.ah(str, str2);
            if (ah.exists()) {
                String B = com.baidu.swan.c.b.B(new File(ah, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(B)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + B);
                }
                com.baidu.swan.apps.ae.a.c gk = com.baidu.swan.apps.ae.a.c.gk(B);
                if (this.asA == null) {
                    this.asA = new HashMap();
                }
                if (gk != null) {
                    this.asA.put(str, gk);
                }
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.a.c eb(String str) {
        if (this.asA == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.asA.get(str);
    }

    private void zP() {
        this.asA = null;
        asz = null;
    }

    public static void release() {
        if (asz != null) {
            asz.zP();
        }
    }
}
