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
    public String f5492a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5493b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f5494c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f5495d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f5496e;

    /* renamed from: f  reason: collision with root package name */
    public View f5497f;

    /* renamed from: g  reason: collision with root package name */
    public int f5498g;

    /* renamed from: h  reason: collision with root package name */
    public int f5499h;
    public int i;
    public int j;
    public SafeKeyBoardPopupWindow mPopupWindow;

    public void hideSoftInputMethod(EditText editText) {
        ((InputMethodManager) this.f5493b.getSystemService("input_method")).hideSoftInputFromWindow(this.f5494c.getWindowToken(), 0);
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
        this.f5493b = context;
        this.f5495d = viewGroup;
        this.f5496e = safeScrollView;
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            SafeScrollView safeScrollView2 = this.f5496e;
            if (safeScrollView2 != null) {
                this.f5499h = safeScrollView2.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.f5494c = safeKeyBoardEditText;
        this.f5497f = view;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f5496e != null && this.f5495d != null) {
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f5496e);
            hideSoftInputMethod(this.f5494c);
            if (this.f5496e.hasWindowFocus() && this.f5494c.isEnabled()) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = this.mPopupWindow;
                if (safeKeyBoardPopupWindow2 != null && !safeKeyBoardPopupWindow2.isShowing() && this.f5496e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f5495d, 80, 0, 0);
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
        ViewGroup.LayoutParams layoutParams = this.f5496e.getLayoutParams();
        layoutParams.height = this.f5499h;
        this.f5496e.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.mPopupWindow == null || this.f5496e == null || this.f5497f == null) {
            return;
        }
        this.f5498g = ((Activity) this.f5493b).getWindow().getDecorView().getBottom();
        this.j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f5496e.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = this.f5496e.getLayoutParams();
        layoutParams.height = (this.f5498g - this.j) - iArr[1];
        this.f5496e.setLayoutParams(layoutParams);
        this.f5496e.post(new l(this));
    }
}
