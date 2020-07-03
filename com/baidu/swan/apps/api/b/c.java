package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bRG;
    private List<a> bRH = new ArrayList();

    private c() {
        this.bRH.add(new b());
    }

    public static c VM() {
        if (bRG == null) {
            synchronized (c.class) {
                if (bRG == null) {
                    bRG = new c();
                }
            }
        }
        return bRG;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void iy(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bRH.size()) {
                this.bRH.get(i2).iy(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void iz(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bRH.size()) {
                this.bRH.get(i2).iz(str);
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
        if (bRG != null) {
            bRG = null;
        }
    }
}
