package com.baidu.swan.apps.swancore.d;

import android.util.Log;
import com.baidu.swan.apps.an.ac;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b aWN;
    private ArrayList<com.baidu.swan.apps.swancore.a.a> aWO = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.swancore.a.a> aWP = new ArrayList<>();

    public static b Oi() {
        if (aWN == null) {
            synchronized (b.class) {
                if (aWN == null) {
                    aWN = new b();
                }
            }
        }
        return aWN;
    }

    public void el(int i) {
        synchronized (b.class) {
            a.ef(i);
            em(i);
        }
    }

    public void a(com.baidu.swan.apps.swancore.a.a aVar, final int i) {
        ArrayList<com.baidu.swan.apps.swancore.a.a> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.eb(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(aVar);
                return;
            }
            if (i == 1) {
                arrayList = this.aWP;
            } else {
                arrayList = this.aWO;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        a.ef(i);
                        b.this.em(i);
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
    public void em(int i) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it = this.aWO.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.aWO.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it2 = this.aWP.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                this.aWP.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.swancore.a.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.vV();
                }
            });
        }
    }
}
