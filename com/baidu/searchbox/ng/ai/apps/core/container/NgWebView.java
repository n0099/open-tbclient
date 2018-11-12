package com.baidu.searchbox.ng.ai.apps.core.container;

import android.content.Context;
import android.support.annotation.MainThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.a;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NgWebView extends BdSailorWebView implements CallbackHandler, SlideInterceptor {
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    private static final boolean DEBUG = false;
    private static final String TAG = "NgWebView";
    private OnCommonEventHandler mCommonEventHandler;
    private OnWebViewHookHandler mWebViewHookHandler;

    /* loaded from: classes2.dex */
    public interface OnCommonEventHandler {
        boolean dispatchTouchEvent(MotionEvent motionEvent);

        boolean onKeyDown(int i, KeyEvent keyEvent);

        void onScrollChanged(int i, int i2, int i3, int i4);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface OnWebViewHookHandler {
        boolean hookCanGoBack(boolean z);

        void hookGoBack();
    }

    @DebugTrace
    public NgWebView(Context context) {
        super(context);
        init(context);
    }

    @DebugTrace
    public NgWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @DebugTrace
    public NgWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @DebugTrace
    private void init(Context context) {
        disableFeature("WEBVIEWPAGER");
        disableControls();
    }

    private void disableControls() {
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView
    @DebugTrace
    public void destroy() {
        super.destroy();
    }

    public void destroyWithoutCreate() {
        super.destroy();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView
    public boolean canGoBack() {
        boolean canGoBack = super.canGoBack();
        if (this.mWebViewHookHandler != null) {
            return this.mWebViewHookHandler.hookCanGoBack(canGoBack);
        }
        return canGoBack;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView
    public void goBack() {
        if (this.mWebViewHookHandler != null) {
            this.mWebViewHookHandler.hookGoBack();
        }
        super.goBack();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!getCurrentWebView().isFocused()) {
            getCurrentWebView().requestFocus();
        }
        if (this.mCommonEventHandler != null && this.mCommonEventHandler.onTouchEvent(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mCommonEventHandler == null || !this.mCommonEventHandler.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        return this.mCommonEventHandler != null && this.mCommonEventHandler.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mCommonEventHandler != null) {
            this.mCommonEventHandler.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(final String str, final String str2) {
        post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.1
            @Override // java.lang.Runnable
            public void run() {
                String quote;
                if (!NgWebView.this.isDestroyed()) {
                    if (TextUtils.isEmpty(str2)) {
                        quote = "";
                    } else {
                        quote = JSONObject.quote(str2);
                    }
                    NgWebView.this.evaluateJavascript("javascript:" + str + "(" + quote + ")", null);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    @MainThread
    public String getCurrentPageUrl() {
        return getUrl();
    }

    public void setOnCommonEventHandler(OnCommonEventHandler onCommonEventHandler) {
        this.mCommonEventHandler = onCommonEventHandler;
    }

    public void setOnWebViewHookHandler(OnWebViewHookHandler onWebViewHookHandler) {
        this.mWebViewHookHandler = onWebViewHookHandler;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return getCurrentWebView().getTouchMode() == 6;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        WebView currentWebView = getCurrentWebView();
        if (currentWebView == null) {
            return false;
        }
        if (a.qV()) {
            return currentWebView.canScrollVertically(i);
        }
        return currentWebView.getWebView() != null && currentWebView.getWebView().canScrollVertically(i);
    }
}
