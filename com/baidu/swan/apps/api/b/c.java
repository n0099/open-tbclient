package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cIF;
    private List<a> cIG = new ArrayList();

    private c() {
        this.cIG.add(new b());
    }

    public static c akD() {
        if (cIF == null) {
            synchronized (c.class) {
                if (cIF == null) {
                    cIF = new c();
                }
            }
        }
        return cIF;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lx(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cIG.size()) {
                this.cIG.get(i2).lx(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void ly(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cIG.size()) {
                this.cIG.get(i2).ly(str);
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
        if (cIF != null) {
            cIF = null;
        }
    }
}
