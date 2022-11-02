package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.al;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class r implements al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MapView a;

    @Override // com.baidu.platform.comapi.map.al
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xVar) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(GeoPoint geoPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, geoPoint) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gl10, xVar) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, point, point2, xVar)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, point, xVar)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2), xVar})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xVar) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b(GeoPoint geoPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, geoPoint) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, point, point2, xVar)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(GeoPoint geoPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, geoPoint) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, point, point2, xVar)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void d(GeoPoint geoPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, geoPoint) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, point, point2, xVar)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void e(GeoPoint geoPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, geoPoint) == null) {
        }
    }

    public r(MapView mapView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mapView;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        MapSurfaceView mapSurfaceView4;
        MapSurfaceView mapSurfaceView5;
        MapSurfaceView mapSurfaceView6;
        float f;
        SparseIntArray sparseIntArray;
        MapSurfaceView mapSurfaceView7;
        ImageView imageView;
        String format;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        MapSurfaceView mapSurfaceView8;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, xVar) != null) {
            return;
        }
        mapSurfaceView = this.a.e;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView2 = this.a.e;
        if (mapSurfaceView2.getController() == null) {
            return;
        }
        mapSurfaceView3 = this.a.e;
        float zoomLevel = mapSurfaceView3.getZoomLevel();
        mapSurfaceView4 = this.a.e;
        if (zoomLevel < mapSurfaceView4.getController().mMinZoomLevel) {
            mapSurfaceView8 = this.a.e;
            zoomLevel = mapSurfaceView8.getController().mMinZoomLevel;
        } else {
            mapSurfaceView5 = this.a.e;
            if (zoomLevel > mapSurfaceView5.getController().mMaxZoomLevel) {
                mapSurfaceView6 = this.a.e;
                zoomLevel = mapSurfaceView6.getController().mMaxZoomLevel;
            }
        }
        f = this.a.u;
        if (Math.abs(f - zoomLevel) > 0.0f) {
            sparseIntArray = MapView.q;
            int i = sparseIntArray.get(Math.round(zoomLevel));
            mapSurfaceView7 = this.a.e;
            int zoomUnitsInMeter = (int) (i / mapSurfaceView7.getController().getZoomUnitsInMeter());
            imageView = this.a.o;
            if (imageView != null) {
                imageView2 = this.a.o;
                int i2 = zoomUnitsInMeter / 2;
                imageView2.setPadding(i2, 0, i2, 0);
            }
            if (i >= 1000) {
                format = String.format(" %d公里 ", Integer.valueOf(i / 1000));
            } else {
                format = String.format(" %d米 ", Integer.valueOf(i));
            }
            textView = this.a.m;
            if (textView != null) {
                textView4 = this.a.m;
                textView4.setText(format);
            }
            textView2 = this.a.n;
            if (textView2 != null) {
                textView3 = this.a.n;
                textView3.setText(format);
            }
            this.a.u = zoomLevel;
        }
        this.a.b();
        this.a.requestLayout();
    }
}
