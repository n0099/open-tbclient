package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdSwitchView extends FrameLayout {
    FrameLayout mLayout;
    private c ud;
    private SwitchState ue;
    private boolean uf;
    private boolean ug;
    private boolean uh;
    private TranslateAnimation ui;
    private TranslateAnimation uj;
    private Animation.AnimationListener uk;
    ImageView ul;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (uo) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchState[] valuesCustom() {
            SwitchState[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchState[] switchStateArr = new SwitchState[length];
            System.arraycopy(valuesCustom, 0, switchStateArr, 0, length);
            return switchStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum SwitchStyle {
        DAY,
        NIGHT,
        SIDE_BAR;

        /* JADX DEBUG: Replace access to removed values field (up) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchStyle[] valuesCustom() {
            SwitchStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchStyle[] switchStyleArr = new SwitchStyle[length];
            System.arraycopy(valuesCustom, 0, switchStyleArr, 0, length);
            return switchStyleArr;
        }
    }

    public BdSwitchView(Context context) {
        super(context);
        this.ud = null;
        this.ue = SwitchState.ON;
        this.uf = false;
        this.ug = false;
        this.uh = false;
        this.uk = null;
        this.mLayout = null;
        this.ul = null;
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ud = null;
        this.ue = SwitchState.ON;
        this.uf = false;
        this.ug = false;
        this.uh = false;
        this.uk = null;
        this.mLayout = null;
        this.ul = null;
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ei().a(context, R.layout.bd_switch_view, this, true);
        this.mLayout = (FrameLayout) findViewById(R.id.layout);
        this.ul = (ImageView) findViewById(R.id.switch_image);
        iz();
        iA();
        this.uk = new a(this);
        setOnClickListener(new b(this));
        iB();
    }

    private void iz() {
        if (this.mLayout != null && this.mLayout.getForeground() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLayout.getLayoutParams();
            layoutParams.width = this.mLayout.getForeground().getIntrinsicWidth();
            this.mLayout.setLayoutParams(layoutParams);
        }
    }

    private void iA() {
        if (this.ul != null && this.ul.getBackground() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ul.getLayoutParams();
            layoutParams.width = this.ul.getBackground().getIntrinsicWidth();
            this.ul.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.uf) {
            super.setOnClickListener(onClickListener);
            this.uf = true;
        }
    }

    private void iB() {
        float translateDis = getTranslateDis();
        if (!this.uh) {
            this.ui = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
            this.uj = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        } else {
            this.ui = new TranslateAnimation(0.0f, translateDis, 0.0f, 0.0f);
            this.uj = new TranslateAnimation(translateDis, 0.0f, 0.0f, 0.0f);
        }
        this.ui.setDuration(200L);
        this.ui.setFillAfter(true);
        this.ui.setAnimationListener(this.uk);
        this.uj.setDuration(200L);
        this.uj.setFillAfter(true);
        this.uj.setAnimationListener(this.uk);
    }

    private float getTranslateDis() {
        return this.mLayout.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    private void b(boolean z, boolean z2) {
        if (!this.ug) {
            if (this.ue == SwitchState.ON) {
                this.ue = SwitchState.OFF;
                if (this.uj != null) {
                    if (z) {
                        this.uj.setDuration(200L);
                        this.ul.startAnimation(this.uj);
                    } else if (!O(false)) {
                        this.uj.setDuration(200L);
                        this.ul.startAnimation(this.uj);
                    }
                }
            } else {
                this.ue = SwitchState.ON;
                if (this.ui != null) {
                    if (z) {
                        this.ui.setDuration(200L);
                        this.ul.startAnimation(this.ui);
                    } else if (!O(true)) {
                        this.ui.setDuration(200L);
                        this.ul.startAnimation(this.ui);
                    }
                }
            }
            if (this.ud != null && z2) {
                this.ud.a(this, this.ue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        b(z, true);
    }

    public void setSwitchFrame(int i) {
        this.mLayout.setForeground(getResources().getDrawable(i));
        iz();
    }

    public void setSwitchImage(int i) {
        this.ul.setBackgroundResource(i);
        iA();
    }

    public void setSwitchStyle(SwitchStyle switchStyle) {
        if (switchStyle == SwitchStyle.DAY) {
            setSwitchFrame(R.drawable.btn_switch_masking);
            setSwitchImage(R.drawable.btn_switch);
        } else if (switchStyle == SwitchStyle.NIGHT) {
            setSwitchFrame(R.drawable.btn_switch_masking_1);
            setSwitchImage(R.drawable.btn_switch_1);
        } else if (switchStyle == SwitchStyle.SIDE_BAR) {
            setSwitchFrame(R.drawable.btn_switch_masking_sidebar);
            setSwitchImage(R.drawable.btn_switch_1);
        }
    }

    public void iC() {
        if (this.ue != SwitchState.ON) {
            b(false, false);
        }
    }

    public void iD() {
        if (this.ue != SwitchState.OFF) {
            b(false, false);
        }
    }

    public void iE() {
        M(false);
    }

    public void M(boolean z) {
        if (this.ue != SwitchState.ON) {
            L(z);
        }
    }

    public void iF() {
        N(false);
    }

    public void N(boolean z) {
        if (this.ue != SwitchState.OFF) {
            L(z);
        }
    }

    public boolean iG() {
        return this.ue == SwitchState.ON;
    }

    private boolean O(boolean z) {
        boolean z2;
        if (this.ug) {
            return false;
        }
        this.ug = true;
        float translateDis = getTranslateDis();
        if (!z) {
            this.ue = SwitchState.OFF;
            z2 = !this.uh;
            this.uh = true;
            if (ax((int) (-translateDis))) {
                iB();
            } else {
                z2 = false;
            }
        } else {
            this.ue = SwitchState.ON;
            boolean z3 = this.uh;
            this.uh = false;
            if (ax(0)) {
                iB();
                z2 = z3;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.ug = false;
        }
        return z2;
    }

    private boolean ax(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ul.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.ul.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ul.getLayoutParams();
        return layoutParams2 == null || layoutParams2.leftMargin == i;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.ud = cVar;
    }
}
