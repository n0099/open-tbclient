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
    private static volatile a asE;
    private Map<String, c> asF;

    public static a zN() {
        if (asE == null) {
            synchronized (a.class) {
                if (asE == null) {
                    asE = new a();
                }
            }
        }
        return asE;
    }

    public void af(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File ah = c.d.ah(str, str2);
            if (ah.exists()) {
                String B = com.baidu.swan.c.b.B(new File(ah, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(B)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + B);
                }
                com.baidu.swan.apps.ae.a.c gl = com.baidu.swan.apps.ae.a.c.gl(B);
                if (this.asF == null) {
                    this.asF = new HashMap();
                }
                if (gl != null) {
                    this.asF.put(str, gl);
                }
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.a.c ed(String str) {
        if (this.asF == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.asF.get(str);
    }

    private void zO() {
        this.asF = null;
        asE = null;
    }

    public static void release() {
        if (asE != null) {
            asE.zO();
        }
    }
}
