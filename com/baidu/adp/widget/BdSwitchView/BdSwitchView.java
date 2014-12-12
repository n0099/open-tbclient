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
    private c tZ;
    private SwitchState ua;
    private boolean ub;
    private boolean uc;
    private boolean ud;
    private TranslateAnimation ue;
    private TranslateAnimation uf;
    private Animation.AnimationListener ug;
    ImageView uh;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (uj) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (uk) with 'values()' method */
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
        this.tZ = null;
        this.ua = SwitchState.ON;
        this.ub = false;
        this.uc = false;
        this.ud = false;
        this.ug = null;
        this.mLayout = null;
        this.uh = null;
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tZ = null;
        this.ua = SwitchState.ON;
        this.ub = false;
        this.uc = false;
        this.ud = false;
        this.ug = null;
        this.mLayout = null;
        this.uh = null;
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ek().a(context, R.layout.bd_switch_view, this, true);
        this.mLayout = (FrameLayout) findViewById(R.id.layout);
        this.uh = (ImageView) findViewById(R.id.switch_image);
        iF();
        iG();
        this.ug = new a(this);
        setOnClickListener(new b(this));
        iH();
    }

    private void iF() {
        if (this.mLayout != null && this.mLayout.getForeground() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLayout.getLayoutParams();
            layoutParams.width = this.mLayout.getForeground().getIntrinsicWidth();
            this.mLayout.setLayoutParams(layoutParams);
        }
    }

    private void iG() {
        if (this.uh != null && this.uh.getBackground() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.uh.getLayoutParams();
            layoutParams.width = this.uh.getBackground().getIntrinsicWidth();
            this.uh.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.ub) {
            super.setOnClickListener(onClickListener);
            this.ub = true;
        }
    }

    private void iH() {
        float translateDis = getTranslateDis();
        if (!this.ud) {
            this.ue = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
            this.uf = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        } else {
            this.ue = new TranslateAnimation(0.0f, translateDis, 0.0f, 0.0f);
            this.uf = new TranslateAnimation(translateDis, 0.0f, 0.0f, 0.0f);
        }
        this.ue.setDuration(200L);
        this.ue.setFillAfter(true);
        this.ue.setAnimationListener(this.ug);
        this.uf.setDuration(200L);
        this.uf.setFillAfter(true);
        this.uf.setAnimationListener(this.ug);
    }

    private float getTranslateDis() {
        return this.mLayout.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    private void b(boolean z, boolean z2) {
        if (!this.uc) {
            if (this.ua == SwitchState.ON) {
                this.ua = SwitchState.OFF;
                if (this.uf != null) {
                    if (z) {
                        this.uf.setDuration(200L);
                        this.uh.startAnimation(this.uf);
                    } else if (!O(false)) {
                        this.uf.setDuration(200L);
                        this.uh.startAnimation(this.uf);
                    }
                }
            } else {
                this.ua = SwitchState.ON;
                if (this.ue != null) {
                    if (z) {
                        this.ue.setDuration(200L);
                        this.uh.startAnimation(this.ue);
                    } else if (!O(true)) {
                        this.ue.setDuration(200L);
                        this.uh.startAnimation(this.ue);
                    }
                }
            }
            if (this.tZ != null && z2) {
                this.tZ.a(this, this.ua);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        b(z, true);
    }

    public void setSwitchFrame(int i) {
        this.mLayout.setForeground(getResources().getDrawable(i));
        iF();
    }

    public void setSwitchImage(int i) {
        this.uh.setBackgroundResource(i);
        iG();
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

    public void iI() {
        if (this.ua != SwitchState.ON) {
            b(false, false);
        }
    }

    public void iJ() {
        if (this.ua != SwitchState.OFF) {
            b(false, false);
        }
    }

    public void iK() {
        M(false);
    }

    public void M(boolean z) {
        if (this.ua != SwitchState.ON) {
            L(z);
        }
    }

    public void iL() {
        N(false);
    }

    public void N(boolean z) {
        if (this.ua != SwitchState.OFF) {
            L(z);
        }
    }

    public boolean iM() {
        return this.ua == SwitchState.ON;
    }

    private boolean O(boolean z) {
        boolean z2;
        if (this.uc) {
            return false;
        }
        this.uc = true;
        float translateDis = getTranslateDis();
        if (!z) {
            this.ua = SwitchState.OFF;
            z2 = !this.ud;
            this.ud = true;
            if (as((int) (-translateDis))) {
                iH();
            } else {
                z2 = false;
            }
        } else {
            this.ua = SwitchState.ON;
            boolean z3 = this.ud;
            this.ud = false;
            if (as(0)) {
                iH();
                z2 = z3;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.uc = false;
        }
        return z2;
    }

    private boolean as(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.uh.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.uh.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.uh.getLayoutParams();
        return layoutParams2 == null || layoutParams2.leftMargin == i;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.tZ = cVar;
    }
}
