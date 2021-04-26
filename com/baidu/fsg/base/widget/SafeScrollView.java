package com.baidu.fsg.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
/* loaded from: classes2.dex */
public class SafeScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5683a = SafeScrollView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f5684b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5685c;

    /* renamed from: d  reason: collision with root package name */
    public int f5686d;

    /* renamed from: e  reason: collision with root package name */
    public Context f5687e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText f5688f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardUtil f5689g;

    /* renamed from: h  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f5690h;

    /* renamed from: i  reason: collision with root package name */
    public int f5691i;
    public int j;
    public boolean k;

    /* loaded from: classes2.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes2.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i2);
    }

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5685c = false;
        this.f5686d = 0;
        this.f5689g = new SafeKeyBoardUtil();
        this.f5691i = 0;
        this.j = 0;
        this.k = false;
        this.f5687e = context;
        setSafeFlag(true);
    }

    private void setSafeFlag(boolean z) {
        if (getContext() instanceof Activity) {
            if (z) {
                BdWalletUtils.addFlagsSecure((Activity) getContext());
            } else {
                BdWalletUtils.clearFlagsSecure((Activity) getContext());
            }
        }
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f5690h;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.f5689g.hideSoftKeyBoard();
            return;
        }
        RimGlobalUtils.hideInputMethod(this.f5687e, safeKeyBoardEditText);
    }

    public boolean isPopupWindowShowing() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        SafeKeyBoardUtil safeKeyBoardUtil = this.f5689g;
        return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
    }

    public void notifyShowKeyBoard(int i2) {
        if (this.f5690h != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5689g.mPopupWindow;
            if (safeKeyBoardPopupWindow != null) {
                safeKeyBoardPopupWindow.getHeight();
            }
            this.f5690h.onKeyBoardStatusChange(true, i2);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.k) {
            this.k = true;
            this.f5691i = i5;
            this.j = i5;
            return;
        }
        int i6 = this.j;
        if (i6 != i5) {
            int i7 = this.f5691i;
            if (i5 >= i7 || i6 >= i7) {
                this.j = i5;
            }
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ScrollChangedListener scrollChangedListener = this.f5684b;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z && !this.f5685c) {
            this.f5689g.hideSoftKeyBoard();
            return;
        }
        this.f5686d = 0;
        a((View) this);
        if (this.f5686d == 1 && (safeKeyBoardEditText = this.f5688f) != null && safeKeyBoardEditText.isFocused() && this.f5688f.getUseSafeKeyBoard()) {
            new Handler().postDelayed(new m(this), 100L);
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.f5685c = z;
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.f5690h = onkeyboardstatuschangelistener;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5689g = safeKeyBoardUtil;
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.f5684b = scrollChangedListener;
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5689g.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                this.f5689g.init(this.f5687e, viewGroup, this);
            }
            this.f5689g.showSoftKeyBoard(safeKeyBoardEditText, view);
            return;
        }
        RimGlobalUtils.showInputMethod(this.f5687e, safeKeyBoardEditText);
    }

    private void a(View view) {
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f5686d + 1;
                this.f5686d = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f5688f = (SafeKeyBoardEditText) view;
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

    public void dismissKeyBoard() {
        this.f5689g.hideSoftKeyBoard();
    }

    public SafeScrollView(Context context) {
        this(context, null);
        this.f5687e = context;
        setSafeFlag(true);
    }

    private void a() {
        this.f5684b = null;
    }
}
