package com.baidu.sapi2;

import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import java.util.LinkedHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SapiJsCallBacks {

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CallBacks {
        WebviewPageFinishCallback A;
        RealNameStatusCallback B;
        LoginStatusChangeCallback C;
        AuthorizationListener D;
        PageStateCallback E;
        Runnable F;
        JsPromptResult G;
        int H = 1;
        boolean I = false;
        boolean J;
        String K;
        SocialResponse L;
        SapiAccountResponse M;
        SapiWebView.FastRegAction N;
        JoinLoginParams O;
        String P;
        DirectedLoginParams Q;
        boolean R;
        BdOauthLoginParams S;
        ShareV2LoginParams T;
        Handler a;
        SapiWebView.FastRegHandler b;
        SapiWebView.SmsHandler c;
        Handler d;
        SapiWebView.WebViewTitleCallback e;
        SapiWebView.BioScanFaceCallback f;
        SapiWebView.BiometricsIdentifyCallback g;
        SapiWebView.UniteVerifyCallback h;
        SapiWebView.QuickLoginHandler i;
        SapiWebView.BindWidgetCallback j;
        SapiWebView.LoadExternalWebViewCallback k;
        SapiWebView.PickPhotoCallback l;
        SapiWebView.BdussChangeCallback m;
        SapiWebView.SwitchAccountCallback n;
        SapiWebView.LeftBtnVisibleCallback o;
        SapiWebView.RealnameAuthenticateCallback p;
        SapiWebView.CoverWebBdussCallback q;
        SapiWebView.PreFillUserNameCallback r;
        SapiWebView.AccountDestoryCallback s;
        SapiWebView.AccountFreezeCallback t;
        SapiWebView.ShareAccountClickCallback u;
        SapiWebView.QrLoginCallback v;
        SapiWebView.SystemUpwardSmsCallback w;
        SapiWebView.InvokeScAppCallback x;
        SapiWebView.LocalConfigCallback y;
        NormalizeGuestAccountCallback z;
    }

    /* loaded from: classes.dex */
    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
        public String uid;
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
