package com.baidu.platform.comapi.walknavi;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements WalkNaviModeSwitchListener {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, int i, boolean z) {
        this.c = bVar;
        this.a = i;
        this.b = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onSuccess() {
        com.baidu.platform.comapi.wnplatform.n.a aVar;
        com.baidu.platform.comapi.wnplatform.n.a aVar2;
        com.baidu.platform.comapi.wnplatform.n.a aVar3;
        this.c.F = this.a;
        aVar = this.c.p;
        if (aVar != null) {
            aVar2 = this.c.p;
            if (aVar2 instanceof com.baidu.platform.comapi.walknavi.g.a) {
                aVar3 = this.c.p;
                ((com.baidu.platform.comapi.walknavi.g.a) aVar3).a(this.a, this.b);
            }
        }
        if (this.a == 1) {
            b.a().d(0);
        } else if (this.a == 2) {
            new Handler(Looper.myLooper()).postDelayed(new f(this), 100L);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onFailed() {
        Log.d("ContentValues", "onWalkNaviModeChange onFailed");
    }
}
