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
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RemoteProcessWebviewActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_EXTERNAL_TITLE = "external_title";
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String EXTRA_IS_DARK_MODE = "is_dark_mode";
    public static final String EXTRA_IS_SHOW_BOTTOM_BACK_TEXT = "is_show_bottom_back_text";
    public static final String EXTRA_SHOW_BOTTOM_BACK = "show_bottom_back";
    public static final String EXTRA_TEXT_ZOOM = "text_zoom";
    public static final String f = ":pass";
    public boolean a;
    public boolean b;
    public View bottomBackView;
    public View bottomBackViewSingleBtn;
    public String c;
    public String d;
    public View dividerLine;
    public WebView e;
    public ImageView mBottomBackBtnIv;
    public ImageView mBottomBackBtnIvSingleBtn;
    public TextView mBottomBackTvText;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public boolean mIsShowBottomBackText;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public int mTextZoom;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;
    public View noNetworkView;
    public ProgressBar progressBar;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        a(false);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28) {
            String curProcessName = SapiUtils.getCurProcessName(this);
            if (!TextUtils.isEmpty(curProcessName) && curProcessName.endsWith(f)) {
                try {
                    WebView.setDataDirectorySuffix(curProcessName);
                } catch (Throwable unused) {
                }
            }
        }
        super.onCreate(bundle);
        setContentView(R.layout.layout_sapi_sdk_normal_webview_with_title_bar);
        a(true);
        b();
        c();
    }

    private void a() {
        WebSettings settings = this.e.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
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
            ProgressBar progressBar = new ProgressBar(this, null, 16842872);
            this.progressBar = progressBar;
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(this, 2.0f), 0, 0));
            this.progressBar.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_explain_camera_detail_color));
            this.e.addView(this.progressBar);
        } catch (Throwable th) {
            Log.e(th);
        }
        this.e.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.1
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
                ProgressBar progressBar2 = RemoteProcessWebviewActivity.this.progressBar;
                if (progressBar2 != null) {
                    if (i == 100) {
                        progressBar2.setVisibility(8);
                    } else {
                        if (progressBar2.getVisibility() == 8) {
                            RemoteProcessWebviewActivity.this.progressBar.setVisibility(0);
                        }
                        RemoteProcessWebviewActivity.this.progressBar.setProgress(i);
                    }
                }
                super.onProgressChanged(webView, i);
            }
        });
        this.e.setWebViewClient(new WebViewClient() { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (!SapiUtils.hasActiveNetwork(RemoteProcessWebviewActivity.this)) {
                    RemoteProcessWebviewActivity remoteProcessWebviewActivity = RemoteProcessWebviewActivity.this;
                    if (remoteProcessWebviewActivity.noNetworkView == null) {
                        remoteProcessWebviewActivity.noNetworkView = b.a(remoteProcessWebviewActivity, remoteProcessWebviewActivity.e);
                        RemoteProcessWebviewActivity.this.e.addView(RemoteProcessWebviewActivity.this.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
                    }
                    RemoteProcessWebviewActivity.this.noNetworkView.setVisibility(0);
                }
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (i > 10 && i < 19) {
            this.e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.e.removeJavascriptInterface("accessibility");
            this.e.removeJavascriptInterface("accessibilityTraversal");
        }
    }

    private void a(boolean z) {
        if (z) {
            overridePendingTransition(R.anim.sapi_sdk_slide_right_in, R.anim.sapi_sdk_slide_left_out);
        } else {
            overridePendingTransition(R.anim.sapi_sdk_slide_left_in, R.anim.sapi_sdk_slide_right_out);
        }
    }

    private void b() {
        this.a = getIntent().getBooleanExtra("is_dark_mode", false);
        this.b = getIntent().getBooleanExtra("show_bottom_back", false);
        this.c = getIntent().getStringExtra("external_title");
        this.d = getIntent().getStringExtra("external_url");
        this.mTextZoom = getIntent().getIntExtra("text_zoom", 100);
        this.mIsShowBottomBackText = getIntent().getBooleanExtra("is_show_bottom_back_text", false);
    }

    private void c() {
        ViewStub viewStub;
        ViewStub viewStub2;
        int i;
        if (this.a) {
            setTheme(R.style.obfuscated_res_0x7f100190);
        }
        this.e = (WebView) findViewById(R.id.obfuscated_res_0x7f092a1b);
        this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f09258f);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09259a);
        this.mLeftBtnIv = imageView;
        imageView.setOnClickListener(this);
        this.mLeftBtnLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0925aa);
        this.dividerLine = findViewById(R.id.obfuscated_res_0x7f0925a2);
        this.mTitleBgLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0920d6);
        this.mTitle.setText(this.c);
        if (this.b) {
            if (this.mIsShowBottomBackText) {
                if (this.bottomBackView == null && (viewStub2 = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0922eb)) != null) {
                    this.bottomBackView = viewStub2.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ff3);
                    this.mBottomBackTvText = (TextView) findViewById(R.id.obfuscated_res_0x7f0920d5);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ff6);
                    this.mBottomDividerLine = (ImageView) findViewById(R.id.obfuscated_res_0x7f09203f);
                    this.mBottomBackBtnIv.setOnClickListener(this);
                    this.mBottomBackTvText.setOnClickListener(this);
                    ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                    ViewUtility.setViewClickAlpha(this.mBottomBackTvText, 0.2f);
                    TextView textView = this.mBottomBackTvText;
                    if (this.mIsShowBottomBackText) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    textView.setVisibility(i);
                }
            } else if (this.bottomBackViewSingleBtn == null && (viewStub = (ViewStub) findViewById(R.id.stub_bottom_back_single_btn)) != null) {
                this.bottomBackViewSingleBtn = viewStub.inflate();
                ImageView imageView2 = (ImageView) findViewById(R.id.sapi_bottom_back_single_btn);
                this.mBottomBackBtnIvSingleBtn = imageView2;
                imageView2.setOnClickListener(this);
            }
            this.mLeftBtnIv.setVisibility(8);
        }
        ViewUtility.enlargedViews(this.mLeftBtnIv, this.mTextZoom);
        ViewUtility.enlargedViews(this.mTitle, this.mTextZoom);
        ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.mTextZoom);
        ViewUtility.enlargedViews(this.mBottomBackTvText, this.mTextZoom);
        if (this.a) {
            this.mTitleBgLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            this.mLeftBtnIv.setImageResource(R.drawable.sapi_sdk_btn_back_dark_mode);
            this.mTitle.setTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            this.dividerLine.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            ImageView imageView3 = this.mBottomBackBtnIv;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.sapi_sdk_btn_back_dark_mode);
            }
            ImageView imageView4 = this.mBottomBackBtnIvSingleBtn;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.sapi_sdk_icon_button_bar_back_dark);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            }
            TextView textView2 = this.mBottomBackTvText;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            }
            ImageView imageView5 = this.mBottomDividerLine;
            if (imageView5 != null) {
                imageView5.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            }
        }
        a();
        this.e.loadUrl(this.d);
    }
}
