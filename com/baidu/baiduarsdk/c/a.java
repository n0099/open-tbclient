package com.baidu.baiduarsdk.c;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.baiduarsdk.ArBridge;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
/* loaded from: classes3.dex */
public class a {
    protected Timer b;
    protected TimerTask c;
    private HandlerC0058a f;
    private int i;
    private int j;
    private int l;
    private com.baidu.baiduarsdk.c.b p;
    private Handler q;
    private ArrayList<Runnable> g = new ArrayList<>();
    private int[] h = null;
    boolean a = false;
    private long k = -1;
    protected float d = 30.0f;
    private boolean m = false;
    private long n = System.currentTimeMillis();
    private int o = 33;
    private volatile int t = 0;
    private volatile boolean u = false;
    private BlockingQueue<int[]> r = new ArrayBlockingQueue(3);
    private BlockingQueue<int[]> s = new ArrayBlockingQueue(3);
    private com.baidu.baiduarsdk.c.b e = new com.baidu.baiduarsdk.c.b("ArGLEngineThread");

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.baiduarsdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0058a extends Handler {
        a a;

        HandlerC0058a(a aVar, Looper looper) {
            super(looper);
            this.a = aVar;
        }

        void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (this.a != null) {
                        this.a.m();
                        return;
                    }
                    return;
                case 1002:
                    if (this.a != null) {
                        this.a.x();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends TimerTask {
        SoftReference<a> a;

        b(a aVar) {
            this.a = new SoftReference<>(aVar);
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            boolean cancel = super.cancel();
            if (this.a != null) {
                this.a.clear();
                this.a = null;
            }
            return cancel;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar;
            if (this.a == null || (aVar = this.a.get()) == null) {
                return;
            }
            aVar.b();
        }
    }

    public a(EGLContext eGLContext, EGLConfig eGLConfig) {
        this.l = 1;
        this.e.a(eGLContext, eGLConfig);
        this.e.start();
        this.f = new HandlerC0058a(this, this.e.getLooper());
        a(new Runnable() { // from class: com.baidu.baiduarsdk.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.k = Thread.currentThread().getId();
            }
        });
        this.l = 1;
        if (this.m) {
            p();
        }
    }

    private void a(Queue<int[]> queue) {
        for (int[] iArr : queue) {
            if (iArr != null) {
                a(iArr);
            }
        }
        queue.clear();
    }

    public static void a(int[] iArr) {
        for (int i = 0; i < 3; i++) {
            if (iArr[i] != -1) {
                com.baidu.baiduarsdk.gpuimage.graphics.a.c(iArr[i]);
                iArr[i] = -1;
            }
            if (iArr[i + 3] != -1) {
                com.baidu.baiduarsdk.gpuimage.graphics.a.b(iArr[i + 3]);
                iArr[i + 3] = -1;
            }
            if (iArr[i + 6] != -1) {
                com.baidu.baiduarsdk.gpuimage.graphics.a.d(iArr[i + 6]);
                iArr[i + 6] = -1;
            }
        }
    }

    private void b(Queue<int[]> queue) {
        for (int[] iArr : queue) {
            if (iArr != null) {
                for (int i = 0; i < 3; i++) {
                    if (iArr[i] != -1) {
                        GLES20.glBindFramebuffer(36160, iArr[i]);
                        GLES20.glViewport(0, 0, this.i, this.j);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        GLES20.glBindFramebuffer(36160, 0);
                    }
                }
            }
        }
    }

    private void c(int i, int i2) {
        if (this.i != i || this.j != i2) {
            this.a = true;
        }
        this.i = i;
        this.j = i2;
    }

    private void n() {
        if (this.p != null) {
            this.p.quit();
            try {
                this.p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void o() {
        if (this.f != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Runnable runnable = new Runnable() { // from class: com.baidu.baiduarsdk.c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        a.this.y();
                        atomicBoolean.set(true);
                        notify();
                    }
                }
            };
            this.f.post(runnable);
            try {
                synchronized (runnable) {
                    while (!atomicBoolean.get()) {
                        runnable.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f.removeCallbacksAndMessages(null);
            this.f.a();
            this.f = null;
        }
        this.g.clear();
        if (this.e != null) {
            this.e.quit();
            try {
                this.e.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void p() {
        if (this.b != null) {
            this.b.cancel();
            this.b.purge();
        }
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.b = new Timer();
        this.c = new b(this);
        this.b.schedule(this.c, 0L, 1000.0f / this.d);
    }

    private boolean q() {
        if (this.b != null) {
            this.b.cancel();
            this.b.purge();
            this.b = null;
            if (this.c != null) {
                this.c.cancel();
                this.c = null;
            }
            return true;
        }
        return false;
    }

    private synchronized void r() {
        if (this.p == null && a() != null) {
            this.p = new com.baidu.baiduarsdk.c.b("GLResLoadThread");
            this.p.a(a(), null);
            this.p.start();
            this.q = new Handler(this.p.getLooper());
        }
    }

    private void s() {
        this.t = 1;
    }

    private boolean t() {
        return this.t == 1;
    }

    private boolean u() {
        if (this.i == 0 && this.j == 0) {
            return false;
        }
        v();
        int[] w = w();
        if (w != null) {
            if (this.h != null) {
                c(this.h);
            }
            this.h = w;
        }
        if (this.h != null) {
            return ArBridge.getInstance().updateFbos(this.h);
        }
        return false;
    }

    private void v() {
        if (this.a) {
            a(this.r);
            a(this.s);
            for (int i = 0; i < 3; i++) {
                int[] iArr = new int[9];
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 == 1 || i2 == 2) {
                        iArr[i2] = -1;
                        iArr[i2 + 3] = -1;
                        iArr[i2 + 6] = -1;
                    } else {
                        iArr[i2] = com.baidu.baiduarsdk.gpuimage.graphics.a.b();
                        iArr[i2 + 3] = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, this.i, this.j);
                        iArr[i2 + 6] = com.baidu.baiduarsdk.gpuimage.graphics.a.c();
                        com.baidu.baiduarsdk.gpuimage.graphics.a.a(33189, this.i, this.j, iArr[i2 + 6], iArr[i2]);
                        com.baidu.baiduarsdk.gpuimage.graphics.a.b(iArr[i2 + 3], 3553, iArr[i2]);
                        Log.d("bdar", "bdar: blend fboIds = " + iArr[i2]);
                        GLES20.glBindFramebuffer(36160, iArr[i2]);
                        GLES20.glViewport(0, 0, this.i, this.j);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        GLES20.glBindFramebuffer(36160, 0);
                    }
                }
                this.r.offer(iArr);
            }
            GLES20.glFlush();
            this.a = false;
        }
    }

    private int[] w() {
        return this.r.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Runnable remove;
        while (true) {
            synchronized (this.e) {
                remove = !this.g.isEmpty() ? this.g.remove(0) : null;
            }
            if (remove == null) {
                return;
            }
            remove.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.h != null) {
            b(this.h);
            this.h = null;
        }
        a(this.r);
        a(this.s);
    }

    public EGLContext a() {
        return this.e.a();
    }

    public void a(int i) {
        if (this.l == i) {
            return;
        }
        this.l = i;
        if (this.l == 0) {
            q();
        } else if (this.m) {
            p();
        }
    }

    public void a(final int i, final int i2) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.c.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(i, i2);
            }
        });
    }

    public void a(Runnable runnable) {
        if (this.f != null) {
            synchronized (this.e) {
                this.g.add(runnable);
            }
            if (this.f.hasMessages(1002)) {
                return;
            }
            this.f.sendEmptyMessage(1002);
        }
    }

    public void b() {
        if (this.f == null || this.f.hasMessages(1001)) {
            return;
        }
        this.f.sendEmptyMessage(1001);
    }

    protected void b(int i, int i2) {
        c(i, i2);
        if (this.h != null) {
            b(this.h);
            this.h = null;
        }
        a(this.r);
        a(this.s);
        GLES20.glFlush();
        this.u = false;
    }

    public void b(Runnable runnable) {
        r();
        if (this.q != null) {
            this.q.post(runnable);
        }
    }

    public void b(int[] iArr) {
        if (iArr != null) {
            this.r.offer(iArr);
        }
    }

    public void c() {
        q();
        n();
        o();
    }

    public void c(int[] iArr) {
        if (iArr != null) {
            this.s.offer(iArr);
        }
    }

    public long d() {
        return this.k;
    }

    public int e() {
        return this.l;
    }

    public boolean f() {
        return this.m;
    }

    public void g() {
        if (this.q != null) {
            this.q.removeCallbacksAndMessages(null);
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
            this.q.post(new Runnable() { // from class: com.baidu.baiduarsdk.c.a.4
                @Override // java.lang.Runnable
                public void run() {
                    linkedBlockingQueue.add(1);
                }
            });
            while (this.p.isAlive()) {
                if (linkedBlockingQueue.poll(50L, TimeUnit.MILLISECONDS) != null) {
                    return;
                }
            }
        }
    }

    public void h() {
        this.u = true;
    }

    public void i() {
        this.t = 0;
    }

    public void j() {
        b(this.r);
        b(this.s);
    }

    public int[] k() {
        if (this.u) {
            return null;
        }
        return this.s.poll();
    }

    public int l() {
        int size;
        synchronized (this.s) {
            size = this.s.size();
        }
        return size;
    }

    public void m() {
        if (t()) {
            return;
        }
        if (this.o > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.n;
            if (currentTimeMillis < this.o) {
                try {
                    Thread.sleep(this.o - currentTimeMillis);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.n = System.currentTimeMillis();
        }
        if (u()) {
            System.currentTimeMillis();
            ArBridge.getInstance().update();
            this.e.c();
            synchronized (this.r) {
                if (this.r.size() != 0) {
                    c(this.h);
                    this.h = null;
                }
            }
        }
        s();
    }
}
