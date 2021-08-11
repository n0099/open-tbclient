package c.a.r0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.f0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import java.io.File;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
@Autowired
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile d l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f29445a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f29446b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f29447c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.g f29448d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.c f29449e;

    /* renamed from: f  reason: collision with root package name */
    public f0 f29450f;

    /* renamed from: g  reason: collision with root package name */
    public int f29451g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29452h;

    /* renamed from: i  reason: collision with root package name */
    public v f29453i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29454j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29455e;

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
            this.f29455e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29455e.f29449e == null) {
                return;
            }
            this.f29455e.f29449e.P();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29456e;

        public b(d dVar) {
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
            this.f29456e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29456e.f29449e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - i0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f29456e.f29449e.P();
                long currentTimeMillis = System.currentTimeMillis();
                i0.e().putLong("ubc_last_upload_all_time", currentTimeMillis);
                i0.e().putLong("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29457e;

        public c(d dVar) {
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
            this.f29457e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29457e.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29457e.f29449e.m();
                }
            }
        }
    }

    /* renamed from: c.a.r0.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1383d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f29458e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29459f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f29460g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f29461h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.n f29462i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ t f29463j;
        public final /* synthetic */ d k;

        public RunnableC1383d(d dVar, JSONObject jSONObject, String str, boolean z, boolean z2, c.a.r0.n nVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, jSONObject, str, Boolean.valueOf(z), Boolean.valueOf(z2), nVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = dVar;
            this.f29458e = jSONObject;
            this.f29459f = str;
            this.f29460g = z;
            this.f29461h = z2;
            this.f29462i = nVar;
            this.f29463j = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.k.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.k.f29449e.K(this.f29458e, this.f29459f, this.f29460g, this.f29461h, this.f29462i, this.f29463j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f29465f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f29466g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f29467h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f29468i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f29469j;

        public e(d dVar, boolean z, File file, String str, boolean z2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z), file, str, Boolean.valueOf(z2), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29469j = dVar;
            this.f29464e = z;
            this.f29465f = file;
            this.f29466g = str;
            this.f29467h = z2;
            this.f29468i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29469j.f29449e == null) {
                    boolean unused = d.k;
                } else if (this.f29464e) {
                    this.f29469j.f29449e.J(this.f29465f, this.f29466g, false, this.f29467h, null, null);
                } else {
                    this.f29469j.f29449e.K(this.f29468i, this.f29466g, false, this.f29467h, null, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29470e;

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
            this.f29470e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29470e.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29470e.f29449e.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29471e;

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
            this.f29471e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29471e.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29471e.f29449e.C();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29472e;

        public h(d dVar) {
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
            this.f29472e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29472e.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29472e.f29449e.B();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29474f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29475g;

        public i(d dVar, boolean z, String str) {
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
            this.f29475g = dVar;
            this.f29473e = z;
            this.f29474f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29475g.f29449e == null) {
                    boolean unused = d.k;
                } else if (this.f29473e) {
                    this.f29475g.f29449e.N(this.f29474f);
                } else {
                    this.f29475g.f29449e.M(this.f29474f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f29476e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29477f;

        /* renamed from: g  reason: collision with root package name */
        public s f29478g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29479h;

        public j(d dVar, w wVar, boolean z, s sVar) {
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
            this.f29479h = dVar;
            this.f29476e = wVar;
            this.f29477f = z;
            this.f29478g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29479h.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29479h.f29449e.H(this.f29476e, this.f29477f, this.f29478g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29483e;

        /* renamed from: f  reason: collision with root package name */
        public int f29484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29485g;

        public l(d dVar, String str, int i2) {
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
            this.f29485g = dVar;
            this.f29483e = str;
            this.f29484f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29485g.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29485g.f29449e.h(this.f29483e, this.f29484f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29488e;

        /* renamed from: f  reason: collision with root package name */
        public int f29489f;

        /* renamed from: g  reason: collision with root package name */
        public int f29490g;

        /* renamed from: h  reason: collision with root package name */
        public long f29491h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f29492i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f29493j;

        public n(d dVar, String str, int i2, int i3, JSONArray jSONArray) {
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
            this.f29493j = dVar;
            this.f29488e = str;
            this.f29489f = i2;
            this.f29490g = i3;
            this.f29491h = System.currentTimeMillis();
            this.f29492i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29493j.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29493j.f29449e.l(this.f29488e, this.f29489f, this.f29490g, this.f29491h, this.f29492i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29494e;

        /* renamed from: f  reason: collision with root package name */
        public int f29495f;

        /* renamed from: g  reason: collision with root package name */
        public String f29496g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29497h;

        public o(d dVar, String str, int i2, String str2) {
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
            this.f29497h = dVar;
            this.f29494e = str;
            this.f29495f = i2;
            this.f29496g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29497h.f29449e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29497h.f29449e.I(this.f29494e, this.f29495f, this.f29496g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29498e;

        public p(d dVar) {
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
            this.f29498e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f29498e.f29448d = c.a.r0.g.n();
                this.f29498e.f29449e = new c.a.r0.c(this.f29498e.f29445a);
                this.f29498e.f29449e.E();
                this.f29498e.f29450f = new f0(this.f29498e.f29445a);
                this.f29498e.f29450f.l(new q(this.f29498e, null));
            }
        }

        public /* synthetic */ p(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class q implements f0.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29499a;

        public q(d dVar) {
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
            this.f29499a = dVar;
        }

        @Override // c.a.r0.f0.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.f0.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f29499a.F();
            }
        }

        @Override // c.a.r0.f0.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f29499a.F();
            }
        }

        public /* synthetic */ q(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349058146, "Lc/a/r0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349058146, "Lc/a/r0/d;");
                return;
            }
        }
        k = AppConfig.isDebug();
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
        this.f29452h = false;
        x(UBC.getContext());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f29451g;
        dVar.f29451g = i2 + 1;
        return i2;
    }

    @Inject
    public static final r t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? c.a.p0.d3.t.a() : (r) invokeV.objValue;
    }

    public static d v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
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

    public void A(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, jSONObject, i2) == null) {
            this.f29446b.execute(new k(this, str, jSONObject, i2));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29446b.execute(new f(this));
        }
    }

    public void C(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f29446b.execute(new k(this, str, str2, i2, str3, i3));
        }
    }

    public void D(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f29446b.execute(new k(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void E(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, runnable, j2) == null) {
            this.f29446b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c.a.g0.b.a.a.g()) {
            this.f29446b.execute(new h(this));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29446b.execute(new g(this));
        }
    }

    public void H(w wVar, boolean z, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f29446b.execute(new j(this, wVar, z, sVar));
        }
    }

    public void I(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, str2) == null) {
            this.f29446b.execute(new o(this, str, i2, str2));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f29452h) {
            return;
        }
        this.f29452h = true;
        this.f29446b.execute(new b(this));
    }

    public void K(j0 j0Var, String str) {
        File file;
        JSONObject t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, j0Var, str) == null) {
            if (k) {
                String str2 = "uploadData isDataInFile:" + j0Var.w();
                if (j0Var.w()) {
                    j0Var.E("UBCDEBUG");
                } else {
                    j0Var.t().toString();
                }
            }
            boolean z = true;
            r t2 = t();
            if (t2 != null && !t2.a()) {
                z = false;
            }
            if (z || j0Var.z()) {
                boolean w = j0Var.w();
                if (w) {
                    t = null;
                    file = j0Var.n();
                } else {
                    file = null;
                    t = j0Var.t();
                }
                this.f29447c.execute(new e(this, w, file, str, j0Var.z(), t));
            }
        }
    }

    public void L(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            M(jSONObject, null);
        }
    }

    public void M(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, str) == null) {
            N(jSONObject, str, false, null, null);
        }
    }

    public void N(JSONObject jSONObject, String str, boolean z, c.a.r0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{jSONObject, str, Boolean.valueOf(z), nVar, tVar}) == null) {
            if (k) {
                String str2 = "uploadData:" + str;
                jSONObject.toString();
            }
            r t = t();
            boolean z2 = t == null || t.a();
            boolean z3 = (nVar == null || (nVar.l() & 128) == 0) ? false : true;
            if (z2 || z3) {
                this.f29447c.execute(new RunnableC1383d(this, jSONObject, str, z, z3, nVar, tVar));
            }
        }
    }

    public void O(JSONObject jSONObject, boolean z, c.a.r0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{jSONObject, Boolean.valueOf(z), nVar, tVar}) == null) {
            N(jSONObject, null, z, nVar, tVar);
        }
    }

    public void P(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            this.f29446b.execute(new i(this, z, str));
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f29446b.execute(new a(this));
        }
    }

    public synchronized Flow o(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048593, this, str, str2, i2)) == null) {
            synchronized (this) {
                r = r(str, i2);
                if (r != null && r.getValid()) {
                    m mVar = new m(this, r, str2);
                    if (this.f29448d != null && this.f29448d.C(str)) {
                        mVar.a(true);
                    }
                    this.f29446b.execute(mVar);
                }
            }
            return r;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow p(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Flow r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, str, jSONObject, i2)) == null) {
            synchronized (this) {
                r = r(str, i2);
                if (r != null && r.getValid()) {
                    m mVar = new m(this, r, jSONObject);
                    if (this.f29448d != null && this.f29448d.C(str)) {
                        mVar.a(true);
                    }
                    this.f29446b.execute(mVar);
                }
            }
            return r;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void q(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, str, i2) == null) {
            this.f29446b.execute(new l(this, str, i2));
        }
    }

    public Flow r(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f29451g, i2);
            c.a.r0.g gVar = this.f29448d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.r0.g gVar2 = this.f29448d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.r0.g gVar3 = this.f29448d;
                if (gVar3 != null && gVar3.z(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.r0.g gVar4 = this.f29448d;
                if (gVar4 != null && !gVar4.D(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public void s(String str, int i2, int i3, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), jSONArray}) == null) {
            this.f29446b.execute(new n(this, str, i2, i3, jSONArray));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f29446b.execute(new c(this));
        }
    }

    public String w(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            c.a.r0.c cVar = this.f29449e;
            return (cVar == null || (q2 = cVar.q(str)) == -1) ? "" : String.valueOf(q2);
        }
        return (String) invokeL.objValue;
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, context) == null) && this.f29445a == null && context != null) {
            if (context instanceof Application) {
                this.f29445a = context;
            } else {
                this.f29445a = context.getApplicationContext();
            }
            this.f29451g = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f29446b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new p(this, null));
            this.f29447c = Executors.newSingleThreadExecutor();
        }
    }

    public void y(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048601, this, str, str2, str3, i2) == null) {
            k kVar = new k(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                kVar.e(str3);
            }
            this.f29446b.execute(kVar);
        }
    }

    public void z(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, str, str2, i2) == null) {
            this.f29446b.execute(new k(this, str, str2, i2));
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.n f29480e;

        /* renamed from: f  reason: collision with root package name */
        public String f29481f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29482g;

        public k(d dVar, String str, String str2, int i2) {
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
            this.f29482g = dVar;
            this.f29480e = new c.a.r0.n(str, str2, i2);
            this.f29481f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                    if (this.f29482g.f29448d == null || this.f29482g.f29448d.g(str, i2)) {
                        if (this.f29482g.f29448d == null || !this.f29482g.f29448d.z(str)) {
                            if (this.f29482g.f29448d == null || !this.f29482g.f29448d.h(str)) {
                                return this.f29482g.f29448d == null || !this.f29482g.f29448d.d(str);
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
            int r;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (length = str2.length()) <= (r = c.a.r0.g.n().r())) {
                return;
            }
            b0.a().g(String.valueOf(r), String.valueOf(length), str);
            if (d.k) {
                String str3 = "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(r / 1024), str, str2));
            }
        }

        public final void c() {
            c.a.r0.n nVar;
            JSONObject k;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f29480e) == null) {
                return;
            }
            String j2 = nVar.j();
            if (TextUtils.isEmpty(j2)) {
                return;
            }
            String d2 = this.f29480e.d();
            if (TextUtils.isEmpty(d2) && (k = this.f29480e.k()) != null) {
                try {
                    d2 = k.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f29482g.f29453i != null) {
                        this.f29482g.f29453i.b(j2, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            b(j2, d2);
            if (this.f29482g.f29453i != null) {
                this.f29482g.f29453i.a(j2, d2);
            }
        }

        public void d(boolean z) {
            c.a.r0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f29480e) == null) {
                return;
            }
            nVar.r(z);
        }

        public void e(String str) {
            c.a.r0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f29480e) == null) {
                return;
            }
            nVar.u(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f29482g.f29449e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (!this.f29482g.f29454j) {
                    if (this.f29482g.f29453i == null) {
                        this.f29482g.f29453i = (v) ServiceManager.getService(v.f29606a);
                    }
                    this.f29482g.f29454j = true;
                }
                if (this.f29482g.f29448d != null && this.f29482g.f29448d.b(this.f29481f) == 1) {
                    c();
                }
                if (this.f29480e.h() == -1) {
                    if (!a(this.f29480e.j(), this.f29480e.l())) {
                        return;
                    }
                    if (this.f29482g.f29448d != null && this.f29482g.f29448d.C(this.f29480e.j())) {
                        d(true);
                    }
                    x.f().a(this.f29480e.j());
                }
                this.f29480e.s();
                String j2 = this.f29480e.j();
                if (TextUtils.isEmpty(j2)) {
                    return;
                }
                if (this.f29482g.f29448d != null) {
                    String i2 = this.f29482g.f29448d.i(j2);
                    if (!TextUtils.isEmpty(i2)) {
                        this.f29480e.p(i2);
                    }
                }
                if (this.f29482g.f29448d != null && this.f29482g.f29448d.b(this.f29481f) == 2) {
                    c();
                }
                if (this.f29480e.h() == -1 && TextUtils.equals(j2, "1876")) {
                    this.f29482g.f29449e.z(this.f29480e);
                } else if ((this.f29480e.l() & 8) != 0) {
                    this.f29482g.f29449e.y(this.f29480e);
                } else if ((this.f29480e.l() & 128) != 0) {
                    this.f29482g.f29449e.x(this.f29480e);
                } else if (this.f29480e == null || this.f29482g.f29448d == null || !this.f29482g.f29448d.f(j2)) {
                    this.f29482g.f29449e.x(this.f29480e);
                } else {
                    this.f29482g.f29449e.U(this.f29480e);
                }
            }
        }

        public k(d dVar, String str, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f29482g = dVar;
            this.f29480e = new c.a.r0.n(str, jSONObject, i2);
            this.f29481f = str;
        }

        public k(d dVar, String str, String str2, int i2, String str3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f29482g = dVar;
            this.f29480e = new c.a.r0.n(str, str2, i2, str3, i3);
            this.f29481f = str;
        }

        public k(d dVar, String str, String str2, int i2, String str3, long j2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f29482g = dVar;
            this.f29480e = new c.a.r0.n(str, str2, i2, str3, j2, i3);
            this.f29481f = str;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.p f29486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29487f;

        public m(d dVar, Flow flow, String str) {
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
            this.f29487f = dVar;
            c.a.r0.p pVar = new c.a.r0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f29486e = pVar;
            pVar.o(flow.getStartTime());
            this.f29486e.z("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            c.a.r0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f29486e) == null) {
                return;
            }
            pVar.r(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f29487f.f29449e == null) {
                    boolean unused = d.k;
                    return;
                }
                this.f29486e.u();
                if (!TextUtils.isEmpty(this.f29487f.f29448d.i(this.f29486e.j()))) {
                    this.f29486e.p(this.f29487f.f29448d.i(this.f29486e.j()));
                }
                this.f29487f.f29449e.F(this.f29486e);
                QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, this.f29487f.f29451g);
            }
        }

        public m(d dVar, Flow flow, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f29487f = dVar;
            c.a.r0.p pVar = new c.a.r0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f29486e = pVar;
            pVar.o(flow.getStartTime());
            this.f29486e.z("1");
            d.n(dVar);
        }
    }
}
