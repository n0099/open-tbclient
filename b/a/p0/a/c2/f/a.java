package b.a.p0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/abTestConfig");
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

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File a2 = b.a.p0.a.v2.l.a();
            if (a2 == null) {
                return null;
            }
            String path = a2.getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            return path + "/debug_abtest_config.json";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4160b) {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && context != null) {
                    JSONObject optJSONObject = a2.optJSONObject("abtest");
                    if (optJSONObject != null) {
                        Toast.makeText(context, l(optJSONObject) ? b.a.p0.a.h.swanapp_debug_abtest_config_success : b.a.p0.a.h.swanapp_debug_abtest_config_fail, 1).show();
                    } else {
                        j();
                        Toast.makeText(context, b.a.p0.a.h.swanapp_delete_debug_abtest_config, 1).show();
                    }
                    return true;
                }
                Toast.makeText(context, b.a.p0.a.h.swanapp_debug_abtest_config_params_empty, 1).show();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String k = k();
            if (TextUtils.isEmpty(k)) {
                return;
            }
            File file = new File(k);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final boolean l(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            String k = k();
            if (TextUtils.isEmpty(k)) {
                return false;
            }
            return b.a.p0.a.b1.a.b(k, jSONObject.toString(), false);
        }
        return invokeL.booleanValue;
    }
}
