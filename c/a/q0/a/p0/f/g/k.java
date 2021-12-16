package c.a.q0.a.p0.f.g;

import android.content.Context;
import c.a.q0.a.f2.f.z;
import c.a.q0.a.h2.c.j.b;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
public class k extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7692g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f7693h;

        public a(k kVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, callbackHandler, unitedSchemeEntity, jSONObject, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7690e = callbackHandler;
            this.f7691f = unitedSchemeEntity;
            this.f7692g = jSONObject;
            this.f7693h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.q0.a.h2.c.d.h(iVar)) {
                    c.a.q0.a.h2.c.d.p(iVar, this.f7690e, this.f7691f);
                    return;
                }
                boolean b2 = c.a.q0.a.p0.f.a.b(this.f7692g.optInt("emitReplaceSwanCore"));
                if (b2 && !c.a.q0.a.q2.b.c()) {
                    c.a.q0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.q0.a.h.aiapps_debug_no_swan_core).G();
                    this.f7691f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f7693h.getResources().getString(c.a.q0.a.h.aiapps_debug_no_swan_core));
                    return;
                }
                c.a.q0.a.x1.a.a.M(b2);
                UnitedSchemeUtility.callCallback(this.f7690e, this.f7691f, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.q0.a.x1.a.a.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.q0.a.f2.e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
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
                c.a.q0.a.e0.d.c("setReplaceSwanCoreConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.has("emitReplaceSwanCore")) {
                c.a.q0.a.e0.d.c("setReplaceSwanCoreConfig", "emitReplaceSwanCore is null");
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
