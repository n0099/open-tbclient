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
    private String a;
    private Context b;
    private SafeKeyBoardEditText c;
    private ViewGroup d;
    private SafeScrollView e;
    private View f;
    private int g;
    private int h;
    private int i;
    private int j;
    public SafeKeyBoardPopupWindow mPopupWindow;

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        this.b = context;
        this.d = viewGroup;
        this.e = safeScrollView;
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
        }
        if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
            if (this.e != null) {
                this.h = this.e.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.c = safeKeyBoardEditText;
        this.f = view;
        if (this.mPopupWindow == null || this.c == null || this.f == null || this.e == null || this.d == null) {
            LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
            return;
        }
        this.mPopupWindow.setSafeEditTet(safeKeyBoardEditText);
        this.mPopupWindow.setScrollView(this.e);
        hideSoftInputMethod(this.c);
        if (this.e.hasWindowFocus() && this.c.isEnabled()) {
            if (this.mPopupWindow != null && !this.mPopupWindow.isShowing() && this.e.hasWindowFocus()) {
                this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                try {
                    this.mPopupWindow.showAtLocation(this.d, 80, 0, 0);
                    if (Build.VERSION.SDK_INT <= 23) {
                        this.mPopupWindow.update();
                    }
                } catch (Exception e) {
                    this.mPopupWindow = null;
                    return;
                }
            }
            new Handler().postDelayed(new j(this), 150L);
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        Activity activity = (Activity) this.b;
        ((InputMethodManager) ((Activity) this.b).getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(editText, false);
        } catch (IllegalAccessException e) {
            LogUtil.d(e.getMessage());
        } catch (IllegalArgumentException e2) {
            LogUtil.d(e2.getMessage());
        } catch (NoSuchMethodException e3) {
            LogUtil.d(e3.getMessage());
            try {
                Method method2 = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method2.setAccessible(true);
                method2.invoke(editText, false);
            } catch (NoSuchMethodException e4) {
                LogUtil.d(e4.getMessage());
                editText.setInputType(0);
            } catch (Exception e5) {
                LogUtil.d(e5.getMessage());
                editText.setInputType(0);
            }
        } catch (InvocationTargetException e6) {
            LogUtil.d(e6.getMessage());
        } catch (Exception e7) {
            LogUtil.d(e7.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.mPopupWindow != null && this.e != null && this.f != null) {
            this.g = ((Activity) this.b).getWindow().getDecorView().getBottom();
            this.j = this.mPopupWindow.getPopupWindowHeight();
            int[] iArr = new int[2];
            this.e.getLocationOnScreen(iArr);
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            layoutParams.height = (this.g - this.j) - iArr[1];
            this.e.setLayoutParams(layoutParams);
            this.e.post(new l(this));
        }
    }

    public void hideSoftKeyBoard() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            b();
        }
    }

    private void b() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.height = this.h;
        this.e.setLayoutParams(layoutParams);
    }
}
