package b.a.t0.o0;

import androidx.core.view.InputDeviceCompat;
import b.a.t0.q;
import b.a.t0.u;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b.a.t0.n0.d f28860a;

    /* renamed from: b  reason: collision with root package name */
    public static b.a.t0.n0.a f28861b;

    /* renamed from: c  reason: collision with root package name */
    public static b.a.t0.n0.c f28862c;

    /* renamed from: d  reason: collision with root package name */
    public static b.a.t0.n0.b f28863d;

    /* renamed from: e  reason: collision with root package name */
    public static q f28864e;

    /* renamed from: f  reason: collision with root package name */
    public static u f28865f;
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

    public static b.a.t0.n0.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b.a.t0.n0.a aVar = f28861b;
            if (aVar != null) {
                return aVar;
            }
            if (f28860a == null) {
                f28860a = d();
            }
            if (f28860a != null) {
                f28861b = f28860a.a();
            }
            return f28861b;
        }
        return (b.a.t0.n0.a) invokeV.objValue;
    }

    public static b.a.t0.n0.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.t0.n0.b bVar = f28863d;
            if (bVar != null) {
                return bVar;
            }
            if (f28860a == null) {
                f28860a = d();
            }
            if (f28860a != null) {
                f28863d = f28860a.e();
            }
            return f28863d;
        }
        return (b.a.t0.n0.b) invokeV.objValue;
    }

    public static b.a.t0.n0.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b.a.t0.n0.c cVar = f28862c;
            if (cVar != null) {
                return cVar;
            }
            if (f28860a == null) {
                f28860a = d();
            }
            if (f28860a != null) {
                f28862c = f28860a.b();
            }
            return f28862c;
        }
        return (b.a.t0.n0.c) invokeV.objValue;
    }

    public static b.a.t0.n0.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (d.class) {
                if (f28860a == null) {
                    f28860a = c.a();
                }
            }
            return f28860a;
        }
        return (b.a.t0.n0.d) invokeV.objValue;
    }

    public static q e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            q qVar = f28864e;
            if (qVar != null) {
                return qVar;
            }
            if (f28860a == null) {
                f28860a = d();
            }
            if (f28860a != null) {
                f28864e = f28860a.c();
            }
            return f28864e;
        }
        return (q) invokeV.objValue;
    }

    public static u f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            u uVar = f28865f;
            if (uVar != null) {
                return uVar;
            }
            if (f28860a == null) {
                f28860a = d();
            }
            if (f28860a != null) {
                f28865f = f28860a.d();
            }
            return f28865f;
        }
        return (u) invokeV.objValue;
    }
}
