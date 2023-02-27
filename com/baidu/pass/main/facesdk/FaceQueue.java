package com.baidu.pass.main.facesdk;

import java.util.LinkedList;
/* loaded from: classes2.dex */
public class FaceQueue {
    public int nThreads;
    public LinkedList queue;
    public PoolWorker[] threads;

    /* loaded from: classes2.dex */
    public static class HolderClass {
        public static final FaceQueue instance = new FaceQueue(1);
    }

    /* loaded from: classes2.dex */
    public class PoolWorker extends Thread {
        public PoolWorker() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Runnable runnable;
            while (true) {
                synchronized (FaceQueue.this.queue) {
                    while (FaceQueue.this.queue.isEmpty()) {
                        try {
                            FaceQueue.this.queue.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    runnable = (Runnable) FaceQueue.this.queue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FaceQueue(int i) {
        this.queue = null;
        this.nThreads = i;
        this.queue = new LinkedList();
        this.threads = new PoolWorker[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.threads[i2] = new PoolWorker();
            this.threads[i2].start();
        }
    }

    public static FaceQueue getInstance() {
        return HolderClass.instance;
    }

    public void execute(Runnable runnable) {
        synchronized (this.queue) {
            this.queue.addLast(runnable);
            this.queue.notify();
        }
    }
}
