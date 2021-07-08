package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class n implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView f7180a;

    public n(MapView mapView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7180a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            jVar = this.f7180a.f7009e;
            float f2 = jVar.a().f7708a;
            jVar2 = this.f7180a.f7009e;
            ab E = jVar2.a().E();
            float f3 = E.f7661a + 1.0f;
            E.f7661a = f3;
            if (f3 <= f2) {
                f2 = f3;
            }
            E.f7661a = f2;
            BaiduMap.mapStatusReason |= 16;
            jVar3 = this.f7180a.f7009e;
            jVar3.a().a(E, 300);
        }
    }
}
