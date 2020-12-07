package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dGx;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dGy = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dGz = new ArrayList<>();

    public static b aNE() {
        if (dGx == null) {
            synchronized (b.class) {
                if (dGx == null) {
                    dGx = new b();
                }
            }
        }
        return dGx;
    }

    public void lq(int i) {
        synchronized (b.class) {
            f(i, a.lk(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bt("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean lf = a.lf(i);
            c.bt("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + lf);
            if (!lf) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dGz;
            } else {
                arrayList = this.dGy;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bt("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.lk(i));
                        c.bt("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bt("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.dGy.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dGy.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.dGz.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dGz.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.ap.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.M(exc);
                }
            });
        }
    }
}
