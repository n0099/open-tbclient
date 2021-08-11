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
/* loaded from: classes5.dex */
public final class SafeKeyBoardUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39506a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39507b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f39508c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f39509d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f39510e;

    /* renamed from: f  reason: collision with root package name */
    public View f39511f;

    /* renamed from: g  reason: collision with root package name */
    public int f39512g;

    /* renamed from: h  reason: collision with root package name */
    public int f39513h;

    /* renamed from: i  reason: collision with root package name */
    public int f39514i;

    /* renamed from: j  reason: collision with root package name */
    public int f39515j;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mPopupWindow == null || this.f39510e == null || this.f39511f == null) {
            return;
        }
        this.f39512g = ((Activity) this.f39507b).getWindow().getDecorView().getBottom();
        this.f39515j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f39510e.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = this.f39510e.getLayoutParams();
        layoutParams.height = (this.f39512g - this.f39515j) - iArr[1];
        this.f39510e.setLayoutParams(layoutParams);
        this.f39510e.post(new Runnable(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardUtil.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SafeKeyBoardUtil f39518a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f39518a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int[] iArr2 = new int[2];
                    this.f39518a.f39511f.getLocationOnScreen(iArr2);
                    SafeKeyBoardUtil safeKeyBoardUtil = this.f39518a;
                    safeKeyBoardUtil.f39514i = ((iArr2[1] + safeKeyBoardUtil.f39511f.getHeight()) - (this.f39518a.f39512g - this.f39518a.f39515j)) + this.f39518a.f39508c.getGap();
                    if (this.f39518a.f39514i > 0) {
                        this.f39518a.f39510e.smoothScrollBy(0, this.f39518a.f39514i);
                    }
                    this.f39518a.f39510e.notifyShowKeyBoard(this.f39518a.f39515j);
                }
            }
        });
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f39510e.getLayoutParams();
            layoutParams.height = this.f39513h;
            this.f39510e.setLayoutParams(layoutParams);
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        String message;
        String message2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editText) == null) {
            ((InputMethodManager) this.f39507b.getSystemService("input_method")).hideSoftInputFromWindow(this.f39508c.getWindowToken(), 0);
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
            b();
        }
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup, safeScrollView) == null) {
            this.f39507b = context;
            this.f39509d = viewGroup;
            this.f39510e = safeScrollView;
            if (this.mPopupWindow == null) {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                SafeScrollView safeScrollView2 = this.f39510e;
                if (safeScrollView2 != null) {
                    this.f39513h = safeScrollView2.getLayoutParams().height;
                } else {
                    LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
                }
            }
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, safeKeyBoardEditText, view) == null) {
            this.f39508c = safeKeyBoardEditText;
            this.f39511f = view;
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || safeKeyBoardEditText == null || view == null || this.f39510e == null || this.f39509d == null) {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
                return;
            }
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f39510e);
            hideSoftInputMethod(this.f39508c);
            if (this.f39510e.hasWindowFocus() && this.f39508c.isEnabled()) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = this.mPopupWindow;
                if (safeKeyBoardPopupWindow2 != null && !safeKeyBoardPopupWindow2.isShowing() && this.f39510e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f39509d, 80, 0, 0);
                        if (Build.VERSION.SDK_INT <= 23) {
                            this.mPopupWindow.update();
                        }
                    } catch (Exception unused) {
                        this.mPopupWindow = null;
                        return;
                    }
                }
                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SafeKeyBoardUtil f39516a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f39516a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow3 = this.f39516a.mPopupWindow;
                            if (safeKeyBoardPopupWindow3 != null && safeKeyBoardPopupWindow3.isShowing() && this.f39516a.f39510e.hasWindowFocus()) {
                                this.f39516a.a();
                            } else {
                                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardUtil.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f39517a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f39517a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow4;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (safeKeyBoardPopupWindow4 = this.f39517a.f39516a.mPopupWindow) != null && safeKeyBoardPopupWindow4.isShowing() && this.f39517a.f39516a.f39510e.hasWindowFocus()) {
                                            this.f39517a.f39516a.a();
                                        }
                                    }
                                }, 150L);
                            }
                        }
                    }
                }, 150L);
            }
        }
    }
}
