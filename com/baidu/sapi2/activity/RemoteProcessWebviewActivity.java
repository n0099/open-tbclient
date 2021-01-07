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
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.l.a.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.views.ViewUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RemoteProcessWebviewActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_EXTERNAL_TITLE = "external_title";
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String EXTRA_IS_DARK_MODE = "is_dark_mode";
    public static final String EXTRA_SHOW_BOTTOM_BACK = "show_bottom_back";
    private static final String h = ":pass";

    /* renamed from: a  reason: collision with root package name */
    private boolean f5135a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5136b;
    protected View bottomBackView;
    private String c;
    private String d;
    protected View dividerLine;
    private WebView e;
    private ProgressBar f;
    private View g;
    protected ImageView mBottomBackBtnIv;
    protected RelativeLayout mBottomBgLayout;
    protected ImageView mBottomDividerLine;
    protected ImageView mLeftBtnIv;
    protected LinearLayout mLeftBtnLayout;
    protected TextView mTitle;
    protected RelativeLayout mTitleBgLayout;

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
            if (!TextUtils.isEmpty(curProcessName) && curProcessName.endsWith(h)) {
                try {
                    WebView.setDataDirectorySuffix(curProcessName);
                } catch (Throwable th) {
                }
            }
        }
        super.onCreate(bundle);
        setContentView(a.f.layout_sapi_sdk_normal_webview_with_title_bar);
        a(true);
        b();
        c();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable th) {
        }
    }

    private void b() {
        this.f5135a = getIntent().getBooleanExtra(EXTRA_IS_DARK_MODE, false);
        this.f5136b = getIntent().getBooleanExtra(EXTRA_SHOW_BOTTOM_BACK, false);
        this.c = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
        this.d = getIntent().getStringExtra(EXTRA_EXTERNAL_URL);
    }

    private void c() {
        ViewStub viewStub;
        if (this.f5135a) {
            setTheme(a.h.SDKDarkTheme);
        }
        this.e = (WebView) findViewById(a.e.webview);
        this.mTitle = (TextView) findViewById(a.e.title);
        this.mLeftBtnIv = (ImageView) findViewById(a.e.title_btn_left_iv);
        this.mLeftBtnIv.setOnClickListener(this);
        this.mLeftBtnLayout = (LinearLayout) findViewById(a.e.title_left_btn_layout);
        this.dividerLine = findViewById(a.e.title_divider_line);
        this.mTitleBgLayout = (RelativeLayout) findViewById(a.e.sapi_title_bg_layout);
        this.mTitle.setText(this.c);
        if (this.f5136b) {
            if (this.bottomBackView == null && (viewStub = (ViewStub) findViewById(a.e.stub_bottom_back)) != null) {
                this.bottomBackView = viewStub.inflate();
                this.mBottomBackBtnIv = (ImageView) findViewById(a.e.sapi_bottom_back);
                this.mBottomBgLayout = (RelativeLayout) findViewById(a.e.sapi_layout_bottom_back);
                this.mBottomDividerLine = (ImageView) findViewById(a.e.sapi_sdk_bottom_divider_line);
                this.mBottomBackBtnIv.setOnClickListener(this);
                ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
            }
            this.mLeftBtnIv.setVisibility(8);
        }
        if (this.f5135a) {
            this.mTitleBgLayout.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            this.mLeftBtnIv.setImageResource(a.d.sapi_sdk_btn_back_dark_mode);
            this.mTitle.setTextColor(getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
            this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            this.dividerLine.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            ImageView imageView = this.mBottomBackBtnIv;
            if (imageView != null) {
                imageView.setImageResource(a.d.sapi_sdk_btn_back_dark_mode);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView2 = this.mBottomDividerLine;
            if (imageView2 != null) {
                imageView2.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            }
        }
        a();
        this.e.loadUrl(this.d);
    }

    private void a() {
        WebSettings settings = this.e.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
        }
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        this.e.setScrollBarStyle(0);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        try {
            this.f = new ProgressBar(this, null, 16842872);
            this.f.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(this, 2.0f), 0, 0));
            this.f.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_explain_camera_detail_color));
            this.e.addView(this.f);
        } catch (Throwable th) {
            Log.e(th);
        }
        this.e.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.1
            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BaseJsonData.TAG_ERRNO, "0");
                } catch (JSONException e2) {
                }
                jsPromptResult.confirm(jSONObject.toString());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (RemoteProcessWebviewActivity.this.f != null) {
                    if (i == 100) {
                        RemoteProcessWebviewActivity.this.f.setVisibility(8);
                    } else {
                        if (RemoteProcessWebviewActivity.this.f.getVisibility() == 8) {
                            RemoteProcessWebviewActivity.this.f.setVisibility(0);
                        }
                        RemoteProcessWebviewActivity.this.f.setProgress(i);
                    }
                }
                super.onProgressChanged(webView, i);
            }
        });
        this.e.setWebViewClient(new WebViewClient() { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (SapiUtils.hasActiveNetwork(RemoteProcessWebviewActivity.this)) {
                    return;
                }
                if (RemoteProcessWebviewActivity.this.g == null) {
                    RemoteProcessWebviewActivity remoteProcessWebviewActivity = RemoteProcessWebviewActivity.this;
                    remoteProcessWebviewActivity.g = g.a(remoteProcessWebviewActivity, remoteProcessWebviewActivity.e);
                    RemoteProcessWebviewActivity.this.e.addView(RemoteProcessWebviewActivity.this.g, new ViewGroup.LayoutParams(-1, -1));
                }
                RemoteProcessWebviewActivity.this.g.setVisibility(0);
            }
        });
    }

    private void a(boolean z) {
        int i = a.C0156a.sapi_sdk_slide_right_in;
        int i2 = a.C0156a.sapi_sdk_slide_right_out;
        if (z) {
            overridePendingTransition(i, a.C0156a.sapi_sdk_slide_left_out);
        } else {
            overridePendingTransition(a.C0156a.sapi_sdk_slide_left_in, i2);
        }
    }
}
