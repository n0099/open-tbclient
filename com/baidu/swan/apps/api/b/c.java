package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cGk;
    private List<a> cGl = new ArrayList();

    private c() {
        this.cGl.add(new b());
    }

    public static c akf() {
        if (cGk == null) {
            synchronized (c.class) {
                if (cGk == null) {
                    cGk = new c();
                }
            }
        }
        return cGk;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lf(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cGl.size()) {
                this.cGl.get(i2).lf(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lg(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cGl.size()) {
                this.cGl.get(i2).lg(str);
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
        if (cGk != null) {
            cGk = null;
        }
    }
}
