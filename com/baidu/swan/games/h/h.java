package com.baidu.swan.games.h;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile h cjy;
    private ArrayList<g> cjw = new ArrayList<>();
    private f cjx = new f();

    private h() {
    }

    public static h ali() {
        if (cjy == null) {
            synchronized (h.class) {
                if (cjy == null) {
                    cjy = new h();
                }
            }
        }
        return cjy;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        g gVar = new g(this, runnable, str, strArr);
        ArrayList<g> t = this.cjx.t(strArr);
        this.cjx.a(gVar, strArr);
        if (t == null || t.size() == 0) {
            gVar.ald();
        } else {
            a(gVar, t);
        }
    }

    public synchronized void c(g gVar) {
        if (gVar != null) {
            this.cjx.b(gVar, gVar.ale());
            if (gVar.alf()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cjw.size());
                }
                for (int size = this.cjw.size() - 1; size >= 0; size--) {
                    g gVar2 = this.cjw.get(size);
                    gVar2.b(gVar);
                    if (gVar2.alh()) {
                        this.cjw.remove(size);
                        gVar2.ald();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cjx.alb();
        Iterator<g> it = this.cjw.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (d(next)) {
                next.alc();
            }
        }
        this.cjw.clear();
    }

    public static synchronized void release() {
        synchronized (h.class) {
            if (cjy != null) {
                cjy.onDestroy();
                cjy = null;
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
        ArrayList<g> t = this.cjx.t(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cjw.size());
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.alg();
            gVar.a(next);
        }
        this.cjw.add(gVar);
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
