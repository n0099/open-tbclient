package b.a.p0.a.r1.k;

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
    public static final boolean f7664c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f7665d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f7666a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b.a.p0.a.r1.o.a f7667b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1911253523, "Lb/a/p0/a/r1/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1911253523, "Lb/a/p0/a/r1/k/f;");
                return;
            }
        }
        f7664c = k.f6397a;
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
            if (f7665d == null) {
                synchronized (f.class) {
                    if (f7665d == null) {
                        f7665d = new f();
                    }
                }
            }
            return f7665d;
        }
        return (f) invokeV.objValue;
    }

    @Override // b.a.p0.a.r1.k.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && m()) {
            if (f7664c) {
                String str = "aiapp start at - " + j;
            }
            this.f7666a.b(j);
            this.f7667b.b(j);
        }
    }

    @Override // b.a.p0.a.r1.k.e
    public void c(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && m()) {
            if (f7664c) {
                String str = "aiapp start cost at - " + j;
            }
            this.f7666a.c(j);
            this.f7667b.c(j);
            o(j);
        }
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7666a : (d) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f7666a == null) {
                this.f7666a = new b();
            }
            if (this.f7667b == null) {
                this.f7667b = new b.a.p0.a.r1.o.c();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f7664c) {
                return true;
            }
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return false;
            }
            String appId = P.getAppId();
            return (TextUtils.isEmpty(appId) || b.a.p0.a.v.a.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l() : invokeV.booleanValue;
    }

    public b.a.p0.a.r1.o.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7667b : (b.a.p0.a.r1.o.a) invokeV.objValue;
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            b.a.p0.a.q2.d.f7426i.update((b.a.p0.a.q2.c<Long>) Long.valueOf(j));
        }
    }
}
