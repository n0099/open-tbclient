package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class u implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TextureMapView a;

    public u(TextureMapView textureMapView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textureMapView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            acVar = this.a.b;
            float f = acVar.b().b;
            acVar2 = this.a.b;
            ab E = acVar2.b().E();
            float f2 = E.a - 1.0f;
            E.a = f2;
            if (f2 >= f) {
                f = f2;
            }
            E.a = f;
            BaiduMap.mapStatusReason |= 16;
            acVar3 = this.a.b;
            acVar3.b().a(E, 300);
        }
    }
}
