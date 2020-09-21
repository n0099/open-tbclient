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
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.f;
import com.baidu.sapi2.utils.j;
import com.baidu.sapi2.utils.k;
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
/* loaded from: classes25.dex */
public final class SapiWebView extends WebView {
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    private static final String D = "prompt_on_cancel";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    private static final String E = "css/sapi_theme/style.css";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    static final int F = 1;
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    static final int G = 0;
    private static final String H = "renren-offline";
    private static final String I = "__wp-action";
    private static final String J = "forget-pwd";
    private static final String K = "modify-pwd";
    private static final String L = "text/html";
    private static final String M = "UTF-8";
    private static final String N = "#login";
    private static final String O = "#insert_account";
    private static final String P = "#canshareAi";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    private static final String Q = "#authPwd";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    private static final String R = "#reg";
    private static final String S = "#canshare_accounts";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";
    private static final String T = "#sms_login";
    private static final String U = "#fastReg";
    private static final String V = "#oneKeyLogin";
    private static final String W = "#share_auth";
    private static final String a0 = "#face_login";
    private static final String b0 = "系统时间错误";
    private static final String c0 = "证书安全警告";
    private static final String d0 = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String e0 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    private static final String f0 = "取消";
    private static final String g0 = "立即设置时间";
    private static final String h0 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String i0 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static j statLoadLogin;
    private int A;
    private volatile boolean B;
    private volatile String C;
    private SapiConfiguration a;
    private WebviewClientCallback b;
    private WebChromeClientCallback c;
    private FileChooserCallback d;
    private ChangePwdCallback e;
    public List<PassNameValuePair> extras;
    private AccountChangeCallback f;
    private boolean g;
    private ReloadConfig h;
    private SapiJsInterpreters i;
    private SapiJsCallBacks.CallBacks j;
    private List<String> k;
    private View l;
    private View m;
    private View n;
    private ProgressBar o;
    private ProgressDialog p;
    private Dialog q;
    private d r;
    private boolean s;
    public boolean shareV2Disable;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide;
    private long t;
    public String[] touchidPortraitAndSign;
    private Handler u;
    private TimeoutTask v;
    private OnFinishCallback w;
    private OnBackCallback x;
    private OnNewBackCallback y;
    private boolean z;
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, "1");
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", "1");
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");

    /* loaded from: classes25.dex */
    public interface AccountChangeCallback {
        void onAccountChange();
    }

    /* loaded from: classes25.dex */
    public static abstract class AccountDestoryCallback {

        /* loaded from: classes25.dex */
        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    /* loaded from: classes25.dex */
    public static abstract class AccountFreezeCallback {

        /* loaded from: classes25.dex */
        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    /* loaded from: classes25.dex */
    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        
        String a;

        ActivityLifeCycle(String str) {
            this.a = str;
        }
    }

    /* loaded from: classes25.dex */
    public interface BdussChangeCallback {
        void onBdussChange();
    }

    /* loaded from: classes25.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes25.dex */
    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;
        public static final int RECORD_VIDEO = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    /* loaded from: classes25.dex */
    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    /* loaded from: classes25.dex */
    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    /* loaded from: classes25.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes25.dex */
        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    /* loaded from: classes25.dex */
    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i);
    }

    /* loaded from: classes25.dex */
    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    /* loaded from: classes25.dex */
    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    /* loaded from: classes25.dex */
    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    /* loaded from: classes25.dex */
    public static class LoadSlideWebViewResult {
        public String adapter;
        public String page;
        public String placeholderTitle;
        public String url;
    }

    /* loaded from: classes25.dex */
    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    /* loaded from: classes25.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes25.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes25.dex */
    public interface OnNewBackCallback {
        boolean onBack();
    }

    /* loaded from: classes25.dex */
    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    /* loaded from: classes25.dex */
    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i, int i2, int i3, PickPhotoResult pickPhotoResult);
    }

    /* loaded from: classes25.dex */
    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    /* loaded from: classes25.dex */
    public static abstract class PreFillUserNameCallback {

        /* loaded from: classes25.dex */
        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    /* loaded from: classes25.dex */
    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    /* loaded from: classes25.dex */
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes25.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4, String str5);
    }

    /* loaded from: classes25.dex */
    public static abstract class SwitchAccountCallback {

        /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
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
                SapiWebView.this.u.sendMessage(message);
                SapiWebView.this.u.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.a = str;
        }
    }

    /* loaded from: classes25.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* loaded from: classes25.dex */
    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes25.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes25.dex */
    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.h = new ReloadConfig();
        this.u = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.v = new TimeoutTask();
        this.A = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (getSettings().getBlockNetworkLoads()) {
            return;
        }
        loadUrl(b(activityLifeCycle.a));
    }

    public void back() {
        View view;
        View view2;
        ProgressBar progressBar;
        if (this.z && (progressBar = this.o) != null && progressBar.getVisibility() == 0) {
            finish();
        } else if (this.z && (view = this.l) != null && view.getVisibility() == 0) {
            finish();
        } else if (this.y == null || this.j.Q != null) {
            super.loadUrl(FN_SWITCH_VIEW);
            a(this.j.Q);
        } else {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.y.onBack();
        }
        View view3 = this.m;
        if ((view3 == null || view3.getVisibility() != 0) && ((view2 = this.n) == null || view2.getVisibility() != 0)) {
            return;
        }
        finish();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.s = true;
        this.u.removeCallbacks(this.v);
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
    }

    public void dismissProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.17
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.p != null && SapiWebView.this.p.isShowing()) {
                    try {
                        SapiWebView.this.p.dismiss();
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

    String getRealnameAuthenticateUrl() {
        return SapiAccountManager.getInstance().getAccountService().e() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    String getSwitchAccountUrl() {
        return SapiAccountManager.getInstance().getAccountService().g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public long getTimeoutMillis() {
        return this.t;
    }

    public String getUaInfo() {
        String encode = URLEncoder.encode("Sapi_8.9.9.1_Android_" + SapiUtils.getAppName(getContext()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + SapiUtils.getVersionName(getContext()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (!TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "") + "_Sapi");
        return (!j() || TextUtils.isEmpty(this.a.userAgent)) ? encode : encode + " " + this.a.userAgent;
    }

    String getUniteVerifyUrl() {
        return SapiAccountManager.getInstance().getAccountService().h() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(b());
    }

    public void loadAccountCenter(String str) {
        loadAccountCenter(null, str);
    }

    public void loadAccountRealName(String str, String str2, boolean z, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", f.a(f.m)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair("scene", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new PassNameValuePair("customLink", str3));
        }
        arrayList.add(new PassNameValuePair("needcbkey", z ? "1" : "0"));
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        loadUrl(a(getAddressManageUrl(), list));
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z, List<PassNameValuePair> list) {
        if (bindWidgetAction != null) {
            if (!TextUtils.isEmpty(str)) {
                a(getContext(), str);
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new PassNameValuePair("skin", str2));
                }
                if (z) {
                    arrayList.add(new PassNameValuePair(FreeSpaceBox.TYPE, "1"));
                }
                if (this.a.supportFaceLogin) {
                    arrayList.add(new PassNameValuePair("liveAbility", "1"));
                }
                String a = a(bindWidgetAction);
                if (arrayList.size() > 0) {
                    a = a + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
                }
                String a2 = a(a, list);
                String a3 = a();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair(this.a.environment.getWap(), a3));
                loadUrl(a2, arrayList2);
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
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.6
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                String str6;
                if (!SapiWebView.this.s) {
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
        loadUrl(a(ParamsUtil.getUrlBind(this.a, SocialType.HUAWEI, str, null, null), list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(a(getInvoiceBuildUrl(), list));
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(a(a(socialType), list));
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z) {
        SapiJsCallBacks.CallBacks callBacks = this.j;
        callBacks.s = qrLoginCallback;
        callBacks.O = z;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadRealnameAuthenticate(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.a.realnameAuthenticateStoken)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.5
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetTplStokenResult getTplStokenResult) {
                        if (SapiWebView.this.j.m != null) {
                            SapiWebView.this.j.m.onFailure();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        String realnameAuthenticateUrl = SapiWebView.this.getRealnameAuthenticateUrl();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new PassNameValuePair("bduss", str));
                        arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                        arrayList2.add(new PassNameValuePair("bdstoken", SapiWebView.this.a.realnameAuthenticateStoken));
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
        loadUrl(a(getLoginUrl(), list) + R);
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().l() + "&adapter=3") + W);
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        loadUrl(a(getSwitchAccountUrl(), list));
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.B = true;
        this.C = str2;
        ArrayList arrayList = new ArrayList();
        String url = this.a.environment.getURL();
        arrayList.add(new PassNameValuePair(url, str3));
        arrayList.add(new PassNameValuePair("https://baidu.com", str4));
        arrayList.add(new PassNameValuePair("https://baidu.com", str5));
        arrayList.add(new PassNameValuePair(url, str6));
        arrayList.add(new PassNameValuePair(url, str7));
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
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
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

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            this.o.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        View view;
        View view2 = this.m;
        if ((view2 == null || view2.getVisibility() != 0) && ((view = this.n) == null || view.getVisibility() != 0)) {
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        return false;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    @Override // android.webkit.WebView
    public void reload() {
        String str = this.h.a;
        if (str != null) {
            loadUrl(str);
        } else {
            super.reload();
        }
        this.h.a();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        View view;
        View view2 = this.m;
        if ((view2 != null && view2.getVisibility() == 0) || ((view = this.n) != null && view.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i, i2);
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.f = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.j.p = accountDestoryCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.j.q = accountFreezeCallback;
    }

    public void setAddressManageCallback(SapiJsCallBacks.AddressManageCallback addressManageCallback) {
        this.j.I = addressManageCallback;
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.j.G = authorizationListener;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.j.V = bdOauthLoginParams;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.j.j = bdussChangeCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.j.g = bindWidgetCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.j.c = bioScanFaceCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.j.d = biometricsIdentifyCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.e = changePwdCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.j.n = coverWebBdussCallback;
    }

    public void setCurrentAccountBdussExpiredCallback(SapiJsCallBacks.CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        this.j.C = currentAccountBdussExpiredCallback;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.j.T = directedLoginParams;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.d = fileChooserCallback;
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        this.j.K = fingerprintCallback;
    }

    public void setGetCurrentPageNameCallback(SapiJsCallBacks.GetCurrentPageNameCallback getCurrentPageNameCallback) {
        this.j.E = getCurrentPageNameCallback;
    }

    public void setGrantWebCallback(SapiJsCallBacks.GrantWebCallback grantWebCallback) {
        this.j.B = grantWebCallback;
    }

    public void setHideSuccessTip(boolean z) {
        this.j.U = z;
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        this.j.J = invoiceBuildCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.j.t = invokeScAppCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.j.R = joinLoginParams;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.j.l = leftBtnVisibleCallback;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.j.h = loadExternalWebViewCallback;
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        this.j.v = loadSlideWebViewCallback;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.j.u = localConfigCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.j.A = loginStatusChangeCallback;
    }

    public final void setNoNetworkView(View view) {
        if (this.m == null) {
            this.m = view;
            this.m.setVisibility(4);
            addView(this.m, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        SapiJsCallBacks.CallBacks callBacks = this.j;
        callBacks.x = normalizeGuestAccountCallback;
        callBacks.S = str;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.x = onBackCallback;
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.w = onFinishCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.y = onNewBackCallback;
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        this.j.F = onSlidePageFinishCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.j.H = pageStateCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.j.i = pickPhotoCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.j.o = preFillUserNameCallback;
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.o == null) {
            this.o = progressBar;
            if (this.o != null) {
                addView(progressBar);
            }
        }
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.j.z = realNameStatusCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.j.m = realnameAuthenticateCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.j.r = shareAccountClickCallback;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.j.W = shareV2LoginParams;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.j.a = handler;
    }

    public void setSpeechRecognitionCallback(SapiJsCallBacks.SpeechRecognitionCallback speechRecognitionCallback) {
        this.j.w = speechRecognitionCallback;
    }

    public void setStopSlideWebviewCallback(SapiJsCallBacks.StopSlideWebviewCallback stopSlideWebviewCallback) {
        this.j.D = stopSlideWebviewCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.j.k = switchAccountCallback;
    }

    public void setTimeoutMillis(long j) {
        this.t = j;
    }

    public final void setTimeoutView(View view) {
        if (this.n == null) {
            this.n = view;
            this.n.setVisibility(4);
            addView(this.n, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.j.e = uniteVerifyCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.c = webChromeClientCallback;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.j.b = webViewTitleCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.b = webviewClientCallback;
    }

    public void setWebviewLoadingView(View view) {
        if (this.l == null) {
            this.l = view;
            this.l.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.j.y = webviewPageFinishCallback;
    }

    public void showProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SapiWebView.this.p = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
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
        } catch (NullPointerException e) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void e() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            Log.e(e);
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
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
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
        View view = this.m;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.n;
            if (view2 == null || view2.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.l != null) {
                            SapiWebView.this.l.setVisibility(0);
                            if (SapiWebView.this.o != null) {
                                SapiWebView.this.o.setVisibility(8);
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.o != null) {
                    SapiWebView.this.o.setVisibility(8);
                }
                if (SapiWebView.this.l != null) {
                    SapiWebView.this.l.setVisibility(8);
                }
                if (SapiWebView.this.m != null) {
                    SapiWebView.this.m.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.o != null) {
                    SapiWebView.this.o.setVisibility(8);
                }
                if (SapiWebView.this.l != null) {
                    SapiWebView.this.l.setVisibility(8);
                }
                SapiWebView.this.h.a = SapiWebView.this.v.a;
                if (SapiWebView.this.n != null) {
                    SapiWebView.this.n.setVisibility(0);
                }
            }
        });
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void i() {
        this.j = new SapiJsCallBacks.CallBacks();
        this.i = new SapiJsInterpreters(this, this.j);
        this.t = DEFAULT_TIMEOUT_MILLIS;
        this.a = SapiAccountManager.getInstance().getSapiConfiguration();
        this.r = new d();
        this.g = new FaceLoginService().isSupFaceLogin();
        e();
        k();
        int i = Build.VERSION.SDK_INT;
        if (i > 10 && i < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new AnonymousClass2());
        setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.SapiWebView.3
            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i2, String str2) {
                Log.d(str + " -- From line " + i2 + " of " + str2, new Object[0]);
                if (SapiWebView.this.c != null) {
                    SapiWebView.this.c.onConsoleMessage(str, i2, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
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
                if (SapiWebView.this.c == null || !SapiWebView.this.c.isSubClassHandleMessage(str2)) {
                    Log.i(Log.TAG, "webview", str2);
                    final String[] strArr = {""};
                    SapiWebView.this.j.M = jsPromptResult;
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Command parse = Command.parse(str2);
                            if (parse != null) {
                                String actionName = parse.getActionName();
                                if (SapiWebView.this.k.contains(actionName)) {
                                    SapiWebView.this.j.M = jsPromptResult;
                                }
                                SapiJsInterpreters.AbstractInterpreter a = SapiWebView.this.i.a(actionName);
                                if (a != null) {
                                    try {
                                        strArr[0] = a.interpret(parse);
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
                                            k.a(linkedHashMap, hashMap);
                                        } catch (JSONException e) {
                                        }
                                    }
                                }
                                if (parse.getActionParams().size() <= 2 || !SapiWebView.D.equals(parse.getActionParams().get(2))) {
                                    if (!SapiWebView.this.k.contains(actionName)) {
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
                return SapiWebView.this.c.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.o != null) {
                    if (i2 == 100) {
                        SapiWebView.this.o.setVisibility(8);
                    } else {
                        if (SapiWebView.this.o.getVisibility() == 8) {
                            SapiWebView.this.o.setVisibility(0);
                        }
                        SapiWebView.this.o.setProgress(i2);
                    }
                }
                super.onProgressChanged(webView, i2);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(5)
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * j);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.d != null) {
                    SapiWebView.this.d.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                if (SapiWebView.this.d != null) {
                    SapiWebView.this.d.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.d != null) {
                    SapiWebView.this.d.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.d != null) {
                    SapiWebView.this.d.onFileChooser(valueCallback);
                }
            }
        });
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        j jVar = statLoadLogin;
        if (jVar != null) {
            jVar.b = System.currentTimeMillis();
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
        this.k = new ArrayList();
        this.k.add("sapi_action_pick_image");
        this.k.add("sapi_action_pick_date");
        this.k.add("sapi_biometrics_identification");
        this.k.add("sapi_biometrics_identification_no_bduss");
        this.k.add("sapi_biometrics_identification_with_authtoken");
        this.k.add("sapi_biometrics_identification_with_uid");
        this.k.add("sapi_action_sc_app_invoke");
        this.k.add("oauth_sso_hash");
        this.k.add("sapi_action_china_mobile_oauth");
        this.k.add("address_manage_get_contact");
        this.k.add("touchid_open_guide");
        this.k.add("touchid_change_status");
        this.k.add("touchid_login");
        this.k.add("speech_recognition_get_content");
        this.k.add("sapi_onekey_oauth_token");
    }

    public void finish(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (!SapiWebView.this.s) {
                    SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                    if (TextUtils.isEmpty(str)) {
                        if (SapiWebView.this.w != null) {
                            SapiWebView.this.w.onFinish();
                        }
                    } else if (SapiWebView.this.j.F != null) {
                        SapiWebView.this.j.F.onFinish(str);
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
        int i;
        if (!TextUtils.isEmpty(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new PassNameValuePair("clientfrom", "native"));
            list.add(new PassNameValuePair("client", "android"));
            list.add(new PassNameValuePair("deliverParams", "1"));
            if (this.a.supportFaceLogin) {
                list.add(new PassNameValuePair("scanface", "1"));
            }
            if (this.j.i != null && this.a.supportPhoto) {
                list.add(new PassNameValuePair("support_photo", "1"));
            }
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str2 = str.substring(0, indexOf + 1) + SapiUtils.createRequestParams(list) + ETAG.ITEM_SEPARATOR + str.substring(i, str.length());
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
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(f.a(f.l) + "?" + I + ETAG.EQUAL + J, "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e) {
            Log.e(e);
        }
        String forgetPwdUrl = getForgetPwdUrl();
        if (arrayList.size() > 0) {
            forgetPwdUrl = forgetPwdUrl + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(forgetPwdUrl);
    }

    public void loadLogin(int i) {
        loadLogin(i, null);
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        d(str);
        String str2 = null;
        if (!TextUtils.isEmpty(str) && !str.contains("javascript:")) {
            a(list);
            str2 = this.r.b(getContext(), str);
        }
        if (!TextUtils.isEmpty(str2)) {
            String a = a(str2, str);
            loadDataWithBaseURL(a, str2, L, "UTF-8", a);
            return;
        }
        c(str);
    }

    private void c(List<PassNameValuePair> list) {
        String a = a(getLoginUrl(), list);
        if (this.j.h != null) {
            a = a + "&enableExternalWeb=1";
        }
        if (this.a.supportFaceLogin) {
            a = a + "&liveAbility=1";
        }
        loadUrl(a + P);
    }

    private void d(String str) {
        if (statLoadLogin != null) {
            if (str.contains(N) || str.contains(S) || str.contains(P) || str.contains(U) || str.contains(T) || (this.g && str.contains(a0))) {
                statLoadLogin.d = System.currentTimeMillis();
            }
        }
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.a(getContext(), str);
        String a = a(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.j.i != null && this.a.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.j.d != null && this.a.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(a(a, list));
    }

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    private String b(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    public void loadLogin(int i, List<PassNameValuePair> list) {
        if (this.a.supportFaceLogin && this.j.d == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        j jVar = statLoadLogin;
        if (jVar != null) {
            jVar.c = System.currentTimeMillis();
        }
        this.extras = list;
        if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
            b(i, list);
        } else if (4 == i) {
            c(list);
        } else if (i == 6) {
            a(i);
        } else {
            this.shareV2Disable = SapiShareClient.isInV2ShareDisableWhiteList() && this.shareV2Disable;
            if (this.j.r != null && !this.shareV2Disable) {
                list.add(new PassNameValuePair(b.c.h, "2"));
                c(i, list);
            } else if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
                c(i, list);
            } else if (this.g) {
                b(list);
            } else if (new OneKeyLoginSdkCall().a()) {
                a(i, list);
            } else {
                b(i, list);
            }
        }
        SapiStatUtil.statLoadLogin(null);
    }

    private void b(List<PassNameValuePair> list) {
        String a = a(getLoginUrl(), list);
        if (this.j.h != null) {
            a = a + "&enableExternalWeb=1";
        }
        loadUrl((a + "&liveAbility=1") + a0);
    }

    public boolean onKeyUp(int i) {
        if (i == 4 && this.A == 1) {
            OnBackCallback onBackCallback = this.x;
            if (onBackCallback != null && this.j.Q == null) {
                onBackCallback.onBack();
            }
            back();
            return true;
        }
        return false;
    }

    private void a(int i) {
        String str = a(getLoginUrl(), this.extras) + "&loginInitType=" + i;
        if (this.j.h != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.a.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + O);
    }

    List<PassNameValuePair> d() {
        String diCookieInfo;
        List<String> j = SapiContext.getInstance().getSapiOptions().j();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.a.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        if (j.size() == 1 && j.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(j);
        }
        String wap = this.a.environment.getWap();
        if (diCookieInfo == null) {
            diCookieInfo = "";
        }
        arrayList.add(new PassNameValuePair(wap, SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo)));
        return arrayList;
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.a.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.a.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    private void c(int i, List<PassNameValuePair> list) {
        String str;
        String loginUrl = getLoginUrl();
        if (this.j.h != null) {
            loginUrl = loginUrl + "&enableExternalWeb=1";
        }
        if (this.a.supportFaceLogin) {
            loginUrl = loginUrl + "&liveAbility=1";
        }
        if (this.g && this.j.d != null) {
            str = loginUrl + "&loginInitType=4";
        } else if (new OneKeyLoginSdkCall().a()) {
            str = loginUrl + "&loginInitType=5";
        } else {
            str = loginUrl + "&loginInitType=" + i;
        }
        loadUrl(a(str, list) + S);
    }

    private void b(int i, List<PassNameValuePair> list) {
        String str = a(getLoginUrl(), list) + "&loginInitType=" + i;
        if (i == 0) {
            if (this.j.h != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.a.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            loadUrl(str + N);
        } else if (i != 1) {
            loadUrl(str + N);
        } else {
            if (this.j.h != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.a.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            loadUrl(str + T);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes25.dex */
    public class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            }
            if (SapiWebView.this.l != null) {
                SapiWebView.this.l.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.m != null && SapiWebView.this.m.getVisibility() != 4) {
                SapiWebView.this.m.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.h0);
            if (SapiWebView.this.j.b != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            if (SapiWebView.this.B && !TextUtils.isEmpty(SapiWebView.this.C)) {
                SapiWebView sapiWebView = SapiWebView.this;
                SapiWebView.super.loadUrl(String.format(SapiWebView.i0, sapiWebView.C));
                SapiWebView.this.B = false;
                SapiWebView.this.C = null;
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().i());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().j());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.z = true;
            } else {
                SapiWebView.this.z = false;
            }
            if ((str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) && !"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.u.removeCallbacks(SapiWebView.this.v);
            if (SapiWebView.this.b != null) {
                SapiWebView.this.b.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.j.H != null) {
                Uri parse = Uri.parse(SapiWebView.this.getLoginUrl());
                Uri parse2 = Uri.parse(str);
                if (parse2 == null || !(parse2.getHost() + parse2.getPath()).equals(parse.getHost() + parse.getPath())) {
                    SapiWebView.this.j.H.pageState(2);
                } else {
                    SapiWebView.this.j.H.pageState(1);
                }
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.g();
            }
            SapiWebView.this.v.setUrl(str);
            SapiWebView.this.u.postDelayed(SapiWebView.this.v, SapiWebView.this.t);
            SapiWebView.this.f();
            if (str != null) {
                if (str.contains(SapiWebView.J) || str.contains(SapiWebView.K)) {
                    String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.I);
                    if (SapiWebView.J.equals(queryParameter) && SapiWebView.this.e != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.e != null) {
                                    SapiWebView.this.e.onSuccess();
                                }
                            }
                        });
                    }
                    if (SapiWebView.K.equals(queryParameter) && SapiWebView.this.e != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.e != null) {
                                        SapiWebView.this.e.onSuccess();
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
                                        if (SapiWebView.this.e != null) {
                                            SapiWebView.this.e.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.e != null) {
                                            SapiWebView.this.e.onSuccess();
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
                                        if (SapiWebView.this.e != null) {
                                            SapiWebView.this.e.onSuccess();
                                        }
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.H.equals(Uri.parse(str).getQueryParameter(SapiWebView.I))) {
                    if (SapiWebView.this.j.Q == null) {
                        if (SapiWebView.this.j.G != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.j.G != null) {
                                        SapiWebView.this.j.G.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                        }
                    } else {
                        SapiWebView sapiWebView = SapiWebView.this;
                        sapiWebView.a(sapiWebView.j.Q);
                    }
                }
            }
            if (SapiWebView.this.b != null) {
                SapiWebView.this.b.onPageStarted(webView, str, bitmap);
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
            k.a("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
            if ((sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) && !(!SapiWebView.this.a.forbidSslErrorDialog)) {
                if (SapiWebView.this.q == null) {
                    if (Build.VERSION.SDK_INT > 17) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SapiWebView.d0);
                        Date date = new Date(System.currentTimeMillis());
                        str = SapiWebView.b0;
                        str2 = simpleDateFormat.format(date);
                    } else {
                        str = SapiWebView.c0;
                        str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(SapiWebView.g0, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent("android.settings.DATE_SETTINGS");
                            intent.setFlags(268435456);
                            SapiWebView.this.getContext().startActivity(intent);
                            dialogInterface.dismiss();
                            k.a("sslerr_date_setting", (Map<String, String>) null);
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            k.a("sslerr_date_cancel", (Map<String, String>) null);
                        }
                    });
                    SapiWebView.this.q = builder.create();
                }
                if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.q.isShowing()) {
                    SapiWebView.this.q.show();
                }
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (webResourceRequest.getUrl().toString().contains(SapiWebView.E)) {
                        String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str)) {
                            return new WebResourceResponse("text/css", "utf-8", com.baidu.sapi2.utils.d.a(SapiWebView.this.getContext(), str));
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
                    if (f.a(f.m).equals(str)) {
                        SapiWebView.this.finish();
                    }
                    if (SapiWebView.this.j.V != null && SapiWebView.this.j.V.redirectUrl != null && str.contains(SapiWebView.this.j.V.redirectUrl)) {
                        SapiWebView.this.j.V.callback.onCallback(str);
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
            if (SapiWebView.this.b != null) {
                SapiWebView.this.b.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    if (str.contains(SapiWebView.E)) {
                        String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str2)) {
                            return new WebResourceResponse("text/css", "utf-8", com.baidu.sapi2.utils.d.a(SapiWebView.this.getContext(), str2));
                        }
                    }
                } catch (Exception e) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    private void a(int i, List<PassNameValuePair> list) {
        String str = a(getLoginUrl(), list) + "&loginInitType=" + i;
        if (this.j.h != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.a.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + V);
    }

    private String a(String str, List<PassNameValuePair> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    try {
                        arrayList.add(new PassNameValuePair(URLEncoder.encode(passNameValuePair.getName(), "UTF-8"), URLEncoder.encode(passNameValuePair.getValue(), "UTF-8")));
                    } catch (UnsupportedEncodingException e) {
                        Log.e(e);
                    }
                }
            }
            return !arrayList.isEmpty() ? str + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList) : str;
        }
        return str;
    }

    private void c(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.s) {
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

    List<PassNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.a.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = this.a.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        SapiConfiguration sapiConfiguration = this.a;
        if (sapiConfiguration.isDarkMode) {
            arrayList.add(new PassNameValuePair(sapiConfiguration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "dark")));
            arrayList.add(new PassNameValuePair(this.a.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "dark")));
        } else {
            arrayList.add(new PassNameValuePair(sapiConfiguration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "light")));
            arrayList.add(new PassNameValuePair(this.a.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "light")));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (statLoadLogin != null) {
            if (str.contains(N) || str.contains(S) || str.contains(P) || str.contains(U) || str.contains(T) || (this.g && str.contains(a0))) {
                statLoadLogin.e = System.currentTimeMillis();
                statLoadLogin.f = z;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SocialResponse b(String str, Context context) {
        SocialResponse socialResponse = null;
        String b = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b.getBytes()), "UTF-8");
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
                            } catch (Exception e) {
                                e = e;
                                socialResponse = socialResponse2;
                                Log.e(e);
                                return socialResponse;
                            }
                        } else if (socialResponse == null && name.equalsIgnoreCase("error_description")) {
                            SocialResponse socialResponse3 = new SocialResponse();
                            try {
                                socialResponse3.errorMsg = newPullParser.nextText();
                                socialResponse = socialResponse3;
                            } catch (Exception e2) {
                                e = e2;
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
                    } catch (Exception e3) {
                        e = e3;
                        Log.e(e);
                        return socialResponse;
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        return socialResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [161=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccountResponse a(String str, Context context) {
        SapiAccountResponse sapiAccountResponse;
        Throwable th;
        XmlPullParser newPullParser;
        int eventType;
        SapiAccountResponse sapiAccountResponse2;
        boolean z;
        SapiAccountResponse sapiAccountResponse3 = null;
        String b = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b)) {
            try {
                newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b.getBytes()), "UTF-8");
                eventType = newPullParser.getEventType();
                sapiAccountResponse2 = null;
                z = false;
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
                                    if (z) {
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
                                    z = true;
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
                                        nextText2 = new OneKeyLoginSdkCall().c();
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
                                } else if (name.equals("guest_account")) {
                                    sapiAccountResponse2.isGuestAccount = newPullParser.nextText();
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

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.h = new ReloadConfig();
        this.u = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.v = new TimeoutTask();
        this.A = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
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
        sapiAccount.putExtra("tpl", this.a.tpl);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount b = b(sapiAccountResponse);
            if (this.j.G != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.12
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SapiWebView.this.j.G.beforeSuccess(b);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiShareClient.getInstance().validate(b);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(b, SapiWebView.this.extras);
                    }
                });
            }
        }
    }

    List<PassNameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        if (this.a.supportFaceLogin) {
            SapiJsCallBacks.CallBacks callBacks = this.j;
            if (callBacks.c != null && callBacks.d != null) {
                arrayList.add(new PassNameValuePair("liveAbility", "1"));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SocialResponse socialResponse) {
        int i;
        if (socialResponse != null) {
            final SapiAccount b = b(socialResponse);
            if (SapiAccount.isValidAccount(b)) {
                socialResponse.errorCode = 0;
            }
            if (socialResponse.accountCenterFlag && ((i = socialResponse.errorCode) == 0 || i == 110000)) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.13
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        SapiShareClient.getInstance().validate(b);
                        if (SapiWebView.this.f == null || currentAccount.uid.equals(b.uid)) {
                            return;
                        }
                        SapiWebView.this.f.onAccountChange();
                    }
                });
            } else if (this.j.G != null) {
                int i2 = socialResponse.errorCode;
                if (i2 != 0 && i2 != 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.j.G != null) {
                                AuthorizationListener authorizationListener = SapiWebView.this.j.G;
                                SocialResponse socialResponse2 = socialResponse;
                                authorizationListener.onFailed(socialResponse2.errorCode, socialResponse2.errorMsg);
                            }
                            SapiWebView.this.j.Q = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.j.G != null) {
                                    SapiWebView.this.j.G.beforeSuccess(b);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            SapiShareClient.getInstance().validate(b);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.j.Q = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (!TextUtils.isEmpty(this.j.L[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.j.L;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        AuthorizationListener authorizationListener = this.j.G;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.j.G.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e) {
                Log.e(e);
            }
            this.j.G.onSuccess();
        }
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.h = new ReloadConfig();
        this.u = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.v = new TimeoutTask();
        this.A = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    String a(String str, String str2) {
        String[] split;
        String str3;
        if (str2.split("#").length > 1) {
            e sapiOptions = SapiContext.getInstance().getSapiOptions();
            String a = this.r.a(str2);
            if (this.r.c(getContext(), a) != null) {
                String str4 = this.r.c(getContext(), a).c;
                String md5 = SecurityUtil.md5(str.getBytes(), false);
                String b = sapiOptions.e().b();
                if (str4.equals(md5)) {
                    str3 = (TextUtils.isEmpty(b) ? "" : "&passAppVersion=" + b) + "&passAppHash=" + this.r.c(getContext(), a).c;
                } else {
                    str3 = "&passAppHash=" + SecurityUtil.md5(str.getBytes(), false);
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    String a() {
        return SapiUtils.buildBDUSSCookie(this.a.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    void a(List<PassNameValuePair> list) {
        List<PassNameValuePair> d = d();
        List<PassNameValuePair> c = c();
        if (list != null && !list.isEmpty()) {
            d.addAll(list);
        }
        if (c != null && !c.isEmpty()) {
            d.addAll(c);
        }
        SapiUtils.syncCookies(getContext(), d);
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
}
