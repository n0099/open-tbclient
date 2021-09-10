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
    public Context f29931a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f29932b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f29933c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.g f29934d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.c f29935e;

    /* renamed from: f  reason: collision with root package name */
    public f0 f29936f;

    /* renamed from: g  reason: collision with root package name */
    public int f29937g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29938h;

    /* renamed from: i  reason: collision with root package name */
    public v f29939i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29940j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29941e;

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
            this.f29941e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29941e.f29935e == null) {
                return;
            }
            this.f29941e.f29935e.P();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29942e;

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
            this.f29942e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29942e.f29935e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - i0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f29942e.f29935e.P();
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
        public final /* synthetic */ d f29943e;

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
            this.f29943e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29943e.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29943e.f29935e.m();
                }
            }
        }
    }

    /* renamed from: c.a.t0.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1395d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f29944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29945f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f29946g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f29947h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.n f29948i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ t f29949j;
        public final /* synthetic */ d k;

        public RunnableC1395d(d dVar, JSONObject jSONObject, String str, boolean z, boolean z2, c.a.t0.n nVar, t tVar) {
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
            this.f29944e = jSONObject;
            this.f29945f = str;
            this.f29946g = z;
            this.f29947h = z2;
            this.f29948i = nVar;
            this.f29949j = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.k.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.k.f29935e.K(this.f29944e, this.f29945f, this.f29946g, this.f29947h, this.f29948i, this.f29949j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f29951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f29952g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f29953h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f29954i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f29955j;

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
            this.f29955j = dVar;
            this.f29950e = z;
            this.f29951f = file;
            this.f29952g = str;
            this.f29953h = z2;
            this.f29954i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29955j.f29935e == null) {
                    boolean unused = d.k;
                } else if (this.f29950e) {
                    this.f29955j.f29935e.J(this.f29951f, this.f29952g, false, this.f29953h, null, null);
                } else {
                    this.f29955j.f29935e.K(this.f29954i, this.f29952g, false, this.f29953h, null, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29956e;

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
            this.f29956e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29956e.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29956e.f29935e.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29957e;

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
            this.f29957e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29957e.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29957e.f29935e.C();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29958e;

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
            this.f29958e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29958e.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29958e.f29935e.B();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f29959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f29960f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29961g;

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
            this.f29961g = dVar;
            this.f29959e = z;
            this.f29960f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29961g.f29935e == null) {
                    boolean unused = d.k;
                } else if (this.f29959e) {
                    this.f29961g.f29935e.N(this.f29960f);
                } else {
                    this.f29961g.f29935e.M(this.f29960f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public w f29962e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29963f;

        /* renamed from: g  reason: collision with root package name */
        public s f29964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29965h;

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
            this.f29965h = dVar;
            this.f29962e = wVar;
            this.f29963f = z;
            this.f29964g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29965h.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29965h.f29935e.H(this.f29962e, this.f29963f, this.f29964g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29969e;

        /* renamed from: f  reason: collision with root package name */
        public int f29970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29971g;

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
            this.f29971g = dVar;
            this.f29969e = str;
            this.f29970f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29971g.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29971g.f29935e.h(this.f29969e, this.f29970f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29974e;

        /* renamed from: f  reason: collision with root package name */
        public int f29975f;

        /* renamed from: g  reason: collision with root package name */
        public int f29976g;

        /* renamed from: h  reason: collision with root package name */
        public long f29977h;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f29978i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f29979j;

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
            this.f29979j = dVar;
            this.f29974e = str;
            this.f29975f = i2;
            this.f29976g = i3;
            this.f29977h = System.currentTimeMillis();
            this.f29978i = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29979j.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29979j.f29935e.l(this.f29974e, this.f29975f, this.f29976g, this.f29977h, this.f29978i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29980e;

        /* renamed from: f  reason: collision with root package name */
        public int f29981f;

        /* renamed from: g  reason: collision with root package name */
        public String f29982g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f29983h;

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
            this.f29983h = dVar;
            this.f29980e = str;
            this.f29981f = i2;
            this.f29982g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29983h.f29935e == null) {
                    boolean unused = d.k;
                } else {
                    this.f29983h.f29935e.I(this.f29980e, this.f29981f, this.f29982g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29984e;

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
            this.f29984e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f29984e.f29934d = c.a.t0.g.n();
                this.f29984e.f29935e = new c.a.t0.c(this.f29984e.f29931a);
                this.f29984e.f29935e.E();
                this.f29984e.f29936f = new f0(this.f29984e.f29931a);
                this.f29984e.f29936f.l(new q(this.f29984e, null));
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
        public final /* synthetic */ d f29985a;

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
            this.f29985a = dVar;
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
                this.f29985a.F();
            }
        }

        @Override // c.a.t0.f0.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f29985a.F();
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
        this.f29938h = false;
        x(UBC.getContext());
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.f29937g;
        dVar.f29937g = i2 + 1;
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
            this.f29932b.execute(new k(this, str, jSONObject, i2));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29932b.execute(new f(this));
        }
    }

    public void C(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f29932b.execute(new k(this, str, str2, i2, str3, i3));
        }
    }

    public void D(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f29932b.execute(new k(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void E(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, runnable, j2) == null) {
            this.f29932b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c.a.h0.b.a.a.g()) {
            this.f29932b.execute(new h(this));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29932b.execute(new g(this));
        }
    }

    public void H(w wVar, boolean z, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            this.f29932b.execute(new j(this, wVar, z, sVar));
        }
    }

    public void I(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, str2) == null) {
            this.f29932b.execute(new o(this, str, i2, str2));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f29938h) {
            return;
        }
        this.f29938h = true;
        this.f29932b.execute(new b(this));
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
                this.f29933c.execute(new e(this, w, file, str, j0Var.z(), t));
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
                this.f29933c.execute(new RunnableC1395d(this, jSONObject, str, z, z3, nVar, tVar));
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
            this.f29932b.execute(new i(this, z, str));
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f29932b.execute(new a(this));
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
                    if (this.f29934d != null && this.f29934d.C(str)) {
                        mVar.a(true);
                    }
                    this.f29932b.execute(mVar);
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
                    if (this.f29934d != null && this.f29934d.C(str)) {
                        mVar.a(true);
                    }
                    this.f29932b.execute(mVar);
                }
            }
            return r;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void q(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, str, i2) == null) {
            this.f29932b.execute(new l(this, str, i2));
        }
    }

    public Flow r(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f29937g, i2);
            c.a.t0.g gVar = this.f29934d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.t0.g gVar2 = this.f29934d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar3 = this.f29934d;
                if (gVar3 != null && gVar3.z(str)) {
                    flow.setValid(false);
                    return flow;
                }
                c.a.t0.g gVar4 = this.f29934d;
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
            this.f29932b.execute(new n(this, str, i2, i3, jSONArray));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f29932b.execute(new c(this));
        }
    }

    public String w(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            c.a.t0.c cVar = this.f29935e;
            return (cVar == null || (q2 = cVar.q(str)) == -1) ? "" : String.valueOf(q2);
        }
        return (String) invokeL.objValue;
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, context) == null) && this.f29931a == null && context != null) {
            if (context instanceof Application) {
                this.f29931a = context;
            } else {
                this.f29931a = context.getApplicationContext();
            }
            this.f29937g = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f29932b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new p(this, null));
            this.f29933c = Executors.newSingleThreadExecutor();
        }
    }

    public void y(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048601, this, str, str2, str3, i2) == null) {
            k kVar = new k(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                kVar.e(str3);
            }
            this.f29932b.execute(kVar);
        }
    }

    public void z(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, str, str2, i2) == null) {
            this.f29932b.execute(new k(this, str, str2, i2));
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.n f29966e;

        /* renamed from: f  reason: collision with root package name */
        public String f29967f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29968g;

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
            this.f29968g = dVar;
            this.f29966e = new c.a.t0.n(str, str2, i2);
            this.f29967f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                    if (this.f29968g.f29934d == null || this.f29968g.f29934d.g(str, i2)) {
                        if (this.f29968g.f29934d == null || !this.f29968g.f29934d.z(str)) {
                            if (this.f29968g.f29934d == null || !this.f29968g.f29934d.h(str)) {
                                return this.f29968g.f29934d == null || !this.f29968g.f29934d.d(str);
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nVar = this.f29966e) == null) {
                return;
            }
            String j2 = nVar.j();
            if (TextUtils.isEmpty(j2)) {
                return;
            }
            String d2 = this.f29966e.d();
            if (TextUtils.isEmpty(d2) && (k = this.f29966e.k()) != null) {
                try {
                    d2 = k.toString();
                } catch (ConcurrentModificationException e2) {
                    if (this.f29968g.f29939i != null) {
                        this.f29968g.f29939i.b(j2, e2.toString());
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            b(j2, d2);
            if (this.f29968g.f29939i != null) {
                this.f29968g.f29939i.a(j2, d2);
            }
        }

        public void d(boolean z) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nVar = this.f29966e) == null) {
                return;
            }
            nVar.r(z);
        }

        public void e(String str) {
            c.a.t0.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nVar = this.f29966e) == null) {
                return;
            }
            nVar.u(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.f29968g.f29935e == null) {
                    boolean unused = d.k;
                    return;
                }
                if (!this.f29968g.f29940j) {
                    if (this.f29968g.f29939i == null) {
                        this.f29968g.f29939i = (v) ServiceManager.getService(v.f30092a);
                    }
                    this.f29968g.f29940j = true;
                }
                if (this.f29968g.f29934d != null && this.f29968g.f29934d.b(this.f29967f) == 1) {
                    c();
                }
                if (this.f29966e.h() == -1) {
                    if (!a(this.f29966e.j(), this.f29966e.l())) {
                        return;
                    }
                    if (this.f29968g.f29934d != null && this.f29968g.f29934d.C(this.f29966e.j())) {
                        d(true);
                    }
                    x.f().a(this.f29966e.j());
                }
                this.f29966e.s();
                String j2 = this.f29966e.j();
                if (TextUtils.isEmpty(j2)) {
                    return;
                }
                if (this.f29968g.f29934d != null) {
                    String i2 = this.f29968g.f29934d.i(j2);
                    if (!TextUtils.isEmpty(i2)) {
                        this.f29966e.p(i2);
                    }
                }
                if (this.f29968g.f29934d != null && this.f29968g.f29934d.b(this.f29967f) == 2) {
                    c();
                }
                if (this.f29966e.h() == -1 && TextUtils.equals(j2, "1876")) {
                    this.f29968g.f29935e.z(this.f29966e);
                } else if ((this.f29966e.l() & 8) != 0) {
                    this.f29968g.f29935e.y(this.f29966e);
                } else if ((this.f29966e.l() & 128) != 0) {
                    this.f29968g.f29935e.x(this.f29966e);
                } else if (this.f29966e == null || this.f29968g.f29934d == null || !this.f29968g.f29934d.f(j2)) {
                    this.f29968g.f29935e.x(this.f29966e);
                } else {
                    this.f29968g.f29935e.U(this.f29966e);
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
            this.f29968g = dVar;
            this.f29966e = new c.a.t0.n(str, jSONObject, i2);
            this.f29967f = str;
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
            this.f29968g = dVar;
            this.f29966e = new c.a.t0.n(str, str2, i2, str3, i3);
            this.f29967f = str;
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
            this.f29968g = dVar;
            this.f29966e = new c.a.t0.n(str, str2, i2, str3, j2, i3);
            this.f29967f = str;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.p f29972e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29973f;

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
            this.f29973f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f29972e = pVar;
            pVar.o(flow.getStartTime());
            this.f29972e.z("1");
            d.n(dVar);
        }

        public void a(boolean z) {
            c.a.t0.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.f29972e) == null) {
                return;
            }
            pVar.r(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f29973f.f29935e == null) {
                    boolean unused = d.k;
                    return;
                }
                this.f29972e.u();
                if (!TextUtils.isEmpty(this.f29973f.f29934d.i(this.f29972e.j()))) {
                    this.f29972e.p(this.f29973f.f29934d.i(this.f29972e.j()));
                }
                this.f29973f.f29935e.F(this.f29972e);
                QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, this.f29973f.f29937g);
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
            this.f29973f = dVar;
            c.a.t0.p pVar = new c.a.t0.p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f29972e = pVar;
            pVar.o(flow.getStartTime());
            this.f29972e.z("1");
            d.n(dVar);
        }
    }
}
