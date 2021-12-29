package c.a.r0.a.f2;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class c extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(424192578, "Lc/a/r0/a/f2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(424192578, "Lc/a/r0/a/f2/c;");
                return;
            }
        }
        boolean z = k.a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "BDWallet" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            c.a.r0.a.e0.d.b("SwanWalletDispatcher", "entity uri = ", unitedSchemeEntity.getUri());
            c.a.r0.a.e0.d.i("SwanWalletDispatcher", "start UnitedSchemeWalletDispatcher");
            String path = unitedSchemeEntity.getPath(false);
            if (TextUtils.isEmpty(path)) {
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
                }
                c.a.r0.a.e0.d.k("SwanWalletDispatcher", "Error: uri action is null.");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                return false;
            } else if (unitedSchemeEntity.isOnlyVerify()) {
                c.a.r0.a.e0.d.k("SwanWalletDispatcher", "Error: is only verify.");
                return true;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.r0.a.e0.d.k("SwanWalletDispatcher", "Error: params is null.");
                    return false;
                }
                String optString = optParamsAsJo.optString("orderInfo");
                String optString2 = optParamsAsJo.optString("version");
                String optString3 = optParamsAsJo.optString("cb");
                c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
                if (L == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.r0.a.e0.d.k("SwanWalletDispatcher", "Error: swan app is null.");
                    return false;
                } else if (L.x() == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.r0.a.e0.d.k("SwanWalletDispatcher", "Error: swan activity is null.");
                    return false;
                } else {
                    String optString4 = optParamsAsJo.optString("from");
                    if (TextUtils.isEmpty(optString4)) {
                        optString4 = RetrieveTaskManager.KEY;
                    }
                    String str = optString4;
                    c.a.r0.a.t1.e eVar = new c.a.r0.a.t1.e(L, unitedSchemeEntity, callbackHandler, optString2, L.N(), optString3);
                    if ("requestPayment".equals(path)) {
                        c.a.r0.a.e0.d.i("SwanWalletDispatcher", "start PAYMENT");
                        n.K("baiduqianbao", "create", 0);
                        return eVar.C("mapp_request_duxiaoman", optString, str);
                    } else if ("requestAliPayment".equals(path)) {
                        c.a.r0.a.e0.d.i("SwanWalletDispatcher", "start ALI PAYMENT");
                        n.K(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "create", 0);
                        return eVar.C("mapp_request_alipayment", optString, str);
                    } else if ("requestPolymerPayment".equals(path)) {
                        c.a.r0.a.e0.d.i("SwanWalletDispatcher", "start POLYMER PAYMENT");
                        n.K("nuomi", "create", 0);
                        return eVar.K(optString, optParamsAsJo);
                    } else if (TextUtils.equals("requestWeChatPayment", path)) {
                        c.a.r0.a.e0.d.i("SwanWalletDispatcher", "start WECHAT HTML5 PAYMENT");
                        n.K("wechatH5Action", "create", 0);
                        return eVar.C("mapp_request_wechatpayment", optString, str);
                    } else {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    }
                }
            }
        }
        return invokeLLL.booleanValue;
    }
}
