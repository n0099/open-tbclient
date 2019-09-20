package com.baidu.swan.apps.swancore.d;

import android.util.Log;
import com.baidu.swan.apps.an.ac;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b aXl;
    private ArrayList<com.baidu.swan.apps.swancore.a.a> aXm = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.swancore.a.a> aXn = new ArrayList<>();

    public static b Om() {
        if (aXl == null) {
            synchronized (b.class) {
                if (aXl == null) {
                    aXl = new b();
                }
            }
        }
        return aXl;
    }

    public void em(int i) {
        synchronized (b.class) {
            a.eg(i);
            en(i);
        }
    }

    public void a(com.baidu.swan.apps.swancore.a.a aVar, final int i) {
        ArrayList<com.baidu.swan.apps.swancore.a.a> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.ec(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(aVar);
                return;
            }
            if (i == 1) {
                arrayList = this.aXn;
            } else {
                arrayList = this.aXm;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        a.eg(i);
                        b.this.en(i);
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
    public void en(int i) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it = this.aXm.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.aXm.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it2 = this.aXn.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                this.aXn.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.swancore.a.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.vZ();
                }
            });
        }
    }
}
