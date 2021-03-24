package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.HandlerThread;
import android.os.Message;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mapsdkplatform.comapi.synchronization.data.i;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7843a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f7844d;

    /* renamed from: b  reason: collision with root package name */
    public int f7845b;

    /* renamed from: c  reason: collision with root package name */
    public int f7846c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f7847e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f7848f;

    /* renamed from: g  reason: collision with root package name */
    public i f7849g;

    /* loaded from: classes2.dex */
    public class a implements i {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f fVar = f.this;
            fVar.e(fVar.f7845b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f7851a = new f();
    }

    public f() {
        this.f7845b = 0;
        this.f7846c = 5;
    }

    public static f a() {
        return b.f7851a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        String str = f7843a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i);
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            f(i);
            return;
        }
        String str2 = f7843a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i);
    }

    private void f(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7843a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = i;
        this.f7847e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e2 = this.f7848f.e();
        DisplayOptions f2 = this.f7848f.f();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7843a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, null, this.f7846c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e2 = this.f7848f.e();
        DisplayOptions f2 = this.f7848f.f();
        try {
            syncResponseResult = this.f7848f.g().take();
        } catch (InterruptedException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7843a, "Get result when InterruptedException happened.", e3);
            syncResponseResult = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7843a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, syncResponseResult, this.f7846c);
        }
    }

    public void a(int i) {
        this.f7845b = i;
        e(i);
    }

    public void a(BaiduMap baiduMap) {
        this.f7848f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        a aVar = new a();
        this.f7849g = aVar;
        this.f7848f.a(aVar);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f7844d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f7844d.getLooper());
        this.f7847e = bVar;
        bVar.a(baiduMap, this.f7848f.e(), this.f7848f.f());
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public Marker b() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7843a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.a();
    }

    public void b(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public Marker c() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7843a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.b();
    }

    public void c(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public Marker d() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7843a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.c();
    }

    public void d(int i) {
        this.f7846c = i;
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        this.f7848f.c();
        if (this.f7849g != null) {
            this.f7849g = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f7848f;
        if (gVar != null) {
            gVar.h();
            this.f7848f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.f();
            this.f7847e.removeCallbacksAndMessages(null);
            this.f7847e = null;
        }
        HandlerThread handlerThread = f7844d;
        if (handlerThread != null) {
            handlerThread.quit();
            f7844d = null;
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7847e;
        if (bVar != null) {
            bVar.g();
        }
    }
}
