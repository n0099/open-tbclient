package c.a.p0.h.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f11222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f11223b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11224c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f11225d;

        public a(f fVar, boolean z, Context context, c.a.p0.a.y.b.a aVar) {
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
            this.f11225d = fVar;
            this.f11222a = z;
            this.f11223b = context;
            this.f11224c = aVar;
        }

        @Override // c.a.p0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f11222a) {
                        this.f11225d.g(this.f11223b, this.f11224c);
                        return;
                    }
                    c.a.p0.a.e0.a.c(this.f11223b, false);
                    this.f11225d.e(this.f11224c, true, "setEnableDebug:ok");
                    return;
                }
                c.a.p0.a.h0.e.c.c(this.f11223b, str);
                f fVar = this.f11225d;
                fVar.e(this.f11224c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.p0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f11226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11227f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11228g;

        public b(f fVar, Context context, c.a.p0.a.y.b.a aVar) {
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
            this.f11228g = fVar;
            this.f11226e = context;
            this.f11227f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    c.a.p0.a.e0.a.c(this.f11226e, true);
                    this.f11228g.e(this.f11227f, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.f11226e, null);
                this.f11228g.e(this.f11227f, false, "internet error");
            }
        }
    }

    public f(c.a.p0.a.l0.c cVar) {
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
        c.a.p0.a.a2.e i2;
        SwanAppActivity x;
        c.a.p0.a.l0.a X0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (i2 = c.a.p0.a.a2.e.i()) == null || !i2.m0() || (x = i2.x()) == null) {
            return;
        }
        c.a.p0.a.t0.c frame = x.getFrame();
        if ((frame instanceof c.a.p0.h.o.d) && (X0 = ((c.a.p0.h.o.d) frame).X0()) != null) {
            X0.S(c.a.p0.h.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull c.a.p0.a.a2.e eVar, @NonNull Context context, @NonNull c.a.p0.a.y.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            c.a.p0.a.h0.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(c.a.p0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            c.a.p0.h.d.c.b bVar = new c.a.p0.h.d.c.b();
            bVar.errMsg = str;
            c.a.p0.h.m0.c.a(aVar, z, bVar);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, c.a.p0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            d.m().o(new b(this, context, aVar));
        }
    }

    public void i(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        boolean m = G.m("enableDebug");
        c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
        if (i2 == null) {
            e(G, false, f("internal error"));
            return;
        }
        SwanAppActivity x = i2.x();
        if (x == null) {
            e(G, false, f("internal error"));
        } else if (m == c.a.p0.a.e0.a.a()) {
            e(G, true, "setEnableDebug:ok");
        } else {
            d(i2, x, G, m);
        }
    }
}
