package c.a.n0.a.i1.c.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.c2.e;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.e0.d;
import c.a.n0.a.i1.c.c;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/backgroundAudio");
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

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4492b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        c.a.n0.a.i1.c.a b2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f4492b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject j2 = j(unitedSchemeEntity.getParam("params"));
            if (j2 == null) {
                d.b("backgroundAudio", "param is null!");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            c E = eVar.E();
            if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
                b2 = c.a.n0.a.i1.c.a.b(j2, new c.a.n0.a.i1.c.a());
            } else {
                b2 = c.a.n0.a.i1.c.a.b(j2, E.q());
            }
            if (a0.f4492b) {
                String str3 = "subAction is : " + str;
            }
            JSONObject jSONObject = null;
            char c2 = 65535;
            switch (str.hashCode()) {
                case 312101659:
                    if (str.equals("/swanAPI/backgroundAudio/getParamsSync")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 335869926:
                    if (str.equals("/swanAPI/backgroundAudio/open")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 335895760:
                    if (str.equals("/swanAPI/backgroundAudio/play")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 335978516:
                    if (str.equals("/swanAPI/backgroundAudio/seek")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 335993246:
                    if (str.equals("/swanAPI/backgroundAudio/stop")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 820188005:
                    if (str.equals("/swanAPI/backgroundAudio/update")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1822525402:
                    if (str.equals("/swanAPI/backgroundAudio/pause")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    d.g("backgroundAudio", "open, audioId " + b2.f6299a);
                    E.z(b2, callbackHandler);
                    z = true;
                    break;
                case 1:
                    d.g("backgroundAudio", "update, audioId " + b2.f6299a);
                    E.K(b2);
                    z = true;
                    break;
                case 2:
                    d.g("backgroundAudio", "play, audioId " + b2.f6299a);
                    E.F();
                    z = true;
                    break;
                case 3:
                    d.g("backgroundAudio", "pause, audioId " + b2.f6299a);
                    E.A();
                    z = true;
                    break;
                case 4:
                    d.g("backgroundAudio", "seek, audioId " + b2.f6299a + " position " + b2.l);
                    E.G(b2.l);
                    z = true;
                    break;
                case 5:
                    d.g("backgroundAudio", "stop, audioId " + b2.f6299a);
                    E.J();
                    z = true;
                    break;
                case 6:
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(b2.m, E.t(b2.m));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException e2) {
                        d.b("backgroundAudio", "getParams error " + e2.toString());
                        if (a0.f4492b) {
                            e2.printStackTrace();
                            break;
                        }
                    }
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
            return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        return invokeLLLLL.booleanValue;
    }

    public final JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e2) {
                    if (a0.f4492b) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}
