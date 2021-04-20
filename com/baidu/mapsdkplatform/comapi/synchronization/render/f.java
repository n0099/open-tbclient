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
    public static final String f7879a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f7880d;

    /* renamed from: b  reason: collision with root package name */
    public int f7881b;

    /* renamed from: c  reason: collision with root package name */
    public int f7882c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f7883e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f7884f;

    /* renamed from: g  reason: collision with root package name */
    public i f7885g;

    /* loaded from: classes2.dex */
    public class a implements i {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f fVar = f.this;
            fVar.e(fVar.f7881b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f7887a = new f();
    }

    public f() {
        this.f7881b = 0;
        this.f7882c = 5;
    }

    public static f a() {
        return b.f7887a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        String str = f7879a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i);
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            f(i);
            return;
        }
        String str2 = f7879a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i);
    }

    private void f(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7879a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = i;
        this.f7883e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e2 = this.f7884f.e();
        DisplayOptions f2 = this.f7884f.f();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7879a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, null, this.f7882c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e2 = this.f7884f.e();
        DisplayOptions f2 = this.f7884f.f();
        try {
            syncResponseResult = this.f7884f.g().take();
        } catch (InterruptedException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7879a, "Get result when InterruptedException happened.", e3);
            syncResponseResult = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7879a, "SyncRenderHandler is null");
        } else {
            bVar.a(e2, f2, syncResponseResult, this.f7882c);
        }
    }

    public void a(int i) {
        this.f7881b = i;
        e(i);
    }

    public void a(BaiduMap baiduMap) {
        this.f7884f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        a aVar = new a();
        this.f7885g = aVar;
        this.f7884f.a(aVar);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f7880d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f7880d.getLooper());
        this.f7883e = bVar;
        bVar.a(baiduMap, this.f7884f.e(), this.f7884f.f());
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public Marker b() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7879a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.a();
    }

    public void b(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public Marker c() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7879a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.b();
    }

    public void c(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public Marker d() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7879a, "SyncRenderHandler created failed");
            return null;
        }
        return bVar.c();
    }

    public void d(int i) {
        this.f7882c = i;
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        this.f7884f.c();
        if (this.f7885g != null) {
            this.f7885g = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f7884f;
        if (gVar != null) {
            gVar.h();
            this.f7884f = null;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.f();
            this.f7883e.removeCallbacksAndMessages(null);
            this.f7883e = null;
        }
        HandlerThread handlerThread = f7880d;
        if (handlerThread != null) {
            handlerThread.quit();
            f7880d = null;
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7883e;
        if (bVar != null) {
            bVar.g();
        }
    }
}
