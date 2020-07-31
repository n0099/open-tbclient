package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i diw;
    private ArrayList<h> diu = new ArrayList<>();
    private g div = new g();

    private i() {
    }

    public static i aEI() {
        if (diw == null) {
            synchronized (i.class) {
                if (diw == null) {
                    diw = new i();
                }
            }
        }
        return diw;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> x = this.div.x(strArr);
        this.div.a(hVar, strArr);
        if (x == null || x.size() == 0) {
            hVar.aED();
        } else {
            a(hVar, x);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.div.b(hVar, hVar.aEE());
            if (hVar.aEF()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.diu.size());
                }
                for (int size = this.diu.size() - 1; size >= 0; size--) {
                    h hVar2 = this.diu.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aEH()) {
                        this.diu.remove(size);
                        hVar2.aED();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.div.aEB();
        Iterator<h> it = this.diu.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aEC();
            }
        }
        this.diu.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (diw != null) {
                diw.onDestroy();
                diw = null;
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
        ArrayList<h> x = this.div.x(strArr);
        if (x == null || x.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), x);
            z = true;
        }
        return z;
    }

    private void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.diu.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aEG();
            hVar.a(next);
        }
        this.diu.add(hVar);
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
