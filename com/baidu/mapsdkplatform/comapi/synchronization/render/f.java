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
    public static final String f7905a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f7906d;

    /* renamed from: b  reason: collision with root package name */
    public int f7907b;

    /* renamed from: c  reason: collision with root package name */
    public int f7908c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f7909e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f7910f;

    /* renamed from: g  reason: collision with root package name */
    public i f7911g;

    /* loaded from: classes2.dex */
    public class a implements i {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f fVar = f.this;
            fVar.e(fVar.f7907b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f7913a = new f();
    }

    public f() {
        this.f7907b = 0;
        this.f7908c = 5;
    }

    public static f a() {
        return b.f7913a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        String str = f7905a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i2);
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            f(i2);
            return;
        }
        String str2 = f7905a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i2);
    }

    private void f(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7905a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = i2;
        this.f7909e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e2 = this.f7910f.e();
        DisplayOptions f2 = this.f7910f.f();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7905a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, (SyncResponseResult) null, this.f7908c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e2 = this.f7910f.e();
        DisplayOptions f2 = this.f7910f.f();
        try {
            syncResponseResult = this.f7910f.g().take();
        } catch (InterruptedException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7905a, "Get result when InterruptedException happened.", e3);
            syncResponseResult = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7905a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, syncResponseResult, this.f7908c);
        }
    }

    public void a(int i2) {
        this.f7907b = i2;
        e(i2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.a(i2, i3, i4, i5);
        }
    }

    public void a(BaiduMap baiduMap) {
        this.f7910f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        a aVar = new a();
        this.f7911g = aVar;
        this.f7910f.a(aVar);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f7906d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f7906d.getLooper());
        this.f7909e = bVar;
        bVar.a(baiduMap, this.f7910f.e(), this.f7910f.f());
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public Marker b() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7905a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.a();
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public Marker c() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7905a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.b();
    }

    public void c(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.b(i2);
        }
    }

    public Marker d() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7905a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.c();
    }

    public void d(int i2) {
        this.f7908c = i2;
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f7910f;
        if (gVar != null) {
            gVar.c();
        }
        if (this.f7911g != null) {
            this.f7911g = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar2 = this.f7910f;
        if (gVar2 != null) {
            gVar2.h();
            this.f7910f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.f();
            this.f7909e.removeCallbacksAndMessages(null);
            this.f7909e = null;
        }
        HandlerThread handlerThread = f7906d;
        if (handlerThread != null) {
            handlerThread.quit();
            f7906d = null;
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7909e;
        if (bVar != null) {
            bVar.g();
        }
    }
}
