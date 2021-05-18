package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WearMapView f7215a;

    public y(WearMapView wearMapView) {
        this.f7215a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        jVar = this.f7215a.f7160f;
        ab E = jVar.a().E();
        E.f7671a -= 1.0f;
        jVar2 = this.f7215a.f7160f;
        jVar2.a().a(E, 300);
    }
}
