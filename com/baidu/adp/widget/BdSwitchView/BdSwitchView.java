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
    private c ug;
    private SwitchState uh;
    private boolean ui;
    private boolean uj;
    private boolean uk;
    private TranslateAnimation ul;
    private TranslateAnimation um;
    private Animation.AnimationListener uo;
    ImageView up;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (ur) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (us) with 'values()' method */
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
        this.ug = null;
        this.uh = SwitchState.ON;
        this.ui = false;
        this.uj = false;
        this.uk = false;
        this.uo = null;
        this.mLayout = null;
        this.up = null;
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ug = null;
        this.uh = SwitchState.ON;
        this.ui = false;
        this.uj = false;
        this.uk = false;
        this.uo = null;
        this.mLayout = null;
        this.up = null;
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ei().a(context, R.layout.bd_switch_view, this, true);
        this.mLayout = (FrameLayout) findViewById(R.id.layout);
        this.up = (ImageView) findViewById(R.id.switch_image);
        iG();
        iH();
        this.uo = new a(this);
        setOnClickListener(new b(this));
        iI();
    }

    private void iG() {
        if (this.mLayout != null && this.mLayout.getForeground() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLayout.getLayoutParams();
            layoutParams.width = this.mLayout.getForeground().getIntrinsicWidth();
            this.mLayout.setLayoutParams(layoutParams);
        }
    }

    private void iH() {
        if (this.up != null && this.up.getBackground() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.up.getLayoutParams();
            layoutParams.width = this.up.getBackground().getIntrinsicWidth();
            this.up.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.ui) {
            super.setOnClickListener(onClickListener);
            this.ui = true;
        }
    }

    private void iI() {
        float translateDis = getTranslateDis();
        if (!this.uk) {
            this.ul = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
            this.um = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        } else {
            this.ul = new TranslateAnimation(0.0f, translateDis, 0.0f, 0.0f);
            this.um = new TranslateAnimation(translateDis, 0.0f, 0.0f, 0.0f);
        }
        this.ul.setDuration(200L);
        this.ul.setFillAfter(true);
        this.ul.setAnimationListener(this.uo);
        this.um.setDuration(200L);
        this.um.setFillAfter(true);
        this.um.setAnimationListener(this.uo);
    }

    private float getTranslateDis() {
        return this.mLayout.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    private void b(boolean z, boolean z2) {
        if (!this.uj) {
            if (this.uh == SwitchState.ON) {
                this.uh = SwitchState.OFF;
                if (this.um != null) {
                    if (z) {
                        this.um.setDuration(200L);
                        this.up.startAnimation(this.um);
                    } else if (!O(false)) {
                        this.um.setDuration(200L);
                        this.up.startAnimation(this.um);
                    }
                }
            } else {
                this.uh = SwitchState.ON;
                if (this.ul != null) {
                    if (z) {
                        this.ul.setDuration(200L);
                        this.up.startAnimation(this.ul);
                    } else if (!O(true)) {
                        this.ul.setDuration(200L);
                        this.up.startAnimation(this.ul);
                    }
                }
            }
            if (this.ug != null && z2) {
                this.ug.a(this, this.uh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        b(z, true);
    }

    public void setSwitchFrame(int i) {
        this.mLayout.setForeground(getResources().getDrawable(i));
        iG();
    }

    public void setSwitchImage(int i) {
        this.up.setBackgroundResource(i);
        iH();
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

    public void iJ() {
        if (this.uh != SwitchState.ON) {
            b(false, false);
        }
    }

    public void iK() {
        if (this.uh != SwitchState.OFF) {
            b(false, false);
        }
    }

    public void iL() {
        M(false);
    }

    public void M(boolean z) {
        if (this.uh != SwitchState.ON) {
            L(z);
        }
    }

    public void iM() {
        N(false);
    }

    public void N(boolean z) {
        if (this.uh != SwitchState.OFF) {
            L(z);
        }
    }

    public boolean iN() {
        return this.uh == SwitchState.ON;
    }

    private boolean O(boolean z) {
        boolean z2;
        if (this.uj) {
            return false;
        }
        this.uj = true;
        float translateDis = getTranslateDis();
        if (!z) {
            this.uh = SwitchState.OFF;
            z2 = !this.uk;
            this.uk = true;
            if (ax((int) (-translateDis))) {
                iI();
            } else {
                z2 = false;
            }
        } else {
            this.uh = SwitchState.ON;
            boolean z3 = this.uk;
            this.uk = false;
            if (ax(0)) {
                iI();
                z2 = z3;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.uj = false;
        }
        return z2;
    }

    private boolean ax(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.up.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.up.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.up.getLayoutParams();
        return layoutParams2 == null || layoutParams2.leftMargin == i;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.ug = cVar;
    }
}
