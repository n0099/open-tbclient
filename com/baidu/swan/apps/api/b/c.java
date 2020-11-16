package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c czo;
    private List<a> czp = new ArrayList();

    private c() {
        this.czp.add(new b());
    }

    public static c ajG() {
        if (czo == null) {
            synchronized (c.class) {
                if (czo == null) {
                    czo = new c();
                }
            }
        }
        return czo;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lQ(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.czp.size()) {
                this.czp.get(i2).lQ(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lR(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.czp.size()) {
                this.czp.get(i2).lR(str);
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
        if (czo != null) {
            czo = null;
        }
    }
}
