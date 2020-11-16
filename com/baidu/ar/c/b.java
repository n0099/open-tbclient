package com.baidu.ar.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes12.dex */
public class b {
    private int ic = 1500;
    private final ReentrantLock ie = new ReentrantLock();

    /* renamed from: if  reason: not valid java name */
    private Map<String, a> f1if = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements Runnable {
        final Thread ig;
        com.baidu.ar.c.a ih;
        BlockingQueue<com.baidu.ar.c.a> ii;
        String tag;

        a(String str, com.baidu.ar.c.a aVar) {
            this.ih = aVar;
            this.ig = new Thread(this);
            this.ii = new ArrayBlockingQueue(10);
            this.tag = str;
        }

        a(String str, BlockingQueue<com.baidu.ar.c.a> blockingQueue) {
            this.ig = new Thread(this);
            this.ii = blockingQueue;
            this.tag = str;
        }

        private void cd() {
            b.this.ie.lock();
            try {
                b.this.f1if.remove(this.tag);
                if (this.ii.size() > 0) {
                    a aVar = new a(this.tag, this.ii);
                    b.this.f1if.put(this.tag, aVar);
                    aVar.ig.start();
                }
            } finally {
                b.this.ie.unlock();
            }
        }

        public boolean b(com.baidu.ar.c.a aVar) {
            return this.ii.offer(aVar);
        }

        final void cc() {
            com.baidu.ar.c.a aVar = this.ih;
            this.ih = null;
            while (true) {
                if (aVar == null) {
                    try {
                        aVar = this.ii.poll(b.this.ic, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            return;
                        }
                    } finally {
                        cd();
                    }
                }
                aVar.run();
                aVar = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int O(String str) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = this.f1if.get(str)) != null) {
            BlockingQueue<com.baidu.ar.c.a> blockingQueue = aVar.ii;
            int size = blockingQueue.size();
            blockingQueue.clear();
            return size;
        }
        return 0;
    }

    public boolean a(com.baidu.ar.c.a aVar) {
        boolean b;
        if (aVar == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.ie;
        reentrantLock.lock();
        try {
            String tag = aVar.getTag();
            String str = tag == null ? "" : tag;
            a aVar2 = this.f1if.get(str);
            if (aVar2 == null) {
                a aVar3 = new a(str, aVar);
                this.f1if.put(str, aVar3);
                aVar3.ig.start();
                b = true;
            } else {
                b = aVar2.b(aVar);
            }
            return b;
        } finally {
            reentrantLock.unlock();
        }
    }
}
