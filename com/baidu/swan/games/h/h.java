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
    private static volatile h coc;
    private ArrayList<g> coa = new ArrayList<>();
    private f cob = new f();

    private h() {
    }

    public static h anT() {
        if (coc == null) {
            synchronized (h.class) {
                if (coc == null) {
                    coc = new h();
                }
            }
        }
        return coc;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        g gVar = new g(this, runnable, str, strArr);
        ArrayList<g> x = this.cob.x(strArr);
        this.cob.a(gVar, strArr);
        if (x == null || x.size() == 0) {
            gVar.anO();
        } else {
            a(gVar, x);
        }
    }

    public synchronized void c(g gVar) {
        if (gVar != null) {
            this.cob.b(gVar, gVar.anP());
            if (gVar.anQ()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.coa.size());
                }
                for (int size = this.coa.size() - 1; size >= 0; size--) {
                    g gVar2 = this.coa.get(size);
                    gVar2.b(gVar);
                    if (gVar2.anS()) {
                        this.coa.remove(size);
                        gVar2.anO();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cob.anM();
        Iterator<g> it = this.coa.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (d(next)) {
                next.anN();
            }
        }
        this.coa.clear();
    }

    public static synchronized void release() {
        synchronized (h.class) {
            if (coc != null) {
                coc.onDestroy();
                coc = null;
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
        ArrayList<g> x = this.cob.x(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + gVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.coa.size());
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.anR();
            gVar.a(next);
        }
        this.coa.add(gVar);
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
