package c.a.p0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.f.a0;
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
public class k extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.p0.a.c2.e eVar) {
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    c.a.p0.a.e0.d.b("saveFile", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String M = c.a.p0.a.k2.b.M(optParamsAsJo.optString("tempFilePath"), eVar.getAppId());
                if (a0.f4774b) {
                    String str = "——> handle: tempFileUrl " + optParamsAsJo.optString("tempFilePath");
                    String str2 = "——> handle: tempFilePath " + M;
                }
                if (TextUtils.isEmpty(M)) {
                    c.a.p0.a.e0.d.b("saveFile", "temp file path is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                int a2 = eVar.U().a(M);
                if (a0.f4774b) {
                    String str3 = "——> handle: statusCode " + a2;
                }
                if (a2 > 2000) {
                    c.a.p0.a.e0.d.b("saveFile", "file path status code : " + a2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, c.a.p0.a.c2.b.a(a2)));
                    return false;
                }
                String o = eVar.U().o(M);
                if (TextUtils.isEmpty(o)) {
                    c.a.p0.a.e0.d.b("saveFile", "save file path is null");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, c.a.p0.a.c2.b.a(2003)));
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("savedFilePath", c.a.p0.a.k2.b.J(o, c.a.p0.a.a2.e.V()));
                    if (a0.f4774b) {
                        String str4 = "——> handle: saveFilePath saveFilePath " + o + " update saveFilePath " + jSONObject.get("savedFilePath");
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException unused) {
                    c.a.p0.a.e0.d.l("saveFile", "save file path to scheme fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
            c.a.p0.a.e0.d.b("saveFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
