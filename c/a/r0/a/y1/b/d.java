package c.a.r0.a.y1.b;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.h;
import c.a.r0.a.d2.i;
import c.a.r0.a.d2.m;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d extends m implements c.a.r0.a.y1.b.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f9700h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f9701f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, c.a.r0.a.y1.b.c> f9702g;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9703e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9703e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (d.f9700h) {
                    d dVar = this.f9703e;
                    dVar.S("onEventCallback msg" + aVar);
                }
                this.f9703e.U(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.z2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9704e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9704e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (d.f9700h) {
                    d dVar = this.f9704e;
                    dVar.S("onEventCallback msg" + aVar);
                }
                this.f9704e.V(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(730390339, "Lc/a/r0/a/y1/b/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(730390339, "Lc/a/r0/a/y1/b/d$c;");
                    return;
                }
            }
            a = new d(c.a.r0.a.d2.d.J());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-718792222, "Lc/a/r0/a/y1/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-718792222, "Lc/a/r0/a/y1/b/d;");
                return;
            }
        }
        f9700h = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9701f = new HashMap<>();
        this.f9702g = new HashMap<>();
        if (f9700h) {
            S("SwanIpc");
        }
        c.a.r0.a.d2.b bVar = new c.a.r0.a.d2.b();
        bVar.e(new b(this), "event_messenger_call_out");
        bVar.e(new a(this), "event_messenger_call_in");
        v(bVar);
    }

    public static synchronized boolean I(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (d.class) {
                K = Q().K(Y(bundle), str);
            }
            return K;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean J(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        boolean K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            synchronized (d.class) {
                K = Q().K(Z(str), str2);
            }
            return K;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized c.a.r0.a.y1.b.c P(@NonNull String str) {
        InterceptResult invokeL;
        c.a.r0.a.y1.b.c d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (d.class) {
                d0 = Q().d0(str);
            }
            return d0;
        }
        return (c.a.r0.a.y1.b.c) invokeL.objValue;
    }

    public static d Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (d) invokeV.objValue;
    }

    public static void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Q();
        }
    }

    public static synchronized c.a.r0.a.y1.b.c Y(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        c.a.r0.a.y1.b.c b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (d.class) {
                b0 = Q().b0(bundle);
            }
            return b0;
        }
        return (c.a.r0.a.y1.b.c) invokeL.objValue;
    }

    public static synchronized c.a.r0.a.y1.b.c Z(@NonNull String str) {
        InterceptResult invokeL;
        c.a.r0.a.y1.b.c c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (d.class) {
                c0 = Q().c0(str, null);
            }
            return c0;
        }
        return (c.a.r0.a.y1.b.c) invokeL.objValue;
    }

    public final synchronized boolean H(@NonNull c.a.r0.a.y1.b.c cVar, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, bundle)) == null) {
            synchronized (this) {
                if (cVar.Z()) {
                    z = K(cVar, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean K(@NonNull c.a.r0.a.y1.b.c cVar, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (cVar.Z()) {
                    String Q = cVar.Q();
                    String str2 = this.f9701f.get(Q);
                    boolean z2 = !TextUtils.isEmpty(str2);
                    z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                    if (z && !z2 && !TextUtils.isEmpty(str)) {
                        this.f9701f.put(Q, str);
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && f9700h) {
            String str2 = SwanAppProcessInfo.current() + " >> " + str;
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            S(str + ": " + str2);
        }
    }

    public final void U(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (f9700h) {
                T("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                i.a aVar2 = new i.a("event_messenger_call", D);
                c.a.r0.a.y1.b.c Y = Y(D);
                if (H(Y, D) && Y.X(aVar2)) {
                    return;
                }
                c.a.r0.a.d2.d.J().A(aVar2);
            }
        }
    }

    public final void V(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (f9700h) {
                T("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Y(aVar.D()).call();
            }
        }
    }

    public String W(@NonNull c.a.r0.a.y1.b.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) ? X(cVar.Q()) : (String) invokeL.objValue;
    }

    public String X(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.f9701f.get(str) : (String) invokeL.objValue;
    }

    public d a0(c.a.r0.a.y1.b.c cVar, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, exc)) == null) {
            if (cVar != null) {
                synchronized (this.f9702g) {
                    cVar.M(exc);
                    this.f9702g.remove(cVar.Q());
                }
            }
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public final synchronized c.a.r0.a.y1.b.c b0(Bundle bundle) {
        InterceptResult invokeL;
        c.a.r0.a.y1.b.c c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                c0 = c0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return c0;
        }
        return (c.a.r0.a.y1.b.c) invokeL.objValue;
    }

    public final synchronized c.a.r0.a.y1.b.c c0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        c.a.r0.a.y1.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                cVar = TextUtils.isEmpty(str) ? null : this.f9702g.get(str);
                if (cVar == null || !cVar.Z()) {
                    a0(cVar, new IllegalStateException("invalid session"));
                    cVar = new c.a.r0.a.y1.b.c(this, str);
                    this.f9702g.put(cVar.Q(), cVar);
                }
                boolean z = bundle != null && H(cVar, bundle);
                if (z) {
                    int i2 = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i2)) {
                        cVar.I(i2);
                    } else if (SwanAppProcessInfo.SERVICE.index == i2) {
                        cVar.K(true);
                    }
                }
                cVar.S(z ? bundle.getLong("ipc_session_timeout") : c.a.r0.a.y1.b.b.n0);
                if (f9700h) {
                    T("session", "id=" + str + " session=" + bundle + " session=" + cVar);
                }
            }
            return cVar;
        }
        return (c.a.r0.a.y1.b.c) invokeLL.objValue;
    }

    public final synchronized c.a.r0.a.y1.b.c d0(String str) {
        InterceptResult invokeL;
        c.a.r0.a.y1.b.c b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            synchronized (this) {
                b0 = b0(null);
                K(b0, str);
                if (f9700h) {
                    T("topic", str + " session=" + b0);
                }
            }
            return b0;
        }
        return (c.a.r0.a.y1.b.c) invokeL.objValue;
    }
}
