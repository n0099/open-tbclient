package b.a.p0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.c2.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
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
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        boolean n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            String l = l("insert");
            String l2 = l("update");
            String l3 = l("remove");
            if (TextUtils.equals(l, str)) {
                n = m(context, unitedSchemeEntity, callbackHandler, str, eVar);
            } else if (TextUtils.equals(l2, str)) {
                n = p(context, unitedSchemeEntity, callbackHandler, str, eVar);
            } else if (TextUtils.equals(l3, str)) {
                n = o(context, unitedSchemeEntity, callbackHandler, str, eVar);
            } else {
                n = n(context, unitedSchemeEntity, callbackHandler, str, eVar);
            }
            b.a.p0.a.e0.d.a("AbsSwanAppWidget", "subAction = " + str + " ; handle result = " + n);
            return n;
        }
        return invokeLLLLL.booleanValue;
    }

    @NonNull
    public abstract String j();

    public JSONObject k(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                b.a.p0.a.e0.d.b("AbsSwanAppWidget", "getParamsJSONObject entity is null");
                return null;
            }
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                b.a.p0.a.e0.d.b("AbsSwanAppWidget", "getParamsJSONObject paramsJson is empty");
                return null;
            }
            try {
                return new JSONObject(param);
            } catch (JSONException e2) {
                b.a.p0.a.e0.d.b("AbsSwanAppWidget", "getParamsJSONObject exception = " + e2.getMessage());
                if (a0.f4160b) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return j() + "/" + str;
        }
        return (String) invokeL.objValue;
    }

    public abstract boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar);

    public boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) ? super.i(context, unitedSchemeEntity, callbackHandler, str, eVar) : invokeLLLLL.booleanValue;
    }

    public abstract boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar);

    public abstract boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar);
}
