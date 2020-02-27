package com.baidu.swan.games.h;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile h cnP;
    private ArrayList<g> cnN = new ArrayList<>();
    private f cnO = new f();

    private h() {
    }

    public static h anO() {
        if (cnP == null) {
            synchronized (h.class) {
                if (cnP == null) {
                    cnP = new h();
                }
            }
        }
        return cnP;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        g gVar = new g(this, runnable, str, strArr);
        ArrayList<g> x = this.cnO.x(strArr);
        this.cnO.a(gVar, strArr);
        if (x == null || x.size() == 0) {
            gVar.anJ();
        } else {
            a(gVar, x);
        }
    }

    public synchronized void c(g gVar) {
        if (gVar != null) {
            this.cnO.b(gVar, gVar.anK());
            if (gVar.anL()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnN.size());
                }
                for (int size = this.cnN.size() - 1; size >= 0; size--) {
                    g gVar2 = this.cnN.get(size);
                    gVar2.b(gVar);
                    if (gVar2.anN()) {
                        this.cnN.remove(size);
                        gVar2.anJ();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cnO.anH();
        Iterator<g> it = this.cnN.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (d(next)) {
                next.anI();
            }
        }
        this.cnN.clear();
    }

    public static synchronized void release() {
        synchronized (h.class) {
            if (cnP != null) {
                cnP.onDestroy();
                cnP = null;
            }
        }
    }

    public void y(String... strArr) {
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
        ArrayList<g> x = this.cnO.x(strArr);
        if (x == null || x.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), x);
            z = true;
        }
        return z;
    }

    private void a(@NonNull g gVar, @NonNull ArrayList<g> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnN.size());
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.anM();
            gVar.a(next);
        }
        this.cnN.add(gVar);
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

    private g b(@NonNull final Semaphore semaphore) {
        return new g(this, new Runnable() { // from class: com.baidu.swan.games.h.h.1
            @Override // java.lang.Runnable
            public void run() {
                semaphore.release();
            }
        }, "JS_WAKE_UP_TASK", null);
    }

    private boolean d(g gVar) {
        return gVar != null && "JS_WAKE_UP_TASK".equals(gVar.getTag());
    }
}
