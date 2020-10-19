package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile i dGL;
    private ArrayList<h> dGJ = new ArrayList<>();
    private g dGK = new g();

    private i() {
    }

    public static i aQQ() {
        if (dGL == null) {
            synchronized (i.class) {
                if (dGL == null) {
                    dGL = new i();
                }
            }
        }
        return dGL;
    }

    public synchronized void a(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> z = this.dGK.z(strArr);
        this.dGK.a(hVar, strArr);
        if (z == null || z.size() == 0) {
            hVar.aQL();
        } else {
            a(hVar, z);
        }
    }

    public synchronized void c(h hVar) {
        if (hVar != null) {
            this.dGK.b(hVar, hVar.aQM());
            if (hVar.aQN()) {
                if (DEBUG) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dGJ.size());
                }
                for (int size = this.dGJ.size() - 1; size >= 0; size--) {
                    h hVar2 = this.dGJ.get(size);
                    hVar2.b(hVar);
                    if (hVar2.aQP()) {
                        this.dGJ.remove(size);
                        hVar2.aQL();
                    }
                }
            }
        }
    }

    private synchronized void onDestroy() {
        this.dGK.arF();
        Iterator<h> it = this.dGJ.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (d(next)) {
                next.aQK();
            }
        }
        this.dGJ.clear();
    }

    public static synchronized void release() {
        synchronized (i.class) {
            if (dGL != null) {
                dGL.onDestroy();
                dGL = null;
            }
        }
    }

    public void A(String... strArr) {
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
        ArrayList<h> z2 = this.dGK.z(strArr);
        if (z2 == null || z2.size() == 0) {
            z = false;
        } else {
            a(b(semaphore), z2);
            z = true;
        }
        return z;
    }

    private void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (DEBUG) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + Constants.ACCEPT_TIME_SEPARATOR_SP + arrayList.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dGJ.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.aQO();
            hVar.a(next);
        }
        this.dGJ.add(hVar);
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
