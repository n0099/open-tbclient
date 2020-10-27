package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cvf;
    private List<a> cvg = new ArrayList();

    private c() {
        this.cvg.add(new b());
    }

    public static c ahO() {
        if (cvf == null) {
            synchronized (c.class) {
                if (cvf == null) {
                    cvf = new c();
                }
            }
        }
        return cvf;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lH(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cvg.size()) {
                this.cvg.get(i2).lH(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lI(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cvg.size()) {
                this.cvg.get(i2).lI(str);
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
        if (cvf != null) {
            cvf = null;
        }
    }
}
