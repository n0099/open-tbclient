package com.baidu.platform.comapi.walknavi;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class j implements WalkNaviModeSwitchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3081a;
    final /* synthetic */ boolean b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, int i, boolean z) {
        this.c = bVar;
        this.f3081a = i;
        this.b = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onSuccess() {
        com.baidu.platform.comapi.wnplatform.o.a aVar;
        com.baidu.platform.comapi.wnplatform.o.a aVar2;
        com.baidu.platform.comapi.wnplatform.o.a aVar3;
        this.c.T = this.f3081a;
        aVar = this.c.p;
        if (aVar != null) {
            aVar2 = this.c.p;
            if (aVar2 instanceof com.baidu.platform.comapi.walknavi.g.a) {
                aVar3 = this.c.p;
                ((com.baidu.platform.comapi.walknavi.g.a) aVar3).a(this.f3081a, this.b);
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
