package b.a.p0.a.u.e.p;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.f2.a;
import b.a.p0.a.k;
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
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8382d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8385g;

        public a(b bVar, String str, b.a.p0.a.a2.e eVar) {
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
            this.f8385g = bVar;
            this.f8383e = str;
            this.f8384f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    boolean unused = b.f8382d;
                    this.f8385g.t(this.f8384f.x(), this.f8384f);
                    this.f8385g.d(this.f8383e, new b.a.p0.a.u.h.b(0));
                    return;
                }
                int b2 = iVar.b();
                this.f8385g.d(this.f8383e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0415b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0415b(b bVar) {
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

        @Override // b.a.p0.a.f2.a.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.v(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229778862, "Lb/a/p0/a/u/e/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229778862, "Lb/a/p0/a/u/e/p/b;");
                return;
            }
        }
        f8382d = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            String appId = g2.getAppId();
            String m = b.a.p0.a.j2.k.m(g2.l());
            fVar.f6388f = appId;
            fVar.f6384b = RetrieveTaskManager.KEY;
            fVar.f6383a = m;
            fVar.f6387e = "addshortcut";
            b.a K = g2.r().K();
            if (K != null) {
                fVar.f6385c = K.S();
            }
            fVar.a("appid", appId);
            fVar.a("resultstate", Integer.valueOf(i2));
            b.a.p0.a.j2.d.b(fVar);
        }
    }

    public final void t(@NonNull Context context, @NonNull b.a.p0.a.a2.e eVar) {
        b.a M;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, eVar) == null) || (M = eVar.M()) == null) {
            return;
        }
        b.a.p0.a.f2.a.k(context, M, new C0415b(this));
    }

    public b.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (f8382d) {
                String str2 = "start addToDesktop action, params = " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-AddToDesktop", str);
            if (!((b.a.p0.a.u.h.b) b2.first).isSuccess()) {
                b.a.p0.a.e0.d.b("Api-AddToDesktop", "parse failed, params = " + str);
                return (b.a.p0.a.u.h.b) b2.first;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (f8382d) {
                String str3 = "cb: " + optString;
            }
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(202, "cb is required");
            }
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            Context context = getContext();
            if (!(context instanceof Activity) && (context = P.x()) == null) {
                return new b.a.p0.a.u.h.b(1001, "the context is not an activity");
            }
            P.S().g(context, "scope_add_to_desktop", new a(this, optString, P));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
