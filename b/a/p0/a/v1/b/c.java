package b.a.p0.a.v1.b;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.h;
import b.a.p0.a.a2.i;
import b.a.p0.a.a2.m;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public final class c extends m implements b.a.p0.a.v1.b.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f8478h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f8479f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, b.a.p0.a.v1.b.b> f8480g;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8481e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8481e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.f8478h) {
                    c cVar = this.f8481e;
                    cVar.H("onEventCallback msg" + aVar);
                }
                this.f8481e.J(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8482e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8482e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.f8478h) {
                    c cVar = this.f8482e;
                    cVar.H("onEventCallback msg" + aVar);
                }
                this.f8482e.K(aVar);
            }
        }
    }

    /* renamed from: b.a.p0.a.v1.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0424c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f8483a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-429021052, "Lb/a/p0/a/v1/b/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-429021052, "Lb/a/p0/a/v1/b/c$c;");
                    return;
                }
            }
            f8483a = new c(b.a.p0.a.a2.d.g());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1166032739, "Lb/a/p0/a/v1/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1166032739, "Lb/a/p0/a/v1/b/c;");
                return;
            }
        }
        f8478h = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar) {
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
        this.f8479f = new HashMap<>();
        this.f8480g = new HashMap<>();
        if (f8478h) {
            H("SwanIpc");
        }
        b.a.p0.a.a2.b bVar = new b.a.p0.a.a2.b();
        bVar.e(new b(this), "event_messenger_call_out");
        bVar.e(new a(this), "event_messenger_call_in");
        v(bVar);
    }

    public static synchronized b.a.p0.a.v1.b.b E(@NonNull String str) {
        InterceptResult invokeL;
        b.a.p0.a.v1.b.b S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (c.class) {
                S = F().S(str);
            }
            return S;
        }
        return (b.a.p0.a.v1.b.b) invokeL.objValue;
    }

    public static c F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0424c.f8483a : (c) invokeV.objValue;
    }

    public static void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            F();
        }
    }

    public static synchronized b.a.p0.a.v1.b.b N(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        b.a.p0.a.v1.b.b Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bundle)) == null) {
            synchronized (c.class) {
                Q = F().Q(bundle);
            }
            return Q;
        }
        return (b.a.p0.a.v1.b.b) invokeL.objValue;
    }

    public static synchronized b.a.p0.a.v1.b.b O(@NonNull String str) {
        InterceptResult invokeL;
        b.a.p0.a.v1.b.b R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            synchronized (c.class) {
                R = F().R(str, null);
            }
            return R;
        }
        return (b.a.p0.a.v1.b.b) invokeL.objValue;
    }

    public static synchronized boolean f(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bundle, str)) == null) {
            synchronized (c.class) {
                h2 = F().h(N(bundle), str);
            }
            return h2;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean g(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        boolean h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            synchronized (c.class) {
                h2 = F().h(O(str), str2);
            }
            return h2;
        }
        return invokeLL.booleanValue;
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f8478h) {
            String str2 = SwanAppProcessInfo.current() + " >> " + str;
        }
    }

    public final void I(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            H(str + ": " + str2);
        }
    }

    public final void J(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (f8478h) {
                I("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle C = aVar.C();
                i.a aVar2 = new i.a("event_messenger_call", C);
                b.a.p0.a.v1.b.b N = N(C);
                if (e(N, C) && N.U(aVar2)) {
                    return;
                }
                b.a.p0.a.a2.d.g().A(aVar2);
            }
        }
    }

    public final void K(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (f8478h) {
                I("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                N(aVar.C()).call();
            }
        }
    }

    public String L(@NonNull b.a.p0.a.v1.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? M(bVar.O()) : (String) invokeL.objValue;
    }

    public String M(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f8479f.get(str) : (String) invokeL.objValue;
    }

    public c P(b.a.p0.a.v1.b.b bVar, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bVar, exc)) == null) {
            if (bVar != null) {
                synchronized (this.f8480g) {
                    bVar.L(exc);
                    this.f8480g.remove(bVar.O());
                }
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public final synchronized b.a.p0.a.v1.b.b Q(Bundle bundle) {
        InterceptResult invokeL;
        b.a.p0.a.v1.b.b R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            synchronized (this) {
                R = R(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return R;
        }
        return (b.a.p0.a.v1.b.b) invokeL.objValue;
    }

    public final synchronized b.a.p0.a.v1.b.b R(String str, Bundle bundle) {
        InterceptResult invokeLL;
        b.a.p0.a.v1.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle)) == null) {
            synchronized (this) {
                bVar = TextUtils.isEmpty(str) ? null : this.f8480g.get(str);
                if (bVar == null || !bVar.W()) {
                    P(bVar, new IllegalStateException("invalid session"));
                    bVar = new b.a.p0.a.v1.b.b(this, str);
                    this.f8480g.put(bVar.O(), bVar);
                }
                boolean z = bundle != null && e(bVar, bundle);
                if (z) {
                    int i2 = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i2)) {
                        bVar.H(i2);
                    } else if (SwanAppProcessInfo.SERVICE.index == i2) {
                        bVar.J(true);
                    }
                }
                bVar.Q(z ? bundle.getLong("ipc_session_timeout") : b.a.p0.a.v1.b.a.f0);
                if (f8478h) {
                    I("session", "id=" + str + " session=" + bundle + " session=" + bVar);
                }
            }
            return bVar;
        }
        return (b.a.p0.a.v1.b.b) invokeLL.objValue;
    }

    public final synchronized b.a.p0.a.v1.b.b S(String str) {
        InterceptResult invokeL;
        b.a.p0.a.v1.b.b Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                Q = Q(null);
                h(Q, str);
                if (f8478h) {
                    I("topic", str + " session=" + Q);
                }
            }
            return Q;
        }
        return (b.a.p0.a.v1.b.b) invokeL.objValue;
    }

    public final synchronized boolean e(@NonNull b.a.p0.a.v1.b.b bVar, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bundle)) == null) {
            synchronized (this) {
                if (bVar.W()) {
                    z = h(bVar, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean h(@NonNull b.a.p0.a.v1.b.b bVar, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, bVar, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (bVar.W()) {
                    String O = bVar.O();
                    String str2 = this.f8479f.get(O);
                    boolean z2 = !TextUtils.isEmpty(str2);
                    z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                    if (z && !z2 && !TextUtils.isEmpty(str)) {
                        this.f8479f.put(O, str);
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
