package c.a.p0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.j2.k;
import c.a.p0.a.v2.q0;
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
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5465g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5466h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5467i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f5468j;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, c.a.p0.a.a2.e eVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, context, eVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5468j = hVar;
            this.f5463e = callbackHandler;
            this.f5464f = str;
            this.f5465g = context;
            this.f5466h = eVar;
            this.f5467i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f5468j.x((Activity) this.f5465g, this.f5466h, this.f5463e, this.f5467i, this.f5464f);
                } else {
                    c.a.p0.a.e2.c.d.p(iVar, this.f5463e, this.f5464f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5469a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5470b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5471c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5472d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f5474f;

        /* loaded from: classes.dex */
        public class a implements c.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.e2.c.f f5475e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f5476f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f5477g;

            /* renamed from: c.a.p0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0168a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f5478e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f5479f;

                public RunnableC0168a(a aVar, Boolean bool) {
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
                    this.f5479f = aVar;
                    this.f5478e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f5479f;
                        h hVar = aVar.f5477g.f5474f;
                        c.a.p0.a.e2.c.f fVar = aVar.f5475e;
                        List list = aVar.f5476f;
                        boolean booleanValue = this.f5478e.booleanValue();
                        b bVar = this.f5479f.f5477g;
                        hVar.P(fVar, list, booleanValue, bVar.f5473e, bVar.f5472d, bVar.f5469a, bVar.f5470b);
                    }
                }
            }

            public a(b bVar, c.a.p0.a.e2.c.f fVar, List list) {
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
                this.f5477g = bVar;
                this.f5475e = fVar;
                this.f5476f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f5477g;
                    bVar.f5474f.O(bVar.f5473e, this.f5475e, bool);
                    q0.X(new RunnableC0168a(this, bool));
                }
            }
        }

        /* renamed from: c.a.p0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0169b implements c.a.p0.a.v2.e1.b<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.e2.c.f f5480e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f5481f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f5482g;

            /* renamed from: c.a.p0.a.e2.b.h$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0169b f5483e;

                public a(C0169b c0169b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0169b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5483e = c0169b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0169b c0169b = this.f5483e;
                        b bVar = c0169b.f5482g;
                        bVar.f5474f.P(c0169b.f5480e, c0169b.f5481f, false, bVar.f5473e, bVar.f5472d, bVar.f5469a, bVar.f5470b);
                    }
                }
            }

            public C0169b(b bVar, c.a.p0.a.e2.c.f fVar, List list) {
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
                this.f5482g = bVar;
                this.f5480e = fVar;
                this.f5481f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f5482g;
                    bVar.f5474f.N(bVar.f5473e, this.f5480e, str);
                    q0.X(new a(this));
                }
            }
        }

        public b(h hVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, c.a.p0.a.a2.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, jSONArray, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5474f = hVar;
            this.f5469a = callbackHandler;
            this.f5470b = str;
            this.f5471c = jSONArray;
            this.f5472d = eVar;
            this.f5473e = activity;
        }

        @Override // c.a.p0.a.n1.q.b.a
        public void a() {
            Map<String, c.a.p0.a.e2.c.f> g2;
            c.a.p0.a.e2.c.f y;
            List<c.a.p0.a.e2.c.f> w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f5474f.y((g2 = c.a.p0.a.n1.q.c.a.g(true)), this.f5469a, this.f5470b)) == null || (w = this.f5474f.w(g2, this.f5471c, this.f5469a, this.f5470b)) == null) {
                return;
            }
            y.g(w);
            if (this.f5472d.j().e(this.f5473e)) {
                this.f5474f.z(new C0169b(this, y, w));
            } else {
                c.a.p0.a.c1.a.T().a(this.f5473e, new a(this, y, w));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5485b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5486c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5487d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f5489f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f5490g;

        public c(h hVar, CallbackHandler callbackHandler, String str, boolean z, c.a.p0.a.a2.e eVar, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, Boolean.valueOf(z), eVar, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5490g = hVar;
            this.f5484a = callbackHandler;
            this.f5485b = str;
            this.f5486c = z;
            this.f5487d = eVar;
            this.f5488e = activity;
            this.f5489f = list;
        }

        @Override // c.a.p0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.p0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    c.a.p0.a.e2.c.d.n(10003, this.f5484a, this.f5485b);
                    return;
                }
                boolean z2 = this.f5486c;
                if (this.f5487d.j().e(this.f5488e)) {
                    this.f5490g.H(this.f5489f, this.f5488e, this.f5484a, this.f5485b);
                } else if (z2) {
                    this.f5490g.K(this.f5489f, this.f5488e, this.f5484a, this.f5485b);
                } else {
                    this.f5490g.G(this.f5489f, this.f5488e, this.f5484a, this.f5485b, this.f5487d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f5491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f5492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5493c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5494d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f5495e;

        public d(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5495e = hVar;
            this.f5491a = list;
            this.f5492b = activity;
            this.f5493c = callbackHandler;
            this.f5494d = str;
        }

        @Override // c.a.p0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                c.a.p0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
                if (z) {
                    this.f5495e.H(this.f5491a, this.f5492b, this.f5493c, this.f5494d);
                } else {
                    c.a.p0.a.e2.c.d.n(10004, this.f5493c, this.f5494d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f5496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f5497f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5498g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5499h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f5500i;

        public e(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5500i = hVar;
            this.f5496e = list;
            this.f5497f = activity;
            this.f5498g = callbackHandler;
            this.f5499h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5500i.I(TextUtils.equals(str, "1"), this.f5496e, this.f5497f, this.f5498g, this.f5499h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f5502f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5503g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5504h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f5505i;

        public f(h hVar, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5505i = hVar;
            this.f5501e = activity;
            this.f5502f = list;
            this.f5503g = callbackHandler;
            this.f5504h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f5505i.J(this.f5501e, this.f5502f, this.f5503g, this.f5504h);
                } else {
                    c.a.p0.a.e2.c.d.n(10003, this.f5503g, this.f5504h);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f5506e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f5507f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5508g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5509h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f5510i;

        public g(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5510i = hVar;
            this.f5506e = list;
            this.f5507f = activity;
            this.f5508g = callbackHandler;
            this.f5509h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    this.f5510i.H(this.f5506e, this.f5507f, this.f5508g, this.f5509h);
                } else {
                    c.a.p0.a.e2.c.d.n(10003, this.f5508g, this.f5509h);
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0170h implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5512f;

        public C0170h(h hVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5511e = callbackHandler;
            this.f5512f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    c.a.p0.a.e2.c.d.n(10001, this.f5511e, this.f5512f);
                    k.p(10001, null);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f5582a);
                if (b2 != 0) {
                    c.a.p0.a.e2.c.d.n(b2, this.f5511e, this.f5512f);
                } else {
                    this.f5511e.handleSchemeDispatchCallback(this.f5512f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f5513e;

        public i(h hVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5513e = jVar;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f5513e.a(false, i2);
                } else {
                    this.f5513e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.p0.a.c2.e eVar) {
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

    public final boolean A(List<c.a.p0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (c.a.p0.a.e2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(c.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f5539b, "mapp_location") || TextUtils.equals(fVar.f5539b, "mapp_images") || TextUtils.equals(fVar.f5539b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f5539b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f5539b, "ppcert") || TextUtils.equals(fVar.f5539b, "mapp_i_face_verify") || TextUtils.equals(fVar.f5539b, "snsapi_userinfo") || TextUtils.equals(fVar.f5539b, "mapp_choose_address") || TextUtils.equals(fVar.f5539b, "mobile") || TextUtils.equals(fVar.f5539b, "mapp_choose_invoice") : invokeL.booleanValue;
    }

    public final boolean C(c.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f5539b, "ppcert") || TextUtils.equals(fVar.f5539b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<c.a.p0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (c.a.p0.a.e2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(c.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f5539b, "mapp_location") || TextUtils.equals(fVar.f5539b, "mapp_images") || TextUtils.equals(fVar.f5539b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f5539b, PermissionProxy.SCOPE_ID_CAMERA) : invokeL.booleanValue;
    }

    public final boolean F(List<c.a.p0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (c.a.p0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<c.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                L(eVar, activity, new d(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void H(List<c.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                z(new e(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void I(boolean z, List<c.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                c.a.p0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            c.a.p0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<c.a.p0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f5539b;
            }
            c.a.p0.a.e2.c.j.b d2 = c.a.p0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
            d2.p(new C0170h(this, callbackHandler, str));
            d2.a();
        }
    }

    public final void K(List<c.a.p0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            c.a.p0.a.c1.a.T().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull c.a.p0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(c.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            c.a.p0.a.c1.a.T().b(false, bVar);
        }
    }

    public final void N(@NonNull Activity activity, c.a.p0.a.e2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String O = c.a.p0.a.a2.d.g().r().O();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(c.a.p0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, c.a.p0.a.e2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String O = c.a.p0.a.a2.d.g().r().O();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(c.a.p0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(c.a.p0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(c.a.p0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(c.a.p0.a.e2.c.f fVar, List<c.a.p0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull c.a.p0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            c.a.p0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        eVar.T().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull c.a.p0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.j().f(activity, null, new i(this, jVar));
        }
    }

    public final List<c.a.p0.a.e2.c.f> w(Map<String, c.a.p0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        c.a.p0.a.e2.c.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                    if (!B(fVar)) {
                        c.a.p0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else if (fVar.f5541d) {
                        c.a.p0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else {
                        if (!arrayList.contains(fVar) && !fVar.a()) {
                            arrayList.add(fVar);
                        }
                        if (!fVar.a()) {
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return null;
            }
            c.a.p0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull c.a.p0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            c.a.p0.a.n1.q.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final c.a.p0.a.e2.c.f y(Map<String, c.a.p0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            c.a.p0.a.e2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                c.a.p0.a.e2.c.d.n(10001, callbackHandler, str);
                k.p(10001, null);
                return null;
            } else if (fVar.f5541d) {
                c.a.p0.a.e2.c.d.n(10005, callbackHandler, str);
                k.p(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (c.a.p0.a.e2.c.f) invokeLLL.objValue;
    }

    public final void z(c.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            c.a.p0.a.c1.a.T().c(c.a.p0.a.c1.a.b(), bVar);
        }
    }
}
