package c.a.r0.a.f2.f.q0;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
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

    /* renamed from: c.a.r0.a.f2.f.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0346a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6301e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f6302f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f6303g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6304h;

        public C0346a(a aVar, CallbackHandler callbackHandler, d dVar, c.a.r0.a.p.e.b bVar) {
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
            this.f6304h = aVar;
            this.f6301e = callbackHandler;
            this.f6302f = dVar;
            this.f6303g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.r0.a.h2.c.d.h(iVar)) {
                    c.a.r0.a.h2.c.d.q(iVar, this.f6301e, this.f6302f.f5453i);
                    this.f6302f.o = null;
                } else {
                    d dVar = this.f6302f;
                    dVar.q = false;
                    this.f6304h.m(this.f6301e, (SwanAppSlaveManager) this.f6303g, dVar);
                }
                if (this.f6303g.x(this.f6302f)) {
                    this.f6304h.o();
                    return;
                }
                c.a.r0.a.e0.d.c("insertWebView", "insert webview widget fail");
                this.f6301e.handleSchemeDispatchCallback(this.f6302f.f5453i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
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
                super((c.a.r0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6343b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            d i2 = d.i(unitedSchemeEntity);
            if (!i2.isValid()) {
                c.a.r0.a.e0.d.c("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(i2.n) && l(i2.n, i2.r)) {
                c.a.r0.a.e0.d.c("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                c.a.r0.a.p.e.b bVar = (c.a.r0.a.p.e.b) c.a.r0.a.g1.f.U().A(i2.f5451g);
                if (bVar == null) {
                    c.a.r0.a.e0.d.c("insertWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(i2.p, "quickPass")) {
                    eVar.d0().g(context, "scope_webview_extra_operation", new C0346a(this, callbackHandler, i2, bVar));
                } else if (!bVar.x(i2)) {
                    c.a.r0.a.e0.d.c("insertWebView", "insert webview widget fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    o();
                }
                c.a.r0.a.e0.d.i("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o() {
        g V;
        c.a.r0.a.h0.g.f o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (V = c.a.r0.a.g1.f.U().V()) == null || (o = V.o()) == null) {
            return;
        }
        c.a.r0.a.e0.d.i("insertWebView", "disable navigationStyle custom");
        o.e3();
    }
}
