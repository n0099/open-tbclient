package c.a.b0.h0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f1552b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<Integer> f1553c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-329508030, "Lc/a/b0/h0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-329508030, "Lc/a/b0/h0/e;");
                return;
            }
        }
        a = new HashSet();
        f1552b = new HashSet();
        f1553c = new HashSet();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        f1552b.add(7);
        f1552b.add(1);
        f1553c.addAll(a);
        f1553c.addAll(f1552b);
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

    public static boolean b(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeCommon.booleanValue;
    }
}
