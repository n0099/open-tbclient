package c.a.n0.a.h2.d.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.u.d;
import c.a.n0.a.v1.e;
import c.a.n0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
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
        super(eVar, "/swanAPI/brightness");
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

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("Brightness", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    @Override // c.a.n0.a.v1.f.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (z.f6924b) {
                Log.d("Brightness", "handleSubAction: " + unitedSchemeEntity.toString());
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (z.f6924b) {
                Log.i("Brightness", "handleSubAction params: " + unitedSchemeEntity.getParam("params"));
            }
            JSONObject jSONObject = null;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                d.c("brightness", "activity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            int i = 1001;
            char c2 = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != -1634890823) {
                if (hashCode != 1913219981) {
                    if (hashCode == 1913231513 && str.equals("/swanAPI/brightness/set")) {
                        c2 = 0;
                    }
                } else if (str.equals("/swanAPI/brightness/get")) {
                    c2 = 1;
                }
            } else if (str.equals("/swanAPI/brightness/keepScreenOn")) {
                c2 = 2;
            }
            if (c2 == 0) {
                if (optParamsAsJo == null) {
                    d.c("brightness", "paramsJson is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("value");
                float f2 = -1.0f;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        f2 = Float.parseFloat(optString);
                    } catch (Exception unused) {
                    }
                }
                if (f2 >= 0.0f && f2 <= 1.0f) {
                    c.a.n0.a.h2.d.b.a.c().e(activity, f2);
                    if (!z) {
                    }
                    return z;
                }
                i = 202;
                z = false;
                if (!z) {
                }
                return z;
            }
            if (c2 != 1) {
                if (c2 == 2) {
                    if (optParamsAsJo == null) {
                        d.c("brightness", "paramsJson is null");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                        return false;
                    }
                    try {
                        c.a.n0.a.h2.d.b.a.c().f(activity, optParamsAsJo.getBoolean("keepScreenOn"));
                    } catch (JSONException unused2) {
                    }
                }
                z = false;
            } else {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", c.a.n0.a.h2.d.b.a.c().a(activity));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (!z) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i);
            } else if (jSONObject != null) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            return z;
        }
        return invokeLLLLL.booleanValue;
    }
}
