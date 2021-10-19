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
    public final Queue<Integer> f35062a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35063b;

    /* renamed from: c  reason: collision with root package name */
    public long f35064c;

    /* renamed from: d  reason: collision with root package name */
    public long f35065d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f35066e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35067f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f35068g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f35069e;

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
            this.f35069e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35069e.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f35070e;

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
            this.f35070e = kVar;
        }

        @Override // c.p.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35070e.f35062a.isEmpty()) {
                return;
            }
            long c2 = c.p.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - this.f35070e.f35065d;
            if (currentTimeMillis < c2) {
                if (this.f35070e.f35067f.hasCallbacks(this.f35070e.f35068g)) {
                    return;
                }
                this.f35070e.f35067f.postDelayed(this.f35070e.f35068g, c2 - currentTimeMillis);
                return;
            }
            this.f35070e.f35065d = System.currentTimeMillis();
            this.f35070e.l();
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
        public final /* synthetic */ Context f35071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f35072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f35073g;

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
            this.f35073g = kVar;
            this.f35071e = context;
            this.f35072f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35073g.h(this.f35071e, this.f35072f.intValue(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f35074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f35075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f35076g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f35077h;

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
            this.f35077h = kVar;
            this.f35074e = context;
            this.f35075f = i2;
            this.f35076g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35077h.a(this.f35074e, this.f35075f, this.f35076g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final k f35078a;
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
            f35078a = new k(null);
        }
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? e.f35078a : (k) invokeV.objValue;
    }

    public int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return h(context, i2, z);
            }
            if (n()) {
                this.f35067f.postDelayed(new d(this, context, i2, z), 1000L);
                return 1;
            } else if (c.p.a.e.b.a.a.c().k()) {
                c.p.a.e.b.c.a.i("leaves", "on Foreground");
                return h(context, i2, z);
            } else if (c.p.a.e.a.c.k()) {
                return 1;
            } else {
                boolean z2 = Build.VERSION.SDK_INT < 29;
                if (this.f35062a.isEmpty() && !this.f35063b && z2) {
                    return h(context, i2, z);
                }
                int b2 = c.p.a.e.b.j.a.r().b("install_queue_size", 3);
                synchronized (this.f35062a) {
                    while (this.f35062a.size() > b2) {
                        this.f35062a.poll();
                    }
                }
                if (z2) {
                    this.f35067f.removeCallbacks(this.f35068g);
                    this.f35067f.postDelayed(this.f35068g, c.p.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
                }
                synchronized (this.f35062a) {
                    if (!this.f35062a.contains(Integer.valueOf(i2))) {
                        this.f35062a.offer(Integer.valueOf(i2));
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
            this.f35066e = new SoftReference<>(jumpUnknownSourceActivity);
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
                this.f35063b = true;
            }
            this.f35064c = System.currentTimeMillis();
            return D;
        }
        return invokeCommon.intValue;
    }

    public JumpUnknownSourceActivity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SoftReference<JumpUnknownSourceActivity> softReference = this.f35066e;
            JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
            this.f35066e = null;
            return jumpUnknownSourceActivity;
        }
        return (JumpUnknownSourceActivity) invokeV.objValue;
    }

    public final void l() {
        Integer poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (Build.VERSION.SDK_INT < 29 || c.p.a.e.b.a.a.c().k()) {
                synchronized (this.f35062a) {
                    poll = this.f35062a.poll();
                }
                this.f35067f.removeCallbacks(this.f35068g);
                if (poll != null) {
                    Context n = c.p.a.e.b.g.e.n();
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        this.f35067f.post(new c(this, n, poll));
                    } else {
                        h(n, poll.intValue(), false);
                    }
                    this.f35067f.postDelayed(this.f35068g, 20000L);
                    return;
                }
                this.f35063b = false;
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? System.currentTimeMillis() - this.f35064c < 1000 : invokeV.booleanValue;
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
        this.f35062a = new ArrayDeque();
        this.f35063b = false;
        this.f35067f = new Handler(Looper.getMainLooper());
        this.f35068g = new a(this);
        c.p.a.e.b.a.a.c().f(new b(this));
    }
}
