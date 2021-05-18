package com.baidu.fsg.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.fsg.base.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class SafeKeyBoardUtil {

    /* renamed from: a  reason: collision with root package name */
    public String f5528a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5529b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f5530c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f5531d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f5532e;

    /* renamed from: f  reason: collision with root package name */
    public View f5533f;

    /* renamed from: g  reason: collision with root package name */
    public int f5534g;

    /* renamed from: h  reason: collision with root package name */
    public int f5535h;

    /* renamed from: i  reason: collision with root package name */
    public int f5536i;
    public int j;
    public SafeKeyBoardPopupWindow mPopupWindow;

    public void hideSoftInputMethod(EditText editText) {
        ((InputMethodManager) this.f5529b.getSystemService("input_method")).hideSoftInputFromWindow(this.f5530c.getWindowToken(), 0);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(editText, Boolean.FALSE);
        } catch (IllegalAccessException e2) {
            LogUtil.d(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            LogUtil.d(e3.getMessage());
        } catch (NoSuchMethodException e4) {
            LogUtil.d(e4.getMessage());
            try {
                Method method2 = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method2.setAccessible(true);
                method2.invoke(editText, Boolean.FALSE);
            } catch (NoSuchMethodException e5) {
                LogUtil.d(e5.getMessage());
                editText.setInputType(0);
            } catch (Exception e6) {
                LogUtil.d(e6.getMessage());
                editText.setInputType(0);
            }
        } catch (InvocationTargetException e7) {
            LogUtil.d(e7.getMessage());
        } catch (Exception e8) {
            LogUtil.d(e8.getMessage());
        }
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
        b();
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        this.f5529b = context;
        this.f5531d = viewGroup;
        this.f5532e = safeScrollView;
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            SafeScrollView safeScrollView2 = this.f5532e;
            if (safeScrollView2 != null) {
                this.f5535h = safeScrollView2.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.f5530c = safeKeyBoardEditText;
        this.f5533f = view;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f5532e != null && this.f5531d != null) {
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f5532e);
            hideSoftInputMethod(this.f5530c);
            if (this.f5532e.hasWindowFocus() && this.f5530c.isEnabled()) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = this.mPopupWindow;
                if (safeKeyBoardPopupWindow2 != null && !safeKeyBoardPopupWindow2.isShowing() && this.f5532e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f5531d, 80, 0, 0);
                        if (Build.VERSION.SDK_INT <= 23) {
                            this.mPopupWindow.update();
                        }
                    } catch (Exception unused) {
                        this.mPopupWindow = null;
                        return;
                    }
                }
                new Handler().postDelayed(new j(this), 150L);
                return;
            }
            return;
        }
        LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
    }

    private void b() {
        ViewGroup.LayoutParams layoutParams = this.f5532e.getLayoutParams();
        layoutParams.height = this.f5535h;
        this.f5532e.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.mPopupWindow == null || this.f5532e == null || this.f5533f == null) {
            return;
        }
        this.f5534g = ((Activity) this.f5529b).getWindow().getDecorView().getBottom();
        this.j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f5532e.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = this.f5532e.getLayoutParams();
        layoutParams.height = (this.f5534g - this.j) - iArr[1];
        this.f5532e.setLayoutParams(layoutParams);
        this.f5532e.post(new l(this));
    }
}
