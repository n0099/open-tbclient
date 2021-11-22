package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.c0.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.common.PassSdkModel;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ShareActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String B = "ShareActivity";
    public static final String C = "share_fail_code";
    public static final String D = "share_fail_reason";
    public static final String E = "share_account";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String t;
    public ShareResult u;
    public WebAuthListener v;
    public String w;
    public String x;
    public String y;
    public String z;

    public ShareActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = "0";
        this.u = new ShareResult();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBottomBackBtnClick();
            d();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                if (!PassSdkModel.getInstance().checkPassSdkInit()) {
                    Log.e(B, "pass sdk没有初始化");
                    this.u.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
                    a(true);
                    return;
                }
                String callingPackage = getCallingPackage();
                if (!PassSdkModel.getInstance().checkPkgSign(this, callingPackage)) {
                    Log.d(B, callingPackage + "不是已经授权的百度系app");
                    this.u.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
                    a(false);
                    return;
                }
                init();
                setupViews();
                Map<String, String> a2 = a();
                a2.put(ImageViewerConfig.IS_LOGIN, this.t.equals("1") ? "0" : "1");
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_INVOKED, a2);
            } catch (Throwable th) {
                reportWebviewError(th);
                this.u.setResultCode(ShareResult.ERROR_CODE_SYS_ERROR);
                a(false);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onLeftBtnClick();
            d();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.setupViews();
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.ShareActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ShareActivity f43447a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43447a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.f43447a.d();
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
            JSONObject jSONObject = new JSONObject();
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            try {
                String stringExtra = getIntent().getStringExtra(ShareCallPacking.EXTRA_FROM_APP_TPL);
                this.y = stringExtra;
                if (TextUtils.isEmpty(stringExtra)) {
                    this.y = "unknown";
                }
                jSONObject.put("errno", "0");
                String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
                jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
                String str = pkgIconAndName[1];
                this.w = str;
                jSONObject.put("currentAPPName", str);
                String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
                jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
                String str2 = pkgIconAndName2[1];
                this.x = str2;
                jSONObject.put("originAPPName", str2);
                if (currentAccount == null) {
                    this.t = "1";
                } else {
                    jSONObject.put("displayName", currentAccount.displayname);
                }
                jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
                jSONObject.put("session_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_SESSION_ID));
                jSONObject.put("trace_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_TRACE_ID));
                this.z = getIntent().getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE);
                this.A = getIntent().getStringExtra(ShareCallPacking.EXTRA_CALL_TYPE_SHARE);
                Log.d(B, "调用来源=" + this.A + ", 调起方=" + this.x + ", 被调起方=" + this.w + ", shareVer=" + this.z);
            } catch (Exception e2) {
                Log.e(e2);
            }
            SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams(this) { // from class: com.baidu.sapi2.activity.ShareActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ShareActivity f43448a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43448a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
                public void onError() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_EXPIRED, this.f43448a.a());
                        if (!this.f43448a.t.equals("1")) {
                            this.f43448a.t = "2";
                        }
                        this.f43448a.c();
                    }
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f43448a.b();
                    }
                }
            };
            shareV2LoginParams.pageParams = jSONObject;
            this.sapiWebView.setShareV2LoginParams(shareV2LoginParams);
            this.sapiWebView.loadShareV2Login();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                this.u.setResultCode(ShareResult.ERROR_CODE_RESULT_NULL);
                a(true);
                return;
            }
            currentAccount.app = SapiUtils.getAppName(this);
            Map<String, String> a2 = a();
            a2.put(ImageViewerConfig.IS_LOGIN, this.t.equals("1") ? "0" : "1");
            StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_SUCCESS, a2);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putParcelable("share_account", currentAccount);
            bundle.putInt("SDK_VERSION", 250);
            bundle.putString("PKG", getPackageName());
            bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.z);
            if (SapiContext.getInstance().shareLivingunameEnable()) {
                bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
            }
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
            LoginActivity.supportShareLogin = false;
            WebLoginDTO.Config config = new WebLoginDTO.Config();
            config.fastLoginFeatureList = new ArrayList();
            webLoginDTO.config = config;
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                webLoginDTO.encryptedId = currentAccount.uid;
                webLoginDTO.preSetUname = currentAccount.displayname;
            }
            this.v = new WebAuthListener(this, z) { // from class: com.baidu.sapi2.activity.ShareActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f43449a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ShareActivity f43450b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43450b = this;
                    this.f43449a = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                        Map a2 = this.f43450b.a();
                        a2.put("code", "" + webAuthResult.getResultCode());
                        StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_FAIL, a2);
                        LoginActivity.supportShareLogin = true;
                        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = this.f43449a;
                        this.f43450b.u.setResultCode(ShareResult.ERROR_CODE_EXPIRED_LOGIN_FAIL);
                        this.f43450b.u.setResultMsg(String.format(ShareResult.ERROR_MSG_EXPIRED_LOGIN_FAIL, this.f43450b.w));
                        this.f43450b.a(true);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, webAuthResult) == null) {
                        StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_SUCCESS, this.f43450b.a());
                        LoginActivity.supportShareLogin = true;
                        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = this.f43449a;
                        SapiWebView sapiWebView = this.f43450b.sapiWebView;
                        if (sapiWebView != null) {
                            sapiWebView.reload();
                        }
                        SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                    }
                }
            };
            CoreViewRouter.getInstance().startLogin(this, this.v, webLoginDTO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
                return;
            }
            this.u.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
            this.u.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.w));
            a(false);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Map<String, String> a2 = a();
            a2.put("error_code", "" + this.u.getResultCode());
            StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_FAIL, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            e();
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap hashMap = new HashMap();
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null) {
                hashMap.put("cur_tpl", sapiConfiguration.tpl);
            } else {
                hashMap.put("cur_tpl", "unknown");
            }
            hashMap.put("from_tpl", this.y);
            hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, this.A);
            hashMap.put("share_ver", this.z);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("share_fail_code", "" + this.u.getResultCode());
            bundle.putString("share_fail_reason", this.u.getResultMsg());
            if (z) {
                bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, getPackageName());
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (currentAccount != null) {
                    bundle.putString(ShareLoginModel.INVALIDATE_BDUSS, currentAccount.bduss);
                }
            }
            bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.z);
            intent.putExtras(bundle);
            setResult(-100, intent);
            finish();
        }
    }
}
