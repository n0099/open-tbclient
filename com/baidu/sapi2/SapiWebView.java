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
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.alibaba.fastjson.asm.Label;
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
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.h;
import com.baidu.sapi2.utils.k;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.wallet.api.IWalletLoginListener;
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
/* loaded from: classes2.dex */
public class SapiWebView extends WebView {
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    public static final String C = "prompt_on_cancel";
    public static final String D = "css/sapi_theme/style.css";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final int E = 1;
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final int F = 0;
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    public static final String G = "renren-offline";
    public static final String H = "__wp-action";
    public static final String I = "forget-pwd";
    public static final String J = "modify-pwd";
    public static final String K = "text/html";
    public static final String L = "UTF-8";
    public static final String M = "#login";
    public static final String N = "#insert_account";
    public static final String O = "#canshareAi";
    public static final String P = "#authPwd";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String PARAMS_SCREEN_TYPE = "screenType";
    public static final String Q = "#reg";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    public static final String R = "#canshare_accounts";
    public static final String S = "#sms_login";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";
    public static final String T = "#fastReg";
    public static final String U = "#oneKeyLogin";
    public static final String V = "#share_auth";
    public static final String W = "#face_login";
    public static final String a0 = "系统时间错误";
    public static final String b0 = "证书安全警告";
    public static final String c0 = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    public static final String d0 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String e0 = "取消";
    public static final String f0 = "立即设置时间";
    public static final String g0 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    public static final String h0 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static k statLoadLogin;
    public volatile boolean A;
    public volatile String B;

    /* renamed from: a  reason: collision with root package name */
    public SapiConfiguration f10406a;

    /* renamed from: b  reason: collision with root package name */
    public WebviewClientCallback f10407b;

    /* renamed from: c  reason: collision with root package name */
    public WebChromeClientCallback f10408c;

    /* renamed from: d  reason: collision with root package name */
    public ChangePwdCallback f10409d;

    /* renamed from: e  reason: collision with root package name */
    public AccountChangeCallback f10410e;
    public List<PassNameValuePair> extras;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10411f;

    /* renamed from: g  reason: collision with root package name */
    public ReloadConfig f10412g;

    /* renamed from: h  reason: collision with root package name */
    public SapiJsInterpreters f10413h;
    public SapiJsCallBacks.CallBacks i;
    public List<String> j;
    public View k;
    public View l;
    public View m;
    public LoginTypes mExcludeTypes;
    public boolean mHadMakeBarHide;
    public ProgressBar n;
    public ProgressDialog o;
    public Dialog p;
    public d q;
    public boolean r;
    public long s;
    public boolean shareV2Disable;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide;
    public Handler t;
    public String[] touchidPortraitAndSign;
    public TimeoutTask u;
    public OnFinishCallback v;
    public OnBackCallback w;
    public OnNewBackCallback x;
    public boolean y;
    public int z;
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair("direct", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", "1");
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");

    /* loaded from: classes2.dex */
    public interface AccountChangeCallback {
        void onAccountChange();
    }

    /* loaded from: classes2.dex */
    public static abstract class AccountDestoryCallback {

        /* loaded from: classes2.dex */
        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class AccountFreezeCallback {

        /* loaded from: classes2.dex */
        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    /* loaded from: classes2.dex */
    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        

        /* renamed from: a  reason: collision with root package name */
        public String f10460a;

        ActivityLifeCycle(String str) {
            this.f10460a = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface BdussChangeCallback {
        void onBdussChange();
    }

    /* loaded from: classes2.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes2.dex */
    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static class Command {

        /* renamed from: a  reason: collision with root package name */
        public String f10461a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f10462b = new ArrayList();

        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                Command command = new Command();
                JSONObject optJSONObject = jSONObject.optJSONObject("action");
                if (optJSONObject != null) {
                    command.f10461a = optJSONObject.optString("name");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            command.f10462b.add(optJSONArray.optString(i));
                        }
                    }
                }
                return command;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }

        public String getActionName() {
            return this.f10461a;
        }

        public List<String> getActionParams() {
            return this.f10462b;
        }
    }

    /* loaded from: classes2.dex */
    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    /* loaded from: classes2.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes2.dex */
        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    /* loaded from: classes2.dex */
    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i);
    }

    /* loaded from: classes2.dex */
    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    /* loaded from: classes2.dex */
    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    /* loaded from: classes2.dex */
    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    /* loaded from: classes2.dex */
    public static class LoadSlideWebViewResult {
        public String adapter;
        public String page;
        public String placeholderTitle;
        public String url;
    }

    /* loaded from: classes2.dex */
    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    /* loaded from: classes2.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes2.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes2.dex */
    public interface OnNewBackCallback {
        boolean onBack();
    }

    /* loaded from: classes2.dex */
    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i, int i2, int i3, PickPhotoResult pickPhotoResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class PreFillUserNameCallback {

        /* loaded from: classes2.dex */
        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    /* loaded from: classes2.dex */
    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes2.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public class ReloadConfig {

        /* renamed from: a  reason: collision with root package name */
        public String f10463a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10464b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10465c;

        /* renamed from: d  reason: collision with root package name */
        public String f10466d;

        /* renamed from: e  reason: collision with root package name */
        public List<PassNameValuePair> f10467e;

        public ReloadConfig() {
            this.f10463a = null;
            this.f10464b = false;
        }

        public void a() {
            this.f10463a = null;
            this.f10464b = false;
        }
    }

    /* loaded from: classes2.dex */
    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4, String str5);
    }

    /* loaded from: classes2.dex */
    public static abstract class SwitchAccountCallback {

        /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class TimeoutTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f10469a;

        public TimeoutTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.f10469a;
                SapiWebView.this.t.sendMessage(message);
                SapiWebView.this.t.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.f10469a = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* loaded from: classes2.dex */
    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes2.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes2.dex */
    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.f10412g = new ReloadConfig();
        this.t = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.u = new TimeoutTask();
        this.z = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    public static String replaceParams(String str, String str2, String str3) {
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

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (getSettings().getBlockNetworkLoads()) {
            return;
        }
        loadUrl(c(activityLifeCycle.f10460a));
    }

    public void back() {
        View view;
        View view2;
        ProgressBar progressBar;
        if (this.y && (progressBar = this.n) != null && progressBar.getVisibility() == 0) {
            finish();
        } else if (this.y && (view = this.k) != null && view.getVisibility() == 0) {
            finish();
        } else if (this.x == null || this.i.T != null) {
            super.loadUrl(FN_SWITCH_VIEW);
            a(this.i.T);
        } else {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.x.onBack();
        }
        View view3 = this.l;
        if ((view3 == null || view3.getVisibility() != 0) && ((view2 = this.m) == null || view2.getVisibility() != 0)) {
            return;
        }
        finish();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.r = true;
        this.t.removeCallbacks(this.u);
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
                if (SapiWebView.this.o == null || !SapiWebView.this.o.isShowing()) {
                    return;
                }
                try {
                    SapiWebView.this.o.dismiss();
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void finish() {
        finish("");
    }

    public String getAddressManageUrl() {
        return SapiAccountManager.getInstance().getAccountService().a() + "&" + SapiUtils.createRequestParams(b());
    }

    public String getForgetPwdUrl() {
        return SapiAccountManager.getInstance().getAccountService().b() + "&" + SapiUtils.createRequestParams(b());
    }

    public String getInvoiceBuildUrl() {
        return SapiAccountManager.getInstance().getAccountService().c() + "&" + SapiUtils.createRequestParams(b());
    }

    public SapiJsCallBacks.CallBacks getJsCallBacks() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getLocalPhoneNumber() {
        String line1Number;
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
        return SapiAccountManager.getInstance().getAccountService().d();
    }

    public String getRealnameAuthenticateUrl() {
        return SapiAccountManager.getInstance().getAccountService().e() + "&" + SapiUtils.createRequestParams(b());
    }

    public String getSwitchAccountUrl() {
        return SapiAccountManager.getInstance().getAccountService().g() + "&" + SapiUtils.createRequestParams(b());
    }

    public long getTimeoutMillis() {
        return this.s;
    }

    public String getUaInfo() {
        String str = !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
        String str2 = TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE;
        String encode = URLEncoder.encode("Sapi_9.2.9.8_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + str + "_" + str2 + "_Sapi");
        if (!j() || TextUtils.isEmpty(this.f10406a.userAgent)) {
            return encode;
        }
        return encode + " " + this.f10406a.userAgent;
    }

    public String getUniteVerifyUrl() {
        return SapiAccountManager.getInstance().getAccountService().h() + "&" + SapiUtils.createRequestParams(b());
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadAccountRealName(String str, String str2, boolean z, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", h.a(h.m)));
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
                if (this.f10406a.supportFaceLogin) {
                    arrayList.add(new PassNameValuePair("liveAbility", "1"));
                }
                String a2 = a(bindWidgetAction);
                if (arrayList.size() > 0) {
                    a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
                }
                String a3 = a(a2, list);
                String a4 = a();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair(this.f10406a.environment.getWap(), a4));
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
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.6
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                String str6;
                if (SapiWebView.this.r) {
                    return;
                }
                if (str.split("#").length > 0) {
                    str6 = split[0] + "&loadDataWithBaseUrl=1#" + split[1];
                } else {
                    str6 = str + "&loadDataWithBaseUrl=1";
                }
                SapiWebView.this.a(str, true);
                SapiWebView.super.loadDataWithBaseURL(str6, str2, str3, str4, str5);
            }
        });
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new PassNameValuePair("clientfrom", "native"));
            list.add(new PassNameValuePair("client", "android"));
            list.add(new PassNameValuePair("deliverParams", "1"));
            if (this.f10406a.supportFaceLogin) {
                list.add(new PassNameValuePair("scanface", "1"));
            }
            if (this.i.j != null && this.f10406a.supportPhoto) {
                list.add(new PassNameValuePair("support_photo", "1"));
            }
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                int i = indexOf + 1;
                str2 = str.substring(0, i) + SapiUtils.createRequestParams(list) + "&" + str.substring(i, str.length());
            } else {
                str2 = str + "?" + SapiUtils.createRequestParams(list);
            }
            loadUrl(str2);
            return;
        }
        throw new IllegalArgumentException("externalUrl can't be empty");
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        loadUrl(a(ParamsUtil.getUrlBind(this.f10406a, SocialType.HUAWEI, str, null, null), list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(a(getInvoiceBuildUrl(), list));
    }

    public void loadIqiyiBindServer(String str) {
        if (str == null) {
            return;
        }
        String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.f10406a.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.f10406a.environment.getURL(), buildIqiyiCookie));
        loadUrl(str, arrayList);
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(a(a(socialType), list));
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z) {
        SapiJsCallBacks.CallBacks callBacks = this.i;
        callBacks.t = qrLoginCallback;
        callBacks.R = z;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadRealnameAuthenticate(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.f10406a.realnameAuthenticateStoken)) {
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
                        if (SapiWebView.this.i.n != null) {
                            SapiWebView.this.i.n.onFailure();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        String realnameAuthenticateUrl = SapiWebView.this.getRealnameAuthenticateUrl();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new PassNameValuePair("bduss", str));
                        arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                        arrayList2.add(new PassNameValuePair("bdstoken", SapiWebView.this.f10406a.realnameAuthenticateStoken));
                        SapiWebView.this.loadUrl(realnameAuthenticateUrl + "&" + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
                    }
                }, str, arrayList);
                return;
            }
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadRegist(List<PassNameValuePair> list) {
        String loginUrl = getLoginUrl();
        loadUrl(a(loginUrl, list) + Q);
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().l() + "&adapter=3") + V);
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        loadUrl(a(getSwitchAccountUrl(), list));
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.A = true;
        this.B = str2;
        ArrayList arrayList = new ArrayList();
        String url = this.f10406a.environment.getURL();
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
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            String uniteVerifyUrl = getUniteVerifyUrl();
            loadUrl(uniteVerifyUrl + "&" + SapiUtils.createRequestParams(arrayList));
            return;
        }
        throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        loadUrl(b(str), Collections.emptyList());
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onKeyUp(int i) {
        if (i == 4 && this.z == 1) {
            OnBackCallback onBackCallback = this.w;
            if (onBackCallback != null && this.i.T == null) {
                onBackCallback.onBack();
            }
            back();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ProgressBar progressBar = this.n;
        if (progressBar != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            this.n.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        View view = this.l;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.m;
            if (view2 == null || view2.getVisibility() != 0) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }
        return false;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    @Override // android.webkit.WebView
    public void reload() {
        String str = this.f10412g.f10463a;
        if (str != null) {
            loadUrl(str);
        } else {
            super.reload();
        }
        this.f10412g.a();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        View view;
        View view2 = this.l;
        if ((view2 != null && view2.getVisibility() == 0) || ((view = this.m) != null && view.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i, i2);
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.f10410e = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.i.q = accountDestoryCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.i.r = accountFreezeCallback;
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.i.H = authorizationListener;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.i.Y = bdOauthLoginParams;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.i.k = bdussChangeCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.i.f10246h = bindWidgetCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.i.f10242d = bioScanFaceCallback;
    }

    public void setBiometricsIdentificationLiveCallBack(SapiJsCallBacks.BiometricsIdentificationLiveCallBack biometricsIdentificationLiveCallBack) {
        this.i.N = biometricsIdentificationLiveCallBack;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.i.f10243e = biometricsIdentifyCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.f10409d = changePwdCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.i.o = coverWebBdussCallback;
    }

    public void setCurrentAccountBdussExpiredCallback(SapiJsCallBacks.CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        this.i.D = currentAccountBdussExpiredCallback;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.i.W = directedLoginParams;
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        this.i.K = fingerprintCallback;
    }

    public void setFocusEdittextCoordinateYCallBack(SapiJsCallBacks.FocusEdittextCoordinateYCallBack focusEdittextCoordinateYCallBack) {
        this.i.M = focusEdittextCoordinateYCallBack;
    }

    public void setGetCurrentPageNameCallback(SapiJsCallBacks.GetCurrentPageNameCallback getCurrentPageNameCallback) {
        this.i.F = getCurrentPageNameCallback;
    }

    public void setGrantWebCallback(SapiJsCallBacks.GrantWebCallback grantWebCallback) {
        this.i.C = grantWebCallback;
    }

    public void setHadMakeBarHide(boolean z) {
        this.mHadMakeBarHide = z;
    }

    public void setHideSuccessTip(boolean z) {
        this.i.X = z;
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        this.i.J = invoiceBuildCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.i.u = invokeScAppCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.i.U = joinLoginParams;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.i.m = leftBtnVisibleCallback;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.i.i = loadExternalWebViewCallback;
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        this.i.w = loadSlideWebViewCallback;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.i.v = localConfigCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.i.B = loginStatusChangeCallback;
    }

    public final void setNoNetworkView(View view) {
        if (this.l == null) {
            this.l = view;
            view.setVisibility(4);
            addView(this.l, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        SapiJsCallBacks.CallBacks callBacks = this.i;
        callBacks.y = normalizeGuestAccountCallback;
        callBacks.V = str;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.w = onBackCallback;
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.v = onFinishCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.x = onNewBackCallback;
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        this.i.G = onSlidePageFinishCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.i.I = pageStateCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.i.j = pickPhotoCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.i.p = preFillUserNameCallback;
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.n != null) {
            return;
        }
        this.n = progressBar;
        if (progressBar != null) {
            addView(progressBar);
        }
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.i.A = realNameStatusCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.i.n = realnameAuthenticateCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.i.s = shareAccountClickCallback;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.i.Z = shareV2LoginParams;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.i.f10240b = handler;
    }

    public void setSocialVerificationHandler(Handler handler) {
        this.i.f10239a = handler;
    }

    public void setSpeechRecognitionCallback(SapiJsCallBacks.SpeechRecognitionCallback speechRecognitionCallback) {
        this.i.x = speechRecognitionCallback;
    }

    public void setStopSlideWebviewCallback(SapiJsCallBacks.StopSlideWebviewCallback stopSlideWebviewCallback) {
        this.i.E = stopSlideWebviewCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.i.l = switchAccountCallback;
    }

    public void setSwitchStyleForCloseBtnAndStatusBarCallBack(SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack switchStyleForCloseBtnAndStatusBarCallBack) {
        this.i.L = switchStyleForCloseBtnAndStatusBarCallBack;
    }

    public void setTimeoutMillis(long j) {
        this.s = j;
    }

    public final void setTimeoutView(View view) {
        if (this.m == null) {
            this.m = view;
            view.setVisibility(4);
            addView(this.m, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.i.f10244f = uniteVerifyCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.f10408c = webChromeClientCallback;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.i.f10241c = webViewTitleCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.f10407b = webviewClientCallback;
    }

    public void setWebviewLoadingView(View view) {
        if (this.k == null) {
            this.k = view;
            view.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.i.z = webviewPageFinishCallback;
    }

    public void showProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SapiWebView.this.o = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
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
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view = this.l;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.m;
            if (view2 == null || view2.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.k != null) {
                            SapiWebView.this.k.setVisibility(0);
                            if (SapiWebView.this.n != null) {
                                SapiWebView.this.n.setVisibility(8);
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
                if (SapiWebView.this.n != null) {
                    SapiWebView.this.n.setVisibility(8);
                }
                if (SapiWebView.this.k != null) {
                    SapiWebView.this.k.setVisibility(8);
                }
                if (SapiWebView.this.l != null) {
                    SapiWebView.this.l.setVisibility(0);
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
                if (SapiWebView.this.n != null) {
                    SapiWebView.this.n.setVisibility(8);
                }
                if (SapiWebView.this.k != null) {
                    SapiWebView.this.k.setVisibility(8);
                }
                SapiWebView.this.f10412g.f10463a = SapiWebView.this.u.f10469a;
                if (SapiWebView.this.m != null) {
                    SapiWebView.this.m.setVisibility(0);
                }
            }
        });
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void i() {
        SapiJsCallBacks.CallBacks callBacks = new SapiJsCallBacks.CallBacks();
        this.i = callBacks;
        this.f10413h = new SapiJsInterpreters(this, callBacks);
        this.s = DEFAULT_TIMEOUT_MILLIS;
        this.f10406a = SapiAccountManager.getInstance().getSapiConfiguration();
        this.q = new d();
        this.f10411f = new FaceLoginService().isSupFaceLogin();
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
                if (SapiWebView.this.f10408c != null) {
                    SapiWebView.this.f10408c.onConsoleMessage(str, i2, str2);
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
                if (SapiWebView.this.f10408c != null && SapiWebView.this.f10408c.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.f10408c.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.i(Log.TAG, "webview", str2);
                final String[] strArr = {""};
                SapiWebView.this.i.P = jsPromptResult;
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if (SapiWebView.this.j.contains(actionName)) {
                                SapiWebView.this.i.P = jsPromptResult;
                            }
                            SapiJsInterpreters.AbstractInterpreter a2 = SapiWebView.this.f10413h.a(actionName);
                            if (a2 != null) {
                                try {
                                    strArr[0] = a2.interpret(parse);
                                } catch (Throwable th) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("errno", 0);
                                        jSONObject.put("msg", "native function error");
                                        strArr[0] = jSONObject.toString();
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
                            if (parse.getActionParams().size() <= 2 || !SapiWebView.C.equals(parse.getActionParams().get(2))) {
                                if (SapiWebView.this.j.contains(actionName)) {
                                    return;
                                }
                                jsPromptResult.confirm(strArr[0]);
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

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.n != null) {
                    if (i2 == 100) {
                        SapiWebView.this.n.setVisibility(8);
                    } else {
                        if (SapiWebView.this.n.getVisibility() == 8) {
                            SapiWebView.this.n.setVisibility(0);
                        }
                        SapiWebView.this.n.setProgress(i2);
                    }
                }
                super.onProgressChanged(webView, i2);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(5)
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(j * 2);
            }
        });
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        k kVar = statLoadLogin;
        if (kVar != null) {
            kVar.f11107b = System.currentTimeMillis();
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
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add("sapi_action_pick_image");
        this.j.add("sapi_action_pick_date");
        this.j.add("sapi_action_third_safety_verification");
        this.j.add("sapi_biometrics_identification");
        this.j.add("sapi_biometrics_identification_no_bduss");
        this.j.add("sapi_biometrics_identification_with_authtoken");
        this.j.add("sapi_biometrics_identification_with_uid");
        this.j.add("sapi_action_sc_app_invoke");
        this.j.add("oauth_sso_hash");
        this.j.add("sapi_action_china_mobile_oauth");
        this.j.add("address_manage_get_contact");
        this.j.add("touchid_open_guide");
        this.j.add("touchid_change_status");
        this.j.add("touchid_login");
        this.j.add("speech_recognition_get_content");
        this.j.add("sapi_onekey_oauth_token");
        this.j.add("sapi_biometrics_identification_live");
    }

    public void finish(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.r) {
                    return;
                }
                SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                if (TextUtils.isEmpty(str)) {
                    if (SapiWebView.this.v != null) {
                        SapiWebView.this.v.onFinish();
                    }
                } else if (SapiWebView.this.i.G != null) {
                    SapiWebView.this.i.G.onFinish(str);
                }
            }
        });
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.a(getContext(), str);
        String a2 = a(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.i.j != null && this.f10406a.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.i.f10243e != null && this.f10406a.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(a(a2, list));
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(h.a(h.l) + "?" + H + "=" + I, "UTF-8")));
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

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    private String c(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    private void d(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.r) {
                    return;
                }
                String b2 = SapiWebView.this.b(str);
                SapiWebView.this.a(b2, false);
                SapiWebView.super.loadUrl(b2);
            }
        });
        if (SapiUtils.hasActiveNetwork(getContext()) || str.startsWith("javascript:")) {
            return;
        }
        g();
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
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + " " + getUaInfo());
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        setScrollBarStyle(0);
        settings.setSaveFormData(false);
        SapiConfiguration sapiConfiguration = this.f10406a;
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
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void loadLogin(int i, List<PassNameValuePair> list) {
        if (this.f10406a.supportFaceLogin && this.i.f10243e == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        k kVar = statLoadLogin;
        if (kVar != null) {
            kVar.f11108c = System.currentTimeMillis();
        }
        this.extras = list;
        if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
            b(i, list);
        } else if (4 == i) {
            c(list);
        } else if (i == 6) {
            a(i);
        } else {
            boolean z = com.baidu.sapi2.share.d.a(this.f10406a) && this.shareV2Disable;
            this.shareV2Disable = z;
            if (this.i.s != null && !z) {
                list.add(new PassNameValuePair(a.c.f10940h, "2"));
                c(i, list);
            } else if (this.f10411f) {
                b(list);
            } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
                a(i, list);
            } else {
                b(i, list);
            }
        }
        SapiStatUtil.statLoadLogin(null);
    }

    private void b(List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        if (this.i.i != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        loadUrl((a2 + "&liveAbility=1") + W);
    }

    private void c(List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        if (this.i.i != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        if (this.f10406a.supportFaceLogin) {
            a2 = a2 + "&liveAbility=1";
        }
        loadUrl(a2 + O);
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        String str2;
        e(str);
        if (TextUtils.isEmpty(str) || str.contains("javascript:")) {
            str2 = null;
        } else {
            a(list);
            str2 = this.q.b(getContext(), str);
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
            String a2 = a(str3, str);
            loadDataWithBaseURL(a2, str3, K, "UTF-8", a2);
            return;
        }
        d(str);
    }

    public List<PassNameValuePair> d() {
        String diCookieInfo;
        List<String> loginCookieDiKeys = SapiContext.getInstance().getSapiOptions().getLoginCookieDiKeys();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.f10406a.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        arrayList.add(new PassNameValuePair(this.f10406a.environment.getWap(), SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo != null ? diCookieInfo : "")));
        return arrayList;
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 extends WebViewClient {
        public AnonymousClass2() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0159, code lost:
            if (r10.contains(r4.getHost() + r4.getPath()) != false) goto L37;
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            }
            if (SapiWebView.this.k != null) {
                SapiWebView.this.k.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.l != null && SapiWebView.this.l.getVisibility() != 4) {
                SapiWebView.this.l.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.g0);
            if (SapiWebView.this.i.f10241c != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            if (SapiWebView.this.A && !TextUtils.isEmpty(SapiWebView.this.B)) {
                SapiWebView sapiWebView = SapiWebView.this;
                SapiWebView.super.loadUrl(String.format(SapiWebView.h0, sapiWebView.B));
                SapiWebView.this.A = false;
                SapiWebView.this.B = null;
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().i());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().j());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.y = true;
            } else {
                SapiWebView.this.y = false;
            }
            if (!str.contains(parse.getHost() + parse.getPath())) {
                if (!str.contains(parse2.getHost() + parse2.getPath())) {
                }
            }
            if (!"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.t.removeCallbacks(SapiWebView.this.u);
            if (SapiWebView.this.f10407b != null) {
                SapiWebView.this.f10407b.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Uri parse;
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.i.I != null) {
                Uri parse2 = Uri.parse(SapiWebView.this.getLoginUrl());
                if (Uri.parse(str) != null) {
                    if ((parse.getHost() + parse.getPath()).equals(parse2.getHost() + parse2.getPath())) {
                        SapiWebView.this.i.I.pageState(1);
                    }
                }
                SapiWebView.this.i.I.pageState(2);
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.g();
            }
            SapiWebView.this.u.setUrl(str);
            SapiWebView.this.t.postDelayed(SapiWebView.this.u, SapiWebView.this.s);
            SapiWebView.this.f();
            if (str != null) {
                if (str.contains(SapiWebView.I) || str.contains(SapiWebView.J)) {
                    String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.H);
                    if (SapiWebView.I.equals(queryParameter) && SapiWebView.this.f10409d != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.f10409d != null) {
                                    SapiWebView.this.f10409d.onSuccess();
                                }
                            }
                        });
                    }
                    if (SapiWebView.J.equals(queryParameter) && SapiWebView.this.f10409d != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.f10409d != null) {
                                        SapiWebView.this.f10409d.onSuccess();
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
                                        if (SapiWebView.this.f10409d != null) {
                                            SapiWebView.this.f10409d.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.f10409d != null) {
                                            SapiWebView.this.f10409d.onSuccess();
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
                                        if (SapiWebView.this.f10409d != null) {
                                            SapiWebView.this.f10409d.onSuccess();
                                        }
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.G.equals(Uri.parse(str).getQueryParameter(SapiWebView.H))) {
                    if (SapiWebView.this.i.T == null) {
                        if (SapiWebView.this.i.H != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.i.H != null) {
                                        SapiWebView.this.i.H.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                        }
                    } else {
                        SapiWebView sapiWebView = SapiWebView.this;
                        sapiWebView.a(sapiWebView.i.T);
                    }
                }
            }
            if (SapiWebView.this.f10407b != null) {
                SapiWebView.this.f10407b.onPageStarted(webView, str, bitmap);
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
            StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
            if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                sslErrorHandler.cancel();
                if (!(!SapiWebView.this.f10406a.forbidSslErrorDialog)) {
                    if (SapiWebView.this.p == null) {
                        if (Build.VERSION.SDK_INT > 17) {
                            str2 = new SimpleDateFormat(SapiWebView.c0).format(new Date(System.currentTimeMillis()));
                            str = SapiWebView.a0;
                        } else {
                            str = SapiWebView.b0;
                            str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                        builder.setTitle(str);
                        builder.setMessage(str2);
                        builder.setPositiveButton(SapiWebView.f0, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                                SapiWebView.this.getContext().startActivity(intent);
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_setting", null);
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_cancel", null);
                            }
                        });
                        SapiWebView.this.p = builder.create();
                    }
                    if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.p.isShowing()) {
                        SapiWebView.this.p.show();
                    }
                } else {
                    sslErrorHandler.proceed();
                }
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (webResourceRequest.getUrl().toString().contains(SapiWebView.D)) {
                        String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str)) {
                            return new WebResourceResponse("text/css", "utf-8", com.baidu.sapi2.utils.e.a(SapiWebView.this.getContext(), str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null) {
                if (!str.startsWith("sms") && !str.startsWith("tel") && !str.startsWith("bdscenter")) {
                    if (str.startsWith("wtloginmqq")) {
                        return true;
                    }
                    if (h.a(h.m).equals(str)) {
                        SapiWebView.this.finish();
                    }
                    if (SapiWebView.this.i.Y != null && SapiWebView.this.i.Y.redirectUrl != null && str.contains(SapiWebView.this.i.Y.redirectUrl)) {
                        SapiWebView.this.i.Y.callback.onCallback(str);
                        return true;
                    }
                } else {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        SapiWebView.this.getContext().startActivity(intent);
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                    return true;
                }
            }
            if (SapiWebView.this.f10407b != null) {
                SapiWebView.this.f10407b.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    if (str.contains(SapiWebView.D)) {
                        String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str2)) {
                            return new WebResourceResponse("text/css", "utf-8", com.baidu.sapi2.utils.e.a(SapiWebView.this.getContext(), str2));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    private void a(int i) {
        String str = a(getLoginUrl(), this.extras) + "&loginInitType=" + i;
        if (this.i.i != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.f10406a.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + N);
    }

    private void b(int i, List<PassNameValuePair> list) {
        String str = a(getLoginUrl(), list) + "&loginInitType=" + i;
        if (i == 0) {
            if (this.i.i != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.f10406a.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            loadUrl(str + M);
        } else if (i != 1) {
            loadUrl(str + M);
        } else {
            if (this.i.i != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.f10406a.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            loadUrl(str + S);
        }
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.f10412g = new ReloadConfig();
        this.t = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.u = new TimeoutTask();
        this.z = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    private void c(int i, List<PassNameValuePair> list) {
        String str;
        String loginUrl = getLoginUrl();
        if (this.i.i != null) {
            loginUrl = loginUrl + "&enableExternalWeb=1";
        }
        if (this.f10406a.supportFaceLogin) {
            loginUrl = loginUrl + "&liveAbility=1";
        }
        if (this.f10411f && this.i.f10243e != null) {
            str = loginUrl + "&loginInitType=4";
        } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
            str = loginUrl + "&loginInitType=5";
        } else {
            str = loginUrl + "&loginInitType=" + i;
        }
        loadUrl(a(str, list) + R);
    }

    private void a(int i, List<PassNameValuePair> list) {
        String str = a(getLoginUrl(), list) + "&loginInitType=" + i;
        if (this.i.i != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.f10406a.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + U);
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.f10412g = new ReloadConfig();
        this.t = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.h();
                }
            }
        };
        this.u = new TimeoutTask();
        this.z = 1;
        this.touchidPortraitAndSign = new String[2];
        i();
    }

    public List<PassNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.f10406a.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = this.f10406a.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        SapiConfiguration sapiConfiguration = this.f10406a;
        if (sapiConfiguration.isDarkMode) {
            arrayList.add(new PassNameValuePair(sapiConfiguration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, SkinManager.SKIN_TYPE_STR_DARK)));
            arrayList.add(new PassNameValuePair(this.f10406a.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, SkinManager.SKIN_TYPE_STR_DARK)));
        } else {
            arrayList.add(new PassNameValuePair(sapiConfiguration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, "light")));
            arrayList.add(new PassNameValuePair(this.f10406a.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, "light")));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        boolean z;
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

    private void e(String str) {
        if (statLoadLogin == null) {
            return;
        }
        if (str.contains(M) || str.contains(R) || str.contains(O) || str.contains(T) || str.contains(S) || (this.f10411f && str.contains(W))) {
            statLoadLogin.f11109d = System.currentTimeMillis();
        }
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
            if (arrayList.isEmpty()) {
                return str;
            }
            return str + "&" + SapiUtils.createRequestParams(arrayList);
        }
        return str;
    }

    public static SocialResponse b(String str, Context context) {
        Exception e2;
        SocialResponse socialResponse;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        SocialResponse socialResponse2 = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase("data")) {
                        if (socialResponse2 == null && name.equalsIgnoreCase("error_code")) {
                            socialResponse = new SocialResponse();
                            try {
                                socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            } catch (Exception e3) {
                                e2 = e3;
                                socialResponse2 = socialResponse;
                                Log.e(e2);
                                return socialResponse2;
                            }
                        } else if (socialResponse2 == null && name.equalsIgnoreCase("error_description")) {
                            socialResponse = new SocialResponse();
                            socialResponse.errorMsg = newPullParser.nextText();
                        } else if (socialResponse2 != null) {
                            if (name.equalsIgnoreCase("error_code")) {
                                socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("error_description")) {
                                socialResponse2.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("is_binded")) {
                                socialResponse2.isBinded = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("display_name")) {
                                socialResponse2.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("passport_uname")) {
                                socialResponse2.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduid")) {
                                socialResponse2.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                socialResponse2.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.f10190h)) {
                                socialResponse2.ptoken = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_username")) {
                                socialResponse2.socialUname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                socialResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_type")) {
                                socialResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("notice_offline")) {
                                socialResponse2.offlineNotice = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("guidebind")) {
                                socialResponse2.bindGuide = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("bind_conflict")) {
                                socialResponse2.bindConflict = "1".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("wapsec")) {
                                socialResponse2.accountCenterFlag = "center".equals(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("next_url_related")) {
                                String nextText = newPullParser.nextText();
                                if (socialResponse2.accountCenterFlag) {
                                    socialResponse2.nextUrl = nextText;
                                }
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    socialResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    socialResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    socialResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("stoken")) {
                                String[] split = newPullParser.nextText().split("#");
                                socialResponse2.tplStokenMap.put(split[0], split[1]);
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                socialResponse2.actionType = newPullParser.nextText();
                            } else if (name.equals("livinguname")) {
                                socialResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (name.equals("guest_account")) {
                                socialResponse2.isGuestAccount = newPullParser.nextText();
                            }
                        }
                        socialResponse2 = socialResponse;
                    } else if (socialResponse2 == null) {
                        socialResponse = new SocialResponse();
                        socialResponse2 = socialResponse;
                    }
                }
                try {
                } catch (Exception e4) {
                    e2 = e4;
                    socialResponse = socialResponse2;
                    socialResponse2 = socialResponse;
                    Log.e(e2);
                    return socialResponse2;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
        }
        return socialResponse2;
    }

    public void a(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (statLoadLogin == null) {
            return;
        }
        if (str.contains(M) || str.contains(R) || str.contains(O) || str.contains(T) || str.contains(S) || (this.f10411f && str.contains(W))) {
            statLoadLogin.f11110e = System.currentTimeMillis();
            statLoadLogin.f11111f = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SapiAccountResponse a(String str, Context context) {
        Throwable th;
        SapiAccountResponse sapiAccountResponse;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
            boolean z = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase("data")) {
                        if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_code")) {
                            sapiAccountResponse = new SapiAccountResponse();
                            try {
                                sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            } catch (Throwable th2) {
                                th = th2;
                                sapiAccountResponse2 = sapiAccountResponse;
                                Log.e(th);
                                if (sapiAccountResponse2 != null) {
                                    sapiAccountResponse2.errorCode = 0;
                                }
                                return sapiAccountResponse2;
                            }
                        } else if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_description")) {
                            sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse.errorMsg = newPullParser.nextText();
                        } else if (sapiAccountResponse2 != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("uname")) {
                                sapiAccountResponse2.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                sapiAccountResponse2.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.f10190h)) {
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
                            } else if (name.equalsIgnoreCase("displayname")) {
                                sapiAccountResponse2.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("uid")) {
                                sapiAccountResponse2.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("authsid")) {
                                String nextText = newPullParser.nextText();
                                sapiAccountResponse2.authSid = nextText;
                                sapiAccountResponse2.newReg = !TextUtils.isEmpty(nextText);
                            } else if (name.equalsIgnoreCase("stoken_list")) {
                                z = true;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_type")) {
                                sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                sapiAccountResponse2.actionType = newPullParser.nextText();
                            } else if (name.equals("livinguname")) {
                                sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                                String nextText3 = newPullParser.nextText();
                                if ("oneKeyLogin".equals(nextText3)) {
                                    nextText3 = new OneKeyLoginSdkCall().getOperatorType();
                                }
                                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText3);
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
                        sapiAccountResponse2 = sapiAccountResponse;
                    } else if (sapiAccountResponse2 == null) {
                        sapiAccountResponse = new SapiAccountResponse();
                        sapiAccountResponse2 = sapiAccountResponse;
                    }
                }
                try {
                } catch (Throwable th3) {
                    th = th3;
                    sapiAccountResponse = sapiAccountResponse2;
                    sapiAccountResponse2 = sapiAccountResponse;
                    Log.e(th);
                    if (sapiAccountResponse2 != null) {
                    }
                    return sapiAccountResponse2;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }

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
        sapiAccount.putExtra("tpl", this.f10406a.tpl);
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

    public static String b(String str, String str2) {
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

    public void a(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse == null) {
            return;
        }
        final SapiAccount b2 = b(sapiAccountResponse);
        if (this.i.H != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SapiWebView.this.i.H.beforeSuccess(b2);
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                    SapiAccountManager.getInstance().validate(b2);
                    SapiWebView.this.a(sapiAccountResponse.accountType);
                    SapiStatUtil.statShareV1Login(b2, SapiWebView.this.extras);
                }
            });
        }
    }

    public void a(final SocialResponse socialResponse) {
        int i;
        if (socialResponse == null) {
            return;
        }
        final SapiAccount b2 = b(socialResponse);
        if (SapiAccount.isValidAccount(b2)) {
            socialResponse.errorCode = 0;
        }
        if (socialResponse.accountCenterFlag && ((i = socialResponse.errorCode) == 0 || i == 110000)) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.loadUrl(socialResponse.nextUrl);
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    SapiAccountManager.getInstance().validate(b2);
                    if (SapiWebView.this.f10410e == null || currentAccount.uid.equals(b2.uid)) {
                        return;
                    }
                    SapiWebView.this.f10410e.onAccountChange();
                }
            });
        } else if (this.i.H != null) {
            int i2 = socialResponse.errorCode;
            if (i2 != 0 && i2 != 110000) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.i.H != null) {
                            AuthorizationListener authorizationListener = SapiWebView.this.i.H;
                            SocialResponse socialResponse2 = socialResponse;
                            authorizationListener.onFailed(socialResponse2.errorCode, socialResponse2.errorMsg);
                        }
                        SapiWebView.this.i.T = null;
                    }
                });
            } else {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (SapiWebView.this.i.H != null) {
                                SapiWebView.this.i.H.beforeSuccess(b2);
                            }
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiAccountManager.getInstance().validate(b2);
                        SapiWebView.this.a(AccountType.UNKNOWN);
                        SapiWebView.this.i.T = null;
                    }
                });
            }
        }
    }

    public List<PassNameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        if (this.f10406a.supportFaceLogin) {
            SapiJsCallBacks.CallBacks callBacks = this.i;
            if (callBacks.f10242d != null && callBacks.f10243e != null) {
                arrayList.add(new PassNameValuePair("liveAbility", "1"));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (!TextUtils.isEmpty(this.i.O[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.i.O;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        AuthorizationListener authorizationListener = this.i.H;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.i.H.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.i.H.onSuccess();
        }
    }

    public String a(String str, String str2) {
        String[] split;
        if (str2.split("#").length > 1) {
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            String a2 = this.q.a(str2);
            String str3 = "";
            if (this.q.b(a2) != null) {
                String str4 = this.q.b(a2).f10398c;
                String md5 = SecurityUtil.md5(str.getBytes(), false);
                SapiOptions.a cache = sapiOptions.getCache();
                String b2 = cache != null ? cache.b() : "";
                if (str4.equals(md5)) {
                    if (!TextUtils.isEmpty(b2)) {
                        str3 = "&passAppVersion=" + b2;
                    }
                    str3 = str3 + "&passAppHash=" + this.q.b(a2).f10398c;
                } else {
                    str3 = "&passAppHash=" + SecurityUtil.md5(str.getBytes(), false);
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    public String a() {
        return SapiUtils.buildBDUSSCookie(this.f10406a.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    public void a(List<PassNameValuePair> list) {
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

    public String a(BindWidgetAction bindWidgetAction) {
        return SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction) + "&" + SapiUtils.createRequestParams(b());
    }

    public String a(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType) + "&" + SapiUtils.createRequestParams(b());
    }

    public String a(String str) {
        return SapiAccountManager.getInstance().getAccountService().a(str) + "&" + SapiUtils.createRequestParams(b());
    }
}
