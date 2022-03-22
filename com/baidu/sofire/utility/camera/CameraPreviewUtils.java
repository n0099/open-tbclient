package com.baidu.sofire.utility.camera;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class CameraPreviewUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_PREVIEW_PIXELS = 2073600;
    public static final int MIN_PREVIEW_PIXELS = 307200;
    public static final String TAG = "CameraPreviewUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1743166005, "Lcom/baidu/sofire/utility/camera/CameraPreviewUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1743166005, "Lcom/baidu/sofire/utility/camera/CameraPreviewUtils;");
        }
    }

    public CameraPreviewUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Point getBestPreview(Camera.Parameters parameters, Point point) {
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
            Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.sofire.utility.camera.CameraPreviewUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public final int compare(Camera.Size size, Camera.Size size2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, size, size2)) == null) {
                        int i = size.height * size.width;
                        int i2 = size2.height * size2.width;
                        if (i2 < i) {
                            return -1;
                        }
                        return i2 > i ? 1 : 0;
                    }
                    return invokeLL2.intValue;
                }
            });
            int i = point.x;
            int i2 = point.y;
            if (i > i2) {
                d2 = i;
                d3 = i2;
            } else {
                d2 = i2;
                d3 = i;
            }
            double d4 = d2 / d3;
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
                    double abs = Math.abs((i3 > i4 ? i3 / i4 : i4 / i3) - d4);
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

    public static Point getBestVideoForSameSize(Camera.Parameters parameters, int i, int i2) {
        InterceptResult invokeLII;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, parameters, i, i2)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            ArrayList arrayList = new ArrayList();
            if (supportedVideoSizes != null && supportedPreviewSizes != null) {
                supportedVideoSizes.addAll(supportedPreviewSizes);
                if (i > i2) {
                    d2 = i;
                    d3 = i2;
                } else {
                    d2 = i2;
                    d3 = i;
                }
                double d4 = d2 / d3;
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
                Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.sofire.utility.camera.CameraPreviewUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public final int compare(Camera.Size size3, Camera.Size size4) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, size3, size4)) == null) {
                            int i4 = size3.height * size3.width;
                            int i5 = size4.height * size4.width;
                            if (i5 < i4) {
                                return 1;
                            }
                            return i5 > i4 ? -1 : 0;
                        }
                        return invokeLL.intValue;
                    }
                });
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
                        double abs = Math.abs((i4 > i5 ? i4 / i5 : i5 / i4) - d4);
                        if (abs < d5) {
                            point = new Point(size3.width, size3.height);
                            d5 = abs;
                        }
                    } else {
                        it.remove();
                    }
                }
                return point == null ? new Point(640, 480) : point;
            }
            return new Point(640, 480);
        }
        return (Point) invokeLII.objValue;
    }
}
