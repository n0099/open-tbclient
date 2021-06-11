package com.baidu.fsg.base.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
/* loaded from: classes2.dex */
public class SafeKeyBoardEditText extends PluginEditText implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public SafeKeyBoardState f5452a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5453b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f5454c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f5455d;

    /* renamed from: e  reason: collision with root package name */
    public View f5456e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5457f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5458g;

    /* renamed from: h  reason: collision with root package name */
    public int f5459h;

    /* renamed from: i  reason: collision with root package name */
    public int f5460i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public OnMyFocusChangeListener n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public CheckFunc r;

    /* loaded from: classes2.dex */
    public interface CheckFunc {
        boolean check(String str);
    }

    /* loaded from: classes2.dex */
    public interface OnMyFocusChangeListener {
        void onMyFocusChange(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public SafeKeyBoardEditText(Context context) {
        this(context, null);
    }

    public void dismissKeyBorad() {
        this.f5455d.dismissKeyBoard(this);
    }

    public CheckFunc getCheckFunc() {
        return this.r;
    }

    public int getCloseBtnVisibility() {
        return this.f5459h;
    }

    public int getGap() {
        if (this.m == 0) {
            this.m = 8;
        }
        return this.m;
    }

    public int getHeadLayoutVisibility() {
        return this.f5460i;
    }

    public SafeKeyBoardState getKeyBoardState() {
        return this.f5452a;
    }

    public View.OnClickListener getOnConfirmListener() {
        return this.q;
    }

    public boolean getUseKeyDot() {
        return this.f5457f;
    }

    public boolean getUseKeyX() {
        return this.f5458g;
    }

    public boolean getUseRandKey() {
        return this.k;
    }

    public boolean getUseSafeKeyBoard() {
        return this.l;
    }

    public ViewGroup getViewGroup() {
        return this.f5454c;
    }

    public View getVisibleView() {
        return this.f5456e;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        this.f5454c = viewGroup;
        this.f5455d = safeScrollView;
        this.f5456e = view;
        if (z) {
            safeScrollView.showKeyBoard(viewGroup, this, view);
        }
    }

    public boolean isShowLogoLockAnim() {
        return this.j;
    }

    @Override // com.baidu.fsg.base.widget.PluginEditText, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.setShowSystemMethodFlag(this.o);
        super.onTouch(view, motionEvent);
        int action = motionEvent.getAction();
        Layout layout = getLayout();
        if (action != 0) {
            return true;
        }
        requestFocus();
        this.off = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (int) motionEvent.getX());
        if (hasFocus()) {
            SafeScrollView safeScrollView = this.f5455d;
            if (safeScrollView == null) {
                RimGlobalUtils.showInputMethod(this.f5453b, this);
                return true;
            } else if (safeScrollView == null || safeScrollView.isPopupWindowShowing()) {
                return true;
            } else {
                this.f5455d.showKeyBoard(this.f5454c, this, this.f5456e);
                return true;
            }
        }
        return true;
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        this.r = checkFunc;
    }

    public void setCloseBtnVisibility(int i2) {
        this.f5459h = i2;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setDisablePast(boolean z) {
        this.p = z;
    }

    public void setGap(int i2) {
        this.m = i2;
    }

    public void setHeadLayoutVisibility(int i2) {
        this.f5460i = i2;
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setOnMyFocusChangeListener(OnMyFocusChangeListener onMyFocusChangeListener) {
        this.n = onMyFocusChangeListener;
    }

    public void setShowLogoLockAnim(boolean z) {
        this.j = z;
    }

    public void setShowSystemKeyBoard(boolean z) {
        this.o = z;
    }

    public void setUseKeyDot(boolean z) {
        this.f5457f = z;
    }

    public void setUseKeyX(boolean z) {
        this.f5458g = z;
    }

    public void setUseRandKey(boolean z) {
        this.k = z;
    }

    public void setUseSafeKeyBoard(boolean z) {
        this.l = z;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5457f = false;
        this.f5458g = false;
        this.f5459h = 0;
        this.f5460i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5457f = false;
        this.f5458g = false;
        this.f5459h = 0;
        this.f5460i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.f5453b = context;
        setOnLongClickListener(new c(this));
        setOnTouchListener(this);
        setOnFocusChangeListener(new d(this));
        setOnKeyListener(new e(this));
    }
}
