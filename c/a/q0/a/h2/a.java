package c.a.q0.a.h2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.h0.g.g;
import c.a.q0.a.h2.c.j.b;
import c.a.q0.a.h2.c.j.f;
import c.a.q0.a.k;
import c.a.q0.a.n2.n;
import c.a.q0.a.u.e.a.d;
import c.a.q0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends c.a.q0.a.d2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f6407g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.a.o2.g.g a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6408b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6409c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f6410d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c.a.q0.a.h2.c.j.b> f6411e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.q0.a.z2.f1.c f6412f;

    /* renamed from: c.a.q0.a.h2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0354a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.z2.g1.c f6413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6414f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f6415g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f6416h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f6417i;

        /* renamed from: c.a.q0.a.h2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0355a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0354a f6418e;

            public C0355a(C0354a c0354a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0354a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6418e = c0354a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0354a c0354a = this.f6418e;
                    c0354a.f6417i.u(c0354a.f6413e, iVar);
                }
            }
        }

        public C0354a(a aVar, c.a.q0.a.z2.g1.c cVar, String str, boolean z, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, str, Boolean.valueOf(z), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6417i = aVar;
            this.f6413e = cVar;
            this.f6414f = str;
            this.f6415g = z;
            this.f6416h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [c.a.q0.a.h2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [c.a.q0.a.h2.c.j.b$e, ResultDataT] */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.q0.a.h2.c.i iVar = new c.a.q0.a.h2.c.i();
                if (a.f6407g && c.a.q0.a.x1.a.a.m()) {
                    iVar.e();
                    iVar.a = new b.e(true, null);
                    this.f6417i.u(this.f6413e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                c.a.q0.a.e0.d.k("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f6414f);
                if (!z2 && !fVar.f6546d) {
                    if (!this.f6415g ? fVar.f6552j == 0 : fVar.f6552j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f6417i.c(this.f6416h, this.f6414f, this.f6415g, new C0355a(this));
                        return;
                    }
                    if (fVar.f6552j > 0) {
                        iVar.e();
                        iVar.a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f6417i.u(this.f6413e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f6417i.u(this.f6413e, iVar);
                c.a.q0.a.e0.d.l("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                n.r(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.z2.g1.c f6419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6420f;

        public b(a aVar, c.a.q0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6420f = aVar;
            this.f6419e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f6420f.u(this.f6419e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6422f;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6422f = aVar;
            this.f6421e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f6422f.f6411e.remove(this.f6421e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.q0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h2.c.j.b f6423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6424g;

        /* renamed from: c.a.q0.a.h2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0356a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f6425e;

            public C0356a(d dVar) {
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
                this.f6425e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f6425e.a();
                }
            }
        }

        public d(a aVar, c.a.q0.a.h2.c.j.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6423f = bVar;
            this.f6424g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.h2.c.j.b bVar = this.f6423f;
                bVar.q(c.a.q0.a.n2.f.a(this.f6424g));
                bVar.o(new C0356a(this));
                this.f6423f.call();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends i<c.a.q0.a.z2.g1.c<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C0354a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.h2.a.i
        /* renamed from: b */
        public void a(c.a.q0.a.z2.g1.c<ResulT> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                cVar.onCallback(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f6426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f6427f;

        public f(a aVar, i iVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, iVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6426e = iVar;
            this.f6427f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6426e.a(this.f6427f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends i<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C0354a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.h2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.q0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f6428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.C0502d f6429g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f6430h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6431i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.z2.g1.c f6432j;

        /* renamed from: c.a.q0.a.h2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0357a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f6433e;

            public C0357a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6433e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.q0.a.h2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f6433e.a();
                }
            }
        }

        public h(a aVar, Activity activity, d.C0502d c0502d, Bundle bundle, String str, c.a.q0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0502d, bundle, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6428f = activity;
            this.f6429g = c0502d;
            this.f6430h = bundle;
            this.f6431i = str;
            this.f6432j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.h2.c.j.f b2 = c.a.q0.a.d2.d.J().y().a().b().b(this.f6428f, this.f6429g, this.f6430h);
                b2.q(this.f6431i);
                b2.o(this.f6432j);
                b2.o(new C0357a(this));
                b2.call();
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class i<CallBackT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0354a c0354a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(622553063, "Lc/a/q0/a/h2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(622553063, "Lc/a/q0/a/h2/a;");
                return;
            }
        }
        f6407g = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.q0.a.d2.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.q0.a.d2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6410d = new HashSet();
        this.f6411e = new HashMap();
        this.f6412f = new c.a.q0.a.z2.f1.c();
        this.f6408b = c.a.q0.a.o2.b.t(eVar);
        this.f6409c = "aiapp_setting_" + this.f6408b;
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            q0.e0(runnable);
        }
    }

    public void A(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            o().putLong(str, j2);
        }
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            o().putString(str, str2);
        }
    }

    public synchronized void C(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            synchronized (this) {
                this.f6410d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a.remove(str);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.a.h0.g.g V = c.a.q0.a.g1.f.U().V();
            if (V == null) {
                c.a.q0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.q0.a.h.aiapps_open_fragment_failed_toast).G();
                return false;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(c.a.q0.a.h0.g.g.f5805g, c.a.q0.a.h0.g.g.f5807i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f6410d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), cVar}) == null) {
            d(context, str, z, true, false, cVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), cVar}) == null) {
            y(context, str, z, z2, z3, cVar);
        }
    }

    public void e(String str, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.f> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(cVar, null);
            } else {
                c.a.q0.a.p1.r.c.a.i(str, new b(this, cVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f6407g && c.a.q0.a.x1.a.a.m()) {
                return true;
            }
            c.a.q0.a.h2.c.f k2 = c.a.q0.a.p1.r.c.a.k(str);
            return (k2 == null || k2.f6546d || !k2.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, cVar) == null) {
            h(context, str, false, cVar);
        }
    }

    public void h(Context context, String str, boolean z, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), cVar}) == null) {
            e(str, new C0354a(this, cVar, str, z, context));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o().edit().clear().apply();
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f6411e.clear();
                this.f6412f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f6410d.clear();
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            o().edit().clear().commit();
        }
    }

    public boolean m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) ? o().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public long n(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j2)) == null) ? o().getLong(str, j2) : invokeLJ.longValue;
    }

    public final c.a.q0.a.o2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.q0.a.o2.g.g(this.f6409c, false);
            }
            return this.a;
        }
        return (c.a.q0.a.o2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f6409c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, d.C0502d c0502d, Bundle bundle, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<f.d>> cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0502d, bundle, cVar, str) == null) {
            this.f6412f.d(new h(this, activity, c0502d, bundle, str, cVar));
        }
    }

    public synchronized <CallBackT> void s(CallBackT callbackt, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, callbackt, iVar) == null) {
            synchronized (this) {
                x(new f(this, iVar, callbackt));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.a.q0.a.h2.a */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, collection, iVar) == null) {
            synchronized (this) {
                Iterator it = new ArrayList(collection).iterator();
                while (it.hasNext()) {
                    s(it.next(), iVar);
                }
            }
        }
    }

    public final <ResulT> void u(c.a.q0.a.z2.g1.c<ResulT> cVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, cVar, result) == null) {
            s(cVar, new e(this, result));
        }
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                t(this.f6410d, new g(this));
            }
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), cVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            c.a.q0.a.h2.c.j.b bVar = this.f6411e.get(str2);
            if (bVar != null && TaskState.FINISHED != bVar.e()) {
                bVar.o(cVar);
                return;
            }
            c.a.q0.a.h2.c.j.b d2 = c.a.q0.a.d2.d.J().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f6411e.put(str2, d2);
            d2.o(cVar);
            d2.o(new c(this, str2));
            n.T(c.a.q0.a.n2.f.a(str), "requestModifyScope");
            this.f6412f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
