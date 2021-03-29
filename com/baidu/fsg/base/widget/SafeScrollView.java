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
    public static final String f5500a = SafeScrollView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f5501b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5502c;

    /* renamed from: d  reason: collision with root package name */
    public int f5503d;

    /* renamed from: e  reason: collision with root package name */
    public Context f5504e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText f5505f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardUtil f5506g;

    /* renamed from: h  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f5507h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes2.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes2.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i);
    }

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5502c = false;
        this.f5503d = 0;
        this.f5506g = new SafeKeyBoardUtil();
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.f5504e = context;
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
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f5507h;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.f5506g.hideSoftKeyBoard();
            return;
        }
        RimGlobalUtils.hideInputMethod(this.f5504e, safeKeyBoardEditText);
    }

    public boolean isPopupWindowShowing() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        SafeKeyBoardUtil safeKeyBoardUtil = this.f5506g;
        return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
    }

    public void notifyShowKeyBoard(int i) {
        if (this.f5507h != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5506g.mPopupWindow;
            if (safeKeyBoardPopupWindow != null) {
                safeKeyBoardPopupWindow.getHeight();
            }
            this.f5507h.onKeyBoardStatusChange(true, i);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.k) {
            this.k = true;
            this.i = i4;
            this.j = i4;
            return;
        }
        int i5 = this.j;
        if (i5 != i4) {
            int i6 = this.i;
            if (i4 >= i6 || i5 >= i6) {
                this.j = i4;
            }
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollChangedListener scrollChangedListener = this.f5501b;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z && !this.f5502c) {
            this.f5506g.hideSoftKeyBoard();
            return;
        }
        this.f5503d = 0;
        a((View) this);
        if (this.f5503d == 1 && (safeKeyBoardEditText = this.f5505f) != null && safeKeyBoardEditText.isFocused() && this.f5505f.getUseSafeKeyBoard()) {
            new Handler().postDelayed(new m(this), 100L);
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.f5502c = z;
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.f5507h = onkeyboardstatuschangelistener;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5506g = safeKeyBoardUtil;
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.f5501b = scrollChangedListener;
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5506g.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                this.f5506g.init(this.f5504e, viewGroup, this);
            }
            this.f5506g.showSoftKeyBoard(safeKeyBoardEditText, view);
            return;
        }
        RimGlobalUtils.showInputMethod(this.f5504e, safeKeyBoardEditText);
    }

    private void a(View view) {
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i = this.f5503d + 1;
                this.f5503d = i;
                if (i == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f5505f = (SafeKeyBoardEditText) view;
                    return;
                }
                return;
            }
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i2));
            i2++;
        }
    }

    public void dismissKeyBoard() {
        this.f5506g.hideSoftKeyBoard();
    }

    public SafeScrollView(Context context) {
        this(context, null);
        this.f5504e = context;
        setSafeFlag(true);
    }

    private void a() {
        this.f5501b = null;
    }
}
