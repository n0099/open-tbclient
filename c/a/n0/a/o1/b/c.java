package c.a.n0.a.o1.b;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.t1.i;
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
/* loaded from: classes.dex */
public final class c extends c.a.n0.a.v0.e.f.c<c> implements b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final d f5593b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5594c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<c.a.n0.a.p2.g1.c<i.a>> f5595d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c.a.n0.a.p2.g1.c<c>> f5596e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f5597f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<Integer> f5598g;

    /* renamed from: h  reason: collision with root package name */
    public Exception f5599h;
    public long i;
    public boolean j;
    public final Runnable k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.f5593b) {
                    this.a.f5593b.a0(this.a, this.a.W());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1520225347, "Lc/a/n0/a/o1/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1520225347, "Lc/a/n0/a/o1/b/c;");
                return;
            }
        }
        l = c.a.n0.a.a.a;
    }

    public c(@NonNull d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5595d = new HashSet();
        this.f5596e = new HashSet();
        this.f5597f = new HashSet();
        this.f5598g = new HashSet();
        this.f5599h = null;
        this.i = 0L;
        this.j = false;
        this.k = new a(this);
        this.f5593b = dVar;
        this.f5594c = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (l) {
            U("IpcSession", "host=" + dVar + " id=" + str + " mId=" + this.f5594c);
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

    public c F(c.a.n0.a.p2.g1.c<c> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            H(this.f5596e, cVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c G(c.a.n0.a.p2.g1.c<i.a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            H(this.f5595d, cVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final <CallBackT> c H(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, callbackt)) == null) {
            synchronized (this.f5593b) {
                if (Z() && callbackt != null) {
                    set.add(callbackt);
                }
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this.f5593b) {
                this.f5598g.add(Integer.valueOf(i));
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
            synchronized (this.f5593b) {
                this.f5597f.add(str);
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
            synchronized (this.f5593b) {
                this.j = z;
                Y();
            }
            return this;
        }
        return (c) invokeZ.objValue;
    }

    public final c.a.n0.a.o1.c.c L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Bundle D = D();
            D.putString("ipc_session_id", this.f5594c);
            D.putLong("ipc_session_timeout", this.i);
            D.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
            D.putString("ipc_topic", this.f5593b.W(this));
            c.a.n0.a.o1.c.c cVar = new c.a.n0.a.o1.c.c(V(), D);
            cVar.p(true);
            cVar.f(!SwanAppProcessInfo.current().isSwanService || this.j);
            for (Integer num : this.f5598g) {
                int intValue = num.intValue();
                if (SwanAppProcessInfo.checkProcessId(intValue)) {
                    cVar.a(intValue);
                }
            }
            for (String str : this.f5597f) {
                if (!TextUtils.isEmpty(str)) {
                    cVar.c(str);
                }
            }
            if (l) {
                U("createMsg", "msgCooker=" + cVar + " bundle=" + D);
            }
            return cVar;
        }
        return (c.a.n0.a.o1.c.c) invokeV.objValue;
    }

    public c M(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, exc)) == null) {
            synchronized (this.f5593b) {
                if (!R()) {
                    c.a.n0.a.t1.d.L().removeCallbacks(this.k);
                    this.i = -1L;
                    this.f5599h = exc;
                    this.f5595d.clear();
                    for (c.a.n0.a.p2.g1.c<c> cVar : this.f5596e) {
                        cVar.onCallback(this);
                    }
                    this.f5596e.clear();
                    this.j = false;
                    this.f5597f.clear();
                    this.f5598g.clear();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5599h : (Exception) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5599h != null : invokeV.booleanValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f5594c : (String) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i < 0 : invokeV.booleanValue;
    }

    public long S(long j) {
        InterceptResult invokeJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
            synchronized (this.f5593b) {
                if (Z()) {
                    this.i = Math.max(Math.max(j, b.d0), this.i);
                    Handler L = c.a.n0.a.t1.d.L();
                    if (this.i > 0) {
                        L.removeCallbacks(this.k);
                        L.postDelayed(this.k, this.i);
                    }
                }
                j2 = this.i;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && l) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
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
            int i = z ? 111 : 11;
            if (l) {
                U("msgType", "service=" + z + " msgType=" + i);
            }
            return i;
        }
        return invokeV.intValue;
    }

    public Exception W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            long nanoTime = l ? System.nanoTime() : 0L;
            TimeoutException timeoutException = new TimeoutException("#ipcHttpTimeout session=" + this + " processList=" + O());
            if (l) {
                Log.d("IpcSession", "#newIpcTimeoutException 耗时(ms): " + ((System.nanoTime() - nanoTime) / 1000000.0d));
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
            synchronized (this.f5593b) {
                z = (!Z() || this.f5595d.isEmpty() || aVar == null) ? false : true;
                if (z) {
                    for (c.a.n0.a.p2.g1.c<i.a> cVar : this.f5595d) {
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
            synchronized (this.f5593b) {
                z = (R() || P() || TextUtils.isEmpty(this.f5594c)) ? false : true;
                if (l) {
                    U("valid", z + " isFinished=" + R() + " hasException=" + this.f5599h + " id=" + this.f5594c);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.p2.g1.f
    public /* bridge */ /* synthetic */ c.a.n0.a.p2.g1.f a() {
        Y();
        return this;
    }

    public c call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? call(b.d0) : (c) invokeV.objValue;
    }

    @Override // c.a.n0.a.v0.e.f.c
    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                str = "IpcSession: id=" + this.f5594c + " timeout=" + this.i;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public c call(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j)) == null) {
            synchronized (this.f5593b) {
                if (l) {
                    U(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
                }
                if (Z()) {
                    long S = S(j);
                    if (l) {
                        U(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + S);
                    }
                    c.a.n0.a.o1.c.a.e().h(L());
                    b();
                } else {
                    this.f5593b.a0(this, new IllegalStateException("invalid session call"));
                }
                Y();
            }
            return this;
        }
        return (c) invokeJ.objValue;
    }
}
