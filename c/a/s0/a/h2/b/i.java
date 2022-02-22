package c.a.s0.a.h2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f2.f.z;
import c.a.s0.a.h2.b.j;
import c.a.s0.a.h2.c.j.b;
import c.a.s0.a.n2.n;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7298g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.d2.e f7299h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7300i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f7301j;

        public a(i iVar, CallbackHandler callbackHandler, String str, Context context, c.a.s0.a.d2.e eVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str, context, eVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7301j = iVar;
            this.f7296e = callbackHandler;
            this.f7297f = str;
            this.f7298g = context;
            this.f7299h = eVar;
            this.f7300i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.s0.a.h2.c.d.h(iVar)) {
                    this.f7301j.x((Activity) this.f7298g, this.f7299h, this.f7296e, this.f7300i, this.f7297f);
                    return;
                }
                j.b d2 = c.a.s0.a.h2.b.j.d();
                d2.n(false);
                d2.o();
                c.a.s0.a.h2.c.d.q(iVar, this.f7296e, this.f7297f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.p1.r.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7302b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7303c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.d2.e f7304d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f7306f;

        /* loaded from: classes.dex */
        public class a implements c.a.s0.a.z2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.h2.c.f f7307e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f7308f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f7309g;

            /* renamed from: c.a.s0.a.h2.b.i$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0438a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f7310e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f7311f;

                public RunnableC0438a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7311f = aVar;
                    this.f7310e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f7311f;
                        i iVar = aVar.f7309g.f7306f;
                        c.a.s0.a.h2.c.f fVar = aVar.f7307e;
                        List list = aVar.f7308f;
                        boolean booleanValue = this.f7310e.booleanValue();
                        b bVar = this.f7311f.f7309g;
                        iVar.P(fVar, list, booleanValue, bVar.f7305e, bVar.f7304d, bVar.a, bVar.f7302b);
                    }
                }
            }

            public a(b bVar, c.a.s0.a.h2.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7309g = bVar;
                this.f7307e = fVar;
                this.f7308f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f7309g;
                    bVar.f7306f.O(bVar.f7305e, this.f7307e, bool);
                    q0.a0(new RunnableC0438a(this, bool));
                }
            }
        }

        /* renamed from: c.a.s0.a.h2.b.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0439b implements c.a.s0.a.z2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.h2.c.f f7312e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f7313f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f7314g;

            /* renamed from: c.a.s0.a.h2.b.i$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0439b f7315e;

                public a(C0439b c0439b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0439b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7315e = c0439b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0439b c0439b = this.f7315e;
                        b bVar = c0439b.f7314g;
                        bVar.f7306f.P(c0439b.f7312e, c0439b.f7313f, false, bVar.f7305e, bVar.f7304d, bVar.a, bVar.f7302b);
                    }
                }
            }

            public C0439b(b bVar, c.a.s0.a.h2.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7314g = bVar;
                this.f7312e = fVar;
                this.f7313f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f7314g;
                    bVar.f7306f.N(bVar.f7305e, this.f7312e, str);
                    q0.a0(new a(this));
                }
            }
        }

        public b(i iVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, c.a.s0.a.d2.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str, jSONArray, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7306f = iVar;
            this.a = callbackHandler;
            this.f7302b = str;
            this.f7303c = jSONArray;
            this.f7304d = eVar;
            this.f7305e = activity;
        }

        @Override // c.a.s0.a.p1.r.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, c.a.s0.a.h2.c.f> g2 = c.a.s0.a.p1.r.c.a.g(true);
                c.a.s0.a.h2.c.f y = this.f7306f.y(g2, this.a, this.f7302b);
                if (y != null) {
                    List<c.a.s0.a.h2.c.f> w = this.f7306f.w(g2, this.f7303c, this.a, this.f7302b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.f7304d.M().e(this.f7305e)) {
                        this.f7306f.z(new C0439b(this, y, w));
                        return;
                    } else {
                        c.a.s0.a.c1.a.Z().a(this.f7305e, new a(this, y, w));
                        return;
                    }
                }
                j.b d2 = c.a.s0.a.h2.b.j.d();
                d2.n(false);
                d2.o();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.s0.a.h2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7316b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f7317c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.d2.e f7318d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f7320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f7321g;

        public c(i iVar, CallbackHandler callbackHandler, String str, boolean z, c.a.s0.a.d2.e eVar, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str, Boolean.valueOf(z), eVar, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7321g = iVar;
            this.a = callbackHandler;
            this.f7316b = str;
            this.f7317c = z;
            this.f7318d = eVar;
            this.f7319e = activity;
            this.f7320f = list;
        }

        @Override // c.a.s0.a.h2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.s0.a.e0.d.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    j.b d2 = c.a.s0.a.h2.b.j.d();
                    d2.i(false);
                    d2.h(false);
                    d2.o();
                    c.a.s0.a.h2.c.d.o(10003, this.a, this.f7316b);
                    return;
                }
                j.b d3 = c.a.s0.a.h2.b.j.d();
                d3.i(true);
                d3.h(true);
                boolean z2 = this.f7317c;
                if (this.f7318d.M().e(this.f7319e)) {
                    c.a.s0.a.h2.b.j.d().m(true);
                    this.f7321g.H(this.f7320f, this.f7319e, this.a, this.f7316b);
                } else if (z2) {
                    this.f7321g.K(this.f7320f, this.f7319e, this.a, this.f7316b);
                } else {
                    c.a.s0.a.h2.b.j.d().m(false);
                    this.f7321g.G(this.f7320f, this.f7319e, this.a, this.f7316b, this.f7318d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f7322b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7323c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7324d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f7325e;

        public d(i iVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7325e = iVar;
            this.a = list;
            this.f7322b = activity;
            this.f7323c = callbackHandler;
            this.f7324d = str;
        }

        @Override // c.a.s0.a.h2.b.i.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                c.a.s0.a.e0.d.i("MultiAuthorize", "login result:" + i2);
                if (z) {
                    c.a.s0.a.h2.b.j.d().k(true);
                    this.f7325e.H(this.a, this.f7322b, this.f7323c, this.f7324d);
                    return;
                }
                j.b d2 = c.a.s0.a.h2.b.j.d();
                d2.k(false);
                d2.n(true);
                d2.i(false);
                d2.o();
                c.a.s0.a.h2.c.d.o(10004, this.f7323c, this.f7324d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.s0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f7326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f7327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7328g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7329h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f7330i;

        public e(i iVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7330i = iVar;
            this.f7326e = list;
            this.f7327f = activity;
            this.f7328g = callbackHandler;
            this.f7329h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7330i.I(TextUtils.equals(str, "1"), this.f7326e, this.f7327f, this.f7328g, this.f7329h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.s0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f7332f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7333g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7334h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f7335i;

        public f(i iVar, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7335i = iVar;
            this.f7331e = activity;
            this.f7332f = list;
            this.f7333g = callbackHandler;
            this.f7334h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    j.b d2 = c.a.s0.a.h2.b.j.d();
                    d2.j(true);
                    d2.i(true);
                    this.f7335i.J(this.f7331e, this.f7332f, this.f7333g, this.f7334h);
                    return;
                }
                j.b d3 = c.a.s0.a.h2.b.j.d();
                d3.j(false);
                d3.i(false);
                d3.o();
                c.a.s0.a.h2.c.d.o(10003, this.f7333g, this.f7334h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.s0.a.z2.g1.c<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f7336e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f7337f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7338g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7339h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f7340i;

        public g(i iVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7340i = iVar;
            this.f7336e = list;
            this.f7337f = activity;
            this.f7338g = callbackHandler;
            this.f7339h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    c.a.s0.a.h2.b.j.d().m(true);
                    this.f7340i.H(this.f7336e, this.f7337f, this.f7338g, this.f7339h);
                    return;
                }
                j.b d2 = c.a.s0.a.h2.b.j.d();
                d2.m(false);
                d2.n(false);
                d2.o();
                c.a.s0.a.h2.c.d.o(10003, this.f7338g, this.f7339h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7342f;

        public h(i iVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7341e = callbackHandler;
            this.f7342f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    c.a.s0.a.h2.c.d.o(10001, this.f7341e, this.f7342f);
                    j.b d2 = c.a.s0.a.h2.b.j.d();
                    d2.n(false);
                    d2.o();
                    n.r(10001, null);
                    return;
                }
                int b2 = iVar.b();
                c.a.s0.a.e0.d.o("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.a);
                if (b2 != 0) {
                    j.b d3 = c.a.s0.a.h2.b.j.d();
                    d3.n(false);
                    d3.o();
                    c.a.s0.a.h2.c.d.o(b2, this.f7341e, this.f7342f);
                    return;
                }
                j.b d4 = c.a.s0.a.h2.b.j.d();
                d4.n(true);
                d4.o();
                this.f7341e.handleSchemeDispatchCallback(this.f7342f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* renamed from: c.a.s0.a.h2.b.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0440i implements c.a.s0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f7343e;

        public C0440i(i iVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7343e = jVar;
        }

        @Override // c.a.s0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f7343e.a(false, i2);
                } else {
                    this.f7343e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.s0.a.f2.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<c.a.s0.a.h2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (c.a.s0.a.h2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(c.a.s0.a.h2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f7365b, "mapp_location") || TextUtils.equals(fVar.f7365b, "mapp_images") || TextUtils.equals(fVar.f7365b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f7365b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f7365b, "ppcert") || TextUtils.equals(fVar.f7365b, "mapp_i_face_verify") || TextUtils.equals(fVar.f7365b, "snsapi_userinfo") || TextUtils.equals(fVar.f7365b, "mapp_choose_address") || TextUtils.equals(fVar.f7365b, "mobile") || TextUtils.equals(fVar.f7365b, "mapp_choose_invoice") || TextUtils.equals(fVar.f7365b, "mapp_i_read_contacts") || TextUtils.equals(fVar.f7365b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(c.a.s0.a.h2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f7365b, "ppcert") || TextUtils.equals(fVar.f7365b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<c.a.s0.a.h2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (c.a.s0.a.h2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(c.a.s0.a.h2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f7365b, "mapp_location") || TextUtils.equals(fVar.f7365b, "mapp_images") || TextUtils.equals(fVar.f7365b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f7365b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f7365b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<c.a.s0.a.h2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (c.a.s0.a.h2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<c.a.s0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.s0.a.d2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                c.a.s0.a.h2.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(eVar, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<c.a.s0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                c.a.s0.a.h2.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<c.a.s0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                j.b d2 = c.a.s0.a.h2.b.j.d();
                d2.l(true);
                d2.i(true);
                c.a.s0.a.e0.d.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            c.a.s0.a.h2.b.j.d().l(false);
            c.a.s0.a.e0.d.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<c.a.s0.a.h2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f7365b;
            }
            c.a.s0.a.h2.c.j.b d2 = c.a.s0.a.d2.d.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<c.a.s0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            c.a.s0.a.c1.a.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull c.a.s0.a.d2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(c.a.s0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            c.a.s0.a.c1.a.Z().b(false, cVar);
        }
    }

    public final void N(@NonNull Activity activity, c.a.s0.a.h2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String Y = c.a.s0.a.d2.d.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_head) + Y + activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_head) + Y + activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(c.a.s0.a.h.swanapp_multi_auth_un_realname_name_head) + Y + activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, c.a.s0.a.h2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String Y = c.a.s0.a.d2.d.J().r().Y();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(c.a.s0.a.h.swanapp_multi_auth_guest_login_name_head) + Y + activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(c.a.s0.a.h.swanapp_multi_auth_un_realname_name_head) + Y + activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_head) + Y + activity.getString(c.a.s0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(c.a.s0.a.h2.c.f fVar, List<c.a.s0.a.h2.c.f> list, boolean z, @NonNull Activity activity, @NonNull c.a.s0.a.d2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            c.a.s0.a.h2.c.d.u(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // c.a.s0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        c.a.s0.a.h2.b.j.d().n(true);
                        eVar.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    j.b d2 = c.a.s0.a.h2.b.j.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                j.b d3 = c.a.s0.a.h2.b.j.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            j.b d4 = c.a.s0.a.h2.b.j.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull c.a.s0.a.d2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.M().f(activity, null, new C0440i(this, jVar));
        }
    }

    public final List<c.a.s0.a.h2.c.f> w(Map<String, c.a.s0.a.h2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = c.a.s0.a.h2.c.f.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    c.a.s0.a.h2.c.f fVar = map.get(c2);
                    if (map.containsKey(c2) && fVar != null && B(fVar)) {
                        if (fVar.f7367d) {
                            c.a.s0.a.h2.c.d.o(10005, callbackHandler, str);
                            j.b d2 = c.a.s0.a.h2.b.j.d();
                            d2.n(false);
                            d2.o();
                            n.r(10005, fVar);
                            return null;
                        }
                        if (!arrayList.contains(fVar) && !fVar.a()) {
                            arrayList.add(fVar);
                        }
                        if (!fVar.a()) {
                            z = false;
                        }
                    } else {
                        c.a.s0.a.h2.c.d.o(10005, callbackHandler, str);
                        j.b d3 = c.a.s0.a.h2.b.j.d();
                        d3.n(false);
                        d3.o();
                        n.r(10005, fVar);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                j.b d4 = c.a.s0.a.h2.b.j.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            c.a.s0.a.e0.d.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                j.b d5 = c.a.s0.a.h2.b.j.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull c.a.s0.a.d2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            c.a.s0.a.p1.r.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final c.a.s0.a.h2.c.f y(Map<String, c.a.s0.a.h2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            c.a.s0.a.h2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                c.a.s0.a.h2.c.d.o(10001, callbackHandler, str);
                n.r(10001, null);
                return null;
            } else if (fVar.f7367d) {
                c.a.s0.a.h2.c.d.o(10005, callbackHandler, str);
                n.r(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (c.a.s0.a.h2.c.f) invokeLLL.objValue;
    }

    public final void z(c.a.s0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            c.a.s0.a.c1.a.Z().c(c.a.s0.a.c1.a.c(), cVar);
        }
    }
}
