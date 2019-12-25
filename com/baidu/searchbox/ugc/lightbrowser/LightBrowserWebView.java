package com.baidu.searchbox.ugc.lightbrowser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.searchbox.publisher.lightbrowser.R;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
/* loaded from: classes11.dex */
public class LightBrowserWebView extends WebView implements CallbackHandler {
    private Context mContext;

    public LightBrowserWebView(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        setWebViewClient(new WebViewClient());
        setWebChromeClient(new WebChromeClient());
        initSettings();
        addJavascriptInterface(new SearchBoxJsBridge(getContext(), null, this), "Bdbox_android_jsbridge");
        setOverScrollMode(2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initSettings() {
        WebSettings settings = getSettings();
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 6.0.1; SM-G9006W Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/11.0 light/1.0 baiduboxapp/11.0.0.11 (Baidu; P1 6.0.1)");
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setNeedInitialFocus(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportMultipleWindows(false);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        UgcLightBrowserUiUtils.setVerticalThumbDrawable(this, R.drawable.ugc_lightbrowser_scrollbar);
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return null;
    }
}
