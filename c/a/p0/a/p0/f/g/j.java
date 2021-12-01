package c.a.p0.a.p0.f.g;

import android.content.Context;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h2.c.j.b;
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
public class j extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7378f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7379g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f7380h;

        public a(j jVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, callbackHandler, unitedSchemeEntity, jSONObject, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7377e = callbackHandler;
            this.f7378f = unitedSchemeEntity;
            this.f7379g = jSONObject;
            this.f7380h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.h2.c.d.h(iVar)) {
                    c.a.p0.a.h2.c.d.p(iVar, this.f7377e, this.f7378f);
                    return;
                }
                boolean b2 = c.a.p0.a.p0.f.a.b(this.f7379g.optInt("useExtension"));
                if (b2 && !c.a.p0.a.p0.f.d.b().exists()) {
                    c.a.p0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.p0.a.h.aiapps_debug_no_extension_core).G();
                    this.f7378f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f7380h.getResources().getString(c.a.p0.a.h.aiapps_debug_no_extension_core));
                    return;
                }
                c.a.p0.a.x1.a.a.V(b2);
                UnitedSchemeUtility.callCallback(this.f7377e, this.f7378f, UnitedSchemeUtility.wrapCallbackParams(0));
                c.a.p0.a.x1.a.a.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(c.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/debug/setExtensionConfig");
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.p0.a.e0.d.c("ExtCore-SetConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.has("useExtension")) {
                c.a.p0.a.e0.d.c("ExtCore-SetConfig", "useExtension is null");
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
