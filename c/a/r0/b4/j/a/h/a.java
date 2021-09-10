package c.a.r0.b4.j.a.h;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.c;
import c.a.x0.t.v;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-914042650, "Lc/a/r0/b4/j/a/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-914042650, "Lc/a/r0/b4/j/a/h/a;");
        }
    }

    public static int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? i2 > i4 ? i4 : i2 < i3 ? i3 : i2 : invokeIII.intValue;
    }

    public static int b(TbPageContext tbPageContext, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, tbPageContext, i2)) == null) {
            int i4 = 0;
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                int d2 = d(tbPageContext);
                if (cameraInfo.facing == 1) {
                    i4 = (cameraInfo.orientation + d2) % 360;
                    i3 = (360 - i4) % 360;
                } else {
                    i3 = ((cameraInfo.orientation - d2) + 360) % 360;
                }
                return i3;
            } catch (RuntimeException e2) {
                c.g(e2);
                return i4;
            }
        }
        return invokeLI.intValue;
    }

    public static int c(Camera.Parameters parameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parameters)) == null) {
            if (parameters == null) {
                return -1;
            }
            try {
                if (parameters.isZoomSupported()) {
                    return Math.min(parameters.getMaxZoom(), 40);
                }
                return -1;
            } catch (Exception e2) {
                c.g(e2);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int d(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            int rotation = tbPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        return rotation != 3 ? 0 : 270;
                    }
                    return 180;
                }
                return 90;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(TbPageContext tbPageContext, int i2, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, tbPageContext, i2, matrix) == null) || matrix == null) {
            return;
        }
        matrix.setScale(1 == i2 ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(b(tbPageContext, i2));
        matrix.postScale(v.e() / 2000.0f, v.d() / 2000.0f);
        matrix.postTranslate(v.e() / 2.0f, v.d() / 2.0f);
    }

    public static void f(RectF rectF, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, rectF, rect) == null) {
            rect.left = Math.round(rectF.left);
            rect.top = Math.round(rectF.top);
            rect.right = Math.round(rectF.right);
            rect.bottom = Math.round(rectF.bottom);
        }
    }

    public static void g(int i2, int i3, Camera camera) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65543, null, i2, i3, camera) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i3, cameraInfo);
            int i5 = 0;
            if (i2 != 0) {
                if (i2 == 1) {
                    i5 = 90;
                } else if (i2 == 2) {
                    i5 = 180;
                } else if (i2 == 3) {
                    i5 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                i4 = (360 - ((cameraInfo.orientation + i5) % 360)) % 360;
            } else {
                i4 = ((cameraInfo.orientation - i5) + 360) % 360;
            }
            camera.setDisplayOrientation(i4);
        }
    }

    public static void h(TbPageContext tbPageContext, int i2, Camera camera) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, tbPageContext, i2, camera) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            int d2 = d(tbPageContext);
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + d2) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - d2) + 360) % 360;
            }
            camera.setDisplayOrientation(i3);
        }
    }
}
