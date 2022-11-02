package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class n implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MapStatus a;
    public final /* synthetic */ MapController.b b;

    public n(MapController.b bVar, MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, mapStatus};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bVar;
        this.a = mapStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoPoint geoPoint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b.a.getMapView() != null && this.b.a.getMapView().getProjection() != null) {
                geoPoint = this.b.a.i.get().getProjection().fromPixels(this.a.winRound.left + (this.b.a.getScreenWidth() / 2), this.a.winRound.top + (this.b.a.getScreenHeight() / 2));
            } else {
                geoPoint = null;
            }
            if (geoPoint != null) {
                float latitudeE6 = (float) geoPoint.getLatitudeE6();
                MapController.CleanAfterDBClick(this.b.a.u, (float) geoPoint.getLongitudeE6(), latitudeE6);
            }
            this.b.a.P = false;
        }
    }
}
