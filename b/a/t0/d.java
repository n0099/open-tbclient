package b.a.t0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.t0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile d l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f29577a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f29578b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f29579c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.t0.g f29580d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.t0.c f29581e;

    /* renamed from: f  reason: collision with root package name */
    public int f29582f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29583g;

    /* renamed from: h  reason: collision with root package name */
    public v f29584h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29585i;
    public boolean j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29586e;

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
            this.f29586e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29586e.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29586e.f29581e.E();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.t0.n f29587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f29588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29589g;

        public b(d dVar, b.a.t0.n nVar, boolean z) {
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
            this.f29589g = dVar;
            this.f29587e = nVar;
            this.f29588f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29589g.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29589g.f29581e.w(this.f29587e, this.f29588f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29592g;

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
            this.f29592g = dVar;
            this.f29590e = z;
            this.f29591f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29592g.f29581e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (this.f29590e) {
                    this.f29592g.f29581e.Q(this.f29591f);
                } else {
                    this.f29592g.f29581e.P(this.f29591f);
                }
                i0.m().B(this.f29590e);
            }
        }
    }

    /* renamed from: b.a.t0.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1438d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29593e;

        public RunnableC1438d(d dVar) {
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
            this.f29593e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29593e.f29581e == null) {
                return;
            }
            this.f29593e.f29581e.S();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29594e;

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
            this.f29594e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29594e.f29581e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - k0.a().c("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f29594e.f29581e.S();
                long currentTimeMillis = System.currentTimeMillis();
                k0.a().e("ubc_last_upload_all_time", currentTimeMillis);
                k0.a().e("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29595e;

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
            this.f29595e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29595e.f29581e == null) {
                return;
            }
            this.f29595e.f29581e.M();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29596e;

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
            this.f29596e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29596e.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29596e.f29581e.m();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1437c f29597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29598f;

        public h(d dVar, c.C1437c c1437c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1437c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29598f = dVar;
            this.f29597e = c1437c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29598f.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29598f.f29581e.N(this.f29597e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1437c f29599e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29600f;

        public i(d dVar, c.C1437c c1437c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1437c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29600f = dVar;
            this.f29599e = c1437c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29600f.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29600f.f29581e.N(this.f29599e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29601e;

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
            this.f29601e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29601e.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29601e.f29581e.v();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29602e;

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
            this.f29602e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29602e.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29602e.f29581e.u();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29603e;

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
            this.f29603e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29603e.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29603e.f29581e.F();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f29604e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29605f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.t0.s f29606g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29607h;

        public m(d dVar, w wVar, boolean z, b.a.t0.s sVar) {
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
            this.f29607h = dVar;
            this.f29604e = wVar;
            this.f29605f = z;
            this.f29606g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29607h.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29607h.f29581e.K(this.f29604e, this.f29605f, this.f29606g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29611e;

        /* renamed from: f  reason: collision with root package name */
        public int f29612f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29613g;

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
            this.f29613g = dVar;
            this.f29611e = str;
            this.f29612f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29613g.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29613g.f29581e.h(this.f29611e, this.f29612f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29616e;

        /* renamed from: f  reason: collision with root package name */
        public int f29617f;

        /* renamed from: g  reason: collision with root package name */
        public int f29618g;

        /* renamed from: h  reason: collision with root package name */
        public long f29619h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f29620i;
        public final /* synthetic */ d j;

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
            this.j = dVar;
            this.f29616e = str;
            this.f29617f = i2;
            this.f29618g = i3;
            this.f29619h = System.currentTimeMillis();
            this.f29620i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f29581e == null) {
                    boolean unused = d.k;
                    return;
                }
                x.f().a(this.f29616e, true);
                this.j.f29581e.l(this.f29616e, this.f29617f, this.f29618g, this.f29619h, this.f29620i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29621e;

        /* renamed from: f  reason: collision with root package name */
        public int f29622f;

        /* renamed from: g  reason: collision with root package name */
        public String f29623g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29624h;

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
            this.f29624h = dVar;
            this.f29621e = str;
            this.f29622f = i2;
            this.f29623g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29624h.f29581e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29624h.f29581e.L(this.f29621e, this.f29622f, this.f29623g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29625e;

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
            this.f29625e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f29625e.f29580d = b.a.t0.g.o();
                this.f29625e.f29581e = new b.a.t0.c(this.f29625e.f29577a);
                this.f29625e.f29581e.H();
                d dVar = this.f29625e;
                dVar.j = dVar.f29580d.N();
            }
        }

        public /* synthetic */ s(d dVar, RunnableC1438d runnableC1438d) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136607645, "Lb/a/t0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136607645, "Lb/a/t0/d;");
                return;
            }
        }
        k = b0.m();
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
        this.f29583g = false;
        y(b0.b());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f29582f;
        dVar.f29582f = i2 + 1;
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
            this.f29578b.execute(new n(this, str, str2, i2));
        }
    }

    public void B(String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, str3) == null) {
            this.f29578b.execute(new n(this, str, str2, i2, str3));
        }
    }

    public void C(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, i2) == null) {
            this.f29578b.execute(new n(this, str, jSONObject, i2));
        }
    }

    public void D(String str, JSONObject jSONObject, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, jSONObject, i2, str2) == null) {
            this.f29578b.execute(new n(this, str, jSONObject, i2, str2));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29578b.execute(new k(this));
        }
    }

    public void F(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f29578b.execute(new n(this, str, str2, i2, str3, i3));
        }
    }

    public void G(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f29578b.execute(new n(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f29578b.execute(new j(this));
        }
    }

    public void I(b.a.t0.n nVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, z) == null) {
            this.f29578b.execute(new b(this, nVar, z));
        }
    }

    public void J(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, runnable, j2) == null) {
            this.f29578b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && b.a.h0.b.a.a.g()) {
            this.f29578b.execute(new a(this));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f29578b.execute(new l(this));
        }
    }

    public void M(w wVar, boolean z, b.a.t0.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f29578b.execute(new m(this, wVar, z, sVar));
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, str2) == null) {
            this.f29578b.execute(new r(this, str, i2, str2));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f29583g) {
            return;
        }
        this.f29583g = true;
        this.f29578b.execute(new e(this));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f29578b.execute(new f(this));
        }
    }

    public void Q(l0 l0Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, l0Var, str) == null) {
            if (k) {
                String str2 = "uploadData isDataInFile:" + l0Var.x();
                if (l0Var.x()) {
                    l0Var.F("UBCDEBUG");
                } else {
                    l0Var.u().toString();
                }
            }
            if (b0.l() || l0Var.A()) {
                c.C1437c c1437c = new c.C1437c();
                boolean x = l0Var.x();
                c1437c.f29568a = x;
                if (x) {
                    c1437c.f29570c = l0Var.o();
                    c1437c.f29573f = l0Var.m();
                } else {
                    c1437c.f29571d = l0Var.u();
                }
                c1437c.f29575h = l0Var.A();
                c1437c.f29572e = str;
                i0.m().z();
                this.f29579c.execute(new i(this, c1437c));
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

    public final void T(JSONObject jSONObject, String str, boolean z, b.a.t0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jSONObject, str, Boolean.valueOf(z), nVar, tVar}) == null) {
            if (k) {
                String str2 = "uploadData:" + str;
                jSONObject.toString();
            }
            boolean l2 = b0.l();
            boolean z2 = (nVar == null || (nVar.n() & 128) == 0) ? false : true;
            if (l2 || z2) {
                c.C1437c c1437c = new c.C1437c();
                c1437c.f29568a = false;
                c1437c.f29571d = jSONObject;
                c1437c.f29572e = str;
                c1437c.f29574g = z;
                c1437c.f29575h = z2;
                c1437c.f29569b = nVar;
                c1437c.f29576i = tVar;
                this.f29579c.execute(new h(this, c1437c));
            }
        }
    }

    public void U(JSONObject jSONObject, boolean z, b.a.t0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{jSONObject, Boolean.valueOf(z), nVar, tVar}) == null) {
            T(jSONObject, null, z, nVar, tVar);
        }
    }

    public void V(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            this.f29578b.execute(new c(this, z, str));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f29578b.execute(new RunnableC1438d(this));
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
                    if (this.f29580d != null && this.f29580d.J(str)) {
                        pVar.a(true);
                    }
                    this.f29578b.execute(pVar);
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
                    if (this.f29580d != null && this.f29580d.J(str)) {
                        pVar.a(true);
                    }
                    this.f29578b.execute(pVar);
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
                    if (this.f29580d != null && this.f29580d.J(str)) {
                        pVar.a(true);
                    }
                    this.f29578b.execute(pVar);
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
                    if (this.f29580d != null && this.f29580d.J(str)) {
                        pVar.a(true);
                    }
                    this.f29578b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) {
            this.f29578b.execute(new o(this, str, i2));
        }
    }

    public Flow t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f29582f, i2);
            b.a.t0.g gVar = this.f29580d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !b0.i().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                b.a.t0.g gVar2 = this.f29580d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                b.a.t0.g gVar3 = this.f29580d;
                if (gVar3 != null && gVar3.F(str)) {
                    flow.setValid(false);
                    return flow;
                }
                b.a.t0.g gVar4 = this.f29580d;
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
            this.f29578b.execute(new q(this, str, i2, i3, jSONArray));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f29578b.execute(new g(this));
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            b.a.t0.c cVar = this.f29581e;
            return (cVar == null || (q2 = cVar.q(str)) == -1) ? "" : String.valueOf(q2);
        }
        return (String) invokeL.objValue;
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, context) == null) && this.f29577a == null && context != null) {
            if (context instanceof Application) {
                this.f29577a = context;
            } else {
                this.f29577a = context.getApplicationContext();
            }
            this.f29582f = b0.d();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f29578b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new s(this, null));
            this.f29579c = Executors.newSingleThreadExecutor();
        }
    }

    public void z(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048609, this, str, str2, str3, i2) == null) {
            n nVar = new n(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                nVar.e(str3);
            }
            this.f29578b.execute(nVar);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.t0.n f29608e;

        /* renamed from: f  reason: collision with root package name */
        public String f29609f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29610g;

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
            this.f29610g = dVar;
            this.f29608e = new b.a.t0.n(str, str2, i2);
            this.f29609f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || b0.i().c(str)) {
                    if (this.f29610g.f29580d == null || this.f29610g.f29580d.g(str, i2)) {
                        if (this.f29610g.f29580d == null || !this.f29610g.f29580d.F(str)) {
                            if (this.f29610g.f29580d == null || !this.f29610g.f29580d.h(str)) {
                                return this.f29610g.f29580d == null || !this.f29610g.f29580d.d(str);
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
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (length = str2.length()) <= (s = b.a.t0.g.o().s())) {
                return;
            }
            d0.a().g(String.valueOf(s), String.valueOf(length), str);
            if (d.k) {
                String str3 = "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(s / 1024), str, str2));
            }
        }

        public final void c() {
            b.a.t0.n nVar;
            JSONObject m;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f29608e) == null) {
                return;
            }
            String l = nVar.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String f2 = this.f29608e.f();
            if (TextUtils.isEmpty(f2) && (m = this.f29608e.m()) != null) {
                try {
                    f2 = m.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f29610g.f29584h != null) {
                        this.f29610g.f29584h.b(l, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            b(l, f2);
            if (this.f29610g.f29584h != null) {
                this.f29610g.f29584h.a(l, f2);
            }
        }

        public void d(boolean z) {
            b.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f29608e) == null) {
                return;
            }
            nVar.u(z);
        }

        public void e(String str) {
            b.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f29608e) == null) {
                return;
            }
            nVar.x(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f29610g.f29581e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (!this.f29610g.f29585i) {
                    if (this.f29610g.f29584h == null) {
                        this.f29610g.f29584h = (v) ServiceManager.getService(v.f29759a);
                    }
                    this.f29610g.f29585i = true;
                }
                if (this.f29610g.f29580d != null && this.f29610g.f29580d.b(this.f29609f) == 1) {
                    c();
                }
                if (this.f29608e.j() == -1) {
                    if (!a(this.f29608e.l(), this.f29608e.n())) {
                        return;
                    }
                    if (this.f29610g.f29580d != null && this.f29610g.f29580d.J(this.f29608e.l())) {
                        d(true);
                    }
                    x.f().a(this.f29608e.l(), true);
                }
                this.f29608e.v();
                String l = this.f29608e.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                if (this.f29610g.f29580d != null) {
                    String j = this.f29610g.f29580d.j(l);
                    if (!TextUtils.isEmpty(j)) {
                        this.f29608e.s(j);
                    }
                }
                if (this.f29610g.f29580d != null && this.f29610g.f29580d.b(this.f29609f) == 2) {
                    c();
                }
                if (this.f29608e.j() == -1 && TextUtils.equals(l, "1876")) {
                    this.f29610g.f29581e.C(this.f29608e);
                } else if ((this.f29608e.n() & 8) != 0) {
                    this.f29610g.f29581e.B(this.f29608e);
                } else if ((this.f29608e.n() & 128) != 0) {
                    if (this.f29610g.j) {
                        this.f29610g.f29581e.t(this.f29608e);
                    } else {
                        this.f29610g.f29581e.A(this.f29608e);
                    }
                } else if (this.f29608e == null || this.f29610g.f29580d == null || !this.f29610g.f29580d.f(l)) {
                    if (this.f29610g.j) {
                        this.f29610g.f29581e.t(this.f29608e);
                    } else {
                        this.f29610g.f29581e.A(this.f29608e);
                    }
                } else {
                    this.f29610g.f29581e.X(this.f29608e);
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
            this.f29610g = dVar;
            b.a.t0.n nVar = new b.a.t0.n(str, str2, i2);
            this.f29608e = nVar;
            this.f29609f = str;
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
            this.f29610g = dVar;
            this.f29608e = new b.a.t0.n(str, jSONObject, i2);
            this.f29609f = str;
        }

        public n(d dVar, String str, JSONObject jSONObject, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, jSONObject, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.f29610g = dVar;
            b.a.t0.n nVar = new b.a.t0.n(str, jSONObject, i2);
            this.f29608e = nVar;
            this.f29609f = str;
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
            this.f29610g = dVar;
            this.f29608e = new b.a.t0.n(str, str2, i2, str3, i3);
            this.f29609f = str;
        }

        public n(d dVar, String str, String str2, int i2, String str3, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f29610g = dVar;
            this.f29608e = new b.a.t0.n(str, str2, i2, str3, j, i3);
            this.f29609f = str;
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.t0.p f29614e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29615f;

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
            this.f29615f = dVar;
            b.a.t0.p pVar = new b.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f29614e = pVar;
            pVar.q(flow.getStartTime());
            this.f29614e.C("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            b.a.t0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f29614e) == null) {
                return;
            }
            pVar.u(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f29615f.f29581e == null) {
                    boolean unused = d.k;
                    return;
                }
                this.f29614e.x();
                if (!TextUtils.isEmpty(this.f29615f.f29580d.j(this.f29614e.l()))) {
                    this.f29614e.s(this.f29615f.f29580d.j(this.f29614e.l()));
                }
                this.f29615f.f29581e.I(this.f29614e);
                b0.q(this.f29615f.f29582f);
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
            this.f29615f = dVar;
            b.a.t0.p pVar = new b.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f29614e = pVar;
            pVar.q(flow.getStartTime());
            this.f29614e.C("1");
            d.n(dVar);
            this.f29614e.r(str2);
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
            this.f29615f = dVar;
            b.a.t0.p pVar = new b.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f29614e = pVar;
            pVar.q(flow.getStartTime());
            this.f29614e.C("1");
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
            this.f29615f = dVar;
            b.a.t0.p pVar = new b.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f29614e = pVar;
            pVar.q(flow.getStartTime());
            this.f29614e.C("1");
            d.n(dVar);
            this.f29614e.r(str);
        }
    }
}
