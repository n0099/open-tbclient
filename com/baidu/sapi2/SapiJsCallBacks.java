package com.baidu.sapi2;

import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class SapiJsCallBacks {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CallBacks {
        SapiWebView.LocalConfigCallback A;
        PageStateCallback B;
        NormalizeGuestAccountCallback C;
        WebviewPageFinishCallback D;
        RealNameStatusCallback E;
        LoginStatusChangeCallback F;
        AuthorizationListener G;
        Runnable H;
        JsPromptResult I;
        int J = 1;
        boolean K = false;
        boolean L;
        String M;
        SocialResponse N;
        SapiAccountResponse O;
        SapiWebView.FastRegAction P;
        JoinLoginParams Q;
        DirectedLoginParams R;
        Handler a;
        SapiWebView.NMLoginHandler b;
        SapiWebView.UniteVerifyHandler c;
        SapiWebView.FastRegHandler d;
        SapiWebView.SmsHandler e;
        Handler f;
        SapiWebView.WebViewTitleCallback g;
        SapiWebView.BioScanFaceCallback h;
        SapiWebView.BiometricsIdentifyCallback i;
        SapiWebView.UniteVerifyCallback j;
        SapiWebView.QuickLoginHandler k;
        SapiWebView.BindWidgetCallback l;
        SapiWebView.LoadExternalWebViewCallback m;
        SapiWebView.PickPhotoCallback n;
        SapiWebView.BdussChangeCallback o;
        SapiWebView.SwitchAccountCallback p;
        SapiWebView.LeftBtnVisibleCallback q;
        SapiWebView.RealnameAuthenticateCallback r;
        SapiWebView.CoverWebBdussCallback s;
        SapiWebView.PreFillUserNameCallback t;
        SapiWebView.AccountDestoryCallback u;
        SapiWebView.AccountFreezeCallback v;
        SapiWebView.ShareAccountClickCallback w;
        SapiWebView.QrLoginCallback x;
        SapiWebView.SystemUpwardSmsCallback y;
        SapiWebView.InvokeScAppCallback z;
    }

    /* loaded from: classes.dex */
    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
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

        void onSuccess(boolean z);
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

        void onFinish(int i);
    }

    /* loaded from: classes.dex */
    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }
}
