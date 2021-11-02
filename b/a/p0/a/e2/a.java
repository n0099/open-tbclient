package b.a.p0.a.e2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.e2.c.j.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.j2.k;
import b.a.p0.a.u.e.a.c;
import b.a.p0.a.v2.q0;
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
public class a extends b.a.p0.a.a2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f4772g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.k2.g.g f4773a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4774b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4775c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f4776d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, b.a.p0.a.e2.c.j.b> f4777e;

    /* renamed from: f  reason: collision with root package name */
    public final b.a.p0.a.v2.d1.c f4778f;

    /* renamed from: b.a.p0.a.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0158a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f4779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4780f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f4781g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f4782h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f4783i;

        /* renamed from: b.a.p0.a.e2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0159a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0158a f4784e;

            public C0159a(C0158a c0158a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0158a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4784e = c0158a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0158a c0158a = this.f4784e;
                    c0158a.f4783i.u(c0158a.f4779e, iVar);
                }
            }
        }

        public C0158a(a aVar, b.a.p0.a.v2.e1.b bVar, String str, boolean z, Context context) {
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
            this.f4783i = aVar;
            this.f4779e = bVar;
            this.f4780f = str;
            this.f4781g = z;
            this.f4782h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [ResultDataT, b.a.p0.a.e2.c.j.b$e] */
        /* JADX WARN: Type inference failed for: r8v6, types: [ResultDataT, b.a.p0.a.e2.c.j.b$e] */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                b.a.p0.a.e2.c.i iVar = new b.a.p0.a.e2.c.i();
                if (a.f4772g && b.a.p0.a.u1.a.a.m()) {
                    iVar.e();
                    iVar.f4946a = new b.e(true, null);
                    this.f4783i.u(this.f4779e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                b.a.p0.a.e0.d.h("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f4780f);
                if (!z2 && !fVar.f4907d) {
                    if (!this.f4781g ? fVar.j == 0 : fVar.j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f4783i.c(this.f4782h, this.f4780f, this.f4781g, new C0159a(this));
                        return;
                    }
                    if (fVar.j > 0) {
                        iVar.e();
                        iVar.f4946a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f4783i.u(this.f4779e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f4783i.u(this.f4779e, iVar);
                b.a.p0.a.e0.d.i("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                k.p(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f4785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4786f;

        public b(a aVar, b.a.p0.a.v2.e1.b bVar) {
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
            this.f4786f = aVar;
            this.f4785e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f4786f.u(this.f4785e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4788f;

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
            this.f4788f = aVar;
            this.f4787e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f4788f.f4777e.remove(this.f4787e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.p0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.j.b f4789f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4790g;

        /* renamed from: b.a.p0.a.e2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0160a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f4791e;

            public C0160a(d dVar) {
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
                this.f4791e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f4791e.a();
                }
            }
        }

        public d(a aVar, b.a.p0.a.e2.c.j.b bVar, String str) {
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
            this.f4789f = bVar;
            this.f4790g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e2.c.j.b bVar = this.f4789f;
                bVar.q(b.a.p0.a.j2.f.a(this.f4790g));
                bVar.o(new C0160a(this));
                this.f4789f.call();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends i<b.a.p0.a.v2.e1.b<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f4792a;

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
                    super((a) objArr2[0], (C0158a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4792a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.e2.a.i
        /* renamed from: b */
        public void a(b.a.p0.a.v2.e1.b<ResulT> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                bVar.onCallback(this.f4792a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f4793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f4794f;

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
            this.f4793e = iVar;
            this.f4794f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4793e.a(this.f4794f);
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
                    super((a) objArr2[0], (C0158a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.e2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends b.a.p0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f4795f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.C0379c f4796g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f4797h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4798i;
        public final /* synthetic */ b.a.p0.a.v2.e1.b j;

        /* renamed from: b.a.p0.a.e2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0161a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f4799e;

            public C0161a(h hVar) {
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
                this.f4799e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(b.a.p0.a.e2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f4799e.a();
                }
            }
        }

        public h(a aVar, Activity activity, c.C0379c c0379c, Bundle bundle, String str, b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0379c, bundle, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4795f = activity;
            this.f4796g = c0379c;
            this.f4797h = bundle;
            this.f4798i = str;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e2.c.j.f b2 = b.a.p0.a.a2.d.g().y().a().b().b(this.f4795f, this.f4796g, this.f4797h);
                b2.q(this.f4798i);
                b2.o(this.j);
                b2.o(new C0161a(this));
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

        public /* synthetic */ i(a aVar, C0158a c0158a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1321854630, "Lb/a/p0/a/e2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1321854630, "Lb/a/p0/a/e2/a;");
                return;
            }
        }
        f4772g = b.a.p0.a.k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.a2.e eVar) {
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
                super((b.a.p0.a.a2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4776d = new HashSet();
        this.f4777e = new HashMap();
        this.f4778f = new b.a.p0.a.v2.d1.c();
        this.f4774b = b.a.p0.a.k2.b.t(eVar);
        this.f4775c = "aiapp_setting_" + this.f4774b;
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            if (b.a.p0.a.r1.l.e.g()) {
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
                this.f4776d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f4773a.remove(str);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                b.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), b.a.p0.a.h.aiapps_open_fragment_failed_toast).F();
                return false;
            }
            g.b i2 = U.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5280g, b.a.p0.a.h0.g.g.f5282i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f4776d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            d(context, str, z, true, false, bVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            y(context, str, z, z2, z3, bVar);
        }
    }

    public void e(String str, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(bVar, null);
            } else {
                b.a.p0.a.n1.q.c.a.i(str, new b(this, bVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f4772g && b.a.p0.a.u1.a.a.m()) {
                return true;
            }
            b.a.p0.a.e2.c.f k = b.a.p0.a.n1.q.c.a.k(str);
            return (k == null || k.f4907d || !k.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, bVar) == null) {
            h(context, str, false, bVar);
        }
    }

    public void h(Context context, String str, boolean z, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            e(str, new C0158a(this, bVar, str, z, context));
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
                this.f4777e.clear();
                this.f4778f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f4776d.clear();
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

    public final b.a.p0.a.k2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f4773a == null) {
                this.f4773a = new b.a.p0.a.k2.g.g(this.f4775c, false);
            }
            return this.f4773a;
        }
        return (b.a.p0.a.k2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f4775c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, c.C0379c c0379c, Bundle bundle, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<f.d>> bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0379c, bundle, bVar, str) == null) {
            this.f4778f.d(new h(this, activity, c0379c, bundle, str, bVar));
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

    public final <ResulT> void u(b.a.p0.a.v2.e1.b<ResulT> bVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, result) == null) {
            s(bVar, new e(this, result));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            t(this.f4776d, new g(this));
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            b.a.p0.a.e2.c.j.b bVar2 = this.f4777e.get(str2);
            if (bVar2 != null && TaskState.FINISHED != bVar2.e()) {
                bVar2.o(bVar);
                return;
            }
            b.a.p0.a.e2.c.j.b d2 = b.a.p0.a.a2.d.g().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f4777e.put(str2, d2);
            d2.o(bVar);
            d2.o(new c(this, str2));
            k.N(b.a.p0.a.j2.f.a(str), "requestModifyScope");
            this.f4778f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
