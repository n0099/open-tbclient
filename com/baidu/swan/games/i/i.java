package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i dsE;
    private ArrayList<h> dsC = new ArrayList<>();
    private g dsD = new g();

    private i() {
    }

    public static i aNw() {
        if (dsE == null) {
            synchronized (i.class) {
                if (dsE == null) {
                    dsE = new i();
                }
            }
        }
        return dsE;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> y = this.dsD.y(strArr);
        this.dsD.a(hVar, strArr);
        if (y == null || y.size() == 0) {
            hVar.aNr();
        } else {
            a(hVar, y);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.dsD.b(hVar, hVar.aNs());
            if (hVar.aNt()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dsC.size());
                }
                for (int size = this.dsC.size() - 1; size >= 0; size--) {
                    h hVar2 = this.dsC.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aNv()) {
                        this.dsC.remove(size);
                        hVar2.aNr();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.dsD.aoj();
        Iterator<h> it = this.dsC.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aNq();
            }
        }
        this.dsC.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (dsE != null) {
                dsE.onDestroy();
                dsE = null;
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
        ArrayList<h> y = this.dsD.y(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dsC.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aNu();
            hVar.a(next);
        }
        this.dsC.add(hVar);
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
