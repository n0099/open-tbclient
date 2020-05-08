package com.baidu.swan.apps.swancore.d;

import android.util.Log;
import com.baidu.swan.apps.as.ai;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile b cvo;
    private ArrayList<com.baidu.swan.apps.swancore.a.a> cvp = new ArrayList<>();
    private ArrayList<com.baidu.swan.apps.swancore.a.a> cvq = new ArrayList<>();

    public static b anK() {
        if (cvo == null) {
            synchronized (b.class) {
                if (cvo == null) {
                    cvo = new b();
                }
            }
        }
        return cvo;
    }

    public void gV(int i) {
        synchronized (b.class) {
            a.gP(i);
            gW(i);
        }
    }

    public void a(com.baidu.swan.apps.swancore.a.a aVar, final int i) {
        ArrayList<com.baidu.swan.apps.swancore.a.a> arrayList;
        if (DEBUG) {
            Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        }
        synchronized (b.class) {
            if (!a.gL(i)) {
                if (DEBUG) {
                    Log.d("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = false.");
                }
                a(aVar);
                return;
            }
            if (i == 1) {
                arrayList = this.cvq;
            } else {
                arrayList = this.cvp;
            }
            if (arrayList.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.DEBUG) {
                            Log.d("PresetSwanCoreUpdater", "onPresetUpdate start.");
                        }
                        a.gP(i);
                        b.this.gW(i);
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
    public void gW(int i) {
        synchronized (b.class) {
            if (i == 0) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it = this.cvp.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.cvp.clear();
            } else if (i == 1) {
                Iterator<com.baidu.swan.apps.swancore.a.a> it2 = this.cvq.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                this.cvq.clear();
            }
        }
    }

    private void a(final com.baidu.swan.apps.swancore.a.a aVar) {
        if (aVar != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.Zz();
                }
            });
        }
    }
}
