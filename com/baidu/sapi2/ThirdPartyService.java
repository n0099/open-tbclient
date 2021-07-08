package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ThirdPartyService implements AbstractThirdPartyService {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final long f9661b = 500;

    /* renamed from: c  reason: collision with root package name */
    public static ThirdLoginCallback f9662c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f9663d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f9664a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-85946249, "Lcom/baidu/sapi2/ThirdPartyService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-85946249, "Lcom/baidu/sapi2/ThirdPartyService;");
        }
    }

    public ThirdPartyService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9664a = 0L;
        CoreViewRouter.getInstance().setThirdPartyService(this);
    }

    public static ThirdLoginCallback getThirdLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f9662c : (ThirdLoginCallback) invokeV.objValue;
    }

    public static void releaseThirdLoginCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f9662c = null;
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, activity, str, str2, i2) == null) {
            if (f9663d) {
                if (i2 == 0) {
                    String urlWeixinBind = ParamsUtil.getUrlWeixinBind(SapiAccountManager.getInstance().getConfignation(), str2, str, false);
                    f9662c.onAuthSuccess();
                    a.a().a(urlWeixinBind, f9662c);
                } else {
                    f9662c.onAuthFailure(i2, OAuthResult.ERROR_MSG_UNKNOWN);
                }
                f9663d = false;
                return;
            }
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(WXLoginActivity.r, true);
            intent.putExtra("error_code", i2);
            intent.putExtra("state", str);
            intent.putExtra("code", str2);
            activity.startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadQQLogin(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            Intent intent = new Intent(context, QQOauthLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            if (!(context instanceof Activity)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, socialType, i2) == null) {
            loadThirdPartyLogin(context, socialType, i2, null, false);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadWechatLogin(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i2) == null) {
            f9663d = true;
            Intent intent = new Intent(context, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            if (!(context instanceof Activity)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadYYSSOLogin(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) {
            Intent intent = new Intent(context, YYInnerSSOLoginActivity.class);
            intent.putExtra(YYInnerSSOLoginActivity.o, str);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2002);
            if (!(context instanceof Activity)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public SapiAccount sapiAccountResponseToAccount(Context context, SapiAccountResponse sapiAccountResponse) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, sapiAccountResponse)) == null) {
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
                sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname);
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
        return (SapiAccount) invokeLL.objValue;
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void socialBind(Activity activity, SocialType socialType, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(1048585, this, activity, socialType, i2, str) == null) && socialType == SocialType.WEIXIN) {
            f9663d = false;
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            intent.putExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL, str);
            activity.startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, ThirdLoginCallback thirdLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, context, socialType, i2, thirdLoginCallback) == null) {
            f9662c = thirdLoginCallback;
            loadThirdPartyLogin(context, socialType, i2, null, false);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, context, socialType, i2, str) == null) {
            loadThirdPartyLogin(context, socialType, i2, str, false);
        }
    }

    @Override // com.baidu.sapi2.service.AbstractThirdPartyService
    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str, boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, socialType, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || System.currentTimeMillis() - this.f9664a < 500) {
            return;
        }
        this.f9664a = System.currentTimeMillis();
        SapiStatUtil.statThirdLoginEnter(socialType);
        boolean z2 = context instanceof Activity;
        if (socialType == SocialType.SINA_WEIBO_SSO) {
            intent = new Intent(context, SinaSSOLoginActivity.class);
        } else if (socialType == SocialType.HUAWEI) {
            intent = new Intent(context, HuaweiSSOLoginActivity.class);
        } else if (socialType == SocialType.WEIXIN) {
            f9663d = false;
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
