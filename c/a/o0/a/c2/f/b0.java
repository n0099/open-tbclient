package c.a.o0.a.c2.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b0 extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/checkAppInstalled");
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
                c.a.o0.a.e0.d.g("SwanCheckAppInstalledAction", "params parse error");
                return false;
            }
            String optString = a2.optString("name");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parameter error");
                c.a.o0.a.e0.d.g("SwanCheckAppInstalledAction", "packageName empty");
                return false;
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(optString, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                c.a.o0.a.e0.d.c("SwanCheckAppInstalledAction", e2.getMessage(), e2);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (packageInfo != null) {
                    jSONObject.put("hasApp", true);
                    jSONObject.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
                } else {
                    jSONObject.put("hasApp", false);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success"));
            } catch (JSONException e3) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e3.getMessage());
                c.a.o0.a.e0.d.c("SwanCheckAppInstalledAction", e3.getMessage(), e3);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
