package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dKp;
    private ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dKq = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dKr = new ArrayList<>();

    public static b aMb() {
        if (dKp == null) {
            synchronized (b.class) {
                if (dKp == null) {
                    dKp = new b();
                }
            }
        }
        return dKp;
    }

    public void jP(int i) {
        synchronized (b.class) {
            f(i, a.jJ(i));
        }
    }

    public void c(com.baidu.swan.apps.ao.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> arrayList;
        c.br("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean jE = a.jE(i);
            c.br("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + jE);
            if (!jE) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dKr;
            } else {
                arrayList = this.dKq;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.br("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.jJ(i));
                        c.br("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.br("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.dKq.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dKq.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it2 = this.dKr.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dKr.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.ao.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.L(exc);
                }
            });
        }
    }
}
