package c.a.p0.a.t2.d;

import android.content.Context;
import c.a.p0.a.e0.d;
import c.a.p0.a.f2.e;
import c.a.p0.a.f2.f.z;
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
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(eVar, "/swanAPI/updateTextarea");
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
            if (z.f5296b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.i("UpdateTextAreaAction", "UpdateTextAreaAction updateParams: " + optParamsAsJo);
            String optString = optParamsAsJo.optString("slaveId");
            String optString2 = optParamsAsJo.optString("componentId");
            c.a.p0.a.c0.c.g.a aVar = (c.a.p0.a.c0.c.g.a) c.a.p0.a.c0.d.a.b(optString, optString2);
            if (aVar == null) {
                String str2 = "can't find textarea component:#" + optString2;
                d.c("UpdateTextAreaAction", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            c.a.p0.a.c0.c.g.b bVar = (c.a.p0.a.c0.c.g.b) aVar.l();
            bVar.h(optParamsAsJo);
            c.a.p0.a.c0.b.c update = aVar.update((c.a.p0.a.c0.c.g.a) bVar);
            if (!update.a()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.f4383b);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            aVar.U0(optString2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
