package c.a.n0.j.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.x.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f8736b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.o.b.a f8737c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f8738d;

        public a(f fVar, boolean z, Context context, c.a.n0.a.o.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Boolean.valueOf(z), context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8738d = fVar;
            this.a = z;
            this.f8736b = context;
            this.f8737c = aVar;
        }

        @Override // c.a.n0.a.x.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.f8738d.g(this.f8736b, this.f8737c);
                        return;
                    }
                    c.a.n0.a.u.a.c(this.f8736b, false);
                    this.f8738d.e(this.f8737c, true, "setEnableDebug:ok");
                    return;
                }
                c.a.n0.a.x.e.c.c(this.f8736b, str);
                f fVar = this.f8738d;
                fVar.e(this.f8737c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.n0.a.p2.g1.c<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.o.b.a f8739b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f8740c;

        public b(f fVar, Context context, c.a.n0.a.o.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8740c = fVar;
            this.a = context;
            this.f8739b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    c.a.n0.a.u.a.c(this.a, true);
                    this.f8740c.e(this.f8739b, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.a, null);
                this.f8740c.e(this.f8739b, false, "internet error");
            }
        }
    }

    public f(c.a.n0.a.b0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void h(JSONObject jSONObject) {
        c.a.n0.a.t1.e L;
        SwanAppActivity x;
        c.a.n0.a.b0.a g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (L = c.a.n0.a.t1.e.L()) == null || !L.v0() || (x = L.x()) == null) {
            return;
        }
        c.a.n0.a.j0.c frame = x.getFrame();
        if ((frame instanceof c.a.n0.j.o.d) && (g1 = ((c.a.n0.j.o.d) frame).g1()) != null) {
            g1.dispatchEvent(c.a.n0.j.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull c.a.n0.a.t1.e eVar, @NonNull Context context, @NonNull c.a.n0.a.o.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            c.a.n0.a.x.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(c.a.n0.a.o.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            c.a.n0.j.d.c.b bVar = new c.a.n0.j.d.c.b();
            bVar.errMsg = str;
            c.a.n0.j.n0.c.call(aVar, z, bVar);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, c.a.n0.a.o.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            d.m().o(new b(this, context, aVar));
        }
    }

    public void i(JsObject jsObject) {
        c.a.n0.a.o.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = c.a.n0.a.o.b.a.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
        if (L == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = L.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == c.a.n0.a.u.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(L, x, F, l);
        }
    }
}
