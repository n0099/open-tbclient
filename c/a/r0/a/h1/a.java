package c.a.r0.a.h1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.e0.d;
import c.a.r0.a.h1.c.a;
import c.a.r0.a.h1.c.b;
import c.a.r0.a.h1.c.c;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6963b;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.r0.a.h1.c.a> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(426009767, "Lc/a/r0/a/h1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(426009767, "Lc/a/r0/a/h1/a;");
                return;
            }
        }
        f6963b = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        e();
    }

    @Nullable
    public final c.a.r0.a.h1.c.b a(@NonNull String str, int i2, int i3, @NonNull String str2, @NonNull Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, obj})) == null) {
            b.a aVar = new b.a();
            aVar.e(str);
            aVar.g(i2);
            aVar.c(i3);
            aVar.b(str2);
            aVar.f(obj);
            c.a.r0.a.h1.c.b a = aVar.a();
            if (a == null) {
                if (f6963b) {
                    String str3 = "build branch(" + str + ") fail: " + aVar.d().getMessage();
                    return null;
                }
                return null;
            }
            return a;
        }
        return (c.a.r0.a.h1.c.b) invokeCommon.objValue;
    }

    @Nullable
    public final c b(int i2, @NonNull String str, @NonNull Object obj) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, obj)) == null) {
            c.a aVar = new c.a();
            aVar.e(i2);
            aVar.d(str);
            aVar.b(obj);
            c a = aVar.a();
            if (a == null) {
                if (f6963b) {
                    String str2 = "build switch(" + str + ") fail: " + aVar.c().getMessage();
                }
                return null;
            }
            return a;
        }
        return (c) invokeILL.objValue;
    }

    @NonNull
    public List<c.a.r0.a.h1.c.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Collections.unmodifiableList(this.a) : (List) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c b2 = b(3, "swan_local_first_installation_update_core_delay", 0L);
            if (b2 == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a("local_1000", 0, 20, "control group", 0L));
            arrayList.add(a("local_1001", 1, 20, "test group 1", 100L));
            arrayList.add(a("local_1002", 1, 20, "test group 2", 500L));
            arrayList.add(a("local_1003", 1, 20, "test group 3", 1000L));
            arrayList.add(a("local_1004", 1, 20, "test group 4", 2000L));
            a.C0412a c0412a = new a.C0412a();
            c0412a.c(b2);
            c0412a.a(arrayList);
            c.a.r0.a.h1.c.a b3 = c0412a.b();
            if (b3 == null) {
                return false;
            }
            return this.a.add(b3);
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && d()) {
            d.c("SwanLocalABTestAutoRegister", "test 'first install updateCore delay' register failed'");
        }
    }
}
