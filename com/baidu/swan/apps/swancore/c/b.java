package com.baidu.swan.apps.swancore.c;

import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b cHq;
    private ArrayList<com.baidu.swan.apps.aq.e.b<Exception>> cHr = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.aq.e.b<Exception>> cHs = new ArrayList<>();

    public static b asb() {
        if (cHq == null) {
            synchronized (b.class) {
                if (cHq == null) {
                    cHq = new b();
                }
            }
        }
        return cHq;
    }

    public void hr(int i) {
        synchronized (b.class) {
            f(i, a.hl(i));
        }
    }

    public void c(com.baidu.swan.apps.aq.e.b<Exception> bVar, final int i) {
        ArrayList<com.baidu.swan.apps.aq.e.b<Exception>> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.hh(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.cHs;
            } else {
                arrayList = this.cHr;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        b.this.f(i, a.hl(i));
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate end.");
                        }
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            if (DEBUG) {
                Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Exception exc) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.aq.e.b<Exception>> it = this.cHr.iterator();
                while (it.hasNext()) {
                    a(it.next(), exc);
                }
                this.cHr.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.aq.e.b<Exception>> it2 = this.cHs.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), exc);
                }
                this.cHs.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.aq.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.H(exc);
                }
            });
        }
    }
}
