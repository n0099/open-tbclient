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
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.gz1;
import com.repackage.hx1;
import com.repackage.hz1;
import com.repackage.mc3;
import com.repackage.om1;
import com.repackage.pm1;
import com.repackage.rg1;
import com.repackage.yd3;
/* loaded from: classes2.dex */
public class NgWebView extends BdSailorWebView implements om1, SlideInterceptor, SwanAppSelectPopView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    public static final boolean DEBUG;
    public static final String TAG = "NgWebView";
    public transient /* synthetic */ FieldHolder $fh;
    public gz1 mCommonEventHandler;
    public SwanAppSelectPopView mSelectPopWindow;
    public SwanAppSelectPopView.a mSelectPopWindowListener;
    public hz1 mWebViewHookHandler;
    public pm1 mWebViewManager;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NgWebView a;

        public a(NgWebView ngWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ngWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ngWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NgWebView ngWebView = this.a;
                ngWebView.calcPopWindowPos(ngWebView.mSelectPopWindow);
                this.a.showPopWindow();
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
        DEBUG = rg1.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        int g;
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
            int g2 = measuredHeight + yd3.g(22.0f);
            int i2 = popTopY - g2;
            if (i2 < 0) {
                g = yd3.g(22.0f) + popBottomY;
                swanAppSelectPopView.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810ff);
            } else {
                g = yd3.g(22.0f) + i2;
                swanAppSelectPopView.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810fe);
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
            mc3.a(this);
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
                Log.d(TAG, "showPopWindow left: " + popX + " top: " + popY + " width: " + this.mSelectPopWindow.getWidth() + " height: " + this.mSelectPopWindow.getHeight() + " measure width: " + this.mSelectPopWindow.getMeasuredWidth() + " measure height: " + this.mSelectPopWindow.getMeasuredHeight());
            }
        }
    }

    @DebugTrace
    private void tryInitSelectPopupWindow(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65547, this, z) == null) && this.mSelectPopWindow == null) {
            SwanAppSelectPopView swanAppSelectPopView = (SwanAppSelectPopView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07eb, (ViewGroup) null);
            this.mSelectPopWindow = swanAppSelectPopView;
            if (z) {
                swanAppSelectPopView.findViewById(R.id.obfuscated_res_0x7f091d0a).setVisibility(8);
                this.mSelectPopWindow.findViewById(R.id.obfuscated_res_0x7f09043c).setVisibility(8);
            }
            getCurrentWebView().addView(this.mSelectPopWindow, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(-2, -2)));
            this.mSelectPopWindow.setEventListener(this);
            this.mSelectPopWindow.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810fe);
            this.mSelectPopWindow.setVisibility(4);
        }
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.repackage.om1
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean canGoBack = super.canGoBack();
            hz1 hz1Var = this.mWebViewHookHandler;
            return hz1Var != null ? hz1Var.v(canGoBack) : canGoBack;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
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
        return invokeI.booleanValue;
    }

    @Override // com.repackage.fz1
    public synchronized void continueTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!isDestroyed()) {
                    hx1.i(TAG, "continueTimer: for=" + this);
                    onResume();
                    resumeTimers();
                }
            }
        }
    }

    @Override // com.repackage.om1
    public View covertToView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.repackage.om1
    @DebugTrace
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (DEBUG) {
                Log.d(TAG, "destroy start");
            }
            super.destroy();
            if (DEBUG) {
                Log.d(TAG, "destroy end");
            }
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
            gz1 gz1Var = this.mCommonEventHandler;
            if (gz1Var == null || !gz1Var.dispatchTouchEvent(motionEvent)) {
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

    @Override // com.repackage.fz1
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            pm1 pm1Var = this.mWebViewManager;
            return pm1Var != null ? pm1Var.b() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.repackage.om1
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

    @Override // com.repackage.om1
    public int getWebViewScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getCurrentWebView().getWebViewScrollX() : invokeV.intValue;
    }

    @Override // com.repackage.om1
    public int getWebViewScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getCurrentWebView().getWebViewScrollY() : invokeV.intValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, com.repackage.om1
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hz1 hz1Var = this.mWebViewHookHandler;
            if (hz1Var == null || !hz1Var.p()) {
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
            pm1 pm1Var = this.mWebViewManager;
            if (pm1Var == null || pm1Var.I() == null) {
                return false;
            }
            return this.mWebViewManager.I().b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fz1
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fz1
    public void onJSLoaded() {
        pm1 pm1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pm1Var = this.mWebViewManager) == null) {
            return;
        }
        pm1Var.onJSLoaded();
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, keyEvent)) == null) {
            if (super.onKeyDown(i, keyEvent)) {
                return true;
            }
            gz1 gz1Var = this.mCommonEventHandler;
            return gz1Var != null && gz1Var.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.browser.sailor.BdSailorWebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            gz1 gz1Var = this.mCommonEventHandler;
            if (gz1Var != null) {
                gz1Var.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (DEBUG) {
                Log.d(TAG, "onSizeChanged - w:" + i + " h:" + i2 + " oldW:" + i3 + " oldH:" + i4);
            }
            setDefaultViewSize(i, i2, null);
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
            gz1 gz1Var = this.mCommonEventHandler;
            if (gz1Var == null || !gz1Var.onTouchEvent(motionEvent)) {
                try {
                    if (DEBUG) {
                        Log.d(TAG, "final event = " + motionEvent);
                    }
                    return super.onTouchEvent(motionEvent);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setBackgroundColorForSwanApp(@ColorInt int i) {
        View webViewImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            setBackgroundColor(i);
            if (BdZeusUtil.isWebkitLoaded() || (webViewImpl = getWebViewImpl()) == null) {
                return;
            }
            webViewImpl.setBackgroundColor(i);
        }
    }

    @Override // com.repackage.om1
    public void setDefaultViewSize(int i, int i2, String str) {
        int i3;
        Pair<Integer, Integer> pair;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048603, this, i, i2, str) == null) {
            if (i2 == Integer.MIN_VALUE) {
                pair = yd3.e(str);
                i3 = ((Integer) pair.second).intValue();
            } else {
                i3 = i2;
                pair = null;
            }
            if (i == Integer.MIN_VALUE) {
                i = pair != null ? ((Integer) pair.first).intValue() : yd3.o(AppRuntime.getAppContext());
            }
            if (i <= 0 || i3 <= 0) {
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "setDefaultViewSize W:" + i + " H:" + i3);
            }
            getWebViewExt().setDefaultViewSizeExt(i, i3);
        }
    }

    public void setOnCommonEventHandler(gz1 gz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, gz1Var) == null) {
            this.mCommonEventHandler = gz1Var;
        }
    }

    public void setOnWebViewHookHandler(hz1 hz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, hz1Var) == null) {
            this.mWebViewHookHandler = hz1Var;
        }
    }

    public void setSelectPopWindowListener(SwanAppSelectPopView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, aVar) == null) {
            this.mSelectPopWindowListener = aVar;
        }
    }

    public void setWebViewManager(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pm1Var) == null) {
            this.mWebViewManager = pm1Var;
        }
    }

    @Override // com.repackage.fz1
    public synchronized void suspendTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            synchronized (this) {
                if (!isDestroyed()) {
                    hx1.i(TAG, "suspendTimer: for=" + this);
                    pauseTimers();
                    onPause();
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void updateAndShowPopupWindow(int i, int i2, int i3, int i4, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Boolean.valueOf(z)}) == null) {
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
            post(new a(this));
        }
    }

    public void webViewScrollBy(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i, i2) == null) {
            getCurrentWebView().scrollBy(i, i2);
        }
    }

    @Override // com.repackage.om1
    public void webViewScrollTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i, i2) == null) {
            getCurrentWebView().scrollTo(i, i2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public NgWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
