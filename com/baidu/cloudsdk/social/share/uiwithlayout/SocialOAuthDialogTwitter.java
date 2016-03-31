package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.AsyncTask;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.p;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SocialOAuthDialogTwitter extends Dialog implements View.OnClickListener {
    private static final String a = SocialOAuthDialogTwitter.class.getSimpleName();
    private static String b = "webview_timer_needresume";
    private String c;
    private IBaiduListener d;
    private final SocialConfig e;
    private ProgressDialog f;
    private WebView g;
    private int h;
    private int i;
    private OAuthConsumer j;
    private OAuthProvider k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AsyncTask {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(String... strArr) {
            try {
                Log.d(SocialOAuthDialogTwitter.a, "RetrieveAccessTokenTask " + strArr[0]);
                SocialOAuthDialogTwitter.this.k.retrieveAccessToken(SocialOAuthDialogTwitter.this.j, strArr[0], new String[0]);
                return true;
            } catch (Exception e) {
                Log.e(SocialOAuthDialogTwitter.a, "BeginOAuthTask", e);
                return false;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                String token = SocialOAuthDialogTwitter.this.j.getToken();
                String tokenSecret = SocialOAuthDialogTwitter.this.j.getTokenSecret();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SocialConstants.PARAM_ACCESS_TOKEN, token).put(SocialConstants.PARAM_ACCESS_TOKEN_SECRET, tokenSecret).put(SocialConstants.PARAM_MEDIA_TYPE, MediaType.TWITTER.toString());
                } catch (JSONException e) {
                }
                SocialOAuthDialogTwitter.this.d.onComplete(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends WebChromeClient {
        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            SocialOAuthDialogTwitter.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (Build.VERSION.SDK_INT >= 11 || !SocialOAuthDialogTwitter.this.a(str)) {
                super.onPageFinished(webView, str);
                if (SocialOAuthDialogTwitter.this.isShowing() && SocialOAuthDialogTwitter.this.f.isShowing()) {
                    SocialOAuthDialogTwitter.this.f.dismiss();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!SocialOAuthDialogTwitter.this.isShowing() || SocialOAuthDialogTwitter.this.f.isShowing()) {
                return;
            }
            SocialOAuthDialogTwitter.this.f.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            SocialOAuthDialogTwitter.this.dismiss();
            SocialOAuthDialogTwitter.this.d.onError(new BaiduException(str));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return Build.VERSION.SDK_INT >= 11 ? SocialOAuthDialogTwitter.this.a(str) : super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public SocialOAuthDialogTwitter(Context context, String str, OAuthConsumer oAuthConsumer, OAuthProvider oAuthProvider, IBaiduListener iBaiduListener) {
        super(context, 16973830);
        this.j = null;
        this.k = null;
        this.c = str;
        this.d = iBaiduListener;
        this.k = oAuthProvider;
        this.j = oAuthConsumer;
        this.e = SocialConfig.getInstance(context);
        setContentView(p.a(getContext(), "bdsocialshare_socialoauthdialoglayout"));
        this.g = new WebView(context);
        ((LinearLayout) findViewById(p.i(getContext(), "socialoauthdialog_rootlayout"))).addView(this.g, new ViewGroup.LayoutParams(-1, -1));
        if (this.e.getInt(b) == 1) {
            if (com.baidu.cloudsdk.Build.DEBUG) {
                Log.d("SocialOAuthActivity", "resumeTimers");
            }
            this.g.resumeTimers();
        }
        c();
        a(context);
    }

    private void a(Context context) {
        this.h = p.i(getContext(), "socialoauthdialog_button_back");
        this.i = p.i(getContext(), "socialoauthdialog_button_refresh");
        ((RelativeLayout) findViewById(p.i(getContext(), "socialoauthdialog_titlebar"))).setBackgroundResource(p.g(getContext(), "bdsocialshare_titlebar_bg"));
        int g = p.g(getContext(), "bdsocialshare_sharedialog_button");
        Button button = (Button) findViewById(this.h);
        button.setText(this.e.getString("back"));
        button.setTextColor(Color.parseColor(p.e(getContext())));
        button.setBackgroundResource(g);
        Button button2 = (Button) findViewById(this.i);
        button2.setText(this.e.getString("refresh"));
        button2.setTextColor(Color.parseColor(p.e(getContext())));
        button2.setBackgroundResource(g);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        TextView textView = (TextView) findViewById(p.i(getContext(), "socialoauthdialog_textview_title"));
        textView.setTextColor(Color.parseColor(p.f(getContext())));
        textView.setText(this.e.getString("auth_dialog_title"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        String str2;
        if (str.startsWith("baidusocialshare://twitter")) {
            Log.d(a, "url " + str);
            Bundle parseUrl = parseUrl(str);
            if (parseUrl != null) {
                Log.d(a, "bundle " + parseUrl.toString());
                str2 = parseUrl.getString("oauth_verifier");
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                Log.d(a, "verifier " + str2);
                new a().execute(str2);
            }
        }
        return true;
    }

    private void b() {
        this.g.setVerticalScrollBarEnabled(true);
        this.g.getSettings().setJavaScriptEnabled(true);
        this.g.setWebChromeClient(new b());
        this.g.getSettings().setSavePassword(false);
        this.g.setWebViewClient(new c());
        this.g.loadUrl(this.c);
    }

    private void c() {
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
            URL url = new URL(str.replace("baidusocialshare", "http"));
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
        b();
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
