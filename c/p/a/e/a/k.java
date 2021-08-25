package c.p.a.e.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Integer> f34926a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34927b;

    /* renamed from: c  reason: collision with root package name */
    public long f34928c;

    /* renamed from: d  reason: collision with root package name */
    public long f34929d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f34930e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f34931f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f34932g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f34933e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34933e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34933e.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f34934e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34934e = kVar;
        }

        @Override // c.p.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34934e.f34926a.isEmpty()) {
                return;
            }
            long c2 = c.p.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - this.f34934e.f34929d;
            if (currentTimeMillis < c2) {
                if (this.f34934e.f34931f.hasCallbacks(this.f34934e.f34932g)) {
                    return;
                }
                this.f34934e.f34931f.postDelayed(this.f34934e.f34932g, c2 - currentTimeMillis);
                return;
            }
            this.f34934e.f34929d = System.currentTimeMillis();
            this.f34934e.l();
        }

        @Override // c.p.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f34935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f34936f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f34937g;

        public c(k kVar, Context context, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34937g = kVar;
            this.f34935e = context;
            this.f34936f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34937g.h(this.f34935e, this.f34936f.intValue(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f34938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f34939f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f34940g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f34941h;

        public d(k kVar, Context context, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34941h = kVar;
            this.f34938e = context;
            this.f34939f = i2;
            this.f34940g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34941h.a(this.f34938e, this.f34939f, this.f34940g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final k f34942a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1501999220, "Lc/p/a/e/a/k$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1501999220, "Lc/p/a/e/a/k$e;");
                    return;
                }
            }
            f34942a = new k(null);
        }
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? e.f34942a : (k) invokeV.objValue;
    }

    public int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return h(context, i2, z);
            }
            if (n()) {
                this.f34931f.postDelayed(new d(this, context, i2, z), 1000L);
                return 1;
            } else if (c.p.a.e.b.a.a.c().k()) {
                c.p.a.e.b.c.a.i("leaves", "on Foreground");
                return h(context, i2, z);
            } else if (c.p.a.e.a.c.k()) {
                return 1;
            } else {
                boolean z2 = Build.VERSION.SDK_INT < 29;
                if (this.f34926a.isEmpty() && !this.f34927b && z2) {
                    return h(context, i2, z);
                }
                int b2 = c.p.a.e.b.j.a.r().b("install_queue_size", 3);
                synchronized (this.f34926a) {
                    while (this.f34926a.size() > b2) {
                        this.f34926a.poll();
                    }
                }
                if (z2) {
                    this.f34931f.removeCallbacks(this.f34932g);
                    this.f34931f.postDelayed(this.f34932g, c.p.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
                }
                synchronized (this.f34926a) {
                    if (!this.f34926a.contains(Integer.valueOf(i2))) {
                        this.f34926a.offer(Integer.valueOf(i2));
                    }
                }
                return 1;
            }
        }
        return invokeCommon.intValue;
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jumpUnknownSourceActivity) == null) {
            this.f34930e = new SoftReference<>(jumpUnknownSourceActivity);
        }
    }

    public void g(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, str) == null) || downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        l();
    }

    public final int h(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int D = c.p.a.e.a.d.D(context, i2, z);
            if (D == 1) {
                this.f34927b = true;
            }
            this.f34928c = System.currentTimeMillis();
            return D;
        }
        return invokeCommon.intValue;
    }

    public JumpUnknownSourceActivity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SoftReference<JumpUnknownSourceActivity> softReference = this.f34930e;
            JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
            this.f34930e = null;
            return jumpUnknownSourceActivity;
        }
        return (JumpUnknownSourceActivity) invokeV.objValue;
    }

    public final void l() {
        Integer poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (Build.VERSION.SDK_INT < 29 || c.p.a.e.b.a.a.c().k()) {
                synchronized (this.f34926a) {
                    poll = this.f34926a.poll();
                }
                this.f34931f.removeCallbacks(this.f34932g);
                if (poll != null) {
                    Context n = c.p.a.e.b.g.e.n();
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        this.f34931f.post(new c(this, n, poll));
                    } else {
                        h(n, poll.intValue(), false);
                    }
                    this.f34931f.postDelayed(this.f34932g, 20000L);
                    return;
                }
                this.f34927b = false;
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? System.currentTimeMillis() - this.f34928c < 1000 : invokeV.booleanValue;
    }

    public k() {
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
        this.f34926a = new ArrayDeque();
        this.f34927b = false;
        this.f34931f = new Handler(Looper.getMainLooper());
        this.f34932g = new a(this);
        c.p.a.e.b.a.a.c().f(new b(this));
    }
}
