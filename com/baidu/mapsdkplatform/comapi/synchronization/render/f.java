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
    public static final String f7862a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f7863d;

    /* renamed from: b  reason: collision with root package name */
    public int f7864b;

    /* renamed from: c  reason: collision with root package name */
    public int f7865c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f7866e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f7867f;

    /* renamed from: g  reason: collision with root package name */
    public i f7868g;

    /* loaded from: classes2.dex */
    public class a implements i {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f fVar = f.this;
            fVar.e(fVar.f7864b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f7870a = new f();
    }

    public f() {
        this.f7864b = 0;
        this.f7865c = 5;
    }

    public static f a() {
        return b.f7870a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        String str = f7862a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i2);
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            f(i2);
            return;
        }
        String str2 = f7862a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i2);
    }

    private void f(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7862a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = i2;
        this.f7866e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e2 = this.f7867f.e();
        DisplayOptions f2 = this.f7867f.f();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7862a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, (SyncResponseResult) null, this.f7865c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e2 = this.f7867f.e();
        DisplayOptions f2 = this.f7867f.f();
        try {
            syncResponseResult = this.f7867f.g().take();
        } catch (InterruptedException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7862a, "Get result when InterruptedException happened.", e3);
            syncResponseResult = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7862a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, syncResponseResult, this.f7865c);
        }
    }

    public void a(int i2) {
        this.f7864b = i2;
        e(i2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.a(i2, i3, i4, i5);
        }
    }

    public void a(BaiduMap baiduMap) {
        this.f7867f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        a aVar = new a();
        this.f7868g = aVar;
        this.f7867f.a(aVar);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f7863d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f7863d.getLooper());
        this.f7866e = bVar;
        bVar.a(baiduMap, this.f7867f.e(), this.f7867f.f());
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public Marker b() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7862a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.a();
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public Marker c() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7862a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.b();
    }

    public void c(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.b(i2);
        }
    }

    public Marker d() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7862a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.c();
    }

    public void d(int i2) {
        this.f7865c = i2;
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f7867f;
        if (gVar != null) {
            gVar.c();
        }
        if (this.f7868g != null) {
            this.f7868g = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar2 = this.f7867f;
        if (gVar2 != null) {
            gVar2.h();
            this.f7867f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.f();
            this.f7866e.removeCallbacksAndMessages(null);
            this.f7866e = null;
        }
        HandlerThread handlerThread = f7863d;
        if (handlerThread != null) {
            handlerThread.quit();
            f7863d = null;
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7866e;
        if (bVar != null) {
            bVar.g();
        }
    }
}
