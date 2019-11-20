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
    private static volatile a aMS;
    private Map<String, c> aMT;

    public static a GD() {
        if (aMS == null) {
            synchronized (a.class) {
                if (aMS == null) {
                    aMS = new a();
                }
            }
        }
        return aMS;
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
                if (this.aMT == null) {
                    this.aMT = new HashMap();
                }
                if (hs != null) {
                    this.aMT.put(str, hs);
                }
            }
        }
    }

    @Nullable
    public c eE(String str) {
        if (this.aMT == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aMT.get(str);
    }

    private void GE() {
        this.aMT = null;
        aMS = null;
    }

    public static void release() {
        if (aMS != null) {
            aMS.GE();
        }
    }
}
