package c.a.p0.a.w0.j;

import android.os.Handler;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q0;
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
public class c implements c.a.p0.a.w0.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f8220b;

    /* renamed from: c  reason: collision with root package name */
    public long f8221c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8222d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.p0.a.w0.j.a> f8223e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f8224f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f8225g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8226e;

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
            this.f8226e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8226e.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8227e;

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
            this.f8227e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8227e.e();
            }
        }
    }

    /* renamed from: c.a.p0.a.w0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0519c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-452357699, "Lc/a/p0/a/w0/j/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-452357699, "Lc/a/p0/a/w0/j/c$c;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c.a.p0.a.w0.j.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0519c.a : (c.a.p0.a.w0.j.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f8221c;
            boolean z = this.f8220b && !this.f8222d && ProcessUtils.isSwanProcess() && n0.C(true);
            c.a.p0.a.u.d.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.a);
            if (z) {
                for (c.a.p0.a.w0.j.a aVar : this.f8223e) {
                    c.a.p0.a.u.d.i("SwanBackStageManager", "performPause for strategy=" + aVar);
                    aVar.onPause();
                }
                this.f8222d = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.f8220b && this.f8222d;
            c.a.p0.a.u.d.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (c.a.p0.a.w0.j.a aVar : this.f8223e) {
                c.a.p0.a.u.d.i("SwanBackStageManager", "performResume for strategy=" + aVar);
                aVar.onResume();
            }
            this.f8222d = false;
        }
    }

    @Override // c.a.p0.a.w0.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.a.u.d.i("SwanBackStageManager", "onPause: enable=" + this.f8220b + " delay=" + this.a);
            if (this.f8220b) {
                this.f8221c = System.currentTimeMillis();
                Handler L = c.a.p0.a.t1.d.L();
                L.removeCallbacks(this.f8224f);
                L.removeCallbacks(this.f8225g);
                L.postDelayed(this.f8224f, this.a);
            }
        }
    }

    @Override // c.a.p0.a.w0.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.a.u.d.i("SwanBackStageManager", "onResume: enable=" + this.f8220b);
            if (this.f8220b) {
                Handler L = c.a.p0.a.t1.d.L();
                L.removeCallbacks(this.f8224f);
                L.removeCallbacks(this.f8225g);
                q0.e0(this.f8225g);
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
        long millis = TimeUnit.SECONDS.toMillis(c.a.p0.a.w0.j.f.c.f8230b.a());
        this.a = millis;
        this.f8220b = millis >= 0 && c.a.p0.a.w0.j.f.c.f8230b.e();
        this.f8221c = 0L;
        this.f8222d = false;
        this.f8224f = new a(this);
        this.f8225g = new b(this);
        this.f8223e = new ArrayList();
        if (c.a.p0.a.w0.j.f.c.f8230b.e()) {
            if (c.a.p0.a.w0.j.f.c.f8230b.d()) {
                this.f8223e.add(new d());
            }
            if (c.a.p0.a.w0.j.f.c.f8230b.b()) {
                this.f8223e.add(new e());
            }
            if (c.a.p0.a.w0.j.f.c.f8230b.c()) {
                this.f8223e.add(new c.a.p0.a.w0.j.b());
            }
        }
    }
}
