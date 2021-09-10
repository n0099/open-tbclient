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
    public final Queue<Integer> f35035a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35036b;

    /* renamed from: c  reason: collision with root package name */
    public long f35037c;

    /* renamed from: d  reason: collision with root package name */
    public long f35038d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f35039e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35040f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f35041g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f35042e;

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
            this.f35042e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35042e.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f35043e;

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
            this.f35043e = kVar;
        }

        @Override // c.p.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35043e.f35035a.isEmpty()) {
                return;
            }
            long c2 = c.p.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - this.f35043e.f35038d;
            if (currentTimeMillis < c2) {
                if (this.f35043e.f35040f.hasCallbacks(this.f35043e.f35041g)) {
                    return;
                }
                this.f35043e.f35040f.postDelayed(this.f35043e.f35041g, c2 - currentTimeMillis);
                return;
            }
            this.f35043e.f35038d = System.currentTimeMillis();
            this.f35043e.l();
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
        public final /* synthetic */ Context f35044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f35045f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f35046g;

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
            this.f35046g = kVar;
            this.f35044e = context;
            this.f35045f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35046g.h(this.f35044e, this.f35045f.intValue(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f35047e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f35048f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f35049g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f35050h;

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
            this.f35050h = kVar;
            this.f35047e = context;
            this.f35048f = i2;
            this.f35049g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35050h.a(this.f35047e, this.f35048f, this.f35049g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final k f35051a;
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
            f35051a = new k(null);
        }
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? e.f35051a : (k) invokeV.objValue;
    }

    public int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return h(context, i2, z);
            }
            if (n()) {
                this.f35040f.postDelayed(new d(this, context, i2, z), 1000L);
                return 1;
            } else if (c.p.a.e.b.a.a.c().k()) {
                c.p.a.e.b.c.a.i("leaves", "on Foreground");
                return h(context, i2, z);
            } else if (c.p.a.e.a.c.k()) {
                return 1;
            } else {
                boolean z2 = Build.VERSION.SDK_INT < 29;
                if (this.f35035a.isEmpty() && !this.f35036b && z2) {
                    return h(context, i2, z);
                }
                int b2 = c.p.a.e.b.j.a.r().b("install_queue_size", 3);
                synchronized (this.f35035a) {
                    while (this.f35035a.size() > b2) {
                        this.f35035a.poll();
                    }
                }
                if (z2) {
                    this.f35040f.removeCallbacks(this.f35041g);
                    this.f35040f.postDelayed(this.f35041g, c.p.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
                }
                synchronized (this.f35035a) {
                    if (!this.f35035a.contains(Integer.valueOf(i2))) {
                        this.f35035a.offer(Integer.valueOf(i2));
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
            this.f35039e = new SoftReference<>(jumpUnknownSourceActivity);
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
                this.f35036b = true;
            }
            this.f35037c = System.currentTimeMillis();
            return D;
        }
        return invokeCommon.intValue;
    }

    public JumpUnknownSourceActivity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SoftReference<JumpUnknownSourceActivity> softReference = this.f35039e;
            JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
            this.f35039e = null;
            return jumpUnknownSourceActivity;
        }
        return (JumpUnknownSourceActivity) invokeV.objValue;
    }

    public final void l() {
        Integer poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (Build.VERSION.SDK_INT < 29 || c.p.a.e.b.a.a.c().k()) {
                synchronized (this.f35035a) {
                    poll = this.f35035a.poll();
                }
                this.f35040f.removeCallbacks(this.f35041g);
                if (poll != null) {
                    Context n = c.p.a.e.b.g.e.n();
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        this.f35040f.post(new c(this, n, poll));
                    } else {
                        h(n, poll.intValue(), false);
                    }
                    this.f35040f.postDelayed(this.f35041g, 20000L);
                    return;
                }
                this.f35036b = false;
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? System.currentTimeMillis() - this.f35037c < 1000 : invokeV.booleanValue;
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
        this.f35035a = new ArrayDeque();
        this.f35036b = false;
        this.f35040f = new Handler(Looper.getMainLooper());
        this.f35041g = new a(this);
        c.p.a.e.b.a.a.c().f(new b(this));
    }
}
