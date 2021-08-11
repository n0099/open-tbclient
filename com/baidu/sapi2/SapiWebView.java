package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.IWalletLoginListener;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.yy.hiidostatis.defs.controller.SensorController;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes5.dex */
public class SapiWebView extends WebView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    public static final String ACTION_FORGET_PWD = "forget-pwd";
    public static final String ACTION_MODIFY_PWD = "modify-pwd";
    public static final String ACTION_RENREN_OFFLINE = "renren-offline";
    public static final int AUTHORIZATION_TYPE_OPEN = 1;
    public static final int AUTHORIZATION_TYPE_PASS = 0;
    public static final String BROWSE_MODE_AGREEMENT_HOST = "https://s.bdstatic.com";
    public static final String CALLBACK_PARAM_KEY = "__wp-action";
    public static final String CUSTOM_CSS_INTERPRETER_URL = "css/sapi_theme/style.css";
    public static final String DATA_ENCODING = "UTF-8";
    public static final String DATA_MIME_TYPE = "text/html";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT;
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL;
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN;
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN;
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER;
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE;
    public static final String FN_GUIDE_PROCESS = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static final String FN_NET_AVAILABLE = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL = "取消";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_MSG = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_SET_TIME = "立即设置时间";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_TITLE = "系统时间错误";
    public static final String HTTPS_SSL_UNTRUSTED_DIALOG_MSG = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String HTTPS_SSL_UNTRUSTED_DIALOG_TITLE = "证书安全警告";
    public static final String PARAMS_IS_ACCEPT_BROWSEMODE_AGREEMENT = "isAcceptBrowseModeAgreement";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String PARAMS_SCREEN_TYPE = "screenType";
    public static final String PROMPT_ON_CANCEL = "prompt_on_cancel";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";
    public static final String URL_HASH_CHINA_MOBILE_OAUTH = "#oneKeyLogin";
    public static final String URL_HASH_FACE_LOGIN = "#face_login";
    public static final String URL_HASH_FAST_REG = "#fastReg";
    public static final String URL_HASH_INSERT_LOGIN = "#insert_account";
    public static final String URL_HASH_JOIN_LOGIN = "#canshareAi";
    public static final String URL_HASH_LOGIN = "#login";
    public static final String URL_HASH_LOGIN_WITH_USERNAME = "#authPwd";
    public static final String URL_HASH_REG = "#reg";
    public static final String URL_HASH_SHARE = "#canshare_accounts";
    public static final String URL_HASH_SHARE_OAUTH = "#share_auth";
    public static final String URL_HASH_SMS_LOGIN = "#sms_login";
    public static StatLoadLogin statLoadLogin;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountChangeCallback accountChangeCallback;
    public List<String> asynJsMehodName;
    public ChangePwdCallback changePwdCallback;
    public SapiConfiguration configuration;
    public Dialog dateInvalidDialog;
    public List<PassNameValuePair> extras;
    public FileChooserCallback fileChooserCallback;
    public boolean isDestory;
    public volatile boolean isLoadThirdPartyUrl;
    public boolean isSupFaceLogin;
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public SapiJsInterpreters jsInterpreters;
    public int leftBtnIsVisible;
    public LoginTypes mExcludeTypes;
    public boolean mHadMakeBarHide;
    public View noNetworkView;
    public OnBackCallback onBackCallback;
    public OnFinishCallback onFinishCallback;
    public OnNewBackCallback onNewBackCallback;
    public ProgressBar progressBar;
    public ProgressDialog progressDialog;
    public ReloadConfig reloadConfig;
    public SapiCache sapiCache;
    public boolean shareV2Disable;
    public boolean shouldClose;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide;
    public Handler timeoutHandler;
    public long timeoutMillis;
    public TimeoutTask timeoutTask;
    public View timeoutView;
    public String[] touchidPortraitAndSign;
    public volatile String userInfoXmlContent;
    public WebChromeClientCallback webChromeClientCallback;
    public WebviewClientCallback webviewClientCallback;
    public View webviewLoadingView;

    /* loaded from: classes5.dex */
    public interface AccountChangeCallback {
        void onAccountChange();
    }

    /* loaded from: classes5.dex */
    public static abstract class AccountDestoryCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class AccountDestoryResult {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public AccountDestoryResult() {
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
        }

        public AccountDestoryCallback() {
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

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    /* loaded from: classes5.dex */
    public static abstract class AccountFreezeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class AccountFreezeResult {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public AccountFreezeResult() {
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
        }

        public AccountFreezeCallback() {
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

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ActivityLifeCycle {
        public static final /* synthetic */ ActivityLifeCycle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ActivityLifeCycle ON_PAUSE;
        public static final ActivityLifeCycle ON_RESUME;
        public transient /* synthetic */ FieldHolder $fh;
        public String methodName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-602383932, "Lcom/baidu/sapi2/SapiWebView$ActivityLifeCycle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-602383932, "Lcom/baidu/sapi2/SapiWebView$ActivityLifeCycle;");
                    return;
                }
            }
            ON_RESUME = new ActivityLifeCycle("ON_RESUME", 0, "webViewWillAppear");
            ActivityLifeCycle activityLifeCycle = new ActivityLifeCycle("ON_PAUSE", 1, "webViewWillDisappear");
            ON_PAUSE = activityLifeCycle;
            $VALUES = new ActivityLifeCycle[]{ON_RESUME, activityLifeCycle};
        }

        public ActivityLifeCycle(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.methodName = str2;
        }

        public static ActivityLifeCycle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ActivityLifeCycle) Enum.valueOf(ActivityLifeCycle.class, str) : (ActivityLifeCycle) invokeL.objValue;
        }

        public static ActivityLifeCycle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ActivityLifeCycle[]) $VALUES.clone() : (ActivityLifeCycle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface BdussChangeCallback {
        void onBdussChange();
    }

    /* loaded from: classes5.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes5.dex */
    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        /* loaded from: classes5.dex */
        public static abstract class BioScanFaceResult {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int showGuidePage;
            public String subpro;
            public List<PassNameValuePair> transParamsList;
            public Map<String, String> transParamsMap;
            public int type;
            public String uid;

            public BioScanFaceResult() {
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
                this.transParamsMap = new HashMap();
                this.transParamsList = new ArrayList();
            }

            public abstract void setScanFaceIdentifyResult(String str);
        }

        void onBioScanFace(BioScanFaceResult bioScanFaceResult);
    }

    /* loaded from: classes5.dex */
    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    /* loaded from: classes5.dex */
    public static abstract class BiometricsIdentifyResult {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ERROR_CODE_GET_STOKEN_FAILED = -402;
        public static final String ERROR_MSG_GET_STOKEN_FAILED = "服务异常，请稍后再试";
        public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
        public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
        public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
        public transient /* synthetic */ FieldHolder $fh;
        public String authToken;
        public int biometricType;
        public String idCardNum;
        public String livenessRecogType;
        public String phoneNum;
        public String realName;
        public int recordVideo;
        public int showGuidePage;
        public String subPro;

        public BiometricsIdentifyResult() {
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

        public abstract void setIdentifyToken(String str);
    }

    /* loaded from: classes5.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public static class Command {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String actionName;
        public List<String> actionParams;

        public Command() {
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
            this.actionParams = new ArrayList();
        }

        public static Command parse(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str.toString());
                    Command command = new Command();
                    JSONObject optJSONObject = jSONObject.optJSONObject("action");
                    if (optJSONObject != null) {
                        command.actionName = optJSONObject.optString("name");
                        JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                command.actionParams.add(optJSONArray.optString(i2));
                            }
                        }
                    }
                    return command;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (Command) invokeL.objValue;
        }

        public String getActionName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.actionName : (String) invokeV.objValue;
        }

        public List<String> getActionParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.actionParams : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    /* loaded from: classes5.dex */
    public static abstract class CoverWebBdussResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CoverWebBdussResult() {
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

        public abstract void setWebBduss(String str);
    }

    /* loaded from: classes5.dex */
    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    /* loaded from: classes5.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes5.dex */
        public static abstract class InvokeScAppResult {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public InvokeScAppResult() {
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

            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    /* loaded from: classes5.dex */
    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i2);
    }

    /* loaded from: classes5.dex */
    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    /* loaded from: classes5.dex */
    public static class LoadExternalWebViewResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String defaultTitle;
        public String externalUrl;

        public LoadExternalWebViewResult() {
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
    }

    /* loaded from: classes5.dex */
    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    /* loaded from: classes5.dex */
    public static class LoadSlideWebViewResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String adapter;
        public String page;
        public String placeholderTitle;
        public String url;

        public LoadSlideWebViewResult() {
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
    }

    /* loaded from: classes5.dex */
    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    /* loaded from: classes5.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes5.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes5.dex */
    public interface OnNewBackCallback {
        boolean onBack();
    }

    /* loaded from: classes5.dex */
    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    /* loaded from: classes5.dex */
    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i2, int i3, int i4, PickPhotoResult pickPhotoResult);
    }

    /* loaded from: classes5.dex */
    public static abstract class PickPhotoResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PickPhotoResult() {
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

        public void setImageData(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class PreFillUserNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class PreFillUserNameResult {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String userName;

            public PreFillUserNameResult() {
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
        }

        public PreFillUserNameCallback() {
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

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    /* loaded from: classes5.dex */
    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    /* loaded from: classes5.dex */
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes5.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public class ReloadConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean bindAccount;
        public List<PassNameValuePair> paramsList;
        public final /* synthetic */ SapiWebView this$0;
        public String timeoutUrl;
        public String weixinBindUrl;
        public boolean wxSsoReload;

        public ReloadConfig(SapiWebView sapiWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiWebView;
            this.timeoutUrl = null;
            this.wxSsoReload = false;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.timeoutUrl = null;
                this.wxSsoReload = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4, String str5);
    }

    /* loaded from: classes5.dex */
    public static abstract class SwitchAccountCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class Result {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String displayName;
            public String encryptedUid;
            public String extraJson;
            public int loginType;
            public int switchAccountType;
            public String userName;

            public Result() {
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
        }

        public SwitchAccountCallback() {
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

        public abstract void onAccountSwitch(Result result);
    }

    /* loaded from: classes5.dex */
    public class TimeoutTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiWebView this$0;
        public String url;

        public TimeoutTask(SapiWebView sapiWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.this$0.getProgress() >= 100) {
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.obj = this.url;
            this.this$0.timeoutHandler.sendMessage(message);
            this.this$0.timeoutHandler.removeCallbacks(this);
        }

        public void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.url = str;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* loaded from: classes5.dex */
    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i2, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes5.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes5.dex */
    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1549966363, "Lcom/baidu/sapi2/SapiWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1549966363, "Lcom/baidu/sapi2/SapiWebView;");
                return;
            }
        }
        EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
        EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
        EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
        EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair("direct", "1");
        EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", "1");
        EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SapiWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.reloadConfig = new ReloadConfig();
        this.timeoutHandler = new Handler(this) { // from class: com.baidu.sapi2.SapiWebView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SapiWebView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 1) {
                    this.this$0.handleTimeout();
                }
            }
        };
        this.timeoutTask = new TimeoutTask();
        this.leftBtnIsVisible = 1;
        this.touchidPortraitAndSign = new String[2];
        init();
    }

    private String addExtras(String str, List<PassNameValuePair> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, this, str, list)) == null) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (PassNameValuePair passNameValuePair : list) {
                    if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                        try {
                            arrayList.add(new PassNameValuePair(URLEncoder.encode(passNameValuePair.getName(), "UTF-8"), URLEncoder.encode(passNameValuePair.getValue(), "UTF-8")));
                        } catch (UnsupportedEncodingException e2) {
                            Log.e(e2);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return str;
                }
                return str + "&" + SapiUtils.createRequestParams(arrayList);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authorizeSuccess(AccountType accountType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, this, accountType) == null) {
            if (!TextUtils.isEmpty(this.jsCallBacks.touchidPortraitAndSign[0])) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                String[] strArr = this.jsCallBacks.touchidPortraitAndSign;
                currentAccount.phone = strArr[0];
                currentAccount.email = strArr[1];
                SapiContext.getInstance().addTouchidAccounts(currentAccount);
            }
            AuthorizationListener authorizationListener = this.jsCallBacks.authorizationListener;
            if (authorizationListener != null) {
                try {
                    if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                        this.jsCallBacks.authorizationListener.onSuccess(accountType);
                        return;
                    }
                } catch (NoSuchMethodException e2) {
                    Log.e(e2);
                }
                this.jsCallBacks.authorizationListener.onSuccess();
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void configSapiWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            WebSettings settings = getSettings();
            try {
                settings.setJavaScriptEnabled(true);
            } catch (NullPointerException e2) {
                Log.e(e2);
            }
            String userAgentString = settings.getUserAgentString();
            settings.setUserAgentString(userAgentString + " " + getUaInfo());
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            settings.setDomStorageEnabled(true);
            setScrollBarStyle(0);
            settings.setSaveFormData(false);
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null) {
                settings.setTextZoom(sapiConfiguration.textZoom);
            }
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            setDownloadListener(new DownloadListener(this) { // from class: com.baidu.sapi2.SapiWebView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;

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
                    this.this$0 = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.setFlags(268435456);
                            this.this$0.getContext().startActivity(intent);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fixAdapterParamValue(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            boolean z2 = false;
            if (confignation == null) {
                z = false;
            } else {
                if (!this.mHadMakeBarHide && confignation.customActionBarEnabled) {
                    z2 = true;
                }
                z = confignation.showBottomBack;
            }
            return replaceParams(str, "adapter", ParamsUtil.getAdapterParamValue(z2, z));
        }
        return (String) invokeL.objValue;
    }

    private String generateJSStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, this, str)) == null) ? String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str) : (String) invokeL.objValue;
    }

    public static String getMatcher(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65583, null, str, str2)) == null) {
            Pattern compile = Pattern.compile(str);
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            Matcher matcher = compile.matcher(str2);
            while (matcher.find()) {
                str3 = matcher.group();
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            View view = this.noNetworkView;
            if (view == null || view.getVisibility() != 0) {
                View view2 = this.timeoutView;
                if (view2 == null || view2.getVisibility() != 0) {
                    post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiWebView this$0;

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
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.webviewLoadingView == null) {
                                return;
                            }
                            this.this$0.webviewLoadingView.setVisibility(0);
                            if (this.this$0.progressBar != null) {
                                this.this$0.progressBar.setVisibility(8);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkUnavailable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;

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
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.progressBar != null) {
                            this.this$0.progressBar.setVisibility(8);
                        }
                        if (this.this$0.webviewLoadingView != null) {
                            this.this$0.webviewLoadingView.setVisibility(8);
                        }
                        if (this.this$0.noNetworkView != null) {
                            this.this$0.noNetworkView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            stopLoading();
            post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;

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
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.progressBar != null) {
                            this.this$0.progressBar.setVisibility(8);
                        }
                        if (this.this$0.webviewLoadingView != null) {
                            this.this$0.webviewLoadingView.setVisibility(8);
                        }
                        this.this$0.reloadConfig.timeoutUrl = this.this$0.timeoutTask.url;
                        if (this.this$0.timeoutView != null) {
                            this.this$0.timeoutView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            SapiJsCallBacks.CallBacks callBacks = new SapiJsCallBacks.CallBacks();
            this.jsCallBacks = callBacks;
            this.jsInterpreters = new SapiJsInterpreters(this, callBacks);
            this.timeoutMillis = DEFAULT_TIMEOUT_MILLIS;
            this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
            this.sapiCache = new SapiCache();
            this.isSupFaceLogin = new FaceLoginService().isSupFaceLogin();
            configSapiWebView();
            setAsynJsMehodName();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 10 && i2 < 19) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            setWebViewClient(new AnonymousClass2(this));
            setWebChromeClient(new WebChromeClient(this) { // from class: com.baidu.sapi2.SapiWebView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.webkit.WebChromeClient
                public void onConsoleMessage(String str, int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str, i3, str2) == null) {
                        Log.d(str + " -- From line " + i3 + " of " + str2, new Object[0]);
                        if (this.this$0.webChromeClientCallback != null) {
                            this.this$0.webChromeClientCallback.onConsoleMessage(str, i3, str2);
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                    InterceptResult invokeLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, jsResult)) == null) {
                        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this.this$0.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new DialogInterface.OnClickListener(this, jsResult) { // from class: com.baidu.sapi2.SapiWebView.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;
                            public final /* synthetic */ JsResult val$result;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, jsResult};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$result = jsResult;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, dialogInterface, i3) == null) {
                                    this.val$result.confirm();
                                }
                            }
                        });
                        positiveButton.setCancelable(false);
                        positiveButton.create();
                        positiveButton.show();
                        return true;
                    }
                    return invokeLLLL.booleanValue;
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    InterceptResult invokeLLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLLL = interceptable2.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, jsPromptResult)) == null) {
                        if (this.this$0.webChromeClientCallback != null && this.this$0.webChromeClientCallback.isSubClassHandleMessage(str2)) {
                            return this.this$0.webChromeClientCallback.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                        }
                        Log.i(Log.TAG, "webview", str2);
                        this.this$0.jsCallBacks.promptResult = jsPromptResult;
                        this.this$0.post(new Runnable(this, str2, jsPromptResult, new String[]{""}) { // from class: com.baidu.sapi2.SapiWebView.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;
                            public final /* synthetic */ String[] val$interpretResult;
                            public final /* synthetic */ String val$message;
                            public final /* synthetic */ JsPromptResult val$result;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str2, jsPromptResult, r9};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$message = str2;
                                this.val$result = jsPromptResult;
                                this.val$interpretResult = r9;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    Command parse = Command.parse(this.val$message);
                                    if (parse != null) {
                                        String actionName = parse.getActionName();
                                        if (this.this$1.this$0.asynJsMehodName.contains(actionName)) {
                                            this.this$1.this$0.jsCallBacks.promptResult = this.val$result;
                                        }
                                        SapiJsInterpreters.AbstractInterpreter interpreter = this.this$1.this$0.jsInterpreters.getInterpreter(actionName);
                                        if (interpreter != null) {
                                            try {
                                                this.val$interpretResult[0] = interpreter.interpret(parse);
                                            } catch (Throwable th) {
                                                JSONObject jSONObject = new JSONObject();
                                                try {
                                                    jSONObject.put("errno", 0);
                                                    jSONObject.put("msg", "native function error");
                                                    this.val$interpretResult[0] = jSONObject.toString();
                                                    LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                                                    linkedHashMap.put("name", "native_fun_error");
                                                    HashMap hashMap = new HashMap(2);
                                                    hashMap.put("msg", android.util.Log.getStackTraceString(th));
                                                    hashMap.put("action_name", actionName);
                                                    StatService.onEventAutoStatistic(linkedHashMap, hashMap);
                                                } catch (JSONException unused) {
                                                }
                                            }
                                        }
                                        if (parse.getActionParams().size() <= 2 || !SapiWebView.PROMPT_ON_CANCEL.equals(parse.getActionParams().get(2))) {
                                            if (this.this$1.this$0.asynJsMehodName.contains(actionName)) {
                                                return;
                                            }
                                            this.val$result.confirm(this.val$interpretResult[0]);
                                            return;
                                        }
                                        this.val$result.cancel();
                                        return;
                                    }
                                    this.val$result.cancel();
                                }
                            }
                        });
                        return true;
                    }
                    return invokeLLLLL.booleanValue;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048579, this, webView, i3) == null) {
                        if (this.this$0.progressBar != null) {
                            if (i3 == 100) {
                                this.this$0.progressBar.setVisibility(8);
                            } else {
                                if (this.this$0.progressBar.getVisibility() == 8) {
                                    this.this$0.progressBar.setVisibility(0);
                                }
                                this.this$0.progressBar.setProgress(i3);
                            }
                        }
                        super.onProgressChanged(webView, i3);
                    }
                }

                @Override // android.webkit.WebChromeClient
                @TargetApi(5)
                public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
                        quotaUpdater.updateQuota(j2 * 2);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048581, this, webView, valueCallback, fileChooserParams)) == null) {
                        if (this.this$0.fileChooserCallback != null) {
                            this.this$0.fileChooserCallback.onFileChooserForOSVersion5(valueCallback);
                            return true;
                        }
                        return true;
                    }
                    return invokeLLL.booleanValue;
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048583, this, valueCallback, str) == null) || this.this$0.fileChooserCallback == null) {
                        return;
                    }
                    this.this$0.fileChooserCallback.onFileChooser(valueCallback);
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048582, this, valueCallback) == null) || this.this$0.fileChooserCallback == null) {
                        return;
                    }
                    this.this$0.fileChooserCallback.onFileChooser(valueCallback);
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, valueCallback, str, str2) == null) || this.this$0.fileChooserCallback == null) {
                        return;
                    }
                    this.this$0.fileChooserCallback.onFileChooser(valueCallback);
                }
            });
            try {
                resumeTimers();
            } catch (Throwable th) {
                Log.e(th);
            }
            StatLoadLogin statLoadLogin2 = statLoadLogin;
            if (statLoadLogin2 != null) {
                statLoadLogin2.tWebviewInitDone = System.currentTimeMillis();
            }
        }
    }

    private boolean isValidPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) {
            for (String str : SapiContext.getInstance().getAuthorizedPackagesForUA()) {
                if (getContext().getPackageName().matches(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void loadChinaMobileLogin(int i2, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65589, this, i2, list) == null) {
            String str = addExtras(getLoginUrl(), list) + "&loginInitType=" + i2;
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                str = str + "&hideHelp=1";
            }
            loadUrl(str + URL_HASH_CHINA_MOBILE_OAUTH);
        }
    }

    private void loadFaceLogin(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, this, list) == null) {
            String addExtras = addExtras(getLoginUrl(), list);
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                addExtras = addExtras + "&enableExternalWeb=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                addExtras = addExtras + "&hideHelp=1";
            }
            loadUrl((addExtras + "&liveAbility=1") + URL_HASH_FACE_LOGIN);
        }
    }

    private void loadJoinLogin(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, this, list) == null) {
            String addExtras = addExtras(getLoginUrl(), list);
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                addExtras = addExtras + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                addExtras = addExtras + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                addExtras = addExtras + "&hideHelp=1";
            }
            loadUrl(addExtras + URL_HASH_JOIN_LOGIN);
        }
    }

    private void loadNameLogin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65592, this, i2) == null) {
            String str = addExtras(getLoginUrl(), this.extras) + "&loginInitType=" + i2;
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                str = str + "&hideHelp=1";
            }
            loadUrl(str + URL_HASH_INSERT_LOGIN);
        }
    }

    private void loadNormalLogin(int i2, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65593, this, i2, list) == null) {
            String str = addExtras(getLoginUrl(), list) + "&loginInitType=" + i2;
            if (i2 == 0) {
                if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                    str = str + "&enableExternalWeb=1";
                }
                if (this.configuration.supportFaceLogin) {
                    str = str + "&liveAbility=1";
                }
                if (this.configuration.isHideLoginHelpEntrance) {
                    str = str + "&hideHelp=1";
                }
                loadUrl(str + URL_HASH_LOGIN);
            } else if (i2 != 1) {
                loadUrl(str + URL_HASH_LOGIN);
            } else {
                if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                    str = str + "&enableExternalWeb=1";
                }
                if (this.configuration.supportFaceLogin) {
                    str = str + "&liveAbility=1";
                }
                if (this.configuration.isHideLoginHelpEntrance) {
                    str = str + "&hideHelp=1";
                }
                loadUrl(str + URL_HASH_SMS_LOGIN);
            }
        }
    }

    private void loadShareAccounts(int i2, List<PassNameValuePair> list) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65594, this, i2, list) == null) {
            String loginUrl = getLoginUrl();
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                loginUrl = loginUrl + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                loginUrl = loginUrl + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                loginUrl = loginUrl + "&hideHelp=1";
            }
            if (this.isSupFaceLogin && this.jsCallBacks.biometricsIdentifyCallback != null) {
                str = loginUrl + "&loginInitType=4";
            } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
                str = loginUrl + "&loginInitType=5";
            } else {
                str = loginUrl + "&loginInitType=" + i2;
            }
            loadUrl(addExtras(str, list) + URL_HASH_SHARE);
        }
    }

    private void loadUrlFromNetwork(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, this, str) == null) {
            post(new Runnable(this, str) { // from class: com.baidu.sapi2.SapiWebView.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$url = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.isDestory) {
                        return;
                    }
                    String fixAdapterParamValue = this.this$0.fixAdapterParamValue(this.val$url);
                    this.this$0.statLoadLogin(fixAdapterParamValue, false);
                    SapiWebView.super.loadUrl(fixAdapterParamValue);
                }
            });
            if (SapiUtils.hasActiveNetwork(getContext()) || str.startsWith("javascript:")) {
                return;
            }
            handleNetworkUnavailable();
        }
    }

    public static SocialResponse parseOpenApiAuthorizedResult(String str, Context context) {
        InterceptResult invokeLL;
        SocialResponse socialResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65596, null, str, context)) == null) {
            String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
            SocialResponse socialResponse2 = null;
            if (TextUtils.isEmpty(matcher)) {
                return null;
            }
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = newPullParser.getName();
                        if (!name.equalsIgnoreCase("data")) {
                            if (socialResponse2 == null && name.equalsIgnoreCase("error_code")) {
                                socialResponse = new SocialResponse();
                                try {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Exception e2) {
                                    socialResponse2 = socialResponse;
                                    e = e2;
                                    Log.e(e);
                                    return socialResponse2;
                                }
                            } else if (socialResponse2 == null && name.equalsIgnoreCase("error_description")) {
                                socialResponse = new SocialResponse();
                                socialResponse.errorMsg = newPullParser.nextText();
                            } else if (socialResponse2 == null) {
                                continue;
                            } else if (name.equalsIgnoreCase("error_code")) {
                                socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("error_description")) {
                                socialResponse2.errorMsg = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("is_binded")) {
                                socialResponse2.isBinded = "1".equals(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("display_name")) {
                                socialResponse2.displayname = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("passport_uname")) {
                                socialResponse2.username = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("bduid")) {
                                socialResponse2.uid = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("bduss")) {
                                socialResponse2.bduss = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                                socialResponse2.ptoken = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("os_username")) {
                                socialResponse2.socialUname = newPullParser.nextText();
                                socialResponse2.socialNickname = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                socialResponse2.socialPortraitUrl = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("os_name")) {
                                socialResponse2.socialNickname = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("os_type")) {
                                socialResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                continue;
                            } else if (name.equalsIgnoreCase("notice_offline")) {
                                socialResponse2.offlineNotice = "1".equals(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("guidebind")) {
                                socialResponse2.bindGuide = "1".equals(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("bind_conflict")) {
                                socialResponse2.bindConflict = "1".equals(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("wapsec")) {
                                socialResponse2.accountCenterFlag = "center".equals(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("next_url_related")) {
                                String nextText = newPullParser.nextText();
                                if (socialResponse2.accountCenterFlag) {
                                    socialResponse2.nextUrl = nextText;
                                    continue;
                                } else {
                                    continue;
                                }
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    socialResponse2.accountType = AccountType.NORMAL;
                                    continue;
                                } else if ("1".equals(nextText2)) {
                                    socialResponse2.accountType = AccountType.INCOMPLETE_USER;
                                    continue;
                                } else {
                                    socialResponse2.accountType = AccountType.UNKNOWN;
                                    continue;
                                }
                            } else if (name.equalsIgnoreCase("stoken")) {
                                String[] split = newPullParser.nextText().split("#");
                                socialResponse2.tplStokenMap.put(split[0], split[1]);
                                continue;
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                socialResponse2.actionType = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                                socialResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                                continue;
                            } else if (name.equals("livinguname")) {
                                socialResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                                continue;
                            } else if (name.equals("guest_account")) {
                                socialResponse2.isGuestAccount = newPullParser.nextText();
                                continue;
                            } else {
                                continue;
                            }
                            socialResponse2 = socialResponse;
                            continue;
                        } else if (socialResponse2 == null) {
                            socialResponse = new SocialResponse();
                            socialResponse2 = socialResponse;
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            return socialResponse2;
        }
        return (SocialResponse) invokeLL.objValue;
    }

    public static String replaceParams(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65597, null, str, str2, str3)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    int indexOf = str.indexOf(str2 + "=");
                    if (indexOf != -1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str.substring(0, indexOf));
                        sb.append(str2);
                        sb.append("=");
                        sb.append(str3);
                        int indexOf2 = str.indexOf("&", indexOf);
                        if (indexOf2 != -1) {
                            sb.append(str.substring(indexOf2));
                        } else {
                            int indexOf3 = str.indexOf("#", indexOf);
                            if (indexOf3 != -1) {
                                sb.append(str.substring(indexOf3));
                            }
                        }
                        return sb.toString();
                    }
                    return str;
                }
            } catch (Exception e2) {
                Log.e(Log.TAG, e2.getMessage());
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    private void setAsynJsMehodName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.asynJsMehodName = arrayList;
            arrayList.add("sapi_action_pick_image");
            this.asynJsMehodName.add("sapi_action_pick_date");
            this.asynJsMehodName.add("sapi_action_third_safety_verification");
            this.asynJsMehodName.add("sapi_biometrics_identification");
            this.asynJsMehodName.add("sapi_biometrics_identification_no_bduss");
            this.asynJsMehodName.add("sapi_biometrics_identification_with_authtoken");
            this.asynJsMehodName.add("sapi_biometrics_identification_with_uid");
            this.asynJsMehodName.add("sapi_action_sc_app_invoke");
            this.asynJsMehodName.add("oauth_sso_hash");
            this.asynJsMehodName.add("sapi_action_china_mobile_oauth");
            this.asynJsMehodName.add("address_manage_get_contact");
            this.asynJsMehodName.add("touchid_open_guide");
            this.asynJsMehodName.add("touchid_change_status");
            this.asynJsMehodName.add("touchid_login");
            this.asynJsMehodName.add("speech_recognition_get_content");
            this.asynJsMehodName.add("sapi_onekey_oauth_token");
            this.asynJsMehodName.add("sapi_biometrics_identification_live");
            this.asynJsMehodName.add("sapi_idcard_ocr_image");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statLoadLogin(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65599, this, str, z) == null) || statLoadLogin == null) {
            return;
        }
        if (str.contains(URL_HASH_LOGIN) || str.contains(URL_HASH_SHARE) || str.contains(URL_HASH_JOIN_LOGIN) || str.contains(URL_HASH_FAST_REG) || str.contains(URL_HASH_SMS_LOGIN) || (this.isSupFaceLogin && str.contains(URL_HASH_FACE_LOGIN))) {
            statLoadLogin.tLoadLogin = System.currentTimeMillis();
            statLoadLogin.isLoadCache = z;
        }
    }

    private void statStartLogin(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65600, this, str) == null) || statLoadLogin == null) {
            return;
        }
        if (str.contains(URL_HASH_LOGIN) || str.contains(URL_HASH_SHARE) || str.contains(URL_HASH_JOIN_LOGIN) || str.contains(URL_HASH_FAST_REG) || str.contains(URL_HASH_SMS_LOGIN) || (this.isSupFaceLogin && str.contains(URL_HASH_FACE_LOGIN))) {
            statLoadLogin.tStartLogin = System.currentTimeMillis();
        }
    }

    public void asyncCommonCookie(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            List<PassNameValuePair> buildDeviceInfoCookie = buildDeviceInfoCookie();
            List<PassNameValuePair> buildDarkModeCookie = buildDarkModeCookie();
            if (list != null && !list.isEmpty()) {
                buildDeviceInfoCookie.addAll(list);
            }
            if (buildDarkModeCookie != null && !buildDarkModeCookie.isEmpty()) {
                buildDeviceInfoCookie.addAll(buildDarkModeCookie);
            }
            SapiUtils.syncCookies(getContext(), buildDeviceInfoCookie);
        }
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activityLifeCycle) == null) || getSettings().getBlockNetworkLoads()) {
            return;
        }
        loadUrl(generateJSStr(activityLifeCycle.methodName));
    }

    public void back() {
        View view;
        View view2;
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.shouldClose && (progressBar = this.progressBar) != null && progressBar.getVisibility() == 0) {
                finish();
            } else if (this.shouldClose && (view = this.webviewLoadingView) != null && view.getVisibility() == 0) {
                finish();
            } else if (this.onNewBackCallback == null || this.jsCallBacks.rrLoginResponse != null) {
                super.loadUrl(FN_SWITCH_VIEW);
                handleOpenApiAuthorizeResponse(this.jsCallBacks.rrLoginResponse);
            } else {
                SapiUtils.hideSoftInput((Activity) getContext());
                this.onNewBackCallback.onBack();
            }
            View view3 = this.noNetworkView;
            if ((view3 == null || view3.getVisibility() != 0) && ((view2 = this.timeoutView) == null || view2.getVisibility() != 0)) {
                return;
            }
            finish();
        }
    }

    public String buildBindBdussCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? SapiUtils.buildBDUSSCookie(this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "") : (String) invokeV.objValue;
    }

    public List<PassNameValuePair> buildCommonParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.configuration.supportFaceLogin) {
                SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
                if (callBacks.bioScanFaceCallback != null && callBacks.biometricsIdentifyCallback != null) {
                    arrayList.add(new PassNameValuePair("liveAbility", "1"));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<PassNameValuePair> buildDarkModeCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String replaceAll = this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            if (this.configuration.isDarkMode) {
                arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, SkinManager.SKIN_TYPE_STR_DARK)));
                arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, SkinManager.SKIN_TYPE_STR_DARK)));
            } else {
                arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, SensorController.KEY_LIGHT)));
                arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, SensorController.KEY_LIGHT)));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<PassNameValuePair> buildDeviceInfoCookie() {
        InterceptResult invokeV;
        String diCookieInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> loginCookieDiKeys = SapiContext.getInstance().getSapiOptions().getLoginCookieDiKeys();
            ArrayList arrayList = new ArrayList();
            String replaceAll = this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            Log.e("APP_VERSION", "wap_pass=" + replaceAll, ", passport=" + replaceAll2);
            if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
                diCookieInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
            } else {
                diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
            }
            arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo == null ? "" : diCookieInfo)));
            arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDeviceInfoCookie(replaceAll2, "DVIF", diCookieInfo != null ? diCookieInfo : "")));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.destroy();
            this.isDestory = true;
            this.timeoutHandler.removeCallbacks(this.timeoutTask);
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                CookieManager.getInstance().flush();
            }
        }
    }

    public void dismissProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;

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
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.progressDialog != null && this.this$0.progressDialog.isShowing()) {
                        try {
                            this.this$0.progressDialog.dismiss();
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            finish("");
        }
    }

    public String getAccountCenterUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getAccountCenterUrl(str) + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeL.objValue;
    }

    public String getAddressManageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getAddressManageUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeV.objValue;
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bindWidgetAction)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getBindWidgetUrl(bindWidgetAction) + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeL.objValue;
    }

    public String getForgetPwdUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getForgetPwdUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeV.objValue;
    }

    public String getHashUrl(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
            if (str2.split("#").length > 1) {
                SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
                String cacheModuleId = this.sapiCache.getCacheModuleId(str2);
                String str3 = "";
                if (this.sapiCache.getModuleById(cacheModuleId) != null) {
                    String str4 = this.sapiCache.getModuleById(cacheModuleId).hash;
                    String md5 = SecurityUtil.md5(str.getBytes(), false);
                    SapiOptions.Cache cache = sapiOptions.getCache();
                    String version = cache != null ? cache.getVersion() : "";
                    if (str4.equals(md5)) {
                        if (!TextUtils.isEmpty(version)) {
                            str3 = "&passAppVersion=" + version;
                        }
                        str3 = str3 + "&passAppHash=" + this.sapiCache.getModuleById(cacheModuleId).hash;
                    } else {
                        str3 = "&passAppHash=" + SecurityUtil.md5(str.getBytes(), false);
                    }
                }
                return split[0] + str3 + "#" + split[1];
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public String getInvoiceBuildUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getInvoiceBuildUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeV.objValue;
    }

    public SapiJsCallBacks.CallBacks getJsCallBacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.jsCallBacks : (SapiJsCallBacks.CallBacks) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getLocalPhoneNumber() {
        InterceptResult invokeV;
        String line1Number;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048594, this)) != null) {
            return (String) invokeV.objValue;
        }
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        if (SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext())) {
            try {
                line1Number = telephonyManager.getLine1Number();
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(line1Number)) {
                return line1Number.replace("+86", "");
            }
            return null;
        }
        line1Number = null;
        if (TextUtils.isEmpty(line1Number)) {
        }
    }

    public String getLoginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? SapiAccountManager.getInstance().getAccountService().getLoginUrl() : (String) invokeV.objValue;
    }

    public String getNormalizeGuestAccountUrl(SocialType socialType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socialType)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getNormalizeGuestAccountUrl(socialType) + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeL.objValue;
    }

    public String getRealnameAuthenticateUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getRealnameAuthenticateUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeV.objValue;
    }

    public String getSwitchAccountUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getSwitchAccountUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeV.objValue;
    }

    public long getTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.timeoutMillis : invokeV.longValue;
    }

    public String getUaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String str = !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
            String str2 = TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE;
            String encode = URLEncoder.encode("Sapi_9.3.7.1_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + str + "_" + str2 + "_Sapi");
            if (!isValidPackage() || TextUtils.isEmpty(this.configuration.userAgent)) {
                return encode;
            }
            return encode + " " + this.configuration.userAgent;
        }
        return (String) invokeV.objValue;
    }

    public String getUniteVerifyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return SapiAccountManager.getInstance().getAccountService().getUniteVerifyUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
        }
        return (String) invokeV.objValue;
    }

    public void handleAuthorizeResponse(SapiAccountResponse sapiAccountResponse) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, sapiAccountResponse) == null) || sapiAccountResponse == null) {
            return;
        }
        SapiAccount sapiAccountResponseToAccount = sapiAccountResponseToAccount(sapiAccountResponse);
        if (this.jsCallBacks.authorizationListener != null) {
            post(new Runnable(this, sapiAccountResponseToAccount, sapiAccountResponse) { // from class: com.baidu.sapi2.SapiWebView.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;
                public final /* synthetic */ SapiAccountResponse val$response;
                public final /* synthetic */ SapiAccount val$sapiAccount;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sapiAccountResponseToAccount, sapiAccountResponse};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sapiAccount = sapiAccountResponseToAccount;
                    this.val$response = sapiAccountResponse;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.jsCallBacks.authorizationListener.beforeSuccess(this.val$sapiAccount);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiAccountManager.getInstance().validate(this.val$sapiAccount);
                        this.this$0.authorizeSuccess(this.val$response.accountType);
                        SapiStatUtil.statShareV1Login(this.val$sapiAccount, this.this$0.extras);
                    }
                }
            });
        }
    }

    public void handleOpenApiAuthorizeResponse(SocialResponse socialResponse) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, socialResponse) == null) || socialResponse == null) {
            return;
        }
        SapiAccount sapiAccountResponseToAccount = sapiAccountResponseToAccount(socialResponse);
        if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (socialResponse.accountCenterFlag && ((i2 = socialResponse.errorCode) == 0 || i2 == 110000)) {
            post(new Runnable(this, socialResponse, sapiAccountResponseToAccount) { // from class: com.baidu.sapi2.SapiWebView.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;
                public final /* synthetic */ SocialResponse val$response;
                public final /* synthetic */ SapiAccount val$sapiAccount;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, socialResponse, sapiAccountResponseToAccount};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$response = socialResponse;
                    this.val$sapiAccount = sapiAccountResponseToAccount;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.loadUrl(this.val$response.nextUrl);
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        SapiAccountManager.getInstance().validate(this.val$sapiAccount);
                        if (this.this$0.accountChangeCallback == null || currentAccount.uid.equals(this.val$sapiAccount.uid)) {
                            return;
                        }
                        this.this$0.accountChangeCallback.onAccountChange();
                    }
                }
            });
        } else if (this.jsCallBacks.authorizationListener != null) {
            int i3 = socialResponse.errorCode;
            if (i3 != 0 && i3 != 110000) {
                post(new Runnable(this, socialResponse) { // from class: com.baidu.sapi2.SapiWebView.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiWebView this$0;
                    public final /* synthetic */ SocialResponse val$response;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, socialResponse};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$response = socialResponse;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.this$0.jsCallBacks.authorizationListener != null) {
                                AuthorizationListener authorizationListener = this.this$0.jsCallBacks.authorizationListener;
                                SocialResponse socialResponse2 = this.val$response;
                                authorizationListener.onFailed(socialResponse2.errorCode, socialResponse2.errorMsg);
                            }
                            this.this$0.jsCallBacks.rrLoginResponse = null;
                        }
                    }
                });
            } else {
                post(new Runnable(this, sapiAccountResponseToAccount) { // from class: com.baidu.sapi2.SapiWebView.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiWebView this$0;
                    public final /* synthetic */ SapiAccount val$sapiAccount;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sapiAccountResponseToAccount};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$sapiAccount = sapiAccountResponseToAccount;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.this$0.jsCallBacks.authorizationListener != null) {
                                    this.this$0.jsCallBacks.authorizationListener.beforeSuccess(this.val$sapiAccount);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            SapiAccountManager.getInstance().validate(this.val$sapiAccount);
                            this.this$0.authorizeSuccess(AccountType.UNKNOWN);
                            this.this$0.jsCallBacks.rrLoginResponse = null;
                        }
                    }
                });
            }
        }
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, list, str) == null) {
            loadAccountCenter(list, str, ACCOUNT_CENTER);
        }
    }

    public void loadAccountRealName(String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, str2, Boolean.valueOf(z), str3}) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new PassNameValuePair("scene", str2));
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new PassNameValuePair("customLink", str3));
            }
            arrayList.add(new PassNameValuePair("needcbkey", z ? "1" : "0"));
            loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
        }
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            loadUrl(addExtras(getAddressManageUrl(), list));
        }
    }

    public void loadAuthWidget(List<PassNameValuePair> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, list, z) == null) {
            loadUrl(addExtras(SapiAccountManager.getInstance().getAccountService().getAuthWidgetUrl(z), list));
        }
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{bindWidgetAction, str, str2, Boolean.valueOf(z), list}) == null) {
            if (bindWidgetAction != null) {
                if (!TextUtils.isEmpty(str)) {
                    webLogin(getContext(), str);
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(new PassNameValuePair("skin", str2));
                    }
                    if (z) {
                        arrayList.add(new PassNameValuePair(FreeSpaceBox.TYPE, "1"));
                    }
                    if (this.configuration.supportFaceLogin) {
                        arrayList.add(new PassNameValuePair("liveAbility", "1"));
                    }
                    String bindWidgetUrl = getBindWidgetUrl(bindWidgetAction);
                    if (arrayList.size() > 0) {
                        bindWidgetUrl = bindWidgetUrl + "&" + SapiUtils.createRequestParams(arrayList);
                    }
                    String addExtras = addExtras(bindWidgetUrl, list);
                    String buildBindBdussCookie = buildBindBdussCookie();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new PassNameValuePair(this.configuration.environment.getWap(), buildBindBdussCookie));
                    loadUrl(addExtras, arrayList2);
                    return;
                }
                throw new IllegalArgumentException("bduss can't be empty");
            }
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048610, this, str, str2, str3, str4, str5) == null) {
            if (Build.VERSION.SDK_INT > 7) {
                getSettings().setBlockNetworkLoads(true);
            }
            post(new Runnable(this, str, str2, str3, str4, str5) { // from class: com.baidu.sapi2.SapiWebView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;
                public final /* synthetic */ String val$baseUrl;
                public final /* synthetic */ String val$data;
                public final /* synthetic */ String val$encoding;
                public final /* synthetic */ String val$failUrl;
                public final /* synthetic */ String val$mimeType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, str4, str5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$baseUrl = str;
                    this.val$data = str2;
                    this.val$mimeType = str3;
                    this.val$encoding = str4;
                    this.val$failUrl = str5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String[] split;
                    String str6;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.isDestory) {
                        return;
                    }
                    if (this.val$baseUrl.split("#").length > 0) {
                        str6 = split[0] + "&loadDataWithBaseUrl=1#" + split[1];
                    } else {
                        str6 = this.val$baseUrl + "&loadDataWithBaseUrl=1";
                    }
                    this.this$0.statLoadLogin(this.val$baseUrl, true);
                    SapiWebView.super.loadDataWithBaseURL(str6, this.val$data, this.val$mimeType, this.val$encoding, this.val$failUrl);
                }
            });
        }
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, list) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!str.contains(BROWSE_MODE_AGREEMENT_HOST)) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(new PassNameValuePair("clientfrom", "native"));
                    list.add(new PassNameValuePair("client", "android"));
                    list.add(new PassNameValuePair("deliverParams", "1"));
                    if (this.configuration.supportFaceLogin) {
                        list.add(new PassNameValuePair("scanface", "1"));
                    }
                    if (this.jsCallBacks.pickPhotoCallback != null && this.configuration.supportPhoto) {
                        list.add(new PassNameValuePair("support_photo", "1"));
                    }
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        int i2 = indexOf + 1;
                        str = str.substring(0, i2) + SapiUtils.createRequestParams(list) + "&" + str.substring(i2, str.length());
                    } else {
                        str = str + "?" + SapiUtils.createRequestParams(list);
                    }
                }
                loadUrl(str);
                return;
            }
            throw new IllegalArgumentException("externalUrl can't be empty");
        }
    }

    public void loadForgetPwd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            loadForgetPwd(null);
        }
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, list) == null) {
            loadUrl(addExtras(ParamsUtil.getUrlBind(this.configuration, SocialType.HUAWEI, str, null, null), list));
        }
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, list) == null) {
            loadUrl(addExtras(getInvoiceBuildUrl(), list));
        }
    }

    public void loadIqiyiBindServer(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, str) == null) || str == null) {
            return;
        }
        String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), buildIqiyiCookie));
        loadUrl(str, arrayList);
    }

    public void loadLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            loadLogin(0, null);
        }
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048620, this, list, str, socialType) == null) {
            webLogin(getContext(), str);
            loadUrl(addExtras(getNormalizeGuestAccountUrl(socialType), list));
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048621, this, qrLoginCallback, str, z) == null) {
            SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
            callBacks.qrLoginCallback = qrLoginCallback;
            callBacks.finishPage = z;
            loadUrl(str + "&suppcheck=1");
        }
    }

    public void loadRealnameAuthenticate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.configuration.realnameAuthenticateStoken)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("pp");
                    SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback(this, str) { // from class: com.baidu.sapi2.SapiWebView.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiWebView this$0;
                        public final /* synthetic */ String val$bduss;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$bduss = str;
                        }

                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            }
                        }

                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onFailure(GetTplStokenResult getTplStokenResult) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, getTplStokenResult) == null) || this.this$0.jsCallBacks.realnameAuthenticateCallback == null) {
                                return;
                            }
                            this.this$0.jsCallBacks.realnameAuthenticateCallback.onFailure();
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onSuccess(GetTplStokenResult getTplStokenResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048580, this, getTplStokenResult) == null) {
                                String realnameAuthenticateUrl = this.this$0.getRealnameAuthenticateUrl();
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new PassNameValuePair("bduss", this.val$bduss));
                                arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                                arrayList2.add(new PassNameValuePair("bdstoken", this.this$0.configuration.realnameAuthenticateStoken));
                                this.this$0.loadUrl(realnameAuthenticateUrl + "&" + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
                            }
                        }
                    }, str, arrayList);
                    return;
                }
                throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
            }
            throw new IllegalArgumentException("bduss can't be empty");
        }
    }

    public void loadRegist(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, list) == null) {
            String loginUrl = getLoginUrl();
            loadUrl(addExtras(loginUrl, list) + URL_HASH_REG);
        }
    }

    public void loadShareV2Login() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            loadUrl((SapiAccountManager.getInstance().getAccountService().getWapShareLoginUrl() + "&adapter=3") + URL_HASH_SHARE_OAUTH);
        }
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, list) == null) {
            loadUrl(addExtras(getSwitchAccountUrl(), list));
        }
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, str2, str3, str4, str5, str6, str7}) == null) {
            this.isLoadThirdPartyUrl = true;
            this.userInfoXmlContent = str2;
            ArrayList arrayList = new ArrayList();
            String url = this.configuration.environment.getURL();
            arrayList.add(new PassNameValuePair(url, str3));
            arrayList.add(new PassNameValuePair("https://baidu.com", str4));
            arrayList.add(new PassNameValuePair("https://baidu.com", str5));
            arrayList.add(new PassNameValuePair(url, str6));
            arrayList.add(new PassNameValuePair(url, str7));
            loadUrl(str, arrayList);
        }
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048627, this, str, str2, str3) == null) {
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(new PassNameValuePair("token", URLEncoder.encode(str, "UTF-8")));
                    if (str2 != null) {
                        arrayList.add(new PassNameValuePair("u", str2));
                    }
                    if (str3 != null) {
                        arrayList.add(new PassNameValuePair("adtext", URLEncoder.encode(str3, "UTF-8")));
                    }
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
                String uniteVerifyUrl = getUniteVerifyUrl();
                loadUrl(uniteVerifyUrl + "&" + SapiUtils.createRequestParams(arrayList));
                return;
            }
            throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        loadUrl(fixAdapterParamValue(str), Collections.emptyList());
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, canvas) == null) {
            super.onDraw(canvas);
        }
    }

    public boolean onKeyUp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            if (i2 == 4 && this.leftBtnIsVisible == 1) {
                OnBackCallback onBackCallback = this.onBackCallback;
                if (onBackCallback != null && this.jsCallBacks.rrLoginResponse == null) {
                    onBackCallback.onBack();
                }
                back();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048632, this, i2, i3, i4, i5) == null) {
            ProgressBar progressBar = this.progressBar;
            if (progressBar != null) {
                AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar.getLayoutParams();
                layoutParams.x = i2;
                layoutParams.y = i3;
                this.progressBar.setLayoutParams(layoutParams);
            }
            super.onScrollChanged(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z)})) == null) {
            View view = this.noNetworkView;
            if (view == null || view.getVisibility() != 0) {
                View view2 = this.timeoutView;
                if (view2 == null || view2.getVisibility() != 0) {
                    return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public SapiAccountResponse parseAuthorizedResult(String str, Context context) {
        InterceptResult invokeLL;
        SapiAccountResponse sapiAccountResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, str, context)) == null) {
            String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
            SapiAccountResponse sapiAccountResponse2 = null;
            if (TextUtils.isEmpty(matcher)) {
                return null;
            }
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
                int eventType = newPullParser.getEventType();
                boolean z = false;
                while (true) {
                    boolean z2 = true;
                    if (eventType == 1) {
                        break;
                    }
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = newPullParser.getName();
                        if (!name.equalsIgnoreCase("data")) {
                            if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_code")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                try {
                                    sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Throwable th) {
                                    sapiAccountResponse2 = sapiAccountResponse;
                                    th = th;
                                    Log.e(th);
                                    if (sapiAccountResponse2 != null) {
                                        sapiAccountResponse2.errorCode = 0;
                                    }
                                    return sapiAccountResponse2;
                                }
                            } else if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_description")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                            } else if (sapiAccountResponse2 == null) {
                                continue;
                            } else if (name.equalsIgnoreCase("errno")) {
                                sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                                continue;
                            } else if (name.equalsIgnoreCase("uname")) {
                                sapiAccountResponse2.username = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                sapiAccountResponse2.errorMsg = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("bduss")) {
                                sapiAccountResponse2.bduss = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                                sapiAccountResponse2.ptoken = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("stoken")) {
                                if (z) {
                                    String[] split = newPullParser.nextText().split("#");
                                    if (split != null && split.length > 1) {
                                        sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                        continue;
                                    }
                                } else {
                                    sapiAccountResponse2.stoken = newPullParser.nextText();
                                    continue;
                                }
                            } else if (name.equalsIgnoreCase("displayname")) {
                                sapiAccountResponse2.displayname = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("uid")) {
                                sapiAccountResponse2.uid = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("authsid")) {
                                String nextText = newPullParser.nextText();
                                sapiAccountResponse2.authSid = nextText;
                                if (TextUtils.isEmpty(nextText)) {
                                    z2 = false;
                                }
                                sapiAccountResponse2.newReg = z2;
                                continue;
                            } else if (name.equalsIgnoreCase("stoken_list")) {
                                z = true;
                                continue;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("os_name")) {
                                sapiAccountResponse2.socialNickname = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase("os_type")) {
                                sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                continue;
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.NORMAL;
                                    continue;
                                } else if ("1".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                    continue;
                                } else {
                                    sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                    continue;
                                }
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                sapiAccountResponse2.actionType = newPullParser.nextText();
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                                sapiAccountResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                                continue;
                            } else if (name.equals("livinguname")) {
                                sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                                continue;
                            } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                                String nextText3 = newPullParser.nextText();
                                if ("oneKeyLogin".equals(nextText3)) {
                                    nextText3 = new OneKeyLoginSdkCall().getOperatorType();
                                }
                                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText3);
                                continue;
                            } else if (name.equals("mobilephone")) {
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                                continue;
                            } else if (name.equals("app")) {
                                sapiAccountResponse2.app = newPullParser.nextText();
                                continue;
                            } else if (name.equals("extra")) {
                                sapiAccountResponse2.extra = newPullParser.nextText();
                                continue;
                            } else if (name.equals("portraitSign")) {
                                sapiAccountResponse2.portraitSign = newPullParser.nextText();
                                continue;
                            } else if (name.equals("portrait")) {
                                sapiAccountResponse2.portraitSign = newPullParser.nextText().replace("https://himg.bdimg.com/sys/portrait/item/", "").replace("http://himg.bdimg.com/sys/portrait/item/", "").replace(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX, "");
                                continue;
                            } else if (name.equals("guest_account")) {
                                sapiAccountResponse2.isGuestAccount = newPullParser.nextText();
                                continue;
                            } else {
                                continue;
                            }
                            sapiAccountResponse2 = sapiAccountResponse;
                            continue;
                        } else if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse2 = sapiAccountResponse;
                            continue;
                        } else {
                            continue;
                        }
                    }
                    eventType = newPullParser.next();
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
                sapiAccountResponse2.errorCode = 0;
            }
            return sapiAccountResponse2;
        }
        return (SapiAccountResponse) invokeLL.objValue;
    }

    public void preSetUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            String str = this.reloadConfig.timeoutUrl;
            if (str != null) {
                loadUrl(str);
            } else {
                super.reload();
            }
            this.reloadConfig.reset();
        }
    }

    public SapiAccount sapiAccountResponseToAccount(SapiAccountResponse sapiAccountResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, sapiAccountResponse)) == null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = sapiAccountResponse.uid;
            sapiAccount.bduss = sapiAccountResponse.bduss;
            sapiAccount.displayname = sapiAccountResponse.displayname;
            sapiAccount.stoken = sapiAccountResponse.stoken;
            sapiAccount.ptoken = sapiAccountResponse.ptoken;
            sapiAccount.email = sapiAccountResponse.email;
            sapiAccount.username = sapiAccountResponse.username;
            sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(getContext()) : sapiAccountResponse.app;
            sapiAccount.extra = sapiAccountResponse.extra;
            sapiAccount.portrait = sapiAccountResponse.portraitSign;
            sapiAccount.fromType = sapiAccountResponse.fromType.getValue();
            if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
                sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname);
                sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
            }
            sapiAccount.putExtra("tpl", this.configuration.tpl);
            if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
                sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
            }
            SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
            sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
            if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
                new FaceLoginService().syncFaceLoginUID(getContext(), sapiAccountResponse.livingUname);
            }
            return sapiAccount;
        }
        return (SapiAccount) invokeL.objValue;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048638, this, i2, i3) == null) {
            View view2 = this.noNetworkView;
            if ((view2 != null && view2.getVisibility() == 0) || ((view = this.timeoutView) != null && view.getVisibility() == 0)) {
                super.scrollTo(0, 0);
            }
            super.scrollTo(i2, i3);
        }
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, accountChangeCallback) == null) {
            this.accountChangeCallback = accountChangeCallback;
        }
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, accountDestoryCallback) == null) {
            this.jsCallBacks.accountDestoryCallback = accountDestoryCallback;
        }
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, accountFreezeCallback) == null) {
            this.jsCallBacks.accountFreezeCallback = accountFreezeCallback;
        }
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, authorizationListener) == null) {
            this.jsCallBacks.authorizationListener = authorizationListener;
        }
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bdOauthLoginParams) == null) {
            this.jsCallBacks.bdOauthLoginParams = bdOauthLoginParams;
        }
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, bdussChangeCallback) == null) {
            this.jsCallBacks.bdussChangeCallback = bdussChangeCallback;
        }
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bindWidgetCallback) == null) {
            this.jsCallBacks.bindWidgetCallback = bindWidgetCallback;
        }
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, bioScanFaceCallback) == null) {
            this.jsCallBacks.bioScanFaceCallback = bioScanFaceCallback;
        }
    }

    public void setBiometricsIdentificationLiveCallBack(SapiJsCallBacks.BiometricsIdentificationLiveCallBack biometricsIdentificationLiveCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, biometricsIdentificationLiveCallBack) == null) {
            this.jsCallBacks.biometricsIdentificationLiveCallBack = biometricsIdentificationLiveCallBack;
        }
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, biometricsIdentifyCallback) == null) {
            this.jsCallBacks.biometricsIdentifyCallback = biometricsIdentifyCallback;
        }
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, changePwdCallback) == null) {
            this.changePwdCallback = changePwdCallback;
        }
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, coverWebBdussCallback) == null) {
            this.jsCallBacks.coverWebBdussCallback = coverWebBdussCallback;
        }
    }

    public void setCurrentAccountBdussExpiredCallback(SapiJsCallBacks.CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, currentAccountBdussExpiredCallback) == null) {
            this.jsCallBacks.currentAccountBdussExpiredCallback = currentAccountBdussExpiredCallback;
        }
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, directedLoginParams) == null) {
            this.jsCallBacks.directedLoginParams = directedLoginParams;
        }
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, fileChooserCallback) == null) {
            this.fileChooserCallback = fileChooserCallback;
        }
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, fingerprintCallback) == null) {
            this.jsCallBacks.fingerprintCallback = fingerprintCallback;
        }
    }

    public void setFocusEdittextCoordinateYCallBack(SapiJsCallBacks.FocusEdittextCoordinateYCallBack focusEdittextCoordinateYCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, focusEdittextCoordinateYCallBack) == null) {
            this.jsCallBacks.focusEdittextCoordinateYCallBack = focusEdittextCoordinateYCallBack;
        }
    }

    public void setGetCurrentPageNameCallback(SapiJsCallBacks.GetCurrentPageNameCallback getCurrentPageNameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, getCurrentPageNameCallback) == null) {
            this.jsCallBacks.getCurrentPageNameCallback = getCurrentPageNameCallback;
        }
    }

    public void setGrantWebCallback(SapiJsCallBacks.GrantWebCallback grantWebCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, grantWebCallback) == null) {
            this.jsCallBacks.grantWebCallback = grantWebCallback;
        }
    }

    public void setHadMakeBarHide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.mHadMakeBarHide = z;
        }
    }

    public void setHideSuccessTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.jsCallBacks.hideSuccessTip = z;
        }
    }

    public void setIdcardOcrImageCallBack(SapiJsCallBacks.IdcardOcrImageCallBack idcardOcrImageCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, idcardOcrImageCallBack) == null) {
            this.jsCallBacks.idcardOcrImageCallBack = idcardOcrImageCallBack;
        }
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, invoiceBuildCallback) == null) {
            this.jsCallBacks.invoiceBuildCallback = invoiceBuildCallback;
        }
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, invokeScAppCallback) == null) {
            this.jsCallBacks.invokeScAppCallback = invokeScAppCallback;
        }
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, joinLoginParams) == null) {
            this.jsCallBacks.joinLoginParams = joinLoginParams;
        }
    }

    public void setJumpToUriCallBack(SapiJsCallBacks.JumpToUriCallBack jumpToUriCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, jumpToUriCallBack) == null) {
            this.jsCallBacks.jumpToUriCallBack = jumpToUriCallBack;
        }
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, leftBtnVisibleCallback) == null) {
            this.jsCallBacks.leftBtnVisibleCallback = leftBtnVisibleCallback;
        }
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, loadExternalWebViewCallback) == null) {
            this.jsCallBacks.loadExternalWebViewCallback = loadExternalWebViewCallback;
        }
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, loadSlideWebViewCallback) == null) {
            this.jsCallBacks.loadSlideWebViewCallback = loadSlideWebViewCallback;
        }
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, localConfigCallback) == null) {
            this.jsCallBacks.localConfigCallback = localConfigCallback;
        }
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, loginStatusChangeCallback) == null) {
            this.jsCallBacks.loginStatusChangeCallback = loginStatusChangeCallback;
        }
    }

    public void setMakeVibrateCallBack(SapiJsCallBacks.MakeVibrateCallBack makeVibrateCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, makeVibrateCallBack) == null) {
            this.jsCallBacks.makeVibrateCallBack = makeVibrateCallBack;
        }
    }

    public final void setNoNetworkView(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048671, this, view) == null) && this.noNetworkView == null) {
            this.noNetworkView = view;
            view.setVisibility(4);
            addView(this.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048672, this, normalizeGuestAccountCallback, str) == null) {
            SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
            callBacks.normalizeGuestAccountCallback = normalizeGuestAccountCallback;
            callBacks.normalizeGuestAccountDesc = str;
        }
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, onBackCallback) == null) {
            this.onBackCallback = onBackCallback;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, onFinishCallback) == null) {
            this.onFinishCallback = onFinishCallback;
        }
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, onNewBackCallback) == null) {
            this.onNewBackCallback = onNewBackCallback;
        }
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, onSlidePageFinishCallback) == null) {
            this.jsCallBacks.onSlidePageFinishCallback = onSlidePageFinishCallback;
        }
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, pageStateCallback) == null) {
            this.jsCallBacks.pageStateCallback = pageStateCallback;
        }
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, pickPhotoCallback) == null) {
            this.jsCallBacks.pickPhotoCallback = pickPhotoCallback;
        }
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, preFillUserNameCallback) == null) {
            this.jsCallBacks.prefillUserNameCallback = preFillUserNameCallback;
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048680, this, progressBar) == null) && this.progressBar == null) {
            this.progressBar = progressBar;
            if (progressBar != null) {
                addView(progressBar);
            }
        }
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, realNameStatusCallback) == null) {
            this.jsCallBacks.realNameStatusCallback = realNameStatusCallback;
        }
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, realnameAuthenticateCallback) == null) {
            this.jsCallBacks.realnameAuthenticateCallback = realnameAuthenticateCallback;
        }
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, shareAccountClickCallback) == null) {
            this.jsCallBacks.shareAccountClickCallback = shareAccountClickCallback;
        }
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, shareV2LoginParams) == null) {
            this.jsCallBacks.shareV2LoginParams = shareV2LoginParams;
        }
    }

    public void setSocialLoginHandler(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, handler) == null) {
            this.jsCallBacks.socialLoginHandler = handler;
        }
    }

    public void setSocialVerificationHandler(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, handler) == null) {
            this.jsCallBacks.socialVerificationHandler = handler;
        }
    }

    public void setSpeechRecognitionCallback(SapiJsCallBacks.SpeechRecognitionCallback speechRecognitionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, speechRecognitionCallback) == null) {
            this.jsCallBacks.speechRecognitionCallback = speechRecognitionCallback;
        }
    }

    public void setStopSlideWebviewCallback(SapiJsCallBacks.StopSlideWebviewCallback stopSlideWebviewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, stopSlideWebviewCallback) == null) {
            this.jsCallBacks.stopSlideWebviewCallback = stopSlideWebviewCallback;
        }
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, switchAccountCallback) == null) {
            this.jsCallBacks.switchAccountCallback = switchAccountCallback;
        }
    }

    public void setSwitchStyleForCloseBtnAndStatusBarCallBack(SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack switchStyleForCloseBtnAndStatusBarCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, switchStyleForCloseBtnAndStatusBarCallBack) == null) {
            this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack = switchStyleForCloseBtnAndStatusBarCallBack;
        }
    }

    public void setTimeoutMillis(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048691, this, j2) == null) {
            this.timeoutMillis = j2;
        }
    }

    public final void setTimeoutView(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048692, this, view) == null) && this.timeoutView == null) {
            this.timeoutView = view;
            view.setVisibility(4);
            addView(this.timeoutView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, uniteVerifyCallback) == null) {
            this.jsCallBacks.uniteVerifyCallback = uniteVerifyCallback;
        }
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, webChromeClientCallback) == null) {
            this.webChromeClientCallback = webChromeClientCallback;
        }
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, webViewTitleCallback) == null) {
            this.jsCallBacks.webViewTitleCallback = webViewTitleCallback;
        }
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, webviewClientCallback) == null) {
            this.webviewClientCallback = webviewClientCallback;
        }
    }

    public void setWebviewLoadingView(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048697, this, view) == null) && this.webviewLoadingView == null) {
            this.webviewLoadingView = view;
            view.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, webviewPageFinishCallback) == null) {
            this.jsCallBacks.webviewPageFinishCallback = webviewPageFinishCallback;
        }
    }

    public void showProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;

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
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.progressDialog = ProgressDialog.show(this.this$0.getContext(), null, "加载中...", true);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            try {
                super.stopLoading();
            } catch (NullPointerException unused) {
            }
        }
    }

    public void webLogin(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048701, this, context, str) == null) {
            SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
        }
    }

    public void finish(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            post(new Runnable(this, str) { // from class: com.baidu.sapi2.SapiWebView.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView this$0;
                public final /* synthetic */ String val$pageName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$pageName = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.isDestory) {
                        return;
                    }
                    SapiUtils.hideSoftInput((Activity) this.this$0.getContext());
                    if (TextUtils.isEmpty(this.val$pageName)) {
                        if (this.this$0.onFinishCallback != null) {
                            this.this$0.onFinishCallback.onFinish();
                        }
                    } else if (this.this$0.jsCallBacks.onSlidePageFinishCallback != null) {
                        this.this$0.jsCallBacks.onSlidePageFinishCallback.onFinish(this.val$pageName);
                    }
                }
            });
        }
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, list, str, str2) == null) {
            SapiAccountService.asyncStoken2Web(getContext(), str);
            String accountCenterUrl = getAccountCenterUrl(str2);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (this.jsCallBacks.pickPhotoCallback != null && this.configuration.supportPhoto) {
                list.add(new PassNameValuePair("support_photo", "1"));
            }
            if (this.jsCallBacks.biometricsIdentifyCallback != null && this.configuration.supportFaceLogin) {
                list.add(new PassNameValuePair("supFaceLogin", "1"));
            }
            loadUrl(addExtras(accountCenterUrl, list));
        }
    }

    public void loadForgetPwd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + CALLBACK_PARAM_KEY + "=" + ACTION_FORGET_PWD, "UTF-8")));
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new PassNameValuePair("skin", str));
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            String forgetPwdUrl = getForgetPwdUrl();
            if (arrayList.size() > 0) {
                forgetPwdUrl = forgetPwdUrl + "&" + SapiUtils.createRequestParams(arrayList);
            }
            loadUrl(forgetPwdUrl);
        }
    }

    public void loadLogin(List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, list) == null) {
            loadLogin(0, list);
        }
    }

    public void loadLogin(int i2, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048618, this, i2, list) == null) {
            if (this.configuration.supportFaceLogin && this.jsCallBacks.biometricsIdentifyCallback == null) {
                throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
            }
            StatLoadLogin statLoadLogin2 = statLoadLogin;
            if (statLoadLogin2 != null) {
                statLoadLogin2.tBeforeLogin = System.currentTimeMillis();
            }
            this.extras = list;
            if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
                loadNormalLogin(i2, list);
            } else if (4 == i2) {
                loadJoinLogin(list);
            } else if (i2 == 6) {
                loadNameLogin(i2);
            } else {
                boolean z = ShareUtils.isInV2ShareDisableWhiteList(this.configuration) && this.shareV2Disable;
                this.shareV2Disable = z;
                if (this.jsCallBacks.shareAccountClickCallback != null && !z) {
                    list.add(new PassNameValuePair(ShareCallPacking.StatModel.KEY_SHARE_VERSION, "2"));
                    loadShareAccounts(i2, list);
                } else if (this.isSupFaceLogin) {
                    loadFaceLogin(list);
                } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
                    loadChinaMobileLogin(i2, list);
                } else {
                    loadNormalLogin(i2, list);
                }
            }
            SapiStatUtil.statLoadLogin(null);
        }
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, list) == null) {
            statStartLogin(str);
            if (TextUtils.isEmpty(str) || str.contains("javascript:")) {
                str2 = null;
            } else {
                asyncCommonCookie(list);
                str2 = this.sapiCache.getCacheData(getContext(), str);
            }
            String str3 = str2;
            if (!TextUtils.isEmpty(str3)) {
                String hashUrl = getHashUrl(str3, str);
                loadDataWithBaseURL(hashUrl, str3, DATA_MIME_TYPE, "UTF-8", hashUrl);
                return;
            }
            loadUrlFromNetwork(str);
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiWebView this$0;

        public AnonymousClass2(SapiWebView sapiWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiWebView;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x015d, code lost:
            if (r10.contains(r4.getHost() + r4.getPath()) != false) goto L39;
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (Build.VERSION.SDK_INT > 7) {
                    this.this$0.getSettings().setBlockNetworkLoads(false);
                }
                if (this.this$0.webviewLoadingView != null) {
                    this.this$0.webviewLoadingView.setVisibility(8);
                }
                if (SapiUtils.hasActiveNetwork(this.this$0.getContext()) && this.this$0.noNetworkView != null && this.this$0.noNetworkView.getVisibility() != 4) {
                    this.this$0.noNetworkView.setVisibility(4);
                }
                this.this$0.loadUrl(SapiWebView.FN_NET_AVAILABLE);
                if (this.this$0.jsCallBacks.webViewTitleCallback != null) {
                    this.this$0.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
                }
                if (this.this$0.isLoadThirdPartyUrl && !TextUtils.isEmpty(this.this$0.userInfoXmlContent)) {
                    SapiWebView sapiWebView = this.this$0;
                    SapiWebView.super.loadUrl(String.format(SapiWebView.FN_GUIDE_PROCESS, sapiWebView.userInfoXmlContent));
                    this.this$0.isLoadThirdPartyUrl = false;
                    this.this$0.userInfoXmlContent = null;
                }
                Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().getUrlAfterAuth());
                Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().getUrlFinishBind());
                Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().getUrlSSOFinish());
                Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().getAccountCenterUrl(SapiWebView.ACCOUNT_CENTER));
                if (str.contains(parse4.getHost() + parse4.getPath())) {
                    this.this$0.shouldClose = true;
                } else {
                    this.this$0.shouldClose = false;
                }
                if (!str.contains(parse.getHost() + parse.getPath())) {
                    if (!str.contains(parse2.getHost() + parse2.getPath())) {
                    }
                }
                if (!"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                    this.this$0.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
                }
                this.this$0.timeoutHandler.removeCallbacks(this.this$0.timeoutTask);
                if (this.this$0.webviewClientCallback != null) {
                    this.this$0.webviewClientCallback.onPageFinished(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Uri parse;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.this$0.jsCallBacks.pageStateCallback != null) {
                    Uri parse2 = Uri.parse(this.this$0.getLoginUrl());
                    if (Uri.parse(str) != null) {
                        if ((parse.getHost() + parse.getPath()).equals(parse2.getHost() + parse2.getPath())) {
                            this.this$0.jsCallBacks.pageStateCallback.pageState(1);
                        }
                    }
                    this.this$0.jsCallBacks.pageStateCallback.pageState(2);
                }
                if (!SapiUtils.hasActiveNetwork(this.this$0.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                    this.this$0.handleNetworkUnavailable();
                }
                this.this$0.timeoutTask.setUrl(str);
                this.this$0.timeoutHandler.postDelayed(this.this$0.timeoutTask, this.this$0.timeoutMillis);
                this.this$0.handleLoadingView();
                if (str != null) {
                    if (str.contains(SapiWebView.ACTION_FORGET_PWD) || str.contains(SapiWebView.ACTION_MODIFY_PWD)) {
                        String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.CALLBACK_PARAM_KEY);
                        if (SapiWebView.ACTION_FORGET_PWD.equals(queryParameter) && this.this$0.changePwdCallback != null) {
                            this.this$0.post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

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
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.stopLoading();
                                        if (this.this$1.this$0.changePwdCallback != null) {
                                            this.this$1.this$0.changePwdCallback.onSuccess();
                                        }
                                    }
                                }
                            });
                        }
                        if (SapiWebView.ACTION_MODIFY_PWD.equals(queryParameter) && this.this$0.changePwdCallback != null) {
                            this.this$0.post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

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
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.stopLoading();
                                        String cookieBduss = SapiUtils.getCookieBduss();
                                        String cookiePtoken = SapiUtils.getCookiePtoken();
                                        if (TextUtils.isEmpty(cookieBduss)) {
                                            if (this.this$1.this$0.changePwdCallback != null) {
                                                this.this$1.this$0.changePwdCallback.onSuccess();
                                                return;
                                            }
                                            return;
                                        }
                                        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback(this, cookieBduss, cookiePtoken) { // from class: com.baidu.sapi2.SapiWebView.2.2.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ RunnableC16912 this$2;
                                            public final /* synthetic */ String val$bduss;
                                            public final /* synthetic */ String val$ptoken;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, cookieBduss, cookiePtoken};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$2 = this;
                                                this.val$bduss = cookieBduss;
                                                this.val$ptoken = cookiePtoken;
                                            }

                                            @Override // com.baidu.sapi2.callback.SapiCallback
                                            public void onFinish() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048580, this) == null) {
                                                    this.this$2.this$1.this$0.dismissProgress();
                                                }
                                            }

                                            @Override // com.baidu.sapi2.callback.SapiCallback
                                            public void onStart() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048581, this) == null) {
                                                    this.this$2.this$1.this$0.showProgress();
                                                }
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.sapi2.callback.LoginStatusAware
                                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                                Interceptable interceptable3 = $ic;
                                                if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, getUserInfoResult) == null) || this.this$2.this$1.this$0.changePwdCallback == null) {
                                                    return;
                                                }
                                                this.this$2.this$1.this$0.changePwdCallback.onSuccess();
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.sapi2.callback.SapiCallback
                                            public void onFailure(GetUserInfoResult getUserInfoResult) {
                                                Interceptable interceptable3 = $ic;
                                                if (!(interceptable3 == null || interceptable3.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) || this.this$2.this$1.this$0.changePwdCallback == null) {
                                                    return;
                                                }
                                                this.this$2.this$1.this$0.changePwdCallback.onSuccess();
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.sapi2.callback.SapiCallback
                                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeL(1048582, this, getUserInfoResult) == null) {
                                                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                                                    if (currentAccount != null) {
                                                        if (currentAccount.uid.equals(getUserInfoResult.uid)) {
                                                            currentAccount.bduss = this.val$bduss;
                                                        }
                                                        if (!TextUtils.isEmpty(this.val$ptoken)) {
                                                            currentAccount.ptoken = this.val$ptoken;
                                                        }
                                                        currentAccount.deleteStokens();
                                                    }
                                                    SapiAccountManager.getInstance().validate(currentAccount);
                                                    if (this.this$2.this$1.this$0.changePwdCallback != null) {
                                                        this.this$2.this$1.this$0.changePwdCallback.onSuccess();
                                                    }
                                                }
                                            }
                                        }, cookieBduss);
                                    }
                                }
                            });
                        }
                    }
                    if (str.contains("__wp-action=renren-offline") && SapiWebView.ACTION_RENREN_OFFLINE.equals(Uri.parse(str).getQueryParameter(SapiWebView.CALLBACK_PARAM_KEY))) {
                        if (this.this$0.jsCallBacks.rrLoginResponse == null) {
                            if (this.this$0.jsCallBacks.authorizationListener != null) {
                                this.this$0.post(new Runnable(this) { // from class: com.baidu.sapi2.SapiWebView.2.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;

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
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.this$0.jsCallBacks.authorizationListener == null) {
                                            return;
                                        }
                                        this.this$1.this$0.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                    }
                                });
                            }
                        } else {
                            SapiWebView sapiWebView = this.this$0;
                            sapiWebView.handleOpenApiAuthorizeResponse(sapiWebView.jsCallBacks.rrLoginResponse);
                        }
                    }
                }
                if (this.this$0.webviewClientCallback != null) {
                    this.this$0.webviewClientCallback.onPageStarted(webView, str, bitmap);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                if (i2 == -8 || i2 == -6 || i2 == -2 || i2 == -5) {
                    this.this$0.handleTimeout();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
                if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                    sslErrorHandler.cancel();
                    if (!(!this.this$0.configuration.forbidSslErrorDialog)) {
                        if (this.this$0.dateInvalidDialog == null) {
                            if (Build.VERSION.SDK_INT > 17) {
                                str2 = new SimpleDateFormat(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_MSG).format(new Date(System.currentTimeMillis()));
                                str = SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_TITLE;
                            } else {
                                str = SapiWebView.HTTPS_SSL_UNTRUSTED_DIALOG_TITLE;
                                str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.getContext());
                            builder.setTitle(str);
                            builder.setMessage(str2);
                            builder.setPositiveButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_SET_TIME, new DialogInterface.OnClickListener(this) { // from class: com.baidu.sapi2.SapiWebView.2.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

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
                                    this.this$1 = this;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                        Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                        intent.setFlags(268435456);
                                        this.this$1.this$0.getContext().startActivity(intent);
                                        dialogInterface.dismiss();
                                        StatService.onEvent("sslerr_date_setting", null);
                                    }
                                }
                            });
                            builder.setNegativeButton("取消", new DialogInterface.OnClickListener(this) { // from class: com.baidu.sapi2.SapiWebView.2.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

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
                                    this.this$1 = this;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                        dialogInterface.dismiss();
                                        StatService.onEvent("sslerr_date_cancel", null);
                                    }
                                }
                            });
                            this.this$0.dateInvalidDialog = builder.create();
                        }
                        if (!((Activity) this.this$0.getContext()).isFinishing() && !this.this$0.dateInvalidDialog.isShowing()) {
                            this.this$0.dateInvalidDialog.show();
                        }
                    } else {
                        sslErrorHandler.proceed();
                    }
                }
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, webResourceRequest)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        if (webResourceRequest.getUrl().toString().contains(SapiWebView.CUSTOM_CSS_INTERPRETER_URL)) {
                            String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                            if (!TextUtils.isEmpty(str)) {
                                return new WebResourceResponse("text/css", "utf-8", SapiCoreUtil.getCacheInputStream(this.this$0.getContext(), str));
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
                if (str != null) {
                    if (!str.startsWith("sms") && !str.startsWith("tel") && !str.startsWith("bdscenter")) {
                        if (str.startsWith("wtloginmqq")) {
                            return true;
                        }
                        if (SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL).equals(str)) {
                            this.this$0.finish();
                        }
                        if (this.this$0.jsCallBacks.bdOauthLoginParams != null && this.this$0.jsCallBacks.bdOauthLoginParams.redirectUrl != null && str.contains(this.this$0.jsCallBacks.bdOauthLoginParams.redirectUrl)) {
                            this.this$0.jsCallBacks.bdOauthLoginParams.callback.onCallback(str);
                            return true;
                        }
                    } else {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.setFlags(268435456);
                            this.this$0.getContext().startActivity(intent);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        return true;
                    }
                }
                if (this.this$0.webviewClientCallback != null) {
                    this.this$0.webviewClientCallback.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                if (Build.VERSION.SDK_INT < 21) {
                    try {
                        if (str.contains(SapiWebView.CUSTOM_CSS_INTERPRETER_URL)) {
                            String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                            if (!TextUtils.isEmpty(str2)) {
                                return new WebResourceResponse("text/css", "utf-8", SapiCoreUtil.getCacheInputStream(this.this$0.getContext(), str2));
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.reloadConfig = new ReloadConfig();
        this.timeoutHandler = new Handler(this) { // from class: com.baidu.sapi2.SapiWebView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SapiWebView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 1) {
                    this.this$0.handleTimeout();
                }
            }
        };
        this.timeoutTask = new TimeoutTask();
        this.leftBtnIsVisible = 1;
        this.touchidPortraitAndSign = new String[2];
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.reloadConfig = new ReloadConfig();
        this.timeoutHandler = new Handler(this) { // from class: com.baidu.sapi2.SapiWebView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SapiWebView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 1) {
                    this.this$0.handleTimeout();
                }
            }
        };
        this.timeoutTask = new TimeoutTask();
        this.leftBtnIsVisible = 1;
        this.touchidPortraitAndSign = new String[2];
        init();
    }
}
