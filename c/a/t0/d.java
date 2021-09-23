package c.a.t0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.f0;
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
    public Context f29952a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f29953b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f29954c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.g f29955d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.c f29956e;

    /* renamed from: f  reason: collision with root package name */
    public f0 f29957f;

    /* renamed from: g  reason: collision with root package name */
    public int f29958g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29959h;

    /* renamed from: i  reason: collision with root package name */
    public v f29960i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29961j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29962e;

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
            this.f29962e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29962e.f29956e == null) {
                return;
            }
            this.f29962e.f29956e.P();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29963e;

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
            this.f29963e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29963e.f29956e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - i0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f29963e.f29956e.P();
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
        public final /* synthetic */ d f29964e;

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
            this.f29964e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29964e.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29964e.f29956e.m();
                }
            }
        }
    }

    /* renamed from: c.a.t0.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1393d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f29965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29966f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f29967g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f29968h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.n f29969i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ t f29970j;
        public final /* synthetic */ d k;

        public RunnableC1393d(d dVar, JSONObject jSONObject, String str, boolean z, boolean z2, c.a.t0.n nVar, t tVar) {
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
            this.f29965e = jSONObject;
            this.f29966f = str;
            this.f29967g = z;
            this.f29968h = z2;
            this.f29969i = nVar;
            this.f29970j = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.k.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.k.f29956e.K(this.f29965e, this.f29966f, this.f29967g, this.f29968h, this.f29969i, this.f29970j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f29972f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f29973g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f29974h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f29975i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f29976j;

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
            this.f29976j = dVar;
            this.f29971e = z;
            this.f29972f = file;
            this.f29973g = str;
            this.f29974h = z2;
            this.f29975i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29976j.f29956e == null) {
                    boolean unused = d.k;
                } else if (this.f29971e) {
                    this.f29976j.f29956e.J(this.f29972f, this.f29973g, false, this.f29974h, null, null);
                } else {
                    this.f29976j.f29956e.K(this.f29975i, this.f29973g, false, this.f29974h, null, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29977e;

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
            this.f29977e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29977e.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29977e.f29956e.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29978e;

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
            this.f29978e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29978e.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29978e.f29956e.C();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29979e;

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
            this.f29979e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29979e.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29979e.f29956e.B();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29981f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29982g;

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
            this.f29982g = dVar;
            this.f29980e = z;
            this.f29981f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29982g.f29956e == null) {
                    boolean unused = d.k;
                } else if (this.f29980e) {
                    this.f29982g.f29956e.N(this.f29981f);
                } else {
                    this.f29982g.f29956e.M(this.f29981f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f29983e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29984f;

        /* renamed from: g  reason: collision with root package name */
        public s f29985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29986h;

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
            this.f29986h = dVar;
            this.f29983e = wVar;
            this.f29984f = z;
            this.f29985g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29986h.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29986h.f29956e.H(this.f29983e, this.f29984f, this.f29985g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29990e;

        /* renamed from: f  reason: collision with root package name */
        public int f29991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29992g;

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
            this.f29992g = dVar;
            this.f29990e = str;
            this.f29991f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29992g.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29992g.f29956e.h(this.f29990e, this.f29991f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29995e;

        /* renamed from: f  reason: collision with root package name */
        public int f29996f;

        /* renamed from: g  reason: collision with root package name */
        public int f29997g;

        /* renamed from: h  reason: collision with root package name */
        public long f29998h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f29999i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f30000j;

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
            this.f30000j = dVar;
            this.f29995e = str;
            this.f29996f = i2;
            this.f29997g = i3;
            this.f29998h = System.currentTimeMillis();
            this.f29999i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30000j.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f30000j.f29956e.l(this.f29995e, this.f29996f, this.f29997g, this.f29998h, this.f29999i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f30001e;

        /* renamed from: f  reason: collision with root package name */
        public int f30002f;

        /* renamed from: g  reason: collision with root package name */
        public String f30003g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f30004h;

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
            this.f30004h = dVar;
            this.f30001e = str;
            this.f30002f = i2;
            this.f30003g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30004h.f29956e == null) {
                    boolean unused = d.k;
                } else {
                    this.f30004h.f29956e.I(this.f30001e, this.f30002f, this.f30003g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f30005e;

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
            this.f30005e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f30005e.f29955d = c.a.t0.g.n();
                this.f30005e.f29956e = new c.a.t0.c(this.f30005e.f29952a);
                this.f30005e.f29956e.E();
                this.f30005e.f29957f = new f0(this.f30005e.f29952a);
                this.f30005e.f29957f.l(new q(this.f30005e, null));
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
        public final /* synthetic */ d f30006a;

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
            this.f30006a = dVar;
        }

        @Override // c.a.t0.f0.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.t0.f0.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f30006a.F();
            }
        }

        @Override // c.a.t0.f0.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f30006a.F();
            }
        }

        public /* synthetic */ q(d dVar, a aVar) {
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
        this.f29959h = false;
        x(UBC.getContext());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f29958g;
        dVar.f29958g = i2 + 1;
        return i2;
    }

    @Inject
    public static final r t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? c.a.r0.e3.t.a() : (r) invokeV.objValue;
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
            this.f29953b.execute(new k(this, str, jSONObject, i2));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29953b.execute(new f(this));
        }
    }

    public void C(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f29953b.execute(new k(this, str, str2, i2, str3, i3));
        }
    }

    public void D(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f29953b.execute(new k(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void E(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, runnable, j2) == null) {
            this.f29953b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c.a.h0.b.a.a.g()) {
            this.f29953b.execute(new h(this));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29953b.execute(new g(this));
        }
    }

    public void H(w wVar, boolean z, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f29953b.execute(new j(this, wVar, z, sVar));
        }
    }

    public void I(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, str2) == null) {
            this.f29953b.execute(new o(this, str, i2, str2));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f29959h) {
            return;
        }
        this.f29959h = true;
        this.f29953b.execute(new b(this));
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
                this.f29954c.execute(new e(this, w, file, str, j0Var.z(), t));
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

    public void N(JSONObject jSONObject, String str, boolean z, c.a.t0.n nVar, t tVar) {
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
                this.f29954c.execute(new RunnableC1393d(this, jSONObject, str, z, z3, nVar, tVar));
            }
        }
    }

    public void O(JSONObject jSONObject, boolean z, c.a.t0.n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{jSONObject, Boolean.valueOf(z), nVar, tVar}) == null) {
            N(jSONObject, null, z, nVar, tVar);
        }
    }

    public void P(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            this.f29953b.execute(new i(this, z, str));
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f29953b.execute(new a(this));
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
                    if (this.f29955d != null && this.f29955d.C(str)) {
                        mVar.a(true);
                    }
                    this.f29953b.execute(mVar);
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
                    if (this.f29955d != null && this.f29955d.C(str)) {
                        mVar.a(true);
                    }
                    this.f29953b.execute(mVar);
                }
            }
            return r;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void q(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, str, i2) == null) {
            this.f29953b.execute(new l(this, str, i2));
        }
    }

    public Flow r(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f29958g, i2);
            c.a.t0.g gVar = this.f29955d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.t0.g gVar2 = this.f29955d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar3 = this.f29955d;
                if (gVar3 != null && gVar3.z(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar4 = this.f29955d;
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
            this.f29953b.execute(new n(this, str, i2, i3, jSONArray));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f29953b.execute(new c(this));
        }
    }

    public String w(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            c.a.t0.c cVar = this.f29956e;
            return (cVar == null || (q2 = cVar.q(str)) == -1) ? "" : String.valueOf(q2);
        }
        return (String) invokeL.objValue;
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, context) == null) && this.f29952a == null && context != null) {
            if (context instanceof Application) {
                this.f29952a = context;
            } else {
                this.f29952a = context.getApplicationContext();
            }
            this.f29958g = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f29953b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new p(this, null));
            this.f29954c = Executors.newSingleThreadExecutor();
        }
    }

    public void y(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048601, this, str, str2, str3, i2) == null) {
            k kVar = new k(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                kVar.e(str3);
            }
            this.f29953b.execute(kVar);
        }
    }

    public void z(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, str, str2, i2) == null) {
            this.f29953b.execute(new k(this, str, str2, i2));
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.n f29987e;

        /* renamed from: f  reason: collision with root package name */
        public String f29988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29989g;

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
            this.f29989g = dVar;
            this.f29987e = new c.a.t0.n(str, str2, i2);
            this.f29988f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                    if (this.f29989g.f29955d == null || this.f29989g.f29955d.g(str, i2)) {
                        if (this.f29989g.f29955d == null || !this.f29989g.f29955d.z(str)) {
                            if (this.f29989g.f29955d == null || !this.f29989g.f29955d.h(str)) {
                                return this.f29989g.f29955d == null || !this.f29989g.f29955d.d(str);
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
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (length = str2.length()) <= (r = c.a.t0.g.n().r())) {
                return;
            }
            b0.a().g(String.valueOf(r), String.valueOf(length), str);
            if (d.k) {
                String str3 = "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(r / 1024), str, str2));
            }
        }

        public final void c() {
            c.a.t0.n nVar;
            JSONObject k;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f29987e) == null) {
                return;
            }
            String j2 = nVar.j();
            if (TextUtils.isEmpty(j2)) {
                return;
            }
            String d2 = this.f29987e.d();
            if (TextUtils.isEmpty(d2) && (k = this.f29987e.k()) != null) {
                try {
                    d2 = k.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f29989g.f29960i != null) {
                        this.f29989g.f29960i.b(j2, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            b(j2, d2);
            if (this.f29989g.f29960i != null) {
                this.f29989g.f29960i.a(j2, d2);
            }
        }

        public void d(boolean z) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f29987e) == null) {
                return;
            }
            nVar.r(z);
        }

        public void e(String str) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f29987e) == null) {
                return;
            }
            nVar.u(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f29989g.f29956e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (!this.f29989g.f29961j) {
                    if (this.f29989g.f29960i == null) {
                        this.f29989g.f29960i = (v) ServiceManager.getService(v.f30113a);
                    }
                    this.f29989g.f29961j = true;
                }
                if (this.f29989g.f29955d != null && this.f29989g.f29955d.b(this.f29988f) == 1) {
                    c();
                }
                if (this.f29987e.h() == -1) {
                    if (!a(this.f29987e.j(), this.f29987e.l())) {
                        return;
                    }
                    if (this.f29989g.f29955d != null && this.f29989g.f29955d.C(this.f29987e.j())) {
                        d(true);
                    }
                    x.f().a(this.f29987e.j());
                }
                this.f29987e.s();
                String j2 = this.f29987e.j();
                if (TextUtils.isEmpty(j2)) {
                    return;
                }
                if (this.f29989g.f29955d != null) {
                    String i2 = this.f29989g.f29955d.i(j2);
                    if (!TextUtils.isEmpty(i2)) {
                        this.f29987e.p(i2);
                    }
                }
                if (this.f29989g.f29955d != null && this.f29989g.f29955d.b(this.f29988f) == 2) {
                    c();
                }
                if (this.f29987e.h() == -1 && TextUtils.equals(j2, "1876")) {
                    this.f29989g.f29956e.z(this.f29987e);
                } else if ((this.f29987e.l() & 8) != 0) {
                    this.f29989g.f29956e.y(this.f29987e);
                } else if ((this.f29987e.l() & 128) != 0) {
                    this.f29989g.f29956e.x(this.f29987e);
                } else if (this.f29987e == null || this.f29989g.f29955d == null || !this.f29989g.f29955d.f(j2)) {
                    this.f29989g.f29956e.x(this.f29987e);
                } else {
                    this.f29989g.f29956e.U(this.f29987e);
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
            this.f29989g = dVar;
            this.f29987e = new c.a.t0.n(str, jSONObject, i2);
            this.f29988f = str;
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
            this.f29989g = dVar;
            this.f29987e = new c.a.t0.n(str, str2, i2, str3, i3);
            this.f29988f = str;
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
            this.f29989g = dVar;
            this.f29987e = new c.a.t0.n(str, str2, i2, str3, j2, i3);
            this.f29988f = str;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.p f29993e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29994f;

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
            this.f29994f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f29993e = pVar;
            pVar.o(flow.getStartTime());
            this.f29993e.z("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            c.a.t0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f29993e) == null) {
                return;
            }
            pVar.r(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f29994f.f29956e == null) {
                    boolean unused = d.k;
                    return;
                }
                this.f29993e.u();
                if (!TextUtils.isEmpty(this.f29994f.f29955d.i(this.f29993e.j()))) {
                    this.f29993e.p(this.f29994f.f29955d.i(this.f29993e.j()));
                }
                this.f29994f.f29956e.F(this.f29993e);
                QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, this.f29994f.f29958g);
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
            this.f29994f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f29993e = pVar;
            pVar.o(flow.getStartTime());
            this.f29993e.z("1");
            d.n(dVar);
        }
    }
}
