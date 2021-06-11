package com.baidu.sapi2;

import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import java.util.LinkedHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiJsCallBacks {

    /* loaded from: classes2.dex */
    public interface BdOauthCallback {
        void onCallback(String str);
    }

    /* loaded from: classes2.dex */
    public static class BdOauthLoginParams {
        public BdOauthCallback callback;
        public String callingAppId;
        public String callingPkg;
        public String redirectUrl;
    }

    /* loaded from: classes2.dex */
    public interface BiometricsIdentificationLiveCallBack {
        void getLiveImage(int i2, PassFaceRecogCallback passFaceRecogCallback);
    }

    /* loaded from: classes2.dex */
    public static class CallBacks {
        public SapiWebView.AccountDestoryCallback accountDestoryCallback;
        public SapiWebView.AccountFreezeCallback accountFreezeCallback;
        public AuthorizationListener authorizationListener;
        public BdOauthLoginParams bdOauthLoginParams;
        public SapiWebView.BdussChangeCallback bdussChangeCallback;
        public SapiWebView.BindWidgetCallback bindWidgetCallback;
        public SapiWebView.BioScanFaceCallback bioScanFaceCallback;
        public BiometricsIdentificationLiveCallBack biometricsIdentificationLiveCallBack;
        public SapiWebView.BiometricsIdentifyCallback biometricsIdentifyCallback;
        public SapiWebView.CoverWebBdussCallback coverWebBdussCallback;
        public CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback;
        public DirectedLoginParams directedLoginParams;
        public FingerprintCallback fingerprintCallback;
        public boolean finishPage;
        public FocusEdittextCoordinateYCallBack focusEdittextCoordinateYCallBack;
        public GetCurrentPageNameCallback getCurrentPageNameCallback;
        public GrantWebCallback grantWebCallback;
        public boolean hideSuccessTip;
        public IdcardOcrImageCallBack idcardOcrImageCallBack;
        public InvoiceBuildCallback invoiceBuildCallback;
        public SapiWebView.InvokeScAppCallback invokeScAppCallback;
        public JoinLoginParams joinLoginParams;
        public SapiWebView.LeftBtnVisibleCallback leftBtnVisibleCallback;
        public SapiWebView.LoadExternalWebViewCallback loadExternalWebViewCallback;
        public SapiWebView.LoadSlideWebViewCallback loadSlideWebViewCallback;
        public SapiWebView.LocalConfigCallback localConfigCallback;
        public LoginStatusChangeCallback loginStatusChangeCallback;
        public SwitchStyleForCloseBtnAndStatusBarCallBack mSwitchStyleForCloseBtnAndStatusBarCallBack;
        public MakeVibrateCallBack makeVibrateCallBack;
        public NormalizeGuestAccountCallback normalizeGuestAccountCallback;
        public String normalizeGuestAccountDesc;
        public SapiWebView.OnSlidePageFinishCallback onSlidePageFinishCallback;
        public PageStateCallback pageStateCallback;
        public SapiWebView.PickPhotoCallback pickPhotoCallback;
        public SapiWebView.PreFillUserNameCallback prefillUserNameCallback;
        public JsPromptResult promptResult;
        public SapiWebView.QrLoginCallback qrLoginCallback;
        public SapiWebView.QuickLoginHandler quickLoginHandler;
        public RealNameStatusCallback realNameStatusCallback;
        public SapiWebView.RealnameAuthenticateCallback realnameAuthenticateCallback;
        public SocialResponse rrLoginResponse;
        public SapiWebView.ShareAccountClickCallback shareAccountClickCallback;
        public ShareV2LoginParams shareV2LoginParams;
        public Handler socialLoginHandler;
        public Handler socialVerificationHandler;
        public SpeechRecognitionCallback speechRecognitionCallback;
        public StopSlideWebviewCallback stopSlideWebviewCallback;
        public SapiWebView.SwitchAccountCallback switchAccountCallback;
        public SapiWebView.UniteVerifyCallback uniteVerifyCallback;
        public SapiWebView.WebViewTitleCallback webViewTitleCallback;
        public WebviewPageFinishCallback webviewPageFinishCallback;
        public String weixinBindUrl;
        public String[] touchidPortraitAndSign = new String[2];
        public int leftBtnIsVisible = 1;

        public JsPromptResult getPromptResult() {
            return this.promptResult;
        }
    }

    /* loaded from: classes2.dex */
    public interface CurrentAccountBdussExpiredCallback {
        void onBdussExpired();
    }

    /* loaded from: classes2.dex */
    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
        public String uid;
    }

    /* loaded from: classes2.dex */
    public static abstract class FingerprintCallback {
        public abstract void onCallback(FingerprintResult fingerprintResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class FingerprintResult {
        public int authType;
        public String portrait;

        public abstract void setResult(int i2);
    }

    /* loaded from: classes2.dex */
    public static abstract class FocusEdittextCoordinateYCallBack {
        public abstract void onCallback(int i2);
    }

    /* loaded from: classes2.dex */
    public interface GetCurrentPageNameCallback {
        void getCurrentPageName(String str);
    }

    /* loaded from: classes2.dex */
    public interface GrantWebCallback {
        public static final int backWap = 0;
        public static final int remainNa = 1;

        void onGrant(int i2);
    }

    /* loaded from: classes2.dex */
    public interface IdcardOcrImageCallBack {
        void getIdcardImage(String str, String str2, IdcardOcrImageCallback idcardOcrImageCallback);
    }

    /* loaded from: classes2.dex */
    public interface InvoiceBuildCallback {
        void onCallback(String str);
    }

    /* loaded from: classes2.dex */
    public static class JoinLoginParams {
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;
    }

    /* loaded from: classes2.dex */
    public interface LoginStatusChangeCallback {
        void onChange();
    }

    /* loaded from: classes2.dex */
    public interface MakeVibrateCallBack {
        void presetVibrate();

        void vibrate(long[] jArr, int i2);
    }

    /* loaded from: classes2.dex */
    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i2, String str);

        void onSuccess(boolean z, String str);
    }

    /* loaded from: classes2.dex */
    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i2);
    }

    /* loaded from: classes2.dex */
    public interface RealNameStatusCallback {
        public static final int STATE_JUNIOR_REALNAME = 1;
        public static final int STATE_SENIOR_REALNAME = 2;

        void onFinish(AccountRealNameResult accountRealNameResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class ShareV2LoginParams {
        public JSONObject pageParams;

        public abstract void onError();

        public abstract void onSuccess();
    }

    /* loaded from: classes2.dex */
    public interface SpeechRecognitionCallback {
        void onSpeechRecognition(SpeechRecognitionResult speechRecognitionResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class SpeechRecognitionResult {
        public void setSpeechData(int i2, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public interface StopSlideWebviewCallback {
        void onStopSlide(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface SwitchStyleForCloseBtnAndStatusBarCallBack {
        public static final String mBlack = "0";
        public static final String mWhite = "1";

        void switchStyle(String str);
    }

    /* loaded from: classes2.dex */
    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }
}
