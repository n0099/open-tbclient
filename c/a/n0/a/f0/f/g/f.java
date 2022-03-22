package c.a.n0.a.f0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x.u.g;
import c.a.n0.a.x1.c.j.b;
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
    public static class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4376b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4377c;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f4376b = unitedSchemeEntity;
            this.f4377c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.x1.c.d.h(iVar)) {
                    c.a.n0.a.x1.c.d.p(iVar, this.a, this.f4376b);
                    return;
                }
                if (this.f4377c.has("emitLive")) {
                    c.a.n0.a.n1.a.a.Q(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitLive")));
                }
                if (this.f4377c.has("emitHttps")) {
                    c.a.n0.a.n1.a.a.N(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitHttps")));
                }
                if (this.f4377c.has("emitDomain")) {
                    c.a.n0.a.n1.a.a.T(!c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitDomain")));
                    c.a.n0.a.n1.a.a.W(!c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitDomain")));
                }
                if (this.f4377c.has("emitWss")) {
                    c.a.n0.a.n1.a.a.P(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitWss")));
                }
                if (this.f4377c.has("emitLaunchMode")) {
                    c.a.n0.a.n1.a.a.U(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitLaunchMode")));
                }
                if (this.f4377c.has("debugEnvData")) {
                    c.a.n0.a.n1.a.a.K(this.f4377c.optString("debugEnvData"));
                }
                if (this.f4377c.has("emitReplaceJsNative")) {
                    c.a.n0.a.n1.a.a.O(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("emitReplaceJsNative")));
                }
                if (this.f4377c.has("emitReplaceV8Core")) {
                    g.v.e(g.v.b(this.f4377c.optInt("emitReplaceV8Core")));
                }
                if (this.f4377c.has("emitHostEnv")) {
                    c.a.n0.a.n1.a.a.S(this.f4377c.optInt("emitHostEnv"));
                }
                if (this.f4377c.has("openStabilityCollector")) {
                    c.a.n0.a.f0.f.f.b(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("openStabilityCollector")));
                }
                if (this.f4377c.has("openPerformanceTesting")) {
                    c.a.n0.a.f0.f.e.b(c.a.n0.a.f0.f.a.b(this.f4377c.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.a, this.f4376b, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.n0.a.n1.a.a.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/debug/setDebugConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, JSONObject jSONObject) {
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
            if (!z.f6924b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                c.a.n0.a.u.d.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    c.a.n0.a.n1.a.a.N(c.a.n0.a.f0.f.a.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    c.a.n0.a.n1.a.a.P(c.a.n0.a.f0.f.a.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    c.a.n0.a.n1.a.a.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.n0.a.n1.a.a.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.n0.a.u.d.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            if (optJSONObject == null) {
                c.a.n0.a.u.d.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int l = c.a.n0.a.t1.d.J().l();
            if (l != 0) {
                if (l != 1) {
                    c.a.n0.a.u.d.c("setDebugConfig", "frame type error");
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
