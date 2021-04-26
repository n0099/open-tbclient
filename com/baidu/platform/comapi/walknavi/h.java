package com.baidu.platform.comapi.walknavi;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes2.dex */
public class h implements WalkNaviModeSwitchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10067a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10068b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f10069c;

    public h(b bVar, int i2, boolean z) {
        this.f10069c = bVar;
        this.f10067a = i2;
        this.f10068b = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onFailed() {
        Log.d("ContentValues", "onWalkNaviModeChange onFailed");
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onSuccess() {
        com.baidu.platform.comapi.wnplatform.n.a aVar;
        com.baidu.platform.comapi.wnplatform.n.a aVar2;
        com.baidu.platform.comapi.wnplatform.n.a aVar3;
        this.f10069c.P = this.f10067a;
        aVar = this.f10069c.p;
        if (aVar != null) {
            aVar2 = this.f10069c.p;
            if (aVar2 instanceof com.baidu.platform.comapi.walknavi.g.a) {
                aVar3 = this.f10069c.p;
                ((com.baidu.platform.comapi.walknavi.g.a) aVar3).a(this.f10067a, this.f10068b);
            }
        }
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            b.a().e(0);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            new Handler(Looper.myLooper()).postDelayed(new i(this), 100L);
        }
    }
}
