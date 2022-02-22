package c.a.s0.a.g1.j;

import android.os.Handler;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c implements c.a.s0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6487b;

    /* renamed from: c  reason: collision with root package name */
    public long f6488c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6489d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.s0.a.g1.j.a> f6490e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f6491f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f6492g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6493e;

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
            this.f6493e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6493e.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6494e;

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
            this.f6494e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6494e.e();
            }
        }
    }

    /* renamed from: c.a.s0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0365c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371722903, "Lc/a/s0/a/g1/j/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1371722903, "Lc/a/s0/a/g1/j/c$c;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c.a.s0.a.g1.j.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0365c.a : (c.a.s0.a.g1.j.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f6488c;
            boolean z = this.f6487b && !this.f6489d && ProcessUtils.isSwanProcess() && n0.C(true);
            c.a.s0.a.e0.d.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.a);
            if (z) {
                for (c.a.s0.a.g1.j.a aVar : this.f6490e) {
                    c.a.s0.a.e0.d.i("SwanBackStageManager", "performPause for strategy=" + aVar);
                    aVar.onPause();
                }
                this.f6489d = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.f6487b && this.f6489d;
            c.a.s0.a.e0.d.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (c.a.s0.a.g1.j.a aVar : this.f6490e) {
                c.a.s0.a.e0.d.i("SwanBackStageManager", "performResume for strategy=" + aVar);
                aVar.onResume();
            }
            this.f6489d = false;
        }
    }

    @Override // c.a.s0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.a.e0.d.i("SwanBackStageManager", "onPause: enable=" + this.f6487b + " delay=" + this.a);
            if (this.f6487b) {
                this.f6488c = System.currentTimeMillis();
                Handler L = c.a.s0.a.d2.d.L();
                L.removeCallbacks(this.f6491f);
                L.removeCallbacks(this.f6492g);
                L.postDelayed(this.f6491f, this.a);
            }
        }
    }

    @Override // c.a.s0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.a.e0.d.i("SwanBackStageManager", "onResume: enable=" + this.f6487b);
            if (this.f6487b) {
                Handler L = c.a.s0.a.d2.d.L();
                L.removeCallbacks(this.f6491f);
                L.removeCallbacks(this.f6492g);
                q0.e0(this.f6492g);
            }
        }
    }

    public c() {
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
        long millis = TimeUnit.SECONDS.toMillis(c.a.s0.a.g1.j.f.c.f6497b.a());
        this.a = millis;
        this.f6487b = millis >= 0 && c.a.s0.a.g1.j.f.c.f6497b.e();
        this.f6488c = 0L;
        this.f6489d = false;
        this.f6491f = new a(this);
        this.f6492g = new b(this);
        this.f6490e = new ArrayList();
        if (c.a.s0.a.g1.j.f.c.f6497b.e()) {
            if (c.a.s0.a.g1.j.f.c.f6497b.d()) {
                this.f6490e.add(new d());
            }
            if (c.a.s0.a.g1.j.f.c.f6497b.b()) {
                this.f6490e.add(new e());
            }
            if (c.a.s0.a.g1.j.f.c.f6497b.c()) {
                this.f6490e.add(new c.a.s0.a.g1.j.b());
            }
        }
    }
}
