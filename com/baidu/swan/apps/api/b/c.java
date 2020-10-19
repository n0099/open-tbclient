package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cmB;
    private List<a> cmC = new ArrayList();

    private c() {
        this.cmC.add(new b());
    }

    public static c afU() {
        if (cmB == null) {
            synchronized (c.class) {
                if (cmB == null) {
                    cmB = new c();
                }
            }
        }
        return cmB;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lo(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cmC.size()) {
                this.cmC.get(i2).lo(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lp(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cmC.size()) {
                this.cmC.get(i2).lp(str);
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
        if (cmB != null) {
            cmB = null;
        }
    }
}
