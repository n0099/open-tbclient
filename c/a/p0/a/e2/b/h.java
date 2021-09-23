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
        public final /* synthetic */ CallbackHandler f5471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5472f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5473g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5474h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5475i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f5476j;

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
            this.f5476j = hVar;
            this.f5471e = callbackHandler;
            this.f5472f = str;
            this.f5473g = context;
            this.f5474h = eVar;
            this.f5475i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f5476j.x((Activity) this.f5473g, this.f5474h, this.f5471e, this.f5475i, this.f5472f);
                } else {
                    c.a.p0.a.e2.c.d.p(iVar, this.f5471e, this.f5472f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5479c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5480d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f5482f;

        /* loaded from: classes.dex */
        public class a implements c.a.p0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.e2.c.f f5483e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f5484f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f5485g;

            /* renamed from: c.a.p0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0168a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f5486e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f5487f;

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
                    this.f5487f = aVar;
                    this.f5486e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f5487f;
                        h hVar = aVar.f5485g.f5482f;
                        c.a.p0.a.e2.c.f fVar = aVar.f5483e;
                        List list = aVar.f5484f;
                        boolean booleanValue = this.f5486e.booleanValue();
                        b bVar = this.f5487f.f5485g;
                        hVar.P(fVar, list, booleanValue, bVar.f5481e, bVar.f5480d, bVar.f5477a, bVar.f5478b);
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
                this.f5485g = bVar;
                this.f5483e = fVar;
                this.f5484f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f5485g;
                    bVar.f5482f.O(bVar.f5481e, this.f5483e, bool);
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
            public final /* synthetic */ c.a.p0.a.e2.c.f f5488e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f5489f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f5490g;

            /* renamed from: c.a.p0.a.e2.b.h$b$b$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0169b f5491e;

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
                    this.f5491e = c0169b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0169b c0169b = this.f5491e;
                        b bVar = c0169b.f5490g;
                        bVar.f5482f.P(c0169b.f5488e, c0169b.f5489f, false, bVar.f5481e, bVar.f5480d, bVar.f5477a, bVar.f5478b);
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
                this.f5490g = bVar;
                this.f5488e = fVar;
                this.f5489f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f5490g;
                    bVar.f5482f.N(bVar.f5481e, this.f5488e, str);
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
            this.f5482f = hVar;
            this.f5477a = callbackHandler;
            this.f5478b = str;
            this.f5479c = jSONArray;
            this.f5480d = eVar;
            this.f5481e = activity;
        }

        @Override // c.a.p0.a.n1.q.b.a
        public void a() {
            Map<String, c.a.p0.a.e2.c.f> g2;
            c.a.p0.a.e2.c.f y;
            List<c.a.p0.a.e2.c.f> w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f5482f.y((g2 = c.a.p0.a.n1.q.c.a.g(true)), this.f5477a, this.f5478b)) == null || (w = this.f5482f.w(g2, this.f5479c, this.f5477a, this.f5478b)) == null) {
                return;
            }
            y.g(w);
            if (this.f5480d.j().e(this.f5481e)) {
                this.f5482f.z(new C0169b(this, y, w));
            } else {
                c.a.p0.a.c1.a.T().a(this.f5481e, new a(this, y, w));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5492a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5493b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5494c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5495d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f5497f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f5498g;

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
            this.f5498g = hVar;
            this.f5492a = callbackHandler;
            this.f5493b = str;
            this.f5494c = z;
            this.f5495d = eVar;
            this.f5496e = activity;
            this.f5497f = list;
        }

        @Override // c.a.p0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.p0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    c.a.p0.a.e2.c.d.n(10003, this.f5492a, this.f5493b);
                    return;
                }
                boolean z2 = this.f5494c;
                if (this.f5495d.j().e(this.f5496e)) {
                    this.f5498g.H(this.f5497f, this.f5496e, this.f5492a, this.f5493b);
                } else if (z2) {
                    this.f5498g.K(this.f5497f, this.f5496e, this.f5492a, this.f5493b);
                } else {
                    this.f5498g.G(this.f5497f, this.f5496e, this.f5492a, this.f5493b, this.f5495d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f5499a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f5500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5501c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5502d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f5503e;

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
            this.f5503e = hVar;
            this.f5499a = list;
            this.f5500b = activity;
            this.f5501c = callbackHandler;
            this.f5502d = str;
        }

        @Override // c.a.p0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                c.a.p0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
                if (z) {
                    this.f5503e.H(this.f5499a, this.f5500b, this.f5501c, this.f5502d);
                } else {
                    c.a.p0.a.e2.c.d.n(10004, this.f5501c, this.f5502d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f5504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f5505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5506g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5507h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f5508i;

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
            this.f5508i = hVar;
            this.f5504e = list;
            this.f5505f = activity;
            this.f5506g = callbackHandler;
            this.f5507h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5508i.I(TextUtils.equals(str, "1"), this.f5504e, this.f5505f, this.f5506g, this.f5507h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f5510f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5511g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5512h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f5513i;

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
            this.f5513i = hVar;
            this.f5509e = activity;
            this.f5510f = list;
            this.f5511g = callbackHandler;
            this.f5512h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f5513i.J(this.f5509e, this.f5510f, this.f5511g, this.f5512h);
                } else {
                    c.a.p0.a.e2.c.d.n(10003, this.f5511g, this.f5512h);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f5514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f5515f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5516g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5517h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f5518i;

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
            this.f5518i = hVar;
            this.f5514e = list;
            this.f5515f = activity;
            this.f5516g = callbackHandler;
            this.f5517h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    this.f5518i.H(this.f5514e, this.f5515f, this.f5516g, this.f5517h);
                } else {
                    c.a.p0.a.e2.c.d.n(10003, this.f5516g, this.f5517h);
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
        public final /* synthetic */ CallbackHandler f5519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5520f;

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
            this.f5519e = callbackHandler;
            this.f5520f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    c.a.p0.a.e2.c.d.n(10001, this.f5519e, this.f5520f);
                    k.p(10001, null);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f5590a);
                if (b2 != 0) {
                    c.a.p0.a.e2.c.d.n(b2, this.f5519e, this.f5520f);
                } else {
                    this.f5519e.handleSchemeDispatchCallback(this.f5520f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f5521e;

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
            this.f5521e = jVar;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f5521e.a(false, i2);
                } else {
                    this.f5521e.a(true, i2);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f5547b, "mapp_location") || TextUtils.equals(fVar.f5547b, "mapp_images") || TextUtils.equals(fVar.f5547b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f5547b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f5547b, "ppcert") || TextUtils.equals(fVar.f5547b, "mapp_i_face_verify") || TextUtils.equals(fVar.f5547b, "snsapi_userinfo") || TextUtils.equals(fVar.f5547b, "mapp_choose_address") || TextUtils.equals(fVar.f5547b, "mobile") || TextUtils.equals(fVar.f5547b, "mapp_choose_invoice") : invokeL.booleanValue;
    }

    public final boolean C(c.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f5547b, "ppcert") || TextUtils.equals(fVar.f5547b, "mapp_i_face_verify") : invokeL.booleanValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f5547b, "mapp_location") || TextUtils.equals(fVar.f5547b, "mapp_images") || TextUtils.equals(fVar.f5547b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f5547b, PermissionProxy.SCOPE_ID_CAMERA) : invokeL.booleanValue;
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
                strArr[i2] = list.get(i2).f5547b;
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
                    } else if (fVar.f5549d) {
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
            } else if (fVar.f5549d) {
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
