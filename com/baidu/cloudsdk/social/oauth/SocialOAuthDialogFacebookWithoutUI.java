package com.baidu.cloudsdk.social.oauth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SocialOAuthDialogFacebookWithoutUI extends Dialog implements View.OnClickListener {
    private static final String a = SocialOAuthDialogFacebookWithoutUI.class.getSimpleName();
    private static String b = "webview_timer_needresume";
    private String c;
    private IBaiduListener d;
    private final SocialConfig e;
    private ProgressDialog f;
    private WebView g;
    private int h;
    private int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends WebChromeClient {
        private a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            SocialOAuthDialogFacebookWithoutUI.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (Build.VERSION.SDK_INT >= 11 || !SocialOAuthDialogFacebookWithoutUI.this.a(str)) {
                super.onPageFinished(webView, str);
                if (SocialOAuthDialogFacebookWithoutUI.this.isShowing() && SocialOAuthDialogFacebookWithoutUI.this.f.isShowing()) {
                    SocialOAuthDialogFacebookWithoutUI.this.f.dismiss();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!SocialOAuthDialogFacebookWithoutUI.this.isShowing() || SocialOAuthDialogFacebookWithoutUI.this.f.isShowing()) {
                return;
            }
            SocialOAuthDialogFacebookWithoutUI.this.f.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            SocialOAuthDialogFacebookWithoutUI.this.dismiss();
            SocialOAuthDialogFacebookWithoutUI.this.d.onError(new BaiduException(str));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return Build.VERSION.SDK_INT >= 11 ? SocialOAuthDialogFacebookWithoutUI.this.a(str) : super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public SocialOAuthDialogFacebookWithoutUI(Context context, String str, IBaiduListener iBaiduListener) {
        super(context, 16973830);
        this.c = str;
        this.d = iBaiduListener;
        this.e = SocialConfig.getInstance(context);
        this.g = new WebView(context);
        this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.e.getInt(b) == 1) {
            if (com.baidu.cloudsdk.Build.DEBUG) {
                Log.d("SocialOAuthActivity", "resumeTimers");
            }
            this.g.resumeTimers();
        }
        setContentView(this.g);
        b();
    }

    private void a() {
        this.g.setVerticalScrollBarEnabled(true);
        this.g.getSettings().setJavaScriptEnabled(true);
        this.g.setWebChromeClient(new a());
        this.g.getSettings().setSavePassword(false);
        this.g.setWebViewClient(new b());
        this.g.loadUrl(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        int i;
        if (!str.startsWith(FacebookAuthHandler.REDIRECT_URI)) {
            if (str.startsWith("fbconnect://cancel")) {
                this.d.onCancel();
                return true;
            } else if (str.contains("touch")) {
                return false;
            } else {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }
        Bundle parseUrl = parseUrl(str);
        String string = parseUrl.getString("error");
        if (string == null) {
            string = parseUrl.getString("error_type");
        }
        String string2 = parseUrl.getString(SocialConstants.PARAM_ERROR_MSG);
        if (string2 == null) {
            string2 = parseUrl.getString("error_description");
        }
        String string3 = parseUrl.getString(SocialConstants.PARAM_ERROR_CODE);
        if (TextUtils.isEmpty(string3)) {
            i = -1;
        } else {
            try {
                i = Integer.parseInt(string3);
            } catch (NumberFormatException e) {
                i = -1;
            }
        }
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && i == -1) {
            Log.d(a, "values " + parseUrl.toString());
            String string4 = parseUrl.getString(SocialConstants.PARAM_ACCESS_TOKEN);
            String string5 = parseUrl.getString(SocialConstants.PARAM_EXPIRES_IN);
            Log.d(a, "accessToken = " + string4);
            Log.d(a, "expires = " + string5);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SocialConstants.PARAM_ACCESS_TOKEN, string4).put(SocialConstants.PARAM_EXPIRES_IN, string5).put(SocialConstants.PARAM_MEDIA_TYPE, "facebook");
            } catch (JSONException e2) {
            }
            this.d.onComplete(jSONObject);
        } else if (string == null || !(string.equals(SocialConstants.ERROR_ACCESS_DENIED) || string.equals("OAuthAccessDeniedException"))) {
            this.d.onError(new BaiduException(i, string2));
        } else {
            this.d.onCancel();
        }
        return true;
    }

    private void b() {
        this.f = new ProgressDialog(getContext());
        this.f.requestWindowFeature(1);
        this.f.setMessage(this.e.getString("loading"));
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return bundle;
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
            this.f = null;
        }
        if (this.g != null) {
            this.g.stopLoading();
            this.g.clearCache(true);
            if (this.e.getInt(b) == 1) {
                if (com.baidu.cloudsdk.Build.DEBUG) {
                    Log.d("SocialOAuthActivity", "pauseTimers");
                }
                this.g.pauseTimers();
            }
            this.g.removeAllViews();
            this.g.freeMemory();
            if (this.g.getParent() != null) {
                ((ViewGroup) this.g.getParent()).removeView(this.g);
            }
            this.g.destroy();
            this.g = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
        this.d.onCancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.h) {
            onBackPressed();
        } else if (view.getId() == this.i) {
            this.g.reload();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        int i = this.e.getInt("activity_brightness");
        if (i > 0) {
            Utils.setBrightness(this, i);
        }
    }
}
