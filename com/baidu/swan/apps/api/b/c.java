package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cKf;
    private List<a> cKg = new ArrayList();

    private c() {
        this.cKg.add(new b());
    }

    public static c akG() {
        if (cKf == null) {
            synchronized (c.class) {
                if (cKf == null) {
                    cKf = new c();
                }
            }
        }
        return cKf;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lE(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cKg.size()) {
                this.cKg.get(i2).lE(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lF(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cKg.size()) {
                this.cKg.get(i2).lF(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public synchronized void release() {
        if (DEBUG) {
            Log.d("Api-Marker", "release: ");
        }
        if (cKf != null) {
            cKf = null;
        }
    }
}
