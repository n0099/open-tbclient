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
    public static final String f8165a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f8166d;

    /* renamed from: b  reason: collision with root package name */
    public int f8167b;

    /* renamed from: c  reason: collision with root package name */
    public int f8168c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f8169e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f8170f;

    /* renamed from: g  reason: collision with root package name */
    public i f8171g;

    /* loaded from: classes2.dex */
    public class a implements i {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f fVar = f.this;
            fVar.e(fVar.f8167b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f8173a = new f();
    }

    public f() {
        this.f8167b = 0;
        this.f8168c = 5;
    }

    public static f a() {
        return b.f8173a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        String str = f8165a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i2);
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            f(i2);
            return;
        }
        String str2 = f8165a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i2);
    }

    private void f(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8165a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = i2;
        this.f8169e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e2 = this.f8170f.e();
        DisplayOptions f2 = this.f8170f.f();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8165a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, null, this.f8168c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e2 = this.f8170f.e();
        DisplayOptions f2 = this.f8170f.f();
        try {
            syncResponseResult = this.f8170f.g().take();
        } catch (InterruptedException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f8165a, "Get result when InterruptedException happened.", e3);
            syncResponseResult = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8165a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, syncResponseResult, this.f8168c);
        }
    }

    public void a(int i2) {
        this.f8167b = i2;
        e(i2);
    }

    public void a(BaiduMap baiduMap) {
        this.f8170f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        a aVar = new a();
        this.f8171g = aVar;
        this.f8170f.a(aVar);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f8166d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f8166d.getLooper());
        this.f8169e = bVar;
        bVar.a(baiduMap, this.f8170f.e(), this.f8170f.f());
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public Marker b() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8165a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.a();
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public Marker c() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8165a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.b();
    }

    public void c(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.b(i2);
        }
    }

    public Marker d() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8165a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.c();
    }

    public void d(int i2) {
        this.f8168c = i2;
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        this.f8170f.c();
        if (this.f8171g != null) {
            this.f8171g = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f8170f;
        if (gVar != null) {
            gVar.h();
            this.f8170f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.f();
            this.f8169e.removeCallbacksAndMessages(null);
            this.f8169e = null;
        }
        HandlerThread handlerThread = f8166d;
        if (handlerThread != null) {
            handlerThread.quit();
            f8166d = null;
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f8169e;
        if (bVar != null) {
            bVar.g();
        }
    }
}
