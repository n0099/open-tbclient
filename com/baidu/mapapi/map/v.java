package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
/* loaded from: classes2.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextureMapView f7108a;

    public v(TextureMapView textureMapView) {
        this.f7108a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        acVar = this.f7108a.f7028b;
        float f2 = acVar.b().f7618a;
        acVar2 = this.f7108a.f7028b;
        ab E = acVar2.b().E();
        float f3 = E.f7571a + 1.0f;
        E.f7571a = f3;
        if (f3 <= f2) {
            f2 = f3;
        }
        E.f7571a = f2;
        BaiduMap.mapStatusReason |= 16;
        acVar3 = this.f7108a.f7028b;
        acVar3.b().a(E, 300);
    }
}
