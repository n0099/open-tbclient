package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dmL;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dmM = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dmN = new ArrayList<>();

    public static b aGL() {
        if (dmL == null) {
            synchronized (b.class) {
                if (dmL == null) {
                    dmL = new b();
                }
            }
        }
        return dmL;
    }

    public void kB(int i) {
        synchronized (b.class) {
            f(i, a.kv(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bg("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean kq = a.kq(i);
            c.bg("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + kq);
            if (!kq) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dmN;
            } else {
                arrayList = this.dmM;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bg("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.kv(i));
                        c.bg("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bg("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.dmM.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dmM.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.dmN.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dmN.clear();
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
