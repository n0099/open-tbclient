package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bYk;
    private List<a> bYl = new ArrayList();

    private c() {
        this.bYl.add(new b());
    }

    public static c acz() {
        if (bYk == null) {
            synchronized (c.class) {
                if (bYk == null) {
                    bYk = new c();
                }
            }
        }
        return bYk;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void kj(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bYl.size()) {
                this.bYl.get(i2).kj(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void kk(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bYl.size()) {
                this.bYl.get(i2).kk(str);
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
        if (bYk != null) {
            bYk = null;
        }
    }
}
