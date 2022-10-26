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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Interpolator create(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new PathInterpolator(f, f2);
            }
            return new PathInterpolatorApi14(f, f2);
        }
        return (Interpolator) invokeCommon.objValue;
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new PathInterpolator(f, f2, f3, f4);
            }
            return new PathInterpolatorApi14(f, f2, f3, f4);
        }
        return (Interpolator) invokeCommon.objValue;
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
}
