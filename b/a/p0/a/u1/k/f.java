package b.a.p0.a.u1.k;

import android.text.TextUtils;
import b.a.p0.a.k;
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
    public static final boolean f9018c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f9019d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f9020a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b.a.p0.a.u1.o.a f9021b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(278797270, "Lb/a/p0/a/u1/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(278797270, "Lb/a/p0/a/u1/k/f;");
                return;
            }
        }
        f9018c = k.f6863a;
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
            if (f9019d == null) {
                synchronized (f.class) {
                    if (f9019d == null) {
                        f9019d = new f();
                    }
                }
            }
            return f9019d;
        }
        return (f) invokeV.objValue;
    }

    @Override // b.a.p0.a.u1.k.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && m()) {
            if (f9018c) {
                String str = "aiapp start at - " + j;
            }
            this.f9020a.b(j);
            this.f9021b.b(j);
        }
    }

    @Override // b.a.p0.a.u1.k.e
    public void c(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && m()) {
            if (f9018c) {
                String str = "aiapp start cost at - " + j;
            }
            this.f9020a.c(j);
            this.f9021b.c(j);
            o(j);
        }
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9020a : (d) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f9020a == null) {
                this.f9020a = new b();
            }
            if (this.f9021b == null) {
                this.f9021b = new b.a.p0.a.u1.o.c();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f9018c) {
                return true;
            }
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return false;
            }
            String appId = a0.getAppId();
            return (TextUtils.isEmpty(appId) || b.a.p0.a.v.a.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l() : invokeV.booleanValue;
    }

    public b.a.p0.a.u1.o.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9021b : (b.a.p0.a.u1.o.a) invokeV.objValue;
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            b.a.p0.a.u2.d.f9135i.update((b.a.p0.a.u2.c<Long>) Long.valueOf(j));
        }
    }
}
