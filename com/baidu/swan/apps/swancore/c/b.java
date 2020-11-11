package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b dBf;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dBg = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> dBh = new ArrayList<>();

    public static b aLf() {
        if (dBf == null) {
            synchronized (b.class) {
                if (dBf == null) {
                    dBf = new b();
                }
            }
        }
        return dBf;
    }

    public void kW(int i) {
        synchronized (b.class) {
            f(i, a.kQ(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bn("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean kL = a.kL(i);
            c.bn("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + kL);
            if (!kL) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.dBh;
            } else {
                arrayList = this.dBg;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bn("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.kQ(i));
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
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.dBg.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.dBg.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.dBh.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.dBh.clear();
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
