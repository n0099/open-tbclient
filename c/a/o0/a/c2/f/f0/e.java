package c.a.o0.a.c2.f.f0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f4791e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f4792f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1582345400, "Lc/a/o0/a/c2/f/f0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1582345400, "Lc/a/o0/a/c2/f/f0/e;");
                return;
            }
        }
        f4791e = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
        f4792f = SchemeConfig.getSchemeHead() + "://swangame/%s";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFavor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.f0.b
    public boolean j(c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.o0.a.c2.f.f0.b
    public void k(c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONArray jSONArray = new JSONArray();
            List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
            if (i2.size() > 0) {
                for (SwanFavorItemData swanFavorItemData : i2) {
                    jSONArray.put(p(swanFavorItemData));
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("favors", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }

    public final JSONObject p(SwanFavorItemData swanFavorItemData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanFavorItemData)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", swanFavorItemData.getAppKey());
                jSONObject.put("type", swanFavorItemData.getAppType());
                jSONObject.put("iconUrl", swanFavorItemData.getIconUrl());
                jSONObject.put("title", swanFavorItemData.getAppName());
                jSONObject.put("frameType", swanFavorItemData.getAppFrameType());
                jSONObject.put("payProtected", swanFavorItemData.getPayProtected());
                if (swanFavorItemData.getAppFrameType() == 1) {
                    str = String.format(f4792f, swanFavorItemData.getAppKey());
                } else {
                    str = f4791e + swanFavorItemData.getAppKey() + "\"}";
                }
                jSONObject.put("scheme", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
