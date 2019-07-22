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
    private static volatile a atv;
    private Map<String, c> atw;

    public static a BE() {
        if (atv == null) {
            synchronized (a.class) {
                if (atv == null) {
                    atv = new a();
                }
            }
        }
        return atv;
    }

    public void ab(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File ae = e.d.ae(str, str2);
            if (ae.exists()) {
                String v = com.baidu.swan.c.a.v(new File(ae, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(v)) {
                    Log.i("SwanAppPreHandleHelper", "pre handle configData : " + v);
                }
                c gM = c.gM(v);
                if (this.atw == null) {
                    this.atw = new HashMap();
                }
                if (gM != null) {
                    this.atw.put(str, gM);
                }
            }
        }
    }

    @Nullable
    public c dV(String str) {
        if (this.atw == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atw.get(str);
    }

    private void BF() {
        this.atw = null;
        atv = null;
    }

    public static void release() {
        if (atv != null) {
            atv.BF();
        }
    }
}
