package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.activity.social.FacebookSSOLoginActivity;
import com.baidu.sapi2.activity.social.GlorySSOLoginActivity;
import com.baidu.sapi2.activity.social.GoogleSSOLoginActivity;
import com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity;
import com.baidu.sapi2.activity.social.MeizuSSOLoginActivity;
import com.baidu.sapi2.activity.social.QQOauthLoginActivity;
import com.baidu.sapi2.activity.social.QQSSOLoginActivity;
import com.baidu.sapi2.activity.social.SinaSSOLoginActivity;
import com.baidu.sapi2.activity.social.TwitterSSOLoginActivity;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity;
import com.baidu.sapi2.activity.social.YYSSOLoginActivity;
import com.baidu.sapi2.activity.social.a;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public class ThirdPartyService implements AbstractThirdPartyService {

    /* renamed from: b  reason: collision with root package name */
    public static final long f10563b = 500;

    /* renamed from: c  reason: collision with root package name */
    public static ThirdLoginCallback f10564c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f10565d = false;

    /* renamed from: a  reason: collision with root package name */
    public long f10566a = 0;

    public ThirdPartyService() {
        CoreViewRouter.getInstance().setThirdPartyService(this);
    }

    public static ThirdLoginCallback getThirdLoginCallback() {
        return f10564c;
    }

    public static void releaseThirdLoginCallback() {
        f10564c = null;
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        if (f10565d) {
            if (i2 == 0) {
                String urlWeixinBind = ParamsUtil.getUrlWeixinBind(SapiAccountManager.getInstance().getConfignation(), str2, str, false);
                f10564c.onAuthSuccess();
                a.a().a(urlWeixinBind, f10564c);
            } else {
                f10564c.onAuthFailure(i2, OAuthResult.ERROR_MSG_UNKNOWN);
            }
            f10565d = false;
            return;
        }
        Intent intent = new Intent(activity, WXLoginActivity.class);
        intent.putExtra(WXLoginActivity.r, true);
        intent.putExtra("error_code", i2);
        intent.putExtra("state", str);
        intent.putExtra("code", str2);
        activity.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadQQLogin(Context context, int i2) {
        Intent intent = new Intent(context, QQOauthLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2) {
        loadThirdPartyLogin(context, socialType, i2, null, false);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadWechatLogin(Context context, int i2) {
        f10565d = true;
        Intent intent = new Intent(context, WXLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public SapiAccount sapiAccountResponseToAccount(Context context, SapiAccountResponse sapiAccountResponse) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", sapiConfiguration.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void socialBind(Activity activity, SocialType socialType, int i2, String str) {
        if (socialType == SocialType.WEIXIN) {
            f10565d = false;
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            intent.putExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL, str);
            activity.startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, ThirdLoginCallback thirdLoginCallback) {
        f10564c = thirdLoginCallback;
        loadThirdPartyLogin(context, socialType, i2, null, false);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str) {
        loadThirdPartyLogin(context, socialType, i2, str, false);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str, boolean z) {
        Intent intent;
        if (System.currentTimeMillis() - this.f10566a < 500) {
            return;
        }
        this.f10566a = System.currentTimeMillis();
        SapiStatUtil.statThirdLoginEnter(socialType);
        boolean z2 = context instanceof Activity;
        if (socialType == SocialType.SINA_WEIBO_SSO) {
            intent = new Intent(context, SinaSSOLoginActivity.class);
        } else if (socialType == SocialType.HUAWEI) {
            intent = new Intent(context, HuaweiSSOLoginActivity.class);
        } else if (socialType == SocialType.WEIXIN) {
            f10565d = false;
            intent = new Intent(context, WXLoginActivity.class);
        } else if (socialType == SocialType.QQ_SSO) {
            intent = new Intent(context, QQSSOLoginActivity.class);
        } else if (socialType == SocialType.MEIZU) {
            intent = new Intent(context, MeizuSSOLoginActivity.class);
        } else if (socialType == SocialType.FACEBOOK) {
            intent = new Intent(context, FacebookSSOLoginActivity.class);
        } else if (socialType == SocialType.XIAOMI) {
            intent = new Intent(context, XiaomiSSOLoginActivity.class);
        } else if (socialType == SocialType.TWITTER) {
            intent = new Intent(context, TwitterSSOLoginActivity.class);
        } else if (socialType == SocialType.GOOGLE) {
            intent = new Intent(context, GoogleSSOLoginActivity.class);
        } else if (socialType == SocialType.GLORY) {
            intent = new Intent(context, GlorySSOLoginActivity.class);
        } else if (socialType == SocialType.YY) {
            intent = new Intent(context, YYSSOLoginActivity.class);
        } else if (socialType == SocialType.QQ_SSO_BACKGROUND) {
            loadQQLogin(context, i2);
            return;
        } else if (socialType == SocialType.WEIXIN_BACKGROUND) {
            loadWechatLogin(context, i2);
            return;
        } else {
            throw new IllegalArgumentException(socialType.getName() + " type login not support");
        }
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        intent.putExtra(BaseSSOLoginActivity.m, z);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("extraJson", str);
        }
        if (!z2) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
            return;
        }
        ((Activity) context).startActivityForResult(intent, 2001);
    }
}
