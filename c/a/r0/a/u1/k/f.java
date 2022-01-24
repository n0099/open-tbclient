package c.a.r0.a.u1.k;

import android.text.TextUtils;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f9512c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f9513d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile d a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c.a.r0.a.u1.o.a f9514b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(26428531, "Lc/a/r0/a/u1/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(26428531, "Lc/a/r0/a/u1/k/f;");
                return;
            }
        }
        f9512c = k.a;
    }

    public f() {
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
        k();
    }

    public static f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f9513d == null) {
                synchronized (f.class) {
                    if (f9513d == null) {
                        f9513d = new f();
                    }
                }
            }
            return f9513d;
        }
        return (f) invokeV.objValue;
    }

    @Override // c.a.r0.a.u1.k.e
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && m()) {
            if (f9512c) {
                String str = "aiapp start at - " + j2;
            }
            this.a.b(j2);
            this.f9514b.b(j2);
        }
    }

    @Override // c.a.r0.a.u1.k.e
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && m()) {
            if (f9512c) {
                String str = "aiapp start cost at - " + j2;
            }
            this.a.c(j2);
            this.f9514b.c(j2);
            o(j2);
        }
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (d) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.a == null) {
                this.a = new b();
            }
            if (this.f9514b == null) {
                this.f9514b = new c.a.r0.a.u1.o.c();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f9512c) {
                return true;
            }
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                return false;
            }
            String appId = a0.getAppId();
            return (TextUtils.isEmpty(appId) || c.a.r0.a.v.a.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l() : invokeV.booleanValue;
    }

    public c.a.r0.a.u1.o.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9514b : (c.a.r0.a.u1.o.a) invokeV.objValue;
    }

    public final void o(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            c.a.r0.a.u2.d.f9602i.update((c.a.r0.a.u2.c<Long>) Long.valueOf(j2));
        }
    }
}
