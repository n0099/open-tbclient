package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.p;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SocialOAuthDialog extends Dialog implements View.OnClickListener {
    private static final String a = SocialOAuthDialog.class.getSimpleName();
    private static String b = "webview_timer_needresume";
    private String c;
    private String d;
    private IBaiduListener e;
    private final SocialConfig f;
    private ProgressDialog g;
    private WebView h;
    private int i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends WebChromeClient {
        private a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            SocialOAuthDialog.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (Build.VERSION.SDK_INT >= 11 || !SocialOAuthDialog.this.a(str)) {
                super.onPageFinished(webView, str);
                if (SocialOAuthDialog.this.isShowing() && SocialOAuthDialog.this.g.isShowing()) {
                    SocialOAuthDialog.this.g.dismiss();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!SocialOAuthDialog.this.isShowing() || SocialOAuthDialog.this.g.isShowing()) {
                return;
            }
            SocialOAuthDialog.this.g.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            SocialOAuthDialog.this.dismiss();
            SocialOAuthDialog.this.e.onError(new BaiduException(str));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return Build.VERSION.SDK_INT >= 11 ? SocialOAuthDialog.this.a(str) : super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public SocialOAuthDialog(Context context, String str, String str2, IBaiduListener iBaiduListener) {
        super(context, 16973830);
        this.c = str;
        this.d = str2;
        this.e = iBaiduListener;
        this.f = SocialConfig.getInstance(context);
        setContentView(p.a(getContext(), "bdsocialshare_socialoauthdialoglayout"));
        this.h = new WebView(context);
        ((LinearLayout) findViewById(p.d(getContext(), "socialoauthdialog_rootlayout"))).addView(this.h, new ViewGroup.LayoutParams(-1, -1));
        if (this.f.getInt(b) == 1) {
            if (com.baidu.cloudsdk.Build.DEBUG) {
                Log.d("SocialOAuthActivity", "resumeTimers");
            }
            this.h.resumeTimers();
        }
        b();
        a(context);
    }

    private void a() {
        this.h.setVerticalScrollBarEnabled(true);
        this.h.getSettings().setJavaScriptEnabled(true);
        this.h.setWebChromeClient(new a());
        this.h.getSettings().setSavePassword(false);
        this.h.setWebViewClient(new b());
        this.h.loadUrl(this.c);
    }

    private void a(Context context) {
        this.i = p.d(getContext(), "socialoauthdialog_button_back");
        this.j = p.d(getContext(), "socialoauthdialog_button_refresh");
        ((RelativeLayout) findViewById(p.d(getContext(), "socialoauthdialog_titlebar"))).setBackgroundResource(p.b(getContext(), "bdsocialshare_titlebar_bg"));
        int b2 = p.b(getContext(), "bdsocialshare_sharedialog_button");
        Button button = (Button) findViewById(this.i);
        button.setText(this.f.getString("back"));
        button.setTextColor(Color.parseColor(p.e(getContext())));
        button.setBackgroundResource(b2);
        Button button2 = (Button) findViewById(this.j);
        button2.setText(this.f.getString("refresh"));
        button2.setTextColor(Color.parseColor(p.e(getContext())));
        button2.setBackgroundResource(b2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        TextView textView = (TextView) findViewById(p.d(getContext(), "socialoauthdialog_textview_title"));
        textView.setTextColor(Color.parseColor(p.f(getContext())));
        textView.setText(this.f.getString("auth_dialog_title"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (str.startsWith("http://openapi.baidu.com/social/oauth/2.0/login_success")) {
            dismiss();
            JSONObject fragmentParams = Utils.getFragmentParams(str);
            if (this.d.equals(fragmentParams.optString(SocialConstants.PARAM_STATE))) {
                this.e.onComplete(fragmentParams);
                return true;
            }
            this.e.onError(new BaiduException("state parameter in response & request are not same, it may be a csrf attack"));
            return true;
        } else if (str.startsWith("http://openapi.baidu.com/social/oauth/2.0/error")) {
            dismiss();
            int optInt = Utils.getQueryParams(str).optInt(SocialConstants.PARAM_ERROR_CODE, -1);
            this.e.onError(new BaiduException(optInt, SocialAPIErrorCodes.getErrorDescription(optInt)));
            return true;
        } else {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme.equals("http") || scheme.equals("https")) {
                if (com.baidu.cloudsdk.Build.DEBUG) {
                    Log.d(a, "scheme: " + parse.toString());
                }
                return false;
            }
            try {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (ActivityNotFoundException e) {
                this.e.onError(new BaiduException("no invalid browser to open"));
                return true;
            }
        }
    }

    private void b() {
        this.g = new ProgressDialog(getContext());
        this.g.requestWindowFeature(1);
        this.g.setMessage(this.f.getString("loading"));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.g != null && this.g.isShowing()) {
            this.g.dismiss();
            this.g = null;
        }
        if (this.h != null) {
            this.h.stopLoading();
            this.h.clearCache(true);
            if (this.f.getInt(b) == 1) {
                if (com.baidu.cloudsdk.Build.DEBUG) {
                    Log.d("SocialOAuthActivity", "pauseTimers");
                }
                this.h.pauseTimers();
            }
            this.h.removeAllViews();
            this.h.freeMemory();
            if (this.h.getParent() != null) {
                ((ViewGroup) this.h.getParent()).removeView(this.h);
            }
            this.h.destroy();
            this.h = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
        this.e.onCancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.i) {
            onBackPressed();
        } else if (view.getId() == this.j) {
            this.h.reload();
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
        int i = this.f.getInt("activity_brightness");
        if (i > 0) {
            Utils.setBrightness(this, i);
        }
    }
}
