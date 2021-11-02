package b.i.b.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f31849a;

    /* renamed from: b  reason: collision with root package name */
    public static final UUID f31850b;

    /* renamed from: c  reason: collision with root package name */
    public static final UUID f31851c;

    /* renamed from: d  reason: collision with root package name */
    public static final UUID f31852d;

    /* renamed from: e  reason: collision with root package name */
    public static final UUID f31853e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-332326189, "Lb/i/b/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-332326189, "Lb/i/b/a/b;");
                return;
            }
        }
        f31849a = b.i.b.a.i0.v.f32661a < 23 ? 1020 : 6396;
        f31850b = new UUID(0L, 0L);
        f31851c = new UUID(1186680826959645954L, -5988876978535335093L);
        new UUID(-2129748144642739255L, 8654423357094679310L);
        f31852d = new UUID(-1301668207276963122L, -6645017420763422227L);
        f31853e = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000 : invokeJ.longValue;
    }

    public static long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000 : invokeJ.longValue;
    }
}
