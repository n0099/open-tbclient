package com.baidu.swan.apps.core.container;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes10.dex */
public class NgWebView extends BdSailorWebView implements SlideInterceptor, d, SwanAppSelectPopView.a {
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = "NgWebView";
    private b mCommonEventHandler;
    private SwanAppSelectPopView mSelectPopWindow;
    private SwanAppSelectPopView.a mSelectPopWindowListener;
    private c mWebViewHookHandler;
    private e mWebViewManager;

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.swan.apps.adaptation.b.d
    public /* bridge */ /* synthetic */ AbsoluteLayout getCurrentWebView() {
        return super.getCurrentWebView();
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
        disableFeature(BdSailorConfig.SAILOR_EXT_WEBVIEWPAGER);
        disableControls();
    }

    private void disableControls() {
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.swan.apps.adaptation.b.d
    @DebugTrace
    public void destroy() {
        if (DEBUG) {
            Log.d(TAG, "destroy start");
        }
        super.destroy();
        if (DEBUG) {
            Log.d(TAG, "destroy end");
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.d
    public View covertToView() {
        return this;
    }

    @Override // com.baidu.swan.apps.adaptation.b.d
    public int getWebViewScrollX() {
        return getCurrentWebView().getWebViewScrollX();
    }

    @Override // com.baidu.swan.apps.adaptation.b.d
    public int getWebViewScrollY() {
        return getCurrentWebView().getWebViewScrollY();
    }

    @Override // com.baidu.swan.apps.adaptation.b.d
    public void webViewScrollTo(int i, int i2) {
        getCurrentWebView().scrollTo(i, i2);
    }

    public void webViewScrollBy(int i, int i2) {
        getCurrentWebView().scrollBy(i, i2);
    }

    public void destroyWithoutCreate() {
        super.destroy();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.swan.apps.adaptation.b.d
    public boolean canGoBack() {
        boolean canGoBack = super.canGoBack();
        if (this.mWebViewHookHandler != null) {
            return this.mWebViewHookHandler.cd(canGoBack);
        }
        return canGoBack;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.swan.apps.adaptation.b.d
    public void goBack() {
        if (this.mWebViewHookHandler == null || !this.mWebViewHookHandler.KD()) {
            super.goBack();
        }
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
            if (DEBUG) {
                Log.d(TAG, "final event = " + motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            if (!DEBUG) {
                return false;
            }
            e.printStackTrace();
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

    public void setOnCommonEventHandler(b bVar) {
        this.mCommonEventHandler = bVar;
    }

    public void setOnWebViewHookHandler(c cVar) {
        this.mWebViewHookHandler = cVar;
    }

    public void setWebViewManager(e eVar) {
        this.mWebViewManager = eVar;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return getCurrentWebView().getTouchMode() == 6;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (BdZeusUtil.isWebkitLoaded()) {
            WebView currentWebView = getCurrentWebView();
            if (currentWebView != null) {
                return currentWebView.canScrollVertically(i);
            }
        } else {
            AbsoluteLayout webViewImpl = getWebViewImpl();
            if (webViewImpl != null) {
                return webViewImpl.canScrollVertically(i);
            }
        }
        return false;
    }

    public void setBackgroundColorForSwanApp(@ColorInt int i) {
        AbsoluteLayout webViewImpl;
        setBackgroundColor(i);
        if (!BdZeusUtil.isWebkitLoaded() && (webViewImpl = getWebViewImpl()) != null) {
            webViewImpl.setBackgroundColor(i);
        }
    }

    @Nullable
    public AbsoluteLayout getWebViewImpl() {
        WebView currentWebView = getCurrentWebView();
        if (currentWebView != null) {
            return currentWebView.getWebView();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isWebView() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void onJSLoaded() {
        if (this.mWebViewManager != null) {
            this.mWebViewManager.onJSLoaded();
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        if (this.mSelectPopWindowListener != null) {
            this.mSelectPopWindowListener.doSelectionCopy(str);
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        if (this.mSelectPopWindowListener != null) {
            this.mSelectPopWindowListener.doSelectionSearch(str);
        }
    }

    public void doSelectionCancel() {
        hidePopWindow();
        getWebViewExt().completeSelectionExt();
    }

    public void setSelectPopWindowListener(SwanAppSelectPopView.a aVar) {
        this.mSelectPopWindowListener = aVar;
    }

    @DebugTrace
    private void tryInitSelectPopupWindow(boolean z) {
        if (this.mSelectPopWindow == null) {
            this.mSelectPopWindow = (SwanAppSelectPopView) LayoutInflater.from(getContext()).inflate(a.g.swanapp_webview_select_view, (ViewGroup) null);
            if (z) {
                this.mSelectPopWindow.findViewById(a.f.select_separator_one).setVisibility(8);
                this.mSelectPopWindow.findViewById(a.f.btn_wv_search).setVisibility(8);
            }
            getCurrentWebView().addView(this.mSelectPopWindow, new AbsoluteLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2)));
            this.mSelectPopWindow.setEventListener(this);
            this.mSelectPopWindow.setBackgroundResource(a.e.swanapp_browser_select_menu_down_bg);
            this.mSelectPopWindow.setVisibility(4);
        }
    }

    public void updateAndShowPopupWindow(int i, int i2, int i3, int i4, String str, boolean z) {
        if (DEBUG) {
            Log.d(TAG, "updateAndShowPopupWindow left: " + i + " right: " + i2 + " top: " + i3 + " bottom: " + i4);
        }
        tryInitSelectPopupWindow(z);
        if (this.mSelectPopWindow == null) {
            if (DEBUG) {
                throw new RuntimeException("update before init");
            }
            return;
        }
        this.mSelectPopWindow.setPopLeftX(i);
        this.mSelectPopWindow.setPopRightX(i2);
        this.mSelectPopWindow.setPopTopY(i3);
        this.mSelectPopWindow.setPopBottomY(i4);
        this.mSelectPopWindow.setSelection(str);
        if (this.mSelectPopWindow.getWidth() == 0 || this.mSelectPopWindow.getHeight() == 0) {
            post(new Runnable() { // from class: com.baidu.swan.apps.core.container.NgWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    NgWebView.this.calcPopWindowPos(NgWebView.this.mSelectPopWindow);
                    NgWebView.this.showPopWindow();
                }
            });
            return;
        }
        calcPopWindowPos(this.mSelectPopWindow);
        showPopWindow();
    }

    public void hidePopWindow() {
        if (this.mSelectPopWindow != null) {
            this.mSelectPopWindow.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopWindow() {
        if (this.mSelectPopWindow == null) {
            if (DEBUG) {
                throw new RuntimeException("show before init");
            }
            return;
        }
        this.mSelectPopWindow.setVisibility(0);
        int popX = this.mSelectPopWindow.getPopX();
        int popY = this.mSelectPopWindow.getPopY();
        ViewGroup.LayoutParams layoutParams = this.mSelectPopWindow.getLayoutParams();
        if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
            ((AbsoluteLayout.LayoutParams) layoutParams).x = popX;
            ((AbsoluteLayout.LayoutParams) layoutParams).y = popY;
        }
        this.mSelectPopWindow.layout(popX, popY, this.mSelectPopWindow.getMeasuredWidth() + popX, this.mSelectPopWindow.getMeasuredHeight() + popY);
        if (DEBUG) {
            Log.d(TAG, "showPopWindow left: " + popX + " top: " + popY + " width: " + this.mSelectPopWindow.getWidth() + " height: " + this.mSelectPopWindow.getHeight() + " measure width: " + this.mSelectPopWindow.getMeasuredWidth() + " measure height: " + this.mSelectPopWindow.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calcPopWindowPos(@NonNull SwanAppSelectPopView swanAppSelectPopView) {
        int S;
        int popLeftX = swanAppSelectPopView.getPopLeftX();
        int popRightX = swanAppSelectPopView.getPopRightX();
        int popTopY = swanAppSelectPopView.getPopTopY();
        int popBottomY = swanAppSelectPopView.getPopBottomY();
        int scrollX = getCurrentWebView().getScrollX();
        int scrollY = getCurrentWebView().getScrollY();
        if (popLeftX <= popRightX) {
            popRightX = popLeftX;
            popLeftX = popRightX;
        }
        if (popTopY <= popBottomY) {
            popBottomY = popTopY;
            popTopY = popBottomY;
        }
        if (DEBUG) {
            Log.d(TAG, popRightX + ", " + popLeftX + ", " + popBottomY + ", " + popTopY);
        }
        int measuredWidth = swanAppSelectPopView.getMeasuredWidth();
        int width = getCurrentWebView().getWidth();
        int i = ((popLeftX + popRightX) - measuredWidth) / 2;
        if (i + measuredWidth > width) {
            i = width - measuredWidth;
        }
        if (i < 0) {
            i = 0;
        }
        int measuredHeight = swanAppSelectPopView.getMeasuredHeight();
        int height = getCurrentWebView().getHeight();
        int S2 = af.S(22.0f) + measuredHeight;
        int i2 = popBottomY - S2;
        if (i2 < 0) {
            S = af.S(22.0f) + popTopY;
            swanAppSelectPopView.setBackgroundResource(a.e.swanapp_browser_select_menu_up_bg);
        } else {
            S = i2 + af.S(22.0f);
            swanAppSelectPopView.setBackgroundResource(a.e.swanapp_browser_select_menu_down_bg);
        }
        int i3 = S + S2 > height ? (popTopY - popBottomY) - S2 : S;
        swanAppSelectPopView.setPopX(i + scrollX);
        swanAppSelectPopView.setPopY(i3 + scrollY);
        if (DEBUG) {
            Log.d(TAG, i + ", " + i3);
        }
    }

    @Override // com.baidu.swan.apps.core.container.a
    public String getContainerId() {
        return this.mWebViewManager != null ? this.mWebViewManager.GA() : "";
    }
}
