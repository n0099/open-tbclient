package com.baidu.platform.comapi.walknavi;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class j implements WalkNaviModeSwitchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4577a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f4578b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, int i, boolean z) {
        this.c = bVar;
        this.f4577a = i;
        this.f4578b = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onSuccess() {
        com.baidu.platform.comapi.wnplatform.o.a aVar;
        com.baidu.platform.comapi.wnplatform.o.a aVar2;
        com.baidu.platform.comapi.wnplatform.o.a aVar3;
        this.c.T = this.f4577a;
        aVar = this.c.p;
        if (aVar != null) {
            aVar2 = this.c.p;
            if (aVar2 instanceof com.baidu.platform.comapi.walknavi.g.a) {
                aVar3 = this.c.p;
                ((com.baidu.platform.comapi.walknavi.g.a) aVar3).a(this.f4577a, this.f4578b);
            }
        }
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            b.a().f(0);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            new Handler(Looper.myLooper()).postDelayed(new k(this), 100L);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onFailed() {
        Log.d("ContentValues", "onWalkNaviModeChange onFailed");
    }
}
