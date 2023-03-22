package com.baidu.sapi2.activity.social;

import android.os.Looper;
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
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static a a;

    /* renamed from: com.baidu.sapi2.activity.social.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0135a extends HttpHandlerWrap {
        public final /* synthetic */ ThirdLoginCallback a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0135a(Looper looper, ThirdLoginCallback thirdLoginCallback) {
            super(looper);
            this.a = thirdLoginCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (this.a != null) {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(i);
                webAuthResult.setResultMsg(str);
                this.a.onFailure(webAuthResult);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
            a.this.b(str, this.a);
        }
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, ThirdLoginCallback thirdLoginCallback) {
        SocialResponse socialResponse;
        try {
            socialResponse = SocialResponse.fromJSONObject(new JSONObject(str));
        } catch (Exception e) {
            Log.e(e);
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
                int i = socialResponse.errorCode;
                if (i == 0 || i == 110000) {
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

    public void a(String str, ThirdLoginCallback thirdLoginCallback) {
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
        new HttpClientWrap().get(addExtras, ReqPriority.IMMEDIATE, ParamsUtil.buildNaCookie(addExtras, SapiAccountManager.getInstance().getConfignation()), new C0135a(Looper.getMainLooper(), thirdLoginCallback));
    }
}
