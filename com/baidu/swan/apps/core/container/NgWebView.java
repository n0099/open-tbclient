package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.R;
import com.baidu.tieba.dn3;
import com.baidu.tieba.fx1;
import com.baidu.tieba.gx1;
import com.baidu.tieba.ir1;
import com.baidu.tieba.po3;
import com.baidu.tieba.x92;
import com.baidu.tieba.y72;
import com.baidu.tieba.y92;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public class NgWebView extends BdSailorWebView implements fx1, SlideInterceptor, SwanAppSelectPopView.a {
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    public static final boolean DEBUG = ir1.a;
    public static final String TAG = "NgWebView";
    public x92 mCommonEventHandler;
    public SwanAppSelectPopView mSelectPopWindow;
    public SwanAppSelectPopView.a mSelectPopWindowListener;
    public y92 mWebViewHookHandler;
    public gx1 mWebViewManager;

    @Override // com.baidu.tieba.fx1
    public View covertToView() {
        return this;
    }

    @Override // com.baidu.tieba.w92
    public boolean isWebView() {
        return true;
    }

    /* loaded from: classes4.dex */
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

    private void disableControls() {
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.tieba.fx1
    public boolean canGoBack() {
        boolean canGoBack = super.canGoBack();
        y92 y92Var = this.mWebViewHookHandler;
        if (y92Var != null) {
            return y92Var.t(canGoBack);
        }
        return canGoBack;
    }

    @Override // com.baidu.tieba.w92
    public synchronized void continueTimer() {
        if (!isDestroyed()) {
            y72.i(TAG, "continueTimer: for=" + this);
            onResume();
            resumeTimers();
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.tieba.fx1
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

    public void doSelectionCancel() {
        hidePopWindow();
        getWebViewExt().completeSelectionExt();
    }

    @Override // com.baidu.tieba.w92
    public String getContainerId() {
        gx1 gx1Var = this.mWebViewManager;
        if (gx1Var != null) {
            return gx1Var.a();
        }
        return "";
    }

    @Override // com.baidu.tieba.fx1
    public /* bridge */ /* synthetic */ View getCurrentWebView() {
        return super.getCurrentWebView();
    }

    @Nullable
    public View getWebViewImpl() {
        WebView currentWebView = getCurrentWebView();
        if (currentWebView != null) {
            return currentWebView.getWebView();
        }
        return null;
    }

    @Override // com.baidu.tieba.fx1
    public int getWebViewScrollX() {
        return getCurrentWebView().getWebViewScrollX();
    }

    @Override // com.baidu.tieba.fx1
    public int getWebViewScrollY() {
        return getCurrentWebView().getWebViewScrollY();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.baidu.tieba.fx1
    public void goBack() {
        y92 y92Var = this.mWebViewHookHandler;
        if (y92Var == null || !y92Var.n()) {
            super.goBack();
        }
    }

    public void hidePopWindow() {
        SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
        if (swanAppSelectPopView != null) {
            swanAppSelectPopView.setVisibility(8);
        }
    }

    public boolean isSwanWebMode() {
        gx1 gx1Var = this.mWebViewManager;
        if (gx1Var != null && gx1Var.getConfig() != null) {
            return this.mWebViewManager.getConfig().b;
        }
        return false;
    }

    @Override // com.baidu.tieba.w92
    public void onJSLoaded() {
        gx1 gx1Var = this.mWebViewManager;
        if (gx1Var != null) {
            gx1Var.onJSLoaded();
        }
    }

    @Override // com.baidu.tieba.w92
    public synchronized void suspendTimer() {
        if (!isDestroyed()) {
            y72.i(TAG, "suspendTimer: for=" + this);
            pauseTimers();
            onPause();
        }
    }

    @DebugTrace
    public NgWebView(Context context) {
        super(context);
        init(context);
    }

    @DebugTrace
    private void init(Context context) {
        dn3.a(this);
        disableFeature(BdSailorConfig.SAILOR_EXT_WEBVIEWPAGER);
        disableControls();
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
        View webViewImpl = getWebViewImpl();
        if (webViewImpl != null) {
            return webViewImpl.canScrollVertically(i);
        }
        return false;
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
        x92 x92Var = this.mCommonEventHandler;
        if (x92Var != null && x92Var.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
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

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (getCurrentWebView().getTouchMode() == 6) {
            return true;
        }
        return false;
    }

    public void setBackgroundColorForSwanApp(@ColorInt int i) {
        View webViewImpl;
        setBackgroundColor(i);
        if (!BdZeusUtil.isWebkitLoaded() && (webViewImpl = getWebViewImpl()) != null) {
            webViewImpl.setBackgroundColor(i);
        }
    }

    public void setOnCommonEventHandler(x92 x92Var) {
        this.mCommonEventHandler = x92Var;
    }

    public void setOnWebViewHookHandler(y92 y92Var) {
        this.mWebViewHookHandler = y92Var;
    }

    public void setSelectPopWindowListener(SwanAppSelectPopView.a aVar) {
        this.mSelectPopWindowListener = aVar;
    }

    public void setWebViewManager(gx1 gx1Var) {
        this.mWebViewManager = gx1Var;
    }

    @DebugTrace
    public NgWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        x92 x92Var = this.mCommonEventHandler;
        if (x92Var != null && x92Var.onKeyDown(i, keyEvent)) {
            return true;
        }
        return false;
    }

    public void webViewScrollBy(int i, int i2) {
        getCurrentWebView().scrollBy(i, i2);
    }

    @Override // com.baidu.tieba.fx1
    public void webViewScrollTo(int i, int i2) {
        getCurrentWebView().scrollTo(i, i2);
    }

    @DebugTrace
    public NgWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calcPopWindowPos(@NonNull SwanAppSelectPopView swanAppSelectPopView) {
        int g;
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
        int g2 = measuredHeight + po3.g(22.0f);
        int i2 = popTopY - g2;
        if (i2 < 0) {
            g = po3.g(22.0f) + popBottomY;
            swanAppSelectPopView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08144b);
        } else {
            g = po3.g(22.0f) + i2;
            swanAppSelectPopView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08144a);
        }
        if (g + g2 > height) {
            g = (popBottomY - popTopY) - g2;
        }
        swanAppSelectPopView.setPopX(scrollX + i);
        swanAppSelectPopView.setPopY(scrollY + g);
        if (DEBUG) {
            Log.d(TAG, i + StringUtil.ARRAY_ELEMENT_SEPARATOR + g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BDThrowableCheck"})
    public void showPopWindow() {
        SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
        if (swanAppSelectPopView == null) {
            if (!DEBUG) {
                return;
            }
            throw new RuntimeException("show before init");
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
            SwanAppSelectPopView swanAppSelectPopView = (SwanAppSelectPopView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0938, (ViewGroup) null);
            this.mSelectPopWindow = swanAppSelectPopView;
            if (z) {
                swanAppSelectPopView.findViewById(R.id.select_separator_one).setVisibility(8);
                this.mSelectPopWindow.findViewById(R.id.btn_wv_search).setVisibility(8);
            }
            getCurrentWebView().addView(this.mSelectPopWindow, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(-2, -2)));
            this.mSelectPopWindow.setEventListener(this);
            this.mSelectPopWindow.setBackgroundResource(R.drawable.obfuscated_res_0x7f08144a);
            this.mSelectPopWindow.setVisibility(4);
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        x92 x92Var = this.mCommonEventHandler;
        if (x92Var != null) {
            x92Var.onScrollChanged(i, i2, i3, i4);
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
        x92 x92Var = this.mCommonEventHandler;
        if (x92Var != null && x92Var.onTouchEvent(motionEvent)) {
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

    @Override // com.baidu.tieba.fx1
    public void setDefaultViewSize(int i, int i2, String str) {
        int i3;
        Pair<Integer, Integer> pair;
        if (i2 == Integer.MIN_VALUE) {
            pair = po3.e(str);
            i3 = ((Integer) pair.second).intValue();
        } else {
            i3 = i2;
            pair = null;
        }
        if (i == Integer.MIN_VALUE) {
            if (pair != null) {
                i = ((Integer) pair.first).intValue();
            } else {
                i = po3.o(AppRuntime.getAppContext());
            }
        }
        if (i > 0 && i3 > 0) {
            if (DEBUG) {
                Log.d(TAG, "setDefaultViewSize W:" + i + " H:" + i3);
            }
            getWebViewExt().setDefaultViewSizeExt(i, i3);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void updateAndShowPopupWindow(int i, int i2, int i3, int i4, String str, boolean z) {
        if (DEBUG) {
            Log.d(TAG, "updateAndShowPopupWindow left: " + i + " right: " + i2 + " top: " + i3 + " bottom: " + i4);
        }
        tryInitSelectPopupWindow(z);
        SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
        if (swanAppSelectPopView == null) {
            if (!DEBUG) {
                return;
            }
            throw new RuntimeException("update before init");
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
}
