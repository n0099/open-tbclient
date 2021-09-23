package c.i.b.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f32992a;

    /* renamed from: b  reason: collision with root package name */
    public static final UUID f32993b;

    /* renamed from: c  reason: collision with root package name */
    public static final UUID f32994c;

    /* renamed from: d  reason: collision with root package name */
    public static final UUID f32995d;

    /* renamed from: e  reason: collision with root package name */
    public static final UUID f32996e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-528839694, "Lc/i/b/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-528839694, "Lc/i/b/a/b;");
                return;
            }
        }
        f32992a = c.i.b.a.i0.v.f33861a < 23 ? 1020 : 6396;
        f32993b = new UUID(0L, 0L);
        f32994c = new UUID(1186680826959645954L, -5988876978535335093L);
        new UUID(-2129748144642739255L, 8654423357094679310L);
        f32995d = new UUID(-1301668207276963122L, -6645017420763422227L);
        f32996e = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000 : invokeJ.longValue;
    }

    public static long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000 : invokeJ.longValue;
    }
}
