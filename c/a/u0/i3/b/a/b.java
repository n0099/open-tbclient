package c.a.u0.i3.b.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f18790e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public Point f18791b;

    /* renamed from: c  reason: collision with root package name */
    public Point f18792c;

    /* renamed from: d  reason: collision with root package name */
    public Point f18793d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922031755, "Lc/a/u0/i3/b/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922031755, "Lc/a/u0/i3/b/a/b;");
                return;
            }
        }
        f18790e = Pattern.compile(",");
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static boolean a(Camera camera) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, camera)) == null) ? f(camera.getParameters().getSupportedFocusModes(), "auto") != null : invokeL.booleanValue;
    }

    public static int d(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, charSequence, i2)) == null) {
            int i3 = 0;
            for (String str : f18790e.split(charSequence)) {
                try {
                    double parseDouble = Double.parseDouble(str.trim());
                    int i4 = (int) (10.0d * parseDouble);
                    if (Math.abs(i2 - parseDouble) < Math.abs(i2 - i3)) {
                        i3 = i4;
                    }
                } catch (NumberFormatException unused) {
                    return i2;
                }
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public static Point e(List<Camera.Size> list, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, point)) == null) {
            Iterator<Camera.Size> it = list.iterator();
            int i2 = 0;
            int i3 = 0;
            int i4 = Integer.MAX_VALUE;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                int i5 = next.width;
                int i6 = next.height;
                int abs = Math.abs(i5 - point.x) + Math.abs(i6 - point.y);
                if (abs == 0) {
                    i3 = i6;
                    i2 = i5;
                    break;
                } else if (abs < i4) {
                    i3 = i6;
                    i2 = i5;
                    i4 = abs;
                }
            }
            if (i2 <= 0 || i3 <= 0) {
                return null;
            }
            return new Point(i2, i3);
        }
        return (Point) invokeLL.objValue;
    }

    public static String f(Collection<String> collection, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, collection, strArr)) == null) {
            if (collection != null) {
                for (String str : strArr) {
                    if (collection.contains(str)) {
                        return str;
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static Point i(Camera.Parameters parameters, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, parameters, point)) == null) {
            Point e2 = e(parameters.getSupportedPreviewSizes(), point);
            return e2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : e2;
        }
        return (Point) invokeLL.objValue;
    }

    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, camera) == null) {
            c(camera, false);
        }
    }

    public final void c(Camera camera, boolean z) {
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera, z) == null) {
            Camera.Parameters parameters = camera.getParameters();
            if (z) {
                f2 = f(parameters.getSupportedFlashModes(), "torch", DebugKt.DEBUG_PROPERTY_VALUE_ON);
            } else {
                f2 = f(parameters.getSupportedFlashModes(), DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            if (f2 != null) {
                parameters.setFlashMode(f2);
            }
            camera.setParameters(parameters);
        }
    }

    public Point g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18792c : (Point) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i2 = 0;
            Camera.getCameraInfo(0, cameraInfo);
            int rotation = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i2) + 360) % 360;
        }
        return invokeV.intValue;
    }

    public void j(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, camera) == null) {
            Camera.Parameters parameters = camera.getParameters();
            if (a(camera)) {
                parameters.setFocusMode("auto");
            }
            this.f18791b = a.d(this.a);
            Point point = new Point();
            Point point2 = this.f18791b;
            point.x = point2.x;
            point.y = point2.y;
            int c2 = a.c(this.a);
            if (c2 == 0) {
                Point point3 = this.f18791b;
                point.x = point3.y;
                point.y = point3.x;
            }
            Point i2 = i(parameters, point);
            this.f18793d = i2;
            if (c2 == 0) {
                Point point4 = this.f18793d;
                this.f18792c = new Point(point4.y, point4.x);
                return;
            }
            this.f18792c = i2;
        }
    }

    public void k(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, camera) == null) {
            c(camera, true);
        }
    }

    public void l(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, camera) == null) {
            Camera.Parameters parameters = camera.getParameters();
            Point point = this.f18793d;
            parameters.setPreviewSize(point.x, point.y);
            m(parameters);
            camera.setDisplayOrientation(h());
            camera.setParameters(parameters);
        }
    }

    public final void m(Camera.Parameters parameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, parameters) == null) {
            String str = parameters.get("zoom-supported");
            if (str == null || Boolean.parseBoolean(str)) {
                int i2 = 27;
                String str2 = parameters.get("max-zoom");
                if (str2 != null) {
                    try {
                        int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                        if (27 > parseDouble) {
                            i2 = parseDouble;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                String str3 = parameters.get("taking-picture-zoom-max");
                if (str3 != null) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (i2 > parseInt) {
                            i2 = parseInt;
                        }
                    } catch (NumberFormatException unused2) {
                    }
                }
                String str4 = parameters.get("mot-zoom-values");
                if (str4 != null) {
                    i2 = d(str4, i2);
                }
                String str5 = parameters.get("mot-zoom-step");
                if (str5 != null) {
                    try {
                        int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                        if (parseDouble2 > 1) {
                            i2 -= i2 % parseDouble2;
                        }
                    } catch (NumberFormatException unused3) {
                    }
                }
                if (str2 != null || str4 != null) {
                    parameters.set("zoom", String.valueOf(i2 / 10.0d));
                }
                if (str3 != null) {
                    parameters.set("taking-picture-zoom", i2);
                }
            }
        }
    }
}
