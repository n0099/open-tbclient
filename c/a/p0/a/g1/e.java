package c.a.p0.a.g1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5772e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f5773a;

    /* renamed from: b  reason: collision with root package name */
    public a f5774b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5775c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.a.g1.j.a f5776d;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f5777a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f5778b;

        /* renamed from: c  reason: collision with root package name */
        public long f5779c;

        /* renamed from: d  reason: collision with root package name */
        public int f5780d;

        /* renamed from: c.a.p0.a.g1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0194a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f5781e;

            public C0194a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5781e = aVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (e.f5772e) {
                        String str = "task run: " + this.f5781e.f5779c;
                    }
                    this.f5781e.f5779c -= 10;
                    if (this.f5781e.f5779c > 0 || this.f5781e.f5777a == null) {
                        return;
                    }
                    this.f5781e.f5777a.g(1);
                    this.f5781e.l();
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5779c = 300L;
            this.f5780d = 0;
        }

        public final synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.f5778b != null) {
                        this.f5778b.cancel();
                        this.f5778b.purge();
                        this.f5778b = null;
                    }
                }
            }
        }

        public final TimerTask e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C0194a(this) : (TimerTask) invokeV.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f5780d == 2) {
                return;
            }
            this.f5780d = 4;
            d();
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f5779c = c.a.p0.a.r1.l.c.a();
                if (e.f5772e && c.a.p0.a.u1.a.a.t().getBoolean("swan_5min_back_optimize", false)) {
                    this.f5779c = 30L;
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f5780d == 4) {
                this.f5780d = 3;
                d();
                i();
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Timer timer = new Timer();
                this.f5778b = timer;
                timer.schedule(e(), 0L, 10000L);
            }
        }

        public void j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
                this.f5777a = bVar;
            }
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f5780d = 1;
                g();
                d();
                i();
            }
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f5780d = 2;
                d();
                g();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(int i2);
    }

    /* loaded from: classes.dex */
    public static class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<e> mPolicyRef;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPolicyRef = new WeakReference<>(eVar);
        }

        public static IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                return intentFilter;
            }
            return (IntentFilter) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || TextUtils.isEmpty(intent.getAction()) || (eVar = this.mPolicyRef.get()) == null) {
                return;
            }
            String action = intent.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -2128145023) {
                if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                    c2 = 0;
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                c2 = 1;
            }
            if (c2 == 0) {
                eVar.d(true);
            } else if (c2 != 1) {
            } else {
                eVar.d(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(818113380, "Lc/a/p0/a/g1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(818113380, "Lc/a/p0/a/g1/e;");
                return;
            }
        }
        f5772e = k.f7085a;
    }

    public e() {
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
        this.f5773a = new c(this);
        this.f5774b = new a();
        this.f5776d = c.a.p0.a.g1.j.c.f();
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || this.f5775c) {
            return;
        }
        if (context == null && (context = c.a.p0.a.c1.a.b()) == null) {
            return;
        }
        this.f5775c = true;
        context.registerReceiver(this.f5773a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (f5772e) {
                String str = "onScreenStatusChanged isOn: " + z;
            }
            if (z) {
                g();
            } else {
                e();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f5774b.f();
        }
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && this.f5775c) {
            if (context == null && (context = c.a.p0.a.c1.a.b()) == null) {
                return;
            }
            this.f5775c = false;
            try {
                context.unregisterReceiver(this.f5773a);
            } catch (IllegalArgumentException e2) {
                if (f5772e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f5774b.h();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f5774b.j(bVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean z = f5772e;
            this.f5776d.onPause();
            this.f5774b.k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = f5772e;
            this.f5776d.onResume();
            this.f5774b.l();
        }
    }
}
