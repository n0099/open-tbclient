package c.a.o0.c;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f9867b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f9868c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f9869d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f9870e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f9871f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static int f9872g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static int f9873h = 5;
    public static int i = 6;
    public static int j = 7;
    public static int k = 8;
    public static int l = 9;
    public static b m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997172910, "Lc/a/o0/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997172910, "Lc/a/o0/c/a;");
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
            cVar.f9874b = i3;
            cVar.f9875c = str;
            cVar.f9876d = str2;
            cVar.f9877e = str3;
            cVar.f9878f = i4;
            m.a(cVar);
        }
    }
}
