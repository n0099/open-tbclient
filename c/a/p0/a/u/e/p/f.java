package c.a.p0.a.u.e.p;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.i2.a;
import c.a.p0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.p0.a.u.e.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8444f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f8446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f8447g;

        public a(f fVar, String str, c.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8447g = fVar;
            this.f8445e = str;
            this.f8446f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    boolean unused = f.f8444f;
                    this.f8447g.A(this.f8446f.x(), this.f8446f);
                    this.f8447g.d(this.f8445e, new c.a.p0.a.u.h.b(0));
                    return;
                }
                int b2 = iVar.b();
                this.f8447g.d(this.f8445e, new c.a.p0.a.u.h.b(b2, c.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a.i2.a.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                f.C(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123530959, "Lc/a/p0/a/u/e/p/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123530959, "Lc/a/p0/a/u/e/p/f;");
                return;
            }
        }
        f8444f = c.a.p0.a.k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public static void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            c.a.p0.a.n2.s.f fVar = new c.a.p0.a.n2.s.f();
            c.a.p0.a.d2.d J = c.a.p0.a.d2.d.J();
            String appId = J.getAppId();
            String n = n.n(J.l());
            fVar.f7117f = appId;
            fVar.f7113b = RetrieveTaskManager.KEY;
            fVar.a = n;
            fVar.f7116e = "addshortcut";
            b.a V = J.r().V();
            if (V != null) {
                fVar.f7114c = V.T();
            }
            fVar.a("appid", appId);
            fVar.a("resultstate", Integer.valueOf(i2));
            c.a.p0.a.n2.d.b(fVar);
        }
    }

    public final void A(@NonNull Context context, @NonNull c.a.p0.a.d2.e eVar) {
        b.a X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, eVar) == null) || (X = eVar.X()) == null) {
            return;
        }
        c.a.p0.a.i2.a.k(context, X, new b(this));
    }

    public c.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#addToDesktop", false);
            if (f8444f) {
                String str2 = "#addToDesktop params = " + str;
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.p0.a.u.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(202, "cb is empty");
                }
                c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    return new c.a.p0.a.u.h.b(1001, "the context is not an activity");
                }
                a0.d0().g(context, "scope_add_to_desktop", new a(this, optString, a0));
                return c.a.p0.a.u.h.b.f();
            }
            return (c.a.p0.a.u.h.b) s.first;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }
}
