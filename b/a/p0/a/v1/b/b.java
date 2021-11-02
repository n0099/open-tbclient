package b.a.p0.a.v1.b;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.i;
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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class b extends b.a.p0.a.f1.e.f.c<b> implements b.a.p0.a.v1.b.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final c f8473f;

    /* renamed from: g  reason: collision with root package name */
    public final String f8474g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<b.a.p0.a.v2.e1.b<i.a>> f8475h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<b.a.p0.a.v2.e1.b<b>> f8476i;
    public final Set<String> j;
    public final Set<Integer> k;
    public Exception l;
    public long m;
    public boolean n;
    public final Runnable o;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8477e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8477e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f8477e.f8473f) {
                    this.f8477e.f8473f.P(this.f8477e, new TimeoutException("timeout"));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1166032708, "Lb/a/p0/a/v1/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1166032708, "Lb/a/p0/a/v1/b/b;");
                return;
            }
        }
        p = k.f6397a;
    }

    public b(@NonNull c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8475h = new HashSet();
        this.f8476i = new HashSet();
        this.j = new HashSet();
        this.k = new HashSet();
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = new a(this);
        this.f8473f = cVar;
        this.f8474g = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (p) {
            S("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.f8474g);
        }
    }

    public b E(b.a.p0.a.v2.e1.b<b> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            G(this.f8476i, bVar);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b F(b.a.p0.a.v2.e1.b<i.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            G(this.f8475h, bVar);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final <CallBackT> b G(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, callbackt)) == null) {
            synchronized (this.f8473f) {
                if (W() && callbackt != null) {
                    set.add(callbackt);
                }
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (this.f8473f) {
                this.k.add(Integer.valueOf(i2));
                V();
            }
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.f8473f) {
                this.j.add(str);
                V();
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            synchronized (this.f8473f) {
                this.n = z;
                V();
            }
            return this;
        }
        return (b) invokeZ.objValue;
    }

    public final b.a.p0.a.v1.c.c K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Bundle C = C();
            C.putString("ipc_session_id", this.f8474g);
            C.putLong("ipc_session_timeout", this.m);
            C.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
            C.putString("ipc_topic", this.f8473f.L(this));
            b.a.p0.a.v1.c.c cVar = new b.a.p0.a.v1.c.c(T(), C);
            cVar.p(true);
            cVar.f(!SwanAppProcessInfo.current().isSwanService || this.n);
            for (Integer num : this.k) {
                int intValue = num.intValue();
                if (SwanAppProcessInfo.checkProcessId(intValue)) {
                    cVar.a(intValue);
                }
            }
            for (String str : this.j) {
                if (!TextUtils.isEmpty(str)) {
                    cVar.c(str);
                }
            }
            if (p) {
                S("createMsg", "msgCooker=" + cVar + " bundle=" + C);
            }
            return cVar;
        }
        return (b.a.p0.a.v1.c.c) invokeV.objValue;
    }

    public b L(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, exc)) == null) {
            synchronized (this.f8473f) {
                if (!P()) {
                    b.a.p0.a.a2.d.i().removeCallbacks(this.o);
                    this.m = -1L;
                    this.l = exc;
                    this.f8475h.clear();
                    for (b.a.p0.a.v2.e1.b<b> bVar : this.f8476i) {
                        bVar.onCallback(this);
                    }
                    this.f8476i.clear();
                    this.n = false;
                    this.j.clear();
                    this.k.clear();
                    b();
                }
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public Exception M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (Exception) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f8474g : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m < 0 : invokeV.booleanValue;
    }

    public long Q(long j) {
        InterceptResult invokeJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
            synchronized (this.f8473f) {
                if (W()) {
                    this.m = Math.max(Math.max(j, b.a.p0.a.v1.b.a.f0), this.m);
                    Handler i2 = b.a.p0.a.a2.d.i();
                    if (this.m > 0) {
                        i2.removeCallbacks(this.o);
                        i2.postDelayed(this.o, this.m);
                    }
                }
                j2 = this.m;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && p) {
            String str2 = SwanAppProcessInfo.current() + " >> " + str;
        }
    }

    public final void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            R(str + ": " + str2);
        }
    }

    public final int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            boolean z = SwanAppProcessInfo.current().isSwanService;
            int i2 = z ? 111 : 11;
            if (p) {
                S("msgType", "service=" + z + " msgType=" + i2);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean U(i.a aVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aVar)) == null) {
            synchronized (this.f8473f) {
                z = (!W() || this.f8475h.isEmpty() || aVar == null) ? false : true;
                if (z) {
                    for (b.a.p0.a.v2.e1.b<i.a> bVar : this.f8475h) {
                        bVar.onCallback(aVar);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public b V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (b) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this.f8473f) {
                z = (P() || N() || TextUtils.isEmpty(this.f8474g)) ? false : true;
                if (p) {
                    S("valid", z + " isFinished=" + P() + " hasException=" + this.l + " id=" + this.f8474g);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.v2.e1.d
    public /* bridge */ /* synthetic */ b.a.p0.a.v2.e1.d a() {
        V();
        return this;
    }

    public b call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? call(b.a.p0.a.v1.b.a.f0) : (b) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.f.c
    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                str = "IpcSession: id=" + this.f8474g + " timeout=" + this.m;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public b call(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            synchronized (this.f8473f) {
                if (p) {
                    S(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
                }
                if (W()) {
                    long Q = Q(j);
                    if (p) {
                        S(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + Q);
                    }
                    b.a.p0.a.v1.c.a.e().h(K());
                    b();
                } else {
                    this.f8473f.P(this, new IllegalStateException("invalid session call"));
                }
                V();
            }
            return this;
        }
        return (b) invokeJ.objValue;
    }
}
