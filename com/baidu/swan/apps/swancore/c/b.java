package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dPb;
    private ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dPc = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dPd = new ArrayList<>();

    public static b aPV() {
        if (dPb == null) {
            synchronized (b.class) {
                if (dPb == null) {
                    dPb = new b();
                }
            }
        }
        return dPb;
    }

    public void lv(int i) {
        synchronized (b.class) {
            f(i, a.lp(i));
        }
    }

    public void c(com.baidu.swan.apps.ao.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ao.e.b<Exception>> arrayList;
        c.bs("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean lk = a.lk(i);
            c.bs("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + lk);
            if (!lk) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dPd;
            } else {
                arrayList = this.dPc;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bs("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.lp(i));
                        c.bs("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bs("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.dPc.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dPc.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it2 = this.dPd.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dPd.clear();
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
