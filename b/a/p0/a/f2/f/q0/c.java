package b.a.p0.a.f2.f.q0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
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
    public class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5192f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f5193g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f5194h;

        public a(c cVar, CallbackHandler callbackHandler, d dVar, b.a.p0.a.p.e.b bVar) {
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
            this.f5194h = cVar;
            this.f5191e = callbackHandler;
            this.f5192f = dVar;
            this.f5193g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.h2.c.d.h(iVar)) {
                    b.a.p0.a.h2.c.d.q(iVar, this.f5191e, this.f5192f.f4199i);
                    this.f5192f.o = null;
                } else {
                    d dVar = this.f5192f;
                    dVar.q = false;
                    this.f5194h.m(this.f5191e, (SwanAppSlaveManager) this.f5193g, dVar);
                }
                if (this.f5193g.Y(this.f5192f)) {
                    return;
                }
                b.a.p0.a.e0.d.c("updateWebView", "update webview widget fail");
                this.f5191e.handleSchemeDispatchCallback(this.f5192f.f4199i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.f2.e eVar) {
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
                super((b.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5228b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            d i2 = d.i(unitedSchemeEntity);
            if (!i2.isValid()) {
                b.a.p0.a.e0.d.c("updateWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(i2.n) && l(i2.n, i2.r)) {
                b.a.p0.a.e0.d.c("updateWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                b.a.p0.a.p.e.b bVar = (b.a.p0.a.p.e.b) b.a.p0.a.g1.f.U().A(i2.f4197g);
                if (bVar == null) {
                    b.a.p0.a.e0.d.c("updateWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(i2.p, "quickPass")) {
                    eVar.d0().g(context, "scope_webview_extra_operation", new a(this, callbackHandler, i2, bVar));
                } else if (!bVar.Y(i2)) {
                    b.a.p0.a.e0.d.c("updateWebView", "update webview widget fail");
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
