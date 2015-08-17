package com.baidu.searchbox.lightbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
/* loaded from: classes.dex */
public class LightBrowserWebView extends BdSailorWebView {
    public LightBrowserWebView(Context context) {
        super(context);
    }

    public LightBrowserWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LightBrowserWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadJavaScript(String str) {
    }

    public String getSelection() {
        return null;
    }

    public boolean isCustomViewShowing() {
        return false;
    }

    public void setSelectionMode() {
    }

    public void clear() {
    }

    public void setExternalWebViewClient(BdSailorWebViewClient bdSailorWebViewClient) {
    }

    public void setExternalWebChromeClient(BdSailorWebChromeClient bdSailorWebChromeClient) {
    }

    public void setFullscreen(Activity activity, boolean z) {
    }

    public void hideCustomView() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
