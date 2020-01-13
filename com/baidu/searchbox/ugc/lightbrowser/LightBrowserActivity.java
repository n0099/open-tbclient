package com.baidu.searchbox.ugc.lightbrowser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.publisher.lightbrowser.R;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
/* loaded from: classes12.dex */
public class LightBrowserActivity extends BaseActivity {
    public static final String EXTRA_SHOW_TITLE_BAR_KEY = "showtitlebar";
    public static final String EXTRA_SHOW_TOOL_BAR_KEY = "showtoolbar";
    public static final String INT_VALUE_TRUE = "1";
    public static final String NEED_APPEND_PUBLIC_PARAM = "bdsb_append_param";
    public static final String SCHEME_APPEND_PARAM_KEY = "append";
    public static final String SCHEME_BROWSER_URL_KEY = "url";
    public static final String START_BROWSER_URL_KEY = "bdsb_light_start_url";
    public static final String VALUE_BROWSER_APPEND_LOC_PARAM = "append_loc_param";
    protected String mContentID;
    private ViewStub mErrorViewStub;
    protected String mInitialUrl;
    protected LightBrowserView mLightBrowserView;
    public UnitedSchemeMainDispatcher mMainDispatcher;
    protected boolean mNeedAppendPublicParam = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    protected void init() {
        setContentView(R.layout.ugc_light_browser_activity);
        this.mInitialUrl = getWebUrl();
        initBrowserView();
        this.mErrorViewStub = (ViewStub) findViewById(R.id.content_detail_error_view_stub);
    }

    private void initBrowserView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.rootview);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mLightBrowserView = new LightBrowserView(this, 2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(this.mLightBrowserView, layoutParams2);
        frameLayout.addView(linearLayout, layoutParams);
        initLoadingView(frameLayout);
        this.mLightBrowserView.loadUrl(this.mInitialUrl);
    }

    private String getWebUrlOnlyFromIntent(Intent intent) {
        if (intent == null || getIntent() == null) {
            return null;
        }
        return getIntent().getStringExtra("url");
    }

    protected String getWebUrl() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return getWebUrlOnlyFromIntent(intent);
    }

    protected String processNightMode(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
        }
        return str;
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity
    public void setEnableSliding(boolean z) {
    }

    private void initLoadingView(FrameLayout frameLayout) {
        this.mLightBrowserView.getWebView().setWebViewClient(new WebViewClient() { // from class: com.baidu.searchbox.ugc.lightbrowser.LightBrowserActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                LightBrowserActivity.this.setErrorViewVisibility(0);
                LightBrowserActivity.this.mLightBrowserView.setVisibility(8);
            }
        });
    }

    private void inflateErrorView() {
        if (this.mErrorViewStub != null) {
            this.mErrorViewStub.inflate();
            this.mErrorViewStub = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorViewVisibility(int i) {
    }

    protected void setActionBarTitle(String str) {
    }

    public void showActionBar(boolean z) {
    }

    protected void onActionBarBackPressed() {
        finish();
    }
}
