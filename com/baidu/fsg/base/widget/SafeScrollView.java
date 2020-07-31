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
/* loaded from: classes11.dex */
public class SafeScrollView extends ScrollView {
    private static final String a = SafeScrollView.class.getSimpleName();
    private ScrollChangedListener b;
    private boolean c;
    private int d;
    private Context e;
    private SafeKeyBoardEditText f;
    private SafeKeyBoardUtil g;
    private onKeyBoardStatusChangeListener h;
    private int i;
    private int j;
    private boolean k;

    /* loaded from: classes11.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes11.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i);
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.c = z;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z && !this.c) {
            this.g.hideSoftKeyBoard();
            return;
        }
        this.d = 0;
        a((View) this);
        if (this.d == 1 && this.f != null && this.f.isFocused() && this.f.getUseSafeKeyBoard()) {
            new Handler().postDelayed(new m(this), 100L);
        }
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

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = 0;
        this.g = new SafeKeyBoardUtil();
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.e = context;
        setSafeFlag(true);
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.g = safeKeyBoardUtil;
    }

    public SafeScrollView(Context context) {
        this(context, null);
        this.e = context;
        setSafeFlag(true);
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.h = onkeyboardstatuschangelistener;
    }

    private void a(View view) {
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < ((ViewGroup) view).getChildCount()) {
                    a(((ViewGroup) view).getChildAt(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
            this.d++;
            if (this.d == 1 && (view instanceof SafeKeyBoardEditText)) {
                this.f = (SafeKeyBoardEditText) view;
            }
        }
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
            if (this.h != null) {
                this.h.onKeyBoardStatusChange(false, 0);
            }
            this.g.hideSoftKeyBoard();
            return;
        }
        RimGlobalUtils.hideInputMethod(this.e, safeKeyBoardEditText);
    }

    public void dismissKeyBoard() {
        this.g.hideSoftKeyBoard();
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
            if (this.g.mPopupWindow == null || !this.g.mPopupWindow.isShowing()) {
                this.g.init(this.e, viewGroup, this);
            }
            this.g.showSoftKeyBoard(safeKeyBoardEditText, view);
            return;
        }
        RimGlobalUtils.showInputMethod(this.e, safeKeyBoardEditText);
    }

    public boolean isPopupWindowShowing() {
        return (this.g == null || this.g.mPopupWindow == null || !this.g.mPopupWindow.isShowing()) ? false : true;
    }

    public void notifyShowKeyBoard(int i) {
        if (this.h != null) {
            if (this.g.mPopupWindow != null) {
                this.g.mPopupWindow.getHeight();
            }
            this.h.onKeyBoardStatusChange(true, i);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.k) {
            this.k = true;
            this.i = i4;
            this.j = i4;
        } else if (this.j != i4) {
            if (i4 >= this.i || this.j >= this.i) {
                if (this.j < i4) {
                }
                this.j = i4;
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.b != null) {
            this.b.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.b = scrollChangedListener;
    }

    private void a() {
        this.b = null;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }
}
