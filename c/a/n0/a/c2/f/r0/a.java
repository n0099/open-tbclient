package c.a.n0.a.c2.f.r0;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.e2.c.i;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.h0.g.g;
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

    /* renamed from: c.a.n0.a.c2.f.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0134a implements c.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4808f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f4809g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f4810h;

        public C0134a(a aVar, CallbackHandler callbackHandler, d dVar, c.a.n0.a.p.e.b bVar) {
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
            this.f4810h = aVar;
            this.f4807e = callbackHandler;
            this.f4808f = dVar;
            this.f4809g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.e2.c.d.h(iVar)) {
                    c.a.n0.a.e2.c.d.p(iVar, this.f4807e, this.f4808f.f4386i);
                    this.f4808f.o = null;
                } else {
                    d dVar = this.f4808f;
                    dVar.q = false;
                    this.f4810h.m(this.f4807e, (SwanAppSlaveManager) this.f4809g, dVar);
                }
                if (this.f4809g.x(this.f4808f)) {
                    this.f4810h.o();
                    return;
                }
                c.a.n0.a.e0.d.b("insertWebView", "insert webview widget fail");
                this.f4807e.handleSchemeDispatchCallback(this.f4808f.f4386i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.c2.e eVar) {
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
                super((c.a.n0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4492b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            d j2 = d.j(unitedSchemeEntity);
            if (!j2.isValid()) {
                c.a.n0.a.e0.d.b("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(j2.n) && l(j2.n, j2.r)) {
                c.a.n0.a.e0.d.b("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                c.a.n0.a.p.e.b bVar = (c.a.n0.a.p.e.b) c.a.n0.a.g1.f.V().B(j2.f4384g);
                if (bVar == null) {
                    c.a.n0.a.e0.d.b("insertWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(j2.p, "quickPass")) {
                    eVar.T().g(context, "scope_webview_extra_operation", new C0134a(this, callbackHandler, j2, bVar));
                } else if (!bVar.x(j2)) {
                    c.a.n0.a.e0.d.b("insertWebView", "insert webview widget fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    o();
                }
                c.a.n0.a.e0.d.g("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o() {
        g W;
        c.a.n0.a.h0.g.f o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (W = c.a.n0.a.g1.f.V().W()) == null || (o = W.o()) == null) {
            return;
        }
        c.a.n0.a.e0.d.g("insertWebView", "disable navigationStyle custom");
        o.V2();
    }
}
