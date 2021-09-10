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
    public String f39724a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39725b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f39726c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f39727d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f39728e;

    /* renamed from: f  reason: collision with root package name */
    public View f39729f;

    /* renamed from: g  reason: collision with root package name */
    public int f39730g;

    /* renamed from: h  reason: collision with root package name */
    public int f39731h;

    /* renamed from: i  reason: collision with root package name */
    public int f39732i;

    /* renamed from: j  reason: collision with root package name */
    public int f39733j;
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
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mPopupWindow == null || this.f39728e == null || this.f39729f == null) {
            return;
        }
        this.f39730g = ((Activity) this.f39725b).getWindow().getDecorView().getBottom();
        this.f39733j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f39728e.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = this.f39728e.getLayoutParams();
        layoutParams.height = (this.f39730g - this.f39733j) - iArr[1];
        this.f39728e.setLayoutParams(layoutParams);
        this.f39728e.post(new Runnable(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardUtil.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SafeKeyBoardUtil f39736a;

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
                this.f39736a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int[] iArr2 = new int[2];
                    this.f39736a.f39729f.getLocationOnScreen(iArr2);
                    SafeKeyBoardUtil safeKeyBoardUtil = this.f39736a;
                    safeKeyBoardUtil.f39732i = ((iArr2[1] + safeKeyBoardUtil.f39729f.getHeight()) - (this.f39736a.f39730g - this.f39736a.f39733j)) + this.f39736a.f39726c.getGap();
                    if (this.f39736a.f39732i > 0) {
                        this.f39736a.f39728e.smoothScrollBy(0, this.f39736a.f39732i);
                    }
                    this.f39736a.f39728e.notifyShowKeyBoard(this.f39736a.f39733j);
                }
            }
        });
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f39728e.getLayoutParams();
            layoutParams.height = this.f39731h;
            this.f39728e.setLayoutParams(layoutParams);
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        String message;
        String message2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editText) == null) {
            ((InputMethodManager) this.f39725b.getSystemService("input_method")).hideSoftInputFromWindow(this.f39726c.getWindowToken(), 0);
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
            this.f39725b = context;
            this.f39727d = viewGroup;
            this.f39728e = safeScrollView;
            if (this.mPopupWindow == null) {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                SafeScrollView safeScrollView2 = this.f39728e;
                if (safeScrollView2 != null) {
                    this.f39731h = safeScrollView2.getLayoutParams().height;
                } else {
                    LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
                }
            }
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, safeKeyBoardEditText, view) == null) {
            this.f39726c = safeKeyBoardEditText;
            this.f39729f = view;
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || safeKeyBoardEditText == null || view == null || this.f39728e == null || this.f39727d == null) {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
                return;
            }
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f39728e);
            hideSoftInputMethod(this.f39726c);
            if (this.f39728e.hasWindowFocus() && this.f39726c.isEnabled()) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = this.mPopupWindow;
                if (safeKeyBoardPopupWindow2 != null && !safeKeyBoardPopupWindow2.isShowing() && this.f39728e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f39727d, 80, 0, 0);
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
                    public final /* synthetic */ SafeKeyBoardUtil f39734a;

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
                        this.f39734a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow3 = this.f39734a.mPopupWindow;
                            if (safeKeyBoardPopupWindow3 != null && safeKeyBoardPopupWindow3.isShowing() && this.f39734a.f39728e.hasWindowFocus()) {
                                this.f39734a.a();
                            } else {
                                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardUtil.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f39735a;

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
                                        this.f39735a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow4;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (safeKeyBoardPopupWindow4 = this.f39735a.f39734a.mPopupWindow) != null && safeKeyBoardPopupWindow4.isShowing() && this.f39735a.f39734a.f39728e.hasWindowFocus()) {
                                            this.f39735a.f39734a.a();
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
