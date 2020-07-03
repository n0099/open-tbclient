package com.baidu.ar.b.b;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    a cZ;
    Handler mHandler;
    HandlerThread mThread;
    private boolean da = false;
    private volatile int db = -100;
    List<d> dc = new ArrayList();
    Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        private a() {
        }

        private void execute() {
            d remove;
            while (!e.this.da) {
                synchronized (e.this.mLock) {
                    if (e.this.dc.isEmpty()) {
                        e.this.mLock.wait();
                    }
                    remove = e.this.dc.isEmpty() ? null : e.this.dc.remove(0);
                }
                if (remove != null) {
                    e.this.db = remove.cX;
                    remove.run();
                    e.this.db = -100;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean b(d dVar) {
        if (dVar instanceof b) {
            synchronized (this.mLock) {
                this.dc.add(dVar);
                this.mLock.notifyAll();
            }
        } else {
            this.mHandler.post(dVar);
        }
        return true;
    }

    public boolean c(int i) {
        synchronized (this.mLock) {
            for (int size = this.dc.size() - 1; size >= 0; size--) {
                if (this.dc.get(size).cX == i) {
                    this.dc.remove(size);
                }
            }
        }
        return true;
    }

    public boolean i(int i) {
        boolean z;
        if (i == this.db) {
            return true;
        }
        synchronized (this.mLock) {
            Iterator<d> it = this.dc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().cX == i) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void start() {
        this.mThread = new HandlerThread("MdlThreadPool");
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
        this.cZ = new a();
        this.cZ.start();
    }
}
