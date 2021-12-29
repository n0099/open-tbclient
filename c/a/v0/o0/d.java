package c.a.v0.o0;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.q;
import c.a.v0.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c.a.v0.n0.d a;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.v0.n0.a f27315b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.v0.n0.c f27316c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.v0.n0.b f27317d;

    /* renamed from: e  reason: collision with root package name */
    public static q f27318e;

    /* renamed from: f  reason: collision with root package name */
    public static u f27319f;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c.a.v0.n0.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c.a.v0.n0.a aVar = f27315b;
            if (aVar != null) {
                return aVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f27315b = a.a();
            }
            return f27315b;
        }
        return (c.a.v0.n0.a) invokeV.objValue;
    }

    public static c.a.v0.n0.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c.a.v0.n0.b bVar = f27317d;
            if (bVar != null) {
                return bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f27317d = a.e();
            }
            return f27317d;
        }
        return (c.a.v0.n0.b) invokeV.objValue;
    }

    public static c.a.v0.n0.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.v0.n0.c cVar = f27316c;
            if (cVar != null) {
                return cVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f27316c = a.b();
            }
            return f27316c;
        }
        return (c.a.v0.n0.c) invokeV.objValue;
    }

    public static c.a.v0.n0.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = c.a();
                }
            }
            return a;
        }
        return (c.a.v0.n0.d) invokeV.objValue;
    }

    public static q e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            q qVar = f27318e;
            if (qVar != null) {
                return qVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f27318e = a.c();
            }
            return f27318e;
        }
        return (q) invokeV.objValue;
    }

    public static u f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            u uVar = f27319f;
            if (uVar != null) {
                return uVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f27319f = a.d();
            }
            return f27319f;
        }
        return (u) invokeV.objValue;
    }
}
