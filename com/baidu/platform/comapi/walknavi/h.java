package com.baidu.platform.comapi.walknavi;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class h implements WalkNaviModeSwitchListener {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, int i, boolean z) {
        this.c = bVar;
        this.a = i;
        this.b = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onSuccess() {
        com.baidu.platform.comapi.wnplatform.n.a aVar;
        com.baidu.platform.comapi.wnplatform.n.a aVar2;
        com.baidu.platform.comapi.wnplatform.n.a aVar3;
        this.c.P = this.a;
        aVar = this.c.p;
        if (aVar != null) {
            aVar2 = this.c.p;
            if (aVar2 instanceof com.baidu.platform.comapi.walknavi.g.a) {
                aVar3 = this.c.p;
                ((com.baidu.platform.comapi.walknavi.g.a) aVar3).a(this.a, this.b);
            }
        }
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            b.a().e(0);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            new Handler(Looper.myLooper()).postDelayed(new i(this), 100L);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onFailed() {
        Log.d("ContentValues", "onWalkNaviModeChange onFailed");
    }
}
