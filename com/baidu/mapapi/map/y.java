package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WearMapView f2084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WearMapView wearMapView) {
        this.f2084a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        jVar = this.f2084a.e;
        ab E = jVar.a().E();
        E.f2214a += 1.0f;
        jVar2 = this.f2084a.e;
        jVar2.a().a(E, 300);
    }
}
