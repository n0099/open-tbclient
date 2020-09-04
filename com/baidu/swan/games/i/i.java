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
    private static volatile i dsI;
    private ArrayList<h> dsG = new ArrayList<>();
    private g dsH = new g();

    private i() {
    }

    public static i aNw() {
        if (dsI == null) {
            synchronized (i.class) {
                if (dsI == null) {
                    dsI = new i();
                }
            }
        }
        return dsI;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> y = this.dsH.y(strArr);
        this.dsH.a(hVar, strArr);
        if (y == null || y.size() == 0) {
            hVar.aNr();
        } else {
            a(hVar, y);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.dsH.b(hVar, hVar.aNs());
            if (hVar.aNt()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dsG.size());
                }
                for (int size = this.dsG.size() - 1; size >= 0; size--) {
                    h hVar2 = this.dsG.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aNv()) {
                        this.dsG.remove(size);
                        hVar2.aNr();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.dsH.aoj();
        Iterator<h> it = this.dsG.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aNq();
            }
        }
        this.dsG.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (dsI != null) {
                dsI.onDestroy();
                dsI = null;
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
        ArrayList<h> y = this.dsH.y(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dsG.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aNu();
            hVar.a(next);
        }
        this.dsG.add(hVar);
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
