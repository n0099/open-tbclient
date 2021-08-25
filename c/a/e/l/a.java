package c.a.e.l;

import android.view.animation.Interpolator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f2936a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class animation.InterpolatorC0048a implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public animation.InterpolatorC0048a() {
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

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
            return invokeF.floatValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1500205363, "Lc/a/e/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1500205363, "Lc/a/e/l/a;");
                return;
            }
        }
        f2936a = new animation.InterpolatorC0048a();
    }

    public static int a(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        float interpolation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (z) {
                interpolation = f2 - (f2936a.getInterpolation(f3 / (f3 - f2)) * f2);
            } else {
                interpolation = f2 * f2936a.getInterpolation(f3 / f2);
            }
            return (int) interpolation;
        }
        return invokeCommon.intValue;
    }
}
