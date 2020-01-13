package com.baidu.swan.apps.swancore.d;

import android.util.Log;
import com.baidu.swan.apps.as.ai;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b bSa;
    private ArrayList<com.baidu.swan.apps.swancore.a.a> bSb = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.swancore.a.a> bSc = new ArrayList<>();

    public static b adn() {
        if (bSa == null) {
            synchronized (b.class) {
                if (bSa == null) {
                    bSa = new b();
                }
            }
        }
        return bSa;
    }

    public void gx(int i) {
        synchronized (b.class) {
            a.gr(i);
            gy(i);
        }
    }

    public void a(com.baidu.swan.apps.swancore.a.a aVar, final int i) {
        ArrayList<com.baidu.swan.apps.swancore.a.a> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.gn(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(aVar);
                return;
            }
            if (i == 1) {
                arrayList = this.bSc;
            } else {
                arrayList = this.bSb;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        a.gr(i);
                        b.this.gy(i);
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
    public void gy(int i) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it = this.bSb.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.bSb.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it2 = this.bSc.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                this.bSc.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.swancore.a.a aVar) {
        if (aVar != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.Ps();
                }
            });
        }
    }
}
