package com.baidu.swan.apps.api.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cal;
    private List<a> cam = new ArrayList();

    private c() {
        this.cam.add(new b());
    }

    public static c adi() {
        if (cal == null) {
            synchronized (c.class) {
                if (cal == null) {
                    cal = new c();
                }
            }
        }
        return cal;
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void kC(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cam.size()) {
                this.cam.get(i2).kC(str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void kD(String str) {
        if (DEBUG) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cam.size()) {
                this.cam.get(i2).kD(str);
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
        if (cal != null) {
            cal = null;
        }
    }
}
