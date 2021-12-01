package c.a.t0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f26288k;
    public static volatile d l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f26289b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f26290c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.g f26291d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.c f26292e;

    /* renamed from: f  reason: collision with root package name */
    public int f26293f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26294g;

    /* renamed from: h  reason: collision with root package name */
    public v f26295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26296i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26297j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26298e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26298e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26298e.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26298e.f26292e.E();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.n f26299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f26300f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26301g;

        public b(d dVar, c.a.t0.n nVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, nVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26301g = dVar;
            this.f26299e = nVar;
            this.f26300f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26301g.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26301g.f26292e.w(this.f26299e, this.f26300f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f26302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26303f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26304g;

        public c(d dVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26304g = dVar;
            this.f26302e = z;
            this.f26303f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26304g.f26292e == null) {
                    boolean unused = d.f26288k;
                    return;
                }
                if (this.f26302e) {
                    this.f26304g.f26292e.Q(this.f26303f);
                } else {
                    this.f26304g.f26292e.P(this.f26303f);
                }
                i0.m().B(this.f26302e);
            }
        }
    }

    /* renamed from: c.a.t0.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1508d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26305e;

        public RunnableC1508d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26305e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26305e.f26292e == null) {
                return;
            }
            this.f26305e.f26292e.S();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26306e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26306e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26306e.f26292e == null) {
                    boolean unused = d.f26288k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - k0.a().c("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f26306e.f26292e.S();
                long currentTimeMillis = System.currentTimeMillis();
                k0.a().e("ubc_last_upload_all_time", currentTimeMillis);
                k0.a().e("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26307e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26307e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26307e.f26292e == null) {
                return;
            }
            this.f26307e.f26292e.M();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26308e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26308e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26308e.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26308e.f26292e.m();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1507c f26309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26310f;

        public h(d dVar, c.C1507c c1507c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1507c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26310f = dVar;
            this.f26309e = c1507c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26310f.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26310f.f26292e.N(this.f26309e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1507c f26311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26312f;

        public i(d dVar, c.C1507c c1507c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1507c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26312f = dVar;
            this.f26311e = c1507c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26312f.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26312f.f26292e.N(this.f26311e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26313e;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26313e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26313e.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26313e.f26292e.v();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26314e;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26314e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26314e.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26314e.f26292e.u();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26315e;

        public l(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26315e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26315e.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26315e.f26292e.F();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f26316e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26317f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.t0.s f26318g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f26319h;

        public m(d dVar, w wVar, boolean z, c.a.t0.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, wVar, Boolean.valueOf(z), sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26319h = dVar;
            this.f26316e = wVar;
            this.f26317f = z;
            this.f26318g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26319h.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26319h.f26292e.K(this.f26316e, this.f26317f, this.f26318g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26323e;

        /* renamed from: f  reason: collision with root package name */
        public int f26324f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26325g;

        public o(d dVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26325g = dVar;
            this.f26323e = str;
            this.f26324f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26325g.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26325g.f26292e.h(this.f26323e, this.f26324f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26328e;

        /* renamed from: f  reason: collision with root package name */
        public int f26329f;

        /* renamed from: g  reason: collision with root package name */
        public int f26330g;

        /* renamed from: h  reason: collision with root package name */
        public long f26331h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f26332i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f26333j;

        public q(d dVar, String str, int i2, int i3, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Integer.valueOf(i2), Integer.valueOf(i3), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26333j = dVar;
            this.f26328e = str;
            this.f26329f = i2;
            this.f26330g = i3;
            this.f26331h = System.currentTimeMillis();
            this.f26332i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26333j.f26292e == null) {
                    boolean unused = d.f26288k;
                    return;
                }
                x.f().a(this.f26328e, true);
                this.f26333j.f26292e.l(this.f26328e, this.f26329f, this.f26330g, this.f26331h, this.f26332i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26334e;

        /* renamed from: f  reason: collision with root package name */
        public int f26335f;

        /* renamed from: g  reason: collision with root package name */
        public String f26336g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f26337h;

        public r(d dVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26337h = dVar;
            this.f26334e = str;
            this.f26335f = i2;
            this.f26336g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26337h.f26292e == null) {
                    boolean unused = d.f26288k;
                } else {
                    this.f26337h.f26292e.L(this.f26334e, this.f26335f, this.f26336g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26338e;

        public s(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26338e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f26338e.f26291d = c.a.t0.g.o();
                this.f26338e.f26292e = new c.a.t0.c(this.f26338e.a);
                this.f26338e.f26292e.H();
                d dVar = this.f26338e;
                dVar.f26297j = dVar.f26291d.N();
            }
        }

        public /* synthetic */ s(d dVar, RunnableC1508d runnableC1508d) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905188, "Lc/a/t0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905188, "Lc/a/t0/d;");
                return;
            }
        }
        f26288k = b0.m();
    }

    public d() {
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
        this.f26294g = false;
        y(b0.b());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f26293f;
        dVar.f26293f = i2 + 1;
        return i2;
    }

    public static d w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (l == null) {
                synchronized (d.class) {
                    if (l == null) {
                        l = new d();
                    }
                }
            }
            return l;
        }
        return (d) invokeV.objValue;
    }

    public void A(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i2) == null) {
            this.f26289b.execute(new n(this, str, str2, i2));
        }
    }

    public void B(String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, str3) == null) {
            this.f26289b.execute(new n(this, str, str2, i2, str3));
        }
    }

    public void C(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, i2) == null) {
            this.f26289b.execute(new n(this, str, jSONObject, i2));
        }
    }

    public void D(String str, JSONObject jSONObject, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, jSONObject, i2, str2) == null) {
            this.f26289b.execute(new n(this, str, jSONObject, i2, str2));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26289b.execute(new k(this));
        }
    }

    public void F(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f26289b.execute(new n(this, str, str2, i2, str3, i3));
        }
    }

    public void G(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f26289b.execute(new n(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26289b.execute(new j(this));
        }
    }

    public void I(c.a.t0.n nVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, z) == null) {
            this.f26289b.execute(new b(this, nVar, z));
        }
    }

    public void J(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, runnable, j2) == null) {
            this.f26289b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && c.a.i0.b.a.a.g()) {
            this.f26289b.execute(new a(this));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f26289b.execute(new l(this));
        }
    }

    public void M(w wVar, boolean z, c.a.t0.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f26289b.execute(new m(this, wVar, z, sVar));
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, str2) == null) {
            this.f26289b.execute(new r(this, str, i2, str2));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f26294g) {
            return;
        }
        this.f26294g = true;
        this.f26289b.execute(new e(this));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f26289b.execute(new f(this));
        }
    }

    public void Q(l0 l0Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, l0Var, str) == null) {
            if (f26288k) {
                String str2 = "uploadData isDataInFile:" + l0Var.x();
                if (l0Var.x()) {
                    l0Var.F("UBCDEBUG");
                } else {
                    l0Var.u().toString();
                }
            }
            if (b0.l() || l0Var.A()) {
                c.C1507c c1507c = new c.C1507c();
                boolean x = l0Var.x();
                c1507c.a = x;
                if (x) {
                    c1507c.f26281c = l0Var.o();
                    c1507c.f26284f = l0Var.m();
                } else {
                    c1507c.f26282d = l0Var.u();
                }
                c1507c.f26286h = l0Var.A();
                c1507c.f26283e = str;
                i0.m().z();
                this.f26290c.execute(new i(this, c1507c));
            }
        }
    }

    public void R(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            S(jSONObject, null);
        }
    }

    public void S(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, jSONObject, str) == null) {
            T(jSONObject, str, false, null, null);
        }
    }

    public final void T(JSONObject jSONObject, String str, boolean z, c.a.t0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jSONObject, str, Boolean.valueOf(z), nVar, tVar}) == null) {
            if (f26288k) {
                String str2 = "uploadData:" + str;
                jSONObject.toString();
            }
            boolean l2 = b0.l();
            boolean z2 = (nVar == null || (nVar.n() & 128) == 0) ? false : true;
            if (l2 || z2) {
                c.C1507c c1507c = new c.C1507c();
                c1507c.a = false;
                c1507c.f26282d = jSONObject;
                c1507c.f26283e = str;
                c1507c.f26285g = z;
                c1507c.f26286h = z2;
                c1507c.f26280b = nVar;
                c1507c.f26287i = tVar;
                this.f26290c.execute(new h(this, c1507c));
            }
        }
    }

    public void U(JSONObject jSONObject, boolean z, c.a.t0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{jSONObject, Boolean.valueOf(z), nVar, tVar}) == null) {
            T(jSONObject, null, z, nVar, tVar);
        }
    }

    public void V(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            this.f26289b.execute(new c(this, z, str));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f26289b.execute(new RunnableC1508d(this));
        }
    }

    public synchronized Flow o(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, str, str2, i2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, str2);
                    if (this.f26291d != null && this.f26291d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26289b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow p(String str, String str2, int i2, String str3) {
        InterceptResult invokeLLIL;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048600, this, str, str2, i2, str3)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, str2, str3);
                    if (this.f26291d != null && this.f26291d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26289b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public synchronized Flow q(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048601, this, str, jSONObject, i2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, jSONObject);
                    if (this.f26291d != null && this.f26291d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26289b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow r(String str, JSONObject jSONObject, int i2, String str2) {
        InterceptResult invokeLLIL;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048602, this, str, jSONObject, i2, str2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, jSONObject, str2);
                    if (this.f26291d != null && this.f26291d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26289b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) {
            this.f26289b.execute(new o(this, str, i2));
        }
    }

    public Flow t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f26293f, i2);
            c.a.t0.g gVar = this.f26291d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !b0.i().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.t0.g gVar2 = this.f26291d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar3 = this.f26291d;
                if (gVar3 != null && gVar3.F(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar4 = this.f26291d;
                if (gVar4 != null && !gVar4.K(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public void u(String str, int i2, int i3, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), jSONArray}) == null) {
            this.f26289b.execute(new q(this, str, i2, i3, jSONArray));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f26289b.execute(new g(this));
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            c.a.t0.c cVar = this.f26292e;
            return (cVar == null || (q2 = cVar.q(str)) == -1) ? "" : String.valueOf(q2);
        }
        return (String) invokeL.objValue;
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, context) == null) && this.a == null && context != null) {
            if (context instanceof Application) {
                this.a = context;
            } else {
                this.a = context.getApplicationContext();
            }
            this.f26293f = b0.d();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f26289b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new s(this, null));
            this.f26290c = Executors.newSingleThreadExecutor();
        }
    }

    public void z(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048609, this, str, str2, str3, i2) == null) {
            n nVar = new n(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                nVar.e(str3);
            }
            this.f26289b.execute(nVar);
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.n f26320e;

        /* renamed from: f  reason: collision with root package name */
        public String f26321f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26322g;

        public n(d dVar, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26322g = dVar;
            this.f26320e = new c.a.t0.n(str, str2, i2);
            this.f26321f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || b0.i().c(str)) {
                    if (this.f26322g.f26291d == null || this.f26322g.f26291d.g(str, i2)) {
                        if (this.f26322g.f26291d == null || !this.f26322g.f26291d.F(str)) {
                            if (this.f26322g.f26291d == null || !this.f26322g.f26291d.h(str)) {
                                return this.f26322g.f26291d == null || !this.f26322g.f26291d.d(str);
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLI.booleanValue;
        }

        public final void b(String str, String str2) {
            int length;
            int s;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (length = str2.length()) <= (s = c.a.t0.g.o().s())) {
                return;
            }
            d0.a().g(String.valueOf(s), String.valueOf(length), str);
            if (d.f26288k) {
                String str3 = "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(s / 1024), str, str2));
            }
        }

        public final void c() {
            c.a.t0.n nVar;
            JSONObject m;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f26320e) == null) {
                return;
            }
            String l = nVar.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String f2 = this.f26320e.f();
            if (TextUtils.isEmpty(f2) && (m = this.f26320e.m()) != null) {
                try {
                    f2 = m.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f26322g.f26295h != null) {
                        this.f26322g.f26295h.b(l, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            b(l, f2);
            if (this.f26322g.f26295h != null) {
                this.f26322g.f26295h.a(l, f2);
            }
        }

        public void d(boolean z) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f26320e) == null) {
                return;
            }
            nVar.u(z);
        }

        public void e(String str) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f26320e) == null) {
                return;
            }
            nVar.x(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f26322g.f26292e == null) {
                    boolean unused = d.f26288k;
                    return;
                }
                if (!this.f26322g.f26296i) {
                    if (this.f26322g.f26295h == null) {
                        this.f26322g.f26295h = (v) ServiceManager.getService(v.a);
                    }
                    this.f26322g.f26296i = true;
                }
                if (this.f26322g.f26291d != null && this.f26322g.f26291d.b(this.f26321f) == 1) {
                    c();
                }
                if (this.f26320e.j() == -1) {
                    if (!a(this.f26320e.l(), this.f26320e.n())) {
                        return;
                    }
                    if (this.f26322g.f26291d != null && this.f26322g.f26291d.J(this.f26320e.l())) {
                        d(true);
                    }
                    x.f().a(this.f26320e.l(), true);
                }
                this.f26320e.v();
                String l = this.f26320e.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                if (this.f26322g.f26291d != null) {
                    String j2 = this.f26322g.f26291d.j(l);
                    if (!TextUtils.isEmpty(j2)) {
                        this.f26320e.s(j2);
                    }
                }
                if (this.f26322g.f26291d != null && this.f26322g.f26291d.b(this.f26321f) == 2) {
                    c();
                }
                if (this.f26320e.j() == -1 && TextUtils.equals(l, "1876")) {
                    this.f26322g.f26292e.C(this.f26320e);
                } else if ((this.f26320e.n() & 8) != 0) {
                    this.f26322g.f26292e.B(this.f26320e);
                } else if ((this.f26320e.n() & 128) != 0) {
                    if (this.f26322g.f26297j) {
                        this.f26322g.f26292e.t(this.f26320e);
                    } else {
                        this.f26322g.f26292e.A(this.f26320e);
                    }
                } else if (this.f26320e == null || this.f26322g.f26291d == null || !this.f26322g.f26291d.f(l)) {
                    if (this.f26322g.f26297j) {
                        this.f26322g.f26292e.t(this.f26320e);
                    } else {
                        this.f26322g.f26292e.A(this.f26320e);
                    }
                } else {
                    this.f26322g.f26292e.X(this.f26320e);
                }
            }
        }

        public n(d dVar, String str, String str2, int i2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f26322g = dVar;
            c.a.t0.n nVar = new c.a.t0.n(str, str2, i2);
            this.f26320e = nVar;
            this.f26321f = str;
            nVar.r(str3);
        }

        public n(d dVar, String str, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.f26322g = dVar;
            this.f26320e = new c.a.t0.n(str, jSONObject, i2);
            this.f26321f = str;
        }

        public n(d dVar, String str, JSONObject jSONObject, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, jSONObject, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65541, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.f26322g = dVar;
            c.a.t0.n nVar = new c.a.t0.n(str, jSONObject, i2);
            this.f26320e = nVar;
            this.f26321f = str;
            nVar.r(str2);
        }

        public n(d dVar, String str, String str2, int i2, String str3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f26322g = dVar;
            this.f26320e = new c.a.t0.n(str, str2, i2, str3, i3);
            this.f26321f = str;
        }

        public n(d dVar, String str, String str2, int i2, String str3, long j2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f26322g = dVar;
            this.f26320e = new c.a.t0.n(str, str2, i2, str3, j2, i3);
            this.f26321f = str;
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.p f26326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26327f;

        public p(d dVar, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26327f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f26326e = pVar;
            pVar.q(flow.getStartTime());
            this.f26326e.C("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            c.a.t0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f26326e) == null) {
                return;
            }
            pVar.u(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f26327f.f26292e == null) {
                    boolean unused = d.f26288k;
                    return;
                }
                this.f26326e.x();
                if (!TextUtils.isEmpty(this.f26327f.f26291d.j(this.f26326e.l()))) {
                    this.f26326e.s(this.f26327f.f26291d.j(this.f26326e.l()));
                }
                this.f26327f.f26292e.I(this.f26326e);
                b0.q(this.f26327f.f26293f);
            }
        }

        public p(d dVar, Flow flow, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f26327f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f26326e = pVar;
            pVar.q(flow.getStartTime());
            this.f26326e.C("1");
            d.n(dVar);
            this.f26326e.r(str2);
        }

        public p(d dVar, Flow flow, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, jSONObject};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f26327f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f26326e = pVar;
            pVar.q(flow.getStartTime());
            this.f26326e.C("1");
            d.n(dVar);
        }

        public p(d dVar, Flow flow, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, jSONObject, str};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f26327f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f26326e = pVar;
            pVar.q(flow.getStartTime());
            this.f26326e.C("1");
            d.n(dVar);
            this.f26326e.r(str);
        }
    }
}
