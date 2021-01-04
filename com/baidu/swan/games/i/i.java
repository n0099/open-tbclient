package com.baidu.swan.games.i;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i ejn;
    private ArrayList<h> ejl = new ArrayList<>();
    private g ejm = new g();

    private i() {
    }

    public static i bab() {
        if (ejn == null) {
            synchronized (i.class) {
                if (ejn == null) {
                    ejn = new i();
                }
            }
        }
        return ejn;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> H = this.ejm.H(strArr);
        this.ejm.a(hVar, strArr);
        if (H == null || H.size() == 0) {
            hVar.aZW();
        } else {
            a(hVar, H);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.ejm.b(hVar, hVar.aZX());
            if (hVar.aZY()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.ejl.size());
                }
                for (int size = this.ejl.size() - 1; size >= 0; size--) {
                    h hVar2 = this.ejl.get(size);
                    hVar2.b(hVar);
                    if (hVar2.baa()) {
                        this.ejl.remove(size);
                        hVar2.aZW();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.ejm.azR();
        Iterator<h> it = this.ejl.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aZV();
            }
        }
        this.ejl.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (ejn != null) {
                ejn.onDestroy();
                ejn = null;
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
        ArrayList<h> H = this.ejm.H(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.ejl.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aZZ();
            hVar.a(next);
        }
        this.ejl.add(hVar);
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
