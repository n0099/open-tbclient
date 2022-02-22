package c.a.s0.a.y1.b;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.i;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public final class c extends c.a.s0.a.f1.e.f.c<c> implements b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final d f9936f;

    /* renamed from: g  reason: collision with root package name */
    public final String f9937g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<c.a.s0.a.z2.g1.c<i.a>> f9938h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<c.a.s0.a.z2.g1.c<c>> f9939i;

    /* renamed from: j  reason: collision with root package name */
    public final Set<String> f9940j;
    public final Set<Integer> k;
    public Exception l;
    public long m;
    public boolean n;
    public final Runnable o;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9941e;

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
            this.f9941e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f9941e.f9936f) {
                    this.f9941e.f9936f.a0(this.f9941e, this.f9941e.W());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-589709534, "Lc/a/s0/a/y1/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-589709534, "Lc/a/s0/a/y1/b/c;");
                return;
            }
        }
        p = k.a;
    }

    public c(@NonNull d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9938h = new HashSet();
        this.f9939i = new HashSet();
        this.f9940j = new HashSet();
        this.k = new HashSet();
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = new a(this);
        this.f9936f = dVar;
        this.f9937g = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (p) {
            U("IpcSession", "host=" + dVar + " id=" + str + " mId=" + this.f9937g);
        }
    }

    public static String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                ActivityManager activityManager = (ActivityManager) AppRuntime.getAppContext().getSystemService("activity");
                if (activityManager == null) {
                    return "ActivityManager=null";
                }
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return "RunningAppProcessInfoList=null";
                }
                StringBuilder sb = new StringBuilder();
                String str = "";
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null) {
                        sb.append(str);
                        sb.append(runningAppProcessInfo.processName);
                        str = ",";
                    }
                }
                return sb.toString();
            } catch (Exception e2) {
                return e2.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public c F(c.a.s0.a.z2.g1.c<c> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            H(this.f9939i, cVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c G(c.a.s0.a.z2.g1.c<i.a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            H(this.f9938h, cVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final <CallBackT> c H(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, callbackt)) == null) {
            synchronized (this.f9936f) {
                if (Z() && callbackt != null) {
                    set.add(callbackt);
                }
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (this.f9936f) {
                this.k.add(Integer.valueOf(i2));
                Y();
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.f9936f) {
                this.f9940j.add(str);
                Y();
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            synchronized (this.f9936f) {
                this.n = z;
                Y();
            }
            return this;
        }
        return (c) invokeZ.objValue;
    }

    public final c.a.s0.a.y1.c.c L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Bundle D = D();
            D.putString("ipc_session_id", this.f9937g);
            D.putLong("ipc_session_timeout", this.m);
            D.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
            D.putString("ipc_topic", this.f9936f.W(this));
            c.a.s0.a.y1.c.c cVar = new c.a.s0.a.y1.c.c(V(), D);
            cVar.p(true);
            cVar.f(!SwanAppProcessInfo.current().isSwanService || this.n);
            for (Integer num : this.k) {
                int intValue = num.intValue();
                if (SwanAppProcessInfo.checkProcessId(intValue)) {
                    cVar.a(intValue);
                }
            }
            for (String str : this.f9940j) {
                if (!TextUtils.isEmpty(str)) {
                    cVar.c(str);
                }
            }
            if (p) {
                U("createMsg", "msgCooker=" + cVar + " bundle=" + D);
            }
            return cVar;
        }
        return (c.a.s0.a.y1.c.c) invokeV.objValue;
    }

    public c M(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, exc)) == null) {
            synchronized (this.f9936f) {
                if (!R()) {
                    c.a.s0.a.d2.d.L().removeCallbacks(this.o);
                    this.m = -1L;
                    this.l = exc;
                    this.f9938h.clear();
                    for (c.a.s0.a.z2.g1.c<c> cVar : this.f9939i) {
                        cVar.onCallback(this);
                    }
                    this.f9939i.clear();
                    this.n = false;
                    this.f9940j.clear();
                    this.k.clear();
                    b();
                }
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public Exception N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (Exception) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f9937g : (String) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m < 0 : invokeV.booleanValue;
    }

    public long S(long j2) {
        InterceptResult invokeJ;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            synchronized (this.f9936f) {
                if (Z()) {
                    this.m = Math.max(Math.max(j2, b.n0), this.m);
                    Handler L = c.a.s0.a.d2.d.L();
                    if (this.m > 0) {
                        L.removeCallbacks(this.o);
                        L.postDelayed(this.o, this.m);
                    }
                }
                j3 = this.m;
            }
            return j3;
        }
        return invokeJ.longValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && p) {
            String str2 = SwanAppProcessInfo.current() + " >> " + str;
        }
    }

    public final void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            T(str + ": " + str2);
        }
    }

    public final int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            boolean z = SwanAppProcessInfo.current().isSwanService;
            int i2 = z ? 111 : 11;
            if (p) {
                U("msgType", "service=" + z + " msgType=" + i2);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public Exception W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            long nanoTime = p ? System.nanoTime() : 0L;
            TimeoutException timeoutException = new TimeoutException("#ipcHttpTimeout session=" + this + " processList=" + O());
            if (p) {
                String str = "#newIpcTimeoutException 耗时(ms): " + ((System.nanoTime() - nanoTime) / 1000000.0d);
            }
            return timeoutException;
        }
        return (Exception) invokeV.objValue;
    }

    public boolean X(i.a aVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, aVar)) == null) {
            synchronized (this.f9936f) {
                z = (!Z() || this.f9938h.isEmpty() || aVar == null) ? false : true;
                if (z) {
                    for (c.a.s0.a.z2.g1.c<i.a> cVar : this.f9938h) {
                        cVar.onCallback(aVar);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public c Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (c) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.f9936f) {
                z = (R() || P() || TextUtils.isEmpty(this.f9937g)) ? false : true;
                if (p) {
                    U("valid", z + " isFinished=" + R() + " hasException=" + this.l + " id=" + this.f9937g);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.a.z2.g1.f
    public /* bridge */ /* synthetic */ c.a.s0.a.z2.g1.f a() {
        Y();
        return this;
    }

    public c call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? call(b.n0) : (c) invokeV.objValue;
    }

    @Override // c.a.s0.a.f1.e.f.c
    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                str = "IpcSession: id=" + this.f9937g + " timeout=" + this.m;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public c call(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) {
            synchronized (this.f9936f) {
                if (p) {
                    U(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j2);
                }
                if (Z()) {
                    long S = S(j2);
                    if (p) {
                        U(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + S);
                    }
                    c.a.s0.a.y1.c.a.e().h(L());
                    b();
                } else {
                    this.f9936f.a0(this, new IllegalStateException("invalid session call"));
                }
                Y();
            }
            return this;
        }
        return (c) invokeJ.objValue;
    }
}
