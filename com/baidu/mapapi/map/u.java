package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
/* loaded from: classes2.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextureMapView f7150a;

    public u(TextureMapView textureMapView) {
        this.f7150a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        acVar = this.f7150a.f7071b;
        float f2 = acVar.b().f7662b;
        acVar2 = this.f7150a.f7071b;
        ab E = acVar2.b().E();
        float f3 = E.f7614a - 1.0f;
        E.f7614a = f3;
        if (f3 >= f2) {
            f2 = f3;
        }
        E.f7614a = f2;
        BaiduMap.mapStatusReason |= 16;
        acVar3 = this.f7150a.f7071b;
        acVar3.b().a(E, 300);
    }
}
