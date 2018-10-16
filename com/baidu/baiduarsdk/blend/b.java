package com.baidu.baiduarsdk.blend;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.gpuimage.a.g;
import java.util.HashMap;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
/* loaded from: classes3.dex */
public class b {
    static int a;
    static int b;
    static byte[] c;
    private static final String d = b.class.getSimpleName();
    private static int h = 0;
    private com.baidu.baiduarsdk.blend.c f;
    private com.baidu.baiduarsdk.blend.a g;
    private e j;
    private com.baidu.baiduarsdk.filter.a k;
    private InterfaceC0062b l;
    private boolean e = false;
    private boolean i = false;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* renamed from: com.baidu.baiduarsdk.blend.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0062b {
        void a(com.baidu.baiduarsdk.filter.a aVar);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void a(int i);

        void a(EGLContext eGLContext, int i, int i2);

        void b();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int[] iArr, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e {
        int a;
        int b;
        boolean c;
        private com.baidu.baiduarsdk.c.a d;

        private e() {
            this.a = 0;
            this.b = 0;
            this.c = false;
        }

        public void a(int i, int i2) {
            if (this.a != i || this.b != i2) {
                this.c = true;
            }
            this.a = i;
            this.b = i2;
        }

        public void a(EGLContext eGLContext, EGLConfig eGLConfig) {
            if (this.d == null) {
                this.d = new com.baidu.baiduarsdk.c.a(eGLContext, eGLConfig);
                ArBridge.getInstance().setArEngineCtl(this.d);
                ArBridge.getInstance().onResume();
                ArBridge.getInstance().setEnginGLJniEnv();
            }
            if (this.c) {
                this.d.a(this.a, this.b);
                ArBridge.getInstance().setSize(this.a, this.b);
                this.c = false;
            }
        }

        public boolean a() {
            return this.c;
        }

        public void b() {
            if (this.d != null) {
                this.d.h();
            }
        }

        public com.baidu.baiduarsdk.c.a c() {
            return this.d;
        }
    }

    public b() {
        this.g = null;
        this.g = new com.baidu.baiduarsdk.blend.a();
        this.f = new com.baidu.baiduarsdk.blend.c(this.g);
        this.f.a();
        this.k = k();
    }

    private void a(com.baidu.baiduarsdk.filter.a aVar) {
        if (aVar != null) {
            this.k = aVar;
            final List<g> c2 = aVar.c();
            final List<g> d2 = aVar.d();
            final List<g> e2 = aVar.e();
            this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.11
                @Override // java.lang.Runnable
                public void run() {
                    b.this.g.a(c2);
                    b.this.g.b(d2);
                    b.this.g.c(e2);
                }
            });
            if (this.l != null) {
                this.l.a(this.k);
            }
        }
    }

    private void a(Object obj, int i, int i2) {
        if (this.f != null) {
            this.f.a(obj, i, i2);
        }
    }

    public static synchronized void a(byte[] bArr, int i, int i2) {
        synchronized (b.class) {
            if (bArr != null) {
                if (bArr.length > 0) {
                    if (a != i) {
                        a = i;
                    }
                    if (b != i2) {
                        b = i2;
                    }
                    if (c == null || c.length != bArr.length) {
                        c = new byte[bArr.length];
                    }
                    System.arraycopy(bArr, 0, c, 0, bArr.length);
                }
            }
        }
    }

    private static void b(int i) {
        h = i;
    }

    public static synchronized void i() {
        synchronized (b.class) {
            c = null;
        }
    }

    private void j() {
        if (this.j != null) {
            this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!b.this.f.e().e() || b.this.j == null) {
                        return;
                    }
                    if (b.this.j.a()) {
                        b.this.j.b();
                        b.this.g.a();
                    }
                    b.this.j.a(b.this.f.e().f(), b.this.f.e().g());
                    b.this.g.a(b.this.j.c());
                }
            });
        }
    }

    private com.baidu.baiduarsdk.filter.a k() {
        com.baidu.baiduarsdk.filter.a aVar = new com.baidu.baiduarsdk.filter.a();
        aVar.a(0);
        aVar.a(true);
        aVar.b(true);
        aVar.c(true);
        aVar.d(true);
        HashMap hashMap = new HashMap();
        hashMap.put(0, new g());
        aVar.d(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(0, new g());
        aVar.e(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(0, new g());
        aVar.f(hashMap3);
        return aVar;
    }

    public void a() {
        this.e = true;
    }

    public void a(int i) {
        b(i);
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2) {
        a((Object) surfaceTexture, i, i2);
        if (this.j != null) {
            this.j.a(i, i2);
        }
        if (this.i) {
            j();
        }
    }

    public void a(final SurfaceTexture surfaceTexture, final TextureParams textureParams) {
        try {
            if (Build.VERSION.SDK_INT >= 16 && surfaceTexture != null) {
                surfaceTexture.detachFromGLContext();
            }
        } catch (RuntimeException e2) {
            Log.e(d, "detachFromGLContext error");
        }
        Log.i(d, "setupSource ");
        this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.g.a(surfaceTexture);
                b.this.g.a(textureParams);
            }
        });
    }

    public void a(final TextureParams textureParams) {
        this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.g.a(textureParams);
            }
        });
    }

    public void a(final c cVar) {
        this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.g.a(cVar);
                cVar.a();
            }
        });
    }

    public void a(final d dVar) {
        this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.g != null) {
                    b.this.g.a(dVar);
                }
            }
        });
    }

    public void a(com.baidu.baiduarsdk.filter.a aVar, String str) {
        boolean z = aVar != null;
        if (!z) {
            aVar = this.k;
        }
        if (aVar != null) {
            if (TextUtils.isEmpty(str)) {
                a(aVar);
            } else if (str.equals("reality_target")) {
                final List<g> c2 = aVar.c();
                if (z) {
                    this.k.d(aVar.i());
                }
                this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.g.a(c2);
                    }
                });
            } else if (str.equals("virtual_target")) {
                final List<g> d2 = aVar.d();
                if (z) {
                    this.k.e(aVar.j());
                }
                this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.g.b(d2);
                    }
                });
            } else if (!str.equals("mix_target")) {
                a(aVar);
            } else {
                final List<g> e2 = aVar.e();
                if (z) {
                    this.k.f(aVar.k());
                }
                this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.g.c(e2);
                    }
                });
            }
        }
    }

    public void a(final boolean z) {
        if (z) {
            j();
        }
        this.i = z;
        this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.g != null) {
                    b.this.g.a(z);
                }
            }
        });
    }

    public void b() {
        this.e = false;
    }

    public void b(final c cVar) {
        this.f.a(new Runnable() { // from class: com.baidu.baiduarsdk.blend.b.9
            @Override // java.lang.Runnable
            public void run() {
                cVar.b();
                b.this.g.a((c) null);
            }
        });
    }

    public void c() {
        if (this.j != null && this.j.c() != null) {
            this.j.c().c();
        }
        if (this.f != null) {
            this.f.c();
        }
    }

    public com.baidu.baiduarsdk.blend.c d() {
        return this.f;
    }

    public void e() {
        this.j = new e();
    }

    public boolean f() {
        return this.i;
    }

    public void g() {
        a(k());
    }

    public com.baidu.baiduarsdk.filter.a h() {
        return this.k;
    }
}
