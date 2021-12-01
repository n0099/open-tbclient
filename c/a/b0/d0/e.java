package c.a.b0.d0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f1434b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<Integer> f1435c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-333202114, "Lc/a/b0/d0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-333202114, "Lc/a/b0/d0/e;");
                return;
            }
        }
        a = new HashSet();
        f1434b = new HashSet();
        f1435c = new HashSet();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        f1434b.add(7);
        f1434b.add(1);
        f1435c.addAll(a);
        f1435c.addAll(f1434b);
    }

    public static String a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return "";
            }
            int i3 = i2 / 3600;
            int i4 = (i2 % 3600) / 60;
            int i5 = i2 % 60;
            return (i3 != 0 || z) ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
        }
        return (String) invokeCommon.objValue;
    }
}
