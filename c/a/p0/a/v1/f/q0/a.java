package c.a.p0.a.v1.f.q0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.v1.f.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0511a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f8135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f8136g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8137h;

        public C0511a(a aVar, CallbackHandler callbackHandler, d dVar, c.a.p0.a.f.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8137h = aVar;
            this.f8134e = callbackHandler;
            this.f8135f = dVar;
            this.f8136g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.x1.c.d.h(iVar)) {
                    c.a.p0.a.x1.c.d.q(iVar, this.f8134e, this.f8135f.f7286i);
                    this.f8135f.o = null;
                } else {
                    d dVar = this.f8135f;
                    dVar.q = false;
                    this.f8137h.m(this.f8134e, (SwanAppSlaveManager) this.f8136g, dVar);
                }
                if (this.f8136g.x(this.f8135f)) {
                    this.f8137h.o();
                    return;
                }
                c.a.p0.a.u.d.c("insertWebView", "insert webview widget fail");
                this.f8134e.handleSchemeDispatchCallback(this.f8135f.f7286i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/insertWebView");
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
                super((c.a.p0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f8176b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            d i2 = d.i(unitedSchemeEntity);
            if (!i2.isValid()) {
                c.a.p0.a.u.d.c("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(i2.n) && l(i2.n, i2.r)) {
                c.a.p0.a.u.d.c("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                c.a.p0.a.f.e.b bVar = (c.a.p0.a.f.e.b) c.a.p0.a.w0.f.U().A(i2.f7284g);
                if (bVar == null) {
                    c.a.p0.a.u.d.c("insertWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(i2.p, "quickPass")) {
                    eVar.d0().g(context, "scope_webview_extra_operation", new C0511a(this, callbackHandler, i2, bVar));
                } else if (!bVar.x(i2)) {
                    c.a.p0.a.u.d.c("insertWebView", "insert webview widget fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    o();
                }
                c.a.p0.a.u.d.i("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o() {
        g V;
        c.a.p0.a.x.g.f o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (V = c.a.p0.a.w0.f.U().V()) == null || (o = V.o()) == null) {
            return;
        }
        c.a.p0.a.u.d.i("insertWebView", "disable navigationStyle custom");
        o.e3();
    }
}
