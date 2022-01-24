package c.a.r0.j.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f11125b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f11126c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f11127d;

        public a(f fVar, boolean z, Context context, c.a.r0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Boolean.valueOf(z), context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11127d = fVar;
            this.a = z;
            this.f11125b = context;
            this.f11126c = aVar;
        }

        @Override // c.a.r0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.f11127d.g(this.f11125b, this.f11126c);
                        return;
                    }
                    c.a.r0.a.e0.a.c(this.f11125b, false);
                    this.f11127d.e(this.f11126c, true, "setEnableDebug:ok");
                    return;
                }
                c.a.r0.a.h0.e.c.c(this.f11125b, str);
                f fVar = this.f11127d;
                fVar.e(this.f11126c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.r0.a.z2.g1.c<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f11128e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f11129f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11130g;

        public b(f fVar, Context context, c.a.r0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11130g = fVar;
            this.f11128e = context;
            this.f11129f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    c.a.r0.a.e0.a.c(this.f11128e, true);
                    this.f11130g.e(this.f11129f, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.f11128e, null);
                this.f11130g.e(this.f11129f, false, "internet error");
            }
        }
    }

    public f(c.a.r0.a.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void h(JSONObject jSONObject) {
        c.a.r0.a.d2.e L;
        SwanAppActivity x;
        c.a.r0.a.l0.a g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (L = c.a.r0.a.d2.e.L()) == null || !L.v0() || (x = L.x()) == null) {
            return;
        }
        c.a.r0.a.t0.c frame = x.getFrame();
        if ((frame instanceof c.a.r0.j.o.d) && (g1 = ((c.a.r0.j.o.d) frame).g1()) != null) {
            g1.dispatchEvent(c.a.r0.j.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull c.a.r0.a.d2.e eVar, @NonNull Context context, @NonNull c.a.r0.a.y.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            c.a.r0.a.h0.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(c.a.r0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            c.a.r0.j.d.c.b bVar = new c.a.r0.j.d.c.b();
            bVar.errMsg = str;
            c.a.r0.j.n0.c.call(aVar, z, bVar);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, c.a.r0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            d.m().o(new b(this, context, aVar));
        }
    }

    public void i(JsObject jsObject) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
        if (L == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = L.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == c.a.r0.a.e0.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(L, x, F, l);
        }
    }
}
