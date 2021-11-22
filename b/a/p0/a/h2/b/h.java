package b.a.p0.a.h2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.n2.n;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/login");
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.m0()) {
                boolean z = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                b.a.p0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    b.a.p0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                    b.a.p0.a.u.e.a.d.J(eVar, 1, 201, "params is null");
                    return false;
                }
                String optString = optParamsAsJo.optString("invokeFrom");
                String str = optString.equals("component") ? "loginButton" : "loginApi";
                n.T(str, "create");
                String optString2 = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    b.a.p0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    b.a.p0.a.u.e.a.d.J(eVar, 1, 201, "empty cb");
                    return false;
                } else if (!optParamsAsJo.optBoolean(TTDownloadField.TT_FORCE, true) && !eVar.M().e(context)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    b.a.p0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    b.a.p0.a.u.e.a.d.J(eVar, 43, 10004, "user not logged in");
                    return true;
                } else {
                    if (!eVar.M().e(context)) {
                        n.S("show", 1, optString);
                    }
                    if (!b.a.p0.a.d2.d.J().r().M().e(context)) {
                        n.T(str, "passLogin");
                    }
                    b.a.p0.a.u.e.a.d.D(eVar, (Activity) context, optParamsAsJo, callbackHandler, optString2, true, str);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
