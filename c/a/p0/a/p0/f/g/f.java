package c.a.p0.a.p0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.h2.c.j.b;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7347e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7348f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7349g;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7347e = callbackHandler;
            this.f7348f = unitedSchemeEntity;
            this.f7349g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.h2.c.d.h(iVar)) {
                    c.a.p0.a.h2.c.d.p(iVar, this.f7347e, this.f7348f);
                    return;
                }
                if (this.f7349g.has("emitLive")) {
                    c.a.p0.a.x1.a.a.Q(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitLive")));
                }
                if (this.f7349g.has("emitHttps")) {
                    c.a.p0.a.x1.a.a.N(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitHttps")));
                }
                if (this.f7349g.has("emitDomain")) {
                    c.a.p0.a.x1.a.a.T(!c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitDomain")));
                    c.a.p0.a.x1.a.a.W(!c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitDomain")));
                }
                if (this.f7349g.has("emitWss")) {
                    c.a.p0.a.x1.a.a.P(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitWss")));
                }
                if (this.f7349g.has("emitLaunchMode")) {
                    c.a.p0.a.x1.a.a.U(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitLaunchMode")));
                }
                if (this.f7349g.has("debugEnvData")) {
                    c.a.p0.a.x1.a.a.K(this.f7349g.optString("debugEnvData"));
                }
                if (this.f7349g.has("emitReplaceJsNative")) {
                    c.a.p0.a.x1.a.a.O(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("emitReplaceJsNative")));
                }
                if (this.f7349g.has("emitReplaceV8Core")) {
                    g.v.e(g.v.b(this.f7349g.optInt("emitReplaceV8Core")));
                }
                if (this.f7349g.has("emitHostEnv")) {
                    c.a.p0.a.x1.a.a.S(this.f7349g.optInt("emitHostEnv"));
                }
                if (this.f7349g.has("openStabilityCollector")) {
                    c.a.p0.a.p0.f.f.b(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("openStabilityCollector")));
                }
                if (this.f7349g.has("openPerformanceTesting")) {
                    c.a.p0.a.p0.f.e.b(c.a.p0.a.p0.f.a.b(this.f7349g.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.f7347e, this.f7348f, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.p0.a.x1.a.a.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.p0.a.f2.e eVar) {
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

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, unitedSchemeEntity, callbackHandler, eVar, jSONObject)) == null) {
            eVar.d0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, unitedSchemeEntity, callbackHandler, jSONObject, jSONObject2)) == null) {
            if (!z.f5296b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                c.a.p0.a.e0.d.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    c.a.p0.a.x1.a.a.N(c.a.p0.a.p0.f.a.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    c.a.p0.a.x1.a.a.P(c.a.p0.a.p0.f.a.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    c.a.p0.a.x1.a.a.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.p0.a.x1.a.a.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.p0.a.e0.d.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            if (optJSONObject == null) {
                c.a.p0.a.e0.d.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int l = c.a.p0.a.d2.d.J().l();
            if (l != 0) {
                if (l != 1) {
                    c.a.p0.a.e0.d.c("setDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                return k(unitedSchemeEntity, callbackHandler, a2, optJSONObject);
            }
            return j(context, unitedSchemeEntity, callbackHandler, eVar, optJSONObject);
        }
        return invokeLLLL.booleanValue;
    }
}
