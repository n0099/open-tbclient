package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i dPi;
    private ArrayList<h> dPg = new ArrayList<>();
    private g dPh = new g();

    private i() {
    }

    public static i aSK() {
        if (dPi == null) {
            synchronized (i.class) {
                if (dPi == null) {
                    dPi = new i();
                }
            }
        }
        return dPi;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> A = this.dPh.A(strArr);
        this.dPh.a(hVar, strArr);
        if (A == null || A.size() == 0) {
            hVar.aSF();
        } else {
            a(hVar, A);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.dPh.b(hVar, hVar.aSG());
            if (hVar.aSH()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dPg.size());
                }
                for (int size = this.dPg.size() - 1; size >= 0; size--) {
                    h hVar2 = this.dPg.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aSJ()) {
                        this.dPg.remove(size);
                        hVar2.aSF();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.dPh.atA();
        Iterator<h> it = this.dPg.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aSE();
            }
        }
        this.dPg.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (dPi != null) {
                dPi.onDestroy();
                dPi = null;
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
        ArrayList<h> A = this.dPh.A(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dPg.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aSI();
            hVar.a(next);
        }
        this.dPg.add(hVar);
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
