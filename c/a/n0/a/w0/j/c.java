package c.a.n0.a.w0.j;

import android.os.Handler;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
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
public class c implements c.a.n0.a.w0.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6959b;

    /* renamed from: c  reason: collision with root package name */
    public long f6960c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6961d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.n0.a.w0.j.a> f6962e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f6963f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f6964g;

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
                this.a.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
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
                this.a.e();
            }
        }
    }

    /* renamed from: c.a.n0.a.w0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0511c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(558759551, "Lc/a/n0/a/w0/j/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(558759551, "Lc/a/n0/a/w0/j/c$c;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c.a.n0.a.w0.j.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0511c.a : (c.a.n0.a.w0.j.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f6960c;
            boolean z = this.f6959b && !this.f6961d && ProcessUtils.isSwanProcess() && n0.C(true);
            c.a.n0.a.u.d.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.a);
            if (z) {
                for (c.a.n0.a.w0.j.a aVar : this.f6962e) {
                    c.a.n0.a.u.d.i("SwanBackStageManager", "performPause for strategy=" + aVar);
                    aVar.onPause();
                }
                this.f6961d = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.f6959b && this.f6961d;
            c.a.n0.a.u.d.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (c.a.n0.a.w0.j.a aVar : this.f6962e) {
                c.a.n0.a.u.d.i("SwanBackStageManager", "performResume for strategy=" + aVar);
                aVar.onResume();
            }
            this.f6961d = false;
        }
    }

    @Override // c.a.n0.a.w0.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.n0.a.u.d.i("SwanBackStageManager", "onPause: enable=" + this.f6959b + " delay=" + this.a);
            if (this.f6959b) {
                this.f6960c = System.currentTimeMillis();
                Handler L = c.a.n0.a.t1.d.L();
                L.removeCallbacks(this.f6963f);
                L.removeCallbacks(this.f6964g);
                L.postDelayed(this.f6963f, this.a);
            }
        }
    }

    @Override // c.a.n0.a.w0.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.n0.a.u.d.i("SwanBackStageManager", "onResume: enable=" + this.f6959b);
            if (this.f6959b) {
                Handler L = c.a.n0.a.t1.d.L();
                L.removeCallbacks(this.f6963f);
                L.removeCallbacks(this.f6964g);
                q0.e0(this.f6964g);
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long millis = TimeUnit.SECONDS.toMillis(c.a.n0.a.w0.j.f.c.f6967b.a());
        this.a = millis;
        this.f6959b = millis >= 0 && c.a.n0.a.w0.j.f.c.f6967b.e();
        this.f6960c = 0L;
        this.f6961d = false;
        this.f6963f = new a(this);
        this.f6964g = new b(this);
        this.f6962e = new ArrayList();
        if (c.a.n0.a.w0.j.f.c.f6967b.e()) {
            if (c.a.n0.a.w0.j.f.c.f6967b.d()) {
                this.f6962e.add(new d());
            }
            if (c.a.n0.a.w0.j.f.c.f6967b.b()) {
                this.f6962e.add(new e());
            }
            if (c.a.n0.a.w0.j.f.c.f6967b.c()) {
                this.f6962e.add(new c.a.n0.a.w0.j.b());
            }
        }
    }
}
