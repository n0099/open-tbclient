package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WearMapView f7106a;

    public y(WearMapView wearMapView) {
        this.f7106a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        jVar = this.f7106a.f7053e;
        ab E = jVar.a().E();
        E.f7569a += 1.0f;
        jVar2 = this.f7106a.f7053e;
        jVar2.a().a(E, 300);
    }
}
