package com.baidu.b.a.f.d.a;

import android.util.Log;
import com.baidu.b.a.f.d.f;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes2.dex */
public class b implements a {
    private Object lock = new Object();
    private Vector<a> aat = new Vector<>();

    public b(a aVar) {
        e(aVar);
    }

    public void e(a aVar) {
        if (aVar != null) {
            synchronized (this.lock) {
                this.aat.add(aVar);
            }
        }
    }

    public void f(a aVar) {
        if (aVar != null) {
            synchronized (this.lock) {
                if (!this.aat.remove(aVar)) {
                    this.aat.remove(this.aat.indexOf(aVar));
                }
            }
        }
    }

    @Override // com.baidu.b.a.f.d.a.a
    public void a(f fVar) {
        try {
            synchronized (this.lock) {
                Iterator<a> it = this.aat.iterator();
                while (it.hasNext()) {
                    it.next().a(fVar);
                }
            }
        } catch (Throwable th) {
            if (com.baidu.b.a.h.b.isDebug()) {
                Log.w("RuntimeTaskObserver", "notifyTaskRunning error:" + th.toString());
            }
        }
    }

    @Override // com.baidu.b.a.f.d.a.a
    public void b(f fVar) {
        Vector vector = new Vector();
        try {
            synchronized (this.lock) {
                Iterator<a> it = this.aat.iterator();
                while (it.hasNext()) {
                    vector.add(it.next());
                }
            }
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).b(fVar);
            }
        } catch (Throwable th) {
            if (com.baidu.b.a.h.b.isDebug()) {
                Log.w("RuntimeTaskObserver", "notifyTaskEnd error:" + th.toString());
            }
        }
    }
}
