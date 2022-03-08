package c.a.p0.a.x1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.p2.q0;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x1.b.j;
import c.a.p0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.R;
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
    public class a implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9031g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9032h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f9033i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f9034j;

        public a(i iVar, CallbackHandler callbackHandler, String str, Context context, c.a.p0.a.t1.e eVar, JSONArray jSONArray) {
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
            this.f9034j = iVar;
            this.f9029e = callbackHandler;
            this.f9030f = str;
            this.f9031g = context;
            this.f9032h = eVar;
            this.f9033i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f9034j.x((Activity) this.f9031g, this.f9032h, this.f9029e, this.f9033i, this.f9030f);
                    return;
                }
                j.b d2 = c.a.p0.a.x1.b.j.d();
                d2.n(false);
                d2.o();
                c.a.p0.a.x1.c.d.q(iVar, this.f9029e, this.f9030f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.f1.r.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9035b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f9036c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9037d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9038e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f9039f;

        /* loaded from: classes.dex */
        public class a implements c.a.p0.a.p2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.x1.c.f f9040e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f9041f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f9042g;

            /* renamed from: c.a.p0.a.x1.b.i$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0592a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f9043e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f9044f;

                public RunnableC0592a(a aVar, Boolean bool) {
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
                    this.f9044f = aVar;
                    this.f9043e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f9044f;
                        i iVar = aVar.f9042g.f9039f;
                        c.a.p0.a.x1.c.f fVar = aVar.f9040e;
                        List list = aVar.f9041f;
                        boolean booleanValue = this.f9043e.booleanValue();
                        b bVar = this.f9044f.f9042g;
                        iVar.P(fVar, list, booleanValue, bVar.f9038e, bVar.f9037d, bVar.a, bVar.f9035b);
                    }
                }
            }

            public a(b bVar, c.a.p0.a.x1.c.f fVar, List list) {
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
                this.f9042g = bVar;
                this.f9040e = fVar;
                this.f9041f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f9042g;
                    bVar.f9039f.O(bVar.f9038e, this.f9040e, bool);
                    q0.a0(new RunnableC0592a(this, bool));
                }
            }
        }

        /* renamed from: c.a.p0.a.x1.b.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0593b implements c.a.p0.a.p2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.x1.c.f f9045e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f9046f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f9047g;

            /* renamed from: c.a.p0.a.x1.b.i$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0593b f9048e;

                public a(C0593b c0593b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0593b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9048e = c0593b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0593b c0593b = this.f9048e;
                        b bVar = c0593b.f9047g;
                        bVar.f9039f.P(c0593b.f9045e, c0593b.f9046f, false, bVar.f9038e, bVar.f9037d, bVar.a, bVar.f9035b);
                    }
                }
            }

            public C0593b(b bVar, c.a.p0.a.x1.c.f fVar, List list) {
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
                this.f9047g = bVar;
                this.f9045e = fVar;
                this.f9046f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f9047g;
                    bVar.f9039f.N(bVar.f9038e, this.f9045e, str);
                    q0.a0(new a(this));
                }
            }
        }

        public b(i iVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, c.a.p0.a.t1.e eVar, Activity activity) {
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
            this.f9039f = iVar;
            this.a = callbackHandler;
            this.f9035b = str;
            this.f9036c = jSONArray;
            this.f9037d = eVar;
            this.f9038e = activity;
        }

        @Override // c.a.p0.a.f1.r.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, c.a.p0.a.x1.c.f> g2 = c.a.p0.a.f1.r.c.a.g(true);
                c.a.p0.a.x1.c.f y = this.f9039f.y(g2, this.a, this.f9035b);
                if (y != null) {
                    List<c.a.p0.a.x1.c.f> w = this.f9039f.w(g2, this.f9036c, this.a, this.f9035b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.f9037d.M().e(this.f9038e)) {
                        this.f9039f.z(new C0593b(this, y, w));
                        return;
                    } else {
                        c.a.p0.a.s0.a.Z().a(this.f9038e, new a(this, y, w));
                        return;
                    }
                }
                j.b d2 = c.a.p0.a.x1.b.j.d();
                d2.n(false);
                d2.o();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.x1.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9049b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f9050c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9051d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9052e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f9053f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f9054g;

        public c(i iVar, CallbackHandler callbackHandler, String str, boolean z, c.a.p0.a.t1.e eVar, Activity activity, List list) {
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
            this.f9054g = iVar;
            this.a = callbackHandler;
            this.f9049b = str;
            this.f9050c = z;
            this.f9051d = eVar;
            this.f9052e = activity;
            this.f9053f = list;
        }

        @Override // c.a.p0.a.x1.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.p0.a.u.d.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    j.b d2 = c.a.p0.a.x1.b.j.d();
                    d2.i(false);
                    d2.h(false);
                    d2.o();
                    c.a.p0.a.x1.c.d.o(10003, this.a, this.f9049b);
                    return;
                }
                j.b d3 = c.a.p0.a.x1.b.j.d();
                d3.i(true);
                d3.h(true);
                boolean z2 = this.f9050c;
                if (this.f9051d.M().e(this.f9052e)) {
                    c.a.p0.a.x1.b.j.d().m(true);
                    this.f9054g.H(this.f9053f, this.f9052e, this.a, this.f9049b);
                } else if (z2) {
                    this.f9054g.K(this.f9053f, this.f9052e, this.a, this.f9049b);
                } else {
                    c.a.p0.a.x1.b.j.d().m(false);
                    this.f9054g.G(this.f9053f, this.f9052e, this.a, this.f9049b, this.f9051d);
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
        public final /* synthetic */ Activity f9055b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9056c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f9057d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f9058e;

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
            this.f9058e = iVar;
            this.a = list;
            this.f9055b = activity;
            this.f9056c = callbackHandler;
            this.f9057d = str;
        }

        @Override // c.a.p0.a.x1.b.i.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                c.a.p0.a.u.d.i("MultiAuthorize", "login result:" + i2);
                if (z) {
                    c.a.p0.a.x1.b.j.d().k(true);
                    this.f9058e.H(this.a, this.f9055b, this.f9056c, this.f9057d);
                    return;
                }
                j.b d2 = c.a.p0.a.x1.b.j.d();
                d2.k(false);
                d2.n(true);
                d2.i(false);
                d2.o();
                c.a.p0.a.x1.c.d.o(10004, this.f9056c, this.f9057d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f9059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f9060f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9061g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9062h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f9063i;

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
            this.f9063i = iVar;
            this.f9059e = list;
            this.f9060f = activity;
            this.f9061g = callbackHandler;
            this.f9062h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9063i.I(TextUtils.equals(str, "1"), this.f9059e, this.f9060f, this.f9061g, this.f9062h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f9065f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9066g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9067h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f9068i;

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
            this.f9068i = iVar;
            this.f9064e = activity;
            this.f9065f = list;
            this.f9066g = callbackHandler;
            this.f9067h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    j.b d2 = c.a.p0.a.x1.b.j.d();
                    d2.j(true);
                    d2.i(true);
                    this.f9068i.J(this.f9064e, this.f9065f, this.f9066g, this.f9067h);
                    return;
                }
                j.b d3 = c.a.p0.a.x1.b.j.d();
                d3.j(false);
                d3.i(false);
                d3.o();
                c.a.p0.a.x1.c.d.o(10003, this.f9066g, this.f9067h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.p2.g1.c<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f9069e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f9070f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9071g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9072h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f9073i;

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
            this.f9073i = iVar;
            this.f9069e = list;
            this.f9070f = activity;
            this.f9071g = callbackHandler;
            this.f9072h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    c.a.p0.a.x1.b.j.d().m(true);
                    this.f9073i.H(this.f9069e, this.f9070f, this.f9071g, this.f9072h);
                    return;
                }
                j.b d2 = c.a.p0.a.x1.b.j.d();
                d2.m(false);
                d2.n(false);
                d2.o();
                c.a.p0.a.x1.c.d.o(10003, this.f9071g, this.f9072h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9075f;

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
            this.f9074e = callbackHandler;
            this.f9075f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    c.a.p0.a.x1.c.d.o(10001, this.f9074e, this.f9075f);
                    j.b d2 = c.a.p0.a.x1.b.j.d();
                    d2.n(false);
                    d2.o();
                    n.r(10001, null);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.u.d.o("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.a);
                if (b2 != 0) {
                    j.b d3 = c.a.p0.a.x1.b.j.d();
                    d3.n(false);
                    d3.o();
                    c.a.p0.a.x1.c.d.o(b2, this.f9074e, this.f9075f);
                    return;
                }
                j.b d4 = c.a.p0.a.x1.b.j.d();
                d4.n(true);
                d4.o();
                this.f9074e.handleSchemeDispatchCallback(this.f9075f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* renamed from: c.a.p0.a.x1.b.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0594i implements c.a.p0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f9076e;

        public C0594i(i iVar, j jVar) {
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
            this.f9076e = jVar;
        }

        @Override // c.a.p0.a.c.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f9076e.a(false, i2);
                } else {
                    this.f9076e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.p0.a.v1.e eVar) {
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

    public final boolean A(List<c.a.p0.a.x1.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (c.a.p0.a.x1.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(c.a.p0.a.x1.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f9098b, "mapp_location") || TextUtils.equals(fVar.f9098b, "mapp_images") || TextUtils.equals(fVar.f9098b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f9098b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f9098b, "ppcert") || TextUtils.equals(fVar.f9098b, "mapp_i_face_verify") || TextUtils.equals(fVar.f9098b, "snsapi_userinfo") || TextUtils.equals(fVar.f9098b, "mapp_choose_address") || TextUtils.equals(fVar.f9098b, "mobile") || TextUtils.equals(fVar.f9098b, "mapp_choose_invoice") || TextUtils.equals(fVar.f9098b, "mapp_i_read_contacts") || TextUtils.equals(fVar.f9098b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(c.a.p0.a.x1.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f9098b, "ppcert") || TextUtils.equals(fVar.f9098b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<c.a.p0.a.x1.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (c.a.p0.a.x1.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(c.a.p0.a.x1.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f9098b, "mapp_location") || TextUtils.equals(fVar.f9098b, "mapp_images") || TextUtils.equals(fVar.f9098b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f9098b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f9098b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<c.a.p0.a.x1.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (c.a.p0.a.x1.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<c.a.p0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.p0.a.t1.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                c.a.p0.a.x1.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(eVar, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<c.a.p0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                c.a.p0.a.x1.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<c.a.p0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                j.b d2 = c.a.p0.a.x1.b.j.d();
                d2.l(true);
                d2.i(true);
                c.a.p0.a.u.d.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            c.a.p0.a.x1.b.j.d().l(false);
            c.a.p0.a.u.d.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<c.a.p0.a.x1.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f9098b;
            }
            c.a.p0.a.x1.c.j.b d2 = c.a.p0.a.t1.d.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<c.a.p0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            c.a.p0.a.s0.a.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull c.a.p0.a.t1.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(c.a.p0.a.p2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            c.a.p0.a.s0.a.Z().b(false, cVar);
        }
    }

    public final void N(@NonNull Activity activity, c.a.p0.a.x1.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String Y = c.a.p0.a.t1.d.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(R.string.swanapp_multi_auth_default_name_head) + Y + activity.getString(R.string.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(R.string.swanapp_multi_auth_default_name_head) + Y + activity.getString(R.string.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(R.string.swanapp_multi_auth_un_realname_name_head) + Y + activity.getString(R.string.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, c.a.p0.a.x1.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String Y = c.a.p0.a.t1.d.J().r().Y();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(R.string.swanapp_multi_auth_guest_login_name_head) + Y + activity.getString(R.string.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(R.string.swanapp_multi_auth_un_realname_name_head) + Y + activity.getString(R.string.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(R.string.swanapp_multi_auth_default_name_head) + Y + activity.getString(R.string.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(c.a.p0.a.x1.c.f fVar, List<c.a.p0.a.x1.c.f> list, boolean z, @NonNull Activity activity, @NonNull c.a.p0.a.t1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            c.a.p0.a.x1.c.d.u(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        c.a.p0.a.x1.b.j.d().n(true);
                        eVar.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    j.b d2 = c.a.p0.a.x1.b.j.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                j.b d3 = c.a.p0.a.x1.b.j.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            j.b d4 = c.a.p0.a.x1.b.j.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull c.a.p0.a.t1.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.M().f(activity, null, new C0594i(this, jVar));
        }
    }

    public final List<c.a.p0.a.x1.c.f> w(Map<String, c.a.p0.a.x1.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = c.a.p0.a.x1.c.f.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    c.a.p0.a.x1.c.f fVar = map.get(c2);
                    if (map.containsKey(c2) && fVar != null && B(fVar)) {
                        if (fVar.f9100d) {
                            c.a.p0.a.x1.c.d.o(10005, callbackHandler, str);
                            j.b d2 = c.a.p0.a.x1.b.j.d();
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
                        c.a.p0.a.x1.c.d.o(10005, callbackHandler, str);
                        j.b d3 = c.a.p0.a.x1.b.j.d();
                        d3.n(false);
                        d3.o();
                        n.r(10005, fVar);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                j.b d4 = c.a.p0.a.x1.b.j.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            c.a.p0.a.u.d.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                j.b d5 = c.a.p0.a.x1.b.j.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull c.a.p0.a.t1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            c.a.p0.a.f1.r.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final c.a.p0.a.x1.c.f y(Map<String, c.a.p0.a.x1.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            c.a.p0.a.x1.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                c.a.p0.a.x1.c.d.o(10001, callbackHandler, str);
                n.r(10001, null);
                return null;
            } else if (fVar.f9100d) {
                c.a.p0.a.x1.c.d.o(10005, callbackHandler, str);
                n.r(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (c.a.p0.a.x1.c.f) invokeLLL.objValue;
    }

    public final void z(c.a.p0.a.p2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            c.a.p0.a.s0.a.Z().c(c.a.p0.a.s0.a.c(), cVar);
        }
    }
}
