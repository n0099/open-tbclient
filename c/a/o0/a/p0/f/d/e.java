package c.a.o0.a.p0.f.d;

import android.content.Context;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.h0.u.g;
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
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7919g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7917e = callbackHandler;
            this.f7918f = unitedSchemeEntity;
            this.f7919g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    c.a.o0.a.e2.c.d.o(iVar, this.f7917e, this.f7918f);
                    return;
                }
                if (this.f7919g.has("emitLive")) {
                    c.a.o0.a.u1.a.a.P(c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitLive")));
                }
                if (this.f7919g.has("emitHttps")) {
                    c.a.o0.a.u1.a.a.M(c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitHttps")));
                }
                if (this.f7919g.has("emitDomain")) {
                    c.a.o0.a.u1.a.a.R(!c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitDomain")));
                    c.a.o0.a.u1.a.a.U(!c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitDomain")));
                }
                if (this.f7919g.has("emitWss")) {
                    c.a.o0.a.u1.a.a.O(c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitWss")));
                }
                if (this.f7919g.has("emitLaunchMode")) {
                    c.a.o0.a.u1.a.a.S(c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitLaunchMode")));
                }
                if (this.f7919g.has("debugEnvData")) {
                    c.a.o0.a.u1.a.a.J(this.f7919g.optString("debugEnvData"));
                }
                if (this.f7919g.has("emitReplaceJsNative")) {
                    c.a.o0.a.u1.a.a.N(c.a.o0.a.p0.f.a.b(this.f7919g.optInt("emitReplaceJsNative")));
                }
                if (this.f7919g.has("emitReplaceV8Core")) {
                    g.t.e(g.t.b(this.f7919g.optInt("emitReplaceV8Core")));
                }
                UnitedSchemeUtility.callCallback(this.f7917e, this.f7918f, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.o0.a.u1.a.a.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setDebugConfig");
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
                c.a.o0.a.e0.d.b("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("config");
            if (optJSONObject == null) {
                c.a.o0.a.e0.d.b("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (c.a.o0.a.a2.d.g().l() == 0) {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, optJSONObject));
            } else if (c.a.o0.a.a2.d.g().l() == 1) {
                if (!a0.f4738b) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                    return false;
                } else if (!a2.optString("category").equals("swanGame")) {
                    c.a.o0.a.e0.d.b("setDebugConfig", "params is not swangame");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    if (optJSONObject.has("emitHttps")) {
                        c.a.o0.a.u1.a.a.M(c.a.o0.a.p0.f.a.b(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitWss")) {
                        c.a.o0.a.u1.a.a.O(c.a.o0.a.p0.f.a.b(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        c.a.o0.a.u1.a.a.J(optJSONObject.optString("debugEnvData"));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    c.a.o0.a.u1.a.a.X();
                }
            } else {
                c.a.o0.a.e0.d.b("setDebugConfig", "frame type error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
