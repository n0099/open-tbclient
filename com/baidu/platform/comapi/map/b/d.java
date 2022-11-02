package com.baidu.platform.comapi.map.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.IllegalFormatException;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public StringBuffer b;
    public StringBuffer c;
    public MapController d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final /* synthetic */ a[] i;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-795593822, "Lcom/baidu/platform/comapi/map/b/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-795593822, "Lcom/baidu/platform/comapi/map/b/d$a;");
                    return;
                }
            }
            a = new a("ZOOM_OUT", 0);
            b = new a("ZOOM_IN", 1);
            c = new a("FLING", 2);
            d = new a("MOVE", 3);
            e = new a("ROTATE", 4);
            f = new a("DOUBLE_CLICK_ZOOM_IN", 5);
            g = new a("TWO_CLICK_ZOOM_OUT", 6);
            a aVar = new a("MOVE_OVERLOOK", 7);
            h = aVar;
            i = new a[]{a, b, c, d, e, f, g, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) i.clone();
            }
            return (a[]) invokeV.objValue;
        }
    }

    public d(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new StringBuffer();
        this.c = new StringBuffer();
        this.d = mapController;
    }

    private void a(a aVar) {
        MapController mapController;
        MapViewInterface mapView;
        String b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, aVar) != null) || (mapController = this.d) == null || (mapView = mapController.getMapView()) == null) {
            return;
        }
        GeoPoint mapCenter = mapView.getMapCenter();
        try {
            b = String.format("(%s,%d,%d,%d,%d)", b(aVar), Double.valueOf(mapCenter.getLongitudeE6()), Double.valueOf(mapCenter.getLatitudeE6()), Integer.valueOf((int) mapView.getZoomLevel()), Long.valueOf(System.currentTimeMillis()));
        } catch (IllegalFormatException unused) {
            b = b(aVar);
        }
        StringBuffer stringBuffer = this.b;
        if (stringBuffer == null) {
            return;
        }
        stringBuffer.append(b);
        StringBuffer stringBuffer2 = this.c;
        if (stringBuffer2 == null) {
            return;
        }
        stringBuffer2.append(b(aVar));
    }

    private String b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            switch (e.a[aVar.ordinal()]) {
                case 1:
                case 2:
                    return "0";
                case 3:
                    return "1";
                case 4:
                    return "2";
                case 5:
                    return "3";
                case 6:
                    return "4";
                case 7:
                    return "5";
                case 8:
                    return "6";
                default:
                    return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f) == null) {
            this.a = f;
        }
    }

    private boolean e(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, this, f)) == null) {
            if (f > this.a) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    private boolean f(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65541, this, f)) == null) {
            if (f < this.a) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public void a(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            if (e(f)) {
                a(a.a);
            }
            if (f(f)) {
                a(a.b);
            }
            d(f);
        }
    }

    public void b(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            a(a.f);
            d(f);
        }
    }

    public void c(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            a(a.g);
            d(f);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(a.c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(a.d);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(a.e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a(a.h);
        }
    }
}
