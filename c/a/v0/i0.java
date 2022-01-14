package c.a.v0;

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
/* loaded from: classes9.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static volatile i0 u;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long f26437b;

    /* renamed from: c  reason: collision with root package name */
    public e f26438c;

    /* renamed from: d  reason: collision with root package name */
    public Application f26439d;

    /* renamed from: e  reason: collision with root package name */
    public y f26440e;

    /* renamed from: f  reason: collision with root package name */
    public int f26441f;

    /* renamed from: g  reason: collision with root package name */
    public int f26442g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26443h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26444i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26445j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public volatile boolean p;
    public int q;
    public long r;
    public Runnable s;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i0 f26446e;

        public a(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26446e = i0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26446e.k();
                c.a.v0.d.w().J(this.f26446e.s, 5000L);
            }
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                boolean unused2 = i0.t;
            }
        }

        public /* synthetic */ b(i0 i0Var, a aVar) {
            this(i0Var);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i0 f26447e;

        public c(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26447e = i0Var;
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
                i0.d(this.f26447e);
                if (this.f26447e.a == 1) {
                    this.f26447e.r();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                i0.e(this.f26447e);
                if (this.f26447e.a == 0) {
                    this.f26447e.u();
                }
            }
        }

        public /* synthetic */ c(i0 i0Var, a aVar) {
            this(i0Var);
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f26448b;

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
    }

    /* loaded from: classes9.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1014349307, "Lc/a/v0/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1014349307, "Lc/a/v0/i0;");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26437b = 0L;
        this.f26441f = 0;
        this.f26442g = 0;
        this.f26443h = false;
        this.f26444i = false;
        this.f26445j = false;
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
        int i2 = i0Var.a;
        i0Var.a = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int e(i0 i0Var) {
        int i2 = i0Var.a;
        i0Var.a = i2 - 1;
        return i2;
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
            boolean z = t;
            e eVar = this.f26438c;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (t) {
                String str = "onUploadFinish isSuccess: " + z;
            }
            this.q = Math.max(this.q - 1, 0);
            if (z) {
                C();
            }
            if (this.f26443h) {
                this.r = SystemClock.uptimeMillis();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(true, 0, 0);
            if (this.f26445j && this.q == 0) {
                boolean z = t;
                c.a.v0.d.w().H();
            }
        }
    }

    public final void j(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && this.f26444i) {
            if (z) {
                if (q()) {
                    return;
                }
                v();
                return;
            }
            boolean q = q();
            this.f26442g += i2;
            this.f26441f += i3;
            if (!q || q()) {
                return;
            }
            v();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f26443h && this.q == 0 && SystemClock.uptimeMillis() - this.r >= this.o) {
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
        this.f26439d = application;
        application.registerActivityLifecycleCallbacks(new c(this, null));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f26439d.registerReceiver(new b(this, null), intentFilter);
        this.f26440e = yVar;
        this.f26438c = eVar;
        this.k = b0.i().a();
        this.l = b0.i().f();
        if (this.k) {
            this.f26440e.k();
        }
        this.m = b0.i().o();
        d s = this.f26440e.s();
        this.f26441f = Math.max(s.a, 0);
        this.f26442g = Math.max(s.f26448b, 0);
        this.f26444i = b0.i().k();
        this.f26443h = b0.i().e();
        this.f26445j = b0.i().p();
        this.n = g.o().A();
        int B = g.o().B() * 1000;
        this.o = B;
        if (!this.f26443h || B <= 0 || this.p) {
            return;
        }
        c.a.v0.d.w().J(this.s, 5000L);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26441f + this.f26442g < this.n : invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = t;
            e eVar = this.f26438c;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || !this.f26444i || i2 < 0 || i3 < 0 || i2 + i3 == 0) {
            return;
        }
        if (t) {
            String str = "onClearData eventCount=" + i2 + ", flowCount=" + i3;
        }
        this.f26441f = Math.max(this.f26441f - i2, 0);
        this.f26442g = Math.max(this.f26442g - i3, 0);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f26444i) {
            boolean z = t;
            d s = this.f26440e.s();
            this.f26441f = Math.max(s.a, 0);
            this.f26442g = Math.max(s.f26448b, 0);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = t;
            e eVar = this.f26438c;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            boolean z = t;
            e eVar = this.f26438c;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean z = t;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f26437b > 60000) {
                e eVar = this.f26438c;
                if (eVar != null) {
                    eVar.e();
                }
                boolean z2 = t;
            }
            this.f26437b = currentTimeMillis;
        }
    }

    public void x(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) && this.f26444i && i2 == -1 && !g.o().f(str) && g.o().i(str)) {
            if (t) {
                String str2 = "onNewEvent id=" + str + ", currentEventCount=" + this.f26441f;
            }
            j(false, 0, 1);
        }
    }

    public void y(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, str, i2) == null) && this.f26444i && i2 > 0 && !g.o().f(str) && g.o().i(str)) {
            if (t) {
                String str2 = "onNewFlow id=" + str + ", currentFlowCount=" + this.f26442g;
            }
            j(false, i2, 0);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q++;
        }
    }
}
