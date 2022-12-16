package com.baidu.sofire.face.c;

import android.graphics.Point;
import android.hardware.Camera;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.sofire.face.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0185a implements Comparator<Camera.Size> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0185a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, size, size2)) == null) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i = size3.height * size3.width;
                int i2 = size4.height * size4.width;
                if (i2 < i) {
                    return -1;
                }
                if (i2 > i) {
                    return 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Comparator<Camera.Size> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, size, size2)) == null) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i = size3.height * size3.width;
                int i2 = size4.height * size4.width;
                if (i2 < i) {
                    return 1;
                }
                if (i2 > i) {
                    return -1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    public static Point a(Camera.Parameters parameters, int i, int i2) {
        InterceptResult invokeLII;
        double d;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, parameters, i, i2)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            ArrayList arrayList = new ArrayList();
            if (supportedVideoSizes != null && supportedPreviewSizes != null) {
                supportedVideoSizes.addAll(supportedPreviewSizes);
                if (i > i2) {
                    d = i;
                    d2 = i2;
                } else {
                    d = i2;
                    d2 = i;
                }
                double d4 = d / d2;
                HashMap hashMap = new HashMap();
                for (Camera.Size size : supportedVideoSizes) {
                    int i3 = 0;
                    if (hashMap.get(size) != null) {
                        i3 = ((Integer) hashMap.get(size)).intValue() + 1;
                    }
                    hashMap.put(size, Integer.valueOf(i3));
                }
                for (Camera.Size size2 : hashMap.keySet()) {
                    if (hashMap.get(size2) != null && ((Integer) hashMap.get(size2)).intValue() > 0) {
                        arrayList.add(size2);
                    }
                }
                Collections.sort(arrayList, new b());
                Iterator it = arrayList.iterator();
                Point point = null;
                double d5 = Double.MAX_VALUE;
                while (it.hasNext()) {
                    Camera.Size size3 = (Camera.Size) it.next();
                    int i4 = size3.width;
                    int i5 = size3.height;
                    int i6 = i4 * i5;
                    if (i6 < 307200) {
                        it.remove();
                    } else if (i6 > 2073600) {
                        it.remove();
                    } else if (i5 % 2 == 0 && i4 % 2 == 0) {
                        if (i4 > i5) {
                            d3 = i4 / i5;
                        } else {
                            d3 = i5 / i4;
                        }
                        double abs = Math.abs(d3 - d4);
                        if (abs < d5) {
                            point = new Point(size3.width, size3.height);
                            d5 = abs;
                        }
                    } else {
                        it.remove();
                    }
                }
                if (point == null) {
                    return new Point(640, 480);
                }
                return point;
            }
            return new Point(640, 480);
        }
        return (Point) invokeLII.objValue;
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        InterceptResult invokeLL;
        double d;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, parameters, point)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null) {
                parameters.getPreviewSize();
                return new Point(640, 480);
            }
            ArrayList arrayList = new ArrayList(supportedPreviewSizes);
            Collections.sort(arrayList, new C0185a());
            int i = point.x;
            int i2 = point.y;
            if (i > i2) {
                d = i;
                d2 = i2;
            } else {
                d = i2;
                d2 = i;
            }
            double d4 = d / d2;
            Camera.Size size = null;
            Iterator it = arrayList.iterator();
            double d5 = -1.0d;
            while (it.hasNext()) {
                Camera.Size size2 = (Camera.Size) it.next();
                int i3 = size2.width;
                int i4 = size2.height;
                int i5 = i3 * i4;
                if (i5 < 307200) {
                    it.remove();
                } else if (i5 > 2073600) {
                    it.remove();
                } else if (i4 % 4 == 0 && i3 % 4 == 0) {
                    if (i3 > i4) {
                        d3 = i3 / i4;
                    } else {
                        d3 = i4 / i3;
                    }
                    double abs = Math.abs(d3 - d4);
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
