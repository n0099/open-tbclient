package b.a.q0.x.w.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14251a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f14252b = 50;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1825112421, "Lb/a/q0/x/w/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1825112421, "Lb/a/q0/x/w/d/c;");
        }
    }

    public static synchronized int a(Context context) {
        InterceptResult invokeL;
        int i2;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (c.class) {
                if (!f14251a && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                    f14252b = dimensionPixelSize;
                    f14251a = true;
                    String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize));
                }
                i2 = f14252b;
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
