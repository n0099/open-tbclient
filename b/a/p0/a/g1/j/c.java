package b.a.p0.a.g1.j;

import android.os.Handler;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
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
public class c implements b.a.p0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f5285a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5286b;

    /* renamed from: c  reason: collision with root package name */
    public long f5287c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5288d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final List<b.a.p0.a.g1.j.a> f5289e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f5290f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f5291g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5292e;

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
            this.f5292e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5292e.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5293e;

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
            this.f5293e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5293e.e();
            }
        }
    }

    /* renamed from: b.a.p0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0196c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f5294a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1142025325, "Lb/a/p0/a/g1/j/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1142025325, "Lb/a/p0/a/g1/j/c$c;");
                    return;
                }
            }
            f5294a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static b.a.p0.a.g1.j.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0196c.f5294a : (b.a.p0.a.g1.j.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f5287c;
            boolean z = this.f5286b && !this.f5288d && ProcessUtils.isSwanProcess() && n0.C(true);
            b.a.p0.a.e0.d.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.f5285a);
            if (z) {
                for (b.a.p0.a.g1.j.a aVar : this.f5289e) {
                    b.a.p0.a.e0.d.i("SwanBackStageManager", "performPause for strategy=" + aVar);
                    aVar.onPause();
                }
                this.f5288d = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.f5286b && this.f5288d;
            b.a.p0.a.e0.d.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (b.a.p0.a.g1.j.a aVar : this.f5289e) {
                b.a.p0.a.e0.d.i("SwanBackStageManager", "performResume for strategy=" + aVar);
                aVar.onResume();
            }
            this.f5288d = false;
        }
    }

    @Override // b.a.p0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.a.e0.d.i("SwanBackStageManager", "onPause: enable=" + this.f5286b + " delay=" + this.f5285a);
            if (this.f5286b) {
                this.f5287c = System.currentTimeMillis();
                Handler L = b.a.p0.a.d2.d.L();
                L.removeCallbacks(this.f5290f);
                L.removeCallbacks(this.f5291g);
                L.postDelayed(this.f5290f, this.f5285a);
            }
        }
    }

    @Override // b.a.p0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.p0.a.e0.d.i("SwanBackStageManager", "onResume: enable=" + this.f5286b);
            if (this.f5286b) {
                Handler L = b.a.p0.a.d2.d.L();
                L.removeCallbacks(this.f5290f);
                L.removeCallbacks(this.f5291g);
                q0.e0(this.f5291g);
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
        long millis = TimeUnit.SECONDS.toMillis(b.a.p0.a.g1.j.f.c.f5300b.a());
        this.f5285a = millis;
        this.f5286b = millis >= 0 && b.a.p0.a.g1.j.f.c.f5300b.e();
        this.f5287c = 0L;
        this.f5288d = false;
        this.f5290f = new a(this);
        this.f5291g = new b(this);
        this.f5289e = new ArrayList();
        if (b.a.p0.a.g1.j.f.c.f5300b.e()) {
            if (b.a.p0.a.g1.j.f.c.f5300b.d()) {
                this.f5289e.add(new d());
            }
            if (b.a.p0.a.g1.j.f.c.f5300b.b()) {
                this.f5289e.add(new e());
            }
            if (b.a.p0.a.g1.j.f.c.f5300b.c()) {
                this.f5289e.add(new b.a.p0.a.g1.j.b());
            }
        }
    }
}
