package c.a.o0.a.p0.f.d;

import android.content.Context;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.j.b;
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
public class g extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7941f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7942g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f7943h;

        public a(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, callbackHandler, unitedSchemeEntity, jSONObject, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7940e = callbackHandler;
            this.f7941f = unitedSchemeEntity;
            this.f7942g = jSONObject;
            this.f7943h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    c.a.o0.a.e2.c.d.o(iVar, this.f7940e, this.f7941f);
                    return;
                }
                if (c.a.o0.a.p0.f.a.b(this.f7942g.optInt("emitReplaceDynamicLib"))) {
                    if (c.a.o0.a.p0.f.b.n().isEmpty()) {
                        Context context = this.f7943h;
                        if (context == null) {
                            context = c.a.o0.a.c1.a.b();
                        }
                        String string = context.getResources().getString(c.a.o0.a.h.aiapps_debug_no_dynamic_lib);
                        c.a.o0.a.z1.b.f.e.g(context, string).F();
                        this.f7941f.result = UnitedSchemeUtility.wrapCallbackParams(1001, string);
                        return;
                    }
                    c.a.o0.a.p0.f.b.p();
                } else {
                    c.a.o0.a.p0.f.b.f();
                }
                UnitedSchemeUtility.callCallback(this.f7940e, this.f7941f, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.o0.a.u1.a.a.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceDynamicLibConfig");
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.o0.a.e0.d.b("setReplaceDynamicLibConfig", "'params' is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.has("emitReplaceDynamicLib")) {
                c.a.o0.a.e0.d.b("setReplaceDynamicLibConfig", "'emitReplaceSwanCore's is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
