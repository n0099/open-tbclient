package com.baidu.sapi2;

import android.app.Activity;
import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import java.util.LinkedHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SapiJsCallBacks {

    /* loaded from: classes4.dex */
    public interface AddressManageCallback {
        void onCallback(String str);
    }

    /* loaded from: classes4.dex */
    public interface BdOauthCallback {
        void onCallback(String str);
    }

    /* loaded from: classes4.dex */
    public static class BdOauthLoginParams {
        public BdOauthCallback callback;
        public String callingAppId;
        public String callingPkg;
        public String redirectUrl;
    }

    /* loaded from: classes4.dex */
    public interface BuildCustomAlertDialog {
        AlertDialogInterface buildDialog(Activity activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class CallBacks {
        WebviewPageFinishCallback A;
        RealNameStatusCallback B;
        LoginStatusChangeCallback C;
        SapiWebView.OnSlidePageFinishCallback D;
        AuthorizationListener E;
        PageStateCallback F;
        BuildCustomAlertDialog G;
        AddressManageCallback H;
        InvoiceBuildCallback I;
        FingerprintCallback J;
        Runnable L;
        JsPromptResult M;
        boolean O;
        String P;
        SocialResponse Q;
        JoinLoginParams R;
        String S;
        DirectedLoginParams T;
        boolean U;
        BdOauthLoginParams V;
        ShareV2LoginParams W;
        Handler a;
        SapiWebView.SmsHandler b;
        SapiWebView.WebViewTitleCallback c;
        SapiWebView.BioScanFaceCallback d;
        SapiWebView.BiometricsIdentifyCallback e;
        SapiWebView.UniteVerifyCallback f;
        SapiWebView.QuickLoginHandler g;
        SapiWebView.BindWidgetCallback h;
        SapiWebView.LoadExternalWebViewCallback i;
        SapiWebView.PickPhotoCallback j;
        SapiWebView.BdussChangeCallback k;
        SapiWebView.SwitchAccountCallback l;
        SapiWebView.LeftBtnVisibleCallback m;
        SapiWebView.RealnameAuthenticateCallback n;
        SapiWebView.CoverWebBdussCallback o;
        SapiWebView.PreFillUserNameCallback p;
        SapiWebView.AccountDestoryCallback q;
        SapiWebView.AccountFreezeCallback r;
        SapiWebView.ShareAccountClickCallback s;
        SapiWebView.QrLoginCallback t;
        SapiWebView.SystemUpwardSmsCallback u;
        SapiWebView.InvokeScAppCallback v;
        SapiWebView.LocalConfigCallback w;
        SapiWebView.LoadSlideWebViewCallback x;
        SpeechRecognitionCallback y;
        NormalizeGuestAccountCallback z;
        String[] K = new String[2];
        int N = 1;
    }

    /* loaded from: classes4.dex */
    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
        public String uid;
    }

    /* loaded from: classes4.dex */
    public static abstract class FingerprintCallback {
        public abstract void onCallback(FingerprintResult fingerprintResult);
    }

    /* loaded from: classes4.dex */
    public static abstract class FingerprintResult {
        public int authType;
        public String portrait;

        public abstract void setResult(int i);
    }

    /* loaded from: classes4.dex */
    public interface InvoiceBuildCallback {
        void onCallback(String str);
    }

    /* loaded from: classes4.dex */
    public static class JoinLoginParams {
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;
    }

    /* loaded from: classes4.dex */
    public interface LoginStatusChangeCallback {
        void onChange();
    }

    /* loaded from: classes4.dex */
    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i, String str);

        void onSuccess(boolean z, String str);
    }

    /* loaded from: classes4.dex */
    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i);
    }

    /* loaded from: classes4.dex */
    public interface RealNameStatusCallback {
        public static final int STATE_JUNIOR_REALNAME = 1;
        public static final int STATE_SENIOR_REALNAME = 2;

        void onFinish(AccountRealNameResult accountRealNameResult);
    }

    /* loaded from: classes4.dex */
    public static abstract class ShareV2LoginParams {
        public JSONObject pageParams;

        public abstract void onError();

        public abstract void onSuccess();
    }

    /* loaded from: classes4.dex */
    public interface SpeechRecognitionCallback {
        void onSpeechRecognition(SpeechRecognitionResult speechRecognitionResult);
    }

    /* loaded from: classes4.dex */
    public static abstract class SpeechRecognitionResult {
        public void setSpeechData(int i, String str) {
        }
    }

    /* loaded from: classes4.dex */
    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }
}
