package c.a.o0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/getInfo");
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
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    c.a.o0.a.e0.d.b("fileInfo", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString = optParamsAsJo.optString("filePath");
                if (c.a.o0.a.k2.b.s(optString) == PathType.BD_FILE) {
                    L = c.a.o0.a.k2.b.M(optString, c.a.o0.a.a2.e.V());
                } else {
                    L = c.a.o0.a.k2.b.s(optString) == PathType.RELATIVE ? c.a.o0.a.k2.b.L(optString, eVar, eVar.Z()) : "";
                }
                if (a0.f4738b) {
                    String str = "——> handle: fileUrl " + optString;
                    String str2 = "——> handle: filePath " + L;
                }
                if (TextUtils.isEmpty(L)) {
                    c.a.o0.a.e0.d.b("fileInfo", "absolute filePath is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                File file = new File(L);
                String b2 = c.a.o0.a.v2.o.b(TextUtils.equals(optParamsAsJo.optString("digestAlgorithm", PackageTable.MD5), PackageTable.MD5) ? "MD5" : "SHA-1", file, false);
                if (TextUtils.isEmpty(b2)) {
                    c.a.o0.a.e0.d.b("fileInfo", "hash is null");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, c.a.o0.a.c2.b.a(2001)));
                    boolean z = a0.f4738b;
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(LightappBusinessClient.MTD_DIGEST, b2);
                    jSONObject.put("size", file.length());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, c.a.o0.a.c2.b.a(2003)));
                    boolean z2 = a0.f4738b;
                    return false;
                }
            }
            c.a.o0.a.e0.d.b("fileInfo", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
