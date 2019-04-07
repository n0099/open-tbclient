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
    private static volatile a asD;
    private Map<String, c> asE;

    public static a zN() {
        if (asD == null) {
            synchronized (a.class) {
                if (asD == null) {
                    asD = new a();
                }
            }
        }
        return asD;
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
                if (this.asE == null) {
                    this.asE = new HashMap();
                }
                if (gl != null) {
                    this.asE.put(str, gl);
                }
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.a.c ed(String str) {
        if (this.asE == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.asE.get(str);
    }

    private void zO() {
        this.asE = null;
        asD = null;
    }

    public static void release() {
        if (asD != null) {
            asD.zO();
        }
    }
}
