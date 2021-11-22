package b.a.p0.a.e0.g;

import android.content.Context;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.g1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public a f4681c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/perfCat");
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
            if (z.f5228b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (z.f5228b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            if (!z.f5228b) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(403));
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -322942229) {
                if (hashCode != 227833272) {
                    if (hashCode == 977180790 && str.equals("/swanAPI/perfCat/on")) {
                        c2 = 0;
                    }
                } else if (str.equals("/swanAPI/perfCat/off")) {
                    c2 = 1;
                }
            } else if (str.equals("/swanAPI/perfCat/duration")) {
                c2 = 2;
            }
            if (c2 == 0) {
                if (this.f4681c == null) {
                    this.f4681c = new a();
                }
                this.f4681c.h();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                b.a.p0.a.e0.d.i("SwanAppPropertyLogAction", " Start property log：");
                return true;
            } else if (c2 != 1) {
                if (c2 != 2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    return false;
                }
                if (optParamsAsJo == null) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202));
                } else {
                    if (this.f4681c != null) {
                        this.f4681c.g(optParamsAsJo.optInt("duration"));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                }
                return true;
            } else {
                JSONObject jSONObject = new JSONObject();
                a aVar = this.f4681c;
                if (aVar == null) {
                    b.a.p0.a.e0.d.c("SwanAppPropertyLogAction", "Property log never start");
                } else {
                    String i2 = aVar.i();
                    this.f4681c = null;
                    f.U().C();
                    try {
                        jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, f.U().C());
                        jSONObject.put("path", i2);
                    } catch (JSONException e2) {
                        if (z.f5228b) {
                            e2.printStackTrace();
                        }
                    }
                    if (z.f5228b) {
                        String str3 = "Video dispatch Params : " + jSONObject.toString();
                    }
                    b.a.p0.a.e0.d.i("SwanAppPropertyLogAction", "Stop property log");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
