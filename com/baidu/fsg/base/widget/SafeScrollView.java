package com.baidu.fsg.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SafeScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37714a = "SafeScrollView";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f37715b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37716c;

    /* renamed from: d  reason: collision with root package name */
    public int f37717d;

    /* renamed from: e  reason: collision with root package name */
    public Context f37718e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText f37719f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardUtil f37720g;

    /* renamed from: h  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f37721h;

    /* renamed from: i  reason: collision with root package name */
    public int f37722i;
    public int j;
    public boolean k;

    /* loaded from: classes7.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes7.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1785124724, "Lcom/baidu/fsg/base/widget/SafeScrollView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1785124724, "Lcom/baidu/fsg/base/widget/SafeScrollView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeScrollView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37718e = context;
        setSafeFlag(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeScrollView(Context context, AttributeSet attributeSet) {
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
        this.f37716c = false;
        this.f37717d = 0;
        this.f37720g = new SafeKeyBoardUtil();
        this.f37722i = 0;
        this.j = 0;
        this.k = false;
        this.f37718e = context;
        setSafeFlag(true);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f37715b = null;
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) != null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f37717d + 1;
                this.f37717d = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f37719f = (SafeKeyBoardEditText) view;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i3));
            i3++;
        }
    }

    private void setSafeFlag(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && (getContext() instanceof Activity)) {
            if (z) {
                BdWalletUtils.addFlagsSecure((Activity) getContext());
            } else {
                BdWalletUtils.clearFlagsSecure((Activity) getContext());
            }
        }
    }

    public void dismissKeyBoard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37720g.hideSoftKeyBoard();
        }
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, safeKeyBoardEditText) == null) {
            if (!safeKeyBoardEditText.getUseSafeKeyBoard()) {
                RimGlobalUtils.hideInputMethod(this.f37718e, safeKeyBoardEditText);
                return;
            }
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f37721h;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.f37720g.hideSoftKeyBoard();
        }
    }

    public boolean isPopupWindowShowing() {
        InterceptResult invokeV;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SafeKeyBoardUtil safeKeyBoardUtil = this.f37720g;
            return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void notifyShowKeyBoard(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f37721h == null) {
            return;
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f37720g.mPopupWindow;
        if (safeKeyBoardPopupWindow != null) {
            safeKeyBoardPopupWindow.getHeight();
        }
        this.f37721h.onKeyBoardStatusChange(true, i2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.k) {
                int i6 = this.j;
                if (i6 == i5) {
                    return;
                }
                int i7 = this.f37722i;
                if (i5 < i7 && i6 < i7) {
                    return;
                }
            } else {
                this.k = true;
                this.f37722i = i5;
            }
            this.j = i5;
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            ScrollChangedListener scrollChangedListener = this.f37715b;
            if (scrollChangedListener != null) {
                scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z && !this.f37716c) {
                this.f37720g.hideSoftKeyBoard();
                return;
            }
            this.f37717d = 0;
            a((View) this);
            if (this.f37717d == 1 && (safeKeyBoardEditText = this.f37719f) != null && safeKeyBoardEditText.isFocused() && this.f37719f.getUseSafeKeyBoard()) {
                new Handler().postDelayed(new m(this), 100L);
            }
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f37716c = z;
        }
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onkeyboardstatuschangelistener) == null) {
            this.f37721h = onkeyboardstatuschangelistener;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
        }
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, safeKeyBoardUtil) == null) {
            this.f37720g = safeKeyBoardUtil;
        }
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, scrollChangedListener) == null) {
            this.f37715b = scrollChangedListener;
        }
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, viewGroup, safeKeyBoardEditText, view) == null) {
            if (!safeKeyBoardEditText.getUseSafeKeyBoard() || view == null) {
                RimGlobalUtils.showInputMethod(this.f37718e, safeKeyBoardEditText);
                return;
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f37720g.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                this.f37720g.init(this.f37718e, viewGroup, this);
            }
            this.f37720g.showSoftKeyBoard(safeKeyBoardEditText, view);
        }
    }
}
