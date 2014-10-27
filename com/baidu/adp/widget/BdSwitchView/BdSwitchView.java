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
    private c rM;
    private SwitchState rN;
    private boolean rO;
    private boolean rP;
    private boolean rQ;
    private TranslateAnimation rR;
    private TranslateAnimation rS;
    private Animation.AnimationListener rT;
    FrameLayout rU;
    ImageView rV;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (rX) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rY) with 'values()' method */
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
        this.rM = null;
        this.rN = SwitchState.ON;
        this.rO = false;
        this.rP = false;
        this.rQ = false;
        this.rT = null;
        this.rU = null;
        this.rV = null;
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rM = null;
        this.rN = SwitchState.ON;
        this.rO = false;
        this.rP = false;
        this.rQ = false;
        this.rT = null;
        this.rU = null;
        this.rV = null;
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ek().a(context, R.layout.bd_switch_view, this, true);
        this.rU = (FrameLayout) findViewById(R.id.layout);
        this.rV = (ImageView) findViewById(R.id.switch_image);
        gI();
        gJ();
        this.rT = new a(this);
        setOnClickListener(new b(this));
        gK();
    }

    private void gI() {
        if (this.rU != null && this.rU.getForeground() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rU.getLayoutParams();
            layoutParams.width = this.rU.getForeground().getIntrinsicWidth();
            this.rU.setLayoutParams(layoutParams);
        }
    }

    private void gJ() {
        if (this.rV != null && this.rV.getBackground() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rV.getLayoutParams();
            layoutParams.width = this.rV.getBackground().getIntrinsicWidth();
            this.rV.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.rO) {
            super.setOnClickListener(onClickListener);
            this.rO = true;
        }
    }

    private void gK() {
        float translateDis = getTranslateDis();
        if (!this.rQ) {
            this.rR = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
            this.rS = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        } else {
            this.rR = new TranslateAnimation(0.0f, translateDis, 0.0f, 0.0f);
            this.rS = new TranslateAnimation(translateDis, 0.0f, 0.0f, 0.0f);
        }
        this.rR.setDuration(200L);
        this.rR.setFillAfter(true);
        this.rR.setAnimationListener(this.rT);
        this.rS.setDuration(200L);
        this.rS.setFillAfter(true);
        this.rS.setAnimationListener(this.rT);
    }

    private float getTranslateDis() {
        return this.rU.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    private void a(boolean z, boolean z2) {
        if (!this.rP) {
            if (this.rN == SwitchState.ON) {
                this.rN = SwitchState.OFF;
                if (this.rS != null) {
                    if (z) {
                        this.rS.setDuration(200L);
                        this.rV.startAnimation(this.rS);
                    } else if (!C(false)) {
                        this.rS.setDuration(200L);
                        this.rV.startAnimation(this.rS);
                    }
                }
            } else {
                this.rN = SwitchState.ON;
                if (this.rR != null) {
                    if (z) {
                        this.rR.setDuration(200L);
                        this.rV.startAnimation(this.rR);
                    } else if (!C(true)) {
                        this.rR.setDuration(200L);
                        this.rV.startAnimation(this.rR);
                    }
                }
            }
            if (this.rM != null && z2) {
                this.rM.a(this, this.rN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z) {
        a(z, true);
    }

    public void setSwitchFrame(int i) {
        this.rU.setForeground(getResources().getDrawable(i));
        gI();
    }

    public void setSwitchImage(int i) {
        this.rV.setBackgroundResource(i);
        gJ();
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

    public void gL() {
        if (this.rN != SwitchState.ON) {
            a(false, false);
        }
    }

    public void gM() {
        if (this.rN != SwitchState.OFF) {
            a(false, false);
        }
    }

    public void gN() {
        A(false);
    }

    public void A(boolean z) {
        if (this.rN != SwitchState.ON) {
            z(z);
        }
    }

    public void gO() {
        B(false);
    }

    public void B(boolean z) {
        if (this.rN != SwitchState.OFF) {
            z(z);
        }
    }

    public boolean gP() {
        return this.rN == SwitchState.ON;
    }

    private boolean C(boolean z) {
        boolean z2;
        if (this.rP) {
            return false;
        }
        this.rP = true;
        float translateDis = getTranslateDis();
        if (!z) {
            this.rN = SwitchState.OFF;
            z2 = !this.rQ;
            this.rQ = true;
            if (ac((int) (-translateDis))) {
                gK();
            } else {
                z2 = false;
            }
        } else {
            this.rN = SwitchState.ON;
            boolean z3 = this.rQ;
            this.rQ = false;
            if (ac(0)) {
                gK();
                z2 = z3;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.rP = false;
        }
        return z2;
    }

    private boolean ac(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rV.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.rV.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.rV.getLayoutParams();
        return layoutParams2 == null || layoutParams2.leftMargin == i;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.rM = cVar;
    }
}
