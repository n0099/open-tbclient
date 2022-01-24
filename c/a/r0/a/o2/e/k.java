package c.a.r0.a.o2.e;

import android.content.Context;
import android.text.TextUtils;
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
public class k extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/file/save");
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
            if (context != null && callbackHandler != null && eVar != null && eVar.e0() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    c.a.r0.a.e0.d.c("saveFile", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String M = c.a.r0.a.o2.b.M(optParamsAsJo.optString("tempFilePath"), eVar.getAppId());
                if (z.f6343b) {
                    String str = "——> handle: tempFileUrl " + optParamsAsJo.optString("tempFilePath");
                    String str2 = "——> handle: tempFilePath " + M;
                }
                if (TextUtils.isEmpty(M)) {
                    c.a.r0.a.e0.d.c("saveFile", "temp file path is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                int a = eVar.e0().a(M);
                if (z.f6343b) {
                    String str3 = "——> handle: statusCode " + a;
                }
                if (a > 2000) {
                    c.a.r0.a.e0.d.c("saveFile", "file path status code : " + a);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a, c.a.r0.a.f2.b.a(a)));
                    return false;
                }
                String o = eVar.e0().o(M);
                if (TextUtils.isEmpty(o)) {
                    c.a.r0.a.e0.d.c("saveFile", "save file path is null");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, c.a.r0.a.f2.b.a(2003)));
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("savedFilePath", c.a.r0.a.o2.b.J(o, c.a.r0.a.d2.e.f0()));
                    if (z.f6343b) {
                        String str4 = "——> handle: saveFilePath saveFilePath " + o + " update saveFilePath " + jSONObject.get("savedFilePath");
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException unused) {
                    c.a.r0.a.e0.d.o("saveFile", "save file path to scheme fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
            c.a.r0.a.e0.d.c("saveFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
