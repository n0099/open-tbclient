package com.baidu.swan.apps.swancore.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b daD;
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> daE = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> daF = new ArrayList<>();

    public static b aEc() {
        if (daD == null) {
            synchronized (b.class) {
                if (daD == null) {
                    daD = new b();
                }
            }
        }
        return daD;
    }

    public void ke(int i) {
        synchronized (b.class) {
            f(i, a.jY(i));
        }
    }

    public void c(com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.ap.e.b<Exception>> arrayList;
        c.bb("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean jT = a.jT(i);
            c.bb("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + jT);
            if (!jT) {
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.daF;
            } else {
                arrayList = this.daE;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.bb("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        b.this.f(i, a.jY(i));
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
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.daE.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.daE.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it2 = this.daF.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.daF.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.ap.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.J(exc);
                }
            });
        }
    }
}
