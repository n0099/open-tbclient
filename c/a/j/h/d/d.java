package c.a.j.h.d;

import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final DisplayMetrics a;

    /* renamed from: b  reason: collision with root package name */
    public static final float f3619b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1421339092, "Lc/a/j/h/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1421339092, "Lc/a/j/h/d/d;");
                return;
            }
        }
        DisplayMetrics displayMetrics = c.a.j.h.b.b.f3530c.h().getAppContext().getResources().getDisplayMetrics();
        a = displayMetrics;
        f3619b = displayMetrics.density;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int identifier = c.a.j.h.b.b.f3530c.h().getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int i2 = 0;
            if (identifier > 0) {
                try {
                    i2 = c.a.j.h.b.b.f3530c.h().getAppContext().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (f3619b * 25.0f) : i2;
        }
        return invokeV.intValue;
    }
}
