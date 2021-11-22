package b.a.p0.j.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f11113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f11114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f11115c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f11116d;

        public a(f fVar, boolean z, Context context, b.a.p0.a.y.b.a aVar) {
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
            this.f11116d = fVar;
            this.f11113a = z;
            this.f11114b = context;
            this.f11115c = aVar;
        }

        @Override // b.a.p0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f11113a) {
                        this.f11116d.g(this.f11114b, this.f11115c);
                        return;
                    }
                    b.a.p0.a.e0.a.c(this.f11114b, false);
                    this.f11116d.e(this.f11115c, true, "setEnableDebug:ok");
                    return;
                }
                b.a.p0.a.h0.e.c.c(this.f11114b, str);
                f fVar = this.f11116d;
                fVar.e(this.f11115c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.p0.a.z2.g1.c<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f11117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f11118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11119g;

        public b(f fVar, Context context, b.a.p0.a.y.b.a aVar) {
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
            this.f11119g = fVar;
            this.f11117e = context;
            this.f11118f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    b.a.p0.a.e0.a.c(this.f11117e, true);
                    this.f11119g.e(this.f11118f, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.f11117e, null);
                this.f11119g.e(this.f11118f, false, "internet error");
            }
        }
    }

    public f(b.a.p0.a.l0.c cVar) {
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
        b.a.p0.a.d2.e L;
        SwanAppActivity x;
        b.a.p0.a.l0.a g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (L = b.a.p0.a.d2.e.L()) == null || !L.v0() || (x = L.x()) == null) {
            return;
        }
        b.a.p0.a.t0.c frame = x.getFrame();
        if ((frame instanceof b.a.p0.j.o.d) && (g1 = ((b.a.p0.j.o.d) frame).g1()) != null) {
            g1.dispatchEvent(b.a.p0.j.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull b.a.p0.a.d2.e eVar, @NonNull Context context, @NonNull b.a.p0.a.y.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.h0.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(b.a.p0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            b.a.p0.j.d.c.b bVar = new b.a.p0.j.d.c.b();
            bVar.errMsg = str;
            b.a.p0.j.n0.c.call(aVar, z, bVar);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, b.a.p0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            d.m().o(new b(this, context, aVar));
        }
    }

    public void i(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
        if (L == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = L.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == b.a.p0.a.e0.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(L, x, F, l);
        }
    }
}
