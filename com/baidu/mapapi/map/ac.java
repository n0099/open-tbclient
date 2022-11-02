package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ac implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TextureMapView a;

    public ac(TextureMapView textureMapView) {
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
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
            return;
        }
        mapTextureView = this.a.b;
        float zoomLevel = mapTextureView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        double d = zoomLevel;
        if (Math.floor(d) != d) {
            f = (float) Math.floor(d);
        }
        mapTextureView2 = this.a.b;
        float max = Math.max(f, mapTextureView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapTextureView3 = this.a.b;
        mapTextureView3.setZoomLevel(max);
    }
}
