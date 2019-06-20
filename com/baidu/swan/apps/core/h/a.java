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
    private static volatile a asS;
    private Map<String, c> asT;

    public static a AW() {
        if (asS == null) {
            synchronized (a.class) {
                if (asS == null) {
                    asS = new a();
                }
            }
        }
        return asS;
    }

    public void ab(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File ae = e.d.ae(str, str2);
            if (ae.exists()) {
                String v = com.baidu.swan.c.a.v(new File(ae, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(v)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + v);
                }
                c gF = c.gF(v);
                if (this.asT == null) {
                    this.asT = new HashMap();
                }
                if (gF != null) {
                    this.asT.put(str, gF);
                }
            }
        }
    }

    @Nullable
    public c dQ(String str) {
        if (this.asT == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.asT.get(str);
    }

    private void AX() {
        this.asT = null;
        asS = null;
    }

    public static void release() {
        if (asS != null) {
            asS.AX();
        }
    }
}
