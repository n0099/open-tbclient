package b.a.p0.a.z0;

import android.content.Context;
import b.a.p0.a.c2.f.a0;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/updateInput");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                b.a.p0.a.e0.d.b("updateInput", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                b.a.p0.a.e0.d.b("updateInput", "paramsJson is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.c0.c.f.b bVar = new b.a.p0.a.c0.c.f.b();
            try {
                bVar.a(optParamsAsJo);
            } catch (JSONException e2) {
                e2.printStackTrace();
                b.a.p0.a.e0.d.c("SwanAppAction", "model parse exception:", e2);
            }
            b.a.p0.a.c0.c.f.a aVar = (b.a.p0.a.c0.c.f.a) b.a.p0.a.c0.d.a.a(bVar);
            if (aVar == null) {
                b.a.p0.a.e0.d.b("updateInput", "input组件不存在");
                b.a.p0.a.e0.d.b("SwanAppAction", "can't find input component:#" + bVar.f4056f);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
                return false;
            }
            boolean a2 = aVar.update((b.a.p0.a.c0.c.f.a) bVar).a();
            if (a2) {
                b.a.p0.a.e0.d.g("updateInput", "update success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
            }
            return a2;
        }
        return invokeLLLL.booleanValue;
    }
}
