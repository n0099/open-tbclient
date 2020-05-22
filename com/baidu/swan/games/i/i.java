package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i cXY;
    private ArrayList<h> cXW = new ArrayList<>();
    private g cXX = new g();

    private i() {
    }

    public static i azX() {
        if (cXY == null) {
            synchronized (i.class) {
                if (cXY == null) {
                    cXY = new i();
                }
            }
        }
        return cXY;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> y = this.cXX.y(strArr);
        this.cXX.a(hVar, strArr);
        if (y == null || y.size() == 0) {
            hVar.azS();
        } else {
            a(hVar, y);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.cXX.b(hVar, hVar.azT());
            if (hVar.azU()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cXW.size());
                }
                for (int size = this.cXW.size() - 1; size >= 0; size--) {
                    h hVar2 = this.cXW.get(size);
                    hVar2.b(hVar);
                    if (hVar2.azW()) {
                        this.cXW.remove(size);
                        hVar2.azS();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.cXX.azQ();
        Iterator<h> it = this.cXW.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.azR();
            }
        }
        this.cXW.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (cXY != null) {
                cXY.onDestroy();
                cXY = null;
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
        ArrayList<h> y = this.cXX.y(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cXW.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.azV();
            hVar.a(next);
        }
        this.cXW.add(hVar);
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
