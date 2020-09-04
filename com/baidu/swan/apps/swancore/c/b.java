package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b cYB;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> cYC = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> cYD = new ArrayList<>();

    public static b aDs() {
        if (cYB == null) {
            synchronized (b.class) {
                if (cYB == null) {
                    cYB = new b();
                }
            }
        }
        return cYB;
    }

    public void jT(int i) {
        synchronized (b.class) {
            f(i, a.jN(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bb("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean jI = a.jI(i);
            c.bb("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + jI);
            if (!jI) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.cYD;
            } else {
                arrayList = this.cYC;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bb("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.jN(i));
                        c.bb("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bb("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.cYC.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.cYC.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.cYD.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.cYD.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.ap.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.I(exc);
                }
            });
        }
    }
}
