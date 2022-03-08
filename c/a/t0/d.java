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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile d l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f25943b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f25944c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.g f25945d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.c f25946e;

    /* renamed from: f  reason: collision with root package name */
    public int f25947f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25948g;

    /* renamed from: h  reason: collision with root package name */
    public v f25949h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25950i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f25951j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25952e;

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
            this.f25952e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25952e.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25952e.f25946e.E();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.n f25953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f25954f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f25955g;

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
            this.f25955g = dVar;
            this.f25953e = nVar;
            this.f25954f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25955g.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25955g.f25946e.w(this.f25953e, this.f25954f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f25956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f25957f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f25958g;

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
            this.f25958g = dVar;
            this.f25956e = z;
            this.f25957f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25958g.f25946e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (this.f25956e) {
                    this.f25958g.f25946e.Q(this.f25957f);
                } else {
                    this.f25958g.f25946e.P(this.f25957f);
                }
                i0.m().B(this.f25956e);
            }
        }
    }

    /* renamed from: c.a.t0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1582d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25959e;

        public RunnableC1582d(d dVar) {
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
            this.f25959e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25959e.f25946e == null) {
                return;
            }
            this.f25959e.f25946e.S();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25960e;

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
            this.f25960e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25960e.f25946e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - k0.a().c("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f25960e.f25946e.S();
                long currentTimeMillis = System.currentTimeMillis();
                k0.a().e("ubc_last_upload_all_time", currentTimeMillis);
                k0.a().e("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25961e;

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
            this.f25961e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25961e.f25946e == null) {
                return;
            }
            this.f25961e.f25946e.M();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25962e;

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
            this.f25962e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25962e.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25962e.f25946e.m();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1581c f25963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f25964f;

        public h(d dVar, c.C1581c c1581c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1581c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25964f = dVar;
            this.f25963e = c1581c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25964f.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25964f.f25946e.N(this.f25963e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1581c f25965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f25966f;

        public i(d dVar, c.C1581c c1581c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1581c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25966f = dVar;
            this.f25965e = c1581c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25966f.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25966f.f25946e.N(this.f25965e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25967e;

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
            this.f25967e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25967e.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25967e.f25946e.v();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25968e;

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
            this.f25968e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25968e.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25968e.f25946e.u();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25969e;

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
            this.f25969e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25969e.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25969e.f25946e.F();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f25970e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f25971f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.t0.s f25972g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f25973h;

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
            this.f25973h = dVar;
            this.f25970e = wVar;
            this.f25971f = z;
            this.f25972g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25973h.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25973h.f25946e.K(this.f25970e, this.f25971f, this.f25972g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f25977e;

        /* renamed from: f  reason: collision with root package name */
        public int f25978f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f25979g;

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
            this.f25979g = dVar;
            this.f25977e = str;
            this.f25978f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25979g.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25979g.f25946e.h(this.f25977e, this.f25978f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f25982e;

        /* renamed from: f  reason: collision with root package name */
        public int f25983f;

        /* renamed from: g  reason: collision with root package name */
        public int f25984g;

        /* renamed from: h  reason: collision with root package name */
        public long f25985h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f25986i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f25987j;

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
            this.f25987j = dVar;
            this.f25982e = str;
            this.f25983f = i2;
            this.f25984g = i3;
            this.f25985h = System.currentTimeMillis();
            this.f25986i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25987j.f25946e == null) {
                    boolean unused = d.k;
                    return;
                }
                x.f().a(this.f25982e, true);
                this.f25987j.f25946e.l(this.f25982e, this.f25983f, this.f25984g, this.f25985h, this.f25986i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f25988e;

        /* renamed from: f  reason: collision with root package name */
        public int f25989f;

        /* renamed from: g  reason: collision with root package name */
        public String f25990g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f25991h;

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
            this.f25991h = dVar;
            this.f25988e = str;
            this.f25989f = i2;
            this.f25990g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25991h.f25946e == null) {
                    boolean unused = d.k;
                } else {
                    this.f25991h.f25946e.L(this.f25988e, this.f25989f, this.f25990g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25992e;

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
            this.f25992e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f25992e.f25945d = c.a.t0.g.o();
                this.f25992e.f25946e = new c.a.t0.c(this.f25992e.a);
                this.f25992e.f25946e.H();
                d dVar = this.f25992e;
                dVar.f25951j = dVar.f25945d.N();
            }
        }

        public /* synthetic */ s(d dVar, RunnableC1582d runnableC1582d) {
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
        this.f25948g = false;
        y(b0.b());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f25947f;
        dVar.f25947f = i2 + 1;
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
            this.f25943b.execute(new n(this, str, str2, i2));
        }
    }

    public void B(String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, str3) == null) {
            this.f25943b.execute(new n(this, str, str2, i2, str3));
        }
    }

    public void C(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, i2) == null) {
            this.f25943b.execute(new n(this, str, jSONObject, i2));
        }
    }

    public void D(String str, JSONObject jSONObject, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, jSONObject, i2, str2) == null) {
            this.f25943b.execute(new n(this, str, jSONObject, i2, str2));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25943b.execute(new k(this));
        }
    }

    public void F(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f25943b.execute(new n(this, str, str2, i2, str3, i3));
        }
    }

    public void G(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f25943b.execute(new n(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25943b.execute(new j(this));
        }
    }

    public void I(c.a.t0.n nVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, z) == null) {
            this.f25943b.execute(new b(this, nVar, z));
        }
    }

    public void J(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, runnable, j2) == null) {
            this.f25943b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && c.a.i0.b.a.a.g()) {
            this.f25943b.execute(new a(this));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25943b.execute(new l(this));
        }
    }

    public void M(w wVar, boolean z, c.a.t0.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f25943b.execute(new m(this, wVar, z, sVar));
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, str2) == null) {
            this.f25943b.execute(new r(this, str, i2, str2));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f25948g) {
            return;
        }
        this.f25948g = true;
        this.f25943b.execute(new e(this));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f25943b.execute(new f(this));
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
                c.C1581c c1581c = new c.C1581c();
                boolean x = l0Var.x();
                c1581c.a = x;
                if (x) {
                    c1581c.f25936c = l0Var.o();
                    c1581c.f25939f = l0Var.m();
                } else {
                    c1581c.f25937d = l0Var.u();
                }
                c1581c.f25941h = l0Var.A();
                c1581c.f25938e = str;
                i0.m().z();
                this.f25944c.execute(new i(this, c1581c));
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
            if (k) {
                String str2 = "uploadData:" + str;
                jSONObject.toString();
            }
            boolean l2 = b0.l();
            boolean z2 = (nVar == null || (nVar.n() & 128) == 0) ? false : true;
            if (l2 || z2) {
                c.C1581c c1581c = new c.C1581c();
                c1581c.a = false;
                c1581c.f25937d = jSONObject;
                c1581c.f25938e = str;
                c1581c.f25940g = z;
                c1581c.f25941h = z2;
                c1581c.f25935b = nVar;
                c1581c.f25942i = tVar;
                this.f25944c.execute(new h(this, c1581c));
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
            this.f25943b.execute(new c(this, z, str));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f25943b.execute(new RunnableC1582d(this));
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
                    if (this.f25945d != null && this.f25945d.J(str)) {
                        pVar.a(true);
                    }
                    this.f25943b.execute(pVar);
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
                    if (this.f25945d != null && this.f25945d.J(str)) {
                        pVar.a(true);
                    }
                    this.f25943b.execute(pVar);
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
                    if (this.f25945d != null && this.f25945d.J(str)) {
                        pVar.a(true);
                    }
                    this.f25943b.execute(pVar);
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
                    if (this.f25945d != null && this.f25945d.J(str)) {
                        pVar.a(true);
                    }
                    this.f25943b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) {
            this.f25943b.execute(new o(this, str, i2));
        }
    }

    public Flow t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f25947f, i2);
            c.a.t0.g gVar = this.f25945d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !b0.i().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.t0.g gVar2 = this.f25945d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar3 = this.f25945d;
                if (gVar3 != null && gVar3.F(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar4 = this.f25945d;
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
            this.f25943b.execute(new q(this, str, i2, i3, jSONArray));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f25943b.execute(new g(this));
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            c.a.t0.c cVar = this.f25946e;
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
            this.f25947f = b0.d();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f25943b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new s(this, null));
            this.f25944c = Executors.newSingleThreadExecutor();
        }
    }

    public void z(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048609, this, str, str2, str3, i2) == null) {
            n nVar = new n(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                nVar.e(str3);
            }
            this.f25943b.execute(nVar);
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.n f25974e;

        /* renamed from: f  reason: collision with root package name */
        public String f25975f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f25976g;

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
            this.f25976g = dVar;
            this.f25974e = new c.a.t0.n(str, str2, i2);
            this.f25975f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || b0.i().c(str)) {
                    if (this.f25976g.f25945d == null || this.f25976g.f25945d.g(str, i2)) {
                        if (this.f25976g.f25945d == null || !this.f25976g.f25945d.F(str)) {
                            if (this.f25976g.f25945d == null || !this.f25976g.f25945d.h(str)) {
                                return this.f25976g.f25945d == null || !this.f25976g.f25945d.d(str);
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
            if (d.k) {
                String str3 = "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(s / 1024), str, str2));
            }
        }

        public final void c() {
            c.a.t0.n nVar;
            JSONObject m;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f25974e) == null) {
                return;
            }
            String l = nVar.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String f2 = this.f25974e.f();
            if (TextUtils.isEmpty(f2) && (m = this.f25974e.m()) != null) {
                try {
                    f2 = m.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f25976g.f25949h != null) {
                        this.f25976g.f25949h.b(l, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            b(l, f2);
            if (this.f25976g.f25949h != null) {
                this.f25976g.f25949h.a(l, f2);
            }
        }

        public void d(boolean z) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f25974e) == null) {
                return;
            }
            nVar.u(z);
        }

        public void e(String str) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f25974e) == null) {
                return;
            }
            nVar.x(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f25976g.f25946e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (!this.f25976g.f25950i) {
                    if (this.f25976g.f25949h == null) {
                        this.f25976g.f25949h = (v) ServiceManager.getService(v.a);
                    }
                    this.f25976g.f25950i = true;
                }
                if (this.f25976g.f25945d != null && this.f25976g.f25945d.b(this.f25975f) == 1) {
                    c();
                }
                if (this.f25974e.j() == -1) {
                    if (!a(this.f25974e.l(), this.f25974e.n())) {
                        return;
                    }
                    if (this.f25976g.f25945d != null && this.f25976g.f25945d.J(this.f25974e.l())) {
                        d(true);
                    }
                    x.f().a(this.f25974e.l(), true);
                }
                this.f25974e.v();
                String l = this.f25974e.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                if (this.f25976g.f25945d != null) {
                    String j2 = this.f25976g.f25945d.j(l);
                    if (!TextUtils.isEmpty(j2)) {
                        this.f25974e.s(j2);
                    }
                }
                if (this.f25976g.f25945d != null && this.f25976g.f25945d.b(this.f25975f) == 2) {
                    c();
                }
                if (this.f25974e.j() == -1 && TextUtils.equals(l, "1876")) {
                    this.f25976g.f25946e.C(this.f25974e);
                } else if ((this.f25974e.n() & 8) != 0) {
                    this.f25976g.f25946e.B(this.f25974e);
                } else if ((this.f25974e.n() & 128) != 0) {
                    if (this.f25976g.f25951j) {
                        this.f25976g.f25946e.t(this.f25974e);
                    } else {
                        this.f25976g.f25946e.A(this.f25974e);
                    }
                } else if (this.f25974e == null || this.f25976g.f25945d == null || !this.f25976g.f25945d.f(l)) {
                    if (this.f25976g.f25951j) {
                        this.f25976g.f25946e.t(this.f25974e);
                    } else {
                        this.f25976g.f25946e.A(this.f25974e);
                    }
                } else {
                    this.f25976g.f25946e.X(this.f25974e);
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
            this.f25976g = dVar;
            c.a.t0.n nVar = new c.a.t0.n(str, str2, i2);
            this.f25974e = nVar;
            this.f25975f = str;
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
            this.f25976g = dVar;
            this.f25974e = new c.a.t0.n(str, jSONObject, i2);
            this.f25975f = str;
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
            this.f25976g = dVar;
            c.a.t0.n nVar = new c.a.t0.n(str, jSONObject, i2);
            this.f25974e = nVar;
            this.f25975f = str;
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
            this.f25976g = dVar;
            this.f25974e = new c.a.t0.n(str, str2, i2, str3, i3);
            this.f25975f = str;
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
            this.f25976g = dVar;
            this.f25974e = new c.a.t0.n(str, str2, i2, str3, j2, i3);
            this.f25975f = str;
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.p f25980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f25981f;

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
            this.f25981f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f25980e = pVar;
            pVar.q(flow.getStartTime());
            this.f25980e.C("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            c.a.t0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f25980e) == null) {
                return;
            }
            pVar.u(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f25981f.f25946e == null) {
                    boolean unused = d.k;
                    return;
                }
                this.f25980e.x();
                if (!TextUtils.isEmpty(this.f25981f.f25945d.j(this.f25980e.l()))) {
                    this.f25980e.s(this.f25981f.f25945d.j(this.f25980e.l()));
                }
                this.f25981f.f25946e.I(this.f25980e);
                b0.q(this.f25981f.f25947f);
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
            this.f25981f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f25980e = pVar;
            pVar.q(flow.getStartTime());
            this.f25980e.C("1");
            d.n(dVar);
            this.f25980e.r(str2);
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
            this.f25981f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f25980e = pVar;
            pVar.q(flow.getStartTime());
            this.f25980e.C("1");
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
            this.f25981f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f25980e = pVar;
            pVar.q(flow.getStartTime());
            this.f25980e.C("1");
            d.n(dVar);
            this.f25980e.r(str);
        }
    }
}
