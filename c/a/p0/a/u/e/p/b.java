package c.a.p0.a.u.e.p;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.e2.c.i;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f2.a;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f9123d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9125f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f9126g;

        public a(b bVar, String str, c.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9126g = bVar;
            this.f9124e = str;
            this.f9125f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    boolean unused = b.f9123d;
                    this.f9126g.u(this.f9125f.x(), this.f9125f);
                    this.f9126g.d(this.f9124e, new c.a.p0.a.u.h.b(0));
                    return;
                }
                int b2 = iVar.b();
                this.f9126g.d(this.f9124e, new c.a.p0.a.u.h.b(b2, c.a.p0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0420b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0420b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a.f2.a.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.w(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123530835, "Lc/a/p0/a/u/e/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123530835, "Lc/a/p0/a/u/e/p/b;");
                return;
            }
        }
        f9123d = k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) {
            c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
            c.a.p0.a.a2.d g2 = c.a.p0.a.a2.d.g();
            String appId = g2.getAppId();
            String m = c.a.p0.a.j2.k.m(g2.l());
            fVar.f7068f = appId;
            fVar.f7064b = RetrieveTaskManager.KEY;
            fVar.f7063a = m;
            fVar.f7067e = "addshortcut";
            b.a L = g2.r().L();
            if (L != null) {
                fVar.f7065c = L.T();
            }
            fVar.a("appid", appId);
            fVar.a("resultstate", Integer.valueOf(i2));
            c.a.p0.a.j2.d.b(fVar);
        }
    }

    public final void u(@NonNull Context context, @NonNull c.a.p0.a.a2.e eVar) {
        b.a N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, eVar) == null) || (N = eVar.N()) == null) {
            return;
        }
        c.a.p0.a.f2.a.k(context, N, new C0420b(this));
    }

    public c.a.p0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (f9123d) {
                String str2 = "start addToDesktop action, params = " + str;
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-AddToDesktop", str);
            if (!((c.a.p0.a.u.h.b) b2.first).isSuccess()) {
                c.a.p0.a.e0.d.b("Api-AddToDesktop", "parse failed, params = " + str);
                return (c.a.p0.a.u.h.b) b2.first;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (f9123d) {
                String str3 = "cb: " + optString;
            }
            if (TextUtils.isEmpty(optString)) {
                return new c.a.p0.a.u.h.b(202, "cb is required");
            }
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            Context i2 = i();
            if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
                return new c.a.p0.a.u.h.b(1001, "the context is not an activity");
            }
            Q.T().g(i2, "scope_add_to_desktop", new a(this, optString, Q));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
