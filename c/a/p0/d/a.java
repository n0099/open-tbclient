package c.a.p0.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f13019a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f13020b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f13021c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f13022d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f13023e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f13024f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static int f13025g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static int f13026h = 5;

    /* renamed from: i  reason: collision with root package name */
    public static int f13027i = 6;

    /* renamed from: j  reason: collision with root package name */
    public static int f13028j = 7;
    public static int k = 8;
    public static int l = 9;
    public static b m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1884706382, "Lc/a/p0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1884706382, "Lc/a/p0/d/a;");
                return;
            }
        }
        m = new b();
    }

    public static void a(@NonNull int i2, @NonNull int i3, String str, String str2, String str3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i4)}) == null) {
            c cVar = new c();
            cVar.f13029a = i2;
            cVar.f13030b = i3;
            cVar.f13031c = str;
            cVar.f13032d = str2;
            cVar.f13033e = str3;
            cVar.f13034f = i4;
            m.a(cVar);
        }
    }
}
