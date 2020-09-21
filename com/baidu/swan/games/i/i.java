package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i duK;
    private ArrayList<h> duI = new ArrayList<>();
    private g duJ = new g();

    private i() {
    }

    public static i aOh() {
        if (duK == null) {
            synchronized (i.class) {
                if (duK == null) {
                    duK = new i();
                }
            }
        }
        return duK;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> y = this.duJ.y(strArr);
        this.duJ.a(hVar, strArr);
        if (y == null || y.size() == 0) {
            hVar.aOc();
        } else {
            a(hVar, y);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.duJ.b(hVar, hVar.aOd());
            if (hVar.aOe()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.duI.size());
                }
                for (int size = this.duI.size() - 1; size >= 0; size--) {
                    h hVar2 = this.duI.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aOg()) {
                        this.duI.remove(size);
                        hVar2.aOc();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.duJ.aoT();
        Iterator<h> it = this.duI.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aOb();
            }
        }
        this.duI.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (duK != null) {
                duK.onDestroy();
                duK = null;
            }
        }
    }

    public void z(String... strArr) {
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
        ArrayList<h> y = this.duJ.y(strArr);
        if (y == null || y.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), y);
            z = true;
        }
        return z;
    }

    private void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.duI.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aOf();
            hVar.a(next);
        }
        this.duI.add(hVar);
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
