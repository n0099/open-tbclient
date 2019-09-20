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
    private static volatile a atT;
    private Map<String, c> atU;

    public static a BI() {
        if (atT == null) {
            synchronized (a.class) {
                if (atT == null) {
                    atT = new a();
                }
            }
        }
        return atT;
    }

    public void ab(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File ae = e.d.ae(str, str2);
            if (ae.exists()) {
                String v = com.baidu.swan.c.a.v(new File(ae, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(v)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + v);
                }
                c gO = c.gO(v);
                if (this.atU == null) {
                    this.atU = new HashMap();
                }
                if (gO != null) {
                    this.atU.put(str, gO);
                }
            }
        }
    }

    @Nullable
    public c dX(String str) {
        if (this.atU == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atU.get(str);
    }

    private void BJ() {
        this.atU = null;
        atT = null;
    }

    public static void release() {
        if (atT != null) {
            atT.BJ();
        }
    }
}
