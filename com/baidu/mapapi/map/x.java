package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WearMapView f2818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WearMapView wearMapView) {
        this.f2818a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        jVar = this.f2818a.e;
        ab E = jVar.a().E();
        E.f3040a -= 1.0f;
        jVar2 = this.f2818a.e;
        jVar2.a().a(E, 300);
    }
}
