package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class v implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextureMapView f7181a;

    public v(TextureMapView textureMapView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textureMapView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7181a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            acVar = this.f7181a.f7101b;
            float f2 = acVar.b().f7691a;
            acVar2 = this.f7181a.f7101b;
            ab E = acVar2.b().E();
            float f3 = E.f7644a + 1.0f;
            E.f7644a = f3;
            if (f3 <= f2) {
                f2 = f3;
            }
            E.f7644a = f2;
            BaiduMap.mapStatusReason |= 16;
            acVar3 = this.f7181a.f7101b;
            acVar3.b().a(E, 300);
        }
    }
}
