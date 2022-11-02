package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ai implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WearMapView a;

    public ai(WearMapView wearMapView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wearMapView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
            return;
        }
        mapSurfaceView = this.a.f;
        com.baidu.mapsdkplatform.comapi.map.x D = mapSurfaceView.getBaseMap().D();
        D.a -= 1.0f;
        mapSurfaceView2 = this.a.f;
        mapSurfaceView2.getBaseMap().a(D, 300);
    }
}
