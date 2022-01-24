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
    public static c.a.v0.n0.a f26527b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.v0.n0.c f26528c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.v0.n0.b f26529d;

    /* renamed from: e  reason: collision with root package name */
    public static q f26530e;

    /* renamed from: f  reason: collision with root package name */
    public static u f26531f;
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
            c.a.v0.n0.a aVar = f26527b;
            if (aVar != null) {
                return aVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f26527b = a.a();
            }
            return f26527b;
        }
        return (c.a.v0.n0.a) invokeV.objValue;
    }

    public static c.a.v0.n0.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c.a.v0.n0.b bVar = f26529d;
            if (bVar != null) {
                return bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f26529d = a.e();
            }
            return f26529d;
        }
        return (c.a.v0.n0.b) invokeV.objValue;
    }

    public static c.a.v0.n0.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.v0.n0.c cVar = f26528c;
            if (cVar != null) {
                return cVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f26528c = a.b();
            }
            return f26528c;
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
            q qVar = f26530e;
            if (qVar != null) {
                return qVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f26530e = a.c();
            }
            return f26530e;
        }
        return (q) invokeV.objValue;
    }

    public static u f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            u uVar = f26531f;
            if (uVar != null) {
                return uVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f26531f = a.d();
            }
            return f26531f;
        }
        return (u) invokeV.objValue;
    }
}
