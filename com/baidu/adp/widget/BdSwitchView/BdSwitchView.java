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
import com.baidu.adp.f;
/* loaded from: classes.dex */
public class BdSwitchView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f473a;
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
        this.f473a = null;
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
        this.f473a = null;
        this.b = null;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(f.bd_switch_view, (ViewGroup) this, true);
        this.f473a = (FrameLayout) findViewById(e.layout);
        this.b = (ImageView) findViewById(e.switch_image);
        d();
        e();
        this.j = new a(this);
        setOnClickListener(new b(this));
        f();
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f473a.getLayoutParams();
        layoutParams.width = this.f473a.getForeground().getIntrinsicWidth();
        this.f473a.setLayoutParams(layoutParams);
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = this.b.getBackground().getIntrinsicWidth();
        this.b.setLayoutParams(layoutParams);
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
        return this.f473a.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!this.f) {
            if (this.d == SwitchState.ON) {
                this.d = SwitchState.OFF;
                if (this.i != null) {
                    if (z) {
                        this.i.setDuration(200L);
                        this.b.startAnimation(this.i);
                    } else {
                        b(false);
                    }
                }
            } else {
                this.d = SwitchState.ON;
                if (this.h != null) {
                    if (z) {
                        this.h.setDuration(200L);
                        this.b.startAnimation(this.h);
                    } else {
                        b(true);
                    }
                }
            }
            if (this.c != null) {
                this.c.a(this, this.d);
            }
        }
    }

    public void setSwitchFrame(int i) {
        this.f473a.setForeground(getResources().getDrawable(i));
        d();
    }

    public void setSwitchImage(int i) {
        this.b.setBackgroundResource(i);
        e();
    }

    public void setSwitchStyle(SwitchStyle switchStyle) {
        if (switchStyle == SwitchStyle.DAY) {
            setSwitchFrame(d.btn_switch_masking);
            setSwitchImage(d.btn_switch);
        } else if (switchStyle == SwitchStyle.NIGHT) {
            setSwitchFrame(d.btn_switch_masking_1);
            setSwitchImage(d.btn_switch_1);
        } else if (switchStyle == SwitchStyle.SIDE_BAR) {
            setSwitchFrame(d.btn_switch_masking_sidebar);
            setSwitchImage(d.btn_switch_1);
        }
    }

    public void a() {
        if (this.d != SwitchState.ON) {
            a(false);
        }
    }

    public void b() {
        if (this.d != SwitchState.OFF) {
            a(false);
        }
    }

    public boolean c() {
        return this.d == SwitchState.ON;
    }

    private void b(boolean z) {
        if (!this.f) {
            this.f = true;
            float translateDis = getTranslateDis();
            if (!z) {
                this.d = SwitchState.OFF;
                if (!this.g) {
                    this.g = true;
                    setLeftMargin((int) (-translateDis));
                    f();
                } else {
                    return;
                }
            } else {
                this.d = SwitchState.ON;
                if (this.g) {
                    this.g = false;
                    setLeftMargin(0);
                    f();
                } else {
                    return;
                }
            }
            this.f = false;
        }
    }

    private void setLeftMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.b.setLayoutParams(layoutParams);
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.c = cVar;
    }
}
