package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cGg;
    private List<a> cGh = new ArrayList();

    private c() {
        this.cGh.add(new b());
    }

    public static c amO() {
        if (cGg == null) {
            synchronized (c.class) {
                if (cGg == null) {
                    cGg = new c();
                }
            }
        }
        return cGg;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void mx(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cGh.size()) {
                this.cGh.get(i2).mx(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void my(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cGh.size()) {
                this.cGh.get(i2).my(str);
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
        if (cGg != null) {
            cGg = null;
        }
    }
}
