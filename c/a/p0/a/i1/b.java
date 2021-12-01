package c.a.p0.a.i1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UnitedSchemeEntity a;

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f6320b;

    public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {unitedSchemeEntity, callbackHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = unitedSchemeEntity;
        this.f6320b = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, unitedSchemeEntity, callbackHandler)) == null) ? new b(unitedSchemeEntity, callbackHandler) : (b) invokeLL.objValue;
    }

    public void b(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            UnitedSchemeUtility.safeCallback(this.f6320b, this.a, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString(), str);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            UnitedSchemeUtility.safeCallback(this.f6320b, this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.a.result = UnitedSchemeUtility.wrapCallbackParams(i2);
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            UnitedSchemeEntity unitedSchemeEntity = this.a;
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(this.f6320b, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }
}
