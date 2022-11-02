package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.al;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class ab implements al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TextureMapView a;

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

    public ab(TextureMapView textureMapView) {
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

    @Override // com.baidu.platform.comapi.map.al
    public void c(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        MapTextureView mapTextureView4;
        MapTextureView mapTextureView5;
        MapTextureView mapTextureView6;
        float f;
        SparseArray sparseArray;
        MapTextureView mapTextureView7;
        ImageView imageView;
        String format;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        MapTextureView mapTextureView8;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, xVar) != null) {
            return;
        }
        mapTextureView = this.a.b;
        if (mapTextureView == null) {
            return;
        }
        mapTextureView2 = this.a.b;
        if (mapTextureView2.getController() == null) {
            return;
        }
        mapTextureView3 = this.a.b;
        float zoomLevel = mapTextureView3.getZoomLevel();
        mapTextureView4 = this.a.b;
        if (zoomLevel < mapTextureView4.getController().mMinZoomLevel) {
            mapTextureView8 = this.a.b;
            zoomLevel = mapTextureView8.getController().mMinZoomLevel;
        } else {
            mapTextureView5 = this.a.b;
            if (zoomLevel > mapTextureView5.getController().mMaxZoomLevel) {
                mapTextureView6 = this.a.b;
                zoomLevel = mapTextureView6.getController().mMaxZoomLevel;
            }
        }
        f = this.a.r;
        if (Math.abs(f - zoomLevel) > 0.0f) {
            sparseArray = TextureMapView.q;
            int intValue = ((Integer) sparseArray.get(Math.round(zoomLevel))).intValue();
            mapTextureView7 = this.a.b;
            int zoomUnitsInMeter = (int) (intValue / mapTextureView7.getController().getZoomUnitsInMeter());
            imageView = this.a.o;
            if (imageView != null) {
                imageView2 = this.a.o;
                int i = zoomUnitsInMeter / 2;
                imageView2.setPadding(i, 0, i, 0);
            }
            if (intValue >= 1000) {
                format = String.format(" %d公里 ", Integer.valueOf(intValue / 1000));
            } else {
                format = String.format(" %d米 ", Integer.valueOf(intValue));
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
            this.a.r = zoomLevel;
        }
        this.a.b();
        this.a.requestLayout();
    }
}
