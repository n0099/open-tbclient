package com.baidu.fsg.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public final class SafeKeyBoardUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f34188b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f34189c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f34190d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f34191e;

    /* renamed from: f  reason: collision with root package name */
    public View f34192f;

    /* renamed from: g  reason: collision with root package name */
    public int f34193g;

    /* renamed from: h  reason: collision with root package name */
    public int f34194h;

    /* renamed from: i  reason: collision with root package name */
    public int f34195i;

    /* renamed from: j  reason: collision with root package name */
    public int f34196j;
    public SafeKeyBoardPopupWindow mPopupWindow;

    public SafeKeyBoardUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f34191e.getLayoutParams();
            layoutParams.height = this.f34194h;
            this.f34191e.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.mPopupWindow == null || this.f34191e == null || this.f34192f == null) {
            return;
        }
        this.f34193g = ((Activity) this.f34188b).getWindow().getDecorView().getBottom();
        this.f34196j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f34191e.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = this.f34191e.getLayoutParams();
        layoutParams.height = (this.f34193g - this.f34196j) - iArr[1];
        this.f34191e.setLayoutParams(layoutParams);
        this.f34191e.post(new l(this));
    }

    public void hideSoftInputMethod(EditText editText) {
        String message;
        String message2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editText) == null) {
            ((InputMethodManager) this.f34188b.getSystemService("input_method")).hideSoftInputFromWindow(this.f34189c.getWindowToken(), 0);
            if (Build.VERSION.SDK_INT < 11) {
                editText.setInputType(0);
                return;
            }
            try {
                Method method = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(editText, Boolean.FALSE);
            } catch (IllegalAccessException e2) {
                message = e2.getMessage();
                LogUtil.d(message);
            } catch (IllegalArgumentException e3) {
                message = e3.getMessage();
                LogUtil.d(message);
            } catch (NoSuchMethodException e4) {
                LogUtil.d(e4.getMessage());
                try {
                    Method method2 = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                    method2.setAccessible(true);
                    method2.invoke(editText, Boolean.FALSE);
                } catch (NoSuchMethodException e5) {
                    message2 = e5.getMessage();
                    LogUtil.d(message2);
                    editText.setInputType(0);
                } catch (Exception e6) {
                    message2 = e6.getMessage();
                    LogUtil.d(message2);
                    editText.setInputType(0);
                }
            } catch (InvocationTargetException e7) {
                message = e7.getMessage();
                LogUtil.d(message);
            } catch (Exception e8) {
                message = e8.getMessage();
                LogUtil.d(message);
            }
        }
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (safeKeyBoardPopupWindow = this.mPopupWindow) != null && safeKeyBoardPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            a();
        }
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup, safeScrollView) == null) {
            this.f34188b = context;
            this.f34190d = viewGroup;
            this.f34191e = safeScrollView;
            if (this.mPopupWindow == null) {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                SafeScrollView safeScrollView2 = this.f34191e;
                if (safeScrollView2 != null) {
                    this.f34194h = safeScrollView2.getLayoutParams().height;
                } else {
                    LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
                }
            }
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, safeKeyBoardEditText, view) == null) {
            this.f34189c = safeKeyBoardEditText;
            this.f34192f = view;
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || safeKeyBoardEditText == null || view == null || this.f34191e == null || this.f34190d == null) {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
                return;
            }
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f34191e);
            hideSoftInputMethod(this.f34189c);
            if (this.f34191e.hasWindowFocus() && this.f34189c.isEnabled()) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = this.mPopupWindow;
                if (safeKeyBoardPopupWindow2 != null && !safeKeyBoardPopupWindow2.isShowing() && this.f34191e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f34190d, 80, 0, 0);
                        if (Build.VERSION.SDK_INT <= 23) {
                            this.mPopupWindow.update();
                        }
                    } catch (Exception unused) {
                        this.mPopupWindow = null;
                        return;
                    }
                }
                new Handler().postDelayed(new k(this), 150L);
            }
        }
    }
}
