package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.HandlerThread;
import android.os.Message;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mapsdkplatform.comapi.synchronization.data.i;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3146a = f.class.getSimpleName();
    private static HandlerThread d;

    /* renamed from: b  reason: collision with root package name */
    private int f3147b;
    private int c;
    private com.baidu.mapsdkplatform.comapi.synchronization.render.b e;
    private com.baidu.mapsdkplatform.comapi.synchronization.data.g f;
    private i g;

    /* loaded from: classes4.dex */
    private class a implements i {
        private a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            f.this.j();
            f.this.e(f.this.f3147b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            f.this.i();
        }
    }

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final f f3149a = new f();
    }

    private f() {
        this.f3147b = 0;
        this.c = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a() {
        return b.f3149a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(f3146a, "The order state is: " + i);
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                f(i);
                return;
            default:
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(f3146a, "Undefined order state: " + i);
                return;
        }
    }

    private void f(int i) {
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = this.e.obtainMessage();
        obtainMessage.what = i;
        this.e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        RoleOptions e = this.f.e();
        DisplayOptions f = this.f.f();
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "SyncRenderHandler is null");
        } else {
            this.e.a(e, f, null, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e = this.f.e();
        DisplayOptions f = this.f.f();
        try {
            syncResponseResult = this.f.g().take();
        } catch (InterruptedException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f3146a, "Get result when InterruptedException happened.", e2);
            syncResponseResult = null;
        }
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "SyncRenderHandler is null");
        } else {
            this.e.a(e, f, syncResponseResult, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f3147b = i;
        e(this.f3147b);
    }

    public void a(BaiduMap baiduMap) {
        this.f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
        this.g = new a();
        this.f.a(this.g);
        d = new HandlerThread("SynchronizationRenderStrategy");
        d.start();
        this.e = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(d.getLooper());
        this.e.a(baiduMap, this.f.e(), this.f.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        if (this.e != null) {
            this.e.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker b() {
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "SyncRenderHandler created failed");
            return null;
        }
        return this.e.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker c() {
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "SyncRenderHandler created failed");
            return null;
        }
        return this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        if (this.e != null) {
            this.e.b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker d() {
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3146a, "SyncRenderHandler created failed");
            return null;
        }
        return this.e.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        this.c = i;
    }

    public void e() {
        if (this.e != null) {
            this.e.d();
        }
    }

    public void f() {
        if (this.e != null) {
            this.e.e();
        }
    }

    public void g() {
        this.f.c();
        if (this.g != null) {
            this.g = null;
        }
        if (this.f != null) {
            this.f.h();
            this.f = null;
        }
        if (this.e != null) {
            this.e.f();
            this.e.removeCallbacksAndMessages(null);
            this.e = null;
        }
        if (d != null) {
            d.quit();
            d = null;
        }
    }

    public void h() {
        if (this.e != null) {
            this.e.g();
        }
    }
}
