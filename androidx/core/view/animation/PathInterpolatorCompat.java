package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PathInterpolatorCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Interpolator create(Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, path)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new PathInterpolator(path);
            }
            return new PathInterpolatorApi14(path);
        }
        return (Interpolator) invokeL.objValue;
    }

    public static Interpolator create(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new PathInterpolator(f2, f3);
            }
            return new PathInterpolatorApi14(f2, f3);
        }
        return (Interpolator) invokeCommon.objValue;
    }

    public static Interpolator create(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new PathInterpolator(f2, f3, f4, f5);
            }
            return new PathInterpolatorApi14(f2, f3, f4, f5);
        }
        return (Interpolator) invokeCommon.objValue;
    }
}
