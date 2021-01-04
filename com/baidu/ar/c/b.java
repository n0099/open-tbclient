package com.baidu.ar.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class b {
    private int is = 1500;
    private final ReentrantLock it = new ReentrantLock();
    private Map<String, a> iu = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        final Thread iv;
        com.baidu.ar.c.a iw;
        BlockingQueue<com.baidu.ar.c.a> ix;
        String tag;

        a(String str, com.baidu.ar.c.a aVar) {
            this.iw = aVar;
            this.iv = new Thread(this);
            this.ix = new ArrayBlockingQueue(10);
            this.tag = str;
        }

        a(String str, BlockingQueue<com.baidu.ar.c.a> blockingQueue) {
            this.iv = new Thread(this);
            this.ix = blockingQueue;
            this.tag = str;
        }

        private void cc() {
            b.this.it.lock();
            try {
                b.this.iu.remove(this.tag);
                if (this.ix.size() > 0) {
                    a aVar = new a(this.tag, this.ix);
                    b.this.iu.put(this.tag, aVar);
                    aVar.iv.start();
                }
            } finally {
                b.this.it.unlock();
            }
        }

        public boolean b(com.baidu.ar.c.a aVar) {
            return this.ix.offer(aVar);
        }

        final void cb() {
            com.baidu.ar.c.a aVar = this.iw;
            this.iw = null;
            while (true) {
                if (aVar == null) {
                    try {
                        aVar = this.ix.poll(b.this.is, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            return;
                        }
                    } finally {
                        cc();
                    }
                }
                aVar.run();
                aVar = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cb();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int R(String str) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = this.iu.get(str)) != null) {
            BlockingQueue<com.baidu.ar.c.a> blockingQueue = aVar.ix;
            int size = blockingQueue.size();
            blockingQueue.clear();
            return size;
        }
        return 0;
    }

    public boolean a(com.baidu.ar.c.a aVar) {
        boolean b2;
        if (aVar == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.it;
        reentrantLock.lock();
        try {
            String tag = aVar.getTag();
            String str = tag == null ? "" : tag;
            a aVar2 = this.iu.get(str);
            if (aVar2 == null) {
                a aVar3 = new a(str, aVar);
                this.iu.put(str, aVar3);
                aVar3.iv.start();
                b2 = true;
            } else {
                b2 = aVar2.b(aVar);
            }
            return b2;
        } finally {
            reentrantLock.unlock();
        }
    }
}
