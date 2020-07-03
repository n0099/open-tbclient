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
    private static volatile i dcL;
    private ArrayList<h> dcJ = new ArrayList<>();
    private g dcK = new g();

    private i() {
    }

    public static i aBd() {
        if (dcL == null) {
            synchronized (i.class) {
                if (dcL == null) {
                    dcL = new i();
                }
            }
        }
        return dcL;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> x = this.dcK.x(strArr);
        this.dcK.a(hVar, strArr);
        if (x == null || x.size() == 0) {
            hVar.aAY();
        } else {
            a(hVar, x);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.dcK.b(hVar, hVar.aAZ());
            if (hVar.aBa()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dcJ.size());
                }
                for (int size = this.dcJ.size() - 1; size >= 0; size--) {
                    h hVar2 = this.dcJ.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aBc()) {
                        this.dcJ.remove(size);
                        hVar2.aAY();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.dcK.aAW();
        Iterator<h> it = this.dcJ.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aAX();
            }
        }
        this.dcJ.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (dcL != null) {
                dcL.onDestroy();
                dcL = null;
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
        ArrayList<h> x = this.dcK.x(strArr);
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
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dcJ.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aBb();
            hVar.a(next);
        }
        this.dcJ.add(hVar);
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
