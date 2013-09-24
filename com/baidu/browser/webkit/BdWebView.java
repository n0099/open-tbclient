package com.baidu.browser.webkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;
import com.baidu.browser.webkit.sys.BdSysTitleBarWebView16;
import com.baidu.browser.webkit.sys.BdSysWebChromeClient;
import com.baidu.browser.webkit.sys.BdSysWebSettings;
import com.baidu.browser.webkit.sys.BdSysWebSettings11;
import com.baidu.browser.webkit.sys.BdSysWebSettings14;
import com.baidu.browser.webkit.sys.BdSysWebSettings16;
import com.baidu.browser.webkit.sys.BdSysWebSettings7;
import com.baidu.browser.webkit.sys.BdSysWebSettings8;
import com.baidu.browser.webkit.sys.BdSysWebSettings9;
import com.baidu.browser.webkit.sys.BdSysWebView;
import com.baidu.browser.webkit.sys.BdSysWebView11;
import com.baidu.browser.webkit.sys.BdSysWebView14;
import com.baidu.browser.webkit.sys.BdSysWebView16;
import com.baidu.browser.webkit.sys.BdSysWebView7;
import com.baidu.browser.webkit.sys.BdSysWebView8;
import com.baidu.browser.webkit.sys.BdSysWebView9;
import com.baidu.browser.webkit.sys.BdSysWebViewClient;
import com.baidu.browser.webkit.zeus.BdZeusWebChromeClient;
import com.baidu.browser.webkit.zeus.BdZeusWebSettings;
import com.baidu.browser.webkit.zeus.BdZeusWebView;
import com.baidu.browser.webkit.zeus.BdZeusWebViewClient;
import com.baidu.zeus.DownloadListener;
import com.baidu.zeus.WebView;
import java.lang.ref.SoftReference;
import java.util.Map;
/* loaded from: classes.dex */
public class BdWebView {
    private Context mContext;
    private int mErrorCode;
    private SparseIntArray mErrorCodeList;
    private SoftReference<BdHitTestResult> mHitTestResultWrapper;
    private BdSysWebSettings mSysWebSettings;
    private BdSysWebView mSysWebView;
    private BdWebChromeClient mWebChromeClient;
    private BdWebSettings mWebSettings;
    private BdWebViewClient mWebViewClient;
    private BdZeusWebSettings mZeusWebSettings;
    private BdZeusWebView mZeusWebView;

    /* loaded from: classes.dex */
    public class BdHitTestResult {
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private WebView.HitTestResult mSysHitTestResult;
        private WebView.HitTestResult mZeusHitTestResult;

        public BdHitTestResult(WebView.HitTestResult hitTestResult) {
            this.mSysHitTestResult = hitTestResult;
        }

        public BdHitTestResult(WebView.HitTestResult hitTestResult) {
            this.mZeusHitTestResult = hitTestResult;
        }

        public boolean equals(Object obj) {
            return (obj instanceof BdHitTestResult) && unwrap() == ((BdHitTestResult) obj).unwrap();
        }

        public int hashCode() {
            return this.mZeusHitTestResult != null ? this.mZeusHitTestResult.hashCode() : this.mSysHitTestResult.hashCode();
        }

        public boolean isContains(Object obj) {
            return this.mZeusHitTestResult != null ? this.mZeusHitTestResult == obj : this.mSysHitTestResult == obj;
        }

        public Object unwrap() {
            return this.mZeusHitTestResult != null ? this.mZeusHitTestResult : this.mSysHitTestResult;
        }

        public int getType() {
            return this.mZeusHitTestResult != null ? this.mZeusHitTestResult.getType() : this.mSysHitTestResult.getType();
        }

        public String getExtra() {
            return this.mZeusHitTestResult != null ? this.mZeusHitTestResult.getExtra() : this.mSysHitTestResult.getExtra();
        }
    }

    /* loaded from: classes.dex */
    public class BdWebViewTransport {
        private WebView.WebViewTransport mSysWebViewTransport;
        private WebView.WebViewTransport mZeusWebViewTransport;

        public BdWebViewTransport(WebView.WebViewTransport webViewTransport) {
            this.mSysWebViewTransport = webViewTransport;
        }

        public BdWebViewTransport(WebView.WebViewTransport webViewTransport) {
            this.mZeusWebViewTransport = webViewTransport;
        }

        public boolean equals(Object obj) {
            return (obj instanceof BdWebViewTransport) && unwrap() == ((BdWebViewTransport) obj).unwrap();
        }

        public int hashCode() {
            return this.mZeusWebViewTransport != null ? this.mZeusWebViewTransport.hashCode() : this.mSysWebViewTransport.hashCode();
        }

        public boolean isContains(Object obj) {
            return this.mZeusWebViewTransport != null ? this.mZeusWebViewTransport == obj : this.mSysWebViewTransport == obj;
        }

        public Object unwrap() {
            return this.mZeusWebViewTransport != null ? this.mZeusWebViewTransport : this.mSysWebViewTransport;
        }

        public BdWebView obtainWebViewWrapper(android.webkit.WebView webView) {
            return (BdWebView) webView.getTag();
        }

        public BdWebView obtainWebViewWrapper(com.baidu.zeus.WebView webView) {
            return (BdWebView) webView.getTag();
        }

        public synchronized void setWebView(BdWebView bdWebView) {
            if (this.mZeusWebViewTransport != null) {
                if (bdWebView == null) {
                    this.mZeusWebViewTransport.setWebView(null);
                } else {
                    this.mZeusWebViewTransport.setWebView((com.baidu.zeus.WebView) bdWebView.unwrap());
                }
            } else if (bdWebView == null) {
                this.mSysWebViewTransport.setWebView(null);
            } else {
                this.mSysWebViewTransport.setWebView((android.webkit.WebView) bdWebView.unwrap());
            }
        }

        public synchronized BdWebView getWebView() {
            return this.mZeusWebViewTransport != null ? obtainWebViewWrapper(this.mZeusWebViewTransport.getWebView()) : obtainWebViewWrapper(this.mSysWebViewTransport.getWebView());
        }
    }

    public BdWebView(Context context, boolean z) {
        this(context, null, z);
    }

    public BdWebView(Context context) {
        this(context, null, false);
    }

    public BdWebView(Context context, AttributeSet attributeSet, boolean z) {
        this(context, attributeSet, -1, z);
    }

    public BdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this.mContext = context;
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            if (i < 0) {
                this.mZeusWebView = new BdZeusWebView(this, context, attributeSet);
                return;
            } else {
                this.mZeusWebView = new BdZeusWebView(this, context, attributeSet, i);
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 7) {
            if (i < 0) {
                this.mSysWebView = new BdSysWebView7(this, context, attributeSet);
            } else {
                this.mSysWebView = new BdSysWebView7(this, context, attributeSet, i);
            }
        } else if (i2 == 8) {
            if (i < 0) {
                this.mSysWebView = new BdSysWebView8(this, context, attributeSet);
            } else {
                this.mSysWebView = new BdSysWebView8(this, context, attributeSet, i);
            }
        } else if (i2 >= 9 && i2 <= 10) {
            if (i < 0) {
                this.mSysWebView = new BdSysWebView9(this, context, attributeSet);
            } else {
                this.mSysWebView = new BdSysWebView9(this, context, attributeSet, i);
            }
        } else if (i2 >= 11 && i2 <= 13) {
            if (i < 0) {
                this.mSysWebView = new BdSysWebView11(this, context, attributeSet);
            } else {
                this.mSysWebView = new BdSysWebView11(this, context, attributeSet, i);
            }
        } else if (i2 >= 14 && i2 <= 15) {
            if (i < 0) {
                this.mSysWebView = new BdSysWebView14(this, context, attributeSet);
            } else {
                this.mSysWebView = new BdSysWebView14(this, context, attributeSet, i);
            }
        } else if (i2 >= 16) {
            if (z) {
                this.mSysWebView = new BdSysTitleBarWebView16(this, context, attributeSet);
            } else {
                this.mSysWebView = new BdSysWebView16(this, context, attributeSet);
            }
        } else if (i < 0) {
            this.mSysWebView = new BdSysWebView(this, context, attributeSet);
        } else {
            this.mSysWebView = new BdSysWebView(this, context, attributeSet, i);
        }
    }

    public BdWebView(android.webkit.WebView webView) {
        if (webView instanceof BdSysWebView) {
            this.mContext = webView.getContext();
            this.mSysWebView = (BdSysWebView) webView;
            return;
        }
        throw new IllegalArgumentException();
    }

    public BdWebView(com.baidu.zeus.WebView webView) {
        if (webView instanceof BdZeusWebView) {
            this.mContext = webView.getContext();
            this.mZeusWebView = (BdZeusWebView) webView;
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebView) && unwrap() == ((BdWebView) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebView != null ? this.mZeusWebView.hashCode() : this.mSysWebView.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebView != null ? this.mZeusWebView == obj : this.mSysWebView == obj;
    }

    public Object unwrap() {
        return this.mZeusWebView != null ? this.mZeusWebView : this.mSysWebView;
    }

    private BdWebSettings obtainWebSettingsWrapper(WebSettings webSettings) {
        if (this.mSysWebSettings == null || !this.mSysWebSettings.isContains(webSettings)) {
            int i = Build.VERSION.SDK_INT;
            if (i == 7) {
                this.mSysWebSettings = new BdSysWebSettings7(webSettings);
            } else if (i == 8) {
                this.mSysWebSettings = new BdSysWebSettings8(webSettings);
            } else if (i >= 9 && i <= 10) {
                this.mSysWebSettings = new BdSysWebSettings9(webSettings);
            } else if (i >= 11 && i <= 13) {
                this.mSysWebSettings = new BdSysWebSettings11(webSettings);
            } else if (i >= 14 && i <= 15) {
                this.mSysWebSettings = new BdSysWebSettings14(webSettings);
            } else if (i >= 16) {
                this.mSysWebSettings = new BdSysWebSettings16(webSettings);
            } else {
                this.mSysWebSettings = new BdSysWebSettings(webSettings);
            }
        }
        if (this.mWebSettings == null || !this.mWebSettings.isContains(this.mSysWebSettings)) {
            this.mWebSettings = new BdWebSettings(this.mSysWebSettings);
        }
        return this.mWebSettings;
    }

    private BdWebSettings obtainWebSettingsWrapper(com.baidu.zeus.WebSettings webSettings) {
        if (this.mZeusWebSettings == null || !this.mZeusWebSettings.isContains(webSettings)) {
            this.mZeusWebSettings = new BdZeusWebSettings(webSettings);
        }
        if (this.mWebSettings == null || !this.mWebSettings.isContains(this.mZeusWebSettings)) {
            this.mWebSettings = new BdWebSettings(this.mZeusWebSettings);
        }
        return this.mWebSettings;
    }

    private BdHitTestResult obtainHitTestResultWrapper(WebView.HitTestResult hitTestResult) {
        BdHitTestResult bdHitTestResult = null;
        if (this.mHitTestResultWrapper != null) {
            bdHitTestResult = this.mHitTestResultWrapper.get();
        }
        if (bdHitTestResult == null || !bdHitTestResult.isContains(hitTestResult)) {
            BdHitTestResult bdHitTestResult2 = new BdHitTestResult(hitTestResult);
            this.mHitTestResultWrapper = new SoftReference<>(bdHitTestResult2);
            return bdHitTestResult2;
        }
        return bdHitTestResult;
    }

    private BdHitTestResult obtainHitTestResultWrapper(WebView.HitTestResult hitTestResult) {
        BdHitTestResult bdHitTestResult = null;
        if (this.mHitTestResultWrapper != null) {
            bdHitTestResult = this.mHitTestResultWrapper.get();
        }
        if (bdHitTestResult == null || !bdHitTestResult.isContains(hitTestResult)) {
            BdHitTestResult bdHitTestResult2 = new BdHitTestResult(hitTestResult);
            this.mHitTestResultWrapper = new SoftReference<>(bdHitTestResult2);
            return bdHitTestResult2;
        }
        return bdHitTestResult;
    }

    public View getWebView() {
        return this.mZeusWebView != null ? this.mZeusWebView : this.mSysWebView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorListCode(int i) {
        if (this.mErrorCodeList == null) {
            this.mErrorCodeList = new SparseIntArray();
        }
        this.mErrorCodeList.put(copyBackForwardList().getCurrentIndex(), i);
    }

    public int getErrorListCode() {
        if (this.mErrorCodeList == null) {
            return 0;
        }
        return this.mErrorCodeList.get(copyBackForwardList().getCurrentIndex());
    }

    public void clearMatches() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.clearMatches();
        } else {
            this.mSysWebView.clearMatches();
        }
    }

    public int findAll(String str) {
        return this.mZeusWebView != null ? this.mZeusWebView.findAll(str) : this.mSysWebView.findAll(str);
    }

    public void findNext(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.findNext(z);
        } else {
            this.mSysWebView.findNext(z);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.addJavascriptInterface(obj, str);
        } else {
            this.mSysWebView.addJavascriptInterface(obj, str);
        }
    }

    public void reload() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.reload();
        } else {
            this.mSysWebView.reload();
        }
    }

    public boolean canGoBack() {
        return this.mZeusWebView != null ? this.mZeusWebView.canGoBack() : this.mSysWebView.canGoBack();
    }

    public void goBack() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.goBack();
        } else {
            this.mSysWebView.goBack();
        }
    }

    public boolean canGoForward() {
        return this.mZeusWebView != null ? this.mZeusWebView.canGoForward() : this.mSysWebView.canGoForward();
    }

    public void goForward() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.goForward();
        } else {
            this.mSysWebView.goForward();
        }
    }

    public boolean canGoBackOrForward(int i) {
        return this.mZeusWebView != null ? this.mZeusWebView.canGoBackOrForward(i) : this.mSysWebView.canGoBackOrForward(i);
    }

    public void goBackOrForward(int i) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.goBackOrForward(i);
        } else {
            this.mSysWebView.goBackOrForward(i);
        }
    }

    public void loadUrl(String str) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.loadUrl(str);
        } else {
            this.mSysWebView.loadUrl(str);
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.postUrl(str, bArr);
        } else {
            this.mSysWebView.postUrl(str, bArr);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.loadUrl(str, map, WebView.PageType.NormalType);
        } else {
            this.mSysWebView.loadUrl(str, map);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.mSysWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.loadData(str, str2, str3);
        } else {
            this.mSysWebView.loadData(str, str2, str3);
        }
    }

    public String getUrl() {
        return this.mZeusWebView != null ? this.mZeusWebView.getUrl() : this.mSysWebView.getUrl();
    }

    public String getTitle() {
        return this.mZeusWebView != null ? this.mZeusWebView.getTitle() : this.mSysWebView.getTitle();
    }

    public void setWebViewClient(BdWebViewClient bdWebViewClient) {
        this.mWebViewClient = bdWebViewClient;
        if (this.mZeusWebView != null) {
            if (bdWebViewClient == null) {
                this.mZeusWebView.setWebViewClient(null);
            } else {
                this.mZeusWebView.setWebViewClient((BdZeusWebViewClient) bdWebViewClient.unwrap());
            }
        } else if (bdWebViewClient == null) {
            this.mSysWebView.setWebViewClient(null);
        } else {
            this.mSysWebView.setWebViewClient((BdSysWebViewClient) bdWebViewClient.unwrap());
        }
    }

    public BdWebViewClient getWebViewClient() {
        return this.mWebViewClient;
    }

    public void setWebChromeClient(BdWebChromeClient bdWebChromeClient) {
        this.mWebChromeClient = bdWebChromeClient;
        if (this.mZeusWebView != null) {
            if (bdWebChromeClient == null) {
                this.mZeusWebView.setWebChromeClient(null);
            } else {
                this.mZeusWebView.setWebChromeClient((BdZeusWebChromeClient) bdWebChromeClient.unwrap());
            }
        } else if (bdWebChromeClient == null) {
            this.mSysWebView.setWebChromeClient(null);
        } else {
            this.mSysWebView.setWebChromeClient((BdSysWebChromeClient) bdWebChromeClient.unwrap());
        }
    }

    public BdWebChromeClient getWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void stopLoading() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.stopLoading();
        } else {
            this.mSysWebView.stopLoading();
        }
    }

    public void clearView() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.clearView();
        } else {
            this.mSysWebView.clearView();
        }
    }

    public void clearHistory() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.clearHistory();
        } else {
            this.mSysWebView.clearHistory();
        }
    }

    public void clearCache(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.clearCache(z);
        } else {
            this.mSysWebView.clearCache(z);
        }
    }

    public void destroy() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.destroy();
        } else {
            this.mSysWebView.destroy();
        }
    }

    public void onPause() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.onPause();
        } else {
            this.mSysWebView.reflectOnPause();
        }
    }

    public void pauseAudio() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.PauseMedia(0);
        }
    }

    public void pauseTimers() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.pauseTimers();
        } else {
            this.mSysWebView.pauseTimers();
        }
    }

    public void resumeTimers() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.resumeTimers();
        } else {
            this.mSysWebView.resumeTimers();
        }
    }

    public void onResume() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.onResume();
        } else {
            this.mSysWebView.reflectOnResume();
        }
    }

    public void resumeAudio() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.ResumeMedia(0);
        }
    }

    public BdWebBackForwardList copyBackForwardList() {
        return this.mZeusWebView != null ? new BdWebBackForwardList(this.mZeusWebView.copyBackForwardList()) : new BdWebBackForwardList(this.mSysWebView.copyBackForwardList());
    }

    public void freeMemory() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.freeMemory();
        } else {
            this.mSysWebView.freeMemory();
        }
    }

    public void emulateShiftHeld() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.emulateShiftHeld();
        } else {
            this.mSysWebView.emulateShiftHeld();
        }
    }

    public BdWebSettings getSettings() {
        return this.mZeusWebView != null ? obtainWebSettingsWrapper(this.mZeusWebView.getSettings()) : obtainWebSettingsWrapper(this.mSysWebView.getSettings());
    }

    public void setEmbeddedTitleBar(View view) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setEmbeddedTitleBar(view);
        } else if (this.mSysWebView instanceof BdSysTitleBarWebView16) {
            this.mSysWebView.setEmbeddedTitleBar(view);
        } else {
            this.mSysWebView.reflectSetEmbeddedTitleBar(view);
        }
    }

    public boolean performLongClick() {
        return superPerformLongClick();
    }

    public boolean superPerformLongClick() {
        return this.mZeusWebView != null ? this.mZeusWebView.superPerformLongClick() : this.mSysWebView.superPerformLongClick();
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return superDrawChild(canvas, view, j);
    }

    public boolean superDrawChild(Canvas canvas, View view, long j) {
        return this.mZeusWebView != null ? this.mZeusWebView.superDrawChild(canvas, view, j) : this.mSysWebView.superDrawChild(canvas, view, j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return superOnTouchEvent(motionEvent);
    }

    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        boolean superOnTouchEvent;
        try {
            if (this.mZeusWebView != null) {
                superOnTouchEvent = this.mZeusWebView.superOnTouchEvent(motionEvent);
            } else {
                superOnTouchEvent = this.mSysWebView.superOnTouchEvent(motionEvent);
            }
            return superOnTouchEvent;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        superOnScrollChanged(i, i2, i3, i4);
    }

    public void superOnScrollChanged(int i, int i2, int i3, int i4) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.superOnScrollChanged(i, i2, i3, i4);
        } else {
            this.mSysWebView.superOnScrollChanged(i, i2, i3, i4);
        }
    }

    public String getSelection() {
        return this.mZeusWebView != null ? "" : this.mSysWebView.reflectGetSelection();
    }

    public boolean getExtendSelection() {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.getExtendSelection();
    }

    public boolean setExtendSelection(boolean z) {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.setExtendSelection(z);
    }

    public boolean getSelectingText() {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.getSelectingText();
    }

    public boolean setSelectingText(boolean z) {
        if (this.mZeusWebView != null) {
            return true;
        }
        return this.mSysWebView.setSelectingText(z);
    }

    public boolean getDrawSelectionPointer() {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.getDrawSelectionPointer();
    }

    public boolean setDrawSelectionPointer(boolean z) {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.setDrawSelectionPointer(z);
    }

    public boolean getShiftIsPressed() {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.getShiftIsPressed();
    }

    public boolean setShiftIsPressed(boolean z) {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.setShiftIsPressed(z);
    }

    public boolean getTouchSelection() {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.getTouchSelection();
    }

    public boolean setTouchSelection(boolean z) {
        if (this.mZeusWebView != null) {
            return false;
        }
        return this.mSysWebView.setTouchSelection(z);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setOnTouchListener(onTouchListener);
        } else {
            this.mSysWebView.setOnTouchListener(onTouchListener);
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setOnLongClickListener(onLongClickListener);
        } else {
            this.mSysWebView.setOnLongClickListener(onLongClickListener);
        }
    }

    public BdHitTestResult getHitTestResult() {
        if (this.mZeusWebView != null) {
            if (this.mZeusWebView.getHitTestResult() != null) {
                return obtainHitTestResultWrapper(this.mZeusWebView.getHitTestResult());
            }
            return null;
        } else if (this.mSysWebView.getHitTestResult() != null) {
            return obtainHitTestResultWrapper(this.mSysWebView.getHitTestResult());
        } else {
            return null;
        }
    }

    public void setDownloadListener(BdDownloadListener bdDownloadListener) {
        if (this.mZeusWebView != null) {
            if (bdDownloadListener == null) {
                this.mZeusWebView.setDownloadListener(null);
            } else {
                this.mZeusWebView.setDownloadListener((DownloadListener) bdDownloadListener.unwrap());
            }
        } else if (bdDownloadListener == null) {
            this.mSysWebView.setDownloadListener(null);
        } else {
            this.mSysWebView.setDownloadListener((android.webkit.DownloadListener) bdDownloadListener.unwrap());
        }
    }

    public void setPictureListener(BdPictureListener bdPictureListener) {
        if (this.mZeusWebView != null) {
            if (bdPictureListener == null) {
                this.mZeusWebView.setPictureListener(null);
            } else {
                this.mZeusWebView.setPictureListener((WebView.PictureListener) bdPictureListener.unwrap());
            }
        } else if (bdPictureListener == null) {
            this.mSysWebView.setPictureListener(null);
        } else {
            this.mSysWebView.setPictureListener((WebView.PictureListener) bdPictureListener.unwrap());
        }
    }

    public int getContentHeight() {
        return this.mZeusWebView != null ? this.mZeusWebView.getContentHeight() : this.mSysWebView.getContentHeight();
    }

    public int getContentWidth() {
        return this.mZeusWebView != null ? this.mZeusWebView.getContentWidth() : this.mSysWebView.getContentWidth();
    }

    public ZoomButtonsController getZoomButtonsController() {
        return this.mZeusWebView != null ? this.mZeusWebView.getZoomButtonsController() : this.mSysWebView.reflectGetZoomButtonsController();
    }

    public void setScrollBarStyle(int i) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setScrollBarStyle(i);
        } else {
            this.mSysWebView.setScrollBarStyle(i);
        }
    }

    public boolean pageDown(boolean z) {
        return this.mZeusWebView != null ? this.mZeusWebView.pageDown(z) : this.mSysWebView.pageDown(z);
    }

    public boolean pageUp(boolean z) {
        return this.mZeusWebView != null ? this.mZeusWebView.pageUp(z) : this.mSysWebView.pageUp(z);
    }

    public boolean zoomIn() {
        return this.mZeusWebView != null ? this.mZeusWebView.zoomIn() : this.mSysWebView.zoomIn();
    }

    public boolean zoomOut() {
        return this.mZeusWebView != null ? this.mZeusWebView.zoomOut() : this.mSysWebView.zoomOut();
    }

    public void requestFocusNodeHref(Message message) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.requestFocusNodeHref(message);
        } else {
            this.mSysWebView.requestFocusNodeHref(message);
        }
    }

    public boolean canZoomIn() {
        return this.mZeusWebView != null ? this.mZeusWebView.canZoomIn() : this.mSysWebView.canZoomIn();
    }

    public boolean canZoomOut() {
        return this.mZeusWebView != null ? this.mZeusWebView.canZoomOut() : this.mSysWebView.canZoomOut();
    }

    public float getScale() {
        return this.mZeusWebView != null ? this.mZeusWebView.getScale() : this.mSysWebView.getScale();
    }

    public Picture capturePicture() {
        if (this.mZeusWebView != null) {
            return null;
        }
        return this.mSysWebView.capturePicture();
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.mZeusWebView != null ? this.mZeusWebView.getHttpAuthUsernamePassword(str, str2) : this.mSysWebView.getHttpAuthUsernamePassword(str, str2);
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setMapTrackballToArrowKeys(z);
        } else {
            this.mSysWebView.setMapTrackballToArrowKeys(z);
        }
    }

    public void setScrollbarFadingEnabled(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setScrollbarFadingEnabled(z);
        } else {
            this.mSysWebView.setScrollbarFadingEnabled(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.mSysWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void disableZoomButtonsController() {
        BdWebSettings settings = getSettings();
        if (this.mZeusWebView != null) {
            settings.setBuiltInZoomControls(false);
            return;
        }
        settings.setBuiltInZoomControls(true);
        this.mSysWebView.setDisplayZoomControls(false);
    }

    public void setFindIsUp(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setFindIsUp(z);
        } else {
            this.mSysWebView.setFindIsUp(z);
        }
    }

    public boolean isMobileSite() {
        return this.mZeusWebView != null ? this.mZeusWebView.isMobileSite() : this.mSysWebView.isMobileSite();
    }

    public boolean notifyNativeExitFullScreenIfNeeded(int i) {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.notifyNativeExitFullScreenIfNeeded(i);
        }
        return false;
    }

    public Bitmap capturePicture(int i, int i2) {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.capturePictureZeus(i, i2);
        }
        return null;
    }

    public void emulateShiftHeldOnLink() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.emulateShiftHeldOnLink();
        }
    }

    public boolean isWapAllowScale() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.ifWapAllowScale();
        }
        return true;
    }

    public void pageVisibilityChange(int i, boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.pageVisibilityChange(i, z);
        }
    }

    public void setWebViewVisible(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setWebViewVisible(z);
        }
    }

    public Bitmap getCanvasCacheBmp() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.getCanvasCacheBmp();
        }
        return null;
    }

    public void destroyCanvasCacheBmp() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.destroyCanvasCacheBmp();
        }
    }

    public void setWebViewType(WebView.WebViewType webViewType) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setWebViewType(webViewType);
        }
    }

    public int getActionNodesCount() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.getActionNodesCount();
        }
        return 0;
    }

    public void onClickActionNode(int i) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.onClickActionNode(i);
        }
    }

    public String getActionNodeText(int i) {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.getActionNodeText(i);
        }
        return null;
    }

    public void startPreviewZoomScale() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.startPreviewZoomScale();
        }
    }

    public void setBeginScale() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setBeginScale();
        }
    }

    public void setEndScale() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setEndScale();
        }
    }

    public float getCurrentScale() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.getCurrentScale();
        }
        return 0.0f;
    }

    public void setPreviewZoomScale(float f) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setPreviewZoomScale(f);
        }
    }

    public float getActualZoomScale() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.getActualZoomScale();
        }
        return 0.0f;
    }

    public int getLastSubjectClickIndex() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.getLastSubjectClickIndex();
        }
        return -1;
    }

    public void setSubjectNeedScrollOnload(int i) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setSubjectNeedScrollOnload(i);
        }
    }

    public void resumeWebkitDraw() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.resumeWebkitDraw();
        }
    }

    public void pauseWebkitDraw() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.pauseWebkitDraw();
        }
    }

    public boolean isNeedToFindTreasure() {
        if (this.mZeusWebView != null) {
            return this.mZeusWebView.ifNeedToFindTreasure();
        }
        return false;
    }

    public void exitFullScreenMode() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.exitFullScreenMode();
        }
    }

    public void setWebViewAction(WebView.WebViewAction webViewAction) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setWebViewAction(webViewAction);
        }
    }

    public void setEnableSelectText(boolean z) {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.setEnableSelectText(z);
        }
    }

    public void selectionDone() {
        if (this.mZeusWebView != null) {
            this.mZeusWebView.selectionDone();
        }
    }
}
