package b.a.p0.a.h2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.b.j;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.q0;
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
    public class a implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6306f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6307g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6308h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f6309i;
        public final /* synthetic */ i j;

        public a(i iVar, CallbackHandler callbackHandler, String str, Context context, b.a.p0.a.d2.e eVar, JSONArray jSONArray) {
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
            this.j = iVar;
            this.f6305e = callbackHandler;
            this.f6306f = str;
            this.f6307g = context;
            this.f6308h = eVar;
            this.f6309i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.j.x((Activity) this.f6307g, this.f6308h, this.f6305e, this.f6309i, this.f6306f);
                    return;
                }
                j.b d2 = b.a.p0.a.h2.b.j.d();
                d2.n(false);
                d2.o();
                b.a.p0.a.h2.c.d.q(iVar, this.f6305e, this.f6306f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.p1.r.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6311b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f6312c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6313d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f6315f;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.z2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.h2.c.f f6316e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f6317f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f6318g;

            /* renamed from: b.a.p0.a.h2.b.i$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0269a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f6319e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f6320f;

                public RunnableC0269a(a aVar, Boolean bool) {
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
                    this.f6320f = aVar;
                    this.f6319e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f6320f;
                        i iVar = aVar.f6318g.f6315f;
                        b.a.p0.a.h2.c.f fVar = aVar.f6316e;
                        List list = aVar.f6317f;
                        boolean booleanValue = this.f6319e.booleanValue();
                        b bVar = this.f6320f.f6318g;
                        iVar.P(fVar, list, booleanValue, bVar.f6314e, bVar.f6313d, bVar.f6310a, bVar.f6311b);
                    }
                }
            }

            public a(b bVar, b.a.p0.a.h2.c.f fVar, List list) {
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
                this.f6318g = bVar;
                this.f6316e = fVar;
                this.f6317f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f6318g;
                    bVar.f6315f.O(bVar.f6314e, this.f6316e, bool);
                    q0.a0(new RunnableC0269a(this, bool));
                }
            }
        }

        /* renamed from: b.a.p0.a.h2.b.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0270b implements b.a.p0.a.z2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.h2.c.f f6321e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f6322f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f6323g;

            /* renamed from: b.a.p0.a.h2.b.i$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0270b f6324e;

                public a(C0270b c0270b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0270b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6324e = c0270b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0270b c0270b = this.f6324e;
                        b bVar = c0270b.f6323g;
                        bVar.f6315f.P(c0270b.f6321e, c0270b.f6322f, false, bVar.f6314e, bVar.f6313d, bVar.f6310a, bVar.f6311b);
                    }
                }
            }

            public C0270b(b bVar, b.a.p0.a.h2.c.f fVar, List list) {
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
                this.f6323g = bVar;
                this.f6321e = fVar;
                this.f6322f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f6323g;
                    bVar.f6315f.N(bVar.f6314e, this.f6321e, str);
                    q0.a0(new a(this));
                }
            }
        }

        public b(i iVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, b.a.p0.a.d2.e eVar, Activity activity) {
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
            this.f6315f = iVar;
            this.f6310a = callbackHandler;
            this.f6311b = str;
            this.f6312c = jSONArray;
            this.f6313d = eVar;
            this.f6314e = activity;
        }

        @Override // b.a.p0.a.p1.r.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, b.a.p0.a.h2.c.f> g2 = b.a.p0.a.p1.r.c.a.g(true);
                b.a.p0.a.h2.c.f y = this.f6315f.y(g2, this.f6310a, this.f6311b);
                if (y != null) {
                    List<b.a.p0.a.h2.c.f> w = this.f6315f.w(g2, this.f6312c, this.f6310a, this.f6311b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.f6313d.M().e(this.f6314e)) {
                        this.f6315f.z(new C0270b(this, y, w));
                        return;
                    } else {
                        b.a.p0.a.c1.a.Z().a(this.f6314e, new a(this, y, w));
                        return;
                    }
                }
                j.b d2 = b.a.p0.a.h2.b.j.d();
                d2.n(false);
                d2.o();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.h2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6326b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f6327c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6328d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6329e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f6330f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f6331g;

        public c(i iVar, CallbackHandler callbackHandler, String str, boolean z, b.a.p0.a.d2.e eVar, Activity activity, List list) {
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
            this.f6331g = iVar;
            this.f6325a = callbackHandler;
            this.f6326b = str;
            this.f6327c = z;
            this.f6328d = eVar;
            this.f6329e = activity;
            this.f6330f = list;
        }

        @Override // b.a.p0.a.h2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                b.a.p0.a.e0.d.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    j.b d2 = b.a.p0.a.h2.b.j.d();
                    d2.i(false);
                    d2.h(false);
                    d2.o();
                    b.a.p0.a.h2.c.d.o(10003, this.f6325a, this.f6326b);
                    return;
                }
                j.b d3 = b.a.p0.a.h2.b.j.d();
                d3.i(true);
                d3.h(true);
                boolean z2 = this.f6327c;
                if (this.f6328d.M().e(this.f6329e)) {
                    b.a.p0.a.h2.b.j.d().m(true);
                    this.f6331g.H(this.f6330f, this.f6329e, this.f6325a, this.f6326b);
                } else if (z2) {
                    this.f6331g.K(this.f6330f, this.f6329e, this.f6325a, this.f6326b);
                } else {
                    b.a.p0.a.h2.b.j.d().m(false);
                    this.f6331g.G(this.f6330f, this.f6329e, this.f6325a, this.f6326b, this.f6328d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6332a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f6333b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6334c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6335d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f6336e;

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
            this.f6336e = iVar;
            this.f6332a = list;
            this.f6333b = activity;
            this.f6334c = callbackHandler;
            this.f6335d = str;
        }

        @Override // b.a.p0.a.h2.b.i.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                b.a.p0.a.e0.d.i("MultiAuthorize", "login result:" + i2);
                if (z) {
                    b.a.p0.a.h2.b.j.d().k(true);
                    this.f6336e.H(this.f6332a, this.f6333b, this.f6334c, this.f6335d);
                    return;
                }
                j.b d2 = b.a.p0.a.h2.b.j.d();
                d2.k(false);
                d2.n(true);
                d2.i(false);
                d2.o();
                b.a.p0.a.h2.c.d.o(10004, this.f6334c, this.f6335d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f6337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f6338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6340h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f6341i;

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
            this.f6341i = iVar;
            this.f6337e = list;
            this.f6338f = activity;
            this.f6339g = callbackHandler;
            this.f6340h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6341i.I(TextUtils.equals(str, "1"), this.f6337e, this.f6338f, this.f6339g, this.f6340h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6342e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f6343f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6344g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6345h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f6346i;

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
            this.f6346i = iVar;
            this.f6342e = activity;
            this.f6343f = list;
            this.f6344g = callbackHandler;
            this.f6345h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    j.b d2 = b.a.p0.a.h2.b.j.d();
                    d2.j(true);
                    d2.i(true);
                    this.f6346i.J(this.f6342e, this.f6343f, this.f6344g, this.f6345h);
                    return;
                }
                j.b d3 = b.a.p0.a.h2.b.j.d();
                d3.j(false);
                d3.i(false);
                d3.o();
                b.a.p0.a.h2.c.d.o(10003, this.f6344g, this.f6345h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.z2.g1.c<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f6347e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f6348f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6349g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6350h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f6351i;

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
            this.f6351i = iVar;
            this.f6347e = list;
            this.f6348f = activity;
            this.f6349g = callbackHandler;
            this.f6350h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    b.a.p0.a.h2.b.j.d().m(true);
                    this.f6351i.H(this.f6347e, this.f6348f, this.f6349g, this.f6350h);
                    return;
                }
                j.b d2 = b.a.p0.a.h2.b.j.d();
                d2.m(false);
                d2.n(false);
                d2.o();
                b.a.p0.a.h2.c.d.o(10003, this.f6349g, this.f6350h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6353f;

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
            this.f6352e = callbackHandler;
            this.f6353f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    b.a.p0.a.h2.c.d.o(10001, this.f6352e, this.f6353f);
                    j.b d2 = b.a.p0.a.h2.b.j.d();
                    d2.n(false);
                    d2.o();
                    n.r(10001, null);
                    return;
                }
                int b2 = iVar.b();
                b.a.p0.a.e0.d.o("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f6424a);
                if (b2 != 0) {
                    j.b d3 = b.a.p0.a.h2.b.j.d();
                    d3.n(false);
                    d3.o();
                    b.a.p0.a.h2.c.d.o(b2, this.f6352e, this.f6353f);
                    return;
                }
                j.b d4 = b.a.p0.a.h2.b.j.d();
                d4.n(true);
                d4.o();
                this.f6352e.handleSchemeDispatchCallback(this.f6353f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* renamed from: b.a.p0.a.h2.b.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0271i implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f6354e;

        public C0271i(i iVar, j jVar) {
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
            this.f6354e = jVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f6354e.a(false, i2);
                } else {
                    this.f6354e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b.a.p0.a.f2.e eVar) {
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

    public final boolean A(List<b.a.p0.a.h2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (b.a.p0.a.h2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(b.a.p0.a.h2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f6383b, "mapp_location") || TextUtils.equals(fVar.f6383b, "mapp_images") || TextUtils.equals(fVar.f6383b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f6383b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f6383b, "ppcert") || TextUtils.equals(fVar.f6383b, "mapp_i_face_verify") || TextUtils.equals(fVar.f6383b, "snsapi_userinfo") || TextUtils.equals(fVar.f6383b, "mapp_choose_address") || TextUtils.equals(fVar.f6383b, "mobile") || TextUtils.equals(fVar.f6383b, "mapp_choose_invoice") || TextUtils.equals(fVar.f6383b, "mapp_i_read_contacts") || TextUtils.equals(fVar.f6383b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(b.a.p0.a.h2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f6383b, "ppcert") || TextUtils.equals(fVar.f6383b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<b.a.p0.a.h2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (b.a.p0.a.h2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(b.a.p0.a.h2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f6383b, "mapp_location") || TextUtils.equals(fVar.f6383b, "mapp_images") || TextUtils.equals(fVar.f6383b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f6383b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f6383b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<b.a.p0.a.h2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (b.a.p0.a.h2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<b.a.p0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull b.a.p0.a.d2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                b.a.p0.a.h2.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(eVar, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<b.a.p0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                b.a.p0.a.h2.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<b.a.p0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                j.b d2 = b.a.p0.a.h2.b.j.d();
                d2.l(true);
                d2.i(true);
                b.a.p0.a.e0.d.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            b.a.p0.a.h2.b.j.d().l(false);
            b.a.p0.a.e0.d.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<b.a.p0.a.h2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f6383b;
            }
            b.a.p0.a.h2.c.j.b d2 = b.a.p0.a.d2.d.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<b.a.p0.a.h2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            b.a.p0.a.c1.a.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull b.a.p0.a.d2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            b.a.p0.a.c1.a.Z().b(false, cVar);
        }
    }

    public final void N(@NonNull Activity activity, b.a.p0.a.h2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String Y = b.a.p0.a.d2.d.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_head) + Y + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_head) + Y + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_un_realname_name_head) + Y + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, b.a.p0.a.h2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String Y = b.a.p0.a.d2.d.J().r().Y();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_guest_login_name_head) + Y + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_un_realname_name_head) + Y + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_head) + Y + activity.getString(b.a.p0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(b.a.p0.a.h2.c.f fVar, List<b.a.p0.a.h2.c.f> list, boolean z, @NonNull Activity activity, @NonNull b.a.p0.a.d2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            b.a.p0.a.h2.c.d.u(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        b.a.p0.a.h2.b.j.d().n(true);
                        eVar.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    j.b d2 = b.a.p0.a.h2.b.j.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                j.b d3 = b.a.p0.a.h2.b.j.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            j.b d4 = b.a.p0.a.h2.b.j.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull b.a.p0.a.d2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.M().f(activity, null, new C0271i(this, jVar));
        }
    }

    public final List<b.a.p0.a.h2.c.f> w(Map<String, b.a.p0.a.h2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = b.a.p0.a.h2.c.f.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    b.a.p0.a.h2.c.f fVar = map.get(c2);
                    if (map.containsKey(c2) && fVar != null && B(fVar)) {
                        if (fVar.f6385d) {
                            b.a.p0.a.h2.c.d.o(10005, callbackHandler, str);
                            j.b d2 = b.a.p0.a.h2.b.j.d();
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
                        b.a.p0.a.h2.c.d.o(10005, callbackHandler, str);
                        j.b d3 = b.a.p0.a.h2.b.j.d();
                        d3.n(false);
                        d3.o();
                        n.r(10005, fVar);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                j.b d4 = b.a.p0.a.h2.b.j.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            b.a.p0.a.e0.d.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                j.b d5 = b.a.p0.a.h2.b.j.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull b.a.p0.a.d2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            b.a.p0.a.p1.r.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final b.a.p0.a.h2.c.f y(Map<String, b.a.p0.a.h2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            b.a.p0.a.h2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                b.a.p0.a.h2.c.d.o(10001, callbackHandler, str);
                n.r(10001, null);
                return null;
            } else if (fVar.f6385d) {
                b.a.p0.a.h2.c.d.o(10005, callbackHandler, str);
                n.r(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (b.a.p0.a.h2.c.f) invokeLLL.objValue;
    }

    public final void z(b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            b.a.p0.a.c1.a.Z().c(b.a.p0.a.c1.a.c(), cVar);
        }
    }
}
