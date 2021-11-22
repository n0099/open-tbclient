package com.baidu.mapapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements InfoWindow.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f40400a;

    public b(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40400a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void a(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, infoWindow) == null) {
            this.f40400a.hideInfoWindow(infoWindow);
        }
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void b(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, infoWindow) == null) {
            this.f40400a.a(infoWindow);
        }
    }
}
