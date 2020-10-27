package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dvn;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dvo = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dvp = new ArrayList<>();

    public static b aIF() {
        if (dvn == null) {
            synchronized (b.class) {
                if (dvn == null) {
                    dvn = new b();
                }
            }
        }
        return dvn;
    }

    public void kM(int i) {
        synchronized (b.class) {
            f(i, a.kG(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bn("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean kB = a.kB(i);
            c.bn("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + kB);
            if (!kB) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dvp;
            } else {
                arrayList = this.dvo;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bn("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.kG(i));
                        c.bn("PresetSwanCoreUpdater", "onPresetUpdate end.");
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.bn("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.dvo.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dvo.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.dvp.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dvp.clear();
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
