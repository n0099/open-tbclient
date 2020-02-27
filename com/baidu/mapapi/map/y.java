package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ WearMapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WearMapView wearMapView) {
        this.a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        jVar = this.a.e;
        ab E = jVar.a().E();
        E.a += 1.0f;
        jVar2 = this.a.e;
        jVar2.a().a(E, 300);
    }
}
