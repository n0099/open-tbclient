package com.baidu.swan.apps.swancore.d;

import android.util.Log;
import com.baidu.swan.apps.an.aa;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b aTk;
    private ArrayList<com.baidu.swan.apps.swancore.a.a> aTl = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.swancore.a.a> aTm = new ArrayList<>();

    public static b KW() {
        if (aTk == null) {
            synchronized (b.class) {
                if (aTk == null) {
                    aTk = new b();
                }
            }
        }
        return aTk;
    }

    public void dY(int i) {
        synchronized (b.class) {
            a.dS(i);
            dZ(i);
        }
    }

    public void a(com.baidu.swan.apps.swancore.a.a aVar, final int i) {
        ArrayList<com.baidu.swan.apps.swancore.a.a> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.dO(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(aVar);
                return;
            }
            if (i == 1) {
                arrayList = this.aTm;
            } else {
                arrayList = this.aTl;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        a.dS(i);
                        b.this.dZ(i);
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
    public void dZ(int i) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it = this.aTl.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.aTl.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it2 = this.aTm.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                this.aTm.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.swancore.a.a aVar) {
        if (aVar != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.uL();
                }
            });
        }
    }
}
