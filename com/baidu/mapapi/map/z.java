package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WearMapView f7216a;

    public z(WearMapView wearMapView) {
        this.f7216a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        jVar = this.f7216a.f7160f;
        ab E = jVar.a().E();
        E.f7671a += 1.0f;
        jVar2 = this.f7216a.f7160f;
        jVar2.a().a(E, 300);
    }
}
