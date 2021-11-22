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
    public static volatile b.a.t0.n0.d f29729a;

    /* renamed from: b  reason: collision with root package name */
    public static b.a.t0.n0.a f29730b;

    /* renamed from: c  reason: collision with root package name */
    public static b.a.t0.n0.c f29731c;

    /* renamed from: d  reason: collision with root package name */
    public static b.a.t0.n0.b f29732d;

    /* renamed from: e  reason: collision with root package name */
    public static q f29733e;

    /* renamed from: f  reason: collision with root package name */
    public static u f29734f;
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
            b.a.t0.n0.a aVar = f29730b;
            if (aVar != null) {
                return aVar;
            }
            if (f29729a == null) {
                f29729a = d();
            }
            if (f29729a != null) {
                f29730b = f29729a.a();
            }
            return f29730b;
        }
        return (b.a.t0.n0.a) invokeV.objValue;
    }

    public static b.a.t0.n0.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.t0.n0.b bVar = f29732d;
            if (bVar != null) {
                return bVar;
            }
            if (f29729a == null) {
                f29729a = d();
            }
            if (f29729a != null) {
                f29732d = f29729a.e();
            }
            return f29732d;
        }
        return (b.a.t0.n0.b) invokeV.objValue;
    }

    public static b.a.t0.n0.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b.a.t0.n0.c cVar = f29731c;
            if (cVar != null) {
                return cVar;
            }
            if (f29729a == null) {
                f29729a = d();
            }
            if (f29729a != null) {
                f29731c = f29729a.b();
            }
            return f29731c;
        }
        return (b.a.t0.n0.c) invokeV.objValue;
    }

    public static b.a.t0.n0.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (d.class) {
                if (f29729a == null) {
                    f29729a = c.a();
                }
            }
            return f29729a;
        }
        return (b.a.t0.n0.d) invokeV.objValue;
    }

    public static q e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            q qVar = f29733e;
            if (qVar != null) {
                return qVar;
            }
            if (f29729a == null) {
                f29729a = d();
            }
            if (f29729a != null) {
                f29733e = f29729a.c();
            }
            return f29733e;
        }
        return (q) invokeV.objValue;
    }

    public static u f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            u uVar = f29734f;
            if (uVar != null) {
                return uVar;
            }
            if (f29729a == null) {
                f29729a = d();
            }
            if (f29729a != null) {
                f29734f = f29729a.d();
            }
            return f29734f;
        }
        return (u) invokeV.objValue;
    }
}
