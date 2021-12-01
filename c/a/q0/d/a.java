package c.a.q0.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f11799b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f11800c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f11801d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f11802e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f11803f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static int f11804g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static int f11805h = 5;

    /* renamed from: i  reason: collision with root package name */
    public static int f11806i = 6;

    /* renamed from: j  reason: collision with root package name */
    public static int f11807j = 7;

    /* renamed from: k  reason: collision with root package name */
    public static int f11808k = 8;
    public static int l = 9;
    public static b m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522757233, "Lc/a/q0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1522757233, "Lc/a/q0/d/a;");
                return;
            }
        }
        m = new b();
    }

    public static void a(@NonNull int i2, @NonNull int i3, String str, String str2, String str3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i4)}) == null) {
            c cVar = new c();
            cVar.a = i2;
            cVar.f11809b = i3;
            cVar.f11810c = str;
            cVar.f11811d = str2;
            cVar.f11812e = str3;
            cVar.f11813f = i4;
            m.a(cVar);
        }
    }
}
