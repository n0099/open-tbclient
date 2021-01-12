package com.baidu.sapi2;

import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import java.util.LinkedHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SapiJsCallBacks {

    /* loaded from: classes3.dex */
    public interface AddressManageCallback {

        /* loaded from: classes3.dex */
        public static abstract class GetContactResult {
            public abstract void setGetContactResult(String str);
        }

        void onGetContact(GetContactResult getContactResult);

        void onSelectedAddress(String str);
    }

    /* loaded from: classes3.dex */
    public interface BdOauthCallback {
        void onCallback(String str);
    }

    /* loaded from: classes3.dex */
    public static class BdOauthLoginParams {
        public BdOauthCallback callback;
        public String callingAppId;
        public String callingPkg;
        public String redirectUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CallBacks {
        LoginStatusChangeCallback A;
        GrantWebCallback B;
        CurrentAccountBdussExpiredCallback C;
        StopSlideWebviewCallback D;
        GetCurrentPageNameCallback E;
        SapiWebView.OnSlidePageFinishCallback F;
        AuthorizationListener G;
        PageStateCallback H;
        AddressManageCallback I;
        InvoiceBuildCallback J;
        FingerprintCallback K;
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

        /* renamed from: a  reason: collision with root package name */
        Handler f4570a;

        /* renamed from: b  reason: collision with root package name */
        SapiWebView.WebViewTitleCallback f4571b;
        SapiWebView.BioScanFaceCallback c;
        SapiWebView.BiometricsIdentifyCallback d;
        SapiWebView.UniteVerifyCallback e;
        SapiWebView.QuickLoginHandler f;
        SapiWebView.BindWidgetCallback g;
        SapiWebView.LoadExternalWebViewCallback h;
        SapiWebView.PickPhotoCallback i;
        SapiWebView.BdussChangeCallback j;
        SapiWebView.SwitchAccountCallback k;
        SapiWebView.LeftBtnVisibleCallback l;
        SapiWebView.RealnameAuthenticateCallback m;
        SapiWebView.CoverWebBdussCallback n;
        SapiWebView.PreFillUserNameCallback o;
        SapiWebView.AccountDestoryCallback p;
        SapiWebView.AccountFreezeCallback q;
        SapiWebView.ShareAccountClickCallback r;
        SapiWebView.QrLoginCallback s;
        SapiWebView.InvokeScAppCallback t;
        SapiWebView.LocalConfigCallback u;
        SapiWebView.LoadSlideWebViewCallback v;
        SpeechRecognitionCallback w;
        NormalizeGuestAccountCallback x;
        WebviewPageFinishCallback y;
        RealNameStatusCallback z;
        String[] L = new String[2];
        int N = 1;
    }

    /* loaded from: classes3.dex */
    public interface CurrentAccountBdussExpiredCallback {
        void onBdussExpired();
    }

    /* loaded from: classes3.dex */
    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
        public String uid;
    }

    /* loaded from: classes3.dex */
    public static abstract class FingerprintCallback {
        public abstract void onCallback(FingerprintResult fingerprintResult);
    }

    /* loaded from: classes3.dex */
    public static abstract class FingerprintResult {
        public int authType;
        public String portrait;

        public abstract void setResult(int i);
    }

    /* loaded from: classes3.dex */
    public interface GetCurrentPageNameCallback {
        public static final String ADDRESS_EDIT_PAGE = "address_edit";
        public static final String ADDRESS_LIST_PAGE = "address_list";

        void getCurrentPageName(String str);
    }

    /* loaded from: classes3.dex */
    public interface GrantWebCallback {
        public static final int backWap = 0;
        public static final int remainNa = 1;

        void onGrant(int i);
    }

    /* loaded from: classes3.dex */
    public interface InvoiceBuildCallback {
        void onCallback(String str);
    }

    /* loaded from: classes3.dex */
    public static class JoinLoginParams {
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;
    }

    /* loaded from: classes3.dex */
    public interface LoginStatusChangeCallback {
        void onChange();
    }

    /* loaded from: classes3.dex */
    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i, String str);

        void onSuccess(boolean z, String str);
    }

    /* loaded from: classes3.dex */
    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i);
    }

    /* loaded from: classes3.dex */
    public interface RealNameStatusCallback {
        public static final int STATE_JUNIOR_REALNAME = 1;
        public static final int STATE_SENIOR_REALNAME = 2;

        void onFinish(AccountRealNameResult accountRealNameResult);
    }

    /* loaded from: classes3.dex */
    public static abstract class ShareV2LoginParams {
        public JSONObject pageParams;

        public abstract void onError();

        public abstract void onSuccess();
    }

    /* loaded from: classes3.dex */
    public interface SpeechRecognitionCallback {
        void onSpeechRecognition(SpeechRecognitionResult speechRecognitionResult);
    }

    /* loaded from: classes3.dex */
    public static abstract class SpeechRecognitionResult {
        public void setSpeechData(int i, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public interface StopSlideWebviewCallback {
        void onStopSlide(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }
}
