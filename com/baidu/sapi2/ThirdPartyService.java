package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.HuaweiLoginActivity;
import com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity;
import com.baidu.sapi2.activity.social.MeizuSSOLoginActivity;
import com.baidu.sapi2.activity.social.QQSSOLoginActivity;
import com.baidu.sapi2.activity.social.SinaSSOLoginActivity;
import com.baidu.sapi2.activity.social.SocialLoginActivity;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public class ThirdPartyService implements AbstractThirdPartyService {
    public ThirdPartyService() {
        PassportSDK.getInstance().setThirdPartyService(this);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i) {
        Intent intent;
        boolean z = context instanceof Activity;
        if (socialType == SocialType.SINA_WEIBO_SSO) {
            intent = new Intent(context, SinaSSOLoginActivity.class);
        } else if (socialType == SocialType.HUAWEI) {
            intent = new Intent(context, HuaweiSSOLoginActivity.class);
        } else if (socialType == SocialType.WEIXIN) {
            intent = new Intent(context, WXLoginActivity.class);
        } else if (socialType == SocialType.CHUANKE) {
            if (z) {
                ((Activity) context).finish();
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(-301);
                webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                loginFail((Activity) context, webAuthResult, i);
                return;
            }
            return;
        } else if (socialType == SocialType.QQ_SSO) {
            intent = new Intent(context, QQSSOLoginActivity.class);
        } else if (socialType == SocialType.XIAOMI) {
            intent = new Intent(context, XiaomiSSOLoginActivity.class);
        } else if (socialType == SocialType.MEIZU) {
            intent = new Intent(context, MeizuSSOLoginActivity.class);
        } else {
            intent = new Intent(context, SocialLoginActivity.class);
            intent.putExtra(SocialLoginActivity.EXTRA_SOCIAL_TYPE, socialType);
        }
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
        if (!z) {
            intent.setFlags(268435456);
            context.startActivity(intent);
        } else if (socialType == SocialType.WEIXIN) {
            context.startActivity(intent);
        } else {
            ((Activity) context).startActivityForResult(intent, 2001);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void socialBind(Activity activity, SocialType socialType, int i, String str) {
        if (socialType == SocialType.WEIXIN) {
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
            intent.putExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL, str);
            activity.startActivity(intent);
        }
    }

    private void loginFail(Activity activity, WebAuthResult webAuthResult, int i) {
        if (i == 2003) {
            activity.finish();
            return;
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        PassportSDK.getInstance().release();
        activity.finish();
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadHuaweiLogin(Context context, WebAuthListener webAuthListener, String str, String str2) {
        Intent intent = new Intent(context, HuaweiLoginActivity.class);
        intent.putExtra("access_token", str2);
        intent.putExtra("uid", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void handleWXLoginResp(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, WXLoginActivity.class);
        intent.putExtra(WXLoginActivity.KEY_FROM_WX_AUTH, true);
        intent.putExtra(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, i);
        intent.putExtra(WXLoginActivity.KEY_BASE_RESP_STATE, str);
        intent.putExtra("code", str2);
        activity.startActivity(intent);
    }
}
