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
    private static volatile h cnR;
    private ArrayList<g> cnP = new ArrayList<>();
    private f cnQ = new f();

    private h() {
    }

    public static h anQ() {
        if (cnR == null) {
            synchronized (h.class) {
                if (cnR == null) {
                    cnR = new h();
                }
            }
        }
        return cnR;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        g gVar = new g(this, runnable, str, strArr);
        ArrayList<g> x = this.cnQ.x(strArr);
        this.cnQ.a(gVar, strArr);
        if (x == null || x.size() == 0) {
            gVar.anL();
        } else {
            a(gVar, x);
        }
    }

    public synchronized void c(g gVar) {
        if (gVar != null) {
            this.cnQ.b(gVar, gVar.anM());
            if (gVar.anN()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnP.size());
                }
                for (int size = this.cnP.size() - 1; size >= 0; size--) {
                    g gVar2 = this.cnP.get(size);
                    gVar2.b(gVar);
                    if (gVar2.anP()) {
                        this.cnP.remove(size);
                        gVar2.anL();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cnQ.anJ();
        Iterator<g> it = this.cnP.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (d(next)) {
                next.anK();
            }
        }
        this.cnP.clear();
    }

    public static synchronized void release() {
        synchronized (h.class) {
            if (cnR != null) {
                cnR.onDestroy();
                cnR = null;
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
        ArrayList<g> x = this.cnQ.x(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnP.size());
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.anO();
            gVar.a(next);
        }
        this.cnP.add(gVar);
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
