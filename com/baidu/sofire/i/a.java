package com.baidu.sofire.i;

import android.graphics.Point;
import android.hardware.Camera;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f44037a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2074199279, "Lcom/baidu/sofire/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2074199279, "Lcom/baidu/sofire/i/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        InterceptResult invokeLL;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, parameters, point)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null) {
                parameters.getPreviewSize();
                return new Point(640, 480);
            }
            ArrayList arrayList = new ArrayList(supportedPreviewSizes);
            Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.sofire.i.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                    Camera.Size size3 = size;
                    Camera.Size size4 = size2;
                    int i2 = size3.height * size3.width;
                    int i3 = size4.height * size4.width;
                    if (i3 < i2) {
                        return -1;
                    }
                    return i3 > i2 ? 1 : 0;
                }
            });
            int i2 = point.x;
            int i3 = point.y;
            if (i2 > i3) {
                d2 = i2;
                d3 = i3;
            } else {
                d2 = i3;
                d3 = i2;
            }
            double d4 = d2 / d3;
            Camera.Size size = null;
            Iterator it = arrayList.iterator();
            double d5 = -1.0d;
            while (it.hasNext()) {
                Camera.Size size2 = (Camera.Size) it.next();
                int i4 = size2.width;
                int i5 = size2.height;
                int i6 = i4 * i5;
                if (i6 < 307200) {
                    it.remove();
                } else if (i6 > 2073600) {
                    it.remove();
                } else if (i5 % 4 == 0 && i4 % 4 == 0) {
                    double abs = Math.abs((i4 > i5 ? i4 / i5 : i5 / i4) - d4);
                    boolean z = false;
                    if ((d5 == -1.0d && abs <= 0.25d) || (d5 >= abs && abs <= 0.25d)) {
                        z = true;
                    }
                    if (z) {
                        size = size2;
                        d5 = abs;
                    }
                } else {
                    it.remove();
                }
            }
            if (size != null) {
                return new Point(size.width, size.height);
            }
            parameters.getPreviewSize();
            return new Point(640, 480);
        }
        return (Point) invokeLL.objValue;
    }
}
