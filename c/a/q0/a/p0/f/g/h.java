package c.a.q0.a.p0.f.g;

import android.content.Context;
import c.a.q0.a.f2.f.z;
import c.a.q0.a.h2.c.j.b;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f7681h;

        public a(h hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, unitedSchemeEntity, jSONObject, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7678e = callbackHandler;
            this.f7679f = unitedSchemeEntity;
            this.f7680g = jSONObject;
            this.f7681h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.q0.a.h2.c.d.h(iVar)) {
                    c.a.q0.a.h2.c.d.p(iVar, this.f7678e, this.f7679f);
                    return;
                }
                if (c.a.q0.a.p0.f.a.b(this.f7680g.optInt("emitReplaceDependency"))) {
                    if (c.a.q0.a.p0.f.b.l().isEmpty()) {
                        Context context = this.f7681h;
                        if (context == null) {
                            context = c.a.q0.a.c1.a.c();
                        }
                        String string = context.getResources().getString(c.a.q0.a.h.aiapps_debug_no_dependency);
                        c.a.q0.a.c2.b.f.e.g(context, string).G();
                        this.f7679f.result = UnitedSchemeUtility.wrapCallbackParams(1001, string);
                        return;
                    }
                    c.a.q0.a.p0.f.b.n(true);
                } else {
                    c.a.q0.a.p0.f.b.n(false);
                    c.a.q0.a.p0.f.b.c();
                }
                UnitedSchemeUtility.callCallback(this.f7678e, this.f7679f, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.q0.a.x1.a.a.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.q0.a.f2.e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceDependencyConfig");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.q0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.q0.a.e0.d.c("setReplaceDependencyConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.has("emitReplaceDependency")) {
                c.a.q0.a.e0.d.c("setReplaceDependencyConfig", "emitReplaceDependency is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                eVar.d0().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
