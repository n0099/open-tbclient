package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.i;
import com.baidu.sapi2.views.ViewUtility;
import d.b.a0.a.a;
import d.b.a0.a.b;
import d.b.a0.a.d;
import d.b.a0.a.e;
import d.b.a0.a.f;
import d.b.a0.a.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoteProcessWebviewActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_EXTERNAL_TITLE = "external_title";
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String EXTRA_IS_DARK_MODE = "is_dark_mode";
    public static final String EXTRA_SHOW_BOTTOM_BACK = "show_bottom_back";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11049h = ":pass";

    /* renamed from: a  reason: collision with root package name */
    public boolean f11050a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11051b;
    public View bottomBackView;

    /* renamed from: c  reason: collision with root package name */
    public String f11052c;

    /* renamed from: d  reason: collision with root package name */
    public String f11053d;
    public View dividerLine;

    /* renamed from: e  reason: collision with root package name */
    public WebView f11054e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f11055f;

    /* renamed from: g  reason: collision with root package name */
    public View f11056g;
    public ImageView mBottomBackBtnIv;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        a(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28) {
            String curProcessName = SapiUtils.getCurProcessName(this);
            if (!TextUtils.isEmpty(curProcessName) && curProcessName.endsWith(f11049h)) {
                try {
                    WebView.setDataDirectorySuffix(curProcessName);
                } catch (Throwable unused) {
                }
            }
        }
        super.onCreate(bundle);
        setContentView(f.layout_sapi_sdk_normal_webview_with_title_bar);
        a(true);
        b();
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
    }

    private void b() {
        this.f11050a = getIntent().getBooleanExtra(EXTRA_IS_DARK_MODE, false);
        this.f11051b = getIntent().getBooleanExtra(EXTRA_SHOW_BOTTOM_BACK, false);
        this.f11052c = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
        this.f11053d = getIntent().getStringExtra(EXTRA_EXTERNAL_URL);
    }

    private void c() {
        ViewStub viewStub;
        if (this.f11050a) {
            setTheme(h.SDKDarkTheme);
        }
        this.f11054e = (WebView) findViewById(e.webview);
        this.mTitle = (TextView) findViewById(e.title);
        ImageView imageView = (ImageView) findViewById(e.title_btn_left_iv);
        this.mLeftBtnIv = imageView;
        imageView.setOnClickListener(this);
        this.mLeftBtnLayout = (LinearLayout) findViewById(e.title_left_btn_layout);
        this.dividerLine = findViewById(e.title_divider_line);
        this.mTitleBgLayout = (RelativeLayout) findViewById(e.sapi_title_bg_layout);
        this.mTitle.setText(this.f11052c);
        if (this.f11051b) {
            if (this.bottomBackView == null && (viewStub = (ViewStub) findViewById(e.stub_bottom_back)) != null) {
                this.bottomBackView = viewStub.inflate();
                this.mBottomBackBtnIv = (ImageView) findViewById(e.sapi_bottom_back);
                this.mBottomBgLayout = (RelativeLayout) findViewById(e.sapi_layout_bottom_back);
                this.mBottomDividerLine = (ImageView) findViewById(e.sapi_sdk_bottom_divider_line);
                this.mBottomBackBtnIv.setOnClickListener(this);
                ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
            }
            this.mLeftBtnIv.setVisibility(8);
        }
        if (this.f11050a) {
            this.mTitleBgLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            this.mLeftBtnIv.setImageResource(d.sapi_sdk_btn_back_dark_mode);
            this.mTitle.setTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
            this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            this.dividerLine.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            ImageView imageView2 = this.mBottomBackBtnIv;
            if (imageView2 != null) {
                imageView2.setImageResource(d.sapi_sdk_btn_back_dark_mode);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView3 = this.mBottomDividerLine;
            if (imageView3 != null) {
                imageView3.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
        }
        a();
        this.f11054e.loadUrl(this.f11053d);
    }

    private void a() {
        WebSettings settings = this.f11054e.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        this.f11054e.setScrollBarStyle(0);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        try {
            ProgressBar progressBar = new ProgressBar(this, null, 16842872);
            this.f11055f = progressBar;
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(this, 2.0f), 0, 0));
            this.f11055f.setBackgroundColor(getResources().getColor(b.sapi_sdk_explain_camera_detail_color));
            this.f11054e.addView(this.f11055f);
        } catch (Throwable th) {
            Log.e(th);
        }
        this.f11054e.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.1
            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", "0");
                } catch (JSONException unused2) {
                }
                jsPromptResult.confirm(jSONObject.toString());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (RemoteProcessWebviewActivity.this.f11055f != null) {
                    if (i == 100) {
                        RemoteProcessWebviewActivity.this.f11055f.setVisibility(8);
                    } else {
                        if (RemoteProcessWebviewActivity.this.f11055f.getVisibility() == 8) {
                            RemoteProcessWebviewActivity.this.f11055f.setVisibility(0);
                        }
                        RemoteProcessWebviewActivity.this.f11055f.setProgress(i);
                    }
                }
                super.onProgressChanged(webView, i);
            }
        });
        this.f11054e.setWebViewClient(new WebViewClient() { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (SapiUtils.hasActiveNetwork(RemoteProcessWebviewActivity.this)) {
                    return;
                }
                if (RemoteProcessWebviewActivity.this.f11056g == null) {
                    RemoteProcessWebviewActivity remoteProcessWebviewActivity = RemoteProcessWebviewActivity.this;
                    remoteProcessWebviewActivity.f11056g = i.a(remoteProcessWebviewActivity, remoteProcessWebviewActivity.f11054e);
                    RemoteProcessWebviewActivity.this.f11054e.addView(RemoteProcessWebviewActivity.this.f11056g, new ViewGroup.LayoutParams(-1, -1));
                }
                RemoteProcessWebviewActivity.this.f11056g.setVisibility(0);
            }
        });
    }

    private void a(boolean z) {
        int i = a.sapi_sdk_slide_right_in;
        int i2 = a.sapi_sdk_slide_right_out;
        if (z) {
            overridePendingTransition(i, a.sapi_sdk_slide_left_out);
        } else {
            overridePendingTransition(a.sapi_sdk_slide_left_in, i2);
        }
    }
}
