package com.baidu.swan.games.i;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i eij;
    private ArrayList<h> eih = new ArrayList<>();
    private g eii = new g();

    private i() {
    }

    public static i aWx() {
        if (eij == null) {
            synchronized (i.class) {
                if (eij == null) {
                    eij = new i();
                }
            }
        }
        return eij;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> H = this.eii.H(strArr);
        this.eii.a(hVar, strArr);
        if (H == null || H.size() == 0) {
            hVar.aWs();
        } else {
            a(hVar, H);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.eii.b(hVar, hVar.aWt());
            if (hVar.aWu()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.eih.size());
                }
                for (int size = this.eih.size() - 1; size >= 0; size--) {
                    h hVar2 = this.eih.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aWw()) {
                        this.eih.remove(size);
                        hVar2.aWs();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.eii.awz();
        Iterator<h> it = this.eih.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aWr();
            }
        }
        this.eih.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (eij != null) {
                eij.onDestroy();
                eij = null;
            }
        }
    }

    public void I(String... strArr) {
        Semaphore semaphore = new Semaphore(0);
        if (a(semaphore, strArr)) {
            if (DEBUG) {
                Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
            }
            a(semaphore);
        }
    }

    private synchronized boolean a(Semaphore semaphore, String... strArr) {
        boolean z;
        ArrayList<h> H = this.eii.H(strArr);
        if (H == null || H.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), H);
            z = true;
        }
        return z;
    }

    private void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.eih.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aWv();
            hVar.a(next);
        }
        this.eih.add(hVar);
    }

    private void a(Semaphore semaphore) {
        try {
            semaphore.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("FileSystemTaskManager", "semaphore.acquire: " + e);
            }
        }
    }

    private h b(@NonNull final Semaphore semaphore) {
        return new h(this, new Runnable() { // from class: com.baidu.swan.games.i.i.1
            @Override // java.lang.Runnable
            public void run() {
                semaphore.release();
            }
        }, "JS_WAKE_UP_TASK", null);
    }

    private boolean d(h hVar) {
        return hVar != null && "JS_WAKE_UP_TASK".equals(hVar.getTag());
    }
}
