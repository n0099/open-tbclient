package c.a.n0.a.x1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.b.j;
import c.a.n0.a.x1.c.j.b;
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
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7587b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f7588c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7589d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f7591f;

        public a(i iVar, CallbackHandler callbackHandler, String str, Context context, c.a.n0.a.t1.e eVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str, context, eVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7591f = iVar;
            this.a = callbackHandler;
            this.f7587b = str;
            this.f7588c = context;
            this.f7589d = eVar;
            this.f7590e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f7591f.x((Activity) this.f7588c, this.f7589d, this.a, this.f7590e, this.f7587b);
                    return;
                }
                j.b d2 = c.a.n0.a.x1.b.j.d();
                d2.n(false);
                d2.o();
                c.a.n0.a.x1.c.d.q(iVar, this.a, this.f7587b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.f1.r.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7592b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7593c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7594d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f7596f;

        /* loaded from: classes.dex */
        public class a implements c.a.n0.a.p2.g1.c<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.x1.c.f a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f7597b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f7598c;

            /* renamed from: c.a.n0.a.x1.b.i$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0584a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f7599b;

                public RunnableC0584a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7599b = aVar;
                    this.a = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f7599b;
                        i iVar = aVar.f7598c.f7596f;
                        c.a.n0.a.x1.c.f fVar = aVar.a;
                        List list = aVar.f7597b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.f7599b.f7598c;
                        iVar.P(fVar, list, booleanValue, bVar.f7595e, bVar.f7594d, bVar.a, bVar.f7592b);
                    }
                }
            }

            public a(b bVar, c.a.n0.a.x1.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7598c = bVar;
                this.a = fVar;
                this.f7597b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f7598c;
                    bVar.f7596f.O(bVar.f7595e, this.a, bool);
                    q0.a0(new RunnableC0584a(this, bool));
                }
            }
        }

        /* renamed from: c.a.n0.a.x1.b.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0585b implements c.a.n0.a.p2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.x1.c.f a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f7600b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f7601c;

            /* renamed from: c.a.n0.a.x1.b.i$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0585b a;

                public a(C0585b c0585b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0585b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0585b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0585b c0585b = this.a;
                        b bVar = c0585b.f7601c;
                        bVar.f7596f.P(c0585b.a, c0585b.f7600b, false, bVar.f7595e, bVar.f7594d, bVar.a, bVar.f7592b);
                    }
                }
            }

            public C0585b(b bVar, c.a.n0.a.x1.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7601c = bVar;
                this.a = fVar;
                this.f7600b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f7601c;
                    bVar.f7596f.N(bVar.f7595e, this.a, str);
                    q0.a0(new a(this));
                }
            }
        }

        public b(i iVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, c.a.n0.a.t1.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str, jSONArray, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7596f = iVar;
            this.a = callbackHandler;
            this.f7592b = str;
            this.f7593c = jSONArray;
            this.f7594d = eVar;
            this.f7595e = activity;
        }

        @Override // c.a.n0.a.f1.r.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, c.a.n0.a.x1.c.f> g2 = c.a.n0.a.f1.r.c.a.g(true);
                c.a.n0.a.x1.c.f y = this.f7596f.y(g2, this.a, this.f7592b);
                if (y != null) {
                    List<c.a.n0.a.x1.c.f> w = this.f7596f.w(g2, this.f7593c, this.a, this.f7592b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.f7594d.M().e(this.f7595e)) {
                        this.f7596f.z(new C0585b(this, y, w));
                        return;
                    } else {
                        c.a.n0.a.s0.a.Z().a(this.f7595e, new a(this, y, w));
                        return;
                    }
                }
                j.b d2 = c.a.n0.a.x1.b.j.d();
                d2.n(false);
                d2.o();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.x1.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7602b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f7603c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7604d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7605e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f7606f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f7607g;

        public c(i iVar, CallbackHandler callbackHandler, String str, boolean z, c.a.n0.a.t1.e eVar, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str, Boolean.valueOf(z), eVar, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7607g = iVar;
            this.a = callbackHandler;
            this.f7602b = str;
            this.f7603c = z;
            this.f7604d = eVar;
            this.f7605e = activity;
            this.f7606f = list;
        }

        @Override // c.a.n0.a.x1.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.n0.a.u.d.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    j.b d2 = c.a.n0.a.x1.b.j.d();
                    d2.i(false);
                    d2.h(false);
                    d2.o();
                    c.a.n0.a.x1.c.d.o(10003, this.a, this.f7602b);
                    return;
                }
                j.b d3 = c.a.n0.a.x1.b.j.d();
                d3.i(true);
                d3.h(true);
                boolean z2 = this.f7603c;
                if (this.f7604d.M().e(this.f7605e)) {
                    c.a.n0.a.x1.b.j.d().m(true);
                    this.f7607g.H(this.f7606f, this.f7605e, this.a, this.f7602b);
                } else if (z2) {
                    this.f7607g.K(this.f7606f, this.f7605e, this.a, this.f7602b);
                } else {
                    c.a.n0.a.x1.b.j.d().m(false);
                    this.f7607g.G(this.f7606f, this.f7605e, this.a, this.f7602b, this.f7604d);
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
        public final /* synthetic */ Activity f7608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7609c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7610d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f7611e;

        public d(i iVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7611e = iVar;
            this.a = list;
            this.f7608b = activity;
            this.f7609c = callbackHandler;
            this.f7610d = str;
        }

        @Override // c.a.n0.a.x1.b.i.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                c.a.n0.a.u.d.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    c.a.n0.a.x1.b.j.d().k(true);
                    this.f7611e.H(this.a, this.f7608b, this.f7609c, this.f7610d);
                    return;
                }
                j.b d2 = c.a.n0.a.x1.b.j.d();
                d2.k(false);
                d2.n(true);
                d2.i(false);
                d2.o();
                c.a.n0.a.x1.c.d.o(10004, this.f7609c, this.f7610d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f7612b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7613c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7614d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f7615e;

        public e(i iVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7615e = iVar;
            this.a = list;
            this.f7612b = activity;
            this.f7613c = callbackHandler;
            this.f7614d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7615e.I(TextUtils.equals(str, "1"), this.a, this.f7612b, this.f7613c, this.f7614d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f7616b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7617c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7618d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f7619e;

        public f(i iVar, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7619e = iVar;
            this.a = activity;
            this.f7616b = list;
            this.f7617c = callbackHandler;
            this.f7618d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    j.b d2 = c.a.n0.a.x1.b.j.d();
                    d2.j(true);
                    d2.i(true);
                    this.f7619e.J(this.a, this.f7616b, this.f7617c, this.f7618d);
                    return;
                }
                j.b d3 = c.a.n0.a.x1.b.j.d();
                d3.j(false);
                d3.i(false);
                d3.o();
                c.a.n0.a.x1.c.d.o(10003, this.f7617c, this.f7618d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.p2.g1.c<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f7620b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7621c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7622d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f7623e;

        public g(i iVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7623e = iVar;
            this.a = list;
            this.f7620b = activity;
            this.f7621c = callbackHandler;
            this.f7622d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    c.a.n0.a.x1.b.j.d().m(true);
                    this.f7623e.H(this.a, this.f7620b, this.f7621c, this.f7622d);
                    return;
                }
                j.b d2 = c.a.n0.a.x1.b.j.d();
                d2.m(false);
                d2.n(false);
                d2.o();
                c.a.n0.a.x1.c.d.o(10003, this.f7621c, this.f7622d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7624b;

        public h(i iVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f7624b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    c.a.n0.a.x1.c.d.o(10001, this.a, this.f7624b);
                    j.b d2 = c.a.n0.a.x1.b.j.d();
                    d2.n(false);
                    d2.o();
                    n.r(10001, null);
                    return;
                }
                int b2 = iVar.b();
                c.a.n0.a.u.d.o("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.a);
                if (b2 != 0) {
                    j.b d3 = c.a.n0.a.x1.b.j.d();
                    d3.n(false);
                    d3.o();
                    c.a.n0.a.x1.c.d.o(b2, this.a, this.f7624b);
                    return;
                }
                j.b d4 = c.a.n0.a.x1.b.j.d();
                d4.n(true);
                d4.o();
                this.a.handleSchemeDispatchCallback(this.f7624b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* renamed from: c.a.n0.a.x1.b.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0586i implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public C0586i(i iVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    this.a.a(false, i);
                } else {
                    this.a.a(true, i);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<c.a.n0.a.x1.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (c.a.n0.a.x1.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(c.a.n0.a.x1.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f7638b, "mapp_location") || TextUtils.equals(fVar.f7638b, "mapp_images") || TextUtils.equals(fVar.f7638b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f7638b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f7638b, "ppcert") || TextUtils.equals(fVar.f7638b, "mapp_i_face_verify") || TextUtils.equals(fVar.f7638b, "snsapi_userinfo") || TextUtils.equals(fVar.f7638b, "mapp_choose_address") || TextUtils.equals(fVar.f7638b, "mobile") || TextUtils.equals(fVar.f7638b, "mapp_choose_invoice") || TextUtils.equals(fVar.f7638b, "mapp_i_read_contacts") || TextUtils.equals(fVar.f7638b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(c.a.n0.a.x1.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f7638b, "ppcert") || TextUtils.equals(fVar.f7638b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<c.a.n0.a.x1.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (c.a.n0.a.x1.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(c.a.n0.a.x1.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f7638b, "mapp_location") || TextUtils.equals(fVar.f7638b, "mapp_images") || TextUtils.equals(fVar.f7638b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f7638b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f7638b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<c.a.n0.a.x1.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (c.a.n0.a.x1.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<c.a.n0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.n0.a.t1.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                c.a.n0.a.x1.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(eVar, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<c.a.n0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                c.a.n0.a.x1.b.j.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<c.a.n0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                j.b d2 = c.a.n0.a.x1.b.j.d();
                d2.l(true);
                d2.i(true);
                c.a.n0.a.u.d.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            c.a.n0.a.x1.b.j.d().l(false);
            c.a.n0.a.u.d.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<c.a.n0.a.x1.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = list.get(i).f7638b;
            }
            c.a.n0.a.x1.c.j.b d2 = c.a.n0.a.t1.d.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<c.a.n0.a.x1.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            c.a.n0.a.s0.a.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull c.a.n0.a.t1.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(c.a.n0.a.p2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            c.a.n0.a.s0.a.Z().b(false, cVar);
        }
    }

    public final void N(@NonNull Activity activity, c.a.n0.a.x1.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String Y = c.a.n0.a.t1.d.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(R.string.obfuscated_res_0x7f0f12a5) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12a4);
            } else if (equals) {
                fVar.r = activity.getString(R.string.obfuscated_res_0x7f0f12a5) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12a4);
            } else {
                fVar.r = activity.getString(R.string.obfuscated_res_0x7f0f12a7) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12a4);
            }
        }
    }

    public final void O(@NonNull Activity activity, c.a.n0.a.x1.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String Y = c.a.n0.a.t1.d.J().r().Y();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(R.string.obfuscated_res_0x7f0f12a6) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12a4);
            } else if (A) {
                fVar.r = activity.getString(R.string.obfuscated_res_0x7f0f12a7) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12a4);
            } else {
                fVar.r = activity.getString(R.string.obfuscated_res_0x7f0f12a5) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12a4);
            }
        }
    }

    public final void P(c.a.n0.a.x1.c.f fVar, List<c.a.n0.a.x1.c.f> list, boolean z, @NonNull Activity activity, @NonNull c.a.n0.a.t1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            c.a.n0.a.x1.c.d.u(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        c.a.n0.a.x1.b.j.d().n(true);
                        eVar.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    j.b d2 = c.a.n0.a.x1.b.j.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                j.b d3 = c.a.n0.a.x1.b.j.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            j.b d4 = c.a.n0.a.x1.b.j.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull c.a.n0.a.t1.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.M().f(activity, null, new C0586i(this, jVar));
        }
    }

    public final List<c.a.n0.a.x1.c.f> w(Map<String, c.a.n0.a.x1.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i = 0; i < length; i++) {
                String c2 = c.a.n0.a.x1.c.f.c(jSONArray.optString(i));
                if (!TextUtils.isEmpty(c2)) {
                    c.a.n0.a.x1.c.f fVar = map.get(c2);
                    if (map.containsKey(c2) && fVar != null && B(fVar)) {
                        if (fVar.f7640d) {
                            c.a.n0.a.x1.c.d.o(10005, callbackHandler, str);
                            j.b d2 = c.a.n0.a.x1.b.j.d();
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
                        c.a.n0.a.x1.c.d.o(10005, callbackHandler, str);
                        j.b d3 = c.a.n0.a.x1.b.j.d();
                        d3.n(false);
                        d3.o();
                        n.r(10005, fVar);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                j.b d4 = c.a.n0.a.x1.b.j.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            c.a.n0.a.u.d.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                j.b d5 = c.a.n0.a.x1.b.j.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull c.a.n0.a.t1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            c.a.n0.a.f1.r.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final c.a.n0.a.x1.c.f y(Map<String, c.a.n0.a.x1.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            c.a.n0.a.x1.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                c.a.n0.a.x1.c.d.o(10001, callbackHandler, str);
                n.r(10001, null);
                return null;
            } else if (fVar.f7640d) {
                c.a.n0.a.x1.c.d.o(10005, callbackHandler, str);
                n.r(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (c.a.n0.a.x1.c.f) invokeLLL.objValue;
    }

    public final void z(c.a.n0.a.p2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            c.a.n0.a.s0.a.Z().c(c.a.n0.a.s0.a.c(), cVar);
        }
    }
}
