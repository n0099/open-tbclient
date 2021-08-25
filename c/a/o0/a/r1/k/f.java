package c.a.o0.a.r1.k;

import android.text.TextUtils;
import c.a.o0.a.k;
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
    public static final boolean f8354c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f8355d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f8356a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c.a.o0.a.r1.o.a f8357b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1271636627, "Lc/a/o0/a/r1/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1271636627, "Lc/a/o0/a/r1/k/f;");
                return;
            }
        }
        f8354c = k.f7049a;
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
            if (f8355d == null) {
                synchronized (f.class) {
                    if (f8355d == null) {
                        f8355d = new f();
                    }
                }
            }
            return f8355d;
        }
        return (f) invokeV.objValue;
    }

    @Override // c.a.o0.a.r1.k.e
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && m()) {
            if (f8354c) {
                String str = "aiapp start at - " + j2;
            }
            this.f8356a.b(j2);
            this.f8357b.b(j2);
        }
    }

    @Override // c.a.o0.a.r1.k.e
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && m()) {
            if (f8354c) {
                String str = "aiapp start cost at - " + j2;
            }
            this.f8356a.c(j2);
            this.f8357b.c(j2);
            o(j2);
        }
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8356a : (d) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f8356a == null) {
                this.f8356a = new b();
            }
            if (this.f8357b == null) {
                this.f8357b = new c.a.o0.a.r1.o.c();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f8354c) {
                return true;
            }
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
            if (Q == null) {
                return false;
            }
            String appId = Q.getAppId();
            return (TextUtils.isEmpty(appId) || c.a.o0.a.v.a.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l() : invokeV.booleanValue;
    }

    public c.a.o0.a.r1.o.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8357b : (c.a.o0.a.r1.o.a) invokeV.objValue;
    }

    public final void o(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            c.a.o0.a.q2.d.f8104i.d(Long.valueOf(j2));
        }
    }
}
