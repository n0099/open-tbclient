package c.a.v0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.c;
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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile d l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f26390b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f26391c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.v0.g f26392d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.v0.c f26393e;

    /* renamed from: f  reason: collision with root package name */
    public int f26394f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26395g;

    /* renamed from: h  reason: collision with root package name */
    public v f26396h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26397i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26398j;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26399e;

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
            this.f26399e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26399e.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26399e.f26393e.E();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.n f26400e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f26401f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26402g;

        public b(d dVar, c.a.v0.n nVar, boolean z) {
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
            this.f26402g = dVar;
            this.f26400e = nVar;
            this.f26401f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26402g.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26402g.f26393e.w(this.f26400e, this.f26401f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f26403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26404f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26405g;

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
            this.f26405g = dVar;
            this.f26403e = z;
            this.f26404f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26405g.f26393e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (this.f26403e) {
                    this.f26405g.f26393e.Q(this.f26404f);
                } else {
                    this.f26405g.f26393e.P(this.f26404f);
                }
                i0.m().B(this.f26403e);
            }
        }
    }

    /* renamed from: c.a.v0.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1590d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26406e;

        public RunnableC1590d(d dVar) {
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
            this.f26406e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26406e.f26393e == null) {
                return;
            }
            this.f26406e.f26393e.S();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26407e;

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
            this.f26407e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26407e.f26393e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - k0.a().c("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f26407e.f26393e.S();
                long currentTimeMillis = System.currentTimeMillis();
                k0.a().e("ubc_last_upload_all_time", currentTimeMillis);
                k0.a().e("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26408e;

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
            this.f26408e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26408e.f26393e == null) {
                return;
            }
            this.f26408e.f26393e.M();
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26409e;

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
            this.f26409e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26409e.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26409e.f26393e.m();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1589c f26410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26411f;

        public h(d dVar, c.C1589c c1589c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1589c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26411f = dVar;
            this.f26410e = c1589c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26411f.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26411f.f26393e.N(this.f26410e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C1589c f26412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26413f;

        public i(d dVar, c.C1589c c1589c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1589c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26413f = dVar;
            this.f26412e = c1589c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26413f.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26413f.f26393e.N(this.f26412e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26414e;

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
            this.f26414e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26414e.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26414e.f26393e.v();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26415e;

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
            this.f26415e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26415e.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26415e.f26393e.u();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26416e;

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
            this.f26416e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26416e.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26416e.f26393e.F();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f26417e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26418f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.v0.s f26419g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f26420h;

        public m(d dVar, w wVar, boolean z, c.a.v0.s sVar) {
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
            this.f26420h = dVar;
            this.f26417e = wVar;
            this.f26418f = z;
            this.f26419g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26420h.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26420h.f26393e.K(this.f26417e, this.f26418f, this.f26419g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26424e;

        /* renamed from: f  reason: collision with root package name */
        public int f26425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26426g;

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
            this.f26426g = dVar;
            this.f26424e = str;
            this.f26425f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26426g.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26426g.f26393e.h(this.f26424e, this.f26425f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26429e;

        /* renamed from: f  reason: collision with root package name */
        public int f26430f;

        /* renamed from: g  reason: collision with root package name */
        public int f26431g;

        /* renamed from: h  reason: collision with root package name */
        public long f26432h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f26433i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f26434j;

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
            this.f26434j = dVar;
            this.f26429e = str;
            this.f26430f = i2;
            this.f26431g = i3;
            this.f26432h = System.currentTimeMillis();
            this.f26433i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26434j.f26393e == null) {
                    boolean unused = d.k;
                    return;
                }
                x.f().a(this.f26429e, true);
                this.f26434j.f26393e.l(this.f26429e, this.f26430f, this.f26431g, this.f26432h, this.f26433i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26435e;

        /* renamed from: f  reason: collision with root package name */
        public int f26436f;

        /* renamed from: g  reason: collision with root package name */
        public String f26437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f26438h;

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
            this.f26438h = dVar;
            this.f26435e = str;
            this.f26436f = i2;
            this.f26437g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26438h.f26393e == null) {
                    boolean unused = d.k;
                } else {
                    this.f26438h.f26393e.L(this.f26435e, this.f26436f, this.f26437g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26439e;

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
            this.f26439e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f26439e.f26392d = c.a.v0.g.o();
                this.f26439e.f26393e = new c.a.v0.c(this.f26439e.a);
                this.f26439e.f26393e.H();
                d dVar = this.f26439e;
                dVar.f26398j = dVar.f26392d.N();
            }
        }

        public /* synthetic */ s(d dVar, RunnableC1590d runnableC1590d) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1352752230, "Lc/a/v0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1352752230, "Lc/a/v0/d;");
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
        this.f26395g = false;
        y(b0.b());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f26394f;
        dVar.f26394f = i2 + 1;
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
            this.f26390b.execute(new n(this, str, str2, i2));
        }
    }

    public void B(String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, str3) == null) {
            this.f26390b.execute(new n(this, str, str2, i2, str3));
        }
    }

    public void C(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, i2) == null) {
            this.f26390b.execute(new n(this, str, jSONObject, i2));
        }
    }

    public void D(String str, JSONObject jSONObject, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, jSONObject, i2, str2) == null) {
            this.f26390b.execute(new n(this, str, jSONObject, i2, str2));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26390b.execute(new k(this));
        }
    }

    public void F(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f26390b.execute(new n(this, str, str2, i2, str3, i3));
        }
    }

    public void G(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f26390b.execute(new n(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26390b.execute(new j(this));
        }
    }

    public void I(c.a.v0.n nVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, z) == null) {
            this.f26390b.execute(new b(this, nVar, z));
        }
    }

    public void J(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, runnable, j2) == null) {
            this.f26390b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && c.a.k0.b.a.a.g()) {
            this.f26390b.execute(new a(this));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f26390b.execute(new l(this));
        }
    }

    public void M(w wVar, boolean z, c.a.v0.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f26390b.execute(new m(this, wVar, z, sVar));
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, str2) == null) {
            this.f26390b.execute(new r(this, str, i2, str2));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f26395g) {
            return;
        }
        this.f26395g = true;
        this.f26390b.execute(new e(this));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f26390b.execute(new f(this));
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
                c.C1589c c1589c = new c.C1589c();
                boolean x = l0Var.x();
                c1589c.a = x;
                if (x) {
                    c1589c.f26383c = l0Var.o();
                    c1589c.f26386f = l0Var.m();
                } else {
                    c1589c.f26384d = l0Var.u();
                }
                c1589c.f26388h = l0Var.A();
                c1589c.f26385e = str;
                i0.m().z();
                this.f26391c.execute(new i(this, c1589c));
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

    public final void T(JSONObject jSONObject, String str, boolean z, c.a.v0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jSONObject, str, Boolean.valueOf(z), nVar, tVar}) == null) {
            if (k) {
                String str2 = "uploadData:" + str;
                jSONObject.toString();
            }
            boolean l2 = b0.l();
            boolean z2 = (nVar == null || (nVar.n() & 128) == 0) ? false : true;
            if (l2 || z2) {
                c.C1589c c1589c = new c.C1589c();
                c1589c.a = false;
                c1589c.f26384d = jSONObject;
                c1589c.f26385e = str;
                c1589c.f26387g = z;
                c1589c.f26388h = z2;
                c1589c.f26382b = nVar;
                c1589c.f26389i = tVar;
                this.f26391c.execute(new h(this, c1589c));
            }
        }
    }

    public void U(JSONObject jSONObject, boolean z, c.a.v0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{jSONObject, Boolean.valueOf(z), nVar, tVar}) == null) {
            T(jSONObject, null, z, nVar, tVar);
        }
    }

    public void V(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            this.f26390b.execute(new c(this, z, str));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f26390b.execute(new RunnableC1590d(this));
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
                    if (this.f26392d != null && this.f26392d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26390b.execute(pVar);
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
                    if (this.f26392d != null && this.f26392d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26390b.execute(pVar);
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
                    if (this.f26392d != null && this.f26392d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26390b.execute(pVar);
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
                    if (this.f26392d != null && this.f26392d.J(str)) {
                        pVar.a(true);
                    }
                    this.f26390b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) {
            this.f26390b.execute(new o(this, str, i2));
        }
    }

    public Flow t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f26394f, i2);
            c.a.v0.g gVar = this.f26392d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !b0.i().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.v0.g gVar2 = this.f26392d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.v0.g gVar3 = this.f26392d;
                if (gVar3 != null && gVar3.F(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.v0.g gVar4 = this.f26392d;
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
            this.f26390b.execute(new q(this, str, i2, i3, jSONArray));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f26390b.execute(new g(this));
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            c.a.v0.c cVar = this.f26393e;
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
            this.f26394f = b0.d();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f26390b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new s(this, null));
            this.f26391c = Executors.newSingleThreadExecutor();
        }
    }

    public void z(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048609, this, str, str2, str3, i2) == null) {
            n nVar = new n(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                nVar.e(str3);
            }
            this.f26390b.execute(nVar);
        }
    }

    /* loaded from: classes9.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.v0.n f26421e;

        /* renamed from: f  reason: collision with root package name */
        public String f26422f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f26423g;

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
            this.f26423g = dVar;
            this.f26421e = new c.a.v0.n(str, str2, i2);
            this.f26422f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || b0.i().c(str)) {
                    if (this.f26423g.f26392d == null || this.f26423g.f26392d.g(str, i2)) {
                        if (this.f26423g.f26392d == null || !this.f26423g.f26392d.F(str)) {
                            if (this.f26423g.f26392d == null || !this.f26423g.f26392d.h(str)) {
                                return this.f26423g.f26392d == null || !this.f26423g.f26392d.d(str);
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
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (length = str2.length()) <= (s = c.a.v0.g.o().s())) {
                return;
            }
            d0.a().g(String.valueOf(s), String.valueOf(length), str);
            if (d.k) {
                String str3 = "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(s / 1024), str, str2));
            }
        }

        public final void c() {
            c.a.v0.n nVar;
            JSONObject m;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f26421e) == null) {
                return;
            }
            String l = nVar.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String f2 = this.f26421e.f();
            if (TextUtils.isEmpty(f2) && (m = this.f26421e.m()) != null) {
                try {
                    f2 = m.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f26423g.f26396h != null) {
                        this.f26423g.f26396h.b(l, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            b(l, f2);
            if (this.f26423g.f26396h != null) {
                this.f26423g.f26396h.a(l, f2);
            }
        }

        public void d(boolean z) {
            c.a.v0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f26421e) == null) {
                return;
            }
            nVar.u(z);
        }

        public void e(String str) {
            c.a.v0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f26421e) == null) {
                return;
            }
            nVar.x(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f26423g.f26393e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (!this.f26423g.f26397i) {
                    if (this.f26423g.f26396h == null) {
                        this.f26423g.f26396h = (v) ServiceManager.getService(v.a);
                    }
                    this.f26423g.f26397i = true;
                }
                if (this.f26423g.f26392d != null && this.f26423g.f26392d.b(this.f26422f) == 1) {
                    c();
                }
                if (this.f26421e.j() == -1) {
                    if (!a(this.f26421e.l(), this.f26421e.n())) {
                        return;
                    }
                    if (this.f26423g.f26392d != null && this.f26423g.f26392d.J(this.f26421e.l())) {
                        d(true);
                    }
                    x.f().a(this.f26421e.l(), true);
                }
                this.f26421e.v();
                String l = this.f26421e.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                if (this.f26423g.f26392d != null) {
                    String j2 = this.f26423g.f26392d.j(l);
                    if (!TextUtils.isEmpty(j2)) {
                        this.f26421e.s(j2);
                    }
                }
                if (this.f26423g.f26392d != null && this.f26423g.f26392d.b(this.f26422f) == 2) {
                    c();
                }
                if (this.f26421e.j() == -1 && TextUtils.equals(l, "1876")) {
                    this.f26423g.f26393e.C(this.f26421e);
                } else if ((this.f26421e.n() & 8) != 0) {
                    this.f26423g.f26393e.B(this.f26421e);
                } else if ((this.f26421e.n() & 128) != 0) {
                    if (this.f26423g.f26398j) {
                        this.f26423g.f26393e.t(this.f26421e);
                    } else {
                        this.f26423g.f26393e.A(this.f26421e);
                    }
                } else if (this.f26421e == null || this.f26423g.f26392d == null || !this.f26423g.f26392d.f(l)) {
                    if (this.f26423g.f26398j) {
                        this.f26423g.f26393e.t(this.f26421e);
                    } else {
                        this.f26423g.f26393e.A(this.f26421e);
                    }
                } else {
                    this.f26423g.f26393e.X(this.f26421e);
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
            this.f26423g = dVar;
            c.a.v0.n nVar = new c.a.v0.n(str, str2, i2);
            this.f26421e = nVar;
            this.f26422f = str;
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
            this.f26423g = dVar;
            this.f26421e = new c.a.v0.n(str, jSONObject, i2);
            this.f26422f = str;
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
            this.f26423g = dVar;
            c.a.v0.n nVar = new c.a.v0.n(str, jSONObject, i2);
            this.f26421e = nVar;
            this.f26422f = str;
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
            this.f26423g = dVar;
            this.f26421e = new c.a.v0.n(str, str2, i2, str3, i3);
            this.f26422f = str;
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
            this.f26423g = dVar;
            this.f26421e = new c.a.v0.n(str, str2, i2, str3, j2, i3);
            this.f26422f = str;
        }
    }

    /* loaded from: classes9.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.v0.p f26427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26428f;

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
            this.f26428f = dVar;
            c.a.v0.p pVar = new c.a.v0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f26427e = pVar;
            pVar.q(flow.getStartTime());
            this.f26427e.C("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            c.a.v0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f26427e) == null) {
                return;
            }
            pVar.u(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f26428f.f26393e == null) {
                    boolean unused = d.k;
                    return;
                }
                this.f26427e.x();
                if (!TextUtils.isEmpty(this.f26428f.f26392d.j(this.f26427e.l()))) {
                    this.f26427e.s(this.f26428f.f26392d.j(this.f26427e.l()));
                }
                this.f26428f.f26393e.I(this.f26427e);
                b0.q(this.f26428f.f26394f);
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
            this.f26428f = dVar;
            c.a.v0.p pVar = new c.a.v0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f26427e = pVar;
            pVar.q(flow.getStartTime());
            this.f26427e.C("1");
            d.n(dVar);
            this.f26427e.r(str2);
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
            this.f26428f = dVar;
            c.a.v0.p pVar = new c.a.v0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f26427e = pVar;
            pVar.q(flow.getStartTime());
            this.f26427e.C("1");
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
            this.f26428f = dVar;
            c.a.v0.p pVar = new c.a.v0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f26427e = pVar;
            pVar.q(flow.getStartTime());
            this.f26427e.C("1");
            d.n(dVar);
            this.f26427e.r(str);
        }
    }
}
