package com.baidu.sapi2;

import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.SapiWebView;
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
        void getLiveImage(int i, PassFaceRecogCallback passFaceRecogCallback);
    }

    /* loaded from: classes2.dex */
    public static class CallBacks {
        public RealNameStatusCallback A;
        public LoginStatusChangeCallback B;
        public GrantWebCallback C;
        public CurrentAccountBdussExpiredCallback D;
        public StopSlideWebviewCallback E;
        public GetCurrentPageNameCallback F;
        public SapiWebView.OnSlidePageFinishCallback G;
        public AuthorizationListener H;
        public PageStateCallback I;
        public InvoiceBuildCallback J;
        public FingerprintCallback K;
        public SwitchStyleForCloseBtnAndStatusBarCallBack L;
        public FocusEdittextCoordinateYCallBack M;
        public BiometricsIdentificationLiveCallBack N;
        public JsPromptResult P;
        public boolean R;
        public String S;
        public SocialResponse T;
        public JoinLoginParams U;
        public String V;
        public DirectedLoginParams W;
        public boolean X;
        public BdOauthLoginParams Y;
        public ShareV2LoginParams Z;

        /* renamed from: a  reason: collision with root package name */
        public Handler f10239a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f10240b;

        /* renamed from: c  reason: collision with root package name */
        public SapiWebView.WebViewTitleCallback f10241c;

        /* renamed from: d  reason: collision with root package name */
        public SapiWebView.BioScanFaceCallback f10242d;

        /* renamed from: e  reason: collision with root package name */
        public SapiWebView.BiometricsIdentifyCallback f10243e;

        /* renamed from: f  reason: collision with root package name */
        public SapiWebView.UniteVerifyCallback f10244f;

        /* renamed from: g  reason: collision with root package name */
        public SapiWebView.QuickLoginHandler f10245g;

        /* renamed from: h  reason: collision with root package name */
        public SapiWebView.BindWidgetCallback f10246h;
        public SapiWebView.LoadExternalWebViewCallback i;
        public SapiWebView.PickPhotoCallback j;
        public SapiWebView.BdussChangeCallback k;
        public SapiWebView.SwitchAccountCallback l;
        public SapiWebView.LeftBtnVisibleCallback m;
        public SapiWebView.RealnameAuthenticateCallback n;
        public SapiWebView.CoverWebBdussCallback o;
        public SapiWebView.PreFillUserNameCallback p;
        public SapiWebView.AccountDestoryCallback q;
        public SapiWebView.AccountFreezeCallback r;
        public SapiWebView.ShareAccountClickCallback s;
        public SapiWebView.QrLoginCallback t;
        public SapiWebView.InvokeScAppCallback u;
        public SapiWebView.LocalConfigCallback v;
        public SapiWebView.LoadSlideWebViewCallback w;
        public SpeechRecognitionCallback x;
        public NormalizeGuestAccountCallback y;
        public WebviewPageFinishCallback z;
        public String[] O = new String[2];
        public int Q = 1;

        public JsPromptResult getPromptResult() {
            return this.P;
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

        public abstract void setResult(int i);
    }

    /* loaded from: classes2.dex */
    public static abstract class FocusEdittextCoordinateYCallBack {
        public abstract void onCallback(int i);
    }

    /* loaded from: classes2.dex */
    public interface GetCurrentPageNameCallback {
        void getCurrentPageName(String str);
    }

    /* loaded from: classes2.dex */
    public interface GrantWebCallback {
        public static final int backWap = 0;
        public static final int remainNa = 1;

        void onGrant(int i);
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
    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i, String str);

        void onSuccess(boolean z, String str);
    }

    /* loaded from: classes2.dex */
    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i);
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
        public void setSpeechData(int i, String str) {
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
