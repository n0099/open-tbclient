package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
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
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f.e.c;
import c.a.p0.a.f.e.d;
import c.a.p0.a.p2.n0;
import c.a.p0.a.x.f.b;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public class NgWebView extends BdSailorWebView implements c, SlideInterceptor, SwanAppSelectPopView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    public static final boolean DEBUG;
    public static final String TAG = "NgWebView";
    public transient /* synthetic */ FieldHolder $fh;
    public b mCommonEventHandler;
    public SwanAppSelectPopView mSelectPopWindow;
    public SwanAppSelectPopView.a mSelectPopWindowListener;
    public c.a.p0.a.x.f.c mWebViewHookHandler;
    public d mWebViewManager;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NgWebView f37420e;

        public a(NgWebView ngWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ngWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37420e = ngWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NgWebView ngWebView = this.f37420e;
                ngWebView.calcPopWindowPos(ngWebView.mSelectPopWindow);
                this.f37420e.showPopWindow();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(652858380, "Lcom/baidu/swan/apps/core/container/NgWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(652858380, "Lcom/baidu/swan/apps/core/container/NgWebView;");
                return;
            }
        }
        DEBUG = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @DebugTrace
    public NgWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calcPopWindowPos(@NonNull SwanAppSelectPopView swanAppSelectPopView) {
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, swanAppSelectPopView) == null) {
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
                String str = popLeftX + StringUtil.ARRAY_ELEMENT_SEPARATOR + popRightX + StringUtil.ARRAY_ELEMENT_SEPARATOR + popTopY + StringUtil.ARRAY_ELEMENT_SEPARATOR + popBottomY;
            }
            int measuredWidth = swanAppSelectPopView.getMeasuredWidth();
            int width = getCurrentWebView().getWidth();
            int i2 = ((popLeftX + popRightX) - measuredWidth) / 2;
            if (i2 + measuredWidth > width) {
                i2 = width - measuredWidth;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int measuredHeight = swanAppSelectPopView.getMeasuredHeight();
            int height = getCurrentWebView().getHeight();
            int g3 = measuredHeight + n0.g(22.0f);
            int i3 = popTopY - g3;
            if (i3 < 0) {
                g2 = n0.g(22.0f) + popBottomY;
                swanAppSelectPopView.setBackgroundResource(R.drawable.swanapp_browser_select_menu_up_bg);
            } else {
                g2 = n0.g(22.0f) + i3;
                swanAppSelectPopView.setBackgroundResource(R.drawable.swanapp_browser_select_menu_down_bg);
            }
            if (g2 + g3 > height) {
                g2 = (popBottomY - popTopY) - g3;
            }
            swanAppSelectPopView.setPopX(scrollX + i2);
            swanAppSelectPopView.setPopY(scrollY + g2);
            if (DEBUG) {
                String str2 = i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + g2;
            }
        }
    }

    private void disableControls() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            getSettings().setBuiltInZoomControls(true);
            getSettings().setDisplayZoomControls(false);
        }
    }

    @DebugTrace
    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            c.a.p0.a.p2.b.a(this);
            disableFeature(BdSailorConfig.SAILOR_EXT_WEBVIEWPAGER);
            disableControls();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BDThrowableCheck"})
    public void showPopWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
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
                String str = "showPopWindow left: " + popX + " top: " + popY + " width: " + this.mSelectPopWindow.getWidth() + " height: " + this.mSelectPopWindow.getHeight() + " measure width: " + this.mSelectPopWindow.getMeasuredWidth() + " measure height: " + this.mSelectPopWindow.getMeasuredHeight();
            }
        }
    }

    @DebugTrace
    private void tryInitSelectPopupWindow(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65547, this, z) == null) && this.mSelectPopWindow == null) {
            SwanAppSelectPopView swanAppSelectPopView = (SwanAppSelectPopView) LayoutInflater.from(getContext()).inflate(R.layout.swanapp_webview_select_view, (ViewGroup) null);
            this.mSelectPopWindow = swanAppSelectPopView;
            if (z) {
                swanAppSelectPopView.findViewById(R.id.select_separator_one).setVisibility(8);
                this.mSelectPopWindow.findViewById(R.id.btn_wv_search).setVisibility(8);
            }
            getCurrentWebView().addView(this.mSelectPopWindow, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(-2, -2)));
            this.mSelectPopWindow.setEventListener(this);
            this.mSelectPopWindow.setBackgroundResource(R.drawable.swanapp_browser_select_menu_down_bg);
            this.mSelectPopWindow.setVisibility(4);
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, c.a.p0.a.f.e.c
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean canGoBack = super.canGoBack();
            c.a.p0.a.x.f.c cVar = this.mWebViewHookHandler;
            return cVar != null ? cVar.v(canGoBack) : canGoBack;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (BdZeusUtil.isWebkitLoaded()) {
                WebView currentWebView = getCurrentWebView();
                if (currentWebView != null) {
                    return currentWebView.canScrollVertically(i2);
                }
                return false;
            }
            View webViewImpl = getWebViewImpl();
            if (webViewImpl != null) {
                return webViewImpl.canScrollVertically(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.a.p0.a.x.f.a
    public synchronized void continueTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!isDestroyed()) {
                    c.a.p0.a.u.d.i(TAG, "continueTimer: for=" + this);
                    onResume();
                    resumeTimers();
                }
            }
        }
    }

    @Override // c.a.p0.a.f.e.c
    public View covertToView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, c.a.p0.a.f.e.c
    @DebugTrace
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = DEBUG;
            super.destroy();
            boolean z2 = DEBUG;
        }
    }

    public void destroyWithoutCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.destroy();
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4) {
                return false;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            b bVar = this.mCommonEventHandler;
            if (bVar == null || !bVar.dispatchTouchEvent(motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void doSelectionCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hidePopWindow();
            getWebViewExt().completeSelectionExt();
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        SwanAppSelectPopView.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (aVar = this.mSelectPopWindowListener) == null) {
            return;
        }
        aVar.doSelectionCopy(str);
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        SwanAppSelectPopView.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.mSelectPopWindowListener) == null) {
            return;
        }
        aVar.doSelectionSearch(str);
    }

    @Override // c.a.p0.a.x.f.a
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d dVar = this.mWebViewManager;
            return dVar != null ? dVar.c() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, c.a.p0.a.f.e.c
    public /* bridge */ /* synthetic */ View getCurrentWebView() {
        return super.getCurrentWebView();
    }

    @Nullable
    public View getWebViewImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            WebView currentWebView = getCurrentWebView();
            if (currentWebView != null) {
                return currentWebView.getWebView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.a.f.e.c
    public int getWebViewScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getCurrentWebView().getWebViewScrollX() : invokeV.intValue;
    }

    @Override // c.a.p0.a.f.e.c
    public int getWebViewScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getCurrentWebView().getWebViewScrollY() : invokeV.intValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, c.a.p0.a.f.e.c
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.p0.a.x.f.c cVar = this.mWebViewHookHandler;
            if (cVar == null || !cVar.p()) {
                super.goBack();
            }
        }
    }

    public void hidePopWindow() {
        SwanAppSelectPopView swanAppSelectPopView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (swanAppSelectPopView = this.mSelectPopWindow) == null) {
            return;
        }
        swanAppSelectPopView.setVisibility(8);
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) ? getCurrentWebView().getTouchMode() == 6 : invokeL.booleanValue;
    }

    public boolean isSwanWebMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d dVar = this.mWebViewManager;
            if (dVar == null || dVar.I() == null) {
                return false;
            }
            return this.mWebViewManager.I().f37419b;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.f.a
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.f.a
    public void onJSLoaded() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (dVar = this.mWebViewManager) == null) {
            return;
        }
        dVar.onJSLoaded();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, keyEvent)) == null) {
            if (super.onKeyDown(i2, keyEvent)) {
                return true;
            }
            b bVar = this.mCommonEventHandler;
            return bVar != null && bVar.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            b bVar = this.mCommonEventHandler;
            if (bVar != null) {
                bVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (DEBUG) {
                String str = "onSizeChanged - w:" + i2 + " h:" + i3 + " oldW:" + i4 + " oldH:" + i5;
            }
            setDefaultViewSize(i2, i3, null);
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            if (!getCurrentWebView().isFocused()) {
                getCurrentWebView().requestFocus();
            }
            b bVar = this.mCommonEventHandler;
            if (bVar == null || !bVar.onTouchEvent(motionEvent)) {
                try {
                    if (DEBUG) {
                        String str = "final event = " + motionEvent;
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
        return invokeL.booleanValue;
    }

    public void setBackgroundColorForSwanApp(@ColorInt int i2) {
        View webViewImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            setBackgroundColor(i2);
            if (BdZeusUtil.isWebkitLoaded() || (webViewImpl = getWebViewImpl()) == null) {
                return;
            }
            webViewImpl.setBackgroundColor(i2);
        }
    }

    @Override // c.a.p0.a.f.e.c
    public void setDefaultViewSize(int i2, int i3, String str) {
        int i4;
        Pair<Integer, Integer> pair;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048603, this, i2, i3, str) == null) {
            if (i3 == Integer.MIN_VALUE) {
                pair = n0.e(str);
                i4 = ((Integer) pair.second).intValue();
            } else {
                i4 = i3;
                pair = null;
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = pair != null ? ((Integer) pair.first).intValue() : n0.o(AppRuntime.getAppContext());
            }
            if (i2 <= 0 || i4 <= 0) {
                return;
            }
            if (DEBUG) {
                String str2 = "setDefaultViewSize W:" + i2 + " H:" + i4;
            }
            getWebViewExt().setDefaultViewSizeExt(i2, i4);
        }
    }

    public void setOnCommonEventHandler(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.mCommonEventHandler = bVar;
        }
    }

    public void setOnWebViewHookHandler(c.a.p0.a.x.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            this.mWebViewHookHandler = cVar;
        }
    }

    public void setSelectPopWindowListener(SwanAppSelectPopView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, aVar) == null) {
            this.mSelectPopWindowListener = aVar;
        }
    }

    public void setWebViewManager(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, dVar) == null) {
            this.mWebViewManager = dVar;
        }
    }

    @Override // c.a.p0.a.x.f.a
    public synchronized void suspendTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            synchronized (this) {
                if (!isDestroyed()) {
                    c.a.p0.a.u.d.i(TAG, "suspendTimer: for=" + this);
                    pauseTimers();
                    onPause();
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void updateAndShowPopupWindow(int i2, int i3, int i4, int i5, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
            if (DEBUG) {
                String str2 = "updateAndShowPopupWindow left: " + i2 + " right: " + i3 + " top: " + i4 + " bottom: " + i5;
            }
            tryInitSelectPopupWindow(z);
            SwanAppSelectPopView swanAppSelectPopView = this.mSelectPopWindow;
            if (swanAppSelectPopView == null) {
                if (DEBUG) {
                    throw new RuntimeException("update before init");
                }
                return;
            }
            swanAppSelectPopView.setPopLeftX(i2);
            this.mSelectPopWindow.setPopRightX(i3);
            this.mSelectPopWindow.setPopTopY(i4);
            this.mSelectPopWindow.setPopBottomY(i5);
            this.mSelectPopWindow.setSelection(str);
            if (this.mSelectPopWindow.getWidth() != 0 && this.mSelectPopWindow.getHeight() != 0) {
                calcPopWindowPos(this.mSelectPopWindow);
                showPopWindow();
                return;
            }
            post(new a(this));
        }
    }

    public void webViewScrollBy(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i2, i3) == null) {
            getCurrentWebView().scrollBy(i2, i3);
        }
    }

    @Override // c.a.p0.a.f.e.c
    public void webViewScrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            getCurrentWebView().scrollTo(i2, i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @DebugTrace
    public NgWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @DebugTrace
    public NgWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        init(context);
    }
}
