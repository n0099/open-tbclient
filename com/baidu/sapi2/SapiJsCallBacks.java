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
        PageStateCallback A;
        NormalizeGuestAccountCallback B;
        AuthorizationListener C;
        Runnable D;
        JsPromptResult E;
        int F = 1;
        boolean G = false;
        boolean H;
        String I;
        SocialResponse J;
        SapiAccountResponse K;
        SapiWebView.FastRegAction L;
        JoinLoginParams M;
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
        SapiWebView.ShareAccountClickCallback v;
        SapiWebView.QrLoginCallback w;
        SapiWebView.SystemUpwardSmsCallback x;
        SapiWebView.InvokeScAppCallback y;
        SapiWebView.LocalConfigCallback z;
    }

    /* loaded from: classes.dex */
    public static class JoinLoginParams {
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;
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
}
