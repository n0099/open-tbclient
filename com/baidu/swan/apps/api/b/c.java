package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cAY;
    private List<a> cAZ = new ArrayList();

    private c() {
        this.cAZ.add(new b());
    }

    public static c ako() {
        if (cAY == null) {
            synchronized (c.class) {
                if (cAY == null) {
                    cAY = new c();
                }
            }
        }
        return cAY;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lW(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cAZ.size()) {
                this.cAZ.get(i2).lW(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lX(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cAZ.size()) {
                this.cAZ.get(i2).lX(str);
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
        if (cAY != null) {
            cAY = null;
        }
    }
}
