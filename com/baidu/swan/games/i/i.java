package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes25.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i eaq;
    private ArrayList<h> eao = new ArrayList<>();
    private g eap = new g();

    private i() {
    }

    public static i aXH() {
        if (eaq == null) {
            synchronized (i.class) {
                if (eaq == null) {
                    eaq = new i();
                }
            }
        }
        return eaq;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> A = this.eap.A(strArr);
        this.eap.a(hVar, strArr);
        if (A == null || A.size() == 0) {
            hVar.aXC();
        } else {
            a(hVar, A);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.eap.b(hVar, hVar.aXD());
            if (hVar.aXE()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.eao.size());
                }
                for (int size = this.eao.size() - 1; size >= 0; size--) {
                    h hVar2 = this.eao.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aXG()) {
                        this.eao.remove(size);
                        hVar2.aXC();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.eap.ayA();
        Iterator<h> it = this.eao.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aXB();
            }
        }
        this.eao.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (eaq != null) {
                eaq.onDestroy();
                eaq = null;
            }
        }
    }

    public void B(String... strArr) {
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
        ArrayList<h> A = this.eap.A(strArr);
        if (A == null || A.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), A);
            z = true;
        }
        return z;
    }

    private void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.eao.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aXF();
            hVar.a(next);
        }
        this.eao.add(hVar);
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
