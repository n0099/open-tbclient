package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements ak {
    public static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    public int f2923a;
    public int b;
    private af g;
    private WeakReference<MapSurfaceView> h;
    private WeakReference<GLTextureView> i;
    private c j;
    private int l;
    private int m;
    private int n;
    private int o;
    private Bitmap.Config p;
    private e q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private AppBaseMap e = null;
    private boolean f = false;
    private volatile boolean k = false;
    private long v = 0;
    private boolean w = false;
    private volatile boolean x = false;
    public int c = 0;

    public m(GLTextureView gLTextureView, af afVar) {
        this.i = new WeakReference<>(gLTextureView);
        this.g = afVar;
    }

    public m(WeakReference<MapSurfaceView> weakReference, af afVar) {
        this.g = afVar;
        this.h = weakReference;
    }

    private void b(Object obj) {
        GLTextureView gLTextureView;
        MapSurfaceView mapSurfaceView;
        if (this.j == null) {
            return;
        }
        if (this.h != null && (mapSurfaceView = this.h.get()) != null && this.l > 0 && this.m > 0) {
            com.baidu.platform.comapi.util.j.a(new o(this, mapSurfaceView.captureImageFromSurface(0, 0, this.l, this.m, obj, this.p)), 0L);
        }
        if (this.i == null || (gLTextureView = this.i.get()) == null || this.l <= 0 || this.m <= 0) {
            return;
        }
        com.baidu.platform.comapi.util.j.a(new p(this, gLTextureView.captureImageFromSurface(0, 0, this.l, this.m, obj, this.p)), 0L);
    }

    private boolean c() {
        return this.e != null && this.f;
    }

    public void a() {
        this.x = false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(int i, int i2) {
        if (this.e != null) {
            this.e.renderResize(i, i2);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.r = false;
        this.s = 0;
        this.u = 0;
        this.t = 0;
        if (c()) {
            this.e.renderInit(i, i2, surfaceHolder != null ? surfaceHolder.getSurface() : null, i3);
        }
    }

    public void a(c cVar, int i, int i2) {
        this.k = true;
        this.j = cVar;
        this.l = i;
        this.m = i2;
        this.p = null;
    }

    public void a(c cVar, int i, int i2, int i3, int i4, Bitmap.Config config) {
        this.k = true;
        this.j = cVar;
        this.n = i;
        this.o = i2;
        this.l = i3;
        this.m = i4;
        this.p = config;
    }

    public void a(c cVar, int i, int i2, Bitmap.Config config) {
        this.k = true;
        this.j = cVar;
        this.l = i;
        this.m = i2;
        this.p = config;
    }

    public void a(e eVar) {
        this.q = eVar;
    }

    public void a(AppBaseMap appBaseMap) {
        this.e = appBaseMap;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(Object obj) {
        GLTextureView gLTextureView;
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        if (c()) {
            if (!this.w) {
                this.w = true;
                if (this.h != null && (mapSurfaceView2 = this.h.get()) != null) {
                    mapSurfaceView2.post(new n(this, mapSurfaceView2));
                }
            }
            if (!this.r) {
                this.s++;
                if (this.s == 3 && this.q != null) {
                    this.q.a();
                }
                this.r = this.s == 3;
            }
            if (d) {
                d = false;
            } else if (!this.x) {
                int Draw = this.e.Draw();
                if (this.h != null && (mapSurfaceView = this.h.get()) != null) {
                    if (Draw == 1) {
                        mapSurfaceView.requestRender();
                    } else if (mapSurfaceView.getRenderMode() != 0) {
                        mapSurfaceView.setRenderMode(0);
                    }
                }
                if (this.i != null && (gLTextureView = this.i.get()) != null) {
                    if (Draw == 1) {
                        gLTextureView.requestRender();
                    } else if (gLTextureView.getRenderMode() != 0) {
                        gLTextureView.setRenderMode(0);
                    }
                }
                if (this.k) {
                    this.k = false;
                    if (this.j != null) {
                        b(obj);
                    }
                }
                if (this.h == null || this.h.get().getBaseMap() == null || this.h.get().getBaseMap().h == null) {
                    return;
                }
                for (ag agVar : this.h.get().getBaseMap().h) {
                    if (this.h.get().getBaseMap() == null) {
                        return;
                    }
                    com.baidu.mapsdkplatform.comapi.map.w G = this.h.get().getBaseMap().G();
                    if (agVar != null) {
                        agVar.a(null, G);
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b() {
        this.x = true;
    }
}
