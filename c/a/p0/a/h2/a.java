package c.a.p0.a.h2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.h2.c.j.f;
import c.a.p0.a.k;
import c.a.p0.a.n2.n;
import c.a.p0.a.u.e.a.d;
import c.a.p0.a.z2.q0;
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
public class a extends c.a.p0.a.d2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f6098g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.o2.g.g a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6099b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6100c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f6101d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c.a.p0.a.h2.c.j.b> f6102e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.p0.a.z2.f1.c f6103f;

    /* renamed from: c.a.p0.a.h2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0320a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.g1.c f6104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f6106g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f6107h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f6108i;

        /* renamed from: c.a.p0.a.h2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0321a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0320a f6109e;

            public C0321a(C0320a c0320a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0320a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6109e = c0320a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0320a c0320a = this.f6109e;
                    c0320a.f6108i.u(c0320a.f6104e, iVar);
                }
            }
        }

        public C0320a(a aVar, c.a.p0.a.z2.g1.c cVar, String str, boolean z, Context context) {
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
            this.f6108i = aVar;
            this.f6104e = cVar;
            this.f6105f = str;
            this.f6106g = z;
            this.f6107h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [c.a.p0.a.h2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [c.a.p0.a.h2.c.j.b$e, ResultDataT] */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.p0.a.h2.c.i iVar = new c.a.p0.a.h2.c.i();
                if (a.f6098g && c.a.p0.a.x1.a.a.m()) {
                    iVar.e();
                    iVar.a = new b.e(true, null);
                    this.f6108i.u(this.f6104e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                c.a.p0.a.e0.d.k("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f6105f);
                if (!z2 && !fVar.f6237d) {
                    if (!this.f6106g ? fVar.f6243j == 0 : fVar.f6243j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f6108i.c(this.f6107h, this.f6105f, this.f6106g, new C0321a(this));
                        return;
                    }
                    if (fVar.f6243j > 0) {
                        iVar.e();
                        iVar.a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f6108i.u(this.f6104e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f6108i.u(this.f6104e, iVar);
                c.a.p0.a.e0.d.l("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                n.r(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.g1.c f6110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6111f;

        public b(a aVar, c.a.p0.a.z2.g1.c cVar) {
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
            this.f6111f = aVar;
            this.f6110e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f6111f.u(this.f6110e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6113f;

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
            this.f6113f = aVar;
            this.f6112e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f6113f.f6102e.remove(this.f6112e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.p0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h2.c.j.b f6114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6115g;

        /* renamed from: c.a.p0.a.h2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0322a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f6116e;

            public C0322a(d dVar) {
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
                this.f6116e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f6116e.a();
                }
            }
        }

        public d(a aVar, c.a.p0.a.h2.c.j.b bVar, String str) {
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
            this.f6114f = bVar;
            this.f6115g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h2.c.j.b bVar = this.f6114f;
                bVar.q(c.a.p0.a.n2.f.a(this.f6115g));
                bVar.o(new C0322a(this));
                this.f6114f.call();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends i<c.a.p0.a.z2.g1.c<ResulT>> {
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
                    super((a) objArr2[0], (C0320a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.h2.a.i
        /* renamed from: b */
        public void a(c.a.p0.a.z2.g1.c<ResulT> cVar) {
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
        public final /* synthetic */ i f6117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f6118f;

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
            this.f6117e = iVar;
            this.f6118f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6117e.a(this.f6118f);
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
                    super((a) objArr2[0], (C0320a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.h2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.p0.a.z2.f1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f6119f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.C0468d f6120g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f6121h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6122i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.g1.c f6123j;

        /* renamed from: c.a.p0.a.h2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0323a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f6124e;

            public C0323a(h hVar) {
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
                this.f6124e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.h2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f6124e.a();
                }
            }
        }

        public h(a aVar, Activity activity, d.C0468d c0468d, Bundle bundle, String str, c.a.p0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0468d, bundle, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6119f = activity;
            this.f6120g = c0468d;
            this.f6121h = bundle;
            this.f6122i = str;
            this.f6123j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h2.c.j.f b2 = c.a.p0.a.d2.d.J().y().a().b().b(this.f6119f, this.f6120g, this.f6121h);
                b2.q(this.f6122i);
                b2.o(this.f6123j);
                b2.o(new C0323a(this));
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

        public /* synthetic */ i(a aVar, C0320a c0320a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819066568, "Lc/a/p0/a/h2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(819066568, "Lc/a/p0/a/h2/a;");
                return;
            }
        }
        f6098g = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.d2.e eVar) {
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
                super((c.a.p0.a.d2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6101d = new HashSet();
        this.f6102e = new HashMap();
        this.f6103f = new c.a.p0.a.z2.f1.c();
        this.f6099b = c.a.p0.a.o2.b.t(eVar);
        this.f6100c = "aiapp_setting_" + this.f6099b;
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
                this.f6101d.add(jVar);
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
            c.a.p0.a.h0.g.g V = c.a.p0.a.g1.f.U().V();
            if (V == null) {
                c.a.p0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.p0.a.h.aiapps_open_fragment_failed_toast).G();
                return false;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(c.a.p0.a.h0.g.g.f5496g, c.a.p0.a.h0.g.g.f5498i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f6101d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), cVar}) == null) {
            d(context, str, z, true, false, cVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), cVar}) == null) {
            y(context, str, z, z2, z3, cVar);
        }
    }

    public void e(String str, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.f> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(cVar, null);
            } else {
                c.a.p0.a.p1.r.c.a.i(str, new b(this, cVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f6098g && c.a.p0.a.x1.a.a.m()) {
                return true;
            }
            c.a.p0.a.h2.c.f k2 = c.a.p0.a.p1.r.c.a.k(str);
            return (k2 == null || k2.f6237d || !k2.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, cVar) == null) {
            h(context, str, false, cVar);
        }
    }

    public void h(Context context, String str, boolean z, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), cVar}) == null) {
            e(str, new C0320a(this, cVar, str, z, context));
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
                this.f6102e.clear();
                this.f6103f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f6101d.clear();
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

    public final c.a.p0.a.o2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.p0.a.o2.g.g(this.f6100c, false);
            }
            return this.a;
        }
        return (c.a.p0.a.o2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f6100c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, d.C0468d c0468d, Bundle bundle, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<f.d>> cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0468d, bundle, cVar, str) == null) {
            this.f6103f.d(new h(this, activity, c0468d, bundle, str, cVar));
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.a.p0.a.h2.a */
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

    public final <ResulT> void u(c.a.p0.a.z2.g1.c<ResulT> cVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, cVar, result) == null) {
            s(cVar, new e(this, result));
        }
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                t(this.f6101d, new g(this));
            }
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), cVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            c.a.p0.a.h2.c.j.b bVar = this.f6102e.get(str2);
            if (bVar != null && TaskState.FINISHED != bVar.e()) {
                bVar.o(cVar);
                return;
            }
            c.a.p0.a.h2.c.j.b d2 = c.a.p0.a.d2.d.J().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f6102e.put(str2, d2);
            d2.o(cVar);
            d2.o(new c(this, str2));
            n.T(c.a.p0.a.n2.f.a(str), "requestModifyScope");
            this.f6103f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
