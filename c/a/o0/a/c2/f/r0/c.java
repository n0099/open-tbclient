package c.a.o0.a.c2.f.r0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
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
public class c extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5057e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5058f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f5059g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f5060h;

        public a(c cVar, CallbackHandler callbackHandler, d dVar, c.a.o0.a.p.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5060h = cVar;
            this.f5057e = callbackHandler;
            this.f5058f = dVar;
            this.f5059g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    c.a.o0.a.e2.c.d.p(iVar, this.f5057e, this.f5058f.f4632i);
                    this.f5058f.o = null;
                } else {
                    d dVar = this.f5058f;
                    dVar.q = false;
                    this.f5060h.m(this.f5057e, (SwanAppSlaveManager) this.f5059g, dVar);
                }
                if (this.f5059g.W(this.f5058f)) {
                    return;
                }
                c.a.o0.a.e0.d.b("updateWebView", "update webview widget fail");
                this.f5057e.handleSchemeDispatchCallback(this.f5058f.f4632i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/updateWebView");
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
                super((c.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            d j2 = d.j(unitedSchemeEntity);
            if (!j2.isValid()) {
                c.a.o0.a.e0.d.b("updateWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(j2.n) && l(j2.n, j2.r)) {
                c.a.o0.a.e0.d.b("updateWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                c.a.o0.a.p.e.b bVar = (c.a.o0.a.p.e.b) c.a.o0.a.g1.f.V().B(j2.f4630g);
                if (bVar == null) {
                    c.a.o0.a.e0.d.b("updateWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(j2.p, "quickPass")) {
                    eVar.T().g(context, "scope_webview_extra_operation", new a(this, callbackHandler, j2, bVar));
                } else if (!bVar.W(j2)) {
                    c.a.o0.a.e0.d.b("updateWebView", "update webview widget fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
