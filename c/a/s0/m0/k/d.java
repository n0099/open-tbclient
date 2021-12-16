package c.a.s0.m0.k;

import c.b.a.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final d a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.b.a.a.g f19372b;

    /* renamed from: c  reason: collision with root package name */
    public static final Class<? extends c.a.s0.m0.f.c.a>[] f19373c;

    /* renamed from: d  reason: collision with root package name */
    public static final c.b.a.a.g f19374d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2027645029, "Lc/a/s0/m0/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2027645029, "Lc/a/s0/m0/k/d;");
                return;
            }
        }
        a = new d();
        c.b.a.a.g b2 = c.b.a.a.g.d(c.a.s0.m0.f.d.b.class).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(ItemDataComponent::class.java).get()");
        f19372b = b2;
        f19373c = new Class[]{c.a.s0.m0.f.d.b.class, c.a.s0.m0.f.d.a.class};
        g.b d2 = c.b.a.a.g.d(c.a.s0.m0.f.d.b.class, c.a.s0.m0.f.d.a.class);
        d2.c(c.a.s0.m0.f.d.c.class, c.a.s0.m0.f.d.d.b.class);
        c.b.a.a.g b3 = d2.b();
        Intrinsics.checkNotNullExpressionValue(b3, "all(\n        ItemDataCom…t::class.java\n    ).get()");
        f19374d = b3;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final c.b.a.a.g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f19372b : (c.b.a.a.g) invokeV.objValue;
    }

    public final Class<? extends c.a.s0.m0.f.c.a>[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f19373c : (Class[]) invokeV.objValue;
    }

    public final c.b.a.a.g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f19374d : (c.b.a.a.g) invokeV.objValue;
    }
}
