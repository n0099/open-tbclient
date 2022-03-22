package androidx.core.view;

import android.os.Build;
import android.view.ScaleGestureDetector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScaleGestureDetectorCompat() {
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

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? isQuickScaleEnabled((ScaleGestureDetector) obj) : invokeL.booleanValue;
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, z) == null) {
            setQuickScaleEnabled((ScaleGestureDetector) obj, z);
        }
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, scaleGestureDetector)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return scaleGestureDetector.isQuickScaleEnabled();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, scaleGestureDetector, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        scaleGestureDetector.setQuickScaleEnabled(z);
    }
}
