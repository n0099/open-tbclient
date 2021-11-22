package b.a.p0.a.o2.e;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.z;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/file/removeSavedFile");
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
            if (context != null && callbackHandler != null && eVar != null && eVar.e0() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    b.a.p0.a.e0.d.c("removeSavedFile", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String M = b.a.p0.a.o2.b.M(optParamsAsJo.optString("filePath"), b.a.p0.a.d2.e.f0());
                if (z.f5228b) {
                    String str = "——> handle: fileUrl " + optParamsAsJo.optString("filePath");
                    String str2 = "——> handle: filePath " + M;
                }
                if (z.f5228b) {
                    String str3 = "——> handle: filePath " + M;
                }
                if (TextUtils.isEmpty(M)) {
                    b.a.p0.a.e0.d.c("removeSavedFile", "file path is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                int a2 = eVar.e0().a(M);
                if (z.f5228b) {
                    String str4 = "——> handle: statusCode " + a2;
                }
                if (a2 > 2000) {
                    b.a.p0.a.e0.d.c("removeSavedFile", "file path status code : " + a2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, b.a.p0.a.f2.b.a(a2)));
                    return false;
                } else if (b.a.p0.w.d.k(M)) {
                    b.a.p0.a.e0.d.i("removeSavedFile", "file delete success");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    boolean z = z.f5228b;
                    return true;
                } else {
                    b.a.p0.a.e0.d.c("removeSavedFile", "file delete fail");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, b.a.p0.a.f2.b.a(2004)));
                    boolean z2 = z.f5228b;
                    return false;
                }
            }
            b.a.p0.a.e0.d.c("removeSavedFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
