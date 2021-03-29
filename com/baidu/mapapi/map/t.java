package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
/* loaded from: classes2.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextureMapView f7098a;

    public t(TextureMapView textureMapView) {
        this.f7098a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        acVar = this.f7098a.f7024b;
        float f2 = acVar.b().f7614b;
        acVar2 = this.f7098a.f7024b;
        ab E = acVar2.b().E();
        float f3 = E.f7570a - 1.0f;
        E.f7570a = f3;
        if (f3 >= f2) {
            f2 = f3;
        }
        E.f7570a = f2;
        BaiduMap.mapStatusReason |= 16;
        acVar3 = this.f7098a.f7024b;
        acVar3.b().a(E, 300);
    }
}
