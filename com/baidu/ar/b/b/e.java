package com.baidu.ar.b.b;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    a cM;
    Handler mHandler;
    HandlerThread mThread;
    private boolean cN = false;
    private volatile int cO = -100;
    List<d> cP = new ArrayList();
    Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        private a() {
        }

        private void execute() {
            d remove;
            while (!e.this.cN) {
                synchronized (e.this.mLock) {
                    if (e.this.cP.isEmpty()) {
                        e.this.mLock.wait();
                    }
                    remove = e.this.cP.remove(0);
                }
                if (remove != null) {
                    e.this.cO = remove.cK;
                    remove.run();
                    e.this.cO = -100;
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

    public boolean b(int i) {
        synchronized (this.mLock) {
            for (int size = this.cP.size() - 1; size >= 0; size--) {
                if (this.cP.get(size).cK == i) {
                    this.cP.remove(size);
                }
            }
        }
        return true;
    }

    public boolean b(d dVar) {
        if (dVar instanceof b) {
            synchronized (this.mLock) {
                this.cP.add(dVar);
                this.mLock.notifyAll();
            }
        } else {
            this.mHandler.post(dVar);
        }
        return true;
    }

    public boolean h(int i) {
        boolean z;
        if (i == this.cO) {
            return true;
        }
        synchronized (this.mLock) {
            Iterator<d> it = this.cP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().cK == i) {
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
        this.cM = new a();
        this.cM.start();
    }
}
