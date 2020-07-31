package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bSy;
    private List<a> bSz = new ArrayList();

    private c() {
        this.bSz.add(new b());
    }

    public static c Wt() {
        if (bSy == null) {
            synchronized (c.class) {
                if (bSy == null) {
                    bSy = new c();
                }
            }
        }
        return bSy;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void iI(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bSz.size()) {
                this.bSz.get(i2).iI(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void iJ(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bSz.size()) {
                this.bSz.get(i2).iJ(str);
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
        if (bSy != null) {
            bSy = null;
        }
    }
}
