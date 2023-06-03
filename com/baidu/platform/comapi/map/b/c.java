package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c implements a.InterfaceC0134a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b a;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    @Override // com.baidu.platform.comapi.map.b.a.a.InterfaceC0134a
    public boolean a(com.baidu.platform.comapi.map.b.a.a aVar) {
        InterceptResult invokeL;
        MapController mapController;
        MapController mapController2;
        MapController mapController3;
        MapController mapController4;
        MapController mapController5;
        MapController mapController6;
        MapController mapController7;
        MapController mapController8;
        MapController mapController9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            mapController = this.a.b;
            if (mapController.isTwoTouchClickZoomEnabled()) {
                mapController2 = this.a.b;
                mapController2.setActingTwoClickZoom(true);
                mapController3 = this.a.b;
                d gestureMonitor = mapController3.getGestureMonitor();
                mapController4 = this.a.b;
                gestureMonitor.c(mapController4.getZoomLevel() - 1.0f);
                mapController5 = this.a.b;
                mapController5.mapStatusChangeStart();
                mapController6 = this.a.b;
                mapController6.MapMsgProc(8193, 4, 0);
                mapController7 = this.a.b;
                if (mapController7.isNaviMode()) {
                    mapController8 = this.a.b;
                    if (mapController8.getNaviMapViewListener() != null) {
                        mapController9 = this.a.b;
                        mapController9.getNaviMapViewListener().onAction(521, null);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
