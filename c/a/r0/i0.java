package c.a.r0;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static volatile i0 u;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long f21142b;

    /* renamed from: c  reason: collision with root package name */
    public e f21143c;

    /* renamed from: d  reason: collision with root package name */
    public Application f21144d;

    /* renamed from: e  reason: collision with root package name */
    public y f21145e;

    /* renamed from: f  reason: collision with root package name */
    public int f21146f;

    /* renamed from: g  reason: collision with root package name */
    public int f21147g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21148h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public volatile boolean p;
    public int q;
    public long r;
    public Runnable s;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i0 a;

        public a(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
                c.a.r0.d.w().J(this.a.s, 5000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i0 this$0;

        public b(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = i0Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
                return;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    return;
                }
                this.this$0.w();
            } catch (Exception unused) {
                if (i0.t) {
                    Log.d("UBCUploadTimingManager", "get network info error!");
                }
            }
        }

        public /* synthetic */ b(i0 i0Var, a aVar) {
            this(i0Var);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i0 a;

        public c(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                i0.d(this.a);
                if (this.a.a == 1) {
                    this.a.r();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                i0.e(this.a);
                if (this.a.a == 0) {
                    this.a.u();
                }
            }
        }

        public /* synthetic */ c(i0 i0Var, a aVar) {
            this(i0Var);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f21149b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1128865911, "Lc/a/r0/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1128865911, "Lc/a/r0/i0;");
                return;
            }
        }
        t = b0.m();
    }

    public i0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21142b = 0L;
        this.f21146f = 0;
        this.f21147g = 0;
        this.f21148h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = 10000;
        this.m = false;
        this.n = 100;
        this.o = TiebaStatic.MAX_COST_VALUE;
        this.p = false;
        this.q = 0;
        this.r = SystemClock.uptimeMillis();
        this.s = new a(this);
    }

    public static /* synthetic */ int d(i0 i0Var) {
        int i = i0Var.a;
        i0Var.a = i + 1;
        return i;
    }

    public static /* synthetic */ int e(i0 i0Var) {
        int i = i0Var.a;
        i0Var.a = i - 1;
        return i;
    }

    public static i0 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (u == null) {
                synchronized (i0.class) {
                    if (u == null) {
                        u = new i0();
                    }
                }
            }
            return u;
        }
        return (i0) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onTimerArrived");
            }
            e eVar = this.f21143c;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onUploadFinish isSuccess: " + z);
            }
            this.q = Math.max(this.q - 1, 0);
            if (z) {
                C();
            }
            if (this.f21148h) {
                this.r = SystemClock.uptimeMillis();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(true, 0, 0);
            if (this.j && this.q == 0) {
                if (t) {
                    Log.d("UBCUploadTimingManager", "onUploadSuccess processOneFailedData");
                }
                c.a.r0.d.w().H();
            }
        }
    }

    public final void j(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) && this.i) {
            if (z) {
                if (q()) {
                    return;
                }
                v();
                return;
            }
            boolean q = q();
            this.f21147g += i;
            this.f21146f += i2;
            if (!q || q()) {
                return;
            }
            v();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f21148h && this.q == 0 && SystemClock.uptimeMillis() - this.r >= this.o) {
            A();
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.k) {
                return this.l;
            }
            return g.o().l();
        }
        return invokeV.intValue;
    }

    public void n(Context context, y yVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, context, yVar, eVar) == null) || context == null) {
            return;
        }
        Application application = (Application) context.getApplicationContext();
        this.f21144d = application;
        application.registerActivityLifecycleCallbacks(new c(this, null));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f21144d.registerReceiver(new b(this, null), intentFilter);
        this.f21145e = yVar;
        this.f21143c = eVar;
        this.k = b0.i().a();
        this.l = b0.i().f();
        if (this.k) {
            this.f21145e.k();
        }
        this.m = b0.i().o();
        d s = this.f21145e.s();
        this.f21146f = Math.max(s.a, 0);
        this.f21147g = Math.max(s.f21149b, 0);
        this.i = b0.i().k();
        this.f21148h = b0.i().e();
        this.j = b0.i().p();
        this.n = g.o().A();
        int B = g.o().B() * 1000;
        this.o = B;
        if (!this.f21148h || B <= 0 || this.p) {
            return;
        }
        c.a.r0.d.w().J(this.s, 5000L);
        this.p = true;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f21146f + this.f21147g < this.n : invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onBackgroundToForeground");
            }
            e eVar = this.f21143c;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public void s(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) || !this.i || i < 0 || i2 < 0 || i + i2 == 0) {
            return;
        }
        if (t) {
            Log.d("UBCUploadTimingManager", "onClearData eventCount=" + i + ", flowCount=" + i2);
        }
        this.f21146f = Math.max(this.f21146f - i, 0);
        this.f21147g = Math.max(this.f21147g - i2, 0);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.i) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onClearDataAndReset");
            }
            d s = this.f21145e.s();
            this.f21146f = Math.max(s.a, 0);
            this.f21147g = Math.max(s.f21149b, 0);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onForegroundToBackground");
            }
            e eVar = this.f21143c;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onLogTooMany");
            }
            e eVar = this.f21143c;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onNetworkAvailable");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f21142b > 60000) {
                e eVar = this.f21143c;
                if (eVar != null) {
                    eVar.e();
                }
                if (t) {
                    Log.d("UBCUploadTimingManager", "onNetworkAvailable filter completed!");
                }
            }
            this.f21142b = currentTimeMillis;
        }
    }

    public void x(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) && this.i && i == -1 && !g.o().f(str) && g.o().i(str)) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onNewEvent id=" + str + ", currentEventCount=" + this.f21146f);
            }
            j(false, 0, 1);
        }
    }

    public void y(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) && this.i && i > 0 && !g.o().f(str) && g.o().i(str)) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onNewFlow id=" + str + ", currentFlowCount=" + this.f21147g);
            }
            j(false, i, 0);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q++;
        }
    }
}
