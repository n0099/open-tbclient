package com.baidu.sapi2.activity.social;

import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.sapi2.activity.social.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C1830a extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThirdLoginCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f39365b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1830a(a aVar, Looper looper, ThirdLoginCallback thirdLoginCallback) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper, thirdLoginCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39365b = aVar;
            this.a = thirdLoginCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) || this.a == null) {
                return;
            }
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(i2);
            webAuthResult.setResultMsg(str);
            this.a.onFailure(webAuthResult);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, hashMap) == null) {
                this.f39365b.b(str, this.a);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, ThirdLoginCallback thirdLoginCallback) {
        SocialResponse socialResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, thirdLoginCallback) == null) {
            try {
                socialResponse = SocialResponse.fromJSONObject(new JSONObject(str));
            } catch (Exception e2) {
                Log.e(e2);
                socialResponse = null;
            }
            if (SapiContext.getInstance().mLastLoginType != null) {
                SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
            }
            if (socialResponse != null) {
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                ThirdPartyService thirdPartyService = (ThirdPartyService) CoreViewRouter.getInstance().getThirdPartyService();
                if (confignation != null && thirdPartyService != null) {
                    SapiAccount sapiAccountResponseToAccount = thirdPartyService.sapiAccountResponseToAccount(confignation.context, socialResponse);
                    if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                        socialResponse.errorCode = 0;
                    }
                    int i2 = socialResponse.errorCode;
                    if (i2 == 0 || i2 == 110000) {
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        if (thirdLoginCallback != null) {
                            WebAuthResult webAuthResult = new WebAuthResult();
                            webAuthResult.setResultCode(0);
                            thirdLoginCallback.onSuccess(webAuthResult);
                            return;
                        }
                        return;
                    }
                }
            }
            if (thirdLoginCallback != null) {
                WebAuthResult webAuthResult2 = new WebAuthResult();
                webAuthResult2.setResultCode(-100);
                webAuthResult2.setResultMsg("登录失败");
                thirdLoginCallback.onFailure(webAuthResult2);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = new a();
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public void a(String str, ThirdLoginCallback thirdLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, thirdLoginCallback) == null) {
            HashMap hashMap = new HashMap();
            WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
            WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
            if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra));
            } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
                hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra));
            }
            hashMap.put("json", "1");
            String addExtras = ParamsUtil.addExtras(str, hashMap);
            new HttpClientWrap().get(addExtras, ReqPriority.IMMEDIATE, ParamsUtil.buildNaCookie(addExtras, SapiAccountManager.getInstance().getConfignation()), new C1830a(this, Looper.getMainLooper(), thirdLoginCallback));
        }
    }
}
