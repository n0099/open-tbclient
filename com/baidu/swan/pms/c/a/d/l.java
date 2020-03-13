package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes11.dex */
public class l implements b {
    private Object lock = new Object();
    private Vector<b> cBP = new Vector<>();

    public l(b bVar) {
        e(bVar);
    }

    public void e(b bVar) {
        if (bVar != null) {
            synchronized (this.lock) {
                this.cBP.add(bVar);
            }
        }
    }

    public void f(b bVar) {
        if (bVar != null) {
            synchronized (this.lock) {
                if (!this.cBP.remove(bVar)) {
                    this.cBP.remove(this.cBP.indexOf(bVar));
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
        try {
            synchronized (this.lock) {
                Iterator<b> it = this.cBP.iterator();
                while (it.hasNext()) {
                    it.next().d(fVar);
                }
            }
        } catch (Throwable th) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.w("RuntimeTaskObserver", "notifyTaskRunning error:" + th.toString());
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        Vector vector = new Vector();
        try {
            synchronized (this.lock) {
                Iterator<b> it = this.cBP.iterator();
                while (it.hasNext()) {
                    vector.add(it.next());
                }
            }
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).e(fVar);
            }
        } catch (Throwable th) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.w("RuntimeTaskObserver", "notifyTaskEnd error:" + th.toString());
            }
        }
    }
}
