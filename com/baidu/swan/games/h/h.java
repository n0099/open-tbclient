package com.baidu.swan.games.h;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile h cjL;
    private ArrayList<g> cjJ = new ArrayList<>();
    private f cjK = new f();

    private h() {
    }

    public static h alB() {
        if (cjL == null) {
            synchronized (h.class) {
                if (cjL == null) {
                    cjL = new h();
                }
            }
        }
        return cjL;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        g gVar = new g(this, runnable, str, strArr);
        ArrayList<g> t = this.cjK.t(strArr);
        this.cjK.a(gVar, strArr);
        if (t == null || t.size() == 0) {
            gVar.alw();
        } else {
            a(gVar, t);
        }
    }

    public synchronized void c(g gVar) {
        if (gVar != null) {
            this.cjK.b(gVar, gVar.alx());
            if (gVar.aly()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cjJ.size());
                }
                for (int size = this.cjJ.size() - 1; size >= 0; size--) {
                    g gVar2 = this.cjJ.get(size);
                    gVar2.b(gVar);
                    if (gVar2.alA()) {
                        this.cjJ.remove(size);
                        gVar2.alw();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cjK.alu();
        Iterator<g> it = this.cjJ.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (d(next)) {
                next.alv();
            }
        }
        this.cjJ.clear();
    }

    public static synchronized void release() {
        synchronized (h.class) {
            if (cjL != null) {
                cjL.onDestroy();
                cjL = null;
            }
        }
    }

    public void u(String... strArr) {
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
        ArrayList<g> t = this.cjK.t(strArr);
        if (t == null || t.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), t);
            z = true;
        }
        return z;
    }

    private void a(@NonNull g gVar, @NonNull ArrayList<g> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cjJ.size());
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.alz();
            gVar.a(next);
        }
        this.cjJ.add(gVar);
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
