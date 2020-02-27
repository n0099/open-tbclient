package com.baidu.fsg.base.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
/* loaded from: classes4.dex */
public class SafeKeyBoardEditText extends PluginEditText implements View.OnTouchListener {
    private SafeKeyBoardState a;
    private Context b;
    private ViewGroup c;
    private SafeScrollView d;
    private View e;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private OnMyFocusChangeListener n;
    private boolean o;
    private boolean p;
    private View.OnClickListener q;
    private CheckFunc r;

    /* loaded from: classes4.dex */
    public interface CheckFunc {
        boolean check(String str);
    }

    /* loaded from: classes4.dex */
    public interface OnMyFocusChangeListener {
        void onMyFocusChange(View view, boolean z);
    }

    /* loaded from: classes4.dex */
    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public void setShowSystemKeyBoard(boolean z) {
        this.o = z;
    }

    public SafeKeyBoardEditText(Context context) {
        this(context, null);
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.b = context;
        setOnLongClickListener(new c(this));
        setOnTouchListener(this);
        setOnFocusChangeListener(new d(this));
        setOnKeyListener(new e(this));
    }

    public SafeKeyBoardState getKeyBoardState() {
        return this.a;
    }

    @Override // com.baidu.fsg.base.widget.PluginEditText, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.setShowSystemMethodFlag(this.o);
        super.onTouch(view, motionEvent);
        int action = motionEvent.getAction();
        Layout layout = getLayout();
        switch (action) {
            case 0:
                requestFocus();
                this.off = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (int) motionEvent.getX());
                if (hasFocus()) {
                    if (this.d == null) {
                        RimGlobalUtils.showInputMethod(this.b, this);
                        return true;
                    } else if (this.d != null && !this.d.isPopupWindowShowing()) {
                        this.d.showKeyBoard(this.c, this, this.e);
                        return true;
                    } else {
                        return true;
                    }
                }
                return true;
            case 1:
            case 2:
            default:
                return true;
        }
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        this.c = viewGroup;
        this.d = safeScrollView;
        this.e = view;
        if (z) {
            safeScrollView.showKeyBoard(viewGroup, this, view);
        }
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        this.r = checkFunc;
    }

    public CheckFunc getCheckFunc() {
        return this.r;
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public View.OnClickListener getOnConfirmListener() {
        return this.q;
    }

    public ViewGroup getViewGroup() {
        return this.c;
    }

    public View getVisibleView() {
        return this.e;
    }

    public int getGap() {
        if (this.m == 0) {
            this.m = 8;
        }
        return this.m;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setCloseBtnVisibility(int i) {
        this.h = i;
    }

    public int getCloseBtnVisibility() {
        return this.h;
    }

    public void setGap(int i) {
        this.m = i;
    }

    public boolean getUseRandKey() {
        return this.k;
    }

    public void setUseRandKey(boolean z) {
        this.k = z;
    }

    public boolean getUseKeyDot() {
        return this.f;
    }

    public void setUseKeyDot(boolean z) {
        this.f = z;
    }

    public boolean getUseKeyX() {
        return this.g;
    }

    public void setUseKeyX(boolean z) {
        this.g = z;
    }

    public void setUseSafeKeyBoard(boolean z) {
        this.l = z;
    }

    public boolean getUseSafeKeyBoard() {
        return this.l;
    }

    public void setOnMyFocusChangeListener(OnMyFocusChangeListener onMyFocusChangeListener) {
        this.n = onMyFocusChangeListener;
    }

    public int getHeadLayoutVisibility() {
        return this.i;
    }

    public void setHeadLayoutVisibility(int i) {
        this.i = i;
    }

    public boolean isShowLogoLockAnim() {
        return this.j;
    }

    public void setShowLogoLockAnim(boolean z) {
        this.j = z;
    }

    public void setDisablePast(boolean z) {
        this.p = z;
    }

    public void dismissKeyBorad() {
        this.d.dismissKeyBoard(this);
    }
}
