package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
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
import android.widget.Toast;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.webkit.internal.ETAG;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
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
/* loaded from: classes6.dex */
public final class SapiWebView extends WebView {
    private static final String A = "取消";
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    private static final String B = "立即设置时间";
    private static final String C = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String D = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final String DEFAULT_WEIXIN_NOT_INSTALL_ERROR = "微信未安装";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";
    private static final String a = "prompt_on_cancel";
    private static final String b = "css/sapi_theme/style.css";
    static final int c = 1;
    static final int d = 0;
    private static final String e = "renren-offline";
    private static final String f = "__wp-action";
    private static final String g = "forget-pwd";
    private static final String h = "modify-pwd";
    private static final String i = "text/html";
    private static final String j = "UTF-8";
    private static final String k = "#login";
    private static final String l = "#insert_account";
    private static final String m = "#canshareAi";
    private static final String n = "#authPwd";
    private static final String o = "#reg";
    private static final String p = "#canshare_accounts";
    private static final String q = "#sms_login";
    private static final String r = "#fastReg";
    private static final String s = "#oneKeyLogin";
    public static com.baidu.sapi2.utils.q statLoadLogin = null;
    private static final String t = "#share_auth";
    private static final String u = "#face_login";
    private static final String v = "服务错误，请稍后重试";
    private static final String w = "系统时间错误";
    private static final String x = "证书安全警告";
    private static final String y = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String z = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    private SapiConfiguration E;
    private WeixinHandler F;
    private WebviewClientCallback G;
    private WebChromeClientCallback H;
    private FileChooserCallback I;
    private ChangePwdCallback J;
    private AccountChangeCallback K;
    private boolean L;
    private ReloadConfig M;
    private SapiJsInterpreters N;
    private SapiJsCallBacks.CallBacks O;
    private List<String> P;
    private View Q;
    private View R;
    private View S;
    private ProgressBar T;
    private ProgressDialog U;
    private Dialog V;
    private V W;
    private boolean aa;
    private long ba;
    private Handler ca;
    private TimeoutTask da;
    private BroadcastReceiver ea;
    public List<PassNameValuePair> extras;
    private OnFinishCallback fa;
    private OnBackCallback ga;
    private OnNewBackCallback ha;
    private boolean ia;
    private int ja;
    private boolean ka;
    private volatile boolean la;
    private volatile String ma;
    public boolean shareV2Disable;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide;
    public String[] touchidPortraitAndSign;
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, "1");
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", "1");
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");

    /* loaded from: classes6.dex */
    public interface AccountChangeCallback {
        void onAccountChange();
    }

    /* loaded from: classes6.dex */
    public static abstract class AccountDestoryCallback {

        /* loaded from: classes6.dex */
        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    /* loaded from: classes6.dex */
    public static abstract class AccountFreezeCallback {

        /* loaded from: classes6.dex */
        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    /* loaded from: classes6.dex */
    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        
        String b;

        ActivityLifeCycle(String str) {
            this.b = str;
        }
    }

    /* loaded from: classes6.dex */
    public interface BdussChangeCallback {
        void onBdussChange();
    }

    /* loaded from: classes6.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes6.dex */
    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        /* loaded from: classes6.dex */
        public static abstract class BioScanFaceResult {
            public int showGuidePage;
            public String subpro;
            public int type;
            public String uid;
            public Map<String, String> transParamsMap = new HashMap();
            public List<PassNameValuePair> transParamsList = new ArrayList();

            public abstract void setScanFaceIdentifyResult(String str);
        }

        void onBioScanFace(BioScanFaceResult bioScanFaceResult);
    }

    /* loaded from: classes6.dex */
    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;
        public static final int RECORD_VIDEO = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    /* loaded from: classes6.dex */
    public static abstract class BiometricsIdentifyResult {
        public static final int ERROR_CODE_GET_STOKEN_FAILED = -402;
        public static final String ERROR_MSG_GET_STOKEN_FAILED = "服务异常，请稍后再试";
        public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
        public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
        public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
        public String authToken;
        public int biometricType;
        public String idCardNum;
        public String livenessRecogType;
        public String phoneNum;
        public String realName;
        public int recordVideo;
        public int showGuidePage;
        public String subPro;

        public abstract void setIdentifyToken(String str);
    }

    /* loaded from: classes6.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes6.dex */
    static class Command {
        private String a;
        private List<String> b = new ArrayList();

        Command() {
        }

        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                Command command = new Command();
                JSONObject optJSONObject = jSONObject.optJSONObject("action");
                if (optJSONObject != null) {
                    command.a = optJSONObject.optString("name");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            command.b.add(optJSONArray.optString(i));
                        }
                    }
                }
                return command;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }

        public String getActionName() {
            return this.a;
        }

        public List<String> getActionParams() {
            return this.b;
        }
    }

    /* loaded from: classes6.dex */
    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    /* loaded from: classes6.dex */
    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    /* loaded from: classes6.dex */
    public class DefaultAuthorizationListener extends AuthorizationListener {
        public DefaultAuthorizationListener() {
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            SapiWebView.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess() {
            SapiWebView.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class DefaultWeixinHandler implements WeixinHandler {
        public DefaultWeixinHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleNotInstall() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleServerError(String str) {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void onFinish() {
            if (SapiWebView.this.getContext() instanceof Activity) {
                ((Activity) SapiWebView.this.getContext()).finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    interface ErrorCode {
        public static final int WEIXIN_NOT_INTALL = -404;
    }

    /* loaded from: classes6.dex */
    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    /* loaded from: classes6.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes6.dex */
        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    /* loaded from: classes6.dex */
    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i);
    }

    /* loaded from: classes6.dex */
    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    /* loaded from: classes6.dex */
    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    /* loaded from: classes6.dex */
    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    /* loaded from: classes6.dex */
    public static class LoadSlideWebViewResult {
        public String page;
        public String placeholderTitle;
        public String url;
    }

    /* loaded from: classes6.dex */
    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    /* loaded from: classes6.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes6.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes6.dex */
    public interface OnNewBackCallback {
        boolean onBack();
    }

    /* loaded from: classes6.dex */
    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    /* loaded from: classes6.dex */
    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i, int i2, int i3, PickPhotoResult pickPhotoResult);
    }

    /* loaded from: classes6.dex */
    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class PreFillUserNameCallback {

        /* loaded from: classes6.dex */
        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    /* loaded from: classes6.dex */
    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes6.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes6.dex */
    private class ReloadConfig {
        String a;
        boolean b;
        boolean c;
        String d;
        List<PassNameValuePair> e;

        private ReloadConfig() {
            this.a = null;
            this.b = false;
        }

        void a() {
            this.a = null;
            this.b = false;
        }
    }

    /* loaded from: classes6.dex */
    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class SmsHandler extends Handler {
        String a;
        String b;

        SmsHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj != null) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                    SapiWebView.this.loadUrl(String.format("javascript:%s('%s','%s');", this.a, str, this.b));
                }
                SapiWebView.this.l();
                removeCallbacks(SapiWebView.this.O.P);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class SwitchAccountCallback {

        /* loaded from: classes6.dex */
        public static class Result {
            public String displayName;
            public String encryptedUid;
            public String extraJson;
            public int loginType;
            public int switchAccountType;
            public String userName;
        }

        public abstract void onAccountSwitch(Result result);
    }

    /* loaded from: classes6.dex */
    public static abstract class SystemUpwardSmsCallback {

        /* loaded from: classes6.dex */
        public static abstract class Result {
            public String content;
            public String destination;

            public abstract void onFinish();
        }

        public abstract void onResult(Result result);
    }

    /* loaded from: classes6.dex */
    private class TimeoutTask implements Runnable {
        private String a;

        private TimeoutTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.a;
                SapiWebView.this.ca.sendMessage(message);
                SapiWebView.this.ca.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.a = str;
        }
    }

    /* loaded from: classes6.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface UpwardSmsCallback {
        void onResult(boolean z, boolean z2, boolean z3);
    }

    /* loaded from: classes6.dex */
    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes6.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes6.dex */
    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes6.dex */
    public interface WeixinHandler {
        void handleNotInstall();

        void handleServerError(String str);

        void onFinish();
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.M = new ReloadConfig();
        this.ca = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.da = new TimeoutTask();
        this.ja = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (getSettings().getBlockNetworkLoads()) {
            return;
        }
        loadUrl(b(activityLifeCycle.b));
    }

    public void back() {
        View view;
        View view2;
        ProgressBar progressBar;
        if (this.ia && (progressBar = this.T) != null && progressBar.getVisibility() == 0) {
            finish();
        } else if (this.ia && (view = this.Q) != null && view.getVisibility() == 0) {
            finish();
        } else if (this.ha == null || this.O.U != null) {
            super.loadUrl(FN_SWITCH_VIEW);
            a(this.O.U);
        } else {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.ha.onBack();
        }
        View view3 = this.R;
        if ((view3 == null || view3.getVisibility() != 0) && ((view2 = this.S) == null || view2.getVisibility() != 0)) {
            return;
        }
        finish();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.aa = true;
        this.ca.removeCallbacks(this.da);
        l();
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
    }

    public void dismissProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.19
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.U != null && SapiWebView.this.U.isShowing()) {
                    try {
                        SapiWebView.this.U.dismiss();
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                }
            }
        });
    }

    public void finish() {
        finish("");
    }

    String getAddressManageUrl() {
        return SapiAccountManager.getInstance().getAccountService().a() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public String getFacebookSSOLoginUrl(List<PassNameValuePair> list, String str, String str2, String str3) {
        String str4 = null;
        try {
            str4 = a(SocialType.FACEBOOK, URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"));
        } catch (Exception e2) {
            Log.e(e2);
        }
        return a(str4, list);
    }

    String getForgetPwdUrl() {
        return SapiAccountManager.getInstance().getAccountService().b() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String getInvoiceBuildUrl() {
        return SapiAccountManager.getInstance().getAccountService().c() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLocalPhoneNumber() {
        String line1Number = SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext()) ? ((TelephonyManager) getContext().getSystemService("phone")).getLine1Number() : null;
        if (TextUtils.isEmpty(line1Number)) {
            return null;
        }
        return line1Number.replace("+86", "");
    }

    String getLoginUrl() {
        return SapiAccountManager.getInstance().getAccountService().d();
    }

    public String getMeizuSSOLoginUrl(List<PassNameValuePair> list, String str, String str2) {
        String str3 = null;
        try {
            str3 = a(SocialType.MEIZU, URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), null);
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        return a(str3, list);
    }

    String getModifyPwdUrl() {
        return SapiAccountManager.getInstance().getAccountService().e() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public String getQQSSOLoginUrl(List<PassNameValuePair> list, String str, String str2, String str3) {
        return a(a(str, str2, str3), list);
    }

    String getRealnameAuthenticateUrl() {
        return SapiAccountManager.getInstance().getAccountService().f() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public String getSinaSSOLoginUrl(List<PassNameValuePair> list, String str, String str2) {
        return a(a(SocialType.SINA_WEIBO_SSO, str, str2, this.E.sinaAppId), list);
    }

    String getSwitchAccountUrl() {
        return SapiAccountManager.getInstance().getAccountService().h() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public long getTimeoutMillis() {
        return this.ba;
    }

    public String getUaInfo() {
        String encode = URLEncoder.encode("Sapi_8.9.5.6_Android_" + SapiUtils.getAppName(getContext()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + SapiUtils.getVersionName(getContext()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (!TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "") + "_Sapi");
        return (!j() || TextUtils.isEmpty(this.E.userAgent)) ? encode : encode + " " + this.E.userAgent;
    }

    String getUniteVerifyUrl() {
        return SapiAccountManager.getInstance().getAccountService().i() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String getWapOpRecordUrl() {
        return SapiAccountManager.getInstance().getAccountService().m() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public String getWeiXinSSOLoginUrl(String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (!TextUtils.isEmpty(str)) {
            return a(a(str, str2, z2), list);
        }
        throw new IllegalArgumentException();
    }

    public void loadAccountCenter(String str) {
        loadAccountCenter(null, str);
    }

    public void loadAccountRealName(String str, String str2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", com.baidu.sapi2.utils.j.a(com.baidu.sapi2.utils.j.m)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair(FaceBaseDTO.KEY_BUSINESS_SCENE, str2));
        }
        arrayList.add(new PassNameValuePair("needcbkey", z2 ? "1" : "0"));
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        loadUrl(a(getAddressManageUrl(), list));
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (bindWidgetAction != null) {
            if (!TextUtils.isEmpty(str)) {
                a(getContext(), str);
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new PassNameValuePair("skin", str2));
                }
                if (z2) {
                    arrayList.add(new PassNameValuePair(FreeSpaceBox.TYPE, "1"));
                }
                if (this.E.supportFaceLogin) {
                    arrayList.add(new PassNameValuePair("liveAbility", "1"));
                }
                String a2 = a(bindWidgetAction);
                if (arrayList.size() > 0) {
                    a2 = a2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
                }
                String a3 = a(a2, list);
                String a4 = a();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair(this.E.environment.getWap(), a4));
                loadUrl(a3, arrayList2);
                return;
            }
            throw new IllegalArgumentException("bduss can't be empty");
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                String str6;
                if (!SapiWebView.this.aa) {
                    if (str.split("#").length > 0) {
                        str6 = split[0] + "&loadDataWithBaseUrl=1#" + split[1];
                    } else {
                        str6 = str + "&loadDataWithBaseUrl=1";
                    }
                    SapiWebView.this.a(str, true);
                    SapiWebView.super.loadDataWithBaseURL(str6, str2, str3, str4, str5);
                }
            }
        });
    }

    public void loadExternalUrl(String str) {
        loadExternalUrl(str, null);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        String str2 = null;
        try {
            str2 = SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, "UTF-8"), "");
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(a(str2, list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(a(getInvoiceBuildUrl(), list));
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadLoginWithUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            loadLogin();
            return;
        }
        String str2 = "";
        try {
            str2 = "disusername=" + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            loadUrl(getLoginUrl() + ETAG.ITEM_SEPARATOR + str2 + n);
        } else {
            loadLogin();
        }
    }

    public void loadModifyPwd(String str) {
        loadModifyPwd(str, null);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(a(a(socialType), list));
    }

    public void loadOperationRecord(String str) {
        loadOperationRecord(str, null);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z2) {
        SapiJsCallBacks.CallBacks callBacks = this.O;
        callBacks.t = qrLoginCallback;
        callBacks.S = z2;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadRealnameAuthenticate(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.E.realnameAuthenticateStoken)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.6
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetTplStokenResult getTplStokenResult) {
                        if (SapiWebView.this.O.n != null) {
                            SapiWebView.this.O.n.onFailure();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        String realnameAuthenticateUrl = SapiWebView.this.getRealnameAuthenticateUrl();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new PassNameValuePair("bduss", str));
                        arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                        arrayList2.add(new PassNameValuePair("bdstoken", SapiWebView.this.E.realnameAuthenticateStoken));
                        SapiWebView.this.loadUrl(realnameAuthenticateUrl + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
                    }
                }, str, arrayList);
                return;
            }
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadRegist(List<PassNameValuePair> list) {
        loadUrl(a(getLoginUrl(), list) + o);
        this.ka = false;
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().n() + "&adapter=3") + t);
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        loadUrl(a(getSwitchAccountUrl(), list));
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.la = true;
        this.ma = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.E.environment.getURL(), str3));
        arrayList.add(new PassNameValuePair("https://baidu.com", str4));
        arrayList.add(new PassNameValuePair("https://baidu.com", str5));
        arrayList.add(new PassNameValuePair(this.E.environment.getURL(), str6));
        arrayList.add(new PassNameValuePair(this.E.environment.getURL(), str7));
        loadUrl(str, arrayList);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
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
            loadUrl(getUniteVerifyUrl() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList));
            return;
        }
        throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadWeixinSSOLogin() {
        if (this.F == null) {
            this.F = new DefaultWeixinHandler();
        }
        new com.baidu.sapi2.outsdk.e().a(getContext(), this.E, this.F);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        ProgressBar progressBar = this.T;
        if (progressBar != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.T.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        View view;
        View view2 = this.R;
        if ((view2 == null || view2.getVisibility() != 0) && ((view = this.S) == null || view.getVisibility() != 0)) {
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
        }
        return false;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    @Override // android.webkit.WebView
    public void reload() {
        String str = this.M.a;
        if (str != null) {
            loadUrl(str);
        } else {
            super.reload();
        }
        this.M.a();
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        View view;
        View view2 = this.R;
        if ((view2 != null && view2.getVisibility() == 0) || ((view = this.S) != null && view.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i2, i3);
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.K = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.O.q = accountDestoryCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.O.r = accountFreezeCallback;
    }

    public void setAddressManageCallback(SapiJsCallBacks.AddressManageCallback addressManageCallback) {
        this.O.L = addressManageCallback;
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.O.I = authorizationListener;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.O.Z = bdOauthLoginParams;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.O.k = bdussChangeCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.O.h = bindWidgetCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.O.d = bioScanFaceCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.O.e = biometricsIdentifyCallback;
    }

    public void setBuildCustomAlertDialog(SapiJsCallBacks.BuildCustomAlertDialog buildCustomAlertDialog) {
        this.O.K = buildCustomAlertDialog;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.J = changePwdCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.O.o = coverWebBdussCallback;
    }

    public void setCurrentAccountBdussExpiredCallback(SapiJsCallBacks.CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        this.O.E = currentAccountBdussExpiredCallback;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.O.X = directedLoginParams;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.I = fileChooserCallback;
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        this.O.N = fingerprintCallback;
    }

    public void setGetCurrentPageNameCallback(SapiJsCallBacks.GetCurrentPageNameCallback getCurrentPageNameCallback) {
        this.O.G = getCurrentPageNameCallback;
    }

    public void setGrantWebCallback(SapiJsCallBacks.GrantWebCallback grantWebCallback) {
        this.O.D = grantWebCallback;
    }

    public void setHideSuccessTip(boolean z2) {
        this.O.Y = z2;
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        this.O.M = invoiceBuildCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.O.v = invokeScAppCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.O.V = joinLoginParams;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.O.m = leftBtnVisibleCallback;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.O.i = loadExternalWebViewCallback;
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        this.O.x = loadSlideWebViewCallback;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.O.w = localConfigCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.O.C = loginStatusChangeCallback;
    }

    public final void setNoNetworkView(View view) {
        if (this.R == null) {
            this.R = view;
            this.R.setVisibility(4);
            addView(this.R, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        SapiJsCallBacks.CallBacks callBacks = this.O;
        callBacks.z = normalizeGuestAccountCallback;
        callBacks.W = str;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ga = onBackCallback;
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.fa = onFinishCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.ha = onNewBackCallback;
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        this.O.H = onSlidePageFinishCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.O.J = pageStateCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.O.j = pickPhotoCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.O.p = preFillUserNameCallback;
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.T == null) {
            this.T = progressBar;
            if (this.T != null) {
                addView(progressBar);
            }
        }
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.O.B = realNameStatusCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.O.n = realnameAuthenticateCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.O.s = shareAccountClickCallback;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.O.aa = shareV2LoginParams;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.O.a = handler;
    }

    public void setSpeechRecognitionCallback(SapiJsCallBacks.SpeechRecognitionCallback speechRecognitionCallback) {
        this.O.y = speechRecognitionCallback;
    }

    public void setStopSlideWebviewCallback(SapiJsCallBacks.StopSlideWebviewCallback stopSlideWebviewCallback) {
        this.O.F = stopSlideWebviewCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.O.l = switchAccountCallback;
    }

    public void setSystemUpwardSmsCallback(SystemUpwardSmsCallback systemUpwardSmsCallback) {
        this.O.u = systemUpwardSmsCallback;
    }

    public void setTimeoutMillis(long j2) {
        this.ba = j2;
    }

    public final void setTimeoutView(View view) {
        if (this.S == null) {
            this.S = view;
            this.S.setVisibility(4);
            addView(this.S, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.O.f = uniteVerifyCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.H = webChromeClientCallback;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.O.c = webViewTitleCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.G = webviewClientCallback;
    }

    public void setWebviewLoadingView(View view) {
        if (this.Q == null) {
            this.Q = view;
            this.Q.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.O.A = webviewPageFinishCallback;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.F = weixinHandler;
    }

    public void showProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SapiWebView.this.U = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException e2) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void e() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            Log.e(e2);
        }
        settings.setUserAgentString(settings.getUserAgentString() + " " + getUaInfo());
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        setScrollBarStyle(0);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.5
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view = this.R;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.S;
            if (view2 == null || view2.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.Q != null) {
                            SapiWebView.this.Q.setVisibility(0);
                            if (SapiWebView.this.T != null) {
                                SapiWebView.this.T.setVisibility(8);
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.T != null) {
                    SapiWebView.this.T.setVisibility(8);
                }
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(8);
                }
                if (SapiWebView.this.R != null) {
                    SapiWebView.this.R.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.T != null) {
                    SapiWebView.this.T.setVisibility(8);
                }
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(8);
                }
                SapiWebView.this.M.a = SapiWebView.this.da.a;
                if (SapiWebView.this.S != null) {
                    SapiWebView.this.S.setVisibility(0);
                }
            }
        });
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void i() {
        this.O = new SapiJsCallBacks.CallBacks();
        this.N = new SapiJsInterpreters(this, this.O);
        this.ba = DEFAULT_TIMEOUT_MILLIS;
        this.E = SapiAccountManager.getInstance().getSapiConfiguration();
        this.W = new V();
        this.L = new FaceLoginService().isSupFaceLogin();
        e();
        k();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new AnonymousClass2());
        setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.SapiWebView.3
            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i3, String str2) {
                Log.d(str + " -- From line " + i3 + " of " + str2, new Object[0]);
                if (SapiWebView.this.H != null) {
                    SapiWebView.this.H.onConsoleMessage(str, i3, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        jsResult.confirm();
                    }
                });
                positiveButton.setCancelable(false);
                positiveButton.create();
                positiveButton.show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.H == null || !SapiWebView.this.H.isSubClassHandleMessage(str2)) {
                    Log.e(Log.TAG, "webview", str2);
                    final String[] strArr = {""};
                    SapiWebView.this.O.Q = jsPromptResult;
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Command parse = Command.parse(str2);
                            if (parse != null) {
                                String actionName = parse.getActionName();
                                if (SapiWebView.this.P.contains(actionName)) {
                                    SapiWebView.this.O.Q = jsPromptResult;
                                }
                                SapiJsInterpreters.AbstractInterpreter a2 = SapiWebView.this.N.a(actionName);
                                if (a2 != null) {
                                    try {
                                        strArr[0] = a2.interpret(parse);
                                    } catch (Throwable th) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                                            jSONObject.put("msg", "native function error");
                                            strArr[0] = jSONObject.toString();
                                            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                                            linkedHashMap.put("name", "native_fun_error");
                                            HashMap hashMap = new HashMap(2);
                                            hashMap.put("msg", android.util.Log.getStackTraceString(th));
                                            hashMap.put("action_name", actionName);
                                            com.baidu.sapi2.utils.t.a(linkedHashMap, hashMap);
                                        } catch (JSONException e2) {
                                        }
                                    }
                                }
                                if (parse.getActionParams().size() <= 2 || !SapiWebView.a.equals(parse.getActionParams().get(2))) {
                                    if (!SapiWebView.this.P.contains(actionName)) {
                                        jsPromptResult.confirm(strArr[0]);
                                        return;
                                    }
                                    return;
                                }
                                jsPromptResult.cancel();
                                return;
                            }
                            jsPromptResult.cancel();
                        }
                    });
                    return true;
                }
                return SapiWebView.this.H.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                if (SapiWebView.this.T != null) {
                    if (i3 == 100) {
                        SapiWebView.this.T.setVisibility(8);
                    } else {
                        if (SapiWebView.this.T.getVisibility() == 8) {
                            SapiWebView.this.T.setVisibility(0);
                        }
                        SapiWebView.this.T.setProgress(i3);
                    }
                }
                super.onProgressChanged(webView, i3);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(5)
            public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * j2);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooser(valueCallback);
                }
            }
        });
        SapiJsCallBacks.CallBacks callBacks = this.O;
        if (callBacks.I == null) {
            callBacks.I = new DefaultAuthorizationListener();
        }
        if (this.F == null) {
            this.F = new DefaultWeixinHandler();
        }
        this.O.b = new SmsHandler();
        this.O.P = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.l();
            }
        };
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        com.baidu.sapi2.utils.q qVar = statLoadLogin;
        if (qVar != null) {
            qVar.h = System.currentTimeMillis();
        }
    }

    private boolean j() {
        for (String str : SapiContext.getInstance().getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        this.P = new ArrayList();
        this.P.add("sapi_action_pick_image");
        this.P.add("sapi_action_pick_date");
        this.P.add("sapi_biometrics_identification");
        this.P.add("sapi_biometrics_identification_no_bduss");
        this.P.add("sapi_biometrics_identification_with_authtoken");
        this.P.add("sapi_biometrics_identification_with_uid");
        this.P.add("sapi_action_sc_app_invoke");
        this.P.add("oauth_sso_hash");
        this.P.add("sapi_action_china_mobile_oauth");
        this.P.add("sapi_action_upsms");
        this.P.add("address_manage_get_contact");
        this.P.add("touchid_open_guide");
        this.P.add("touchid_change_status");
        this.P.add("touchid_login");
        this.P.add("speech_recognition_get_content");
        this.P.add("sapi_onekey_oauth_token");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.ea != null) {
            try {
                getContext().unregisterReceiver(this.ea);
            } catch (Throwable th) {
            }
        }
        this.ea = null;
    }

    public void finish(final String str) {
        l();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (!SapiWebView.this.aa) {
                    SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                    if (TextUtils.isEmpty(str)) {
                        if (SapiWebView.this.fa != null) {
                            SapiWebView.this.fa.onFinish();
                        }
                    } else if (SapiWebView.this.O.H != null) {
                        SapiWebView.this.O.H.onFinish(str);
                    }
                }
            }
        });
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        String str2;
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new PassNameValuePair("clientfrom", "native"));
            list.add(new PassNameValuePair("client", "android"));
            list.add(new PassNameValuePair("deliverParams", "1"));
            if (this.E.supportFaceLogin) {
                list.add(new PassNameValuePair("scanface", "1"));
            }
            if (this.O.j != null && this.E.supportPhoto) {
                list.add(new PassNameValuePair("support_photo", "1"));
            }
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str2 = str.substring(0, indexOf + 1) + SapiUtils.createRequestParams(list) + ETAG.ITEM_SEPARATOR + str.substring(i2, str.length());
            } else {
                str2 = str + "?" + SapiUtils.createRequestParams(list);
            }
            loadUrl(str2);
            return;
        }
        throw new IllegalArgumentException("externalUrl can't be empty");
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(com.baidu.sapi2.utils.j.a(com.baidu.sapi2.utils.j.l) + "?" + f + ETAG.EQUAL + g, "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String forgetPwdUrl = getForgetPwdUrl();
        if (arrayList.size() > 0) {
            forgetPwdUrl = forgetPwdUrl + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(forgetPwdUrl);
    }

    public void loadLogin(int i2) {
        loadLogin(i2, null);
    }

    public void loadModifyPwd(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(getContext(), str);
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("u", URLEncoder.encode(com.baidu.sapi2.utils.j.a(com.baidu.sapi2.utils.j.l) + "?" + f + ETAG.EQUAL + h, "UTF-8")));
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new PassNameValuePair("skin", str2));
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            String modifyPwdUrl = getModifyPwdUrl();
            if (arrayList.size() > 0) {
                modifyPwdUrl = modifyPwdUrl + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
            }
            String a2 = a();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new PassNameValuePair(this.E.environment.getWap(), a2));
            loadUrl(modifyPwdUrl, arrayList2);
            return;
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadOperationRecord(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(getContext(), str);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new PassNameValuePair("skin", str2));
            }
            String wapOpRecordUrl = getWapOpRecordUrl();
            if (arrayList.size() > 0) {
                wapOpRecordUrl = wapOpRecordUrl + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
            }
            loadUrl(wapOpRecordUrl);
            return;
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        d(str);
        String str2 = null;
        if (!TextUtils.isEmpty(str) && !str.contains("javascript:")) {
            a(list);
            str2 = this.W.b(getContext(), str);
        }
        if (!TextUtils.isEmpty(str2)) {
            String a2 = a(str2, str);
            loadDataWithBaseURL(a2, str2, i, "UTF-8", a2);
            return;
        }
        c(str);
    }

    private void c(List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        if (this.O.i != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        if (this.E.supportFaceLogin) {
            a2 = a2 + "&liveAbility=1";
        }
        loadUrl(a2 + m);
    }

    private void d(String str) {
        if (statLoadLogin != null) {
            if (str.contains(k) || str.contains(p) || str.contains(m) || str.contains(r) || str.contains(q) || (this.L && str.contains(u))) {
                statLoadLogin.j = System.currentTimeMillis();
            }
        }
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.a(getContext(), str);
        String a2 = a(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.O.j != null && this.E.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.O.e != null && this.E.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(a(a2, list));
    }

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    private String b(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    public void loadLogin(int i2, List<PassNameValuePair> list) {
        boolean z2 = true;
        if (this.E.supportFaceLogin && this.O.e == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        com.baidu.sapi2.utils.q qVar = statLoadLogin;
        if (qVar != null) {
            qVar.i = System.currentTimeMillis();
        }
        this.extras = list;
        this.ka = true;
        if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
            b(i2, list);
        } else if (4 == i2) {
            c(list);
        } else if (i2 == 6) {
            a(i2);
        } else {
            List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(this.E.context);
            this.shareV2Disable = (SapiShareClient.isInV2ShareDisableWhiteList() && this.shareV2Disable) ? false : false;
            if (this.O.s != null && shareStorageModel != null && shareStorageModel.size() > 0 && !this.shareV2Disable) {
                list.add(new PassNameValuePair("share_version", "2"));
                c(i2, list);
            } else if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
                c(i2, list);
            } else if (this.L) {
                b(list);
            } else if (new com.baidu.sapi2.outsdk.c().a()) {
                a(i2, list);
            } else {
                b(i2, list);
            }
        }
        SapiStatUtil.statLoadLogin(null);
    }

    public boolean onKeyUp(int i2) {
        if (i2 == 4 && this.ja == 1) {
            OnBackCallback onBackCallback = this.ga;
            if (onBackCallback != null && this.O.U == null) {
                onBackCallback.onBack();
            }
            back();
            return true;
        }
        return false;
    }

    private void b(List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        if (this.O.i != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        loadUrl((a2 + "&liveAbility=1") + u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            }
            if (SapiWebView.this.Q != null) {
                SapiWebView.this.Q.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.R != null && SapiWebView.this.R.getVisibility() != 4) {
                SapiWebView.this.R.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.C);
            if (SapiWebView.this.O.c != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            if (SapiWebView.this.la && !TextUtils.isEmpty(SapiWebView.this.ma)) {
                SapiWebView sapiWebView = SapiWebView.this;
                SapiWebView.super.loadUrl(String.format(SapiWebView.D, sapiWebView.ma));
                SapiWebView.this.la = false;
                SapiWebView.this.ma = null;
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().j());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().l());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.ia = true;
            } else {
                SapiWebView.this.ia = false;
            }
            if ((str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) && !"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.ca.removeCallbacks(SapiWebView.this.da);
            if (SapiWebView.this.G != null) {
                SapiWebView.this.G.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.O.J != null) {
                Uri parse = Uri.parse(SapiWebView.this.getLoginUrl());
                Uri parse2 = Uri.parse(str);
                if (parse2 == null || !(parse2.getHost() + parse2.getPath()).equals(parse.getHost() + parse.getPath())) {
                    SapiWebView.this.O.J.pageState(2);
                } else {
                    SapiWebView.this.O.J.pageState(1);
                }
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.g();
            }
            SapiWebView.this.da.setUrl(str);
            SapiWebView.this.ca.postDelayed(SapiWebView.this.da, SapiWebView.this.ba);
            SapiWebView.this.f();
            if (str != null) {
                if (str.contains(SapiWebView.g) || str.contains(SapiWebView.h)) {
                    String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.f);
                    if (SapiWebView.g.equals(queryParameter) && SapiWebView.this.J != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.J != null) {
                                    SapiWebView.this.J.onSuccess();
                                }
                            }
                        });
                    }
                    if (SapiWebView.h.equals(queryParameter) && SapiWebView.this.J != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.J != null) {
                                        SapiWebView.this.J.onSuccess();
                                        return;
                                    }
                                    return;
                                }
                                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.2.1
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFinish() {
                                        SapiWebView.this.dismissProgress();
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onStart() {
                                        SapiWebView.this.showProgress();
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.J != null) {
                                            SapiWebView.this.J.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.J != null) {
                                            SapiWebView.this.J.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                                        if (currentAccount != null) {
                                            if (currentAccount.uid.equals(getUserInfoResult.uid)) {
                                                currentAccount.bduss = cookieBduss;
                                            }
                                            if (!TextUtils.isEmpty(cookiePtoken)) {
                                                currentAccount.ptoken = cookiePtoken;
                                            }
                                            currentAccount.deleteStokens();
                                        }
                                        SapiAccountManager.getInstance().validate(currentAccount);
                                        SapiAccountManager.getInstance().preFetchStoken(currentAccount, true);
                                        if (SapiWebView.this.J != null) {
                                            SapiWebView.this.J.onSuccess();
                                        }
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.e.equals(Uri.parse(str).getQueryParameter(SapiWebView.f))) {
                    if (SapiWebView.this.O.U == null) {
                        if (SapiWebView.this.O.I != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.O.I != null) {
                                        SapiWebView.this.O.I.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                        }
                    } else {
                        SapiWebView sapiWebView = SapiWebView.this;
                        sapiWebView.a(sapiWebView.O.U);
                    }
                }
            }
            if (SapiWebView.this.G != null) {
                SapiWebView.this.G.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i == -8 || i == -6 || i == -2 || i == -5) {
                SapiWebView.this.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            com.baidu.sapi2.utils.t.a("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
            if ((sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) && !(!SapiWebView.this.E.forbidSslErrorDialog)) {
                if (SapiWebView.this.V == null) {
                    if (Build.VERSION.SDK_INT > 17) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SapiWebView.y);
                        Date date = new Date(System.currentTimeMillis());
                        str = SapiWebView.w;
                        str2 = simpleDateFormat.format(date);
                    } else {
                        str = SapiWebView.x;
                        str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(SapiWebView.B, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent("android.settings.DATE_SETTINGS");
                            intent.setFlags(268435456);
                            SapiWebView.this.getContext().startActivity(intent);
                            dialogInterface.dismiss();
                            com.baidu.sapi2.utils.t.a("sslerr_date_setting", (Map<String, String>) null);
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            com.baidu.sapi2.utils.t.a("sslerr_date_cancel", (Map<String, String>) null);
                        }
                    });
                    SapiWebView.this.V = builder.create();
                }
                if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.V.isShowing()) {
                    SapiWebView.this.V.show();
                }
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (webResourceRequest.getUrl().toString().contains(SapiWebView.b)) {
                        String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str)) {
                            return new WebResourceResponse("text/css", "utf-8", com.baidu.sapi2.utils.g.a(SapiWebView.this.getContext(), str));
                        }
                    }
                } catch (Exception e) {
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null) {
                if (!str.startsWith(LoginConstants.SMS_LOGIN) && !str.startsWith("tel") && !str.startsWith("bdscenter")) {
                    if (str.startsWith("wtloginmqq")) {
                        return true;
                    }
                    if (com.baidu.sapi2.utils.j.a(com.baidu.sapi2.utils.j.m).equals(str)) {
                        SapiWebView.this.finish();
                    }
                    if (SapiWebView.this.O.Z != null && SapiWebView.this.O.Z.redirectUrl != null && str.contains(SapiWebView.this.O.Z.redirectUrl)) {
                        SapiWebView.this.O.Z.callback.onCallback(str);
                        return true;
                    }
                } else {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        SapiWebView.this.getContext().startActivity(intent);
                        return true;
                    } catch (Throwable th) {
                        Log.e(th);
                        return true;
                    }
                }
            }
            if (SapiWebView.this.G != null) {
                SapiWebView.this.G.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    if (str.contains(SapiWebView.b)) {
                        String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str2)) {
                            return new WebResourceResponse("text/css", "utf-8", com.baidu.sapi2.utils.g.a(SapiWebView.this.getContext(), str2));
                        }
                    }
                } catch (Exception e) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    List<PassNameValuePair> d() {
        String diCookieInfo;
        List<String> n2 = SapiContext.getInstance().getSapiOptions().n();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.E.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        if (n2.size() == 1 && n2.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(n2);
        }
        String wap = this.E.environment.getWap();
        if (diCookieInfo == null) {
            diCookieInfo = "";
        }
        arrayList.add(new PassNameValuePair(wap, SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo)));
        return arrayList;
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.E.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.E.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    private void c(int i2, List<PassNameValuePair> list) {
        String str;
        String loginUrl = getLoginUrl();
        if (this.O.i != null) {
            loginUrl = loginUrl + "&enableExternalWeb=1";
        }
        if (this.E.supportFaceLogin) {
            loginUrl = loginUrl + "&liveAbility=1";
        }
        if (this.L && this.O.e != null) {
            str = loginUrl + "&loginInitType=4";
        } else if (new com.baidu.sapi2.outsdk.c().a()) {
            str = loginUrl + "&loginInitType=5";
        } else {
            str = loginUrl + "&loginInitType=" + i2;
        }
        loadUrl(a(str, list) + p);
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.M = new ReloadConfig();
        this.ca = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.da = new TimeoutTask();
        this.ja = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    private void a(int i2) {
        String str = a(getLoginUrl(), this.extras) + "&loginInitType=" + i2;
        if (this.O.i != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.E.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + l);
    }

    private void b(int i2, List<PassNameValuePair> list) {
        String str = a(getLoginUrl(), list) + "&loginInitType=" + i2;
        if (i2 == 0) {
            if (this.O.i != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.E.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            loadUrl(str + k);
        } else if (i2 != 1) {
            loadUrl(str + k);
        } else {
            if (this.O.i != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.E.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            loadUrl(str + q);
        }
    }

    private void a(int i2, List<PassNameValuePair> list) {
        String str = a(getLoginUrl(), list) + "&loginInitType=" + i2;
        if (this.O.i != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.E.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + s);
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.M = new ReloadConfig();
        this.ca = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.da = new TimeoutTask();
        this.ja = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    private void c(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.12
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.aa) {
                    return;
                }
                SapiWebView.this.a(str, false);
                SapiWebView.super.loadUrl(str);
            }
        });
        if (SapiUtils.hasActiveNetwork(getContext()) || str.startsWith("javascript:")) {
            return;
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SocialResponse b(String str, Context context) {
        SocialResponse socialResponse = null;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b2)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType == 2) {
                        String name = newPullParser.getName();
                        if (name.equalsIgnoreCase("data")) {
                            if (socialResponse == null) {
                                socialResponse = new SocialResponse();
                            }
                        } else if (socialResponse == null && name.equalsIgnoreCase("error_code")) {
                            SocialResponse socialResponse2 = new SocialResponse();
                            try {
                                socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                                socialResponse = socialResponse2;
                            } catch (Exception e2) {
                                e = e2;
                                socialResponse = socialResponse2;
                                Log.e(e);
                                return socialResponse;
                            }
                        } else if (socialResponse == null && name.equalsIgnoreCase("error_description")) {
                            SocialResponse socialResponse3 = new SocialResponse();
                            try {
                                socialResponse3.errorMsg = newPullParser.nextText();
                                socialResponse = socialResponse3;
                            } catch (Exception e3) {
                                e = e3;
                                socialResponse = socialResponse3;
                                Log.e(e);
                                return socialResponse;
                            }
                        } else if (socialResponse != null) {
                            if (name.equalsIgnoreCase("error_code")) {
                                socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("error_description")) {
                                socialResponse.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("is_binded")) {
                                socialResponse.isBinded = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("display_name")) {
                                socialResponse.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("passport_uname")) {
                                socialResponse.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduid")) {
                                socialResponse.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                socialResponse.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("ptoken")) {
                                socialResponse.ptoken = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_username")) {
                                socialResponse.socialUname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                socialResponse.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(HttpConstants.HTTP_OS_TYPE)) {
                                socialResponse.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("notice_offline")) {
                                socialResponse.offlineNotice = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("guidebind")) {
                                socialResponse.bindGuide = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("bind_conflict")) {
                                socialResponse.bindConflict = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("wapsec")) {
                                socialResponse.accountCenterFlag = "center".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("next_url_related")) {
                                String nextText = newPullParser.nextText();
                                if (socialResponse.accountCenterFlag) {
                                    socialResponse.nextUrl = nextText;
                                }
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    socialResponse.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    socialResponse.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    socialResponse.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("stoken")) {
                                String[] split = newPullParser.nextText().split("#");
                                socialResponse.tplStokenMap.put(split[0], split[1]);
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                socialResponse.actionType = newPullParser.nextText();
                            } else if (name.equals("livinguname")) {
                                socialResponse.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (name.equals("guest_account")) {
                                socialResponse.isGuestAccount = newPullParser.nextText();
                            }
                        }
                    }
                    try {
                    } catch (Exception e4) {
                        e = e4;
                        Log.e(e);
                        return socialResponse;
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return socialResponse;
    }

    List<PassNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.E.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = this.E.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            arrayList.add(new PassNameValuePair(this.E.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "dark")));
            arrayList.add(new PassNameValuePair(this.E.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "dark")));
        } else {
            arrayList.add(new PassNameValuePair(this.E.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "light")));
            arrayList.add(new PassNameValuePair(this.E.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "light")));
        }
        return arrayList;
    }

    private String a(String str, List<PassNameValuePair> list) {
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
            return !arrayList.isEmpty() ? str + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList) : str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2) {
        if (statLoadLogin != null) {
            if (str.contains(k) || str.contains(p) || str.contains(m) || str.contains(r) || str.contains(q) || (this.L && str.contains(u))) {
                statLoadLogin.k = System.currentTimeMillis();
                statLoadLogin.l = z2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccountResponse a(String str, Context context) {
        SapiAccountResponse sapiAccountResponse;
        Throwable th;
        XmlPullParser newPullParser;
        int eventType;
        SapiAccountResponse sapiAccountResponse2;
        boolean z2;
        SapiAccountResponse sapiAccountResponse3 = null;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b2)) {
            try {
                newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
                eventType = newPullParser.getEventType();
                sapiAccountResponse2 = null;
                z2 = false;
            } catch (Throwable th2) {
                sapiAccountResponse = null;
                th = th2;
            }
            while (eventType != 1) {
                if (eventType == 2) {
                    try {
                        String name = newPullParser.getName();
                        if (!name.equalsIgnoreCase("data")) {
                            if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_code")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                try {
                                    sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } else if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_description")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                            } else if (sapiAccountResponse2 != null) {
                                if (name.equalsIgnoreCase(BaseJsonData.TAG_ERRNO)) {
                                    sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase(BdStatsConstant.StatsKey.UNAME)) {
                                    sapiAccountResponse2.username = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase(BaseJsonData.TAG_ERRMSG)) {
                                    sapiAccountResponse2.errorMsg = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("bduss")) {
                                    sapiAccountResponse2.bduss = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("ptoken")) {
                                    sapiAccountResponse2.ptoken = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("stoken")) {
                                    if (z2) {
                                        String[] split = newPullParser.nextText().split("#");
                                        if (split != null && split.length > 1) {
                                            sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                        }
                                    } else {
                                        sapiAccountResponse2.stoken = newPullParser.nextText();
                                    }
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                    sapiAccountResponse2.displayname = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("uid")) {
                                    sapiAccountResponse2.uid = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("authsid")) {
                                    sapiAccountResponse2.authSid = newPullParser.nextText();
                                    sapiAccountResponse2.newReg = !TextUtils.isEmpty(sapiAccountResponse2.authSid);
                                } else if (name.equalsIgnoreCase("stoken_list")) {
                                    z2 = true;
                                    sapiAccountResponse = sapiAccountResponse2;
                                } else if (name.equalsIgnoreCase("os_headurl")) {
                                    sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase(HttpConstants.HTTP_OS_TYPE)) {
                                    sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                } else if (name.equalsIgnoreCase("incomplete_user")) {
                                    String nextText = newPullParser.nextText();
                                    if ("0".equals(nextText)) {
                                        sapiAccountResponse2.accountType = AccountType.NORMAL;
                                    } else if ("1".equals(nextText)) {
                                        sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                    } else {
                                        sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                    }
                                } else if (name.equalsIgnoreCase("actiontype")) {
                                    sapiAccountResponse2.actionType = newPullParser.nextText();
                                } else if (name.equals("livinguname")) {
                                    sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                                } else if ("loginType".equals(name)) {
                                    String nextText2 = newPullParser.nextText();
                                    if ("oneKeyLogin".equals(nextText2)) {
                                        nextText2 = new com.baidu.sapi2.outsdk.c().c();
                                    }
                                    SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText2);
                                } else if (name.equals("mobilephone")) {
                                    SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                                } else if (name.equals("app")) {
                                    sapiAccountResponse2.app = newPullParser.nextText();
                                } else if (name.equals("extra")) {
                                    sapiAccountResponse2.extra = newPullParser.nextText();
                                } else if (name.equals("portraitSign")) {
                                    sapiAccountResponse2.portraitSign = newPullParser.nextText();
                                } else if (name.equals("portrait")) {
                                    sapiAccountResponse2.portraitSign = newPullParser.nextText().replace("https://himg.bdimg.com/sys/portrait/item/", "").replace("http://himg.bdimg.com/sys/portrait/item/", "").replace(".jpg", "");
                                }
                            }
                            SapiAccountResponse sapiAccountResponse4 = sapiAccountResponse;
                            eventType = newPullParser.next();
                            sapiAccountResponse2 = sapiAccountResponse4;
                        } else if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                            SapiAccountResponse sapiAccountResponse42 = sapiAccountResponse;
                            eventType = newPullParser.next();
                            sapiAccountResponse2 = sapiAccountResponse42;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        sapiAccountResponse = sapiAccountResponse2;
                    }
                    th = th3;
                    Log.e(th);
                    sapiAccountResponse3 = sapiAccountResponse;
                    if (sapiAccountResponse3 != null && !TextUtils.isEmpty(sapiAccountResponse3.bduss) && sapiAccountResponse3.errorCode == -100) {
                        sapiAccountResponse3.errorCode = 0;
                    }
                }
                sapiAccountResponse = sapiAccountResponse2;
                SapiAccountResponse sapiAccountResponse422 = sapiAccountResponse;
                eventType = newPullParser.next();
                sapiAccountResponse2 = sapiAccountResponse422;
            }
            sapiAccountResponse3 = sapiAccountResponse2;
            if (sapiAccountResponse3 != null) {
                sapiAccountResponse3.errorCode = 0;
            }
        }
        return sapiAccountResponse3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount b(SapiAccountResponse sapiAccountResponse) {
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
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.E.tpl);
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

    static String b(String str, String str2) {
        String str3 = "";
        Pattern compile = Pattern.compile(str);
        if (!TextUtils.isEmpty(str2)) {
            Matcher matcher = compile.matcher(str2);
            while (matcher.find()) {
                str3 = matcher.group();
            }
        }
        return str3;
    }

    List<PassNameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        if (this.E.supportFaceLogin) {
            SapiJsCallBacks.CallBacks callBacks = this.O;
            if (callBacks.d != null && callBacks.e != null) {
                arrayList.add(new PassNameValuePair("liveAbility", "1"));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount b2 = b(sapiAccountResponse);
            if (this.O.I != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.13
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SapiWebView.this.O.I.beforeSuccess(b2);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiShareClient.getInstance().validate(b2);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(b2, SapiWebView.this.extras);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SocialResponse socialResponse) {
        int i2;
        if (socialResponse != null) {
            final SapiAccount b2 = b(socialResponse);
            if (SapiUtils.isValidAccount(b2)) {
                socialResponse.errorCode = 0;
            }
            if (socialResponse.accountCenterFlag && ((i2 = socialResponse.errorCode) == 0 || i2 == 110000)) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        SapiShareClient.getInstance().validate(b2);
                        if (SapiWebView.this.K == null || currentAccount.uid.equals(b2.uid)) {
                            return;
                        }
                        SapiWebView.this.K.onAccountChange();
                    }
                });
            } else if (this.O.I != null) {
                int i3 = socialResponse.errorCode;
                if (i3 != 0 && i3 != 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.O.I != null) {
                                AuthorizationListener authorizationListener = SapiWebView.this.O.I;
                                SocialResponse socialResponse2 = socialResponse;
                                authorizationListener.onFailed(socialResponse2.errorCode, socialResponse2.errorMsg);
                            }
                            SapiWebView.this.O.U = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.O.I != null) {
                                    SapiWebView.this.O.I.beforeSuccess(b2);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            SapiShareClient.getInstance().validate(b2);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.O.U = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (!TextUtils.isEmpty(this.O.O[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.O.O;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        SapiUtils.reportGid(this.ka ? 10002 : 10003);
        AuthorizationListener authorizationListener = this.O.I;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.O.I.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.O.I.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler) {
        if (this.ea == null) {
            com.baidu.sapi2.utils.g.a(getContext(), handler, new RequestSMSCallback() { // from class: com.baidu.sapi2.SapiWebView.17
                @Override // com.baidu.sapi2.callback.RequestSMSCallback
                public void receiverResult(BroadcastReceiver broadcastReceiver) {
                    SapiWebView.this.ea = broadcastReceiver;
                }
            });
        }
    }

    String a(String str, String str2) {
        String[] split;
        String str3;
        if (str2.split("#").length > 1) {
            X sapiOptions = SapiContext.getInstance().getSapiOptions();
            String a2 = this.W.a(str2);
            if (this.W.c(getContext(), a2) != null) {
                String str4 = this.W.c(getContext(), a2).c;
                String md5 = SecurityUtil.md5(str.getBytes(), false);
                String b2 = sapiOptions.e().b();
                if (str4.equals(md5)) {
                    str3 = (TextUtils.isEmpty(b2) ? "" : "&passAppVersion=" + b2) + "&passAppHash=" + this.W.c(getContext(), a2).c;
                } else {
                    str3 = "&passAppHash=" + SecurityUtil.md5(str.getBytes(), false);
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    String a() {
        return SapiUtils.buildBDUSSCookie(this.E.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    void a(List<PassNameValuePair> list) {
        List<PassNameValuePair> d2 = d();
        List<PassNameValuePair> c2 = c();
        if (list != null && !list.isEmpty()) {
            d2.addAll(list);
        }
        if (c2 != null && !c2.isEmpty()) {
            d2.addAll(c2);
        }
        SapiUtils.syncCookies(getContext(), d2);
    }

    String a(BindWidgetAction bindWidgetAction) {
        return SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String a(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String a(String str) {
        return SapiAccountManager.getInstance().getAccountService().a(str) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String a(SocialType socialType, String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType, str, str2, str3) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String a(String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().a(str, str2, str3) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String a(String str, String str2, boolean z2) {
        return SapiAccountManager.getInstance().getAccountService().a(str, str2, z2) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }
}
