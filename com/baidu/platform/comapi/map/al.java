package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
/* loaded from: classes3.dex */
public class al implements ad {
    private static final Semaphore e = new Semaphore(1);

    /* renamed from: b  reason: collision with root package name */
    protected boolean f4302b;
    private int c;
    private a d;
    private WeakReference<SurfaceView> h;
    private boolean f = true;
    private final WeakReference<al> g = new WeakReference<>(this);

    /* renamed from: a  reason: collision with root package name */
    protected ak f4301a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<al> f4304b;
        private boolean d;
        private boolean f;
        private ak k;
        private SurfaceHolder l;
        private Runnable n;
        private boolean e = false;
        private ArrayList<Runnable> m = new ArrayList<>();
        private boolean c = false;
        private int g = 0;
        private int h = 0;
        private boolean j = true;
        private int i = 1;

        public a(WeakReference<al> weakReference) {
            this.f4304b = weakReference;
            al alVar = weakReference.get();
            this.k = alVar.f4301a;
            this.l = alVar.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
            if (r2 == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
            r4 = true;
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
            if (r4 == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
            if (r2 == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
            r11.k.a(r11.l, r7, r8, 1);
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
            if (r0 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:
            r11.k.a(r7, r8);
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008a, code lost:
            if (r11.n == null) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
            r0 = r11.n;
            r11.n = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0091, code lost:
            if (r7 <= 0) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
            if (r8 <= 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0095, code lost:
            r11.k.a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x009a, code lost:
            if (r0 == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
            r0.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a3, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a5, code lost:
            r2 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a7, code lost:
            r4 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
            r2 = r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void f() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3 = true;
            boolean z4 = true;
            while (true) {
                try {
                    if (this.c) {
                        break;
                    }
                    synchronized (this) {
                        while (true) {
                            Runnable h = h();
                            if (h == null) {
                                break;
                            }
                            h.run();
                        }
                        boolean z5 = this.d;
                        while (g()) {
                            if (!this.e && !this.f) {
                                this.f = true;
                                notifyAll();
                            }
                            wait();
                        }
                        if (this.c) {
                            break;
                        }
                        boolean z6 = al.this.f;
                        int i = this.g;
                        int i2 = this.h;
                        al.this.f = false;
                        this.j = false;
                        if (this.e && this.f) {
                            this.f = false;
                            z6 = true;
                        }
                    }
                    z3 = z2;
                    z4 = z;
                } finally {
                    Log.i("VulkanSurfaceView", "destroySurface");
                }
            }
        }

        private boolean g() {
            if (this.c) {
                return false;
            }
            if (this.d || !this.e) {
                return true;
            }
            return this.g <= 0 || this.h <= 0 || !(this.j || this.i == 1);
        }

        private Runnable h() {
            synchronized (this) {
                if (this.m.size() > 0) {
                    return this.m.remove(0);
                }
                return null;
            }
        }

        public int a() {
            int i;
            synchronized (this) {
                i = this.i;
            }
            return i;
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this) {
                this.i = i;
                if (i == 1) {
                    notifyAll();
                }
            }
        }

        public void a(SurfaceHolder surfaceHolder) {
            synchronized (this) {
                this.e = true;
                notifyAll();
            }
        }

        public void a(SurfaceHolder surfaceHolder, int i, int i2) {
            synchronized (this) {
                this.g = i;
                this.h = i2;
                al.this.f = true;
                notifyAll();
            }
        }

        public void a(Runnable runnable) {
            synchronized (this) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.j = true;
                this.n = runnable;
                notifyAll();
            }
        }

        public void b() {
            synchronized (this) {
                this.j = true;
                notifyAll();
            }
        }

        public void b(SurfaceHolder surfaceHolder) {
            synchronized (this) {
                this.e = false;
                notifyAll();
                while (!this.f && isAlive()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void b(Runnable runnable) {
            synchronized (this) {
                this.m.add(runnable);
            }
        }

        public void c() {
            synchronized (this) {
                this.d = true;
            }
        }

        public void d() {
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }

        public void e() {
            synchronized (this) {
                this.c = true;
                notifyAll();
            }
            try {
                join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("VkThread " + getId());
            try {
                try {
                    al.e.acquire();
                    f();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    al.e.release();
                }
            } catch (InterruptedException e2) {
            }
        }
    }

    public al(SurfaceView surfaceView) {
        this.h = new WeakReference<>(surfaceView);
    }

    private void c() {
        if (this.d != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    @Override // com.baidu.platform.comapi.map.ad
    public Bitmap a(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return null;
    }

    public SurfaceHolder a() {
        return this.h.get().getHolder();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void a(int i) {
        this.c = i;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void a(ak akVar) {
        c();
        this.f4301a = akVar;
        this.d = new a(this.g);
        this.d.start();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void a(Runnable runnable) {
        this.d.b(runnable);
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void c(int i) {
        this.d.a(i);
    }

    @Override // com.baidu.platform.comapi.map.ad
    public int d() {
        return this.c;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public int e() {
        return this.d.a();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void f() {
        this.d.b();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.d != null) {
                this.d.e();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void g() {
        this.d.c();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void h() {
        this.d.d();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void i() {
        if (this.f4302b && this.f4301a != null) {
            int a2 = this.d != null ? this.d.a() : 1;
            this.d = new a(this.g);
            if (a2 != 1) {
                this.d.a(a2);
            }
            this.d.start();
        }
        this.f4302b = false;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void j() {
        if (this.d != null) {
            this.d.e();
        }
        this.f4302b = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.d.a(surfaceHolder, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.d.a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.d.b(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        if (this.d != null) {
            this.d.a(runnable);
        }
    }
}
