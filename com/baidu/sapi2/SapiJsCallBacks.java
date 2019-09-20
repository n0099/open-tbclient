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
/* loaded from: classes.dex */
public class SapiJsCallBacks {

    /* loaded from: classes.dex */
    public interface AddressManageCallback {
        void onCallback(String str);
    }

    /* loaded from: classes.dex */
    public interface BdOauthCallback {
        void onCallback(String str);
    }

    /* loaded from: classes.dex */
    public static class BdOauthLoginParams {
        public BdOauthCallback callback;
        public String callingAppId;
        public String callingPkg;
        public String redirectUrl;
    }

    /* loaded from: classes.dex */
    public interface BuildCustomAlertDialog {
        AlertDialogInterface buildDialog(Activity activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CallBacks {
        RealNameStatusCallback A;
        LoginStatusChangeCallback B;
        AuthorizationListener C;
        PageStateCallback D;
        BuildCustomAlertDialog E;
        AddressManageCallback F;
        InvoiceBuildCallback G;
        FingerprintCallback H;
        Runnable J;
        JsPromptResult K;
        boolean M;
        String N;
        SocialResponse O;
        JoinLoginParams P;
        String Q;
        DirectedLoginParams R;
        boolean S;
        BdOauthLoginParams T;
        ShareV2LoginParams U;
        Handler a;
        SapiWebView.SmsHandler b;
        Handler c;
        SapiWebView.WebViewTitleCallback d;
        SapiWebView.BioScanFaceCallback e;
        SapiWebView.BiometricsIdentifyCallback f;
        SapiWebView.UniteVerifyCallback g;
        SapiWebView.QuickLoginHandler h;
        SapiWebView.BindWidgetCallback i;
        SapiWebView.LoadExternalWebViewCallback j;
        SapiWebView.PickPhotoCallback k;
        SapiWebView.BdussChangeCallback l;
        SapiWebView.SwitchAccountCallback m;
        SapiWebView.LeftBtnVisibleCallback n;
        SapiWebView.RealnameAuthenticateCallback o;
        SapiWebView.CoverWebBdussCallback p;
        SapiWebView.PreFillUserNameCallback q;
        SapiWebView.AccountDestoryCallback r;
        SapiWebView.AccountFreezeCallback s;
        SapiWebView.ShareAccountClickCallback t;
        SapiWebView.QrLoginCallback u;
        SapiWebView.SystemUpwardSmsCallback v;
        SapiWebView.InvokeScAppCallback w;
        SapiWebView.LocalConfigCallback x;
        NormalizeGuestAccountCallback y;
        WebviewPageFinishCallback z;
        String[] I = new String[2];
        int L = 1;
    }

    /* loaded from: classes.dex */
    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
        public String uid;
    }

    /* loaded from: classes.dex */
    public static abstract class FingerprintCallback {
        public abstract void onCallback(FingerprintResult fingerprintResult);
    }

    /* loaded from: classes.dex */
    public static abstract class FingerprintResult {
        public int authType;
        public String portrait;

        public abstract void setResult(int i);
    }

    /* loaded from: classes.dex */
    public interface InvoiceBuildCallback {
        void onCallback(String str);
    }

    /* loaded from: classes.dex */
    public static class JoinLoginParams {
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;
    }

    /* loaded from: classes.dex */
    public interface LoginStatusChangeCallback {
        void onChange();
    }

    /* loaded from: classes.dex */
    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i, String str);

        void onSuccess(boolean z, String str);
    }

    /* loaded from: classes.dex */
    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i);
    }

    /* loaded from: classes.dex */
    public interface RealNameStatusCallback {
        public static final int STATE_JUNIOR_REALNAME = 1;
        public static final int STATE_SENIOR_REALNAME = 2;

        void onFinish(AccountRealNameResult accountRealNameResult);
    }

    /* loaded from: classes.dex */
    public static abstract class ShareV2LoginParams {
        public JSONObject pageParams;

        public abstract void onError();

        public abstract void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }
}
