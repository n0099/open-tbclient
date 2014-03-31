package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.d;
import com.baidu.adp.e;
import com.baidu.adp.lib.util.f;
/* loaded from: classes.dex */
public class BdSwitchView extends FrameLayout {
    FrameLayout a;
    ImageView b;
    private c c;
    private SwitchState d;
    private boolean e;
    private boolean f;
    private boolean g;
    private TranslateAnimation h;
    private TranslateAnimation i;
    private Animation.AnimationListener j;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
        this.c = null;
        this.d = SwitchState.ON;
        this.e = false;
        this.f = false;
        this.g = false;
        this.j = null;
        this.a = null;
        this.b = null;
        a(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = SwitchState.ON;
        this.e = false;
        this.f = false;
        this.g = false;
        this.j = null;
        this.a = null;
        this.b = null;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(e.bd_switch_view, (ViewGroup) this, true);
        this.a = (FrameLayout) findViewById(d.layout);
        this.b = (ImageView) findViewById(d.switch_image);
        d();
        e();
        this.j = new a(this);
        setOnClickListener(new b(this));
        f();
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = this.a.getForeground().getIntrinsicWidth();
        this.a.setLayoutParams(layoutParams);
    }

    private void e() {
        if (this.b != null && this.b.getBackground() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = this.b.getBackground().getIntrinsicWidth();
            this.b.setLayoutParams(layoutParams);
            return;
        }
        f.b("mSwitchImage is null or mSwitchImage.getBackground() is null");
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.e) {
            super.setOnClickListener(onClickListener);
            this.e = true;
        }
    }

    private void f() {
        float translateDis = getTranslateDis();
        if (!this.g) {
            this.h = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
            this.i = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        } else {
            this.h = new TranslateAnimation(0.0f, translateDis, 0.0f, 0.0f);
            this.i = new TranslateAnimation(translateDis, 0.0f, 0.0f, 0.0f);
        }
        this.h.setDuration(200L);
        this.h.setFillAfter(true);
        this.h.setAnimationListener(this.j);
        this.i.setDuration(200L);
        this.i.setFillAfter(true);
        this.i.setAnimationListener(this.j);
    }

    private float getTranslateDis() {
        return this.a.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (!this.f) {
            if (this.d == SwitchState.ON) {
                this.d = SwitchState.OFF;
                if (this.i != null) {
                    if (z) {
                        this.i.setDuration(200L);
                        this.b.startAnimation(this.i);
                    } else if (!d(false)) {
                        this.i.setDuration(200L);
                        this.b.startAnimation(this.i);
                    }
                }
            } else {
                this.d = SwitchState.ON;
                if (this.h != null) {
                    if (z) {
                        this.h.setDuration(200L);
                        this.b.startAnimation(this.h);
                    } else if (!d(true)) {
                        this.h.setDuration(200L);
                        this.b.startAnimation(this.h);
                    }
                }
            }
            if (this.c != null) {
                this.c.a(this, this.d);
            }
        }
    }

    public void setSwitchFrame(int i) {
        this.a.setForeground(getResources().getDrawable(i));
        d();
    }

    public void setSwitchImage(int i) {
        this.b.setBackgroundResource(i);
        e();
    }

    public void setSwitchStyle(SwitchStyle switchStyle) {
        if (switchStyle == SwitchStyle.DAY) {
            setSwitchFrame(com.baidu.adp.c.btn_switch_masking);
            setSwitchImage(com.baidu.adp.c.btn_switch);
        } else if (switchStyle == SwitchStyle.NIGHT) {
            setSwitchFrame(com.baidu.adp.c.btn_switch_masking_1);
            setSwitchImage(com.baidu.adp.c.btn_switch_1);
        } else if (switchStyle == SwitchStyle.SIDE_BAR) {
            setSwitchFrame(com.baidu.adp.c.btn_switch_masking_sidebar);
            setSwitchImage(com.baidu.adp.c.btn_switch_1);
        }
    }

    public final void a() {
        a(false);
    }

    public final void a(boolean z) {
        if (this.d != SwitchState.ON) {
            c(z);
        }
    }

    public final void b() {
        b(false);
    }

    public final void b(boolean z) {
        if (this.d != SwitchState.OFF) {
            c(z);
        }
    }

    public final boolean c() {
        return this.d == SwitchState.ON;
    }

    private boolean d(boolean z) {
        boolean z2;
        if (this.f) {
            return false;
        }
        this.f = true;
        float translateDis = getTranslateDis();
        if (!z) {
            this.d = SwitchState.OFF;
            z2 = !this.g;
            this.g = true;
            if (a((int) (-translateDis))) {
                f();
            } else {
                z2 = false;
            }
        } else {
            this.d = SwitchState.ON;
            boolean z3 = this.g;
            this.g = false;
            if (a(0)) {
                f();
                z2 = z3;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.f = false;
        }
        return z2;
    }

    private boolean a(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.b.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        return layoutParams2 == null || layoutParams2.leftMargin == i;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.c = cVar;
    }
}
