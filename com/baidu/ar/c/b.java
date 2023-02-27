package com.baidu.ar.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class b {
    public int is = 1500;
    public final ReentrantLock it = new ReentrantLock();
    public Map<String, a> iu = new HashMap();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final Thread iv;
        public com.baidu.ar.c.a iw;
        public BlockingQueue<com.baidu.ar.c.a> ix;
        public String tag;

        public a(String str, com.baidu.ar.c.a aVar) {
            this.iw = aVar;
            this.iv = new Thread(this);
            this.ix = new ArrayBlockingQueue(10);
            this.tag = str;
        }

        public a(String str, BlockingQueue<com.baidu.ar.c.a> blockingQueue) {
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

        public final void cb() {
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
        if (TextUtils.isEmpty(str) || (aVar = this.iu.get(str)) == null) {
            return 0;
        }
        BlockingQueue<com.baidu.ar.c.a> blockingQueue = aVar.ix;
        int size = blockingQueue.size();
        blockingQueue.clear();
        return size;
    }

    public boolean a(com.baidu.ar.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = true;
        ReentrantLock reentrantLock = this.it;
        reentrantLock.lock();
        try {
            String tag = aVar.getTag();
            if (tag == null) {
                tag = "";
            }
            a aVar2 = this.iu.get(tag);
            if (aVar2 == null) {
                a aVar3 = new a(tag, aVar);
                this.iu.put(tag, aVar3);
                aVar3.iv.start();
            } else {
                z = aVar2.b(aVar);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }
}
