package com.baidu.browser.webkit.sys;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import com.baidu.browser.webkit.BdWebView;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSysWebView7 extends BdSysWebView {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdSysWebView7";

    public BdSysWebView7(BdWebView bdWebView, Context context) {
        super(bdWebView, context);
    }

    public BdSysWebView7(BdWebView bdWebView, Context context, AttributeSet attributeSet) {
        super(bdWebView, context, attributeSet);
    }

    public BdSysWebView7(BdWebView bdWebView, Context context, AttributeSet attributeSet, int i) {
        super(bdWebView, context, attributeSet, i);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebView
    public String reflectGetSelection() {
        try {
            Object[] objArr = new Object[1];
            if (invokeMethod(this, "nativeGetSelection", null, objArr) && (objArr[0] instanceof Region)) {
                Region region = (Region) objArr[0];
                Object fieldValue = getFieldValue(this, "mWebViewCore");
                if (fieldValue != null) {
                    invokeMethod(fieldValue, "nativeGetSelection", new Object[]{region}, objArr);
                    if (objArr[0] instanceof String) {
                        return (String) objArr[0];
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    @Override // android.webkit.WebView
    public final boolean canZoomIn() {
        return reflectGetActualScale() < reflectGetMaxZoomScale();
    }

    @Override // android.webkit.WebView
    public final boolean canZoomOut() {
        return reflectGetActualScale() > reflectGetMinZoomScale() && !reflectGetInZoomOverview();
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebView, android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebView, android.webkit.WebView
    public void setFindIsUp(boolean z) {
    }
}
