package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dzy;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dzz = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dzA = new ArrayList<>();

    public static b aKx() {
        if (dzy == null) {
            synchronized (b.class) {
                if (dzy == null) {
                    dzy = new b();
                }
            }
        }
        return dzy;
    }

    public void kS(int i) {
        synchronized (b.class) {
            f(i, a.kM(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bm("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean kH = a.kH(i);
            c.bm("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + kH);
            if (!kH) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dzA;
            } else {
                arrayList = this.dzz;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bm("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.kM(i));
                        c.bm("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bm("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.dzz.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dzz.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.dzA.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dzA.clear();
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
