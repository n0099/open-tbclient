package b.a.p0.h.f;

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
        public final /* synthetic */ boolean f10420a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f10421b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10422c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f10423d;

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
            this.f10423d = fVar;
            this.f10420a = z;
            this.f10421b = context;
            this.f10422c = aVar;
        }

        @Override // b.a.p0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f10420a) {
                        this.f10423d.g(this.f10421b, this.f10422c);
                        return;
                    }
                    b.a.p0.a.e0.a.c(this.f10421b, false);
                    this.f10423d.e(this.f10422c, true, "setEnableDebug:ok");
                    return;
                }
                b.a.p0.a.h0.e.c.c(this.f10421b, str);
                f fVar = this.f10423d;
                fVar.e(this.f10422c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.p0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f10424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f10426g;

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
            this.f10426g = fVar;
            this.f10424e = context;
            this.f10425f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    b.a.p0.a.e0.a.c(this.f10424e, true);
                    this.f10426g.e(this.f10425f, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.f10424e, null);
                this.f10426g.e(this.f10425f, false, "internet error");
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
        b.a.p0.a.a2.e i2;
        SwanAppActivity x;
        b.a.p0.a.l0.a W0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (i2 = b.a.p0.a.a2.e.i()) == null || !i2.l0() || (x = i2.x()) == null) {
            return;
        }
        b.a.p0.a.t0.c frame = x.getFrame();
        if ((frame instanceof b.a.p0.h.o.d) && (W0 = ((b.a.p0.h.o.d) frame).W0()) != null) {
            W0.i0(b.a.p0.h.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull b.a.p0.a.a2.e eVar, @NonNull Context context, @NonNull b.a.p0.a.y.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.h0.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(b.a.p0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            b.a.p0.h.d.c.b bVar = new b.a.p0.h.d.c.b();
            bVar.errMsg = str;
            b.a.p0.h.m0.c.call(aVar, z, bVar);
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
        b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
        if (i2 == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = i2.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == b.a.p0.a.e0.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(i2, x, F, l);
        }
    }
}
