package c.a.r0.a.r2.j;

import android.content.Context;
import android.provider.Settings;
import c.a.r0.a.e0.d;
import c.a.r0.a.f2.e;
import c.a.r0.a.f2.f.z;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/getAutoRotationSync");
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.c("getAutoRotationSync", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = z.f6343b;
                return false;
            } else if (context == null) {
                d.c("getAutoRotationSync", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                boolean z2 = z.f6343b;
                return false;
            } else {
                try {
                    int i2 = Settings.System.getInt(context.getApplicationContext().getContentResolver(), "accelerometer_rotation");
                    if (z.f6343b) {
                        String str = "getAutoRotationSync --- isRotateOn: " + i2;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("isRotateOn", i2 != 0);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException unused) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                        boolean z3 = z.f6343b;
                        return false;
                    }
                } catch (Exception e2) {
                    if (z.f6343b) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
