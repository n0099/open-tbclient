package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dMt;
    private ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dMu = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dMv = new ArrayList<>();

    public static b aMu() {
        if (dMt == null) {
            synchronized (b.class) {
                if (dMt == null) {
                    dMt = new b();
                }
            }
        }
        return dMt;
    }

    public void jS(int i) {
        synchronized (b.class) {
            f(i, a.jM(i));
        }
    }

    public void c(com.baidu.swan.apps.ao.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> arrayList;
        c.bl("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean jH = a.jH(i);
            c.bl("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + jH);
            if (!jH) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dMv;
            } else {
                arrayList = this.dMu;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bl("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.jM(i));
                        c.bl("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bl("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.dMu.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dMu.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it2 = this.dMv.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dMv.clear();
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
