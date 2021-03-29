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
    public static final String f7844a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f7845d;

    /* renamed from: b  reason: collision with root package name */
    public int f7846b;

    /* renamed from: c  reason: collision with root package name */
    public int f7847c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f7848e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f7849f;

    /* renamed from: g  reason: collision with root package name */
    public i f7850g;

    /* loaded from: classes2.dex */
    public class a implements i {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f fVar = f.this;
            fVar.e(fVar.f7846b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f7852a = new f();
    }

    public f() {
        this.f7846b = 0;
        this.f7847c = 5;
    }

    public static f a() {
        return b.f7852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        String str = f7844a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i);
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            f(i);
            return;
        }
        String str2 = f7844a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i);
    }

    private void f(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7844a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = i;
        this.f7848e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e2 = this.f7849f.e();
        DisplayOptions f2 = this.f7849f.f();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7844a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, null, this.f7847c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e2 = this.f7849f.e();
        DisplayOptions f2 = this.f7849f.f();
        try {
            syncResponseResult = this.f7849f.g().take();
        } catch (InterruptedException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7844a, "Get result when InterruptedException happened.", e3);
            syncResponseResult = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7844a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, syncResponseResult, this.f7847c);
        }
    }

    public void a(int i) {
        this.f7846b = i;
        e(i);
    }

    public void a(BaiduMap baiduMap) {
        this.f7849f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        a aVar = new a();
        this.f7850g = aVar;
        this.f7849f.a(aVar);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f7845d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f7845d.getLooper());
        this.f7848e = bVar;
        bVar.a(baiduMap, this.f7849f.e(), this.f7849f.f());
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public Marker b() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7844a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.a();
    }

    public void b(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public Marker c() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7844a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.b();
    }

    public void c(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public Marker d() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7844a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.c();
    }

    public void d(int i) {
        this.f7847c = i;
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        this.f7849f.c();
        if (this.f7850g != null) {
            this.f7850g = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f7849f;
        if (gVar != null) {
            gVar.h();
            this.f7849f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.f();
            this.f7848e.removeCallbacksAndMessages(null);
            this.f7848e = null;
        }
        HandlerThread handlerThread = f7845d;
        if (handlerThread != null) {
            handlerThread.quit();
            f7845d = null;
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7848e;
        if (bVar != null) {
            bVar.g();
        }
    }
}
