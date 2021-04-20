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
    public SafeKeyBoardState f5510a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5511b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f5512c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f5513d;

    /* renamed from: e  reason: collision with root package name */
    public View f5514e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5515f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5516g;

    /* renamed from: h  reason: collision with root package name */
    public int f5517h;
    public int i;
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
        this.f5513d.dismissKeyBoard(this);
    }

    public CheckFunc getCheckFunc() {
        return this.r;
    }

    public int getCloseBtnVisibility() {
        return this.f5517h;
    }

    public int getGap() {
        if (this.m == 0) {
            this.m = 8;
        }
        return this.m;
    }

    public int getHeadLayoutVisibility() {
        return this.i;
    }

    public SafeKeyBoardState getKeyBoardState() {
        return this.f5510a;
    }

    public View.OnClickListener getOnConfirmListener() {
        return this.q;
    }

    public boolean getUseKeyDot() {
        return this.f5515f;
    }

    public boolean getUseKeyX() {
        return this.f5516g;
    }

    public boolean getUseRandKey() {
        return this.k;
    }

    public boolean getUseSafeKeyBoard() {
        return this.l;
    }

    public ViewGroup getViewGroup() {
        return this.f5512c;
    }

    public View getVisibleView() {
        return this.f5514e;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        this.f5512c = viewGroup;
        this.f5513d = safeScrollView;
        this.f5514e = view;
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
            SafeScrollView safeScrollView = this.f5513d;
            if (safeScrollView == null) {
                RimGlobalUtils.showInputMethod(this.f5511b, this);
                return true;
            } else if (safeScrollView == null || safeScrollView.isPopupWindowShowing()) {
                return true;
            } else {
                this.f5513d.showKeyBoard(this.f5512c, this, this.f5514e);
                return true;
            }
        }
        return true;
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        this.r = checkFunc;
    }

    public void setCloseBtnVisibility(int i) {
        this.f5517h = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setDisablePast(boolean z) {
        this.p = z;
    }

    public void setGap(int i) {
        this.m = i;
    }

    public void setHeadLayoutVisibility(int i) {
        this.i = i;
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
        this.f5515f = z;
    }

    public void setUseKeyX(boolean z) {
        this.f5516g = z;
    }

    public void setUseRandKey(boolean z) {
        this.k = z;
    }

    public void setUseSafeKeyBoard(boolean z) {
        this.l = z;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5515f = false;
        this.f5516g = false;
        this.f5517h = 0;
        this.i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5515f = false;
        this.f5516g = false;
        this.f5517h = 0;
        this.i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.f5511b = context;
        setOnLongClickListener(new c(this));
        setOnTouchListener(this);
        setOnFocusChangeListener(new d(this));
        setOnKeyListener(new e(this));
    }
}
