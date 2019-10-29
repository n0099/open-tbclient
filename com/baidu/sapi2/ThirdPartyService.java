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
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public class ThirdPartyService implements AbstractThirdPartyService {
    private static final long MIN_INVOKE_INTER_TIME = 500;
    private long lastInvokeTime = 0;

    public ThirdPartyService() {
        PassportSDK.getInstance().setThirdPartyService(this);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i) {
        Intent intent;
        if (System.currentTimeMillis() - this.lastInvokeTime >= MIN_INVOKE_INTER_TIME) {
            this.lastInvokeTime = System.currentTimeMillis();
            SapiStatUtil.statThirdLoginEnter(socialType);
            boolean z = context instanceof Activity;
            if (socialType == SocialType.SINA_WEIBO_SSO) {
                intent = new Intent(context, SinaSSOLoginActivity.class);
            } else if (socialType == SocialType.HUAWEI) {
                intent = new Intent(context, HuaweiSSOLoginActivity.class);
            } else if (socialType == SocialType.WEIXIN) {
                intent = new Intent(context, WXLoginActivity.class);
            } else if (socialType == SocialType.QQ_SSO) {
                intent = new Intent(context, QQSSOLoginActivity.class);
            } else if (socialType == SocialType.XIAOMI) {
                intent = new Intent(context, XiaomiSSOLoginActivity.class);
            } else if (socialType == SocialType.MEIZU) {
                intent = new Intent(context, MeizuSSOLoginActivity.class);
            } else {
                throw new IllegalArgumentException(socialType.getName() + " type login not support");
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
        intent.putExtra("error_code", i);
        intent.putExtra("state", str);
        intent.putExtra("code", str2);
        activity.startActivity(intent);
    }
}
