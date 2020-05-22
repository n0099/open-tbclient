package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bMS;
    private List<a> bMT = new ArrayList();

    private c() {
        this.bMT.add(new b());
    }

    public static c UG() {
        if (bMS == null) {
            synchronized (c.class) {
                if (bMS == null) {
                    bMS = new c();
                }
            }
        }
        return bMS;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void iq(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bMT.size()) {
                this.bMT.get(i2).iq(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void ir(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bMT.size()) {
                this.bMT.get(i2).ir(str);
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
        if (bMS != null) {
            bMS = null;
        }
    }
}
