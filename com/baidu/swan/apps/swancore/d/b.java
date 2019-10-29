package com.baidu.swan.apps.swancore.d;

import android.util.Log;
import com.baidu.swan.apps.an.ac;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b bqp;
    private ArrayList<com.baidu.swan.apps.swancore.a.a> bqq = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.swancore.a.a> bqr = new ArrayList<>();

    public static b Tc() {
        if (bqp == null) {
            synchronized (b.class) {
                if (bqp == null) {
                    bqp = new b();
                }
            }
        }
        return bqp;
    }

    public void fh(int i) {
        synchronized (b.class) {
            a.fb(i);
            fi(i);
        }
    }

    public void a(com.baidu.swan.apps.swancore.a.a aVar, final int i) {
        ArrayList<com.baidu.swan.apps.swancore.a.a> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.eX(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(aVar);
                return;
            }
            if (i == 1) {
                arrayList = this.bqr;
            } else {
                arrayList = this.bqq;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        a.fb(i);
                        b.this.fi(i);
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate end.");
                        }
                    }
                }, "updateSwanCoreAsync").start();
            }
            arrayList.add(aVar);
            if (DEBUG) {
                Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(int i) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it = this.bqq.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.bqq.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it2 = this.bqr.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                this.bqr.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.swancore.a.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.AT();
                }
            });
        }
    }
}
