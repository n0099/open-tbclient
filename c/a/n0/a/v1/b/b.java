package c.a.n0.a.v1.b;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.i;
import c.a.n0.a.k;
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
public final class b extends c.a.n0.a.f1.e.f.c<b> implements c.a.n0.a.v1.b.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final c f8942f;

    /* renamed from: g  reason: collision with root package name */
    public final String f8943g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<c.a.n0.a.v2.e1.b<i.a>> f8944h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<c.a.n0.a.v2.e1.b<b>> f8945i;

    /* renamed from: j  reason: collision with root package name */
    public final Set<String> f8946j;
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
        public final /* synthetic */ b f8947e;

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
            this.f8947e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f8947e.f8942f) {
                    this.f8947e.f8942f.P(this.f8947e, new TimeoutException("timeout"));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(397333093, "Lc/a/n0/a/v1/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(397333093, "Lc/a/n0/a/v1/b/b;");
                return;
            }
        }
        p = k.f6803a;
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
        this.f8944h = new HashSet();
        this.f8945i = new HashSet();
        this.f8946j = new HashSet();
        this.k = new HashSet();
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = new a(this);
        this.f8942f = cVar;
        this.f8943g = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (p) {
            V("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.f8943g);
        }
    }

    public b F(c.a.n0.a.v2.e1.b<b> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            H(this.f8945i, bVar);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b G(c.a.n0.a.v2.e1.b<i.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            H(this.f8944h, bVar);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final <CallBackT> b H(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, callbackt)) == null) {
            synchronized (this.f8942f) {
                if (Z() && callbackt != null) {
                    set.add(callbackt);
                }
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (this.f8942f) {
                this.k.add(Integer.valueOf(i2));
                Y();
            }
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.f8942f) {
                this.f8946j.add(str);
                Y();
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            synchronized (this.f8942f) {
                this.n = z;
                Y();
            }
            return this;
        }
        return (b) invokeZ.objValue;
    }

    public b L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            M(c.a.n0.a.v1.b.a.f0);
            return this;
        }
        return (b) invokeV.objValue;
    }

    public b M(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            synchronized (this.f8942f) {
                if (p) {
                    V(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j2);
                }
                if (Z()) {
                    long T = T(j2);
                    if (p) {
                        V(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + T);
                    }
                    c.a.n0.a.v1.c.a.e().h(N());
                    b();
                } else {
                    this.f8942f.P(this, new IllegalStateException("invalid session call"));
                }
                Y();
            }
            return this;
        }
        return (b) invokeJ.objValue;
    }

    public final c.a.n0.a.v1.c.c N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Bundle C = C();
            C.putString("ipc_session_id", this.f8943g);
            C.putLong("ipc_session_timeout", this.m);
            C.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
            C.putString("ipc_topic", this.f8942f.L(this));
            c.a.n0.a.v1.c.c cVar = new c.a.n0.a.v1.c.c(W(), C);
            cVar.p(true);
            cVar.f(!SwanAppProcessInfo.current().isSwanService || this.n);
            for (Integer num : this.k) {
                int intValue = num.intValue();
                if (SwanAppProcessInfo.checkProcessId(intValue)) {
                    cVar.a(intValue);
                }
            }
            for (String str : this.f8946j) {
                if (!TextUtils.isEmpty(str)) {
                    cVar.c(str);
                }
            }
            if (p) {
                V("createMsg", "msgCooker=" + cVar + " bundle=" + C);
            }
            return cVar;
        }
        return (c.a.n0.a.v1.c.c) invokeV.objValue;
    }

    public b O(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, exc)) == null) {
            synchronized (this.f8942f) {
                if (!S()) {
                    c.a.n0.a.a2.d.i().removeCallbacks(this.o);
                    this.m = -1L;
                    this.l = exc;
                    this.f8944h.clear();
                    for (c.a.n0.a.v2.e1.b<b> bVar : this.f8945i) {
                        bVar.onCallback(this);
                    }
                    this.f8945i.clear();
                    this.n = false;
                    this.f8946j.clear();
                    this.k.clear();
                    b();
                }
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public Exception P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : (Exception) invokeV.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f8943g : (String) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m < 0 : invokeV.booleanValue;
    }

    public long T(long j2) {
        InterceptResult invokeJ;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            synchronized (this.f8942f) {
                if (Z()) {
                    this.m = Math.max(Math.max(j2, c.a.n0.a.v1.b.a.f0), this.m);
                    Handler i2 = c.a.n0.a.a2.d.i();
                    if (this.m > 0) {
                        i2.removeCallbacks(this.o);
                        i2.postDelayed(this.o, this.m);
                    }
                }
                j3 = this.m;
            }
            return j3;
        }
        return invokeJ.longValue;
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && p) {
            String str2 = SwanAppProcessInfo.current() + " >> " + str;
        }
    }

    public final void V(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            U(str + ": " + str2);
        }
    }

    public final int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            boolean z = SwanAppProcessInfo.current().isSwanService;
            int i2 = z ? 111 : 11;
            if (p) {
                V("msgType", "service=" + z + " msgType=" + i2);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean X(i.a aVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, aVar)) == null) {
            synchronized (this.f8942f) {
                z = (!Z() || this.f8944h.isEmpty() || aVar == null) ? false : true;
                if (z) {
                    for (c.a.n0.a.v2.e1.b<i.a> bVar : this.f8944h) {
                        bVar.onCallback(aVar);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public b Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this : (b) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this.f8942f) {
                z = (S() || Q() || TextUtils.isEmpty(this.f8943g)) ? false : true;
                if (p) {
                    V("valid", z + " isFinished=" + S() + " hasException=" + this.l + " id=" + this.f8943g);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.v2.e1.d
    public /* bridge */ /* synthetic */ c.a.n0.a.v2.e1.d a() {
        Y();
        return this;
    }

    @Override // c.a.n0.a.f1.e.f.c
    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                str = "IpcSession: id=" + this.f8943g + " timeout=" + this.m;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
