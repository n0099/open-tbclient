package com.baidu.swan.apps.core.container;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.webkit.sdk.WebView;
import d.b.h0.a.e;
import d.b.h0.a.e0.k.b;
import d.b.h0.a.f;
import d.b.h0.a.g;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import d.b.h0.a.p.d.c;
import d.b.h0.a.p.d.d;
/* loaded from: classes2.dex */
public class NgWebView extends BdSailorWebView implements c, SlideInterceptor, SwanAppSelectPopView.a {
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    public static final boolean DEBUG = k.f45772a;
    public static final String TAG = "NgWebView";
    public static final String WEBVIEW_SIZE_SWITCH = "swan_app_set_webview_size_switch";
    public static final boolean sIsSetWebViewSize;
    public b mCommonEventHandler;
    public SwanAppSelectPopView mSelectPopWindow;
    public SwanAppSelectPopView.a mSelectPopWindowListener;
    public d.b.h0.a.e0.k.c mWebViewHookHandler;
    public d mWebViewManager;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NgWebView ngWebView = NgWebView.this;
            ngWebView.calcPopWindowPos(ngWebView.mSelectPopWindow);
            NgWebView.this.showPopWindow();
        }
    }

    static {
        d.b.h0.a.w0.a.N().getSwitch(WEBVIEW_SIZE_SWITCH, false);
        sIsSetWebViewSize = false;
    }

    @DebugTrace
    public NgWebView(Context context) {
        super(context);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calcPopWindowPos(@NonNull SwanAppSelectPopView swanAppSelectPopView) {
        int f2;
        int popLeftX = swanAppSelectPopView.getPopLeftX();
        int popRightX = swanAppSelectPopView.getPopRightX();
        int popTopY = swanAppSelectPopView.getPopTopY();
        int popBottomY = swanAppSelectPopView.getPopBottomY();
        int scrollX = getCurrentWebView().getScrollX();
        int scrollY = getCurrentWebView().getScrollY();
        if (popLeftX > popRightX) {
            popRightX = popLeftX;
            popLeftX = popRightX;
        }
        if (popTopY > popBottomY) {
            popBottomY = popTopY;
            popTopY = popBottomY;
        }
        if (DEBUG) {
            Log.d(TAG, popLeftX + StringUtil.ARRAY_ELEMENT_SEPARATOR + popRightX + StringUtil.ARRAY_ELEMENT_SEPARATOR + popTopY + StringUtil.ARRAY_ELEMENT_SEPARATOR + popBottomY);
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
        int f3 = measuredHeight + h0.f(22.0f);
        int i2 = popTopY - f3;
        if (i2 < 0) {
            f2 = h0.f(22.0f) + popBottomY;
            swanAppSelectPopView.setBackgroundResource(e.swanapp_browser_select_menu_up_bg);
        } else {
            f2 = h0.f(22.0f) + i2;
            swanAppSelectPopView.setBackgroundResource(e.swanapp_browser_select_menu_down_bg);
        }
        if (f2 + f3 > height) {
            f2 = (popBottomY - popTopY) - f3;
        }
        swanAppSelectPopView.setPopX(scrollX + i);
        swanAppSelectPopView.setPopY(scrollY + f2);
        if (DEBUG) {
            Log.d(TAG, i + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2);
        }
    }

    private void disableControls() {
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
    }

    @DebugTrace
    private void init(Context context) {
        d.b.h0.a.i2.a.a(this);
        disableFeature(BdSailorConfig.SAILOR_EXT_WEBVIEWPAGER);
        disableControls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopWindow() {
        SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
        if (swanAppSelectPopView == null) {
            if (DEBUG) {
                throw new RuntimeException("show before init");
            }
            return;
        }
        swanAppSelectPopView.setVisibility(0);
        int popX = this.mSelectPopWindow.getPopX();
        int popY = this.mSelectPopWindow.getPopY();
        ViewGroup.LayoutParams layoutParams = this.mSelectPopWindow.getLayoutParams();
        if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
            AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) layoutParams;
            layoutParams2.x = popX;
            layoutParams2.y = popY;
        }
        SwanAppSelectPopView swanAppSelectPopView2 = this.mSelectPopWindow;
        swanAppSelectPopView2.layout(popX, popY, swanAppSelectPopView2.getMeasuredWidth() + popX, this.mSelectPopWindow.getMeasuredHeight() + popY);
        if (DEBUG) {
            Log.d(TAG, "showPopWindow left: " + popX + " top: " + popY + " width: " + this.mSelectPopWindow.getWidth() + " height: " + this.mSelectPopWindow.getHeight() + " measure width: " + this.mSelectPopWindow.getMeasuredWidth() + " measure height: " + this.mSelectPopWindow.getMeasuredHeight());
        }
    }

    @DebugTrace
    private void tryInitSelectPopupWindow(boolean z) {
        if (this.mSelectPopWindow == null) {
            SwanAppSelectPopView swanAppSelectPopView = (SwanAppSelectPopView) LayoutInflater.from(getContext()).inflate(g.swanapp_webview_select_view, (ViewGroup) null);
            this.mSelectPopWindow = swanAppSelectPopView;
            if (z) {
                swanAppSelectPopView.findViewById(f.select_separator_one).setVisibility(8);
                this.mSelectPopWindow.findViewById(f.btn_wv_search).setVisibility(8);
            }
            getCurrentWebView().addView(this.mSelectPopWindow, new AbsoluteLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2)));
            this.mSelectPopWindow.setEventListener(this);
            this.mSelectPopWindow.setBackgroundResource(e.swanapp_browser_select_menu_down_bg);
            this.mSelectPopWindow.setVisibility(4);
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, d.b.h0.a.p.d.c
    public boolean canGoBack() {
        boolean canGoBack = super.canGoBack();
        d.b.h0.a.e0.k.c cVar = this.mWebViewHookHandler;
        return cVar != null ? cVar.N(canGoBack) : canGoBack;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (BdZeusUtil.isWebkitLoaded()) {
            WebView currentWebView = getCurrentWebView();
            if (currentWebView != null) {
                return currentWebView.canScrollVertically(i);
            }
            return false;
        }
        AbsoluteLayout webViewImpl = getWebViewImpl();
        if (webViewImpl != null) {
            return webViewImpl.canScrollVertically(i);
        }
        return false;
    }

    @Override // d.b.h0.a.p.d.c
    public View covertToView() {
        return this;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, d.b.h0.a.p.d.c
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

    public void destroyWithoutCreate() {
        super.destroy();
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
        b bVar = this.mCommonEventHandler;
        if (bVar == null || !bVar.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void doSelectionCancel() {
        hidePopWindow();
        getWebViewExt().completeSelectionExt();
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        SwanAppSelectPopView.a aVar = this.mSelectPopWindowListener;
        if (aVar != null) {
            aVar.doSelectionCopy(str);
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        SwanAppSelectPopView.a aVar = this.mSelectPopWindowListener;
        if (aVar != null) {
            aVar.doSelectionSearch(str);
        }
    }

    @Override // d.b.h0.a.e0.k.a
    public String getContainerId() {
        d dVar = this.mWebViewManager;
        return dVar != null ? dVar.c() : "";
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, d.b.h0.a.p.d.c
    public /* bridge */ /* synthetic */ AbsoluteLayout getCurrentWebView() {
        return super.getCurrentWebView();
    }

    @Nullable
    public AbsoluteLayout getWebViewImpl() {
        WebView currentWebView = getCurrentWebView();
        if (currentWebView != null) {
            return currentWebView.getWebView();
        }
        return null;
    }

    @Override // d.b.h0.a.p.d.c
    public int getWebViewScrollX() {
        return getCurrentWebView().getWebViewScrollX();
    }

    @Override // d.b.h0.a.p.d.c
    public int getWebViewScrollY() {
        return getCurrentWebView().getWebViewScrollY();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, d.b.h0.a.p.d.c
    public void goBack() {
        d.b.h0.a.e0.k.c cVar = this.mWebViewHookHandler;
        if (cVar == null || !cVar.u()) {
            super.goBack();
        }
    }

    public void hidePopWindow() {
        SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
        if (swanAppSelectPopView != null) {
            swanAppSelectPopView.setVisibility(8);
        }
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return getCurrentWebView().getTouchMode() == 6;
    }

    @Override // d.b.h0.a.e0.k.a
    public boolean isWebView() {
        return true;
    }

    @Override // d.b.h0.a.e0.k.a
    public void onJSLoaded() {
        d dVar = this.mWebViewManager;
        if (dVar != null) {
            dVar.onJSLoaded();
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        b bVar = this.mCommonEventHandler;
        return bVar != null && bVar.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        b bVar = this.mCommonEventHandler;
        if (bVar != null) {
            bVar.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (DEBUG) {
            Log.d(TAG, "onSizeChanged - w:" + i + " h:" + i2 + " oldW:" + i3 + " oldH:" + i4);
        }
        setDefaultViewSize(i, i2, null);
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!getCurrentWebView().isFocused()) {
            getCurrentWebView().requestFocus();
        }
        b bVar = this.mCommonEventHandler;
        if (bVar == null || !bVar.onTouchEvent(motionEvent)) {
            try {
                if (DEBUG) {
                    Log.d(TAG, "final event = " + motionEvent);
                }
                return super.onTouchEvent(motionEvent);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public void setBackgroundColorForSwanApp(@ColorInt int i) {
        AbsoluteLayout webViewImpl;
        setBackgroundColor(i);
        if (BdZeusUtil.isWebkitLoaded() || (webViewImpl = getWebViewImpl()) == null) {
            return;
        }
        webViewImpl.setBackgroundColor(i);
    }

    @Override // d.b.h0.a.p.d.c
    public void setDefaultViewSize(int i, int i2, String str) {
        if (sIsSetWebViewSize) {
            Pair<Integer, Integer> pair = null;
            if (i2 == Integer.MIN_VALUE) {
                pair = h0.d(str);
                i2 = ((Integer) pair.second).intValue();
            }
            if (i == Integer.MIN_VALUE) {
                i = pair != null ? ((Integer) pair.first).intValue() : h0.m(AppRuntime.getAppContext());
            }
            if (i <= 0 || i2 <= 0) {
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "setDefaultViewSize W:" + i + " H:" + i2);
            }
            getWebViewExt().setDefaultViewSizeExt(i, i2);
        }
    }

    public void setOnCommonEventHandler(b bVar) {
        this.mCommonEventHandler = bVar;
    }

    public void setOnWebViewHookHandler(d.b.h0.a.e0.k.c cVar) {
        this.mWebViewHookHandler = cVar;
    }

    public void setSelectPopWindowListener(SwanAppSelectPopView.a aVar) {
        this.mSelectPopWindowListener = aVar;
    }

    public void setWebViewManager(d dVar) {
        this.mWebViewManager = dVar;
    }

    public void updateAndShowPopupWindow(int i, int i2, int i3, int i4, String str, boolean z) {
        if (DEBUG) {
            Log.d(TAG, "updateAndShowPopupWindow left: " + i + " right: " + i2 + " top: " + i3 + " bottom: " + i4);
        }
        tryInitSelectPopupWindow(z);
        SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
        if (swanAppSelectPopView == null) {
            if (DEBUG) {
                throw new RuntimeException("update before init");
            }
            return;
        }
        swanAppSelectPopView.setPopLeftX(i);
        this.mSelectPopWindow.setPopRightX(i2);
        this.mSelectPopWindow.setPopTopY(i3);
        this.mSelectPopWindow.setPopBottomY(i4);
        this.mSelectPopWindow.setSelection(str);
        if (this.mSelectPopWindow.getWidth() != 0 && this.mSelectPopWindow.getHeight() != 0) {
            calcPopWindowPos(this.mSelectPopWindow);
            showPopWindow();
            return;
        }
        post(new a());
    }

    public void webViewScrollBy(int i, int i2) {
        getCurrentWebView().scrollBy(i, i2);
    }

    @Override // d.b.h0.a.p.d.c
    public void webViewScrollTo(int i, int i2) {
        getCurrentWebView().scrollTo(i, i2);
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
}
