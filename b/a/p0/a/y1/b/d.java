package b.a.p0.a.y1.b;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.h;
import b.a.p0.a.d2.i;
import b.a.p0.a.d2.m;
import b.a.p0.a.k;
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
public final class d extends m implements b.a.p0.a.y1.b.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f9454h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f9455f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, b.a.p0.a.y1.b.c> f9456g;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9457e;

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
            this.f9457e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (d.f9454h) {
                    d dVar = this.f9457e;
                    dVar.S("onEventCallback msg" + aVar);
                }
                this.f9457e.U(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9458e;

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
            this.f9458e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (d.f9454h) {
                    d dVar = this.f9458e;
                    dVar.S("onEventCallback msg" + aVar);
                }
                this.f9458e.V(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f9459a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1556387354, "Lb/a/p0/a/y1/b/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1556387354, "Lb/a/p0/a/y1/b/d$c;");
                    return;
                }
            }
            f9459a = new d(b.a.p0.a.d2.d.J());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-466423483, "Lb/a/p0/a/y1/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-466423483, "Lb/a/p0/a/y1/b/d;");
                return;
            }
        }
        f9454h = k.f6863a;
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
        this.f9455f = new HashMap<>();
        this.f9456g = new HashMap<>();
        if (f9454h) {
            S("SwanIpc");
        }
        b.a.p0.a.d2.b bVar = new b.a.p0.a.d2.b();
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

    public static synchronized b.a.p0.a.y1.b.c P(@NonNull String str) {
        InterceptResult invokeL;
        b.a.p0.a.y1.b.c d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (d.class) {
                d0 = Q().d0(str);
            }
            return d0;
        }
        return (b.a.p0.a.y1.b.c) invokeL.objValue;
    }

    public static d Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.f9459a : (d) invokeV.objValue;
    }

    public static void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Q();
        }
    }

    public static synchronized b.a.p0.a.y1.b.c Y(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        b.a.p0.a.y1.b.c b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (d.class) {
                b0 = Q().b0(bundle);
            }
            return b0;
        }
        return (b.a.p0.a.y1.b.c) invokeL.objValue;
    }

    public static synchronized b.a.p0.a.y1.b.c Z(@NonNull String str) {
        InterceptResult invokeL;
        b.a.p0.a.y1.b.c c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (d.class) {
                c0 = Q().c0(str, null);
            }
            return c0;
        }
        return (b.a.p0.a.y1.b.c) invokeL.objValue;
    }

    public final synchronized boolean H(@NonNull b.a.p0.a.y1.b.c cVar, @NonNull Bundle bundle) {
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

    public final synchronized boolean K(@NonNull b.a.p0.a.y1.b.c cVar, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (cVar.Z()) {
                    String Q = cVar.Q();
                    String str2 = this.f9455f.get(Q);
                    boolean z2 = !TextUtils.isEmpty(str2);
                    z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                    if (z && !z2 && !TextUtils.isEmpty(str)) {
                        this.f9455f.put(Q, str);
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
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && f9454h) {
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
            if (f9454h) {
                T("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                i.a aVar2 = new i.a("event_messenger_call", D);
                b.a.p0.a.y1.b.c Y = Y(D);
                if (H(Y, D) && Y.X(aVar2)) {
                    return;
                }
                b.a.p0.a.d2.d.J().A(aVar2);
            }
        }
    }

    public final void V(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (f9454h) {
                T("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Y(aVar.D()).call();
            }
        }
    }

    public String W(@NonNull b.a.p0.a.y1.b.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) ? X(cVar.Q()) : (String) invokeL.objValue;
    }

    public String X(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.f9455f.get(str) : (String) invokeL.objValue;
    }

    public d a0(b.a.p0.a.y1.b.c cVar, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, exc)) == null) {
            if (cVar != null) {
                synchronized (this.f9456g) {
                    cVar.M(exc);
                    this.f9456g.remove(cVar.Q());
                }
            }
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public final synchronized b.a.p0.a.y1.b.c b0(Bundle bundle) {
        InterceptResult invokeL;
        b.a.p0.a.y1.b.c c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                c0 = c0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return c0;
        }
        return (b.a.p0.a.y1.b.c) invokeL.objValue;
    }

    public final synchronized b.a.p0.a.y1.b.c c0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        b.a.p0.a.y1.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                cVar = TextUtils.isEmpty(str) ? null : this.f9456g.get(str);
                if (cVar == null || !cVar.Z()) {
                    a0(cVar, new IllegalStateException("invalid session"));
                    cVar = new b.a.p0.a.y1.b.c(this, str);
                    this.f9456g.put(cVar.Q(), cVar);
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
                cVar.S(z ? bundle.getLong("ipc_session_timeout") : b.a.p0.a.y1.b.b.f0);
                if (f9454h) {
                    T("session", "id=" + str + " session=" + bundle + " session=" + cVar);
                }
            }
            return cVar;
        }
        return (b.a.p0.a.y1.b.c) invokeLL.objValue;
    }

    public final synchronized b.a.p0.a.y1.b.c d0(String str) {
        InterceptResult invokeL;
        b.a.p0.a.y1.b.c b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            synchronized (this) {
                b0 = b0(null);
                K(b0, str);
                if (f9454h) {
                    T("topic", str + " session=" + b0);
                }
            }
            return b0;
        }
        return (b.a.p0.a.y1.b.c) invokeL.objValue;
    }
}
