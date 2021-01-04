package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cKW;
    private List<a> cKX = new ArrayList();

    private c() {
        this.cKX.add(new b());
    }

    public static c anY() {
        if (cKW == null) {
            synchronized (c.class) {
                if (cKW == null) {
                    cKW = new c();
                }
            }
        }
        return cKW;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void mq(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cKX.size()) {
                this.cKX.get(i2).mq(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void mr(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cKX.size()) {
                this.cKX.get(i2).mr(str);
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
        if (cKW != null) {
            cKW = null;
        }
    }
}
