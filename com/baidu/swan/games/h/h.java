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
    private static volatile h cnQ;
    private ArrayList<g> cnO = new ArrayList<>();
    private f cnP = new f();

    private h() {
    }

    public static h anQ() {
        if (cnQ == null) {
            synchronized (h.class) {
                if (cnQ == null) {
                    cnQ = new h();
                }
            }
        }
        return cnQ;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        g gVar = new g(this, runnable, str, strArr);
        ArrayList<g> x = this.cnP.x(strArr);
        this.cnP.a(gVar, strArr);
        if (x == null || x.size() == 0) {
            gVar.anL();
        } else {
            a(gVar, x);
        }
    }

    public synchronized void c(g gVar) {
        if (gVar != null) {
            this.cnP.b(gVar, gVar.anM());
            if (gVar.anN()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnO.size());
                }
                for (int size = this.cnO.size() - 1; size >= 0; size--) {
                    g gVar2 = this.cnO.get(size);
                    gVar2.b(gVar);
                    if (gVar2.anP()) {
                        this.cnO.remove(size);
                        gVar2.anL();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cnP.anJ();
        Iterator<g> it = this.cnO.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (d(next)) {
                next.anK();
            }
        }
        this.cnO.clear();
    }

    public static synchronized void release() {
        synchronized (h.class) {
            if (cnQ != null) {
                cnQ.onDestroy();
                cnQ = null;
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
        ArrayList<g> x = this.cnP.x(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnO.size());
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.anO();
            gVar.a(next);
        }
        this.cnO.add(gVar);
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
