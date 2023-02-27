package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.activity.social.CFOSSOLoginActivity;
import com.baidu.sapi2.activity.social.FacebookSSOLoginActivity;
import com.baidu.sapi2.activity.social.GoogleSSOLoginActivity;
import com.baidu.sapi2.activity.social.HonorSSOLoginActivity;
import com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity;
import com.baidu.sapi2.activity.social.MeizuSSOLoginActivity;
import com.baidu.sapi2.activity.social.QQOauthLoginActivity;
import com.baidu.sapi2.activity.social.QQSSOLoginActivity;
import com.baidu.sapi2.activity.social.SinaSSOLoginActivity;
import com.baidu.sapi2.activity.social.TwitterSSOLoginActivity;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.activity.social.YYSSOLoginActivity;
import com.baidu.sapi2.activity.social.a;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes2.dex */
public class ThirdPartyService implements AbstractThirdPartyService {
    public static final long b = 500;
    public static ThirdLoginCallback c = null;
    public static boolean d = false;
    public static final int e = -404;
    public long a = 0;

    public ThirdPartyService() {
        CoreViewRouter.getInstance().setThirdPartyService(this);
    }

    public static ThirdLoginCallback getThirdLoginCallback() {
        return c;
    }

    public static void releaseThirdLoginCallback() {
        c = null;
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void handleWXLoginResp(Activity activity, String str, String str2, int i) {
        if (d) {
            ThirdLoginCallback thirdLoginCallback = c;
            releaseThirdLoginCallback();
            if (i == 0) {
                String urlWeixinBind = ParamsUtil.getUrlWeixinBind(SapiAccountManager.getInstance().getConfignation(), str2, str, false);
                thirdLoginCallback.onAuthSuccess();
                a.a().a(urlWeixinBind, thirdLoginCallback);
            } else {
                thirdLoginCallback.onAuthFailure(i, OAuthResult.ERROR_MSG_UNKNOWN);
            }
            d = false;
            return;
        }
        Intent intent = new Intent(activity, WXLoginActivity.class);
        intent.putExtra(WXLoginActivity.r, true);
        intent.putExtra("error_code", i);
        intent.putExtra("state", str);
        intent.putExtra("code", str2);
        activity.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadCFOSSOLogin(Context context, int i) {
        Intent intent = new Intent(context, CFOSSOLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadQQLogin(Context context, int i) {
        Intent intent = new Intent(context, QQOauthLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadYYSSOLogin(Context context, String str) {
        Intent intent = new Intent(context, YYInnerSSOLoginActivity.class);
        intent.putExtra(YYInnerSSOLoginActivity.o, str);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2002);
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i) {
        loadThirdPartyLogin(context, socialType, i, null, false);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i, ThirdLoginCallback thirdLoginCallback) {
        c = thirdLoginCallback;
        loadThirdPartyLogin(context, socialType, i, null, false);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void socialBind(Activity activity, SocialType socialType, int i, String str) {
        if (socialType == SocialType.WEIXIN) {
            d = false;
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
            intent.putExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL, str);
            activity.startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i, String str) {
        loadThirdPartyLogin(context, socialType, i, str, false);
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i, String str, boolean z) {
        Intent intent;
        if (System.currentTimeMillis() - this.a < 500) {
            return;
        }
        this.a = System.currentTimeMillis();
        SapiStatUtil.statThirdLoginEnter(socialType);
        try {
            if (SapiAccountManager.getInstance() != null && SapiAccountManager.getInstance().getConfignation() != null) {
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                if (confignation.context == null) {
                    return;
                }
                if (context.getPackageName() != null && !context.getPackageName().equals(confignation.context.getPackageName())) {
                    context = confignation.context;
                }
                boolean z2 = context instanceof Activity;
                if (socialType == SocialType.SINA_WEIBO_SSO) {
                    intent = new Intent(context, SinaSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
                } else if (socialType == SocialType.HUAWEI) {
                    intent = new Intent(context, HuaweiSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
                } else if (socialType == SocialType.WEIXIN) {
                    d = false;
                    intent = new Intent(context, WXLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                } else if (socialType == SocialType.QQ_SSO) {
                    intent = new Intent(context, QQSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                } else if (socialType == SocialType.MEIZU) {
                    intent = new Intent(context, MeizuSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
                } else if (socialType == SocialType.FACEBOOK) {
                    intent = new Intent(context, FacebookSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OTHER;
                } else if (socialType == SocialType.XIAOMI) {
                    intent = new Intent(context, XiaomiSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
                } else if (socialType == SocialType.TWITTER) {
                    intent = new Intent(context, TwitterSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OTHER;
                } else if (socialType == SocialType.GOOGLE) {
                    intent = new Intent(context, GoogleSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OTHER;
                } else if (socialType == SocialType.HONOR) {
                    intent = new Intent(context, HonorSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HONOR;
                } else if (socialType == SocialType.YY) {
                    intent = new Intent(context, YYSSOLoginActivity.class);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.YY;
                } else if (socialType == SocialType.QQ_SSO_BACKGROUND) {
                    loadQQLogin(context, i);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                    return;
                } else if (socialType == SocialType.WEIXIN_BACKGROUND) {
                    loadWechatLogin(context, i);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                    return;
                } else if (socialType == SocialType.CFO) {
                    loadCFOSSOLogin(context, i);
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.CFO;
                    return;
                } else {
                    throw new IllegalArgumentException(socialType.getName() + " type login not support");
                }
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
                intent.putExtra(BaseSSOLoginActivity.m, z);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("extraJson", str);
                }
                if (!z2) {
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(intent);
                    return;
                }
                ((Activity) context).startActivityForResult(intent, 2001);
            }
        } catch (Exception unused) {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(13);
            webAuthResult.setResultMsg(WebAuthResult.ERROR_MSG_CONTEXT_ERROR);
            CoreViewRouter coreViewRouter = CoreViewRouter.getInstance();
            if (coreViewRouter != null && coreViewRouter.getWebAuthListener() != null) {
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(webAuthResult);
                CoreViewRouter.getInstance().release();
            }
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadWechatLogin(Context context, int i) {
        if (c == null) {
            return;
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null) {
            c.onAuthFailure(-404, "pass没有初始化");
            releaseThirdLoginCallback();
        } else if (!WXAPIFactory.createWXAPI(confignation.context, confignation.wxAppID).isWXAppInstalled()) {
            c.onAuthFailure(-404, "微信未安装");
            releaseThirdLoginCallback();
        } else {
            d = true;
            Intent intent = new Intent(context, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i);
            if (!(context instanceof Activity)) {
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public SapiAccount sapiAccountResponseToAccount(Context context, SapiAccountResponse sapiAccountResponse) {
        String str;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        if (TextUtils.isEmpty(sapiAccountResponse.app)) {
            str = SapiUtils.getAppName(context);
        } else {
            str = sapiAccountResponse.app;
        }
        sapiAccount.app = str;
        sapiAccount.extra = sapiAccountResponse.extra;
        SocialType socialType = SocialType.UNKNOWN;
        SocialType socialType2 = sapiAccountResponse.socialType;
        if (socialType != socialType2) {
            sapiAccount.addSocialInfo(socialType2, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname);
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
}
