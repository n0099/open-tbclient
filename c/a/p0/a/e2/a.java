package c.a.p0.a.e2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.e2.c.j.f;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.j2.k;
import c.a.p0.a.u.e.a.c;
import c.a.p0.a.v2.q0;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends c.a.p0.a.a2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5400g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.k2.g.g f5401a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5402b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5403c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f5404d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c.a.p0.a.e2.c.j.b> f5405e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.p0.a.v2.d1.c f5406f;

    /* renamed from: c.a.p0.a.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0163a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f5407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f5409g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f5410h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f5411i;

        /* renamed from: c.a.p0.a.e2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0164a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0163a f5412e;

            public C0164a(C0163a c0163a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0163a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5412e = c0163a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0163a c0163a = this.f5412e;
                    c0163a.f5411i.u(c0163a.f5407e, iVar);
                }
            }
        }

        public C0163a(a aVar, c.a.p0.a.v2.e1.b bVar, String str, boolean z, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str, Boolean.valueOf(z), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5411i = aVar;
            this.f5407e = bVar;
            this.f5408f = str;
            this.f5409g = z;
            this.f5410h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [c.a.p0.a.e2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [c.a.p0.a.e2.c.j.b$e, ResultDataT] */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.p0.a.e2.c.i iVar = new c.a.p0.a.e2.c.i();
                if (a.f5400g && c.a.p0.a.u1.a.a.m()) {
                    iVar.e();
                    iVar.f5582a = new b.e(true, null);
                    this.f5411i.u(this.f5407e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                c.a.p0.a.e0.d.h("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f5408f);
                if (!z2 && !fVar.f5541d) {
                    if (!this.f5409g ? fVar.f5547j == 0 : fVar.f5547j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f5411i.c(this.f5410h, this.f5408f, this.f5409g, new C0164a(this));
                        return;
                    }
                    if (fVar.f5547j > 0) {
                        iVar.e();
                        iVar.f5582a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f5411i.u(this.f5407e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f5411i.u(this.f5407e, iVar);
                c.a.p0.a.e0.d.i("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                k.p(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f5413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5414f;

        public b(a aVar, c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5414f = aVar;
            this.f5413e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f5414f.u(this.f5413e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5416f;

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
            this.f5416f = aVar;
            this.f5415e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f5416f.f5405e.remove(this.f5415e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.p0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.e2.c.j.b f5417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5418g;

        /* renamed from: c.a.p0.a.e2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0165a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5419e;

            public C0165a(d dVar) {
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
                this.f5419e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f5419e.a();
                }
            }
        }

        public d(a aVar, c.a.p0.a.e2.c.j.b bVar, String str) {
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
            this.f5417f = bVar;
            this.f5418g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.e2.c.j.b bVar = this.f5417f;
                bVar.r(c.a.p0.a.j2.f.a(this.f5418g));
                bVar.p(new C0165a(this));
                this.f5417f.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends i<c.a.p0.a.v2.e1.b<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f5420a;

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
                    super((a) objArr2[0], (C0163a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5420a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.e2.a.i
        /* renamed from: b */
        public void a(c.a.p0.a.v2.e1.b<ResulT> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                bVar.onCallback(this.f5420a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f5421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f5422f;

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
            this.f5421e = iVar;
            this.f5422f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5421e.a(this.f5422f);
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
                    super((a) objArr2[0], (C0163a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.e2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.p0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f5423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.C0384c f5424g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f5425h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5426i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f5427j;

        /* renamed from: c.a.p0.a.e2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0166a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f5428e;

            public C0166a(h hVar) {
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
                this.f5428e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(c.a.p0.a.e2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f5428e.a();
                }
            }
        }

        public h(a aVar, Activity activity, c.C0384c c0384c, Bundle bundle, String str, c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0384c, bundle, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5423f = activity;
            this.f5424g = c0384c;
            this.f5425h = bundle;
            this.f5426i = str;
            this.f5427j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.e2.c.j.f b2 = c.a.p0.a.a2.d.g().y().a().b().b(this.f5423f, this.f5424g, this.f5425h);
                b2.r(this.f5426i);
                b2.p(this.f5427j);
                b2.p(new C0166a(this));
                b2.a();
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

        public /* synthetic */ i(a aVar, C0163a c0163a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(816296005, "Lc/a/p0/a/e2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(816296005, "Lc/a/p0/a/e2/a;");
                return;
            }
        }
        f5400g = c.a.p0.a.k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.a2.e eVar) {
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
                super((c.a.p0.a.a2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5404d = new HashSet();
        this.f5405e = new HashMap();
        this.f5406f = new c.a.p0.a.v2.d1.c();
        this.f5402b = c.a.p0.a.k2.b.t(eVar);
        this.f5403c = "aiapp_setting_" + this.f5402b;
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            if (c.a.p0.a.r1.l.e.g()) {
                q0.b0(runnable);
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
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
                this.f5404d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f5401a.remove(str);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                c.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), c.a.p0.a.h.aiapps_open_fragment_failed_toast).F();
                return false;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(c.a.p0.a.h0.g.g.f5928g, c.a.p0.a.h0.g.g.f5930i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f5404d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            d(context, str, z, true, false, bVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            y(context, str, z, z2, z3, bVar);
        }
    }

    public void e(String str, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(bVar, null);
            } else {
                c.a.p0.a.n1.q.c.a.i(str, new b(this, bVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f5400g && c.a.p0.a.u1.a.a.m()) {
                return true;
            }
            c.a.p0.a.e2.c.f k = c.a.p0.a.n1.q.c.a.k(str);
            return (k == null || k.f5541d || !k.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, bVar) == null) {
            h(context, str, false, bVar);
        }
    }

    public void h(Context context, String str, boolean z, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            e(str, new C0163a(this, bVar, str, z, context));
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
                this.f5405e.clear();
                this.f5406f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f5404d.clear();
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

    public final c.a.p0.a.k2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f5401a == null) {
                this.f5401a = new c.a.p0.a.k2.g.g(this.f5403c, false);
            }
            return this.f5401a;
        }
        return (c.a.p0.a.k2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f5403c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, c.C0384c c0384c, Bundle bundle, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<f.d>> bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0384c, bundle, bVar, str) == null) {
            this.f5406f.d(new h(this, activity, c0384c, bundle, str, bVar));
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

    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, collection, iVar) == null) {
            synchronized (this) {
                for (CallBackT callbackt : collection) {
                    s(callbackt, iVar);
                }
            }
        }
    }

    public final <ResulT> void u(c.a.p0.a.v2.e1.b<ResulT> bVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, result) == null) {
            s(bVar, new e(this, result));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            t(this.f5404d, new g(this));
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            c.a.p0.a.e2.c.j.b bVar2 = this.f5405e.get(str2);
            if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
                bVar2.p(bVar);
                return;
            }
            c.a.p0.a.e2.c.j.b d2 = c.a.p0.a.a2.d.g().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f5405e.put(str2, d2);
            d2.p(bVar);
            d2.p(new c(this, str2));
            k.N(c.a.p0.a.j2.f.a(str), "requestModifyScope");
            this.f5406f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
