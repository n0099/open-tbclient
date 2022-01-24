package c.a.r0.a.h2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.h2.c.j.f;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.u.e.a.d;
import c.a.r0.a.z2.q0;
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
public class a extends c.a.r0.a.d2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f7131g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.o2.g.g a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7132b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7133c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f7134d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c.a.r0.a.h2.c.j.b> f7135e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.a.z2.f1.c f7136f;

    /* renamed from: c.a.r0.a.h2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0422a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f7137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f7140h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7141i;

        /* renamed from: c.a.r0.a.h2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0423a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0422a f7142e;

            public C0423a(C0422a c0422a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0422a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7142e = c0422a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0422a c0422a = this.f7142e;
                    c0422a.f7141i.u(c0422a.f7137e, iVar);
                }
            }
        }

        public C0422a(a aVar, c.a.r0.a.z2.g1.c cVar, String str, boolean z, Context context) {
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
            this.f7141i = aVar;
            this.f7137e = cVar;
            this.f7138f = str;
            this.f7139g = z;
            this.f7140h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [c.a.r0.a.h2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [c.a.r0.a.h2.c.j.b$e, ResultDataT] */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.r0.a.h2.c.i iVar = new c.a.r0.a.h2.c.i();
                if (a.f7131g && c.a.r0.a.x1.a.a.m()) {
                    iVar.e();
                    iVar.a = new b.e(true, null);
                    this.f7141i.u(this.f7137e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                c.a.r0.a.e0.d.k("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f7138f);
                if (!z2 && !fVar.f7267d) {
                    if (!this.f7139g ? fVar.f7273j == 0 : fVar.f7273j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f7141i.c(this.f7140h, this.f7138f, this.f7139g, new C0423a(this));
                        return;
                    }
                    if (fVar.f7273j > 0) {
                        iVar.e();
                        iVar.a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f7141i.u(this.f7137e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f7141i.u(this.f7137e, iVar);
                c.a.r0.a.e0.d.l("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                n.r(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f7143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7144f;

        public b(a aVar, c.a.r0.a.z2.g1.c cVar) {
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
            this.f7144f = aVar;
            this.f7143e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f7144f.u(this.f7143e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7145e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7146f;

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
            this.f7146f = aVar;
            this.f7145e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f7146f.f7135e.remove(this.f7145e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.r0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h2.c.j.b f7147f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7148g;

        /* renamed from: c.a.r0.a.h2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0424a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7149e;

            public C0424a(d dVar) {
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
                this.f7149e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f7149e.a();
                }
            }
        }

        public d(a aVar, c.a.r0.a.h2.c.j.b bVar, String str) {
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
            this.f7147f = bVar;
            this.f7148g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.h2.c.j.b bVar = this.f7147f;
                bVar.q(c.a.r0.a.n2.f.a(this.f7148g));
                bVar.o(new C0424a(this));
                this.f7147f.call();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends i<c.a.r0.a.z2.g1.c<ResulT>> {
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
                    super((a) objArr2[0], (C0422a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h2.a.i
        /* renamed from: b */
        public void a(c.a.r0.a.z2.g1.c<ResulT> cVar) {
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
        public final /* synthetic */ i f7150e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f7151f;

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
            this.f7150e = iVar;
            this.f7151f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7150e.a(this.f7151f);
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
                    super((a) objArr2[0], (C0422a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.r0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f7152f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.C0570d f7153g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f7154h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7155i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f7156j;

        /* renamed from: c.a.r0.a.h2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0425a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f7157e;

            public C0425a(h hVar) {
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
                this.f7157e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.h2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f7157e.a();
                }
            }
        }

        public h(a aVar, Activity activity, d.C0570d c0570d, Bundle bundle, String str, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0570d, bundle, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7152f = activity;
            this.f7153g = c0570d;
            this.f7154h = bundle;
            this.f7155i = str;
            this.f7156j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.h2.c.j.f b2 = c.a.r0.a.d2.d.J().y().a().b().b(this.f7152f, this.f7153g, this.f7154h);
                b2.q(this.f7155i);
                b2.o(this.f7156j);
                b2.o(new C0425a(this));
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

        public /* synthetic */ i(a aVar, C0422a c0422a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(426039558, "Lc/a/r0/a/h2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(426039558, "Lc/a/r0/a/h2/a;");
                return;
            }
        }
        f7131g = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.d2.e eVar) {
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
                super((c.a.r0.a.d2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7134d = new HashSet();
        this.f7135e = new HashMap();
        this.f7136f = new c.a.r0.a.z2.f1.c();
        this.f7132b = c.a.r0.a.o2.b.t(eVar);
        this.f7133c = "aiapp_setting_" + this.f7132b;
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
                this.f7134d.add(jVar);
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
            c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
            if (V == null) {
                c.a.r0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.r0.a.h.aiapps_open_fragment_failed_toast).G();
                return false;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(c.a.r0.a.h0.g.g.f6541g, c.a.r0.a.h0.g.g.f6543i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f7134d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), cVar}) == null) {
            d(context, str, z, true, false, cVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), cVar}) == null) {
            y(context, str, z, z2, z3, cVar);
        }
    }

    public void e(String str, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.f> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(cVar, null);
            } else {
                c.a.r0.a.p1.r.c.a.i(str, new b(this, cVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f7131g && c.a.r0.a.x1.a.a.m()) {
                return true;
            }
            c.a.r0.a.h2.c.f k = c.a.r0.a.p1.r.c.a.k(str);
            return (k == null || k.f7267d || !k.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, cVar) == null) {
            h(context, str, false, cVar);
        }
    }

    public void h(Context context, String str, boolean z, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), cVar}) == null) {
            e(str, new C0422a(this, cVar, str, z, context));
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
                this.f7135e.clear();
                this.f7136f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f7134d.clear();
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

    public final c.a.r0.a.o2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.r0.a.o2.g.g(this.f7133c, false);
            }
            return this.a;
        }
        return (c.a.r0.a.o2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f7133c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, d.C0570d c0570d, Bundle bundle, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<f.d>> cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0570d, bundle, cVar, str) == null) {
            this.f7136f.d(new h(this, activity, c0570d, bundle, str, cVar));
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.a.r0.a.h2.a */
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

    public final <ResulT> void u(c.a.r0.a.z2.g1.c<ResulT> cVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, cVar, result) == null) {
            s(cVar, new e(this, result));
        }
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                t(this.f7134d, new g(this));
            }
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), cVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            c.a.r0.a.h2.c.j.b bVar = this.f7135e.get(str2);
            if (bVar != null && TaskState.FINISHED != bVar.e()) {
                bVar.o(cVar);
                return;
            }
            c.a.r0.a.h2.c.j.b d2 = c.a.r0.a.d2.d.J().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f7135e.put(str2, d2);
            d2.o(cVar);
            d2.o(new c(this, str2));
            n.T(c.a.r0.a.n2.f.a(str), "requestModifyScope");
            this.f7136f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
